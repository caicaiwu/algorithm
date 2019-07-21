package com.test.algorithm.proxy;

/*
* 静态代理,将要代理得实例显示得放入代理中
 */
public class UserDaoStaticProxy implements IUserDao {
    private IUserDao target;

    public UserDaoStaticProxy(IUserDao target) {
        this.target = target;
    }

    @Override
    public void save() {
        System.out.println("开启事务");//扩展了额外功能
        target.save();
        System.out.println("提交事务");

    }
}
