package com.self.springbootdemo.controller.front;

import com.self.springbootdemo.service.TestInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * 前台测试接口
 * @author zp
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestInfoService service;

    /**
     * 跳转到test1页面
     * @param id id
     * @return modelAndView
     */
    @RequestMapping("/toTest1")
    public ModelAndView toTest1(Integer id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("test/test1");
        modelAndView.addObject("testInfo",service.selectByPrimaryKey(id).getData());
        return modelAndView;
    }

}
