package com.example.liteflowdemo.components;

import com.example.liteflowdemo.context.NumberCheckContext;
import com.yomahub.liteflow.core.NodeComponent;
import org.springframework.stereotype.Component;

@Component("dynamicConditionCmp")
public class DynamicConditionComponent extends NodeComponent {
    @Override
    public void process() throws Exception {
        NumberCheckContext context = this.getContextBean(NumberCheckContext.class);
        double number = context.getInputNumber();
        String condition = context.getCondition();
        
        boolean result = evaluateCondition(number, condition);
        String resultStr = number + " " + condition + " is " + result;
        
        context.addExecutionStep("Condition evaluated: " + condition);
        context.setFinalResult(resultStr);
    }
    
    private boolean evaluateCondition(double number, String condition) {
        if (condition.startsWith(">")) {
            double value = Double.parseDouble(condition.substring(1));
            return number > value;
        } else if (condition.startsWith("<")) {
            double value = Double.parseDouble(condition.substring(1));
            return number < value;
        } else if (condition.startsWith(">=")) {
            double value = Double.parseDouble(condition.substring(2));
            return number >= value;
        } else if (condition.startsWith("<=")) {
            double value = Double.parseDouble(condition.substring(2));
            return number <= value;
        } else if (condition.startsWith("==")) {
            double value = Double.parseDouble(condition.substring(2));
            return number == value;
        } else if (condition.startsWith("!=")) {
            double value = Double.parseDouble(condition.substring(2));
            return number != value;
        }
        throw new IllegalArgumentException("Invalid condition: " + condition);
    }
}