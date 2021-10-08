package com.it.service;

public interface UserService {

    /**
     * 转账
     * @param fukuan 付款人
     * @param shoukuan 收款人
     * @param money 转账金额
     */
    void transfer(String fukuan,String shoukuan,Double money);
}
