import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
//from  ww  w  . j  ava  2 s. co  m
public class test extends JFrame {
  public test() {
    if("kau".equals("KaU"))
        System.out.println("YES");
  }

  public static void main(String[] args) {
    test frame = new test();
    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }

}