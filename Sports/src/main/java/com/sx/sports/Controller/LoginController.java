package com.sx.sports.Controller;

//import com.sx.sports.entity.LoginUser;
import com.sx.sports.entity.Result;
import com.sx.sports.entity.Role;
//import com.sx.sports.exception.BusinessException;
import com.sx.sports.service.RoleService;
//import com.sx.sports.util.CurrentUser;
//import com.sx.sports.util.DigestUtil;
//import com.sx.sports.util.TokenUtils;
//import com.sx.sports.util.WarehouseConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * 用户登录后台
 * @author wk
 * @version 1.0 2022/03/25
 */
@RestController
public class LoginController {

	@Autowired
	private RoleService RoleService;
	// Springboot提供的针对redis操作字符串的便捷工具对象
	private static StringRedisTemplate stringRedisTemplate;

	@Autowired
	public void setStringRedisTemplate(StringRedisTemplate stringRedisTemplate) {
		this.stringRedisTemplate = stringRedisTemplate;
	}

	/**
	 * 验证用户名和密码
	 */
	@PostMapping("/login")
	public Result login(@RequestBody LoginUser loginUser) {
		// @RequestBody 解析post提交的请求体(json)，将json字符串转化为对象
		// 验证码判断
		String serverCode = stringRedisTemplate.opsForValue().get(loginUser.getVerificationKey());
		if(!loginUser.getVerificationCode().equals(serverCode)){
			return Result.err(Result.CODE_ERR_BUSINESS, "验证码不正确！");
		}

		// 通过userCode获取当前用户
		User user = userService.findUserByCode(loginUser.getUserCode());
		if (null != user) {
			// 密码判断
			String password = DigestUtil.hmacSign(loginUser.getUserPwd()); // 用户输入密码
			if (user.getUserState().equals(WarehouseConstants.USER_STATE_PASS)) {
				if (password.equals(user.getUserPwd())) {
					CurrentUser currentUser = new CurrentUser(user.getUserId(), user.getUserCode(), user.getUserName());
					// 登录成功后，使用令牌工具类生成令牌（token），返回客户端
					String token = TokenUtils.loginSign(currentUser, user.getUserPwd());
					System.out.println(token);
					return Result.ok("登录成功！", token);
				} else {
					return Result.err(Result.CODE_ERR_BUSINESS, "密码不正确！");
				}
			} else {
				// 用户未审核
				return Result.err(Result.CODE_ERR_BUSINESS, "用户未审核！");
			}
		}else{
			return Result.err(Result.CODE_ERR_BUSINESS, "该用户不存在！");
		}
	}

	/**
	 * 根据前端发送的token解析当前用户
	 */
	@GetMapping("/curr-user")
	public Result currUser(@RequestHeader(WarehouseConstants.HEADER_TOKEN_NAME) String clientToken) {
		CurrentUser currentUser = TokenUtils.getCurrentUser(clientToken);
		return Result.ok(currentUser);
	}

	// 校验令牌
	@GetMapping("/token/verify")
	public Result verifyToken(@RequestHeader(WarehouseConstants.HEADER_TOKEN_NAME) String clientToken){
		try {
			TokenUtils.verify(clientToken);
			return Result.ok();
		} catch (BusinessException e) {
			return Result.err(Result.CODE_ERR_UNLOGINED, e.getMessage());
		} catch (Exception e){
			return Result.err(Result.CODE_ERR_SYS, "系统错误");
		}
	}

	/**
	 * 用户退出
	 */
	@DeleteMapping("/logout")
	public Result logout(@RequestHeader(WarehouseConstants.HEADER_TOKEN_NAME) String clientToken) {
		// 从redis清除令牌
		TokenUtils.removeToken(clientToken);
		return Result.ok();
	}

}
