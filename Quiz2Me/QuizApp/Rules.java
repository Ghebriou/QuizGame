package QuizApp;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
class RoundButton extends JButton {

    public RoundButton(String label) {
        super(label);
        setFocusPainted(false);
        setContentAreaFilled(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(new Color(30, 144, 254));
        } else {
            g.setColor(getBackground());
        }

        g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);

        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
    }
}

class Rules extends JFrame implements ActionListener {

	 String name;
	    RoundButton start, back;

    Rules(String name) {
    	this.name = name;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        // image for rules
        ImageIcon ruleImage = new ImageIcon(ClassLoader.getSystemResource("imgs/login.jpg"));
        JLabel image = new JLabel(ruleImage);
        image.setBounds(680, 0, 1150, 780);

        add(image);
        image.setVisible(true);
    
       JLabel heading = new JLabel("Welcome " + name + " to Quiz Game");
       heading.setBounds(120, 100, 700, 30);
       heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 32));
       heading.setForeground(new Color(30, 144, 254));
       add(heading);
   
       JLabel rules = new JLabel();
       rules.setBounds(20, 150, 1100, 550);
       rules.setFont(new Font("Tahoma", Font.PLAIN, 18));
       rules.setText(
           "<html>"+ 
               "1. First, pick the type of quiz you want to do.  There are three options: math,<br> general knowledge, and sciences." + "<br><br>" +
               "2. Next, choose the level you prefer. There are two: easy and difficult.The easy <br> level doesn't have a timer, while the difficult level has a 20-second timer for <br> each question." + "<br><br>" +
               "3. Once you've chosen the quiz and level, read the question displayed on the <br> screen carefully" + "<br><br>" +
               "4. Among the choices given, select the answer you think is correct." + "<br><br>" +
               "5. If you chose the easy level, take your time to answer. There's no timer, so <br> respond when you're ready." + "<br><br>" +
               "6. If you chose the difficult level, keep an eye on the 20-second timer. Try to <br> answer as quickly as possible." + "<br><br>" +
               "7. Continue to answer all the questions in your quiz by repeating steps 3 to 6." + "<br><br>" +
               "8. At the end of the quiz, you'll see your score! Each correct answer adds points.<br> Congratulations for every correct response!" + "<br><br>" +
           "<html>"
       );
       add(rules);
       
       back = new RoundButton("Back");
       back.setBounds(320, 700, 140, 40);
       back.setBackground(new Color(30, 144, 254));
       back.setForeground(Color.BLACK);
       back.setBackground(Color.RED);  
       back.addActionListener(this);
       add(back);
       
       start = new RoundButton("Start");
       start.setBounds(140, 700, 140, 40);
       start.setBackground(new Color(30, 144, 254));
       start.setForeground(Color.BLACK);
       start.setBackground(new Color(30, 144, 254)); 
       start.addActionListener(this);
       add(start);

        setTitle("Quiz Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == start) { 
            setVisible(false); 
            new Login2(name); 
        } else {
            setVisible(false); 
            new Login();  
        }
    }

 
}