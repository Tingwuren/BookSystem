package cn.edu.bupt.booksystem.service.impl;

import cn.edu.bupt.booksystem.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class SmsServiceImpl implements SmsService{

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public String sendSmsCode(String sessionId) {
        String code = generateCode();
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        ops.set("sms:code:" + sessionId, code, 3, TimeUnit.MINUTES); // 设置3分钟有效期
        System.out.println("发送的验证码: " + code); // 模拟发送短信
        return code;
    }

    @Override
    public boolean verifySmsCode(String sessionId, String code) {
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        String storedCode = ops.get("sms:code:" + sessionId);
        return code.equals(storedCode);
    }

    private String generateCode() {
        return String.valueOf((int)((Math.random() * 9 + 1) * 100000)); // 生成6位数字验证码
    }
}
