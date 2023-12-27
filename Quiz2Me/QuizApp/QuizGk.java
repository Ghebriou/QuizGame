 package QuizApp;
 import javax.swing.*;
 import java.awt.*;
 import java.awt.event.*;

 public class QuizGk extends JFrame implements ActionListener {
	 String questions[][] = new String[20][5];  // Increase the array size
     String answers[][] = new String[20][2];    // Increase the array size
     String useranswers[][] = new String[20][1];  // Increase the array s

     JLabel qno, question;
     JRadioButton opt1, opt2, opt3, opt4;
     ButtonGroup groupoptions;
     JButton next, lifeline, submit;

     public static int timer = 20;
     public static int ans_given = 0;
     public static int count = 0;
     public static int score = 0;

     String name;// Store user's name
     private boolean isDifficult;

     QuizGk(String name, boolean isDifficult) {
         this.name = name;
         this.isDifficult = isDifficult;

         setBounds(0, 0, 1440, 800);
         getContentPane().setBackground(Color.WHITE);
         setLayout(null);

         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("imgs/mapp.jpg"));
         JLabel image = new JLabel(i1);
         image.setBounds(300, 0, 1440, 780);
         add(image);

         qno = new JLabel("1");
         qno.setBounds(50, 105, 50, 30);
         qno.setFont(new Font("Tahoma", Font.PLAIN, 27));
         qno.setForeground(Color.BLUE);
         add(qno);

         question = new JLabel("This is Question no1");
         question.setBounds(85, 100, 800, 40);
         question.setForeground(Color.BLUE);
         question.setFont(new Font("Tahoma", Font.PLAIN, 27));
         add(question);
         // Existing questions and answers...
         if (isDifficult) {
             // Difficult level questions and answers
    

             questions[0] = new String[]{"What is the purpose of the heart in the human body?", "Pump blood", "Digest food", "Exchange oxygen and carbon dioxide", "Filter blood"};
             answers[0] = new String[]{"Pump blood", "Pump blood"};

             questions[1] = new String[]{"What is the process by which solid ice turns directly into water ?", "Evaporation", "Melting", "Sublimation", "Condensation"};
             answers[1] = new String[]{"Melting", "Melting"};

             questions[2] = new String[]{"Which gas is essential for photosynthesis in plants?", "Hydrogen", "Carbon Dioxide", "Nitrogen", "Oxygen"};
             answers[2] = new String[]{"Oxygen", "Oxygen"};

             questions[3] = new String[]{"What is the largest land animal?", "Elephant", "Giraffe", "Rhino", "Hippopotamus"};
             answers[3] = new String[]{"Elephant", "Elephant"};

             questions[4] = new String[]{"What is the purpose of the liver in the human body?", "Digest food", "Filter blood", "Pump blood", "Exchange oxygen and carbon dioxide"};
             answers[4] = new String[]{"Filter blood", "Filter blood"};
         
             questions[5] = new String[]{"How many hearts does an octopus have?", "2", "1", "3", "0"};
             answers[5] = new String[]{"3", "3"};

             questions[6] = new String[]{"Which of these is an example of a liquid?", "Ice", "Juce", "Air", "Wood"};
             answers[6] = new String[]{"Juce", "Juce"};

             questions[7] = new String[]{"Which gas makes up the majority of Earth's atmosphere?", "Oxygen", "Nitrogen", "Carbon Dioxide", "Hydrogen"};
             answers[7] = new String[]{"Nitrogen", "Nitrogen"};

             questions[8] = new String[]{"What is the unit of measurement for time?", "Meters", "Seconds", "Kilograms", "Liters"};
             answers[8] = new String[]{"Seconds", "Seconds"};

             questions[9] = new String[]{"What happens to a balloon when you blow air into it?", "It stays the same", "It changes color", "It gets heavier", "It gets lighter"};
             answers[9] = new String[]{"It gets lighter", "It gets lighter"};


         } else {
             // Easy level questions and answers
             questions[0] = new String[]{"What gas do we breathe in to stay alive?", "Nitrogen", "Oxygen", "Carbon Dioxide", "Hydrogen"};
             answers[0] = new String[]{"Oxygen", "Oxygen"};

             questions[1] = new String[]{"What is the process by which plants make their own food using sunlight?", "Respiration", "Transpiration", "Photosynthesis", "Digestion"};
             answers[1] = new String[]{"Photosynthesis", "Photosynthesis"};

             questions[2] = new String[]{"What do we call animals that eat both plants and meat?", "Herbivores", "Carnivores", "Omnivores", "Insectivores"};
             answers[2] = new String[]{"Omnivores", "Omnivores"};

             questions[3] = new String[]{"What is the largest mammal on Earth?", "Elephant", "Giraffe", "Blue Whale", "Hippopotamus"};
             answers[3] = new String[]{"Blue Whale", "Blue Whale"};

             questions[4] = new String[]{"In the human body, what is the function of the lungs?", "Pump blood", "Filter waste", "Exchange oxygen and carbon dioxide", "Digest food"};
             answers[4] = new String[]{"Exchange oxygen and carbon dioxide", "Exchange oxygen and carbon dioxide"};

             questions[5] = new String[]{"What is the process by which a liquid turns into a gas at temperatures below its boiling point?", "Melting", "Evaporation", "Sublimation", "Condensation"};
             answers[5] = new String[]{"Evaporation", "Evaporation"};

             questions[6] = new String[]{"What part of a plant absorbs water and nutrients from the soil?", "Leaves", "Stem", "Roots", "Flower"};
             answers[6] = new String[]{"Roots", "Roots"};

             questions[7] = new String[]{"What force pulls objects toward the center of the Earth?", "Magnetism", "Friction", "Gravity", "Air resistance"};
             answers[7] = new String[]{"Gravity", "Gravity"};

             questions[8] = new String[]{"Which of these materials is a good conductor of electricity?", "Wood", "Rubber", "Metal", "Plastic"};
             answers[8] = new String[]{"Metal", "Metal"};

             questions[9] = new String[]{"Which part of your body helps you smell different scents?", "Eyes", "Nose", "Mouth", "Ears"};
             answers[9] = new String[]{"Nose", "Nose"};


         }

         opt1 = new JRadioButton();
         opt1.setBounds(120, 180, 300, 30);
         opt1.setBackground(Color.WHITE);
         opt1.setFont(new Font("Dialog", Font.PLAIN, 20));
         add(opt1);

         opt2 = new JRadioButton();
         opt2.setBounds(120, 220, 300, 30);
         opt2.setBackground(Color.WHITE);
         opt2.setFont(new Font("Dialog", Font.PLAIN, 20));
         add(opt2);

         opt3 = new JRadioButton();
         opt3.setBounds(120, 260, 300, 30);
         opt3.setBackground(Color.WHITE);
         opt3.setFont(new Font("Dialog", Font.PLAIN, 20));
         add(opt3);

         opt4 = new JRadioButton();
         opt4.setBounds(120, 300, 300, 30);
         opt4.setBackground(Color.WHITE);
         opt4.setFont(new Font("Dialog", Font.PLAIN, 20));
         add(opt4);

         groupoptions = new ButtonGroup();
         groupoptions.add(opt1);
         groupoptions.add(opt2);
         groupoptions.add(opt3);
         groupoptions.add(opt4);

         next = new JButton("Next");
         next.setBounds(280, 450, 180, 40);
         next.setFont(new Font("Tohama", Font.PLAIN, 22));
         next.setBackground(Color.yellow);
         next.setForeground(Color.black);
         next.addActionListener(this);
         add(next);

         lifeline = new JButton("50,50 Lifeline");
         lifeline.setBounds(70, 450, 180, 40);
         lifeline.setFont(new Font("Tohama", Font.PLAIN, 22));
         lifeline.setBackground(new Color(30, 144, 255));
         lifeline.setForeground(Color.yellow);
         lifeline.addActionListener(this);
         add(lifeline);

         submit = new JButton("Submit");
         submit.setBounds(490, 450, 180, 40);
         submit.setFont(new Font("Tohama", Font.PLAIN, 22));
         submit.setBackground(Color.cyan);
         submit.setForeground(Color.green);
         submit.addActionListener(this);
         submit.setEnabled(false);
         add(submit);

         start(count);


         setTitle("Quiz Game");
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setExtendedState(JFrame.MAXIMIZED_BOTH);
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
             score = 0;  

             for (int i = 0; i <= count; i++) {
                 if (useranswers[i][0].equals(answers[i][1])) {
                     score += 10;
                 }
             }

             setVisible(false);
             new Score(name, score);
             //  reset game values 
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
                 g.drawString(time, 280, 600);
             } else {
                 g.drawString("Times up!!",280, 600);
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