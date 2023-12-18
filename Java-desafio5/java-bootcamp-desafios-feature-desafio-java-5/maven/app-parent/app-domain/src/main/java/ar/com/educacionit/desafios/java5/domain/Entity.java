package ar.com.educacionit.desafios.java5.domain;

public class Entity {
	private Long id;
	private String json;
	
	public Entity(Long id, String json) {
		this.id = id;
		this.json = json;
	}
	
	public Entity(String json) {
		this.json = json;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public String getJson() {
		return json;
	}
	public void setJson(String json) {
		this.json = json;
	}
	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Entity [id=" + id + ", json=" + json + "]";
	}
	
	
	
}
