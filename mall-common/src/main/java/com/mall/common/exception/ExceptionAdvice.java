package com.mall.common.exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mall.common.domain.Result;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author HC
 * @Date 2020/7/17 16:59
 * @Version 1.0
 */
@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(DuplicateKeyException.class)
    public Object handleDuplicateKeyException(DuplicateKeyException e, HttpServletRequest request,
                                              HttpServletResponse response) {
        return Result.fail("数据库中已存在该记录");
    }

    private static String getExceptionToString(Throwable e) {
        if (e == null){
            return "";
        }
        StringWriter stringWriter = new StringWriter();
        e.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    @ExceptionHandler(Exception.class)
    public Object handleException(Exception e, HttpServletRequest request, HttpServletResponse response) {
        //开发阶段直接把异常抛到前台去，方便调试
        return Result.fail("系统异常，请联系管理员！");
    }

    /**
     * spring validator实体对象参数校验结果处理
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(BindException.class)
    public Object handleBindExceptionException(BindException ex, HttpServletRequest request,
                                               HttpServletResponse response) {
        return Result.fail("表单参数校验不通过！");
        // 判断提交表单的请求是否为Ajax请求,若是则生成refresh_token,以替换表单页面的formToken,解决Ajax提交后,验证不通过无法再次提交的问题
    }

    /**
     * spring validator方法参数校验结果处理
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Object handleMethodArgumentException(MethodArgumentNotValidException ex, HttpServletRequest request,
                                                HttpServletResponse response) {
        // 判断提交表单的请求是否为Ajax请求,若是则生成refresh_token,以替换表单页面的formToken,解决Ajax提交后,验证不通过无法再次提交的问题
        return Result.fail("表单参数校验不通过！");
    }

    /**
     * 数据库外键约束错误
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(DataIntegrityViolationException.class)
    public Object handleDataIntegrityViolationException(DataIntegrityViolationException ex, HttpServletRequest request,
                                                        HttpServletResponse response) {
        return Result.fail("外键约束，操作失败！");
    }
}

