package com.example.liteflowdemo.components;

import com.example.liteflowdemo.context.NumberCheckContext;
import com.yomahub.liteflow.core.NodeComponent;
import org.springframework.stereotype.Component;

@Component("smallNumberCmp")
public class SmallNumberComponent extends NodeComponent {
    @Override
    public void process() throws Exception {
        NumberCheckContext context = this.getContextBean(NumberCheckContext.class);
        context.addExecutionStep("Processing small number special case");
        // Additional logic for big numbers
    }
}
