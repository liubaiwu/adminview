package me.look.service;

import me.look.entity.Account;
import me.look.entity.AccountExample;
import me.look.entity.common.Pager;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccountService {

    Account getAccountById(int id);

    int countByExample(AccountExample example);

    int getCount(Account account);

    List<Account> select(Account account,Pager pager);

    int insert(Account record);

    /**
     * 根据用户名查找数量
     * @param userName
     * @return
     */
    int countByUserName(String userName);

    /**
     * 根据邮箱查找数量
     * @param email
     * @return
     */
    int countByEmail(String email);



}
