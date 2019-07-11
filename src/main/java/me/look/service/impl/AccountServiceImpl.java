package me.look.service.impl;

import me.look.entity.Account;
import me.look.entity.AccountExample;
import me.look.entity.common.Pager;
import me.look.mapping.AccountMapper;
import me.look.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public Account getAccountById(int id) {
        return accountMapper.selectByPrimaryKey(id);
    }

    @Override
    public int countByExample(AccountExample example) {
        return accountMapper.countByExample(example);
    }

    @Override
    public int getCount(Account account) {
        return accountMapper.count(account);
    }

    public List<Account> select(Account account,Pager pager)
    {
        return accountMapper.select(account,pager);
    }

    @Override
    public int insert(Account record) {
        return accountMapper.insert(record);
    }


    /**
     * 根据用户名查找数量
     * @param userName
     * @return
     */
    public int countByUserName(String userName)
    {
        return accountMapper.countByUserName(userName);
    }

    /**
     * 根据邮箱查找数量
     * @param email
     * @return
     */
    public int countByEmail(String email)
    {
        return accountMapper.countByEmail(email);
    }

}
