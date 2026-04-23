package com.ll.framework.ioc;

import com.ll.domain.testPost.testPost.repository.TestPostRepository;
import com.ll.domain.testPost.testPost.service.TestPostService;

public class ApplicationContext {
    private TestPostService testPostService;
    public ApplicationContext() {
    }

    public <T> T genBean(String beanName) {
        if (beanName.equals("testPostService")) {
            if(testPostService==null){
                TestPostRepository testPostRepository = new TestPostRepository();
                testPostService=new TestPostService(testPostRepository);
            }
            return (T) testPostService;
        }

        return null;
    }
}