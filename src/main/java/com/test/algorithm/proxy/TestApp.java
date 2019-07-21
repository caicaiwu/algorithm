package com.test.algorithm.proxy;

public class TestApp {

    public static void testStaticProxy() {
        // 静态代理测试
        IUserDao target = new UserDao();
        //代理对象
        IUserDao proxy = new UserDaoStaticProxy(target);
        proxy.save();
    }

    public static void testDynamicProxy (){
        // 动态代理测试
        IUserDao target = new UserDao();
        System.out.println(target.getClass());  //输出目标对象信息
        IUserDao proxy = (IUserDao) new UserDaoDynamicProxy(target).getProxyInstance();
        System.out.println(proxy.getClass());  //输出代理对象信息
        proxy.save();  //执行代理方法
    }

    public static void testCglibProxy(){
        // Cglib代理测试
        //目标对象
        UserDao target = new UserDao();
        System.out.println(target.getClass());
        //代理对象
        UserDao proxy = (UserDao) new UserDaoCglibProxy(target).getProxyInstance();
        System.out.println(proxy.getClass());
        //执行代理对象方法
        proxy.save();
    }

    public static void main( String[] args )
    {
        testStaticProxy();
        testDynamicProxy();
        testCglibProxy();
    }
}
