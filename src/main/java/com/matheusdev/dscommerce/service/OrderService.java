package com.matheusdev.dscommerce.service;

import com.matheusdev.dscommerce.dto.OrderDTO;
import com.matheusdev.dscommerce.dto.OrderItemDTO;
import com.matheusdev.dscommerce.entities.*;
import com.matheusdev.dscommerce.repository.OrderItemRepository;
import com.matheusdev.dscommerce.repository.OrderRepository;
import com.matheusdev.dscommerce.repository.ProductRepository;
import com.matheusdev.dscommerce.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private AuthService authService;

    @Transactional
    public OrderDTO insert(OrderDTO orderDTO) {
        Order order = new Order();
        order.setMoment(Instant.now());
        order.setStatus(OrderStatus.WAITING_PAYMENT);

        User user = userService.autheticated();
        order.setClient(user);

        for (OrderItemDTO orderItemDTO : orderDTO.getItemDTOS()) {
            Product product = productRepository.getReferenceById(orderItemDTO.getProductId());
            OrderItem item = new OrderItem(order, product, orderItemDTO.getQuantity(), product.getPrice());
            order.getItems().add(item);
        }

        orderRepository.save(order);
        orderItemRepository.saveAll(order.getItems());

        return new OrderDTO(order);
    }

    @Transactional(readOnly = true)
    public OrderDTO findById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));

        authService.validateSelfOrAdmin(order.getClient().getId());

        return new OrderDTO(order);
    }
}
