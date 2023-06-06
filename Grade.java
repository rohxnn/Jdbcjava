package School;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Grade {
	static Scanner sc=new Scanner(System.in);
	static encap e=new encap();
	static Grade g=new Grade();
	int x_id=0;
	int y_id=0;
	int f=0;
	void login(String n,int p)
	{
		e.setS_name(n);
		e.setS_pass(p);
		e.setT_name(n);
		e.setT_pass(p);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");		
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","root");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select roll_no from student where s_name='"+e.getS_name()+"' and s_password='"+e.getS_pass()+"'");
			Statement stmt1=con.createStatement();
			ResultSet rs1=stmt1.executeQuery("select t_id from teacher where t_name='"+e.getT_name()+"' and t_password='"+e.getT_pass()+"'");
			if(n.equals(e.getS_name())&& p==e.getS_pass())
			{
				while(rs.next())
				{
					System.out.println("login succesfulll");
					x_id=rs.getInt("roll_no");
//					System.out.println(x_id);
					this.s_log(x_id);
					break;
				}
			}
			else {
				System.out.println("sorry no element register");
			}
				if(n.equals(e.getT_name())&&p==e.getT_pass())
				{
				
					while(rs1.next())
					{
						System.out.println("login succesfull");
						y_id=rs1.getInt("t_id");
						this.t_log(y_id);
						String upd;
						System.out.println("do you want to update if yes press Y if no press N");
						upd=sc.next();
						while(upd.equals("Y")||upd.equals("y"))
						{
//							System.out.println(x_id);
							this.update(x_id,y_id);
					}				
					
					
					}}
				else
				{
					System.out.println("sorry there is no file available register new");}}
							
			
		
		 catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
	}
	void s_reg(String s,int p,int ps)
	{
		e.setS_name(s);
		e.setPh_no(p);
		e.setS_pass(ps);
		try {		Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","root");
				PreparedStatement stmt=con.prepareStatement("insert into student (s_name,ph_no,s_password)values('"+e.getS_name()+"','"+e.getPh_no()+"','"+e.getS_pass()+"')");
				int i=stmt.executeUpdate();
//				System.out.println(i);

			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	void t_reg(String s,int p)
	{
		e.setT_name(s);
		e.setT_pass(p);
		try {		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","root");
		PreparedStatement stmt=con.prepareStatement("insert into student(t_name,t_password) values('"+e.getT_name()+"','"+e.getT_pass()+"')");
		int i=stmt.executeUpdate();
//		System.out.println(i);

	
} catch (Exception e) {
	// TODO: handle exception
	System.out.println(e);
}
	}
	void upd_sph(String s,int p)
	{
		 try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","root");
				PreparedStatement stmt=con.prepareStatement("update student set ph_no='"+p+"'where s_name= '"+s+"'");
				int i=stmt.executeUpdate();
//				System.out.println(i);
			} catch (Exception e) {
				System.out.println(e);
				// TODO: handle exception
			}
	}
	void upd_spass(String s,int p)
	{
		 try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","root");
				PreparedStatement stmt=con.prepareStatement("update student set s_password='"+p+"'where s_name= '"+s+"'");
				int i=stmt.executeUpdate();
//				System.out.println(i);
			} catch (Exception e) {
				System.out.println(e);
				// TODO: handle exception
			}
	}
	void mark(int x_id,int y_id)
	{
		System.out.println(x_id+" "+y_id);
		
				
			System.out.println("|---------------MARK UPDATION-----------|");
			System.out.println("enter the English mark");
			int eng=sc.nextInt();
			System.out.println("enter the maths mark");
			int math=sc.nextInt();
			System.out.println("enter the physics mark");
			int phy=sc.nextInt();
			System.out.println("enter the chemistry mark");
			int chem=sc.nextInt();
			System.out.println("enter the   c++ mark");
			int cse=sc.nextInt();
			e.setEng(eng);
			e.setMath(math);
			e.setPhy(phy);
			e.setChem(chem);
			e.setCplus(cse);
			try {		Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","root");
			PreparedStatement stmt=con.prepareStatement("insert into marklist values('"+x_id+"','"+y_id+"','"+e.getEng()+"','"+e.getMath()+"','"+e.getPhy()+"','"+e.getChem()+"','"+e.getCplus()+"')");
			int i=stmt.executeUpdate();
//			System.out.println(i);

		
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println(e);
	}
			

	}
	void s_rem(String s)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","root");
			PreparedStatement stmt=con.prepareStatement("delete from student where name='"+s+"'");
			int i=stmt.executeUpdate();
