package com.wonderland.server.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wonderland.server.pojo.Admin;
import com.wonderland.server.pojo.ResBean;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wonderland
 * @since 2022-02-25
 */
public interface IAdminService extends IService<Admin> {

    ResBean login(String username, String password, HttpServletRequest request);

    Admin getAdminByUserName(String username);
}
