package com.ozmenyavuz.controller.impl;

import com.ozmenyavuz.utils.PagerUtil;
import com.ozmenyavuz.utils.RestPageableEntity;
import com.ozmenyavuz.utils.RestPageableRequest;
import com.ozmenyavuz.utils.RestRootEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class RestBaseController {

    public Pageable toPageable(RestPageableRequest restPageableRequest) {
        return PagerUtil.toPageable(restPageableRequest);
    }

    public <T> RestPageableEntity<T> toPageableResponse(Page<?> page, List<T> content ) {
        return PagerUtil.toPageableResponse(page, content);
    }

    public <T>RestRootEntity<T> ok(T payload){
        return RestRootEntity.ok(payload);

    }

}
