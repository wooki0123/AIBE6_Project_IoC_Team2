package com.ll.framework.ioc;

import com.ll.domain.testPost.testPost.service.TestPostService;

public class ApplicationContext {
    private final TestPostService testPostService;

    public ApplicationContext() {
        testPostService = new TestPostService();
    }

    public <T> T genBean(String beanName) {
        return (T) testPostService;
    }
}
