package cn.edu.bupt.booksystem.service;



public interface SmsService {
    String sendSmsCode(String sessionId);

    boolean verifySmsCode(String sessionId, String code);
}
