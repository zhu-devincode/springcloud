package com.alibaba.springcloud.entites;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;  
import lombok.experimental.Accessors;

@AllArgsConstructor
@Data
@Accessors(chain=true)
public class Dept implements Serializable{
	
	private Long deptno;
	private String dname;
	private String db_source;
	
	public Dept() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getDeptno() {
		return deptno;
	}

	public void setDeptno(Long deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getDb_source() {
		return db_source;
	}

	public void setDb_source(String db_source) {
		this.db_source = db_source;
	}

	@Override
	public String toString() {
		return "Dept [deptno=" + deptno + ", dname=" + dname + ", db_source=" + db_source + "]";
	}
	
	

}
