package com.ozmenyavuz.controller;

import com.ozmenyavuz.utils.RestPageableRequest;
import com.ozmenyavuz.utils.RestRootEntity;

public interface IRestController {

   public RestRootEntity<RestPageableRequest> findAllPageAble(RestPageableRequest restPageableRequest);

}
