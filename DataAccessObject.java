package com.techpalle.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.techpalle.model.Student;

public class DataAccessObject {
	private static final String url="jdbc:mysql://localhost:3306/spring";
	private static final String user="root";
	private static final String password="2313";
	private static Connection con=null;
	private static PreparedStatement ps=null;
    private static Statement st= null;
    private static ResultSet rs=null;
    private static final String insert ="insert into student (name,email,password,mobile) values (?,?,?,?)";
    private static final String select="select * from student";
    private static String delete="delete from student where id=?";
	private static String selectstudentbysno="select * from student where sno=?";
	private static String updateuser ="update student set name=?,email=?,password=?,mobile=?, where sno=?";

    public static void insertStudentDao(Student s) {
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		con=DriverManager.getConnection(url,user,password);
    		ps=con.prepareStatement(insert);
    		ps.setString(1, s.getName());
    		ps.setString(2, s.getEmail());
    		ps.setString(3, s.getPassword());
            ps.setLong(4, s.getMobile());
            ps.executeUpdate();    	}
    	catch(ClassNotFoundException e) {
    		e.printStackTrace();
    	}
    	catch(SQLException e) {
    		e.printStackTrace();
    	}
    	finally {
    		if(ps !=null) {
    			try {
    				ps.close();
    			}
    			catch(SQLException e) {
    	    		e.printStackTrace();
    	    	}
    		}
    			if(con !=null) {
        			try {
        				con.close();
        			}
        			catch(SQLException e) {
        	    		e.printStackTrace();
        	    	}

    		}
    	
    }
}
    public static ArrayList<Student> getAllStudentDao(){
    	ArrayList<Student> al=new ArrayList<Student>();
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		con=DriverManager.getConnection(url,user,password);
            st=con.createStatement();
            rs=st.executeQuery(select);
            while(rs.next()) {
            	int i=rs.getInt("sno");
            	String n=rs.getString("name");
            	String e=rs.getString("email");
            	String p=rs.getString("password");
            	long m=rs.getLong("mobile");
                Student s= new Student (i,n,e,p,m);
                al.add(s);
            }
    	}
    	catch(ClassNotFoundException e) {
    		e.printStackTrace();
    	}
    	catch(SQLException e) {
    		e.printStackTrace();
    	}
    	finally {
    		if(rs !=null) {
    			try {
    				rs.close();
    			}
    			catch(SQLException e) {
    	    		e.printStackTrace();
    	    	}
    		}if(st !=null) {
    			try {
    				st.close();
    			}
    			catch(SQLException e) {
    	    		e.printStackTrace();
    	    	}
    		}
    		
    			if(con !=null) {
        			try {
        				con.close();
        			}
        			catch(SQLException e) {
        	    		e.printStackTrace();
        	    	}

    		}
    	
    }
		return al;
    	
    }
    public static void delete(int id) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,user,password);
			ps=con.prepareStatement(delete);
			ps.setInt(1,id);
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static Student selectStudentBySno(int sno) {
		Student s=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		    con=DriverManager.getConnection(url,user,password);
			ps=con.prepareStatement(selectstudentbysno);
			ps.setInt(1, sno);
			ResultSet rs1=ps.executeQuery();
			rs1.next();
			int sno1=rs1.getInt("sno");
			String name=rs1.getString("name");
			String email=rs1.getString("email");
			String password=rs1.getString("password");
			long mobile=rs1.getLong("mobile");
			 s=new Student (sno1,name,email,password,mobile);
			

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return s;	
	} 
	public static void updateStudent(Student s) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,user,password);
			ps=con.prepareStatement(updateuser);
			ps.setString(1, s.getName());
			ps.setString(2, s.getEmail());
			ps.setString(3, s.getPassword());
			ps.setLong(4, s.getMobile());
			ps.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
	}
		finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
    }
