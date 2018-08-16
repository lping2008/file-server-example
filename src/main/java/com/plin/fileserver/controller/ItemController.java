package com.plin.fileserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.plin.fileserver.domain.PictureResult;
import com.plin.fileserver.service.IItemService;
import com.plin.fileserver.utils.JsonUtils;

@RestController
public class ItemController {
	@Autowired
	private IItemService itemservice;
	
	@RequestMapping(value="/pic/upload",method=RequestMethod.POST)
	public String picUpload(MultipartFile uploadFile) {
		PictureResult picResult = itemservice.uploadFile(uploadFile);
		String result = JsonUtils.objectToJson(picResult);
		return result;
	}
}
