package com.koei.data.repository;

import com.koei.dada.pojo.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @Auther: paul
 * @Date: 2018/7/30 15:53
 * @Description:
 */
public interface UserRepository  extends JpaRepository<SysUser, String> {


}
