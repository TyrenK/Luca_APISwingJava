import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CadastroUsuario {
    public static void main(String[] args) {

        //Criação do Frame, utilizando o BoxLayout para uma organização mais agradável dos elementos.
        JFrame frame = new JFrame("Cadastro De Usuário");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        
        //Criação dos Panels que irão organizar os elementos, com aqueles que se tornarão campos para esquerda e os botões centralizados.
        JPanel linhaNome = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel linhaEmail = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel linhaIdade = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel linhaBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel linhaGenero = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        //Criação dos Labels utilizados
        JLabel labelNome = new JLabel("Nome: ");
        JLabel labelEmail = new JLabel("Email: ");
        JLabel labelIdade = new JLabel("Idade: ");
        JLabel labelGenero = new JLabel("Gênero: ");

        //Criação dos campos para inserção de dados.
        JTextField campoNome = new JTextField(20);
        JTextField campoEmail = new JTextField(20);
        JTextField campoIdade = new JTextField(5);

        //Criação dos RadioButtons para a seleção do gênero.
        JRadioButton masculino = new JRadioButton("Masculino");
        JRadioButton feminino = new JRadioButton("Feminino");
        JRadioButton outro = new JRadioButton("Outro");

        //Criação do grupo que organizará os RadioButtons
        ButtonGroup grupoGenero = new ButtonGroup();

        //Criação dos botões de cadastro e de limpeza do cadastro realizado.
        JButton botaoCadastrar = new JButton("Cadastrar");
        JButton botaoLimpar = new JButton("Limpar Cadastro");

        //Adição dos RadioButton ao seu grupo.
        grupoGenero.add(masculino);
        grupoGenero.add(feminino);
        grupoGenero.add(outro);

        //Adição dos elementos aos seus Panels respectivos.
        linhaGenero.add(labelGenero);
        linhaGenero.add(masculino);
        linhaGenero.add(feminino);
        linhaGenero.add(outro);

        linhaNome.add(labelNome);
        linhaNome.add(campoNome);

        linhaEmail.add(labelEmail);
        linhaEmail.add(campoEmail);

        linhaIdade.add(labelIdade);
        linhaIdade.add(campoIdade);

        linhaBotoes.add(botaoCadastrar);
        linhaBotoes.add(botaoLimpar);
        
        //Adição dos Panels aos frames.
        frame.add(linhaNome);
        frame.add(linhaEmail);
        frame.add(linhaIdade);
        frame.add(linhaGenero);
        frame.add(linhaBotoes);
        
        //Funcionalidade dos botões
        botaoCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Verificar se todos os campos estão preenchidos e se o e-mail é valido
                if (campoNome.getText().isEmpty() || campoEmail.getText().isEmpty() || campoIdade.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "É obrigatório que todos os campos estejam preenchidos.");
                } else if (!campoEmail.getText().contains("@")) {
                    JOptionPane.showMessageDialog(frame, "Email inválido! O email precisa conter '@'.");
                } 

                //Verificação do preenchimento do RadioButton.
                String generoSelecionado = "";
                if (masculino.isSelected()) {
                    generoSelecionado = "Masculino";
                } else if (feminino.isSelected()) {
                    generoSelecionado = "Feminino";
                } else if (outro.isSelected()) {
                    generoSelecionado = "Outro";
                } else {
                    JOptionPane.showMessageDialog(frame, "Por favor, selecione um gênero.");
                    return;
                }

                //Verificar se a entrada da idade é válida (se é de fato um número e se é positivo).
                try {
                    int idadeInt = Integer.parseInt(campoIdade.getText());
                    if (idadeInt <= 0) {
                        JOptionPane.showMessageDialog(frame, "Idade deve ser um número positivo.");
                        return;
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Idade inválida! Digite um número inteiro.");
                    return;
                }
                
                //Mostrar as informações cadastradas.
                JOptionPane.showMessageDialog(frame,
                    "Usuário Cadastrado: \nNome: " + campoNome.getText() +
                   "\nEmail: " + campoEmail.getText() +
                    "\nIdade: " + campoIdade.getText() +
                    "\nGênero: " + generoSelecionado);


            }
        });

        botaoLimpar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Limpar o cadastro.
                campoNome.setText("");
                campoEmail.setText("");
                campoIdade.setText("");
                grupoGenero.clearSelection();
            }
        });

        frame.setVisible(true);
    }
}
