package com.eyesfree.weibo.base;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
// @ControllerAdvice
@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 应用到所有@RequestMapping注解方法，在其执行之前初始化数据绑定器
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        System.out.println("initBinder");
    }

    /**
     * 把值绑定到Model中，使全局@RequestMapping可以获取到该值
     * @param model
     */
    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("author", "Magical Sam");
    }

    /**
     * 全局异常捕捉处理
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public R errorHandler(Exception e) {
        if(e instanceof RException){
            log.error(e.getMessage(), e);
            RException rException=(RException) e;
            return R.error(rException.getCode(),rException.getMsg());
        }else {
            log.error(e.getMessage(), e);
            return R.error();
        }
    }
}
