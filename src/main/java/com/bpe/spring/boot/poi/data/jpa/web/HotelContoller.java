package com.bpe.spring.boot.poi.data.jpa.web;

import com.bpe.spring.boot.poi.data.jpa.domain.Hotel;
import com.bpe.spring.boot.poi.data.jpa.service.CityService;
import com.bpe.spring.boot.poi.data.jpa.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by polinchakb on 9/25/16.
 */
@Controller
public class HotelContoller {

    @Autowired
    private HotelService hotelService;

    @RequestMapping("/hotel")
    @ResponseBody
    @Transactional(readOnly = true)
    public Hotel findHotelById(@RequestParam(value = "id") String id) {
        return hotelService.getHotelById(Long.parseLong(id));
    }
}
