package cn.a218.newproject.models;

import java.io.Serializable;

/**
 * @author cjq
 *
 * @description   舞曲分类
 * 
 */
public class DanceSort implements Serializable{

	private int id;
	private String imageUrl;
	private String name;
	private String visiteNum;
	private Integer msgNum;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVisiteNum() {
		return visiteNum;
	}

	public void setVisiteNum(String visiteNum) {
		this.visiteNum = visiteNum;
	}

	public Integer getMsgNum() {
		return msgNum;
	}

	public void setMsgNum(Integer msgNum) {
		this.msgNum = msgNum;
	}

	public DanceSort(){}

	public DanceSort(String name) {
		this.name = name;
	}

	public DanceSort(String imageUrl, String name, String visiteNum, Integer msgNum) {
		this.imageUrl = imageUrl;
		this.name = name;
		this.visiteNum = visiteNum;
		this.msgNum = msgNum;
	}
}
