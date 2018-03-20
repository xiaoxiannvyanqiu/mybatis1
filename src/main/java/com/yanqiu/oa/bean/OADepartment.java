package com.yanqiu.oa.bean;

import java.util.List;

public class OADepartment {

    private int departmentId;
    private String departmentName;
    private List<OAUser> oaUserList;

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<OAUser> getOaUserList() {
        return oaUserList;
    }

    public void setOaUserList(List<OAUser> oaUserList) {
        this.oaUserList = oaUserList;
    }


}
