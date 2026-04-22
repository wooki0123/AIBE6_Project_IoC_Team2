package com.ll.framework.ioc;

import com.ll.domain.testPost.testPost.repository.TestPostRepository;
import com.ll.domain.testPost.testPost.service.TestFacadePostService;
import com.ll.domain.testPost.testPost.service.TestPostService;

import java.util.HashMap;
import java.util.Map;

public class ApplicationContext {
    private final TestPostRepository testPostRepository;
    private final TestPostService testPostService;
    private final TestFacadePostService testFacadePostService;

    Map<String, Object> beanMap;

    public ApplicationContext() {
        this.testPostRepository = new TestPostRepository();
        this.testPostService = new TestPostService(testPostRepository);
        this.testFacadePostService = new TestFacadePostService(testPostService, testPostRepository);
        this.beanMap = new HashMap<>();

        beanMap.put("testPostRepository", testPostRepository);
        beanMap.put("testPostService", testPostService);
        beanMap.put("testFacadePostService", testFacadePostService);
    }


    public <T> T genBean(String beanName) {
        return (T) beanMap.get(beanName);
    }


}
