
package br.com.View;
import java.sql.SQLException;
import javax.swing.*;

public class Splash extends JFrame {

    private static JLabel lbSplash;
    private ImageIcon imSplash;
    
public static void main (String arg [] ) throws SQLException {
    
     try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                
                if ("Windows".equals(info.getName())) {
                    
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
 
Splash s = new Splash();
s.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
s.setSize(400, 200);
s.setUndecorated(true);
s.setLocationRelativeTo(null);
s.setVisible(true);

try {
    Thread.sleep(2200);
    } catch (InterruptedException ex) {  
}
   
s.dispose();
Principal p = new Principal();
p.show();
}

public Splash () {
 setIconImage(new ImageIcon("Img/iconeSistema.png").getImage());
        setTitle("GSA - Gerenciamento de Secretaria Agil  ");
setLayout(null);
imSplash = new ImageIcon ("Img/Splash.jpg");
lbSplash = new JLabel (imSplash);
lbSplash.setBounds(0, 0 , 400 , 200 );

add(lbSplash);

}


}






