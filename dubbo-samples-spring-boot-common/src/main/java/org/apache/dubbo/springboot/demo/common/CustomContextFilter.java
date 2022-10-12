package org.apache.dubbo.springboot.demo.common;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.Filter;
import org.apache.dubbo.rpc.Invocation;
import org.apache.dubbo.rpc.Invoker;
import org.apache.dubbo.rpc.Result;
import org.apache.dubbo.rpc.RpcException;

@Activate(group = CommonConstants.CONSUMER)
@Slf4j
public class CustomContextFilter implements Filter {

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        doSomething(invocation);
        return invoker.invoke(invocation);
    }

    protected void doSomething(Invocation invocation) {
        if ("org.apache.dubbo.springboot.demo.AnotherService".equalsIgnoreCase(invocation.getServiceName())
            && "xyz".equalsIgnoreCase(invocation.getMethodName())) {
            return;
        }
        if ("org.apache.dubbo.metadata.MetadataService".equalsIgnoreCase(invocation.getServiceName())
            && "getMetadataInfo".equalsIgnoreCase(invocation.getMethodName())) {
            return;
        }
        ICustomContextHolder customContextHolder = SpringUtil.getBean("customContextHolder", ICustomContextHolder.class);
        if (customContextHolder != null) {
            String context = customContextHolder.getContext();
            log.info("custom context={}", context);
        }
    }
}