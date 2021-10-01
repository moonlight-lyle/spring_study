package com.it.dao;

import com.it.pojo.Account;

import java.util.List;

/**
 * ToDo
 *
 * @author Lyle
 * @date 2021/9/19
 */
public interface AccountDao {

    /**
     * 在所save()方法调用之前进行权限的校验checkPrivilege()
     *
     * 连接点: 所有的方法都可以是连接点
     * 切入点: 需要增强的方法就是切入点  eg:当前例子里面save()是切入点
     * 通知(增强): 增强的逻辑 eg: 当前例子里面checkPrivilege()
     *      前置通知: 在目标(需要增强的)方法调用之前执行
     *      后置通知: 在目标(需要增强的)方法调用之后执行
     *      环绕通知  在目标(需要增强的)方法调用之前执行, 调用之后执行
     * 切面: 把通知和切入点进行结合, 把通知的逻辑用在切入点上面
     */
    void save(Account account);

    /**
     * 后置通知例子：在所有delete方法调用之后进行日志打印
     */
    void delete(int id);

    List<Account> findAll();

    void update(Account account);

    Account findById(int id);
}
