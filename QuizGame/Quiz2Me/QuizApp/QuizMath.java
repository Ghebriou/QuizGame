 package QuizApp;

 import javax.swing.*;
 import java.awt.*;
 import java.awt.event.*;
 class RoundedCornerButton extends JButton {
	    public RoundedCornerButton(String text) {
	        super(text);
	        setContentAreaFilled(false);
	    }

	    @Override
	    protected void paintComponent(Graphics g) {
	        if (getModel().isArmed()) {
	            g.setColor(Color.lightGray);
	        } else {
	            g.setColor(getBackground());
	        }
	        g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
	        super.paintComponent(g);
	    }

	    @Override
	    protected void paintBorder(Graphics g) {
	        g.setColor(getForeground());
	        g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
	    }
	}

 public class QuizMath extends JFrame implements ActionListener {
 	String questions[][] = new String[20][5];  // Increase the array size
     String answers[][] = new String[20][2];    // Increase the array size
     String useranswers[][] = new String[20][1];  // Increase the array s

     JLabel qno, question;
     JRadioButton opt1, opt2, opt3, opt4;
     ButtonGroup groupoptions;
     RoundedCornerButton next, lifeline, submit;

     public static int timer = 15;
     public static int ans_given = 0;
     public static int count = 0;
     public static int score = 0;

     String name;
     private boolean isDifficult;

     QuizMath(String name, boolean isDifficult) {
         this.name = name;
         this.isDifficult = isDifficult;

         setBounds(0, 0, 1440, 800);
         getContentPane().setBackground(Color.WHITE);
         setLayout(null);

         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("imgs/maths.png"));
         JLabel image = new JLabel(i1);
         image.setBounds(740,-50, 400,600);
         add(image);


         qno = new JLabel("1");
         qno.setBounds(50, 105, 50, 30);
         qno.setFont(new Font("Tahoma", Font.PLAIN, 24));
         qno.setForeground(new Color(30, 144, 254));
         add(qno);

         question = new JLabel("This is Question no1");
         question.setBounds(85, 100, 800, 40);
         question.setForeground(new Color(30, 144, 254));
         question.setFont(new Font("Tahoma", Font.PLAIN, 24));
         add(question);
         // Existing questions and answers...
         if (isDifficult) {
             // Difficult level questions and answers
    

             questions[0] = new String[]{"What is the shape of a pizza slice?","Square","Triangle","Circle","Rectangle"};
             answers[0] = new String[]{"Triangle", "Triangle"};

             questions[1] = new String[]{"What is the name of a shape with five sides?","Circle","Square","Pentagon","Hexagon"};
             answers[1] = new String[]{"Pentagon", "Pentagon"};

             questions[2] = new String[]{"What do you call a shape with eight sides?","Octagon","Pentagon","Hexagon","Square"};
             answers[2] = new String[]{"Octagon", "Octagon"};

             questions[3] = new String[]{"How many sides does a triangle have?","6","8","3","10"};
             answers[3] = new String[]{"3", "3"};

             questions[4] = new String[]{"Which shape has no corners?","Rectangle","Triangle","Square","Circle"};
             answers[4] = new String[]{"Circle", "Circle"};

             questions[5] = new String[]{"What is the double of 9?","10","18","9","11"};
             answers[5] = new String[]{"18", "18"};
             
             questions[6] = new String[]{"What the result of 9 - (4+2)?", "2", "5", "3", "8"};
             answers[6] = new String[]{"3", "3"};

             questions[7] = new String[]{"How many sides does a square have?", "5", "4", "1", "2"};
             answers[7] = new String[]{"4", "4"};

             questions[8] = new String[]{"What is the name of a shape with four sides?", "Circle", "Triangle", "Square", "Rectangle"};
             answers[8] = new String[]{"Square", "Square"};

             questions[9] = new String[]{"What is the sum in degrees of the angles in a triangle?", "90", "120", "180", "360"};
             answers[9] = new String[]{"180", "180"};


         } else {
             // Easy level questions and answers
             questions[0] = new String[]{"What is the sum of 4 and 4 ?", "8", "6", "10","7"};
             answers[0] = new String[]{"8", "8"};

             questions[1] = new String[]{"What is 10 divided by 2?", "4", "5", "3", "2"};
             answers[1] = new String[]{"5","5"};

             questions[2] = new String[]{"What is 16 divided by 4 ?", "4", "6", "8", "5"};
             answers[2] = new String[]{"4","4"};

             questions[3] = new String[]{"What is the multiplication of 2 and 2 ?", "4", "5", "3", "6"};
             answers[3] = new String[]{"4", "4"};

             questions[4] = new String[]{"What is the sum of 3 and 8 ?", "12", "14", "10", "11"};
             answers[4] = new String[]{"11", "11"};

             questions[5] = new String[]{"What is the substraction of 9 and 4 ?", "5", "6", "4", "3"};
             answers[5] = new String[]{"5" , "5"};

             questions[6] = new String[]{"What is the substraction of 13 and 6 ?", "8", "7", "5", "3"};
             answers[6] = new String[]{"7" , "7"};

             questions[7] = new String[]{"What is the multiplication of 6 and 2 ?", "12", "8", "10", "14"};
             answers[7] = new String[]{"12", "12"};

             questions[8] = new String[]{"What is the sum of 13 and 4 ?", "15", "16", "17","18"};
             answers[8] = new String[]{"17", "17"};

              questions[9] = new String[]{"What is the multiplication of 3 and 3 ?", "14", "9", "13", "6"};
             answers[9] = new String[]{"9", "9"};


         }

         opt1 = new JRadioButton();
         opt1.setBounds(120, 180, 300, 30);
         opt1.setBackground(Color.WHITE);
         opt1.setForeground(new Color(23, 111, 196));
         opt1.setFont(new Font("Dialog", Font.PLAIN, 20));
         add(opt1);

         opt2 = new JRadioButton();
         opt2.setBounds(120, 220, 300, 30);
         opt2.setBackground(Color.WHITE);
         opt2.setForeground(new Color(23, 111, 196));
         opt2.setFont(new Font("Dialog", Font.PLAIN, 20));
         add(opt2);

         opt3 = new JRadioButton();
         opt3.setBounds(120, 260, 300, 30);
         opt3.setBackground(Color.WHITE);
         opt3.setForeground(new Color(23, 111, 196));
         opt3.setFont(new Font("Dialog", Font.PLAIN, 20));
         add(opt3);

         opt4 = new JRadioButton();
         opt4.setBounds(120, 300, 300, 30);
         opt4.setBackground(Color.WHITE);
         opt4.setForeground(new Color(23, 111, 196));
         opt4.setFont(new Font("Dialog", Font.PLAIN, 20));
         add(opt4);

         groupoptions = new ButtonGroup();
         groupoptions.add(opt1);
         groupoptions.add(opt2);
         groupoptions.add(opt3);
         groupoptions.add(opt4);

         next = new RoundedCornerButton("Next");
         next.setBounds(280, 400, 180, 40);
         next.setFont(new Font("Tohama", Font.PLAIN, 22));
         next.setBackground(new Color(2, 180, 254));
         next.setForeground(Color.WHITE);
         next.addActionListener(this);
         add(next);

         lifeline = new RoundedCornerButton("50,50 Lifeline");
         lifeline.setBounds(70, 400, 180, 40);
         lifeline.setFont(new Font("Tohama", Font.PLAIN, 22));
         lifeline.setBackground(Color.WHITE);
         lifeline.setForeground(new Color(2, 180, 254));
         lifeline.addActionListener(this);
         add(lifeline);

         submit = new RoundedCornerButton("Submit");
         submit.setBounds(490, 400, 180, 40);
         submit.setFont(new Font("Tohama", Font.PLAIN, 22));
         submit.setBackground(new Color(63, 195, 23));
         submit.setForeground(Color.WHITE);
         submit.addActionListener(this);
         
         add(submit);

         start(count);


         setTitle("Quiz Game");
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setSize(1200, 650);
         setLocationRelativeTo(null);
         setVisible(true);
     }

     public void actionPerformed(ActionEvent ae) {
         if (ae.getSource() == next) {
             repaint();
             opt1.setEnabled(true);
             opt2.setEnabled(true);
             opt3.setEnabled(true);
             opt4.setEnabled(true);
             
             ans_given = 1;
             if (groupoptions.getSelection() == null) {
                useranswers[count][0] = "";
             } else {
                 useranswers[count][0] = groupoptions.getSelection().getActionCommand();
             }
             
             if (count == 8) {
                 next.setEnabled(false);
                 submit.setEnabled(true);
             }
             
             count++;
             start(count);
         } else if (ae.getSource() == lifeline) {
             if (count == 2 || count == 4 || count == 6 || count == 8 || count == 9) {
                 opt2.setEnabled(false);
                 opt3.setEnabled(false);
             } else {
                 opt1.setEnabled(false);
                 opt4.setEnabled(false);
             }
             lifeline.setEnabled(false);
         } else if (ae.getSource() == submit) {
             ans_given = 1;
             if (groupoptions.getSelection() == null) {
                 useranswers[count][0] = "";
             } else {
                 useranswers[count][0] = groupoptions.getSelection().getActionCommand();
             }

          // Calculate the score when the user submits answers
             score = 0; // Reset the score before recalculating

             for (int i = 0; i <= count; i++) {
                 if (useranswers[i][0].equals(answers[i][1])) {
                     score += 10;
                 }
             }

             setVisible(false);
             new Score(name, score); // Display score in Score class
            
             //reset game values 
             timer = 20;
             ans_given = 0;
             count = 0;
             score = 0;
             useranswers = new String[20][1]; // Reset user answers array

             // Reset radio button selections and button states
             groupoptions.clearSelection();
             opt1.setEnabled(true);
             opt2.setEnabled(true);
             opt3.setEnabled(true);
             opt4.setEnabled(true);
         }
     }

     public void paint(Graphics g) {
         super.paint(g);

         if (isDifficult) {
        	 String time = "Time left " + timer + " seconds";
             g.setColor(Color.RED);
             g.setFont(new Font("Tohama", Font.BOLD, 25));

             if (timer > 0) {
                 g.drawString(time, 250, 550);
             } else {
                 g.drawString("Times up!!",280, 550);
             }

             if (isDifficult) {
                 timer--;
             }

             try {
                 Thread.sleep(1000);
                 repaint();
             } catch (Exception e) {
                 System.out.println("Any error occurred");
                 e.printStackTrace();
             }

             if (ans_given == 1) {
                 ans_given = 0;
                 timer = 15;
             }
         }

         if (timer < 0) {
             timer = 15;
             opt1.setEnabled(true);
             opt2.setEnabled(true);
             opt3.setEnabled(true);
             opt4.setEnabled(true);

             if (count == 9) {
             } else {
             }
             if (count == 8) {
                 next.setEnabled(false);
                 submit.setEnabled(true);
             } 

             if (count == 9) {
                 if (groupoptions.getSelection() == null) {
                     useranswers[count][0] = "";
                 } else {
                     useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                 }

                 for (int i = 0; i < useranswers.length; i++) {
                     if (useranswers[i][0].equals(answers[i][1])) {
                         score += 10;
                     } else {
                         score += 0;
                     }
                 }
                 setVisible(false);
               new Score(name, score);
             } else {
                 if (groupoptions.getSelection() == null) {
                     useranswers[count][0] = "";
                 } else {
                     useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                 }
                 count++;
                 start(count);
             }
         }
     }
     
     public void start(int count) {
        opt1.setEnabled(true);
        opt2.setEnabled(true);
        opt3.setEnabled(true);
        opt4.setEnabled(true);

        qno.setText("" + (count + 1) + ". ");
        question.setText(questions[count][0]);
        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);

        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);

        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);

        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);

        groupoptions.clearSelection();
    }
    
    }
    
    
    
    
     
    
    
    
    
       
    
    
    
    

 