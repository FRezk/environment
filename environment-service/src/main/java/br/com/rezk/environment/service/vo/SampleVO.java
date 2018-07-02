package br.com.rezk.environment.service.vo;

public class SampleVO {
	
	private String key;
	private String projName;
	private String author;
	
	
	public SampleVO(){
		this.key = "Hello World!";
		this.projName = "Environment";
		this.author = "Fernando D. Rezk";
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getProjName() {
		return projName;
	}

	public void setProjName(String projName) {
		this.projName = projName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}
