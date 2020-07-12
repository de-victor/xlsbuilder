package br.com.malabar.xlsbuilder.utils;

import java.io.File;
import java.io.IOException;

import jxl.Workbook;

public class XlsMaker {

	private XlsMaker() {}
	
	public static WritableWorkBook createWorkbook(File file) throws IOException {
		
		return new WritableWorkBook(Workbook.createWorkbook(file));
	}
	
	
}
