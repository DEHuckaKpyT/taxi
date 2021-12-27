package study.taxi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import study.taxi.data.entity.CarType;
import study.taxi.data.repository.CarTypeRepository;

@Service
@RequiredArgsConstructor
public class TypeServiceImpl implements TypeService{

    private final CarTypeRepository carTypeRepository;

    @Override
    public CarType getType(String typeName) {
        return carTypeRepository.findByTypeName(typeName);
    }
}
