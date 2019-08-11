package com.itdr.pojo;

import java.util.Date;

/**
 * @author Excellent吴
 * @date 2019-08-09 10:28
 */
public class Categorys {
    //分类查询的对象
    private Integer cid;
    private Integer cparentId;
    private String  cname;
    private String cstatus;
    private Integer csortOrder;
    private Date ccreateTime;
    private Date cupdateTime;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getCparentId() {
        return cparentId;
    }

    public void setCparentId(Integer cparentId) {
        this.cparentId = cparentId;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCstatus() {
        return cstatus;
    }

    public void setCstatus(String cstatus) {
        this.cstatus = cstatus;
    }

    public Integer getCsortOrder() {
        return csortOrder;
    }

    public void setCsortOrder(Integer csortOrder) {
        this.csortOrder = csortOrder;
    }

    public Date getCcreateTime() {
        return ccreateTime;
    }

    public void setCcreateTime(Date ccreateTime) {
        this.ccreateTime = ccreateTime;
    }

    public Date getCupdateTime() {
        return cupdateTime;
    }

    public void setCupdateTime(Date cupdateTime) {
        this.cupdateTime = cupdateTime;
    }

    @Override
    public String toString() {
        return "Categorys{" +
                "cid=" + cid +
                ", cparentId=" + cparentId +
                ", cname='" + cname + '\'' +
                ", cstatus='" + cstatus + '\'' +
                ", csortOrder=" + csortOrder +
                ", ccreateTime=" + ccreateTime +
                ", cupdateTime=" + cupdateTime +
                '}';
    }
}
