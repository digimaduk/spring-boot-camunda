package org.digimad.controller;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.task.Task;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.Variables;
import org.digimad.dto.Order;
import org.digimad.util.GenericJsonConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PizzaController {
    @Autowired
    RuntimeService runtimeService;
    @Autowired
    TaskService taskService;

    @PostMapping("/receive")
    public void startProcess(@RequestBody Order order) {
        VariableMap variableMap = Variables.createVariables()
            .putValue("orderId", order.getOrderId())
            .putValueTyped("orderDto", new GenericJsonConverter<>(order).convertToJson());
        runtimeService.startProcessInstanceByKey("pizza", order.getOrderId().toString(), variableMap);
    }

    @PostMapping("/approve")
    public void approveOrder(@RequestBody String taskId) {
        Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
        String processId = task.getId();
        runtimeService.setVariable(task.getExecutionId(), "isOrderApproved", "Y");
        taskService.complete(processId);
        log.info("Camunda workflow task:: {} completed", processId);
    }
}
