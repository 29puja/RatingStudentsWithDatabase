package BH40133423.CoreJava.RatingStudentsWithDatabase.BH40133423_CoreJava_RatingStudentsWithDatabase;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;  
public class CrudOp{
	void crudDistribution() {
		   Scanner in=new Scanner(System.in);
		   int cho=5;
		   while(cho!=0) {
		   System.out.println("1-Add Assignment Category.");
		   System.out.println("2-Remove Assignment Category.");
		   System.out.println("3-Display Assignment Category.");
		   System.out.println("0-Exit.");
		   
		   cho=in.nextInt();
		   switch(cho){
			   case 1:
				   addDistri();
				   break;
			   case 3:
				   disDistri();
				   break;
			   case 2:
				   //remDistri();
				   break;
			   
		   }
		   }
	}
	 void addDistri() {
		   Scanner in=new Scanner(System.in);
		   System.out.println("Enter name of Assigment category:-");
		   String na=in.next();
		   System.out.println("Enter weight of category in number out of 100:-");
		   String we=in.next();
		   ArrayList<String> Distribution= new ArrayList<String>();
		   try {
		   	Class.forName("com.mysql.jdbc.Driver");  
		   		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3309/pooja","root","pooja");  
		   		Statement stmt=con.createStatement(); 
		   		ResultSet rs=stmt.executeQuery("select * from `pooja`.`distributions`;");
		   		while(rs.next()) {  
		   			Distribution.add(rs.getString(2));  
		   		}
		   		con.close();  
		   	 }
		   	 catch(Exception e) {
		   		 System.out.println(e);
		      }
		   if(Distribution.contains(na.toString())) {
			   System.out.print("Its Already Exists.");
		   }
		   else {
		   try{  
				Class.forName("com.mysql.jdbc.Driver");  
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3309/pooja","root","pooja");  
				Statement stmt=con.createStatement(); 
				stmt.executeUpdate("INSERT INTO `pooja`.`distributions`(`Assignment_Category`,`Weight`) VALUES("+na+","+we+");");
				  con.close();
				}catch(Exception e)
			{ System.out.println(e);}  
		   System.out.println("Insertion Completed");
	   }
	 }
	 void disDistri() {
		 try {
		// Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3309/pooja","root","pooja");  
			Statement stmt=con.createStatement(); 
			ResultSet rs=stmt.executeQuery("select * from `pooja`.`distributions`;");
			System.out.println("Assignment Category---Weignt(%)");
			while(rs.next()) {  
			System.out.println(rs.getString(2)+"---"+rs.getString(3));  
			}
			con.close();  
		 }
		 catch(Exception e) {
			 System.out.println(e);
	   }
	 }
	 void remDistri() {
		 Scanner in=new Scanner(System.in);
		 try {
				//Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3309/pooja","root","pooja");  
					Statement stmt=con.createStatement(); 
					ResultSet rs=stmt.executeQuery("select * from `pooja`.`distributions`;");
					System.out.println("Srno---Assignment Category---Weignt(%)");
					while(rs.next()) {  
					System.out.println(rs.getInt(1)+"---"+rs.getString(2)+"---"+rs.getString(3));  
					}
					con.close();  
				 }
				 catch(Exception e) {
					 System.out.println(e);
			   }
		 System.out.println("Enter srno of assignment you want to remove:-");
		   int k=in.nextInt();
		   try{  
				Class.forName("com.mysql.jdbc.Driver");  
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3309/pooja","root","pooja");  
				Statement stmt=con.createStatement(); 
				stmt.executeUpdate("DELETE FROM `pooja`.`distributions` WHERE `id`="+k+";");
				  con.close();
				}catch(Exception e)
			{ System.out.println(e);}  
		   System.out.println("Deltion Completed");
		 
	 }
	 void crudAssign() {
		   Scanner in=new Scanner(System.in);
		   int cho=5;
		   while(cho!=0) {
		   System.out.println("1-Enroll Student in Subject.");
		   System.out.println("2-Remove Student.");
		   System.out.println("3-Display Assignments..");
		   System.out.println("0-Exit.");
		   
		   cho=in.nextInt();
		   switch(cho){
			   case 1:
				   enroll();
				   break;
			   case 3:
				   disass();
				   break;
			   case 2:
				   remstu();
				   break;
			   
		   }
		   }
		   
	   }
void enroll() {
	 Scanner in=new Scanner(System.in);
	   System.out.println("Enter name of Student:-");
	   String na=in.next();
	   System.out.println("Enter name of Subject ex-Coputer_Science note-If space in between subject name replace space with _(underscore):-");
	   String sa=in.next();
	   System.out.println("Enter assignment category:-");
	   
	   String ac=in.next();
	   System.out.println("Enter submission date in format of date-month-year ex-21-jul-2021:-");
	   String sd=in.next();
	   System.out.println("Enter points:-");
	   String po=in.next();
	   try{  
			//Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3309/pooja","root","pooja");  
			Statement stmt=con.createStatement(); 
			stmt.executeUpdate("INSERT INTO `pooja`.`assignments`(`student_name`,`subject`,`assignment_category`,`date_of_submission`,`points`) VALUES("+na+","+sa+","+ac+","+sd+","+po+");");
			  con.close();
			}catch(Exception e)
		{ System.out.println(e);}  
	   System.out.println("Insertion Completed");
}
void remstu() {
	
		 Scanner in=new Scanner(System.in);
		 try {
				// Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3309/pooja","root","pooja");  
					Statement stmt=con.createStatement(); 
					ResultSet rs=stmt.executeQuery("select * from `pooja`.`assignments`;");
					System.out.println("Srno---student_name---subject---assignment_category---date_of_submission---points");
					while(rs.next()) {  
					System.out.println(rs.getInt(1)+"---"+rs.getString(2)+"---"+rs.getString(3)+"---"+rs.getString(4)+"---"+rs.getString(5)+"---"+rs.getString(6));  
					}
					con.close();  
				 }
				 catch(Exception e) {
					 System.out.println(e);
			   }
		 System.out.println("Enter srno of student you want to remove:-");
		   int k=in.nextInt();
		   try{  
				Class.forName("com.mysql.jdbc.Driver");  
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3309/pooja","root","pooja");  
				Statement stmt=con.createStatement(); 
				stmt.executeUpdate("DELETE FROM `pooja`.`assignments` WHERE `id`="+k+";");
				  con.close();
				}catch(Exception e)
			{ System.out.println(e);}  
		   System.out.println("Deltion Completed");
		 
	 }
void disass() {
	 try {
			// Class.forName("com.mysql.jdbc.Driver");  
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3309/pooja","root","pooja");  
				Statement stmt=con.createStatement(); 
				ResultSet rs=stmt.executeQuery("select * from `pooja`.`assignments`;");
				System.out.println("Srno---student_name---subject---assignment_category---date_of_submission---points");
				while(rs.next()) {  
				System.out.println(rs.getInt(1)+"---"+rs.getString(2)+"---"+rs.getString(3)+"---"+rs.getString(4)+"---"+rs.getString(5)+"---"+rs.getString(6));  
				}
				con.close();  
			 }
			 catch(Exception e) {
				 System.out.println(e);
		   }
}
void cpa(String na) {
	   ArrayList<String> sub=new ArrayList<String>();
	   ArrayList<ArrayList<String> > Distribution= new ArrayList<ArrayList<String> >(); 
	   ArrayList<ArrayList<String> > Assignments= new ArrayList<ArrayList<String> >();
	   ArrayList<ArrayList<String> > Assign= new ArrayList<ArrayList<String> >();
	   try {
			// Class.forName("com.mysql.jdbc.Driver");  
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3309/pooja","root","pooja");  
				Statement stmt=con.createStatement(); 
				ResultSet rs=stmt.executeQuery("select * from `pooja`.`distributions`;");
				System.out.println("Assignment Category---Weignt(%)");
				while(rs.next()) {  
					Distribution.add(new ArrayList<String>(Arrays.asList(rs.getString(2).toString(),rs.getString(3).toString())));  
				}
				con.close();  
			 }
			 catch(Exception e) {
				 System.out.println(e);
		   }
	   try {
			// Class.forName("com.mysql.jdbc.Driver");  
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3309/pooja","root","pooja");  
				Statement stmt=con.createStatement(); 
				ResultSet rs=stmt.executeQuery("select * from `pooja`.`assignments`;");
				//System.out.println("Srno---student_name---subject---assignment_category---date_of_submission---points");
				while(rs.next()) {  
				//System.out.println(rs.getInt(1)+"---"+rs.getString(2)+"---"+rs.getString(3)+"---"+rs.getString(4)+"---"+rs.getString(5)+"---"+rs.getString(6));  
					Assignments.add(new ArrayList<String>(Arrays.asList(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6))));
				}
				con.close();  
			 }
			 catch(Exception e) {
				 System.out.println(e);
		   }
    	 for(int i=0;i<=Assignments.size()-1;i++) {
    		 if(Assignments.get(i).get(0).toString().equals(na)) {
    			 if(sub.contains(Assignments.get(i).get(1))) {
    				continue;
    			 }
    			 else {
    				 sub.add(Assignments.get(i).get(1).toString());
    			 }
    		 }
    	 }
    	 for(int k=0;k<=sub.size()-1;k++) {
    		ArrayList<String> val=new ArrayList<String>();
    		val.add(sub.get(k));
    		for(int j=0;j<=Distribution.size()-1;j++) {
					
    			double sc=0;
    			double n1=0,n2=0,n3=0;
    	 for(int i=0;i<=Assignments.size()-1;i++) {
    		
    		if(Assignments.get(i).get(0).toString().equals(na)) {
    			if(Assignments.get(i).get(1).toString().equals(sub.get(k).toString())) {
    				//System.out.println("ok");
    		       if(Assignments.get(i).get(2).toString().equals(Distribution.get(j).get(0).toString())) {
    		    	  
    		    	  n1=Double.parseDouble(Distribution.get(j).get(1).toString());
    		    	  n2=Double.parseDouble(Assignments.get(i).get(4).toString());
    		    	  n3++;
    		    	 // System.out.println(n1);
    		    	  //System.out.println(n3);
    		    	  //System.out.println(sc);
    		       }
    		    
    			}
    			
    		}
    		if(n3!=0) {
    		sc=n1/n3;
    		sc*=n2;
    		}
    	 }
    	//sc=n1/n3;
		//sc*=n2;
    	 sc/=100;
    val.add(String.valueOf(sc));
    
    		}
    		Assign.addAll(Arrays.asList(val));
    		
    	 }
    	 for(int i=0;i<=Assign.size()-1;i++) {
    		 double or=0;
    		 for(int j=1;j<=Assign.get(i).size()-1;j++) {
    			 or=or+Double.parseDouble(Assign.get(i).get(j).toString());
    		 }
    		 Assign.get(i).add(String.valueOf(or));
    	 }
    	 System.out.print("Subject--");
    	for(int i=0;i<=Distribution.size()-1;i++) {
		   if(i!=Distribution.size()-1) {
    		System.out.print(Distribution.get(i).get(0).toString()+"--");
		   }
		   else {
			   System.out.print(Distribution.get(i).get(0).toString());
			   System.out.println("--Overall Rating(%)");
		   }
	   }
    	System.out.println(Assign);
}
void cpp(String sna) {
	   ArrayList<String> sub=new ArrayList<String>();
	   ArrayList<ArrayList<String> > Assign= new ArrayList<ArrayList<String> >();
	   ArrayList<ArrayList<String> > Distribution= new ArrayList<ArrayList<String> >(); 
	   ArrayList<ArrayList<String> > Assignments= new ArrayList<ArrayList<String> >();
	   try {
			// Class.forName("com.mysql.jdbc.Driver");  
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3309/pooja","root","pooja");  
				Statement stmt=con.createStatement(); 
				ResultSet rs=stmt.executeQuery("select * from `pooja`.`distributions`;");
				System.out.println("Assignment Category---Weignt(%)");
				while(rs.next()) {  
					Distribution.add(new ArrayList<String>(Arrays.asList(rs.getString(2).toString(),rs.getString(3).toString())));  
				}
				con.close();  
			 }
			 catch(Exception e) {
				 System.out.println(e);
		   }
	   try {
			// Class.forName("com.mysql.jdbc.Driver");  
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3309/pooja","root","pooja");  
				Statement stmt=con.createStatement(); 
				ResultSet rs=stmt.executeQuery("select * from `pooja`.`assignments`;");
				//System.out.println("Srno---student_name---subject---assignment_category---date_of_submission---points");
				while(rs.next()) {  
				//System.out.println(rs.getInt(1)+"---"+rs.getString(2)+"---"+rs.getString(3)+"---"+rs.getString(4)+"---"+rs.getString(5)+"---"+rs.getString(6));  
					Assignments.add(new ArrayList<String>(Arrays.asList(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6))));
				}
				con.close();  
			 }
			 catch(Exception e) {
				 System.out.println(e);
		   }
	   for(int i=0;i<=Assignments.size()-1;i++) {
  		 if(Assignments.get(i).get(1).toString().equals(sna)) {
  			 if(sub.contains(Assignments.get(i).get(0))) {
  				continue;
  			 }
  			 else {
  				 sub.add(Assignments.get(i).get(0).toString());
  			 }
  		 }
  	 }
	   for(int k=0;k<=sub.size()-1;k++) {
   		ArrayList<String> val=new ArrayList<String>();
   		val.add(sub.get(k));
   		for(int j=0;j<=Distribution.size()-1;j++) {
					
   			double sc=0;
   			double n1=0,n2=0,n3=0;
   	 for(int i=0;i<=Assignments.size()-1;i++) {
   		
   		if(Assignments.get(i).get(1).toString().equals(sna)) {
   			if(Assignments.get(i).get(0).toString().equals(sub.get(k).toString())) {
   				//System.out.println("ok");
   		       if(Assignments.get(i).get(2).toString().equals(Distribution.get(j).get(0).toString())) {
   		    	  
   		    	  n1=Double.parseDouble(Distribution.get(j).get(1).toString());
   		    	  n2=Double.parseDouble(Assignments.get(i).get(4).toString());
   		    	  n3++;
   		    	  //System.out.println(n1);
   		    	  //System.out.println(n3);
   		    	  //System.out.println(sc);
   		       }
   		    
   			}
   			
   		}
   		if(n3!=0) {
   		sc=n1/n3;
   		sc*=n2;
   		}
   	 }
   	//sc=n1/n3;
		//sc*=n2;
   	 sc/=100;
   val.add(String.valueOf(sc));
   
   		}
   		Assign.addAll(Arrays.asList(val));
   		
   	 }
   	 for(int i=0;i<=Assign.size()-1;i++) {
   		 double or=0;
   		 for(int j=1;j<=Assign.get(i).size()-1;j++) {
   			 or=or+Double.parseDouble(Assign.get(i).get(j).toString());
   		 }
   		 Assign.get(i).add(String.valueOf(or));
   	 }
   	System.out.print("Student Name--");
    	for(int i=0;i<=Distribution.size()-1;i++) {
		   if(i!=Distribution.size()-1) {
    		System.out.print(Distribution.get(i).get(0).toString()+"--");
		   }
		   else {
			   System.out.print(Distribution.get(i).get(0).toString());
			   System.out.println("--Overall Rating(%)");
		   }
	   }
    	System.out.println(Assign);
}
	public static void main(String[]args) {
		CrudOp c=new CrudOp();
		Scanner in=new Scanner(System.in);
    	int choo=5;
    	while(choo!=0) {
    	System.out.println("1-Add/Remove Assignment Category.");
    	System.out.println("2-Enroll/Remove Students from Assignment.");
    	System.out.println("3-Compute & display student average score per assignment category &overall  rating for assigned subject");
    	System.out.println("4-Compute & Display subject average score per assignment category &overall rating for assigned student");
        choo=in.nextInt();
    	switch(choo) {
    	case 1:
    		c.crudDistribution();
    		break;
    	case 2:
    		c.crudAssign();
    		break;
    	case 3:
    		System.out.println("Enter the name of student:");
    		String name=in.next();
    		c.cpa(name);
    		break;
    	case 4:
    		System.out.println("Enter name of Subject ex-Coputer_Science note-If space in between subject name replace space with _(underscore):");
    		String sna=in.next();
    		//System.out.print(sna);
    		c.cpp(sna);
    		break;
    	}
    	
    	}
    }


}
