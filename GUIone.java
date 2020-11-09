import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
# shach is here

public class GUIone extends JFrame implements ActionListener
{

    //Creating Text boxes & buttons
    JLabel number = new JLabel("Number");
    JTextField idinp = new JTextField(8);
    JLabel name = new JLabel("Name");
    JTextField nameinp = new JTextField(10);
    JLabel cell = new JLabel("Cell Phone");
    JTextField cellnuminp = new JTextField(10);
    JButton myButton = new JButton("Display");

    GUIone()
    {
        // Screen properties
        setLayout(null);
        setSize(440, 267);
        setTitle("Customer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /**
         * Add items to frame & Setting Bonds
          */
        number.setBounds(50,35,50, 35);
        add(number);
        idinp.setBounds(130,35,180, 35);
        add(idinp);
        name.setBounds(50,78,50, 35);
        add(name);
        nameinp.setBounds(130,78,250, 35);
        add(nameinp);
        cell.setBounds(50,123,100, 35);
        add(cell);
        cellnuminp.setBounds(130,123,250, 35);
        add(cellnuminp);
        myButton.setBounds(298,180,80, 30);
        add(myButton);

        myButton.addActionListener(this);
        setVisible(true);
    }// GUIone

    public static void main(String[]arg)
    {
        GUIone fr = new GUIone();
        centerFrame(fr);
    }//main

    /** This method centers a frame on the screen.
     * Add centerFrame(fr); to the main after the constructor */
    private static void centerFrame(GUIone fr)
    {
        // Get size of the screen
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        // Determine the new location of the window
        int w, h, x, y;
        w = fr.getSize().width;
        h = fr.getSize().height;
        x = (dim.width - w) / 2;
        y = (dim.height - h) / 2;

        // Move the Window
        fr.setLocation(x, y);
    }// centerFrame

    /**
     * @param e
     * When the display button is clicked any information typed is the textbox is displayed in a
     * dialog box
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        JFrame f = new JFrame();
            String i,n,c;
            int id,cell;

            i = idinp.getText();
            n = nameinp.getText();
            c = cellnuminp.getText();


            if (e.getSource() == myButton)
            {
                if (n.equals("") || i.equals("") || c.equals(""))
                {
                    notice();
                }
                else
                {
                    try
                    {
                        id = Integer.parseInt (i);
                        cell = Integer.parseInt (c);
                        // Give the number of integers in the object cell
                        int length = String.valueOf(cell).length();

                        if (length == 7) {
                            display(id, n, cell);
                        } else {
                            JOptionPane.showMessageDialog(f, "<html><font size='3'- color=red>Cell # must be 7 digits!</font></html>");
                        }
                    }
                    catch (NumberFormatException e1)
                    {
                        notice2();
                    }
                }
            }



    }// actionPerformed

    /**
     * OptionPane
     * dialog boxes use used to display information
     */
    JFrame f = new JFrame();

    private void notice()
    {
        JOptionPane.showMessageDialog(f,"<html><font size='3'- color=red>Please complete the form</font></html>");
    }// notice

    private void notice2()
    {
        JOptionPane.showMessageDialog(f,"<html><font size='3'- color=red>Wrong inputs!</font></html>");
    }// notice2

    private void display(int a, String b, int c)
    {
        JOptionPane.showMessageDialog(f,"Number:  " + a +
                "\nName:  " + b +
                "\nCell Number: " + c);
    }// display
}
