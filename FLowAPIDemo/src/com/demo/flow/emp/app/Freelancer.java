package com.demo.flow.emp.app;

public class Freelancer extends Emp {
	int fid;

	public Freelancer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Freelancer(int id, int fid, String name) {
		super(id, name);
		this.fid=fid;
	}

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return id+" "+fid+" "+name;
	}
}
