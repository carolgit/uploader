/**
 * 
 */
package uploader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.multipart.UploadedFile;
import br.com.caelum.vraptor.util.test.MockResult;
import junit.framework.TestCase;
import reader.Reader;

/**
 * @author ana
 *
 */
public class TestUpload extends TestCase {
	private Result result = new MockResult();
	private UploadController controller;
	private Reader reader;
	private UploadedFile file;

	/**
	 * @param name
	 */
	public TestUpload(String name) {
		super(name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#setUp()
	 */
	@Before
	protected void setUp() throws Exception {
		reader = new Reader();
		controller = new UploadController(reader);
	}

	@Test
	public void testUpload() {
		UploadedFile file =  new UploadedFile() {
			private InputStream file = null;

			public long getSize() {				
				return 0;
			}
			
			public String getFileName() {
				return "Mapeamento.xlsx";
			}
			
			public InputStream getFile() {
				try {
					file = new FileInputStream("test/resources/Mapeamento.xlsx");
				} catch (FileNotFoundException e1) {
					assertTrue(false);
				}
				return this.file;
			}
			
			public String getContentType() {
				return null;
			}
		};		
		controller.upload(file);
	}
	
	@Test
	public void testUpload2() {
		UploadedFile file =  new UploadedFile() {
			private InputStream file = null;

			public long getSize() {				
				return 0;
			}
			
			public String getFileName() {
				return "Mapeamento.xlsx";
			}
			
			public InputStream getFile() {
				try {
					file = new FileInputStream("test/resources/Mapeamento1.xls");
				} catch (FileNotFoundException e1) {
					assertTrue(false);
				}
				return this.file;
			}
			
			public String getContentType() {
				return null;
			}
		};		
		controller.upload(file);
	}

}
