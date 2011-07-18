package org.cloudfoundry.samples;

public class Trip {

	private Long id;
	
	private Long eid;
	
	private Long car_id;
	
	private Long source;
	
	private Long destination;
	
	private Long checkin_time;
	
	private Long checkout_time;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getEid() {
		return eid;
	}

	public void setEid(Long eid) {
		this.eid = eid;
	}

	public Long getCar_id() {
		return car_id;
	}

	public void setCar_id(Long car_id) {
		this.car_id = car_id;
	}

	public Long getSource() {
		return source;
	}

	public void setSource(Long source) {
		this.source = source;
	}

	public Long getDestination() {
		return destination;
	}

	public void setDestination(Long destination) {
		this.destination = destination;
	}

	public Long getCheckin_time() {
		return checkin_time;
	}

	public void setCheckin_time(Long checkin_time) {
		this.checkin_time = checkin_time;
	}

	public Long getCheckout_time() {
		return checkout_time;
	}

	public void setCheckout_time(Long checkout_time) {
		this.checkout_time = checkout_time;
	}
	
	@Override
	public String toString() {
		return "Trip [id=" + id + ", eid=" + eid + ",source=" + source  +", destination=" 
				+ destination + ", checkin_time="+ checkin_time  +", checkout_time=" + checkout_time + "]";
	}



}
