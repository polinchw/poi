package com.bpe.spring.boot.poi.data.jpa.web;

import com.bpe.spring.boot.poi.data.jpa.domain.Hotel;
import com.bpe.spring.boot.poi.data.jpa.service.HotelService;
import com.bpe.spring.boot.poi.data.jpa.word.Word2Forrest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

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

    @RequestMapping("/writeHotelToFile")
    @ResponseBody
    @Transactional(readOnly = true)
    public Hotel writeHotelToWord(@RequestParam(value = "id") String id) throws Exception {
        Hotel hotel = hotelService.getHotelById(Long.parseLong(id));
        InputStream is = new FileInputStream("/home/polinchakb/IdeaProjects/poi/test.docx");
        OutputStream out = new FileOutputStream("test.xml");
        try {
            new Word2Forrest(null, out);
        } finally {
            out.close();
            is.close();
        }
        return hotel;
    }
}
