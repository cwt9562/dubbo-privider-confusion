package org.apache.dubbo.springboot.demo.common;

import java.util.List;

public class BaseServiceImpl<B> implements BaseService<B> {
    @Override
    public String create(B bean) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void update(B bean) {

    }

    @Override
    public B get(String id) {
        return null;
    }

    @Override
    public List<B> list(List<String> ids) {
        return null;
    }
}
