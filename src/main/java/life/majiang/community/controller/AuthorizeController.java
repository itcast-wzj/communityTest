package life.majiang.community.controller;

import life.majiang.community.dto.AccessTokenDTO;
import life.majiang.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;
    
    @GetMapping("/callback")
    public String callback(@RequestParam("code") String code){
        // 使用java创建一个post请求: OKHttp, 传递参数(超过两个创建DTO类), 调用指定接口, 获取令牌
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri("http://localhost:8080/callback");
        accessTokenDTO.setClient_id("Iv1.32f713f8177e2e57");
        accessTokenDTO.setClient_secret("24be2535706c6540cf6be8a54f1fd9c8d74850fc");
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        String user = githubProvider.getUser(accessToken);
        System.out.println(user);
        return "index";
    }
}
