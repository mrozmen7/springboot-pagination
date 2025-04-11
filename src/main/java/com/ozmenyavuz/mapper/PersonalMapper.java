package com.ozmenyavuz.mapper;

import com.ozmenyavuz.dto.DtoDepartment;
import com.ozmenyavuz.dto.DtoPersonel;
import com.ozmenyavuz.model.Department;
import com.ozmenyavuz.model.Personal;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonalMapper {

    // Tekil dönüşümler
    DtoPersonel toDto(Personal personal);
    Personal toEntity(DtoPersonel dtoPersonel);

    DtoDepartment toDto(Department department);
    Department toEntity(DtoDepartment dtoDepartment);

    // Liste dönüşümleri
    List<DtoPersonel> toDtoList(List<Personal> personalList);
    List<Personal> toEntityList(List<DtoPersonel> dtoPersonelList);
}