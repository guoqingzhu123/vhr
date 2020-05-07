package com.example.vhr.controller;

import com.google.code.kaptcha.Producer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @Auther:zhugq
 * @Date: 2020/05/05/9:06
 */
@RestController
@Api(value = "验证码")
public class VerifyCodeController {
    @Autowired
    Producer defaultKaptcha;

    @GetMapping("/verifyCode")
    @ApiOperation(value = "生成验证码")
    public void verify(HttpServletRequest request, HttpServletResponse response)
        throws IOException {
        response.setDateHeader("Expires",0);
        response.setHeader("Cache-Control","no-store,no-cache,must-revalidate");
        response.setHeader("Cache-Control","post-check=0,pre-check=0");
        response.setHeader("Pragma","no-cache");
        response.setContentType("image/jpeg");


        String code = defaultKaptcha.createText();
        request.getSession().setAttribute("verify_code",code);

        ServletOutputStream out = response.getOutputStream();
        BufferedImage image = defaultKaptcha.createImage(code);
        ImageIO.write(image,"JPEG",out);
        out.flush();
        out.close();
    }
}
