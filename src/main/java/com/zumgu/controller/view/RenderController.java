package com.zumgu.controller.view;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kanghonggu on 2016-12-12.
 */
@RestController
public class RenderController {

    @Autowired
    private BeanFactory beanFactory;

}
