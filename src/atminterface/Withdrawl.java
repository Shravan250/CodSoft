
package atminterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Withdrawl extends JFrame implements ActionListener {
 
    double balance;  
    
    JButton exit , withdraw;
    
    JTextField amount;
    
    Withdrawl(double balance){
        
        this.balance = balance;        
        
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(700 , 700 , Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(0 , 0 , 700 , 700);
        add(label);
        
        JLabel text = new JLabel("Enter the amount you want to Withdraw");
        text.setBounds(135 , 240 ,400 ,20);
        text.setForeground(Color.WHITE);
        text.setFont(new Font ("System" , Font.BOLD , 13));
        label.add(text);        
        
        amount = new JTextField();
        amount.setFont(new Font ("Raleway" , Font.BOLD , 16));
        amount.setBounds(135 , 270 , 250 , 25);
        label.add(amount);          

        withdraw = new JButton("Withdraw");
        withdraw.setBounds(130 , 402 , 100 , 30);
        withdraw.addActionListener(this);
        label.add(withdraw);

        exit = new JButton("Back");
        exit.setBounds(295 , 402 , 100 , 30);
        exit.addActionListener(this);
        label.add(exit);        

        setSize(700, 700);
        setLocation(350 , 30);
        setVisible(true);
        
    
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == exit){
            setVisible(false);
            new Atminterface(balance).setVisible(true);
        }else if(ae.getSource() == withdraw ){
            
            try{
                double value = Double.valueOf(amount.getText());
                Bankaccount a = new Bankaccount();
                balance =  a.Withdrawl(balance , value );
                
            }catch(Exception e){
                System.out.println(e);
            }
        }    
        
    }
    
    public static void main(String args[]){
        new Withdrawl(0);
    }
}
