package top.zhengru;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement //开启注解方式的事务管理
@EnableCaching
@EnableScheduling
@Slf4j
public class XgApplication {
    public static void main(String[] args) {
        SpringApplication.run(XgApplication.class, args);
        log.info("server started");
    }
}
