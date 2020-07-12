package br.com.malabar.xlsbuilder.utils;

import java.io.IOException;
import java.util.List;

import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class WritableWorkBook {
	private WritableWorkbook xls;
	private WritableSheet sheet;
	
	
	public WritableWorkBook(WritableWorkbook xls) {
		this.xls = xls;
	}
	
	
	public InnerSheet createSheet(String sheetName, int index) {
		this.sheet = xls.createSheet(sheetName, index);
		return new InnerSheet(xls, sheet, index);
	}
	
	public class InnerSheet{
		private WritableWorkbook xls;
		private WritableSheet sheet;
		private Integer headSize;
		int index;
		
		public InnerSheet(WritableWorkbook xls, WritableSheet sheet, int index) {
			this.xls = xls;
			this.sheet = sheet;
			this.index = index;
		}
		
		
		public InnerSheet createHeader(String[] header) throws RowsExceededException, WriteException {
			this.headSize = header.length;
			
			for(int i = 0; i < header.length; i++) {
				this.sheet.addCell(new Label(i, index, header[i]));
			}
			return this;
		}
		
		public InnerSheet fillData(List<List<String>> data) throws Exception {
			for(int i = 0; i < data.size(); i++) {
				if(data.get(i).size() < this.headSize) {
					this.xls.close();
					throw new Exception("Tamanho de linha diferente do tamanho do cabeçalho");
					
				}
				for(int j = 0; j < data.get(i).size(); j++) {
					String value = data.get(i).get(j);
					this.sheet.addCell(new Label(j, i+1, value));
				}
			}
			return this;
		}
		
		public WritableWorkbook buildToWritableWorkbook() {
			return this.xls;
		}
		
		public void buildAndWriteFile() throws IOException, WriteException {
			this.xls.write();
			this.xls.close();
		}
		
		
	}

}
