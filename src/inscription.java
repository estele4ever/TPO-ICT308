import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class inscription extends  JDialog{
    private JTextField nameField;
    private JTextField Emailfield;
    private JButton seConnecterButton;
    private JPasswordField passwordField;
    private JPanel inscriptionpanel;
    private JButton annulerButton;
    private JPasswordField confirmpasswordField;

    public inscription(JFrame parent) {
        super(parent);
        setTitle("HostoApp");
        setContentPane(inscriptionpanel);
        setMinimumSize(new Dimension(450,475));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);



        seConnecterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inscriptionmethod();

            }
        });
        annulerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        setVisible(true);
    }

    private void inscriptionmethod() {

        String nom = nameField.getText();
        String  email = Emailfield.getText();
        String password = String.valueOf(passwordField.getPassword());
        String confirmpassword = String.valueOf(confirmpasswordField.getPassword());
        if (!password.equals(confirmpassword)){
            JOptionPane.showMessageDialog(this,"le  mot de passe n'est pas confirmer","essayez encore",JOptionPane.ERROR_MESSAGE);
        }
        if (nom.isEmpty() || email.isEmpty() ){
            JOptionPane.showMessageDialog(this,"veuillez remplir tous les champs","essayez encore",JOptionPane.ERROR_MESSAGE);
        }
        user = addUsertoDatabase(nom,email,password);
        if (user != null){
            dispose();
        }
        else {
            JOptionPane.showMessageDialog(this,"echec de l'incription","essayez encore",JOptionPane.ERROR_MESSAGE);

        }
    }
public Utilisateur user ;
    private Utilisateur addUsertoDatabase(String nom, String email, String password) {
        Utilisateur user = null;
        final  String DB_URL = "jdbc:mysql://localhost/MyStore?serverTimezone=UTC";
        final  String Username ="root";
        final  String PASSWORD = "";
        try {
            Connection conn = DriverManager.getConnection(DB_URL,Username,PASSWORD);
            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO Utilisateur (nom,email,password)" + "VALUE (?,?,?)";
            PreparedStatement preparestmt = conn.prepareStatement(sql);
            preparestmt.setString(1,nom);
            preparestmt.setString(2,email);
            preparestmt.setString(3,password);
            int addrows = preparestmt.executeUpdate();
            if (addrows > 0){
                user = new Utilisateur(nom,email,password);

            }
            stmt.close();
            conn.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }

}
