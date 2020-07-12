package br.com.malabar.xlsbuilder;

import java.io.IOException;

import br.com.malabar.xlsbuilder.service.XlsTestService;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class App {

	public static void main(String[] args) throws IOException, RowsExceededException, WriteException {


		try {
			new XlsTestService().buildXlsFile();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
