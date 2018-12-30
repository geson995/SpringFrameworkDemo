package com.springmvc.service.impl;

import com.springmvc.service.EhcacheTestService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class EhcacheTestServiceImpl implements EhcacheTestService {
    @Override
    @Cacheable(value = "cacheTest", key = "#param")
    public String getTimestamp(String param) {
        Long timestamp = System.currentTimeMillis();
        return timestamp.toString();
    }
}
