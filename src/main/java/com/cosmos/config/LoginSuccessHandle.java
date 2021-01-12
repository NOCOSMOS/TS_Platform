package com.cosmos.config;

import com.cosmos.mapper.TSMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Set;
public class LoginSuccessHandle implements AuthenticationSuccessHandler {
    @Autowired
    private TSMapper TsMapper;
    @Override

    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication)throws IOException {
        HttpSession session = request.getSession();
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();//获取用户名
        String id = userDetails.getUsername();
        session.setAttribute("id",id);
//        System.out.println(TsMapper.queryNameById("121101"));//查数据库会报错，应该是项目启动顺序问题，bean没有加载
        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        //获取到登陆者的权限，然后做跳转
        if (roles.contains("admin")){
            response.sendRedirect("/admin/index.html");
            return;
        }else if (roles.contains("staff")){
            response.sendRedirect("/staff/index.html");
            return;
        }else if (roles.contains("student")){
            response.sendRedirect("/student/index.html");
            return;
        }else {
            response.sendRedirect("/403");
        }

    }
}
