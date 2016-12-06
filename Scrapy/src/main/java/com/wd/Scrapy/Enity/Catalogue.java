package com.wd.Scrapy.Enity;

import java.util.Date;

public class Catalogue {
    private Integer id;

    private Integer bookId;

    private String origin_url;

	private String catalogue;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getOrigin_url() {
		return origin_url;
	}

	public void setOrigin_url(String origin_url) {
		this.origin_url = origin_url;
	}
	
    public String getCatalogue() {
        return catalogue;
    }

    public void setCatalogue(String catalogue) {
        this.catalogue = catalogue == null ? null : catalogue.trim();
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
		return "Catalogue [id=" + id + ", bookId=" + bookId + ", origin_url=" + origin_url + ", catalogue=" + catalogue
				+ ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
	}

}