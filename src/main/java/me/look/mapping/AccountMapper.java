package me.look.mapping;

import me.look.entity.Account;
import me.look.entity.AccountExample;
import me.look.entity.common.Pager;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccountMapper {
    int countByExample(AccountExample example);

    int deleteByExample(AccountExample example);

    int deleteByPrimaryKey(int id);

    int insert(Account record);

    int insertSelective(Account record);

    List<Account> selectByExample(AccountExample example);

    Account selectByPrimaryKey(int id);

    int updateByExampleSelective(@Param("record") Account record, @Param("example") AccountExample example);

    int updateByExample(@Param("record") Account record, @Param("example") AccountExample example);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);

    List<Account> select(@Param("Acount") Account account,@Param("Pager")Pager pager);

    /**
     * 获取数量
     * @param account
     * @return
     */
    int count(Account account);

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