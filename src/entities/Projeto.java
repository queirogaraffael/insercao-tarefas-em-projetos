package entities;


import interfaces.Executavel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Projeto {

    private String nome;
    private LocalDate inicio;
    private LocalDate fim;
    private List<Executavel> tarefas;

    public Projeto(String nome, LocalDate inicio, LocalDate fim) {
        this.nome = nome;
        this.inicio = inicio;
        this.fim = fim;
        tarefas = new ArrayList<>();
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public LocalDate getInicio() {
        return inicio;
    }

    public void setInicio(LocalDate inicio) {
        this.inicio = inicio;
    }

    public LocalDate getFim() {
        return fim;
    }

    public void setFim(LocalDate fim) {
        this.fim = fim;
    }

    public List<Executavel> getTarefas() {
        return tarefas;
    }

    public void setTarefas(List<Executavel> tarefas) {
        this.tarefas = tarefas;
    }

    public void addTarefas(Executavel tarefa) {

        if (tarefa instanceof TarefaComPrazo tarefaComPrazo) {
            if (tarefaComPrazo.getPrazo().isBefore(this.inicio) || tarefaComPrazo.getPrazo().isAfter(fim)) {
                System.out.println("Nao foi possivel adicionar a tarefa: " + tarefaComPrazo.getDescricao() + ", pois o prazo esta fora do intervalo de tempo do projeto.");
                return;
            }
        }

        if (tarefa instanceof Tarefa tarefaT) {
            if (tarefaT.getStatus() != Tarefa.Status.TODO) {
                System.out.println("Nao foi possivel adicionar tarefa: " + tarefaT.getDescricao() +" ao projeto, pois a tarefa tem status diferente de TODO");
                return;
            }
        }

        this.tarefas.add(tarefa);
    }


    @Override
    public String toString() {
        String retorno = "O projeto " + getNome() + " com data de inicio " + getInicio()+ " e data de fim "+ getFim() + "\n";

        if (!tarefas.isEmpty()) {
            for (Executavel executavel : tarefas) {
                retorno += executavel.toString() + "\n";
            }
        }

        return retorno ;
    }

}