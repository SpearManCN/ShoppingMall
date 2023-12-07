package shop.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

//import javax.annotation.Resource;
import org.springframework.core.io.Resource;
import org.springframework.web.util.UriUtils;

import java.io.File;
import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
public class HomeController {
    @RequestMapping("/home")
    public String home(Model model){
        String data = "gogo";
        model.addAttribute("data", data);
        return "home";
    }
    @Value("${file.dir}")
    private String fileDir;
    @RequestMapping("/test")
    public String home(Model model, @RequestParam("fileName") List<MultipartFile> files)throws Exception{
//        if (!file.isEmpty()) {
//            String fullPath = fileDir + file.getOriginalFilename();
//            file.transferTo(new File(fullPath));
//        }
        for(MultipartFile file : files){
            if(!file.isEmpty()){
                System.out.println("데이터 있다!");
                String fullPath = fileDir + file.getOriginalFilename();
                file.transferTo(new File(fullPath));
            }else{
                System.out.println("데이터 없다");
            }
        }
        return "home";
    }
    @RequestMapping("/testDown")
    public ResponseEntity<Resource> downloadImage() throws
            MalformedURLException {
        UrlResource resource = new UrlResource("file:" +
                fileDir+"1.png");
        String encodedUploadFileName = UriUtils.encode("123123123.png",
                StandardCharsets.UTF_8);
        String contentDisposition = "attachment; filename=\"" +
                encodedUploadFileName + "\"";
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, contentDisposition)
                .body(resource);
    }
//        Path filePath = Paths.get(fileDir, "1.png");
//        return new UrlResource("file:"+fileDir+"1.png");

// storeFileName = uuid.png
// uploadFileName = 1.png
// fileStore.getFullPath(storeFileName) = fileDir+filename ex) c:/pjFile/uuid.png
    // 저장할때는 uuid.png로 저장하는구나

}
