package com.wd.CoilingDragon.Enity;

import java.util.Date;

public class Content {
    private Integer id;

    private Integer catalogueId;

    private Date createTime;

    private Date updateTime;

    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCatalogueId() {
        return catalogueId;
    }



	public void setCatalogueId(Integer catalogueId) {
        this.catalogueId = catalogueId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    
    @Override
	public String toString() {
		return "Content [id=" + id + ", catalogueId=" + catalogueId + ", createTime=" + createTime + ", updateTime="
				+ updateTime + ", content=" + content + "]";
	}
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}