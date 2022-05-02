/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4_ihm;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import static java.lang.Integer.parseInt;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

/**
 *
 * 
 */
public class Windows extends JFrame implements FocusListener, ActionListener {
    
    private JTextField txt;
    private JButton button;
    
    private JLabel nb;
    private JLabel base;
    private JLabel result;
    
    private JComboBox<Integer> select;
    
    public Windows() {
        this.setTitle("Convertisseur");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        initialisation();
        txt.addFocusListener(this);
        button.addActionListener(this);
    }
    
    private void initialisation() {
    
        txt = new JTextField("Inserez un nombre.");
        txt.setColumns(10);
        
        button = new JButton("Convert");
        
        nb = new JLabel("Nombre (Base10) :");
        nb.setBorder(new BevelBorder(1));
        
        base = new JLabel("Base :");
        base.setBorder(new BevelBorder(1));
        
        result = new JLabel(" ...");
        result.setBorder(new BevelBorder(1));
        
        Integer[] baseTitle = new Integer[] {2,3,8,16};
        
        select = new JComboBox<>(baseTitle);
        add(select);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        
        GridBagConstraints cont = new GridBagConstraints();
        cont.fill=GridBagConstraints.BOTH;
        
        cont.gridx=0;
        cont.gridy=0;
        panel.add(nb, cont);
        
        cont.gridx=1;
        panel.add(base, cont);
        
        cont.gridx=0;
        cont.gridy=1;
        panel.add(txt, cont);
        
        cont.gridx=1;
        panel.add(select, cont);
        
        cont.gridx=0;
        cont.gridy=2;
        cont.gridwidth=2;
        panel.add(button, cont);
        
        cont.gridy=3;
        panel.add(result, cont);
        
        this.setContentPane(panel);
        this.pack();
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (e.getSource()==txt) {
            txt.setText("");
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
      
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            
            Integer num = new Integer(parseInt(txt.getText()));
            
            Integer selecting = (Integer) select.getSelectedItem();
            Integer binary = new Integer(5);
            result.setText(binary.toString(num, selecting));
        }
    }
}
