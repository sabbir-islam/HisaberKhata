package com.testproject;

import static java.awt.Color.GREEN;
import static java.awt.Color.gray;
import static java.awt.Color.WHITE;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sabbi
 */
public class Home extends JFrame implements ActionListener{
    private JTable table;
    private JScrollPane scroll;
    private DefaultTableModel model;
    private Container c;
    private JLabel tittlelabel, prolabel, quantylabel, sellLabel, buylabel;
    private JTextField protf, quantf, selltf, buytf;
    private JButton addButton, updateButton, clearButton, deletButton;
    
    private String[] columns ={"Product Name","Quantity", "Sell Price", "Buy Price", "Profit"};
    private String[] rows = new String[5];
    
    Home(){
      initcomponents();
    }

    private void initcomponents() {
        
      //this.setVisible(true);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setSize(780,690);
      this.setLocation(400, 50);
      this.setTitle("Home Page");
    
      c  = this.getContentPane();
      c.setLayout(null);
      c.setBackground(gray);
      
      
      Font font = new Font("Arial", Font.BOLD,16);
      
      tittlelabel = new JLabel("Hisaber Khata");
      tittlelabel.setFont(font);
      tittlelabel.setBounds(140,10,250,50);
      c.add(tittlelabel);
      
      prolabel = new JLabel("Product: ");
      prolabel.setBounds(10,80,140,30);
      prolabel.setFont(font);
      c.add(prolabel);
      
      protf = new JTextField();
      protf.setBounds(110,80,200,30);
      protf.setFont(font);
      c.add(protf);
      
      addButton = new JButton("Entry");
      addButton.setBounds(400,80,100,30);
      addButton.setFont(font);
      c.add(addButton);
      
      quantylabel = new JLabel("Quantity: ");
      quantylabel.setBounds(10,130,150,30);
      quantylabel.setFont(font);
      c.add(quantylabel);
      
      quantf = new JTextField();
      quantf.setBounds(110,130,200,30);
      quantf.setFont(font);
      c.add(quantf);
      
      updateButton = new JButton("Update");
      updateButton.setBounds(400,130,100,30);
      updateButton.setFont(font);
      c.add(updateButton);
      
      sellLabel = new JLabel("Sell price: ");
      sellLabel.setBounds(10,180,150,30);
      sellLabel.setFont(font);
      c.add(sellLabel);
      
      selltf = new JTextField();
      selltf.setBounds(110,180,200,30);
      selltf.setFont(font);
      c.add(selltf);
      
      
      clearButton = new JButton("Clear");
      clearButton.setBounds(400,180,100,30);
      clearButton.setFont(font);
      c.add(clearButton);
      
      
      buylabel = new JLabel("Buy Price: ");
      buylabel.setBounds(10,230,150,30);
      buylabel.setFont(font);
      c.add(buylabel);
      
      buytf = new JTextField();
      buytf.setBounds(110,230,200,30);
      buytf.setFont(font);
      c.add(buytf);
      
      
      deletButton = new JButton("Delete");
      deletButton.setBounds(400,230,100,30);
      deletButton.setFont(font);
      c.add(deletButton);
      
      
      table = new JTable();
      
      model = new DefaultTableModel();
      model.setColumnIdentifiers(columns);
      table.setModel(model);
      table.setFont(font);
      table.setSelectionBackground(GREEN);
      table.setBackground(WHITE);
      table.setRowHeight(30);
      
      
      scroll = new JScrollPane(table);
      scroll.setBounds(10,360,740,265);
      c.add(scroll);
      
      addButton.addActionListener(this);
      clearButton.addActionListener(this);
      deletButton.addActionListener(this);
      updateButton.addActionListener(this);
      table.addMouseListener(new MouseAdapter(){
      
                  @Override
                  public void mouseClicked(MouseEvent me){
                          
                  int numberofRow =    table.getSelectedRow();
                  
                  String pname = model.getValueAt(numberofRow, 0).toString();
                  String quantity = model.getValueAt(numberofRow, 1).toString();
                  String sellp = model.getValueAt(numberofRow, 2).toString();
                  String buyp = model.getValueAt(numberofRow, 3).toString();
                  
                  protf.setText(pname);
                  quantf.setText(quantity);
                  selltf.setText(sellp);
                  buytf.setText(buyp);
                  
                  }
      
         });
      
    }
    @Override
    public void actionPerformed(ActionEvent e) {
       
        if(e.getSource()==addButton){
        String productName = protf.getText();
        String quantity = quantf.getText();
        String sellPrice = selltf.getText();
        String buyPrice = buytf.getText();

        
        double quantityValue = Double.parseDouble(quantity);
        double sellPriceValue = Double.parseDouble(sellPrice);
        double buyPriceValue = Double.parseDouble(buyPrice);
        double totalRevenue = quantityValue * sellPriceValue;
        double totalCost = quantityValue * buyPriceValue;
        double profit = totalRevenue - totalCost;

        
        model.addRow(new Object[]{productName, quantity, sellPrice, buyPrice, profit});
        }
        else if(e.getSource()==clearButton){
         protf.setText("");
        quantf.setText("");
        selltf.setText("");
        buytf.setText("");
            
        }
        else if(e.getSource()==deletButton){
            
          int numberofRow =  table.getSelectedRow();
            if(numberofRow>=0){
                model.removeRow(numberofRow);
            }
            else{
                 JOptionPane.showMessageDialog(null, "No rows are Selected");
            }
        }
        else if(e.getSource()==updateButton){
          
         int numberofRow = table.getSelectedRow();
         
            String productName = protf.getText();
            String quantity = quantf.getText();
            String sellPrice = selltf.getText();
            String buyPrice = buytf.getText();

            
            int quantityValue = Integer.parseInt(quantity);
            double sellPriceValue = Double.parseDouble(sellPrice);
            double buyPriceValue = Double.parseDouble(buyPrice);
            double totalRevenue = quantityValue * sellPriceValue;
            double totalCost = quantityValue * buyPriceValue;
            double profit = totalRevenue - totalCost;

           
            model.setValueAt(productName, numberofRow, 0);
            model.setValueAt(quantity, numberofRow, 1);
            model.setValueAt(sellPrice, numberofRow, 2);
            model.setValueAt(buyPrice, numberofRow, 3);
            model.setValueAt(profit, numberofRow, 4);

           protf.setText("");
           quantf.setText("");
           selltf.setText("");
           buytf.setText("");
           
        }
    }

    public static void main(String[] args){
       Home frame =new Home();
       frame.setVisible(true);
      }

        }

