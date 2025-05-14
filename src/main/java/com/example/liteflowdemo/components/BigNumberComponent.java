package com.example.liteflowdemo.components;

import com.example.liteflowdemo.context.NumberCheckContext;
import com.yomahub.liteflow.core.NodeComponent;
import org.springframework.stereotype.Component;

@Component("bigNumberCmp")
public class BigNumberComponent extends NodeComponent {
    @Override
    public void process() throws Exception {
        NumberCheckContext context = this.getContextBean(NumberCheckContext.class);
        context.addExecutionStep("Processing big number special case");
        // Additional logic for small numbers
    }
}