package com.wj.springboot.controller.redis;


import redis.clients.jedis.Jedis;

public class MyJedis {
    public   Jedis jedis;
    public  void initJedis(){
         jedis = new Jedis("127.0.0.1", 6379);
        jedis.select(0);
    }

    public void tearDown(){
    if (jedis!=null)
    {
        jedis.close();
    }
    }
}
