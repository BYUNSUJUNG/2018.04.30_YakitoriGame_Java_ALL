package spaceTR;

public class UserInfo {

	// getter, setter
	private String id; // 아이디
	private String password; // 비밀번호
	private String birthday; // 생년월일
	private int gender; // 성별

	public UserInfo(String id, String password, String birthday, int gender) {
		this.id = id;
		this.password = password;
		this.birthday = birthday;
		this.gender = gender;
	} // UserInfo(생성자) of end

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

} // class of end
