package QuizApp;
import java.awt.*; 
import javax.swing.*;
import java.awt.event.*;

class RoundedButton extends JButton {
    public RoundedButton(String text) {
        super(text);
        setFocusPainted(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isPressed()) {
            g.setColor(Color.RED.darker());
        } else {
            g.setColor(getBackground());
        }
        g.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        // Ne pas dessiner la bordure
    }
}
public class Score extends JFrame implements ActionListener {
	
    Score(String name,int score){
        setBounds(0, 0, 1550, 900);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("imgs/score3.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(210, 90, 800, 400);
        add(image);

        JLabel heading = new JLabel("Thank you " + name + " for playing Quiz Game !");
        heading.setBounds(560, 30, 750, 40);
        heading.setFont(new Font("Comic Sans MS", Font.BOLD, 29));
        add(heading);

        if (score>=50) {
            JLabel lblScore = new JLabel("Congratulations! "+ name +" You have passed the test ");
            lblScore.setBounds(660, 550, 700, 30);
            lblScore.setFont(new Font("Tahoma", Font.PLAIN, 26));
            add(lblScore);
            
        } else {
            JLabel lblScore = new JLabel("OOP! "+ name +" You are fell, try again" );
            lblScore.setBounds(610, 550, 700, 30);
            lblScore.setFont(new Font("Tahoma", Font.PLAIN, 26));
            add(lblScore);
        }
        JLabel lblScore = new JLabel("Your Score is " + score );
        lblScore.setBounds(680, 600, 300, 30);
        lblScore.setFont(new Font("Tahoma", Font.PLAIN, 28));
        add(lblScore);

        RoundedButton submit = new RoundedButton("Home");
        submit.setBounds(690, 650, 170, 40);
        submit.setFont(new Font("Tahoma", Font.PLAIN, 22));
        submit.setBackground(Color.RED);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        add(submit);
        

        setTitle("Quiz Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
      setVisible(false);
      new Login(); 
    }

// public static void main(String[] args) {
//    new Score("User",0);
// }    
}
