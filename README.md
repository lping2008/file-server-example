# file-server-example
搭建一个Nginx+vsftpd图片服务器，通过Nginx提供http服务，对图片url进行访问。vsftpd提供上传图片功能。
实现浏览器端上传图片，使用springmvc并得到图片的url（使用UUID生成随机图片名，防止重名），在浏览器访问图片url，展示图片。
详细介绍请参见https://blog.csdn.net/lping985/article/details/81738537
