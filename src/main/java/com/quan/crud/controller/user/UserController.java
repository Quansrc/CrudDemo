package com.quan.crud.controller.user;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.captcha.generator.RandomGenerator;
import com.quan.crud.entity.User;
import com.quan.crud.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping("getLogin")
    public String getLogin(){
        return "/user/login";
    }

    @RequestMapping("/getvcode")
    @ResponseBody
    public Object getVcode(HttpServletRequest request){
        //获取session
        HttpSession session = request.getSession();
        // 自定义纯数字的验证码（随机4位数字，可重复）
        RandomGenerator randomGenerator = new RandomGenerator("0123456789", 4);
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(200, 100);
        lineCaptcha.setGenerator(randomGenerator);
        // 重新生成code
        lineCaptcha.createCode();
//        System.out.println("vcode为"+lineCaptcha.getCode());
        logger.info("vcode为"+lineCaptcha.getCode());
        session.setAttribute("vcode",lineCaptcha.getCode());
        return lineCaptcha.getImageBytes();
    }

    /**
     * 登陆
     */
    @RequestMapping("/login")
    public ModelAndView Login(@ModelAttribute User user,HttpSession session){
        try{
            ModelAndView mv = new ModelAndView("index");
            String msg = userService.getUserByName(user,session);
            if(msg=="登陆成功!"){
                return mv;
            }
            return null;
        }catch (Exception e){
            logger.error("系统错误！");
            return null;
        }

    }

}
