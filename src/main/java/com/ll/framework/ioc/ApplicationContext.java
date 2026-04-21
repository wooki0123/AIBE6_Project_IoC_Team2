package com.ll.framework.ioc;

import com.ll.domain.testPost.testPost.repository.TestPostRepository;
import com.ll.domain.testPost.testPost.service.TestPostService;

public class ApplicationContext {
    private TestPostService testPostService;
    private TestPostRepository testPostRepository;

    public ApplicationContext() {
        testPostService = new TestPostService();
        testPostRepository = new TestPostRepository();
    }

    public <T> T genBean(String beanName) {
        if(beanName.equals("testPostService")){
            return (T)testPostService;
        }if(beanName.equals("testPostRepository")){
            return (T)testPostRepository;
        }
        return (T) null;
    }
}
