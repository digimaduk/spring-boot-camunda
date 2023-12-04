package org.digimad.repo;

import org.digimad.domain.OrderWorkflowEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderWorkflowRepository extends JpaRepository<OrderWorkflowEntity, Long> {
}
