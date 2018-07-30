package com.koei.dada.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @Auther: paul
 * @Date: 2018/7/30 15:25
 * @Description:
 */
@Entity
@Table(name = "sys_user")
public class SysUser {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String SysUserId;

    @Column(columnDefinition = "varchar(40) comment '用户表唯一标识'", name = "sys_user_name")
    private String SysUserName;

    @Column(columnDefinition = "int(4) comment '用户类型'", name = "sys_user_type")
    private int sysUserType;

    @Column(columnDefinition = "varchar(40) comment '用户密码'", name = "sys_user_pwd")
    private String sysUserPwd;

    @Column(columnDefinition = "int(4) comment '用户部门'", name = "sys_user_dept")
    private int sysUserDept;

    @Column(columnDefinition = "varchar(40) comment '用户表备注1'", name = "sys_user_remark1")
    private String sysUserRemark1;

    @Column(columnDefinition = "varchar(40) comment '用户表备注2'", name = "sys_user_remark2")
    private String sysUserRemark2;

    @Column(columnDefinition = "varchar(40) comment '用户表备注3'", name = "sys_user_remark3")
    private String sysUserRemark3;

    public String getSysUserId() {
        return SysUserId;
    }

    public void setSysUserId(String sysUserId) {
        SysUserId = sysUserId;
    }

    public String getSysUserName() {
        return SysUserName;
    }

    public void setSysUserName(String sysUserName) {
        SysUserName = sysUserName;
    }

    public int getSysUserType() {
        return sysUserType;
    }

    public void setSysUserType(int sysUserType) {
        this.sysUserType = sysUserType;
    }

    public String getSysUserPwd() {
        return sysUserPwd;
    }

    public void setSysUserPwd(String sysUserPwd) {
        this.sysUserPwd = sysUserPwd;
    }

    public int getSysUserDept() {
        return sysUserDept;
    }

    public void setSysUserDept(int sysUserDept) {
        this.sysUserDept = sysUserDept;
    }

    public String getSysUserRemark1() {
        return sysUserRemark1;
    }

    public void setSysUserRemark1(String sysUserRemark1) {
        this.sysUserRemark1 = sysUserRemark1;
    }

    public String getSysUserRemark2() {
        return sysUserRemark2;
    }

    public void setSysUserRemark2(String sysUserRemark2) {
        this.sysUserRemark2 = sysUserRemark2;
    }

    public String getSysUserRemark3() {
        return sysUserRemark3;
    }

    public void setSysUserRemark3(String sysUserRemark3) {
        this.sysUserRemark3 = sysUserRemark3;
    }
}
