package com.plin.fileserver.service;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.plin.fileserver.domain.PictureResult;
import com.plin.fileserver.utils.FtpUtil;
import com.plin.fileserver.utils.IdUtil;
@Service
public class ItemServiceImpl implements IItemService{
	
	@Value("${FTP_ADDRESS}")
	private String FTP_ADDRESS;
	@Value("${FTP_PORT}")
	private Integer FTP_PORT;
	@Value("${FTP_USERNAME}")
	private String FTP_USERNAME;
	@Value("${FTP_PASSWORD}")
	private String FTP_PASSWORD;
	@Value("${FTP_BASE_PATH}")
	private String FTP_BASE_PATH;
	@Value("${IMAGE_BASE_URL}")
	private String IMAGE_BASE_URL;

	public PictureResult uploadFile(MultipartFile uploadFile) {
		PictureResult picResult = new PictureResult();
		try {
			//生成一个新的文件名
			//取原始文件名
			String oldName = uploadFile.getOriginalFilename();
			//生成新文件名
			//UUID.randomUUID();
			String newName = IdUtil.genImageName();
			newName = newName + oldName.substring(oldName.lastIndexOf("."));
			//图片上传
			String imagePath = new DateTime().toString("/yyyy/MM/dd");
			boolean result = FtpUtil.uploadFile(FTP_ADDRESS, FTP_PORT, FTP_USERNAME, FTP_PASSWORD, 
					FTP_BASE_PATH, imagePath, newName, uploadFile.getInputStream());
			//返回结果
			if(!result) {
				picResult.setError(1);
				picResult.setMessage("文件上传失败");
				return picResult;
			}
			picResult.setError(0);
			picResult.setUrl(IMAGE_BASE_URL + imagePath + "/" + newName);
			return picResult;
			
		} catch (Exception e) {
			picResult.setError(1);
			picResult.setMessage("文件上传发生异常");
			return picResult;
		}
	}
}
