package tad;

public class FilaPacientes {
    //atributos
    private Paciente pacientes[];
    private int inicio;
    private int fim;
    private int total;

    //construtor da fila
    public FilaPacientes(int tamanho) {
        pacientes = new Paciente[tamanho];
        inicio = fim = total = 0;
    }

    //insere dado na fila
    public void enqueue(Paciente dado) {
        if (isFull()) {
            throw new RuntimeException("==>Fila Cheia!!");
        }
        pacientes[fim] = dado;
        fim = (fim + 1) % pacientes.length;
        total++;
    }

    //retira dado da fila
    public Paciente dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("==>Fila Vazia!!");
        }
        Paciente dado = pacientes[inicio];
        inicio = (inicio + 1) % pacientes.length;
        total--;
        return dado;
    }

    //verifica se a fila está vazia
    public boolean isEmpty() {
        return total == 0;
    }

    //verifica se a fila está cheia
    public boolean isFull() {
        return total == pacientes.length;
    }

    //retorna o total de dados da fila
    public int size() {
        return total;
    }

    //retorna dado do início da fila sem remover
    public Paciente front() {
        if (isEmpty()) {
            throw new RuntimeException("==>Fila Vazia!!");
        }
        return pacientes[inicio];
    }

    //método sobrescrito para visualizar os dados da fila, utilizando a biblioteca StringBuilder para melhor desempenho
    @Override
    public String toString() {
        StringBuilder saida = new StringBuilder();
        int max = total + inicio;

        for (int i = inicio; i < max; i++) {
            saida.append(pacientes[i % pacientes.length]).append(" ");
        }
        return saida.toString();
    }
}
