package com.ll.framework.ioc;

import com.ll.domain.testPost.testPost.service.TestPostService;

public class ApplicationContext {
    private TestPostService testPostService;

    public ApplicationContext() {
        testPostService = new TestPostService();
    }

    public <T> T genBean(String beanName) {
        if(beanName.equals("testPostService")){
            return (T)testPostService;
        }
        return (T) null;
    }
}
