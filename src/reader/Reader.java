package reader;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.interceptor.multipart.UploadedFile;
import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;
import exception.FormatNotAllowedException;
import uploader.UploadController;

@Component
@ApplicationScoped
public class Reader {
	
	private Validator validator;
	private Result result;

	public void readFile(UploadedFile file) {
		String extension = file.getFileName().substring(file.getFileName().indexOf("."));
		//planilha com todas as abas
		Workbook workbook;
		try {
			workbook = getWorkbook(extension, file.getFile());
			if (workbook == null) {
				result.on(FormatNotAllowedException.class).forwardTo(UploadController.class).uploadform();
			}
			//primeira aba
			Sheet sheet = workbook.getSheetAt(0);
			//percorre a planilha e monta o objeto
			createObject(sheet);
			//chamar função que salva
			
		} catch (IOException e) {
			result.on(IOException.class).forwardTo(UploadController.class).uploadform();
		}
		
	}

	private Workbook getWorkbook(String extension, InputStream file) throws IOException {
		Workbook workbook = null;
		if (extension.equals(".xlsx")) {
			workbook = new XSSFWorkbook(file);
		} else if (extension.equals(".xls")) {
			workbook = new HSSFWorkbook(new POIFSFileSystem(file));
		} else {
			workbook = null;
		}
		return workbook;
	}
	
	private void createObject(Sheet sheet){
		Iterator<Row> lines = sheet.iterator();
		while (lines.hasNext()) {
			//linha atual
			Row line = lines.next();
			//percorrer celulas da linha
			Iterator<Cell> cells = line.iterator();
			while(cells.hasNext()){
				Cell cell = cells.next();
				System.out.println(cell.getColumnIndex()+" - "+cell.toString());
			}
		}
	}
}
