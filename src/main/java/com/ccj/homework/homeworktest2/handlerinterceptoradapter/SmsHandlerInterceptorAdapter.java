package com.ccj.homework.homeworktest2.handlerinterceptoradapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ccj.homework.homeworktest2.dao.data.SmsCodeAndPhoNumData;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SmsHandlerInterceptorAdapter extends HandlerInterceptorAdapter {

    /**
     * 短信验证码拦截器
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {

        // 从请求中提取phoNum和smsCode参数
        String phoNum = request.getParameter("phoNum");
        String smsCode = request.getParameter("smsCode");

        // 校验参数
        if (SmsCodeAndPhoNumData.getSmsCodeByPhoNum(phoNum).equals(smsCode)) {
            return true;
        } else {

            // 校验失败
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            // throw new Exception("用户名或密码错误");
            return false;
        }

    }
}
