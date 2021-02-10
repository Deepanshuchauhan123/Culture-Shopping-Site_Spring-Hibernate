package com.deepanshu.OnlineShopping.util;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtility {

	private static final String ABS_PATH = "C:\\Users\\user\\eclipse-workspace\\Servlet_Work\\Online-Shopping-Site\\OnlineShopping\\src\\main\\webapp\\assets\\images\\";
	private static String REAL_PATH = "";

	private static final Logger logger = LoggerFactory.getLogger(FileUploadUtility.class);

	public static void uploadFile(HttpServletRequest request, MultipartFile file, String code) {
		// get real path
		REAL_PATH = request.getSession().getServletContext().getRealPath("/assets/images/");

	}

}