//			System.out.println(i);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	void s_upd(int x,int y)
	{

	System.out.println("enter the name of the student whom you want to update");
	String ng=sc.next();
	try {
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","root");
	Statement stmt3=con.createStatement();
	ResultSet rs3=stmt3.executeQuery("select roll_no from student where s_name='"+ng+"'");
	

	while(rs3.next())
	{
	
		x=rs3.getInt("roll_no");
//		System.out.println(x);
		}
		
	 }catch (Exception e) {
		// TODO: handle exception
	System.out.println(e);}
//		System.out.println(x_id);
		int ch1;
		do
		{
		   System.out.println("|--------------------STUDENT UPDATE--------------|");
		   System.out.println("|--------------------1.UPDATE PH_NO--------------|");
		   System.out.println("|--------------------2.CHANGE PASSWORD-----------|");
		   System.out.println("|--------------------3.UPDATE MARK---------------|");
		   System.out.println("|--------------------4.REMOVE STUDENT------------|");
		   System.out.println("|--------------------5.EXIT----------------------|");
		   System.out.println("|----------------Enter your choice---------------|");
		   ch1=sc.nextInt();
		   switch(ch1)
		   {
		   case 1:System.out.println("enter the name where you want to update your phone number");
		   String na=sc.next();
		   System.out.println("enter the new phone number");
		   int po=sc.nextInt();
		   g.upd_sph(na, po);
		   break;
		   case 2:System.out.println("enter the name where you want to change your password");
		   String ns=sc.next();
		   System.out.println("enter the new password in integer only");
		   int pss=sc.nextInt();
		   g.upd_spass(ns, pss);
		   break;
		   case 3:g.mark(x,y);
		   		break;
		   case 4:System.out.println("enter the name you want to delete");
		   			String nr=sc.next();
		   			g.s_rem(nr);
		   			break;
		   case 5:System.out.println("thank you your details are uploaded");
		   	break;
		   	default:System.out.println("wrong input try again");
			   		
		   }}while(ch1<5);
	}
	void upd_tp(String s,int p)
	{
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","root");
				PreparedStatement stmt=con.prepareStatement("update teacher set t_password='"+p+"'where t_name= '"+s+"'");
				int i=stmt.executeUpdate();
//				System.out.println(i);
			} catch (Exception e) {
				System.out.println(e);
				// TODO: handle exception
			}
		
	}
	void del_t(String s)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","root");
			PreparedStatement stmt=con.prepareStatement("delete from teacher where name='"+s+"'");
			int i=stmt.executeUpdate();
