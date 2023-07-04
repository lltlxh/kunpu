package com.sx.sports;
import com.sx.sports.Controller.HelloController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.sx.sports.entity.Role;
import com.sx.sports.mapper.RoleMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;


/**class SportsApplicationTests {


	void contextLoads() {
	}

}**/

@SpringBootTest
class SportsApplicationTests {
	@Autowired
	private HelloController helloController;
	@Autowired
	private RoleMapper roleMapper;

	@Test
	public void testFindRoleByCode(){
		Role role = roleMapper.findRoleByCode("丁宇宁");
		System.out.println(role);
	}
	/**@Test
	public void testInsertRole(){
		Role role = new Role();
		role.setUserName("学生");
		role.setPwd("student");
		role.setSex("女");
		role.setGrade(42);
		int updateRows = roleMapper.insertRole(role);
		System.out.println("添加了" + updateRows + "行数据！");
	}**/
	/**@Test
	public void testUpdateRole(){
		Role role = new Role();
		role.setRoleId(17);
		role.setRoleName("学生2");
		role.setRoleDesc("学生2");
		role.setUpdateBy(3);
		int updateRows = roleMapper.updateRole(role);
		System.out.println("修改了" + updateRows + "行数据！");
	}
	@Test
	public void testDeleteRole(){
		int updateRows = roleMapper.deleteRole(17);
		System.out.println("删除了" + updateRows + "行数据！");
	}**/

}

