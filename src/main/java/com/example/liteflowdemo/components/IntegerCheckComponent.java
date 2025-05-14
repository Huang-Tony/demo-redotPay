package com.example.liteflowdemo.components;

import org.springframework.stereotype.Component;

import com.example.liteflowdemo.context.NumberCheckContext;
import com.yomahub.liteflow.core.NodeComponent;

@Component("integerCheckCmp")
public class IntegerCheckComponent extends NodeComponent {
    @Override
    public void process() throws Exception {
        NumberCheckContext context = this.getContextBean(NumberCheckContext.class);
        double number = context.getInputNumber();
        
        boolean isInteger = (number == Math.floor(number)) && !Double.isInfinite(number);
        String result = isInteger ? "Is an integer" : "Not an integer";
        
        context.addExecutionStep("Integer check completed: " + result);
        context.setFinalResult(result);
    }
}