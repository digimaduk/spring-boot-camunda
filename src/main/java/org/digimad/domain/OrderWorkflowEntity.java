package org.digimad.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "customer_order_workflow")
public class OrderWorkflowEntity {

    @Id
    @Column(name = "customer_order_workflow_id")
    @JsonProperty("id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "camunda_task_id")
    @JsonProperty("taskId")
    private String taskId;

    @Column(name = "order_id")
    @JsonProperty("orderId")
    private Long orderId;
}
