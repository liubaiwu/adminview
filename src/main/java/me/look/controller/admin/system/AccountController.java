package me.look.controller.admin.system;

import me.look.common.enums.AccountLockStatus;
import me.look.common.enums.IsDelete;
import me.look.common.utils.DateUtils;
import me.look.controller.admin.BaseController;
import me.look.controller.admin.ErrorCode;
import me.look.controller.admin.Result;
import me.look.controller.admin.ResultTable;
import me.look.entity.Account;
import me.look.entity.AccountExample;
import me.look.entity.common.Pager;
import me.look.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@RequestMapping("/admin/account")
@Controller
public class AccountController extends BaseController {

    //模板目录
    String viewDic="system/account/";



    @Autowired
    protected AccountService accountService;

    /**账号管理列表页面*/

    @GetMapping("index") // <==>  @RequestMapping("index")
    public ModelAndView Index()
    {
        return View(viewDic+"index");
    }

    /**
     * 列表数据
     * @return
     */
    @ResponseBody
    @GetMapping("DataSource") // <==>  @RequestMapping("DataSource")
    public ResultTable DataSource()
    {
        int page=Integer.parseInt(GetParam("page"));
        int limit=Integer.parseInt(GetParam("limit"));

        Account account=new Account();
        account.setName("lisss");
        Pager pager=new Pager();
        pager.setPageIndex(page);
        pager.setPageSize(limit);
        List<Account> list=accountService.select(account,pager);
        int count=accountService.getCount(account);
        return SeccussTable(count,list);
    }



    /**账号添加界面*/
    @GetMapping("add") // <==>  @RequestMapping("add")
    public ModelAndView Add()
    {
        return View(viewDic+"add");
    }


    @ResponseBody
    @GetMapping("DoAdd") // <==>  @RequestMapping("DoAdd")
    /**添加账号*/
    public Result DoAdd(Account account)
    {
       String name=  GetParam("uid");

       try{
           Date date=new Date();
            //验证账号是否存在
           int c= accountService.getCount(account);
           if(c>0)
           {
               return Fail("用户名已经存在,请重新输入!");
           }
           AccountExample accountExample=new AccountExample();
           AccountExample.Criteria criteria= accountExample.createCriteria();
           criteria.andEmailEqualTo(account.getEmail());
           c= accountService.countByExample(accountExample);
           if(c>0)
           {
               return Fail("邮箱已经存在,请重新输入!");
           }
           account.setCreatetime(date);
           account.setLogintime(date);
           account.setLockstatus((byte) AccountLockStatus.normal.getKey());
           account.setIsdelete((byte)IsDelete.no.getKey());



           accountService.insert(account);
           return Seccuss();
       }catch (Exception ex){
            return Fail();
       }

    }
    @GetMapping("edit") // <==>  @RequestMapping("edit")
    public ModelAndView Edit(int id)
    {

        Account account=accountService.getAccountById(id);
        Object o=account;

        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("model",o);
        modelAndView.setViewName("admin/"+viewDic+"edit");
        //return modelAndView;
        return View(viewDic+"edit",account);
    }
    @GetMapping("DoEdit")
    public Result DoEdit(Account account)
    {
        return Seccuss("成功");
    }
}
