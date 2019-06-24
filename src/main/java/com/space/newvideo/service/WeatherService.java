package com.space.newvideo.service;

import com.space.newvideo.bean.WeatherBean;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class WeatherService {
    public WeatherBean getWeatherLogic(int index) {
        WeatherBean bean = null;
        switch (index) {
            case 0:
                bean = setWeather(24, "sun", "good");
                break;
            case 1:
                bean = setWeather(2, "cold", "bad");
                break;
            case 2:
                bean = setWeather(38, "sun", "very hot");
                break;
            case 3:
                bean = setWeather(15, "rain", "worse");
                break;
        }
        return bean;
    }

    private WeatherBean setWeather(int temperature, String type, String desc) {
        WeatherBean weatherBean = new WeatherBean();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        weatherBean.setTime(dateFormat.format(new Date()));
        weatherBean.setTemperature(temperature);
        weatherBean.setType(type);
        weatherBean.setDescription(desc);
        return weatherBean;
    }
}
