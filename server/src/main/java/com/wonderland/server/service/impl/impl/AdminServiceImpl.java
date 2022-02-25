package com.wonderland.server.service.impl.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wonderland.server.mapper.AdminMapper;
import com.wonderland.server.pojo.Admin;
import com.wonderland.server.pojo.ResBean;
import com.wonderland.server.security.JwtTokenUtil;
import com.wonderland.server.service.impl.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wonderland
 * @since 2022-02-25
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {

    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    /**
     * 登录返回token
     * */
    @Override
    public ResBean login(String username, String password, HttpServletRequest request) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        if(userDetails == null || passwordEncoder.matches(password, userDetails.getPassword())){
            return ResBean.error("用户名或密码不正确！");
        }
        if(!userDetails.isEnabled()){
            return ResBean.error("账号被禁用");
        }

        //更新security登录用户对象
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        String token = jwtTokenUtil.generateToken(userDetails);
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return ResBean.success("登录成功", tokenMap);
    }

    /**
     * 根据用户名获取用户
     * */
    @Override
    public Admin getAdminByUserName(String username){
        return adminMapper.selectOne(new QueryWrapper<Admin>().eq("username", username));
    }
}
