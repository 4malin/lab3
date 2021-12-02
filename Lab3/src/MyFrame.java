import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class MyFrame extends JFrame {
    List<Person> person = new ArrayList<>();

    MyFrame () {
        this.setSize(500, 400);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setTitle("LogIn");
        this.setResizable(false);
        person.add(new Person("Jedrzej", "888987"));
        person.add(new Person("Mikolaj", "213141"));
        person.add(new Person("Iza", "908076"));
        person.add(new Person("Oliwia", "oli2145"));
        person.add(new Person("Anna", "14159265"));
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 400, 300);
        panel.setBackground(Color.lightGray);
        panel.setLayout(null);

        JTextField Name = new JTextField();
        Name.setBackground(Color.white);
        Name.setBounds(200, 50, 100, 25);

        JPasswordField password = new JPasswordField();
        password.setBackground(Color.white);
        password.setBounds(200, 100, 100, 25);

        JLabel labelName = new JLabel();
        labelName.setText("Name");
        labelName.setForeground(Color.black);
        labelName.setBounds(110, 30, 60, 60);

        JLabel labelPassword = new JLabel();
        labelPassword.setText("Password");
        labelPassword.setForeground(Color.red);
        labelPassword.setBounds(110, 90, 110, 60);


        JButton loginButton = new JButton("Login");
        loginButton.setBounds(190, 170, 120, 50);
        loginButton.setBackground(Color.white);

        loginButton.addActionListener(e -> {

            for (Person person : person) {
                if (Objects.equals(Name.getText(), person.getLogin())) {
                    if (Objects.equals(String.valueOf(password.getPassword()), person.getPassword())) {
                        loginButton.setBackground(Color.green);
                    } else
                        loginButton.setBackground(Color.red);
                } else  {
                    if (Objects.equals(Name.getText(), person.getLogin())) {
                        loginButton.setBackground(Color.green);
                    } else
                        loginButton.setBackground(Color.red);
                }
            }
        });
        JButton cancelButton = new JButton("Clear");
        cancelButton.setBounds(320, 70, 75, 35);
        cancelButton.setBackground(Color.white);
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Name.setText("");
                password.setText("");
                loginButton.setBackground(Color.white);
            }

        });
        this.setVisible(true);
        panel.add(Name);
        panel.add(password);
        panel.add(labelName);
        panel.add(labelPassword);
        panel.add(loginButton);
        panel.add(cancelButton);
        this.add(panel);
    }

}