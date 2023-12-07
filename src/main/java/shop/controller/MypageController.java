package shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriUtils;
import shop.domain.BasketDTO;
import shop.domain.JoinDTO;
import shop.service.LoginService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class MypageController {
    @Autowired
    LoginService loginService;
    @Value("${file.dir}")
    private String fileDir;

    @RequestMapping("/mypage")
    public String mypage(Model model){

        return "mypage";
    }

    @RequestMapping("/mypage_change")
    public String mypageChange(Model model){return "mypage_change";}

    @RequestMapping("/mypage_changeProc")
    @ResponseBody
    public void mypageChangeProc(JoinDTO joinDTO, HttpServletRequest request){
        JoinDTO user = new JoinDTO();
        HttpSession session = request.getSession();
        user = (JoinDTO) session.getAttribute("user");
        user.setPw(joinDTO.getPw());
        loginService.updateMember(user);
    }
    @RequestMapping("/mypage_basket")
    public String mypageBasket(HttpServletRequest request, Model model){
        List<BasketDTO> result = new ArrayList<>();

        result = loginService.selectBasket((JoinDTO)request.getSession().getAttribute("user"));
        model.addAttribute("baskets", result);
        return "mypage_basket";
    }
    @RequestMapping("/pictureDown")
    public ResponseEntity<Resource> downloadImage(HttpServletRequest request) throws
            MalformedURLException {
        JoinDTO joinDTO =
                (JoinDTO) request.getSession().getAttribute("user");
        String origin =  joinDTO.getPictureUuidName();
        String uuid = joinDTO.getPictureUuidName();
        UrlResource resource = new UrlResource("file:" +
                fileDir+uuid);
        String encodedUploadFileName = UriUtils.encode(origin,
                StandardCharsets.UTF_8);
        String contentDisposition = "attachment; filename=\"" +
                encodedUploadFileName + "\"";
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, contentDisposition)
                .body(resource);
    }











    @RequestMapping("/login")
    public String login(Model model){
        return "login";
    }

    @RequestMapping("/join")
    public String join(Model model){
        return "join";
    }

    @RequestMapping("/joinProc")
    @ResponseBody
    public int joinProc(JoinDTO joinDTO)throws Exception{
        MultipartFile file = joinDTO.getFileName();
        if(!file.isEmpty()){
            String originName = file.getOriginalFilename();
            int pos = originName.lastIndexOf(".");
            String ext = originName.substring(pos + 1);
            String uuid = UUID.randomUUID().toString();
            String uuidName = uuid + "." + ext;
            joinDTO.setPictureOriginName(originName);
            joinDTO.setPictureUuidName(uuidName);

            String fullPath = fileDir + uuidName;
            file.transferTo(new File(fullPath));
        }
        return loginService.join(joinDTO);
    }







    @RequestMapping("loginProc")
    @ResponseBody
    public int loginProc(JoinDTO joinDTO, Model model, HttpServletRequest request){
        JoinDTO searchResult = new JoinDTO();
        searchResult = loginService.selectMember(joinDTO);

        if(searchResult == null){
            return 0;
        }else{
            HttpSession session = request.getSession();
            session.setAttribute("user", searchResult);
            return 1;
        }
    }
    @RequestMapping("/mypage_logout")
    public String logout(HttpServletRequest request){
        request.getSession().invalidate();
        return "home";
    }


}
