package app;

//Bibliotecas utilizadas
import javax.swing.JOptionPane;
import tad.FilaPacientes;
import tad.Paciente;

public class AppConsultorioMedico {
    
    public static void main(String[] args) {
        //Referenciando objeto paciente
        Paciente paciente;
        //Criando uma fila de pacientes estática
        FilaPacientes fila = new FilaPacientes(10);
        //variável para controlar as opções 
        int opcao = 0;

        //Enquanto a opção for diferente de zero o sistema ficará disponível para cadastrar mais pacientes 
        do {
            try {
                //recebe a opção desejada
                opcao = Integer.parseInt(JOptionPane.showInputDialog(null, menu()));

                //a opção desejada é controlada por um switch case
                switch (opcao) {
                    case 1:
                        //cadastrar pacientes
                        //criando objeto paciente
                        paciente = new Paciente();
                        paciente.setNome(JOptionPane.showInputDialog(null, "Nome completo: "));
                        paciente.setIdade(Integer.parseInt(JOptionPane.showInputDialog(null, "Idade: ")));
                        fila.enqueue(paciente);

                        //mensagem de confirmação do enfileiramento
                        JOptionPane.showMessageDialog(null, "O paciente " + paciente.getNome() + " foi inserido com sucesso!");
                        break;
                    case 2:
                        //Chamamos o paciente a ser atendido, isto é, desenfileiramos um dado e retornamos ele
                        JOptionPane.showMessageDialog(null, "O paciente a ser atendido é: \n" + fila.dequeue());
                        break;
                    case 3:
                        if (fila.isFull()) {
                            //Se a fila estiver cheia retornará um true e seguinte mensagem irá aparecer
                            JOptionPane.showMessageDialog(null, "A fila está completamente cheia!");
                        } else if (fila.isEmpty()) {
                            //Se a fila estiver vazia retornará um true e seguinte mensagem irá aparecer
                            JOptionPane.showMessageDialog(null, "A fila está completamente vazia!");
                        } else {
                            //Caso nenhum dos métodos retorne true então a fila não está cheia, mas também não está vazia, ou seja, ainda há pacientes
                            JOptionPane.showMessageDialog(null, "Ainda há pacientes na fila!");
                        }
                        break;
                    case 4:
                        //Verifica qual é o front da fila, isto é, o primeiro elemento da fila
                        JOptionPane.showMessageDialog(null, "O próximo paciente a ser atendido é o(a): \n" + fila.front());
                        break;
                    case 5:
                        //Retorna a quantidade de elementos que existem na fila
                        JOptionPane.showMessageDialog(null, "Ainda há " + fila.size() + " na fila");
                        break;
                    case 0:
                        //Mensagem de encerramento do sistema
                        JOptionPane.showMessageDialog(null, "Obrigado por usar o sistema!\n" + "Por: Breno Henrique");
                        break;
                    default:
                        //Caso nenhuma das opções sejam digitadas retornará uma mensagem de erro
                        JOptionPane.showMessageDialog(null, "Digite uma opção válida!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            //captura a exceção     
            } catch (RuntimeException e) {
                e.getMessage();
            }

        } while (!(opcao == 0));
    }

    //criando um método estático para visualizar as opções do sistema
    private static String menu() {
        return "===================Consultório Médico==================\n"
                + "1 - Inserir um paciente na fila de espera\n"
                + "2 - Chamar o paciente para ser atendido\n"
                + "3 - Verificar se a fila está cheia ou vazia\n"
                + "4 - Verificar o próximo paciente a ser atendido\n"
                + "5 - Informar quantos pacientes existem na fila de espera\n"
                + "0 - Sair do sistema";
    }
}
