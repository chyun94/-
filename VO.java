package sVO;

public class VO {
	private String study_id, study_pw, study_name, city;
	public String getStudy_id() {
		return study_id;
	}
	public void setStudy_id(String study_id) {
		this.study_id = study_id;
	}
	public String getStudy_pw() {
		return study_pw;
	}
	public void setStudy_pw(String study_pw) {
		this.study_pw = study_pw;
	}
	public String getStudy_name() {
		return study_name;
	}
	public void setStudy_name(String study_name) {
		this.study_name = study_name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getJoindate() {
		return joindate;
	}
	public void setJoindate(int joindate) {
		this.joindate = joindate;
	}
	private int joindate;
}
