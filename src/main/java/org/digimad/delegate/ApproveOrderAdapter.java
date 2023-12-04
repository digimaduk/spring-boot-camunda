package org.digimad.delegate;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;
import org.digimad.domain.OrderWorkflowEntity;
import org.digimad.repo.OrderWorkflowRepository;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class ApproveOrderAdapter implements TaskListener {

    private final OrderWorkflowRepository orderWorkflowRepository;

    @Override
    public void notify(DelegateTask delegateTask) {
        log.info("Inside ApproveOrderAdapter");
        String camundaTaskId = delegateTask.getId();
        Long orderId = (Long) delegateTask.getExecution().getVariable("orderId");
        orderWorkflowRepository.save(OrderWorkflowEntity.builder()
            .taskId(camundaTaskId)
            .orderId(orderId)
            .build());
        log.info("CamundaTaskId is persisted {}", camundaTaskId);
    }
}
