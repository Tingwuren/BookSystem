package cn.edu.bupt.booksystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cn.edu.bupt.booksystem.service.SmsService;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/sms")
public class SmsController {

    @Autowired
    private SmsService smsService;

    @PostMapping("/send")
    public String sendSmsCode(HttpSession session) {
        String sessionId = session.getId();
        System.out.println("发送的 sessionId: " + sessionId);
        return smsService.sendSmsCode(sessionId);
    }

    @PostMapping("/verify")
    public boolean verifySmsCode(HttpSession session, String code) {
        String sessionId = session.getId();
        System.out.println("验证的 sessionId: " + sessionId);
        return smsService.verifySmsCode(sessionId, code);
    }
}
