package spaceTR;

import java.sql.*;

public class UserInfoDAO {
	/*
	CREATE TABLE MEMBER(
    id varchar2(12) NOT NULL, --아이디
    password varchar2(12) NOT NULL, --비밀번호
    birthday varchar2(11) NOT NULL, -- 생년월일
    gender varchar2(1) NOT NULL -- 성별
	)
	 * */
	
	// DB login information
	String url = "jdbc:mariadb://localhost:3306/tu";
	String id = "root";
	String pw = "8498";
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

	// connection database
	public void con() throws Exception {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			con = DriverManager.getConnection(url, id, pw);
			// System.out.println("오라클 접속성공");
		} catch (Exception e) {
			System.out.println(e + "-> 오라클 접속실패");
		}
	} // conMethod of end

	// Method Overloading
	public void insertMembre(String id, String password, String birthday, int gender) {

	}

	// insert
	public void insertMember(UserInfo user) throws Exception {
		con();
		try {
			String sql = "insert into member values(?,?,?,?)";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getBirthday());
			if (user.getGender() == 1)
				pstmt.setString(4, "M");
			else if (user.getGender() == 2)
				pstmt.setString(4, "W");

			pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println(e + "-> 입력 실패");
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch (Exception ignore) {
			}
		}
	} // insertMemberMethod of end

	// update
	public void updateMember(UserInfo user) throws Exception {
		con();
		try {
			String sql = "update member set password=?, birthday=?, gender=? where id=?";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, user.getPassword());
			pstmt.setString(2, user.getBirthday());
			if (user.getGender() == 1)
				pstmt.setString(3, "M");
			else if (user.getGender() == 2)
				pstmt.setString(3, "W");
			pstmt.setString(4, user.getId());

			pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println(e + "-> 수정 실패");
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch (Exception ignore) {
			}
		}
	} // updateMemberMethod of end

	// delete
	public void deleteMember(String id) throws Exception {
		con();
		try {
			String sql = "delete from member where id=?";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, id);
			
			pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println(e + "-> 삭제 실패");
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch (Exception ignore) {
			}
		}
	} // deleteMemberMethod of end

	// id duplicate check
	public boolean checkId(String id) throws Exception {
		con();
		try {
			String sql = "select * from member where id=?";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				String chid = rs.getString("id");

				if (chid.equals(id)) {
					return true;
				} else {
					return false;
				}
			}

		} catch (Exception e) {
			
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch (Exception ignore) {
			}
		}
		return false;
	} // checkIdMethod of end

	// login
	public boolean login(String id, String password) throws Exception {
		con();
		try {
			String sql = "select password from member where id=?";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {

				String pw = rs.getString("password");

				if (pw.equals(password)) {
					return true;
				}
				return false;
			} else {
				return false;
			}

		} catch (Exception e) {
			System.out.println(e + "-> 로그인 실패");
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch (Exception ignore) {
			}
		}
		return false;
	} // loginMethod of end

} // class of end
