package com.example.liteflowdemo.components;

import com.example.liteflowdemo.context.NumberCheckContext;
import com.yomahub.liteflow.core.NodeComponent;
import org.springframework.stereotype.Component;

@Component("numberCheckCmp")
public class NumberCheckComponent extends NodeComponent {
    @Override
    public void process() throws Exception {
        NumberCheckContext context = this.getContextBean(NumberCheckContext.class);
        double number = context.getInputNumber();
        
        String result = (number > 5) ? "Larger than 5" : "5 or smaller";
        context.addExecutionStep("Basic check completed: " + result);
        context.setFinalResult(result);
    }
}