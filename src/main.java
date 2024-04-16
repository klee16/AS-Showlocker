//Kel Lee
//ShowLocker


import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class main {
	

	 
	   protected static final String ResultSet = null;

	public static void main(String[] args) {
		    //Run
		   dispalyGUI();
 
	   }
	   
	   public static void  dispalyGUI(){
		   //First Page/Main
		   JFrame f=new JFrame("ShowLocker");
	    
	       f.setBounds(40,80,200,200);   
	        f.setBackground(Color.gray); 
		    JButton b=new JButton("Display Your ShowLocker");
		    
		    b.setBounds(50,200,200,50);  
		    b.addActionListener(new ActionListener(){
		    	
		
		    	public void actionPerformed(ActionEvent e){  
		    		  
		    		  JFrame frame1;//creating object of first JFrame
		    		    frame1 = new JFrame();

		    		    JTextField nameTextField;
		    	        frame1.setTitle("ShowLocker Start");//setting the title of first JFrame
		    	        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//setting default close operation
		    	        GridBagLayout bagLayout = new GridBagLayout();//creating object of GridBagLayout
		    	        GridBagConstraints bagConstraints = new GridBagConstraints();//creating object of GridBagConstratints
		    	        frame1.setSize(500, 300);//setting the size of first JFrame
		    	        frame1.setLayout(bagLayout);//setting the layout to GridBagLayout of first JFrame
		    	       
		    	       
		    	        
		    		nameTextField = new JTextField(15);
		    	        bagConstraints.gridx = 1;
		    	        bagConstraints.gridy = 0;
		    	        frame1.add(nameTextField, bagConstraints);
		    	     
		    	        //Displays Full Locker
		    		
		    		  String selectALL = nameTextField.getText().toString();//getting text of selectALL text field and storing it in a String variable
		              frameSecond(selectALL);//passing the text value to frameSecond method
		   
		    	
		        }
		    	
		    }); 
		    JPanel panel = new JPanel();
		    JLabel label = new JLabel("ShowLocker ");
		    label.setIcon(new ImageIcon(".\\ShowlockerLG.png"));
		    JTextArea text = new JTextArea();
		    text.setText("Welcome");
		    panel.setLayout(new GridBagLayout());
		      panel.add(label);
		      panel.add(text);
		      
		   
		    f.add(panel);
		    f.add(b);  
		    f.setSize(500,500);   
		    f.setVisible(true); 
		    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   
	       		   
	   }

	   
	   public static  void frameSecond(String selectALL) {

		    JFrame frame2;//creating object of second JFrame
		    DefaultTableModel defaultTableModel;//creating object of DefaultTableModel
		    JTable table;//Creating object of JTable

		    Statement statement;//Creating object of Statement class
		    
		   //setting the properties of second JFrame
	        frame2 = new JFrame("ShowLocker");
	        frame2.setLayout(new FlowLayout());
	        frame2.setSize(800, 300);
	       
	        //Setting the properties of JTable and DefaultTableModel
	        defaultTableModel = new DefaultTableModel();
	        table = new JTable(defaultTableModel);
	        table.setPreferredScrollableViewportSize(new Dimension(500, 100));
	        table.setFillsViewportHeight(true);
	        frame2.add(new JScrollPane(table));
	        defaultTableModel.addColumn("Title");
	        defaultTableModel.addColumn("Genre");
	        defaultTableModel.addColumn("EpCount");
	        defaultTableModel.addColumn("EpCompleted");
	        defaultTableModel.addColumn("ServiceName");
	        
	        
	 
		   try {
	            // The newInstance() call is a work around for some
	            // broken Java implementations

	            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
	        } catch (Exception ex) {
	            // handle the error
	        }
	    
	
		 try {
			 
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/showlocker?" +
					                               "user=root&password=password1");
			    
			    // Do something with the Connection
			    

					statement = conn.createStatement();//crating statement object
					String query = "select * from Media " ;//Storing MySQL query in A string variable
		            ResultSet resultSet = statement.executeQuery(query);//executing query and storing result in ResultSet
		            
			
				    	
			   
			          
				    
			    
			            
			    // Now do something with the ResultSet ....
				    

				    while (resultSet.next()) {
		                String Title = resultSet.getString("Title");
		                String Genre =  resultSet.getString("Genre");
		                String EpCount = resultSet.getString(String.valueOf("EpCount"));
		                String EpCompleted = resultSet.getString(String.valueOf("EpCompleted"));
		                String ServiceName= resultSet.getString("ServiceName");
		                
				 
		                //Retrieving details from the database and storing it in the String variables
		                           
		                    defaultTableModel.addRow(new Object[]{Title, Genre, EpCount, EpCompleted, ServiceName });//Adding row in Table
		                    frame2.setVisible(true);//Setting the visibility of second Frame
		                    
				    }
				   
		                    //Manage Section
		                    
		                    JLabel A= new JLabel("Manage");
		                    JButton M=new JButton("ADD");
		                    JButton D=new JButton("Delete");
		                    JButton E=new JButton("Edit");
		                    M.setBounds(50,200,200,50); 
		                    frame2.add(A);//Manage Label 
		                    frame2.add(M);//ADD
		                    D.setBounds(50,200,200,50);
		                    frame2.add(D);//Delete
		                    E.setBounds(50,200,200,50);
		                    frame2.add(E);//Edit
		                    //Manage Section End
		                    
		                    //Edit Button
		                    

                    		
		                    E.addActionListener(new ActionListener(){
		                    	public void actionPerformed(ActionEvent e) {
 		                    
		                    		Connection conn = null;
		                    		 ResultSet resultSet =null;
                    		
							try {
								conn = DriverManager.getConnection("jdbc:mysql://localhost/showlocker?" +
								           "user=root&password=password1");
							} catch (SQLException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
							
							//MAKE TEXT BOX
							 JFrame frame = new JFrame("Edit Program");

							
							 
						        JPanel panel = new JPanel();
						       JPanel panel2= new JPanel();
						        
						        
						      
						        panel.setLayout( new FlowLayout() ); 
						        panel2.setLayout( new FlowLayout()); 
						        frame.getContentPane().add( panel, "North");
						        frame.getContentPane().add( panel2, "South");
						      

						        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						        frame.setSize(1500, 800);
						        frame.getContentPane().add(panel,"North");
						        frame.setVisible(true);
						        
                    		JTextField nameTextField1;
                    		JTextField nameTextField2;
                    		JTextField nameTextField3;
                    		JTextField nameTextField4;
                    		JTextField nameTextField5;
 	
                            nameTextField1 = new JTextField(15);
                    		nameTextField2 = new JTextField(15);
                    		nameTextField3 = new JTextField(15);
                    		nameTextField4 = new JTextField(15);
                    		nameTextField5 = new JTextField(15);
                    		
                    	    JLabel Titlelbl= new JLabel("Title: ");		    		    	        
   		    	         Titlelbl.setLabelFor(nameTextField1);
   		    	         panel.add(Titlelbl);
   		    	         panel.add(nameTextField1);
   		    	        
   		    	         JLabel Genrelbl= new JLabel("Genre: ");		    		    	        
   		    	         Genrelbl.setLabelFor(nameTextField2);
   		    	         panel.add(Genrelbl);
   		    	         panel.add(nameTextField2);
   		    	         
   		    	         JLabel EpCountlbl= new JLabel("EpCount: ");		    		    	        
   		    	         EpCountlbl.setLabelFor(nameTextField3);
   		    	         panel.add(EpCountlbl);
   		    	         panel.add(nameTextField3);
   		    	         
   		    	         JLabel EpCompletedlbl= new JLabel("EpComplted: ");		    		    	        
   		    	         EpCompletedlbl.setLabelFor(nameTextField4);
   		    	         panel.add(EpCompletedlbl);
   		    	         panel.add(nameTextField4);
   		    	         
   		    	         JLabel ServiceNamelbl= new JLabel("ServiceName: ");		    		    	        
   		    	         ServiceNamelbl.setLabelFor(nameTextField5);
   		    	         panel.add(ServiceNamelbl);
   		    	         panel.add(nameTextField5);

							 JButton Up=new JButton("Update");
							 Up.setBounds(25,100,100,25);
							 panel.add(Up, "East");
			    
						        panel2.add(new JScrollPane(table));
		
							 
							                                                // Paste MyPanel2 to South
							 frame.getContentPane().add(panel2, "Center");  // Paste MyPanel2 to Center 
							
							 
							 
						     	try {
        		            		
		                    		String uTitle = nameTextField1.getText().toString();		                    		
		                    		String uGenre = nameTextField2.getText().toString();		                    		
		                    	
		                    		String uServiceName = nameTextField5.getText().toString();
						     	
		                    		  String tempRate =nameTextField3.getText().toString();
		                    	        String tempQty = nameTextField4.getText().toString();
		                    	  	
 		            			   if (tempRate != null && !tempRate.isEmpty() && !tempRate.equals("null") && tempQty != null && !tempQty.isEmpty() && !tempQty.equals("null")) {
		                    	            
		                    			   int uEpCount = Integer.parseInt(nameTextField3.getText());	
				                    		int uEpCompleted = Integer.parseInt(nameTextField4.getText());
		                    	        
 		            			   
     		            		 String query1 = "insert INTO Media(Title,Genre,EpCount,EpCompleted,ServiceName)"+
		                    				"values('"+uTitle+"','"+uGenre+"','"+uEpCount+"','"+uEpCompleted+"','"+uServiceName+"')";//Storing MySQL query in A string variable
 		            			   

     		            		  statement.executeUpdate(query1);

 		            			   }
 		            			   
                    		Up.addActionListener(new ActionListener(){
         						public void actionPerformed(ActionEvent e) {
         							
         							try {	//default title and icon
        
         								JOptionPane.showMessageDialog(frame2,
         								    "Edit Complete");
         								 frame2.setVisible(true);
         								 dispalyGUI();
         							}finally {
         								
         							}
         						}


							
         						});
		                      	} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
						     	catch (NumberFormatException n) {
   		            			 
    		                        // Print the message if exception occured
    		                        System.out.println(
    		                            "NumberFormatException occured");
    		                    }
		                    	}
		                    	
			                   });//End  of  Edit Button
                    		   		    	    
		                    
		                    //Delete Button
		                    D.addActionListener(new ActionListener(){
		                    	public void actionPerformed(ActionEvent e) {
		                    		JFrame frame = new JFrame("Delete Program");
 
								        JPanel paneld = new JPanel();
									    JPanel panel2= new JPanel();
								      
									        paneld.setLayout( new FlowLayout() ); 
									        panel2.setLayout( new FlowLayout()); 
									        frame.getContentPane().add( paneld, "North");
									        frame.getContentPane().add( panel2, "South");
							

									        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
									        frame.setSize(1500, 800);
									        frame.getContentPane().add(paneld,"North");
									        frame.setVisible(true);
		                    	
		                 		   try {
		                 	            // The newInstance() call is a work around for some
		                 	            // broken Java implementations

		                 	            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		                 	        } catch (Exception ex) {
		                 	            // handle the error
		                 	        }
		                 	    
		                 	
		                 		 try {
		                 			 
		                 				
		                 					
		                 					JTextField uSelect;
		                 					uSelect = new JTextField(15);
		                 					 JLabel Deletelbl= new JLabel("Find Program to delete: ");	
		                 					 Deletelbl.setLabelFor(uSelect);
				    		    	         paneld.add(Deletelbl);
				    		    	         JButton Up= new JButton("Update");
			                 					Up.setBounds(50,200,200,50);
			                 					paneld.add(Up);
			                 					 panel2.add(new JScrollPane(table));
			                                     frame.getContentPane().add(panel2, "Center");  // Paste MyPanel2 to Center 
				                           
				                            paneld.add(uSelect);
				                            
				                        	String Select = uSelect.getText().toString();
				                        	
		                 			    // Do something with the Connection
				                      
				                        	 String sql = "delete from media where Title = '"+Select+"'";//Storing MySQL query in A string variable"
       
				                        	statement.executeUpdate(sql);//executing query and storing result in ResultSet
				                        	
				                        	
		                 					
		                 					Up.addActionListener(new ActionListener(){
		                 						public void actionPerformed(ActionEvent e) {
		                 							
		                 							try {	//default title and icon
		                
		                 								JOptionPane.showMessageDialog(frame2,
		                 								    "Delete Complete");
		                 								 frame2.setVisible(true); 
		                 								 dispalyGUI();
		                 							}finally {
		                 								
		                 							}
		                 						}


											
		                 						});
		                 					
		                 		  
				                        
		                    	} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}finally
		                 		 {
		                    		
		                 		 }
		                    	}
		                    	
		                   });
				    //Delete Button Ends
		                    
		                    //ADD Button			                    
		                    M.addActionListener(new ActionListener(){
		                    
		                    	public void actionPerformed(ActionEvent e) { 

		 		                    
		                    		Connection conn = null;
		                    		
									try {
										conn = DriverManager.getConnection("jdbc:mysql://localhost/showlocker?" +
										           "user=root&password=password1");
									} catch (SQLException e2) {
										// TODO Auto-generated catch block
										e2.printStackTrace();
									}
									
									//MAKE TEXT BOX
									 JFrame frame = new JFrame("ADD Program");

									
									 
								        JPanel panel = new JPanel();
								        JPanel panel2= new JPanel();
								        panel.setLayout(new FlowLayout());
								        panel2.setLayout(new FlowLayout());
								        frame.getContentPane().add (panel,"North");
								        frame.getContentPane().add(panel2,"South");
								        
							
								      
								     

								        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
								        frame.setSize(1500, 800);
								        frame.getContentPane().add(panel,"North");
								        frame.setVisible(true);
								        
		                    		JTextField nameTextField1;
		                    		JTextField nameTextField2;
		                    		JTextField nameTextField3;
		                    		JTextField nameTextField4;
		                    		JTextField nameTextField5;
	
		                            nameTextField1 = new JTextField(15);
		                    		nameTextField2 = new JTextField(15);
		                    		nameTextField3 = new JTextField(15);
		                    		nameTextField4 = new JTextField(15);
		                    		nameTextField5 = new JTextField(15);
		                    			        
		    		    	        try {
		    		    	            JLabel Titlelbl= new JLabel("Title: ");		    		    	        
			    		    	         Titlelbl.setLabelFor(nameTextField1);
			    		    	         panel.add(Titlelbl);
			    		    	         panel.add(nameTextField1);
			    		    	        
			    		    	         JLabel Genrelbl= new JLabel("Genre: ");		    		    	        
			    		    	         Genrelbl.setLabelFor(nameTextField2);
			    		    	         panel.add(Genrelbl);
			    		    	         panel.add(nameTextField2);
			    		    	         
			    		    	         JLabel EpCountlbl= new JLabel("EpCount: ");		    		    	        
			    		    	         EpCountlbl.setLabelFor(nameTextField3);
			    		    	         panel.add(EpCountlbl);
			    		    	         panel.add(nameTextField3);
			    		    	         
			    		    	         JLabel EpCompletedlbl= new JLabel("EpComplted: ");		    		    	        
			    		    	         EpCompletedlbl.setLabelFor(nameTextField4);
			    		    	         panel.add(EpCompletedlbl);
			    		    	         panel.add(nameTextField4);
			    		    	         
			    		    	         JLabel ServiceNamelbl= new JLabel("ServiceName: ");		    		    	        
			    		    	         ServiceNamelbl.setLabelFor(nameTextField5);
			    		    	         panel.add(ServiceNamelbl);
			    		    	         panel.add(nameTextField5);

										 JButton U=new JButton("Update");
										 U.setBounds(50,200,200,50);
										 panel.add(U);
										 
										
										 panel2.add(new JScrollPane(table));
	                                     frame.getContentPane().add(panel2, "Center");  // Paste MyPanel2 to Center 
		            		    		    	        
		        		            	try {
		        		            		
				                    		String uTitle = nameTextField1.getText().toString();		                    		
				                    		String uGenre = nameTextField2.getText().toString();	
				                    		String uServiceName = nameTextField5.getText().toString();
				                    		
				                    		   String tempRate =nameTextField3.getText().toString();
				                    	        String tempQty = nameTextField4.getText().toString();
				                    	        
				                    	
				                    	
				                    		
		        		            		try {
		        		            			 
		        		        	
		        		            			   if (tempRate != null && !tempRate.isEmpty() && !tempRate.equals("null") && tempQty != null && !tempQty.isEmpty() && !tempQty.equals("null")) {
					                    	            
					                    			   int uEpCount = Integer.parseInt(nameTextField3.getText());	
							                    		int uEpCompleted = Integer.parseInt(nameTextField4.getText());
					                    	        
		        		            			   
			        		            		 String query1 = "insert INTO Media(Title,Genre,EpCount,EpCompleted,ServiceName)"+
	 				                    				"values('"+uTitle+"','"+uGenre+"','"+uEpCount+"','"+uEpCompleted+"','"+uServiceName+"')";//Storing MySQL query in A string variable
		        		            			   

			        		            		 statement.executeUpdate(query1);
			        		            		 conn.close();
		        		            			   }
		        		            		 
										
		        		            			
										
										  U.addActionListener(new ActionListener(){
							                    
						                    	public void actionPerformed(ActionEvent e) { 
			
						                    		JOptionPane.showMessageDialog(frame2,
		                 								    "Add Complete");
		                 								 frame2.setVisible(true);
		                 								 dispalyGUI();
												
						                    	}
										  });
										       		
				                    
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}//executing query and storing result in ResultSet
		    		    	        
		    		    	     
		        		         		}catch (NumberFormatException n) {
		        		         			 
	        		                        // Print the message if exception occured
	        		                        System.out.println(
	        		                            "NumberFormatException occured");
	        		                    }
				                    	
		    		    	        }
		    		    	    	finally {
	        		            	    System.out.println("In finally: ADD");
	        		            	    try { statement.close(); } catch (Exception e1) { /* Ignored */ }
	        		            	    try { resultSet.close(); } catch (Exception e1) { /* Ignored */ }
	        		            	    try { conn.close(); } catch (Exception e1) { /* Ignored */ }
	        		            	}
		                    	}
				          
		                    });

		                    
		 }catch (NumberFormatException | SQLException n) {
			 
             // Print the message if exception occured
             System.out.println(
                 "NumberFormatException occured");
             System.out.println(n);
         
				    }
		     
	   }
		 
}

	   

	


