 package QuizApp;
 import javax.swing.*;
 import java.awt.*;
 import java.awt.event.ActionEvent;
 import java.awt.event.ActionListener;;

class RoundButton extends JButton {

    public RoundButton(String label) {
        super(label);
 
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
    }
 
    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(Color.lightGray);
        } else {
            g.setColor(getBackground());
        }

        int borderRadius = 10;  
        g.fillRoundRect(0, 0, getSize().width - 1, getSize().height - 1, borderRadius, borderRadius);

        super.paintComponent(g);
    }

     @Override
    protected void paintBorder(Graphics g) {
        g.setColor(getForeground());

        int borderRadius = 10; 
        g.drawRoundRect(0, 0, getSize().width - 1, getSize().height - 1, borderRadius, borderRadius);
    }
}

public class Login2 extends JFrame implements ActionListener {

    JButton Capitals,Sciences, Maths, Exit;
    String userName;  

    Login2(String name) {
    	getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        userName = name; 

        ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("imgs/login.jpg"));
        JLabel image3 = new JLabel(i3);
        image3.setBounds(0, 0,800, 780);
        add(image3);
        
        
        JPanel headingPanel = new JPanel();
        headingPanel.setBackground(new Color(255, 255, 255, 128)); 
        headingPanel.setBounds(1035, 170, 400, 75);
        add(headingPanel);

        JLabel heading = new JLabel("Quiz Game");
        heading.setFont(new Font("Montserrat", Font.BOLD, 48));
        heading.setForeground(Color.BLUE);
 
        headingPanel.setLayout(new BorderLayout());
        headingPanel.add(heading, BorderLayout.CENTER);

        JLabel module = new JLabel("Select any of the Following to attempt Quiz");
        module.setBounds(925, 300, 500, 30);
        module.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
        module.setForeground(Color.BLACK);
        add(module);

        Sciences = createStyledButton("Sciences");
        Sciences.setBounds(900, 380, 150, 40);
        add(Sciences);

        Maths = createStyledButton("Mathematics");
        Maths.setBounds(1100, 380, 150, 40);
        add(Maths);

        Capitals = createStyledButton("Capitals");
        Capitals.setBounds(1300, 380, 150, 40);
        add(Capitals);

        Exit = createStyledButton("Exit");
        Exit.setBounds(1100, 550, 150, 40);
        Exit.setBackground(Color.RED);
        add(Exit);

        setTitle("Quiz Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }

    private JButton createStyledButton(String text) {
        JButton button = new RoundButton(text);
        button.setBackground(new Color(52, 152, 219));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.addActionListener(this);
        return button;
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == Sciences) { 
        	setVisible(false);
            String[] options = {"Easy", "Difficult"};
            int choice = JOptionPane.showOptionDialog(null, "Choose Difficulty Level", "Difficulty Level",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            boolean isDifficult = false;
            if (choice == 1) {
                isDifficult = true;
            }
            new QuizGk(userName, isDifficult);  
            
        } else if (ae.getSource() == Maths) { 
            setVisible(false);
            String[] options = {"Easy", "Difficult"};
            int choice = JOptionPane.showOptionDialog(null, "Choose Difficulty Level", "Difficulty Level",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            boolean isDifficult = false;
            if (choice == 1) {
                isDifficult = true;
            }
           new QuizMath(userName, isDifficult);  
           
        } else if (ae.getSource() == Capitals) { 
        	setVisible(false);
            String[] options = {"Easy", "Difficult"};
            int choice = JOptionPane.showOptionDialog(null, "Choose Difficulty Level", "Difficulty Level",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            boolean isDifficult = false;
            if (choice == 1) {
                isDifficult = true;
            }
            new QuizComp(userName, isDifficult); 
            
        } else if (ae.getSource() == Exit) {
            setVisible(false);
        }
    }

}