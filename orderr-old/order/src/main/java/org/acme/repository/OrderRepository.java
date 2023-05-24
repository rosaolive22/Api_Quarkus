package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.entity.OrdertEntity;

@ApplicationScoped
public class OrderRepository implements PanacheRepository<OrderEntity> {
}
