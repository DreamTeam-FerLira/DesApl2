package model;

public class Category {

	private String id;
	private String categoryName;
	private String description;
	private String picture;
	private String info;
	
	
	
	/**
	 * 
	 */
	public Category() {
		this("","","", "","");
	}
	/**
	 * @param id
	 * @param categoryName
	 * @param description
	 * @param picture
	 * @param dato
	 */
	public Category(String id, String categoryName, String description, String picture, String info) {
		super();
		this.id = id;
		this.categoryName = categoryName;
		this.description = description;
		this.picture = picture;
		this.info = info;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the categoryName
	 */
	public String getCategoryName() {
		return categoryName;
	}
	/**
	 * @param categoryName the categoryName to set
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the picture
	 */
	public String getPicture() {
		return picture;
	}
	/**
	 * @param picture the picture to set
	 */
	public void setPicture(String picture) {
		this.picture = picture;
	}
	/**
	 * @return the dato
	 */
	public String getInfo() {
		return info;
	}
	/**
	 * @param dato the dato to set
	 */
	public void setInfo(String info) {
		this.info = info;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Categories [id=" + id + ", categoryName=" + categoryName + ", description=" + description + ", picture="
				+ picture + ", info=" + info + "]";
	}
	
	
	
	
	

}//End
