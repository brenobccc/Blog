package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		 try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} /* Aqui registra */
		PreparedStatement st = null;
		ResultSet rs = null;
		Connection conn;
		try {
			conn = DB.getConnection();
						
			List<String[]> list = new ArrayList<String[]>();
			
			
			st = conn.prepareStatement("SELECT * FROM AREA_AVALIACAO");

			rs = st.executeQuery();
			if(rs.next()) {
				do {
					System.out.print(rs.getString("NOME_AREA") + "\n");
				}while(rs.next());
			}
			
			rs.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("\n Fim requisição | consultar Areas");
		}
	}

}
