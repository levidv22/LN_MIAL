package ln.mial.ecommerce.app.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.web.multipart.MultipartFile;

public class UploadFile {
   
    private final String FOLDER = "images//";
    private final String IMG_DEFAULT = "default.png";
    
    public String upload(MultipartFile multipartFile) throws IOException{
        if (multipartFile != null && !multipartFile.isEmpty()) {
            byte [] bytes = multipartFile.getBytes();
            Path path = Paths.get(FOLDER + multipartFile.getOriginalFilename());
            Files.write(path, bytes);
            return multipartFile.getOriginalFilename();
            
        }
        return IMG_DEFAULT;
    }
    public void delete(String nameFile){
        File file = new File(FOLDER + nameFile);
        file.delete();
    }
}
