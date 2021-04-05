package com.spboot.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spboot.test.entity.ExhibitonInfo;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ExhibitonInfoController {

	@PostMapping("/exhibition")
	public @ResponseBody int insert(@RequestBody ExhibitonInfo ei) {
		log.info("ei=>{}",ei);
		return ei.getEiNum();
	}
}
