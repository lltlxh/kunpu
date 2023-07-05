/**
 * 路由定义
 * 作者：王坤 2022-03
 */


const routes = [

    // 访问路由"/", 自动重定向到"/home"
    //修改redirect值，修改默认路由
    {
        path: '/',
        redirect: '/home'
    },   
    {
        path: '/home',
        name: 'Home',
        component: () => import('@/views/home/home.vue'),
        //children放子界面内容,path,name,component
        children:[
        ]       
    },
    {
        path: '/login',
        name: "Login",
        component: () => import('@/views/home/login.vue')
    },
    {
        path: '/404',
        name: "NotFound",
        component: () => import('@/views/404.vue')
    },
    {
      path: '/game',
      name: "Game",
      component: () => import('@/views/game/home.vue'),
      children:[
      ]
    },
    {
      path: '/rolecenter',
      name: "RoleCenter",
      component: () => import('@/views/rolecenter/home.vue'),
      children:[
      ]
    },
    {
      path: '/community',
      name: "Community",
      component: () => import('@/views/community/home.vue'),
      children:[
      ]
    },

];

// 判断路由是否存在
const existsRoute_inner = (path, theRoutes)=>{
    for (let i = 0; i < theRoutes.length; i++) {
        const r = theRoutes[i];
        if (r.path == path) {
            return true;
        }
        if (r.children && r.children.length) {
            const existsInChildren = existsRoute_inner(path,r.children);
            if(existsInChildren) return true; 
        }
    }
    return false;
};

export const existsRoute = (path) => {

    return existsRoute_inner(path,routes);

};

export default routes;