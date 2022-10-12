package org.apache.dubbo.springboot.demo.consumer;

import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.springboot.demo.AnotherService;
import org.apache.dubbo.springboot.demo.common.ICustomContextHolder;
import org.springframework.stereotype.Service;

@Service
public class CustomContextHolder implements ICustomContextHolder {

    @DubboReference
    private AnotherService anotherService;

    @Override
    public String getContext() {
        return anotherService.xyz();
    }
}
