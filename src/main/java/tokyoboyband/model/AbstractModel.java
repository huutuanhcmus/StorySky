package tokyoboyband.model;

import java.util.ArrayList;

public abstract class AbstractModel<T> {
	private java.sql.Timestamp createdDate;
	private java.sql.Timestamp modifiedDate;
	private String createdBy;
	private String modifiedBy;
	private String search;
	
	private ArrayList<T> listResult = new ArrayList<T>();
	
	public java.sql.Timestamp getCreatedDate() {
		return createdDate;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public void setCreatedDate(java.sql.Timestamp timestamp) {
		this.createdDate = timestamp;
	}
	public java.sql.Timestamp getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(java.sql.Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public ArrayList<T> getListResult() {
		return listResult;
	}
	public void setListResult(ArrayList<T> listResult) {
		this.listResult = listResult;
	}
	
	
}
