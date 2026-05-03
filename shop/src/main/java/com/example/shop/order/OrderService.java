package com.example.shop.order;

import com.example.shop.order.dto.OrderCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    @Transactional
    public Long createOrder(OrderCreateRequest request){
        // 1. 실제로는 멤버 레포지토리에서 멤버를 찾아와야 함 (여기선 생략)
        // Member member = memberRepository.findById(request.getMemberId());

        // 2. 엔티티 생성 (id는 넣지 않습니다. DB가 만들어주니까요!)
        Order order = new Order(
                null, // 우선은 null로 테스트하거나 멤버 객체를 넣어주세요.
                request.getTotalPrice(),
                request.getPointUsed(),
                request.getCashAmount(),
                request.getStatus()
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
    public void deleteOrder(Long id) {
        Order order = orderRepository.findById(id);

        if (order == null) {
            throw new RuntimeException("주문을 찾을 수 없습니다");
        }

        orderRepository.deleteById(id);
    }
}

