package com.example.Chatbot.schedule;

import com.example.Chatbot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class Scheduler {

    @Autowired
    UserService userService;

    @Scheduled(cron = "0 * * ? * *")
    public void scheduleTaskUsingCronExpression() {
        String msg = "Bây giờ là " + java.time.LocalDate.now() + " " + java.time.LocalTime.now() + ". Hề lô cvuk, mỗi phút gọi 1 lần nhé :D";
        userService.sendMessage(msg, null);
    }
}
