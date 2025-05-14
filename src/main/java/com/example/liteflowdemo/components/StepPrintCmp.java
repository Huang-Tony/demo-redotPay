package com.example.liteflowdemo.components;

import com.example.liteflowdemo.context.NumberCheckContext;
import com.yomahub.liteflow.core.NodeComponent;
import com.yomahub.liteflow.log.LFLog;
import com.yomahub.liteflow.log.LFLoggerManager;
import org.springframework.stereotype.Component;

@Component("printResultCmp")
public class StepPrintCmp extends NodeComponent {
    
    private final LFLog log = LFLoggerManager.getLogger(getClass());
    
    @Override
    public void process() throws Exception {
        NumberCheckContext context = this.getContextBean(NumberCheckContext.class);
        
        StringBuilder sb = new StringBuilder();
        sb.append("Number Check Execution Steps:\n");
        sb.append("============================\n");
        sb.append("Input Number: ").append(context.getInputNumber()).append("\n");
        
        for (String step : context.getExecutionSteps()) {
            sb.append("- ").append(step).append("\n");
        }
        
        sb.append("Final Result: ").append(context.getFinalResult()).append("\n");
        sb.append("============================");
        
        log.info(sb.toString());
    }
}