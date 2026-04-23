package com.ll.framework.ioc;

import com.ll.domain.testPost.testPost.repository.TestPostRepository;
import com.ll.domain.testPost.testPost.service.TestFacadePostService;
import com.ll.domain.testPost.testPost.service.TestPostService;

public class ApplicationContext {
    private TestPostRepository testPostRepository;
    private TestPostService testPostService;
    private TestFacadePostService testFacadePostService;

    public ApplicationContext() {
    }

    public <T> T genBean(String beanName) {
        if (beanName.equals("testPostRepository")) {
            if(testPostRepository==null){
                testPostRepository=new TestPostRepository();
            }
            return (T) testPostRepository;
        }

        if (beanName.equals("testPostService")) {
            if(testPostService==null){
                testPostService=new TestPostService(genBean("testPostRepository"));
            }
            return (T) testPostService;
        }

        if (beanName.equals("testFacadePostService")) {
            if(testFacadePostService==null){
                testFacadePostService=new TestFacadePostService(genBean("testPostService"),genBean("testPostRepository"));
            }
            return (T) testFacadePostService;
        }

        return null;
    }
}