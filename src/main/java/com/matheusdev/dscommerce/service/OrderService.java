package com.matheusdev.dscommerce.service;

import com.matheusdev.dscommerce.dto.OrderDTO;
import com.matheusdev.dscommerce.entities.Order;
import com.matheusdev.dscommerce.repository.OrderRepository;
import com.matheusdev.dscommerce.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Transactional(readOnly = true)
    public OrderDTO findById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));

        return new OrderDTO(order);
    }
}
