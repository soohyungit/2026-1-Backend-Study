package com.example.shop.order;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    @Transactional
    public Long createOrder(OrderCreateRequest request){
        Order existingOrder = orderRepository.findById(request.getId());
        if(existingOrder != null){
            throw new RuntimeException("이미 존재하는 주문 입니다: "+ request.getId());
        }

        Order order = new Order(
                request.getId(),
                request.getQuantity()
        );

        orderRepository.save(order);

        return order.getId();
    }

    @Transactional(readOnly = true)
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Order getOrderById(Long id) {
        Order order = orderRepository.findById(id);
        if (order == null) {
            throw new RuntimeException("주문을 찾을 수 없습니다.");
        }
        return order;
    }

    @Transactional
    public void deleteOrder(Long id) { // deleteOrder -> cancelOrder
        Order order = orderRepository.findById(id);

        if (order == null) {
            throw new RuntimeException("주문을 찾을 수 없습니다");
        }

        orderRepository.deleteById(id);
    }
}

