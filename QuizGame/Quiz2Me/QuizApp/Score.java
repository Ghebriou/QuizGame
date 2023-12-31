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
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("imgs/results.png"));
        JLabel image = new JLabel(i1);
        image.setBounds(150, 70, 900, 300);
        add(image);

        JLabel heading = new JLabel("Thank you " + name + " for playing Quiz Game!");
        heading.setBounds(300, 30, 700, 40);
        heading.setFont(new Font("Comic Sans MS", Font.BOLD, 29));
        heading.setForeground(new Color(30, 144, 254));
        add(heading);

        if (score>=50) {
            JLabel lblScore = new JLabel("Congratulations "+ name +" Lkhabache! ");
            lblScore.setBounds(370, 400, 600, 30);
            lblScore.setFont(new Font("Tahoma", Font.PLAIN, 26));
            lblScore.setForeground(new Color(0, 255, 0));
            add(lblScore);
            
        } else {
            JLabel lblScore = new JLabel("OOPS! "+ name +", try again!" );
            lblScore.setBounds(430, 400, 600, 30);
            lblScore.setFont(new Font("Tahoma", Font.PLAIN, 26));
            lblScore.setForeground(new Color(255, 0, 0));
            add(lblScore);
        }
        JLabel lblScore = new JLabel("Your Score is " + score +"/100");
        lblScore.setBounds(430, 440, 300, 30);
        lblScore.setFont(new Font("Tahoma", Font.PLAIN, 28));
        lblScore.setForeground(new Color(30, 144, 254));
        add(lblScore);

        RoundedButton submit = new RoundedButton("Home");
        submit.setBounds(470, 495, 170, 40);
        submit.setFont(new Font("Tahoma", Font.PLAIN, 22));
        submit.setBackground(Color.RED);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        add(submit);
        

        setTitle("Quiz Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 650);
        setLocationRelativeTo(null);
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