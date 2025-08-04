import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CadastroUsuario {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Cadastro De Usuário");
        frame.setSize(400,300); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JLabel labelNome = new JLabel("Nome: ");
        JLabel labelEmail = new JLabel("Email: ");
        JLabel labelIdade = new JLabel("Idade: ");

        JTextField campoNome = new JTextField(10);
        JTextField campoEmail = new JTextField(10);
        JTextField campoIdade = new JTextField(10);

        JButton botaoCadastrar = new JButton("Cadastrar");
        JButton botaoLimpar = new JButton("Limpar Cadastro");

        botaoCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e ) {
                if (campoNome.getText().isEmpty()  || campoEmail.getText().isEmpty()  || campoIdade.getText().isEmpty()){
                    JOptionPane.showMessageDialog(frame, "É obrigatório que todos os campos estejam preenchidos.");
                }else {
                    JOptionPane.showMessageDialog(frame, "Usuário Cadastrado: \nNome: " + campoNome.getText() + "\nEmail: " + campoEmail.getText() + "\nIdade: " + campoIdade.getText());
                }
            }
        });

        botaoLimpar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e ) {
                campoNome.setText("");
                campoEmail.setText("");
                campoIdade.setText("");

            }
        });

        frame.add(labelNome);
        frame.add(campoNome);
        frame.add(labelEmail);
        frame.add(campoEmail);
        frame.add(labelIdade);
        frame.add(campoIdade);
        frame.add(botaoCadastrar);
        frame.add(botaoLimpar);

        frame.setVisible(true);
    }
}

