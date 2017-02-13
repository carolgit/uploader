package uploader;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.multipart.UploadedFile;
import br.com.caelum.vraptor.view.Results;
import reader.Reader;

@Resource
@Path("/excel")
public class UploadController {
	private Reader reader;
	private Result result;

	public UploadController(Reader reader, Result result) {
		super();
		this.reader = reader;
		this.result = result;
	}

	@Post("/upload")
	public void upload(UploadedFile file) {
		System.out.println(file.getFileName());
		reader.readFile(file);
		result.use(Results.http()).setStatusCode(200);
	}
	
	@Get("/upload")
	public void uploadform() {
	}
	
	@Get("/avaliacao")
	public void avaliacao() {
	}
}
