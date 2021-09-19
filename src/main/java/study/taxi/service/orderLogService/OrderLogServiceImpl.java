package study.taxi.service.orderLogService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.taxi.data.entity.OrderLog;
import study.taxi.data.repository.OrderLogRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderLogServiceImpl implements OrderLogService {

    private final OrderLogRepository orderLogRepository;

    @Override
    @Transactional(readOnly = true)
    public List<OrderLog> getAll() {
        return orderLogRepository.findAll();
    }
}
