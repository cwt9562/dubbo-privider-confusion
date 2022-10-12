package org.apache.dubbo.springboot.demo.common;

import java.util.List;

public interface BaseService<B> {

    String create(B bean);

    void delete(String id);

    void update(B bean);

    B get(String id);

    List<B> list(List<String> ids);
}
