package com.datumsolutions.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.datumsolutions.model.Student;

@Configuration
@EnableRedisRepositories
public class AppConfig {

	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
	
		 JedisConnectionFactory jedisConFactory = new JedisConnectionFactory();
		 jedisConFactory.setHostName("localhost"); 
		 jedisConFactory.setPort(6379);
		 
	    return new JedisConnectionFactory();
	}

	@Bean
	@Primary
	public RedisTemplate<String, Object> redisTemplate() {
	    RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
	    redisTemplate.setConnectionFactory(jedisConnectionFactory());
	    redisTemplate.setKeySerializer(new StringRedisSerializer());
	    redisTemplate.setHashKeySerializer(new StringRedisSerializer());
	    redisTemplate.setHashKeySerializer(new JdkSerializationRedisSerializer());
	    redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
	    redisTemplate.setEnableTransactionSupport(true);
	    redisTemplate.afterPropertiesSet();
	    return redisTemplate;
	}
}
