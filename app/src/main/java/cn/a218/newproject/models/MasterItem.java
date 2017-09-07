package cn.a218.newproject.models;

import java.io.Serializable;

/**
 * @author cjq
 *
 * @description   达人item
 * 
 */
public class MasterItem implements Serializable{

	private int id;
	private String imageUrl;
	private String name = "飞得更高";
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

	public MasterItem(){}

	public MasterItem(String name) {
		this.name = name;
	}

	public MasterItem(String imageUrl, String name, String visiteNum, Integer msgNum) {
		this.imageUrl = imageUrl;
		this.name = name;
		this.visiteNum = visiteNum;
		this.msgNum = msgNum;
	}
}
