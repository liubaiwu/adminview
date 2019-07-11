package me.look.controller.admin;

import jdk.internal.org.objectweb.asm.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

public class BaseController {



    @Autowired
    protected HttpServletRequest request;


    public static final String Model = "Model";


    /**
     * 后台模板目录
     */
    private static String AdminPath="admin";



    /**获取请求参数*/
    protected  String GetParam(String key)
    {
        if(key.isEmpty())
        {
            try {
                throw new Exception("参数不能为空");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String result=request.getParameter(key);

        return result;
    }




    /**
     * 视图路径
     * @param viewName 视图模板路径
     * @return
     */
    protected ModelAndView View(String viewName)
    {
        ModelAndView view = new ModelAndView(AdminPath+"/"+viewName);
        return view;
    }

    /**
     * 带数据的视图
     * @param viewName 视图模板路径
     * @param data 数据
     * @return
     */
    protected ModelAndView View(String viewName, Object data)
    {
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject(Model,data);
        modelAndView.setViewName(AdminPath+"/"+viewName);
        return modelAndView;
    }


    /**成功*/
    protected <T> Result Seccuss()
    {
        Result<T> result=new Result<T>(ErrorCode.SUCCESS.getCode(),ErrorCode.SUCCESS.getMsg(),null);
        return  result;
    }
    /**成功*/
    protected <T> Result Seccuss(T data)
    {
        Result<T> result=new Result<T>(ErrorCode.SUCCESS.getCode(),ErrorCode.SUCCESS.getMsg(),data);
        return  result;
    }
    /**
     * 成功
     * @param msg 自定义消息
     * @param <T>
     * @return
     */
    protected <T> Result Seccuss(String msg)
    {
        Result<T> result=new Result<T>(ErrorCode.SUCCESS.getCode(),msg,null);
        return  result;
    }
    /**
     * 成功
     * @param msg 自定义消息
     * @param data 自定义数据
     * @param <T>
     * @return
     */
    protected <T> Result Seccuss(String msg,T data)
    {
        Result<T> result=new Result<T>(ErrorCode.SUCCESS.getCode(),msg,data);
        return  result;
    }

    /**失败*/
    protected <T> Result Fail()
    {
        Result<T> result=new Result<T>(ErrorCode.FAIL.getCode(),ErrorCode.FAIL.getMsg(),null);
        return  result;
    }
    /**失败*/
    protected <T> Result Fail(T data)
    {
        Result<T> result=new Result<T>(ErrorCode.FAIL.getCode(),ErrorCode.FAIL.getMsg(),data);
        return  result;
    }
    /**
     * 失败
     * @param msg 自定义消息
     * @param <T>
     * @return
     */
    protected <T> Result Fail(String msg)
    {
        Result<T> result=new Result<T>(ErrorCode.FAIL.getCode(),msg,null);
        return  result;
    }
    /**
     * 失败
     * @param msg 自定义消息
     * @param data 自定义数据
     * @param <T>
     * @return
     */
    protected <T> Result Fail(String msg,T data)
    {
        Result<T> result=new Result<T>(ErrorCode.FAIL.getCode(),msg,data);
        return  result;
    }
    /**错误*/
    protected <T> Result Error()
    {
        Result<T> result=new Result<T>(ErrorCode.ERROR.getCode(),ErrorCode.ERROR.getMsg(),null);
        return  result;
    }
    /**错误*/
    protected <T> Result Error(T data)
    {
        Result<T> result=new Result<T>(ErrorCode.ERROR.getCode(),ErrorCode.ERROR.getMsg(),data);
        return  result;
    }
    /**
     * 错误
     * @param msg 自定义消息
     * @param <T>
     * @return
     */
    protected <T> Result Error(String msg)
    {
        Result<T> result=new Result<T>(ErrorCode.ERROR.getCode(),msg,null);
        return  result;
    }
    /**
     * 错误
     * @param msg 自定义消息
     * @param data 自定义数据
     * @param <T>
     * @return
     */
    protected <T> Result Error(String msg,T data)
    {
        Result<T> result=new Result<T>(ErrorCode.ERROR.getCode(),msg,data);
        return  result;
    }

    /**
     * 数据表格统一返回数据集合
     * @param count
     * @param data
     * @param <T>
     * @return
     */
    protected <T> ResultTable SeccussTable(int count,T data)
    {
        ResultTable<T> resultTable=new ResultTable<T>();
        resultTable.setCode("0");
        resultTable.setMsg("成功");
        resultTable.setCount(count);
        resultTable.setData(data);
        return  resultTable;
    }

}
