package com.ozmenyavuz.controller.impl;

import com.ozmenyavuz.controller.IRestController;
import com.ozmenyavuz.dto.DtoPersonel;
import com.ozmenyavuz.model.Personal;
import com.ozmenyavuz.service.IPersonalService;
import com.ozmenyavuz.utils.RestPageableEntity;
import com.ozmenyavuz.utils.RestPageableRequest;
import com.ozmenyavuz.utils.RestRootEntity;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/rest/api/personal")
public class RestControllerImpl extends RestBaseController implements IRestController {

    private final IPersonalService personalService;

    public RestControllerImpl(IPersonalService personalService) {
        this.personalService = personalService;
    }

    // 8080?pageNumber=0&pageSize=5&columnName=createTime&asc=true
    // @ModelAttribute :

    @GetMapping("/list/pageable")
    @Override
    public RestRootEntity<RestPageableRequest> findAllPageAble(@ModelAttribute RestPageableRequest restPageableRequest) {

        Page<Personal> page = personalService.findAllPageAble(toPageable(restPageableRequest));

        List<DtoPersonel> dtoList = personalService.toDtoList(page.getContent());

        RestPageableEntity<DtoPersonel> response = toPageableResponse(page, dtoList);

        return ok(restPageableRequest);
    }




}
