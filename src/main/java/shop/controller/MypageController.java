package shop.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriUtils;
import shop.domain.*;
import shop.service.LoginService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;
import java.util.*;

@Controller
public class MypageController {
    @Autowired
    @Qualifier("loginServiceV2")
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
//        MultipartFile file = joinDTO.getFileName();
//        if(!file.isEmpty()){
//            String originName = file.getOriginalFilename();
//            int pos = originName.lastIndexOf(".");
//            String ext = originName.substring(pos + 1);
//            String uuid = UUID.randomUUID().toString();
//            String uuidName = uuid + "." + ext;
//            joinDTO.setPictureOriginName(originName);
//            joinDTO.setPictureUuidName(uuidName);
//
//            String fullPath = fileDir + uuidName;
//            file.transferTo(new File(fullPath));
//        }
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





    //카카오 로그인


    @GetMapping("/goKakao")
    public String goKakao(){
        return "redirect:https://kauth.kakao.com/oauth/authorize?client_id=089f7b2b7117e7dfafb58a1638cc179e&redirect_uri=http://localhost:8080/home2&response_type=code";

    }


    @GetMapping("/home2")
    public String goKakao(@RequestParam("code")String code, Model model, HttpServletRequest request){

        RestTemplate rt = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-type","application/x-www-form-urlencoded;charset=utf-8");

        MultiValueMap<String,String> params = new LinkedMultiValueMap<>();
        params.add("grant_type","authorization_code");
        params.add("client_id","089f7b2b7117e7dfafb58a1638cc179e");
        params.add("redirect_uri","http://localhost:8080/home2");
        params.add("code",code);

        HttpEntity<MultiValueMap<String,String>> kakaoTokenRequest =
                new HttpEntity<>(params,headers);

        ResponseEntity<String> response = rt.exchange(
                "https://kauth.kakao.com/oauth/token"
                , HttpMethod.POST
                ,kakaoTokenRequest
                ,String.class
        );

        ObjectMapper objectMapper = new ObjectMapper();
        OauthToken oauthToken = null;
        try{
            oauthToken = objectMapper.readValue(response.getBody(), OauthToken.class);
        }catch(JsonMappingException e){
            e.printStackTrace();
        }catch(JsonProcessingException e){
            e.printStackTrace();
        }
        System.out.println(oauthToken.getAccess_token());

        // 토큰이용해서 정보가져오기
        RestTemplate rt2 = new RestTemplate();
        HttpHeaders headers2 = new HttpHeaders();
        headers2.add("Authorization","Bearer "+oauthToken.getAccess_token());

        headers2.add("Content-type","application/x-www-form-urlencoded;charset=utf-8");


        HttpEntity<MultiValueMap<String,String>> kakaoProfileRequest =
                new HttpEntity<>(headers2);

        ResponseEntity<String> response2 = rt2.exchange(
                "https://kapi.kakao.com/v2/user/me"
                , HttpMethod.POST
                ,kakaoProfileRequest
                ,String.class
        );


        //받은 회원정보 json객체를 object로 바꾼뒤 값 꺼내기
        ObjectMapper objectMapper2 = new ObjectMapper();
        KakaoMember kakaoMember = new KakaoMember();
        Map map = new HashMap();
        Map map2 = new HashMap();
        try{
            map = objectMapper2.readValue(response2.getBody(), Map.class);
        }catch(JsonMappingException e){
            e.printStackTrace();
        }catch(JsonProcessingException e){
            e.printStackTrace();
        }
        map2 = (Map) map.get("properties");

        kakaoMember.setNickname((String)map2.get("nickname"));
        kakaoMember.setProfile_image((String)map2.get("profile_image"));

        JoinDTO kakaoJoin = new JoinDTO();
        kakaoJoin.setId(kakaoMember.getNickname()+"kakao");
        kakaoJoin.setPhone(1);
        kakaoJoin.setAddress("1");
        kakaoJoin.setPw("123");
        kakaoJoin.setMemberName(kakaoMember.getNickname());
        kakaoJoin.setBirth(1);

        if(loginService.selectMember(kakaoJoin)==null){
            loginService.join(kakaoJoin);
        }
        HttpSession session = request.getSession();
        session.setAttribute("user", kakaoJoin);
        return "home";
    }
}
