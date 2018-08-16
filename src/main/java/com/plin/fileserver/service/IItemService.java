package com.plin.fileserver.service;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.plin.fileserver.domain.PictureResult;

public interface IItemService {
	public PictureResult uploadFile(MultipartFile uploadFile);

}
