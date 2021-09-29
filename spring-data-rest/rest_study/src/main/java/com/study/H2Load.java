package com.study;

import com.study.entity.Test;
import com.study.entity.User;
import com.study.repository.TestRepository;
import com.study.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class H2Load {
    @Bean
    public CommandLineRunner dataLoader(UserRepository userRepository, TestRepository testRepository){
        return  new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                User user1 = new User(1, "zhangsan1", "8690#@!Zxc", 1, true);
                User user2 = new User(2, "zhangsan2", "8690#@!Zxc", 2, true);
                User user3 = new User(3, "zhangsan3", "8690#@!Zxc", 3, true);
                User user4 = new User(4, "zhangsan4", "8690#@!Zxc", 4, true);
                User user5 = new User(5, "zhangsan5", "8690#@!Zxc", 5, true);
                Test test1 = new Test(1,"hah", "test1");
                Test test = new Test(2, "testdsa", "dsadsaf");
                Test test2 = new Test(3, "dsad", "fdg");
                userRepository.save(user1);
                userRepository.save(user2);
                userRepository.save(user3);
                userRepository.save(user4);
                userRepository.save(user5);
                testRepository.save(test);
                testRepository.save(test1);
                testRepository.save(test2);
            }
        };
    }

}
