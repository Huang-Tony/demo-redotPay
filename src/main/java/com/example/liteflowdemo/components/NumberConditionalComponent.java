package com.example.liteflowdemo.components;

import com.example.liteflowdemo.context.NumberCheckContext;
import com.yomahub.liteflow.core.NodeSwitchComponent;
import org.springframework.stereotype.Component;

@Component("numberCondCmp")
public class NumberConditionalComponent extends NodeSwitchComponent {
    @Override
    public String processSwitch() throws Exception {
        NumberCheckContext context = this.getContextBean(NumberCheckContext.class);
        double number = context.getInputNumber();
        
        if (number > 10) {
            context.addExecutionStep("Number > 10 detected");
            return "bigNumberCmp";
        } else {
            context.addExecutionStep("Number ≤ 10 detected");
            return "smallNumberCmp";
        }
    }
}