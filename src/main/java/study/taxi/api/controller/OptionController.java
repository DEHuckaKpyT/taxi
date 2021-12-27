package study.taxi.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.taxi.api.dto.OptionDto;
import study.taxi.api.mapper.OptionMapper;
import study.taxi.api.mapper.OrderMapper;
import study.taxi.data.entity.Option;
import study.taxi.data.repository.OptionRepository;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("option")
@RequiredArgsConstructor
public class OptionController {

    private final OptionRepository optionRepository;

    @GetMapping("list")
    @Transactional
    List<OptionDto> getAll() {
        return OptionMapper.INSTANCE.toOptionDto(optionRepository.findAll());
    }
}
