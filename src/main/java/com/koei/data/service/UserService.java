package com.koei.data.service;

import com.koei.dada.pojo.SysUser;
import com.koei.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: paul
 * @Date: 2018/7/30 15:47
 * @Description:
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public SysUser add(SysUser sysuser){
        SysUser sysUser= userRepository.save(sysuser);
        return sysUser;
    }

}
