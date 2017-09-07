package cn.a218.newproject.models;

import java.io.Serializable;

/**
 * @author cjq
 *
 * @description   视频信息
 * 
 */
public class VideoMsg implements Serializable{

	private int id;
	private String imageUrl;
	private String name="五月初五";
	private String visiteNum;
	private Integer msgNum;
	private Boolean iSplaying = false;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public Boolean getiSplaying() {
		return iSplaying;
	}

	public void setiSplaying(Boolean iSplaying) {
		this.iSplaying = iSplaying;
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

	public VideoMsg(){}

	public VideoMsg( String name){
		this.name = name;
	}

	public VideoMsg(String imageUrl, String name, String visiteNum, Integer msgNum) {
		this.imageUrl = imageUrl;
		this.name = name;
		this.visiteNum = visiteNum;
		this.msgNum = msgNum;
	}
}
