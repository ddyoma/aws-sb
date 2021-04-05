package com.spboot.test.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spboot.test.entity.FileInfo;
import com.spboot.test.repository.FileInfoReposytory;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class FileInfoController {

	@Autowired
	private FileInfoReposytory fiRepo;
	private final static String ROOT = "C:\\study\\workspace11\\aws-sb\\src\\main\\webapp\\resources\\";
	@PostMapping("/file-info")
	public @ResponseBody Integer insert(FileInfo fi) throws Exception {
		String fiName = fi.getFiFile().getOriginalFilename();
		if(fiName==null) {
			throw new Exception("파일은필수항목입니다");
		}
		int idx = fiName.lastIndexOf(".");
		String eName = fiName.substring(idx);
		String path = ROOT + System.nanoTime() +eName;
		fi.setFiName(fiName);
		fi.setFiPath(path);
		fiRepo.save(fi);
		if(fi.getFiNum()==null) {
			throw new Exception("저장시 오류발생");
		}
		File f =  new File(path);
		fi.getFiFile().transferTo(f);
		log.info("fi={}",fi);
		return 1;
	}
}
