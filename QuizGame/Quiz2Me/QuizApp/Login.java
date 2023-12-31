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

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("imgs/photo1.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(260, 50,650, 300);
        add(image);
        image.setVisible(true);   

        JLabel name=new JLabel("Enter Your Name");
        name.setBounds(500, 350, 300, 30);
        name.setFont(new Font("Arial", Font.PLAIN, 20));
        name.setForeground(new Color(30, 144, 254));
        add(name);

        tfName = new JTextField();
        tfName.setBounds(420, 400, 300, 40);
        tfName.setFont(new Font("Arial", Font.PLAIN, 16));
        tfName.setBorder(BorderFactory.createLineBorder(new Color(2, 180, 254)));
        tfName.setForeground(new Color(2, 180, 254));
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
        Start.setBounds(580, 490, 160, 40);
        Start.addActionListener(this);
        Start.setBackground(new Color(2, 180, 254));
        Start.setForeground(Color.white);
        add(Start);

        Exit = new RoundButton("Exit");
        Exit.setBounds(400, 490, 160, 40);
        Exit.setBackground(Color.RED);
        Exit.setForeground(Color.white);
        Exit.addActionListener(this);
        add(Exit);

       
           
        setTitle("Quiz Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 650);
        setLocationRelativeTo(null);
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