//			System.out.println(i);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	void upd_t(int x)
	{
		int ch1;
		System.out.println("enter the name of the teacher whom you want to update");
		String ng=sc.next();
		try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","root");
		Statement stmt3=con.createStatement();
		ResultSet rs3=stmt3.executeQuery("select roll_no from teacher where t_name='"+ng+"'");

		while(rs3.next())
		{
		
			y_id=rs3.getInt("t_id");
//			System.out.println(y_id);
			}
			
		 }catch (Exception e) {
			// TODO: handle exception
		System.out.println(e);}
		do
		{
		   System.out.println("|--------------------TEACHER UPDATE--------------|");
		   System.out.println("|--------------------1.CHANGE PASSWORD-----------|");
		   System.out.println("|--------------------2.REMOVE STUDENT------------|");
		   System.out.println("|--------------------3.EXIT----------------------|");
		   System.out.println("|----------------Enter your choice---------------|");
		   ch1=sc.nextInt();
		   switch(ch1)
		   {
		   case 1:System.out.println("enter the name where you want to update the password");
		   String na=sc.next();
		   System.out.println("enter the new password");
		   g.upd_tp(na, ch1);
		   break;
		   case 2:System.out.println("enter the name where you want to remove");
		   String ns=sc.next();
		   g.del_t(ns);
		   break;
		   case 3:System.out.println("thank you your details are updated");
		   		break;
		   default:System.out.println("wrong input");
		   }
	}while(ch1<3);}
	void update(int x_id,int y_id)
	{
		int ch2;
		do
		{
		   System.out.println("|--------------------1.UPDATE STUDENT------------|");
		   System.out.println("|--------------------2.UPDATE TEACHER------------|");
		   System.out.println("|--------------------3.EXIT----------------------|");
		   System.out.println("|----------------Enter your choice---------------|");
		   ch2=sc.nextInt();
		   switch(ch2)
		   {
		 case 1:g.s_upd(x_id,y_id);
	   		break;
	   case 2:g.upd_t(y_id);
	   			break;
	   case 3: System.out.println("thank youuu");
	   break;
	   default:System.out.println("sorry wrong input");
	   		
	   }
	}while(ch2<3);
	}
	 void reg()
	{
		int cho;
		do
		{
		   System.out.println("|--------------------REGISTRATION----------------|");
		   System.out.println("|--------------------1.STUDENT REG---------------|");
		   System.out.println("|--------------------2.TEACHER REG---------------|");
		   System.out.println("|--------------------3.EXIT----------------------|");
		   System.out.println("|----------------Enter your choice---------------|");
		   cho=sc.nextInt();
		   switch(cho)
		   {
		   case 1:System.out.println("Enter you name");
		   		String sname=sc.next();
		   		System.out.println("Enter your mobile number");
		   		int ph=sc.nextInt();
		   		System.out.println("Enter a Password which is Strong");
		   		int pas=sc.nextInt();
		   		g.s_reg(sname,ph,pas);

		   		break;
		   case 2:System.out.println("Enter you Name");
		   			String tn=sc.next();
		   			System.out.println("enter your password");
		   			int pt=sc.nextInt();
		   			g.t_reg(tn, pt);
		   			break;
		   case 3: System.out.println("thank youuu");
		   break;
		   default:System.out.println("sorry wrong input");
		   		
		   }
		}while(cho<3);
	}
	
	void s_log(int x)
	{		
			try {Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","root");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select student.roll_no,student.s_name,student.ph_no,marklist.English,marklist.maths,marklist.physics,marklist.chemistry,marklist.cpp from student inner join marklist on student.roll_no=marklist.roll_no where student.roll_no='"+x+"'");
			while(rs.next())
			{
				System.out.println("roll_no:"+rs.getInt("student.roll_no")+" "+"Name:"+rs.getString("student.s_name")+" "+"ph_no:"+rs.getInt("student.ph_no")+" "+"English:"+rs.getInt("marklist.English")+" "+"Maths:"+rs.getInt("marklist.maths")+" "+"Physics:"+rs.getInt("marklist.physics")+" "+"Chemistry:"+rs.getInt("marklist.chemistry")+" "+"Cpp:"+rs.getInt("marklist.cpp"));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	void t_log(int y)
	{
//		System.out.println(y);
		try {Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","root");
		PreparedStatement stmt=con.prepareStatement("select * from teacher where t_id='"+y+"'");
		ResultSet rs=stmt.executeQuery();
		while(rs.next())
		{
			System.out.println("teacher's id:"+rs.getInt("t_id")+" "+" teacher name:"+rs.getString("t_name"));
		}
		
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println(e);
	}
	}
	public static void main(String[] args) {
		
		int ch;
		System.out.println(" ___________________________________________");
		System.out.println("|___________________MENU____________________|");
		System.out.println("|----------------1.LOGIN--------------------|");
		System.out.println("|----------------2.REGISTER-----------------|");
		System.out.println("|----------------3.EXIT---------------------|");
		System.out.println("|___________________________________________|");
		System.out.println("--------------Enter you choice please--------");
		ch=sc.nextInt();
		switch(ch)
		{
		case 1:System.out.println("USER NAME:");
				String n=sc.next();
				System.out.println("PASSWORD");
				int p=sc.nextInt();
				g.login(n, p);
				break;
		case 2:
			System.out.println("enter the password");
			int decrypt=sc.nextInt();
			if(e.getEncrypt()==decrypt)
			{
				g.reg();
			}
			else
			{
				System.out.println("sorry wrong password try again");
			}
			break;
			
			
			   
				
		}
		
	}
}
