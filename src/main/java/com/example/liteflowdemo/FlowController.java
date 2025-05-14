package com.example.liteflowdemo;

import java.util.Map;
import com.example.liteflowdemo.context.NumberCheckContext;
import com.yomahub.liteflow.core.FlowExecutor;
import com.yomahub.liteflow.flow.LiteflowResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.MediaType;

@Controller
public class FlowController {
    
    private final FlowExecutor flowExecutor;
    
    public FlowController(FlowExecutor flowExecutor) {
        this.flowExecutor = flowExecutor;
    }

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("number", 0);
        model.addAttribute("condition", ">5");
        model.addAttribute("result", "Submit a number to check");
        return "number-check";
    }

    @PostMapping("/check-number")
    public String checkNumber(
            @RequestParam double number,
            @RequestParam String condition,
            Model model) {
        
        NumberCheckContext context = new NumberCheckContext();
        context.setInputNumber(number);
        context.setCondition(condition);
        
        flowExecutor.execute2Resp("dynamicConditionChain", number, context);
        
        model.addAttribute("number", number);
        model.addAttribute("condition", condition);
        model.addAttribute("result", context.getFinalResult());
        model.addAttribute("steps", context.getExecutionSteps());
        
        return "number-check";
    }
}