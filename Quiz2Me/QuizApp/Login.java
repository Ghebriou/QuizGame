package QuizApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class RoundButton extends JButton {
    public RoundButton(String label) {
        super(label);
        setContentAreaFilled(false);
    }

    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(Color.lightGray);
        } else {
            g.setColor(getBackground());
        }
        g.fillRoundRect(0, 0, getSize().width - 1, getSize().height - 1, 20, 20);

        super.paintComponent(g);
    }

    protected void paintBorder(Graphics g) {
        g.setColor(getForeground());
        g.drawRoundRect(0, 0, getSize().width - 1, getSize().height - 1, 20, 20);
    }
}

public class Login extends JFrame implements ActionListener {
    RoundButton Start, Exit;
    JTextField tfName;

    Login() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("imgs/login.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0,750, 790);
        add(image);
        image.setVisible(true);   

        JLabel heading=new JLabel("Quiz Game");
        heading.setBounds(960, 170, 400, 75);
        heading.setFont(new Font("Comic Sans MS", Font.BOLD, 70));
        heading.setForeground(new Color(30, 144, 254));
        add(heading);

        JLabel name=new JLabel("Enter Your Name");
        name.setBounds(1000, 340, 300, 30);
        name.setFont(new Font("Arial", Font.PLAIN, 18));
        name.setForeground(new Color(30, 144, 254));
        add(name);

        tfName = new JTextField();
        tfName.setBounds(1000, 380, 300, 40);
        tfName.setFont(new Font("Arial", Font.PLAIN, 16));
        tfName.setBorder(BorderFactory.createLineBorder(new Color(30, 144, 254)));
        tfName.setForeground(new Color(30, 144, 254));
        tfName.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    String name = tfName.getText();
                    setVisible(false);
                    new Rules(name);
                }
            }
        });
        add(tfName);

        Start = new RoundButton("Start");
        Start.setBounds(1000, 450, 140, 40);
        Start.addActionListener(this);
        Start.setBackground(new Color(30, 144, 254));
        Start.setForeground(Color.BLACK);
        add(Start);

        Exit = new RoundButton("Exit");
        Exit.setBounds(1160, 450, 140, 40);
        Exit.setBackground(Color.RED);
        Exit.setForeground(Color.BLACK);
        Exit.addActionListener(this);
        add(Exit);

       
           
        setTitle("Quiz Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }
  
 
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == Start) {
            String name = tfName.getText();
            setVisible(false);
            new Rules(name);
        } else if (ae.getSource() == Exit) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}


