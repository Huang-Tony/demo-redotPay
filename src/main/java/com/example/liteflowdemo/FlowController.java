package com.example.liteflowdemo;
import java.util.Map;
import com.example.liteflowdemo.context.NumberCheckContext;
import com.yomahub.liteflow.core.FlowExecutor;
import com.yomahub.liteflow.flow.LiteflowResponse;
// import com.yomahub.liteflow.flow.ResponseBody;

import java.util.List;

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

    // Handle GET requests (initial page load) https://www.w3schools.com/TAgs/ref_httpmethods.asp
    @GetMapping("/")
    public String showForm(Model model) {
        // Initialize with default values
        model.addAttribute("number", 0);
        model.addAttribute("checkType", "greaterThan5");
        model.addAttribute("result", "Submit a number to check");
        return "number-check";
    }

    // Handle POST requests (form submission) https://www.w3schools.com/TAgs/ref_httpmethods.asp
    @PostMapping("/check-number")
    public String checkNumber(
            @RequestParam double number,    //https://docs.spring.io/spring-framework/reference/web/webmvc/mvc-controller/ann-methods/requestparam.html
            @RequestParam String checkType,
            Model model) {
        
        NumberCheckContext context = new NumberCheckContext();
        context.setInputNumber(number);
        
        String chainName = checkType.equals("isInteger") 
            ? "integerCheckChain" 
            : "greaterThan5Chain";
            
        flowExecutor.execute2Resp(chainName, number, context);
        
        // Add results to model for Thymeleaf
        model.addAttribute("number", number);
        model.addAttribute("checkType", checkType);
        model.addAttribute("result", context.getFinalResult());
        model.addAttribute("steps", context.getExecutionSteps());
        
        return "number-check"; // Return to the same page
    }
}
