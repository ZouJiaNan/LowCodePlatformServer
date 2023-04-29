package com.gyxs.service.impl;

import com.gyxs.service.FlowService;
import com.gyxs.utils.WorkFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlowServiceaImpl implements FlowService {

    @Autowired
    WorkFlow workFlow;

    @Override
    public void start(String data) {
        //init:初始化
        //input:输入,只用于测试，实际值应该是前端传过来
        //start:启动
        workFlow.init(data).start();
    }

    @Override
    public void startDemo() {

    }
}
