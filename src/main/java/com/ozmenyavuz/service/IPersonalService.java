package com.ozmenyavuz.service;

import com.ozmenyavuz.dto.DtoPersonel;
import com.ozmenyavuz.model.Personal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPersonalService {

    Page<Personal> findAllPageAble(Pageable pageable);

    List<DtoPersonel> toDtoList(List<Personal> personalList);
}
