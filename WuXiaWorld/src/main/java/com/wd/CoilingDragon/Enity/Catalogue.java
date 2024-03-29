package com.wd.CoilingDragon.Enity;

import java.util.Date;

public class Catalogue {
    private Integer id;

    private Integer bookId;

    private String originUrl;

    private String catalogue;

    private Date createTime;

    private Date updateTime;

    private String title;

    private String superTitle;

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

    public String getOriginUrl() {
        return originUrl;
    }

    public void setOriginUrl(String originUrl) {
        this.originUrl = originUrl == null ? null : originUrl.trim();
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


	public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getSuperTitle() {
        return superTitle;
    }

    public void setSuperTitle(String superTitle) {
        this.superTitle = superTitle == null ? null : superTitle.trim();
    }
    

    @Override
	public String toString() {
		return "Catalogue [id=" + id + ", bookId=" + bookId + ", originUrl=" + originUrl + ", catalogue=" + catalogue
				+ ", createTime=" + createTime + ", updateTime=" + updateTime + ", title=" + title + ", superTitle="
				+ superTitle + "]";
	}
}