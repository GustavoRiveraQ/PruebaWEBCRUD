	import java.sql.*;


	public class Title_Types {
		
		public static boolean insert(Connection conn, String title_no, String title) {
			PreparedStatement pst;
			boolean vret = false;
			try {
				pst = conn.prepareStatement("INSERT INTO Title_Types VALUES (?,?)" );
				pst.setString(1, title_no);
				pst.setString(2, title);
				pst.execute();
				vret = true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 

			return vret;
		}	
		
		public static String select(Connection conn, String title_no) {
			PreparedStatement pst;
			String vret = null;
			try {
				pst = conn.prepareStatement("SELECT * FROM Title_types WHERE title_no=?" );
				pst.setString(1, title_no);
				ResultSet rs = pst.executeQuery();
				rs.next();
				vret = rs.getString("title_no") + ";" + rs.getString("title");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 

			return vret;
		}
		
		public static boolean update(Connection conn, String title, String title_no) {
			PreparedStatement pst;
			boolean vret = false;
			try {
				pst = conn.prepareStatement("UPDATE Title_Types set title=? WHERE title_no=?" );
				pst.setString(1, title);
				pst.setString(2, title_no);
				pst.execute();
				vret = true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 

			return vret;
		}
		
		public static boolean delete(Connection conn, String title_no) {
			PreparedStatement pst;
			boolean vret = false;
			try {
				pst = conn.prepareStatement("DELETE FROM Title_Types where title_no=?" );
				pst.setString(1, title_no);
				pst.execute();
				vret = true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 

			return vret;
		}
		

	}
