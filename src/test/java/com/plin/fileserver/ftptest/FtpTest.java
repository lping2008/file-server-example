package com.plin.fileserver.ftptest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.plin.fileserver.service.IItemService;
import com.plin.fileserver.utils.FtpUtil;

public class FtpTest {
	@Test
	public void testFtp() throws Exception {
		//1、连接ftp服务器
		FTPClient ftpClient = new FTPClient();
		ftpClient.connect("192.168.35.5", 21);
		//2、登录ftp服务器
		ftpClient.login("ftpuser", "ftpuser");
		//3、读取本地文件
		FileInputStream inputStream = new FileInputStream(new File("F:\\ftptest\\ftptest3.jpg"));
		//4、上传文件
		//1）指定上传目录
		ftpClient.changeWorkingDirectory("/home/ftpuser/ftpexample/images");
		//2）指定文件类型
		ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
		//第一个参数：文件在远程服务器的名称
		//第二个参数：文件流
		ftpClient.storeFile("ftptest3.jpg", inputStream);
		//5、退出登录
		ftpClient.logout();
	}
	
	@Test
	public void testFtpUtil() throws FileNotFoundException {
		InputStream input =new FileInputStream(new File("F:\\ftptest\\ftptest3.jpg"));
		boolean bool = FtpUtil.uploadFile("192.168.35.5", 21, "ftpuser", "ftpuser", "/home/ftpuser/ftpexample/images", "2018/08/16", "ftptest3.jpg", input);
		System.out.println(bool);
	}
	
	@Autowired
	private IItemService service;
	@Test 
	public void testFtpUploadService() {
//		service.uploadFile(uploadFile);
	}
}
