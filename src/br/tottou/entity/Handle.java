package br.tottou.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="handle")
public class Handle {
	
	@Id
	@GeneratedValue
	@Column(name="handle_id")
	private long handleId;
	
	@Column(name="handle")
	private String handle;
	
	@Column(name="resource_type_id")
	private long resourceType;
	

	
	
	
	
	public long getHandleId() {
		return handleId;
	}
	public void setHandleId(long handleId) {
		this.handleId = handleId;
	}
	public String getHandle() {
		return handle;
	}
	public void setHandle(String handle) {
		this.handle = handle;
	}
	public long getResourceType() {
		return resourceType;
	}
	public void setResourceType(long resourceType) {
		this.resourceType = resourceType;
	}

	
	
	

}
