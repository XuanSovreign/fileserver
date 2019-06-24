package com.space.newvideo.controller;

import com.space.newvideo.bean.ItemBean;
import com.space.newvideo.bean.TestBean;
import com.space.newvideo.bean.WeatherBean;
import com.space.newvideo.service.ItemDataService;
import com.space.newvideo.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/convert")
public class DataController {
    @Autowired
    WeatherService service;
    @Autowired
    ItemDataService dataService;

    @RequestMapping("/dataBean")
    public TestBean testJson() {
        TestBean bean = new TestBean();
        bean.setCode(100);
        bean.setMessge("hello world");
        return bean;
    }

    @RequestMapping("/weather")
    public WeatherBean getWeather() {
        return service.getWeatherLogic(2);
    }

    @RequestMapping("/item")
    public List<ItemBean> requireMoreItem(int num) {
        return dataService.getMoreItem(num);
    }
}
