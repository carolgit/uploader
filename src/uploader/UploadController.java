package uploader;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.multipart.UploadedFile;
import reader.Reader;

@Resource
@Path("/excel")
public class UploadController {
	private Reader reader;
	private Result result;

	public UploadController(Reader reader) {
		super();
		this.reader = reader;
	}

	@Post("/upload")
	public void upload(UploadedFile file) {
		reader.readFile(file);
		result.nothing();
	}
	
	@Get("/upload")
	public void uploadform() {
	}
}
