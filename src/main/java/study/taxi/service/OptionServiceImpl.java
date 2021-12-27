package study.taxi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import study.taxi.data.entity.Option;
import study.taxi.data.repository.OptionRepository;

@Service
@RequiredArgsConstructor
public class OptionServiceImpl implements OptionService {

    private final OptionRepository optionRepository;

    @Override
    public Option getOption(String optionName) {
        return optionRepository.findByOptionName(optionName);
    }
}
