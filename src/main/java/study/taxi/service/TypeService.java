package study.taxi.service;

import study.taxi.data.entity.CarType;

public interface TypeService {

    CarType getType(String typeName);
}
