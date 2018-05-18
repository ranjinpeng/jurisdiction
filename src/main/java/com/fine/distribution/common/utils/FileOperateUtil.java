package com.fine.distribution.common.utils;

import org.apache.poi.ss.usermodel.Workbook;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;

/**
 * Created by sunxyz on 2016/12/21.
 */
public final class FileOperateUtil {

	private FileOperateUtil() {

	}

	public static void download(HttpServletRequest request, HttpServletResponse response, String storeName, Workbook book) throws Exception {
		String agent = request.getHeader("USER-AGENT").toLowerCase();
		response.setContentType("application/vnd.ms-excel");
		String fileName = storeName;
		String codedFileName = URLEncoder.encode(fileName, "UTF-8");
		if (agent.contains("firefox")) {
			response.setCharacterEncoding("utf-8");
			response.setHeader("content-disposition", "attachment;filename=" + new String(fileName.getBytes(), "ISO8859-1"));
		} else {
			response.setHeader("content-disposition", "attachment;filename=" + codedFileName);
		}
		book.write(response.getOutputStream());
	}
}