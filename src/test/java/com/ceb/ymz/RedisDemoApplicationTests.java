package com.ceb.ymz;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.sound.midi.Soundbank;
import java.util.Map;

@SpringBootTest
class RedisDemoApplicationTests {

    @Autowired
    StringRedisTemplate template;

    @Test
    void contextLoads() {
        String phone="13176544567";
        String psw="111";
        template.<String, Object>opsForHash().put("user",phone,psw);
    }

    @Test
    public void hashGetAll() {
        String key="user";
        HashOperations<String, String, String> ops = template.opsForHash();
        Map<String, String> entries = ops.entries(key);
        System.out.println(entries);
    }

}
