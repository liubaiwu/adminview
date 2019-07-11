package me.look.controller.admin;


import me.look.entity.Account;
import me.look.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping(value = "/admin")
@Controller
public class AdminController extends BaseController {

    @Autowired
    private AccountService accountService;

    /**
     * 后台首页
     * @return
     */
    @RequestMapping("/index")
    public ModelAndView Index()
    {

       Account account= accountService.getAccountById(2);
       

        return View("index");
    }

    /**
     * 登录页面
     * @return
     */
    @RequestMapping("/login")
    public ModelAndView Login()
    {
        return View("login");
    }

    /**
     * home主目录
     * @return
     */
    @RequestMapping("/home")
    public ModelAndView home()
    {
        return View("home");
    }
}
