package study.taxi.service.authorityService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import study.taxi.data.entity.Authority;
import study.taxi.data.repository.AuthorityRepository;

@Service
@RequiredArgsConstructor
public class AuthorityServiceImpl implements AuthorityService{

    private final AuthorityRepository authorityRepository;

    public Authority create(Authority authority){
        return authorityRepository.save(authority);
    }
}
