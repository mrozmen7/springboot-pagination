package com.ozmenyavuz.service.impl;


import com.ozmenyavuz.dto.DtoPersonel;
import com.ozmenyavuz.mapper.PersonalMapper;
import com.ozmenyavuz.model.Personal;
import com.ozmenyavuz.repository.PersonalRepository;
import com.ozmenyavuz.service.IPersonalService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PersonalServiceImpl implements IPersonalService {

    private final PersonalRepository personalRepository;
    private final PersonalMapper personalMapper;

    public PersonalServiceImpl(PersonalRepository personalRepository, PersonalMapper personalMapper) {
        this.personalRepository = personalRepository;
        this.personalMapper = personalMapper;
    }

    @Override
    public Page<Personal> findAllPageAble(Pageable pageable) {
        return personalRepository.findAllPageAble(pageable);
    }

    @Override
    public List<DtoPersonel> toDtoList(List<Personal> personalList) {
        return personalMapper.toDtoList(personalList);
    }
}
