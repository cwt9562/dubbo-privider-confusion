package org.apache.dubbo.springboot.demo.provider;

import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.springboot.demo.AnotherService;

@DubboService
public class AnotherServiceImpl implements AnotherService {
    @Override
    public String xyz() {
        return "zhangsan";
    }
}
