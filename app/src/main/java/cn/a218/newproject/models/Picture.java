package cn.a218.newproject.models;

import java.io.Serializable;

/**
 * @author cjq
 *
 * @description   图片
 * 
 */
public class Picture implements Serializable{

	private int order;
	private String alt;
	private String src;

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public String getAlt() {
		return alt;
	}

	public void setAlt(String alt) {
		this.alt = alt;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}
}
