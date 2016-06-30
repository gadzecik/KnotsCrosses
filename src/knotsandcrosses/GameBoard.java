/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knotsandcrosses;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author oem
 */
public class GameBoard extends JPanel{
    
    JFrame frame;
    JPanel content;
    JPanel line1;
    JPanel line2;
    JPanel line3;
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    JButton button5;
    JButton button6;
    JButton button7;
    JButton button8;
    JButton button9;
    
    //JLabel label;
    
    public void gboard(){
        frame = new JFrame();
        content = new JPanel();
        line1 = new JPanel();
        line2 = new JPanel();
        line3 = new JPanel();
        
        button1= new JButton();
        button2= new JButton();
        button3= new JButton();
        button4= new JButton();
        button5= new JButton();
        button6= new JButton();
        button7= new JButton();
        button8= new JButton();
        button9= new JButton();

        
        
        frame.getContentPane().add(content);
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        
        content.add(line1);
        content.add(line2);
        content.add(line3);

        line1.add(button1);
        line1.add(button2);
        line1.add(button3);
        line2.add(button4);
        line2.add(button5);
        line2.add(button6);
        line3.add(button7);
        line3.add(button8);
        line3.add(button9);
        
        frame.setSize(100,100);
        frame.setVisible(true);
            
    }
    
    class OListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
    }
            
    
    
    
    
    
}
