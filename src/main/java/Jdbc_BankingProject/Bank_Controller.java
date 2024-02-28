package Jdbc_BankingProject;


	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;

	public class Bank_Controller {
		public void insert(Bank bank) {
			try {
				Class.forName("org.postgresql.Driver");
				Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/Bank","postgres","root");
				
				PreparedStatement psmt=con.prepareStatement("insert into bank values(?,?,?,?,?)");
				psmt.setInt(1,bank.getId());
				psmt.setString(2, bank.getBname());
				psmt.setString(3, bank.getAddress());
				psmt.setString(4, bank.getPassword());
				psmt.setString(5, bank.getAddress());
				
				int n=psmt.executeUpdate();
				System.out.println(n+"no of record inserted");
				con.close();
				
				
			} catch (ClassNotFoundException | SQLException  e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	public void find(int id) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Bank","postgres","root");
			PreparedStatement psmt = con.prepareStatement("select * from bank where id =?");
			psmt.setInt(1, id );
			ResultSet rs = psmt.executeQuery();
			if(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5));
				
			}
			else {
				System.out.println("record not found");
			}
			con.close();
			
			int n = psmt.executeUpdate();
//			System.out.println(n+" no of records updated...");
			con.close();
				
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

		public void fetchall() {
			try {
				Class.forName("org.postgresql.Driver");
				Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Bank","postgres","root");
				PreparedStatement psmt = con.prepareStatement("select * from bank");
				ResultSet rs = psmt.executeQuery();
				while(rs.next()) {
					System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+ rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5));
				}
				
				con.close();
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		public void update(int id , String newEmail) {
			try {
				Class.forName("org.postgresql.Driver");
				Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Bank","postgres","root");
				PreparedStatement psmt = con.prepareStatement("update bank set email=? where id=?");
				psmt.setString(1,newEmail);
				psmt.setInt(2, id );
				
				int n = psmt.executeUpdate();
				System.out.println(n+" no of records updated...");
				con.close();
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		public void delete(int id) {
			try {
				Class.forName("org.postgresql.Driver");
				Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Bank","postgres","root");
				PreparedStatement psmt = con.prepareStatement("delete from bank where id =?");
				psmt.setInt(1, id);
				int n = psmt.executeUpdate();
				System.out.println(n+" no of row deleted");
			
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	}


