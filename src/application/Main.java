package application;

import entities.Projeto;
import entities.Tarefa;
import entities.TarefaSimples;
import entities.TarefaComPrazo;
import interfaces.Executavel;


import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {

        System.out.println("---------------------------------------------");
        Tarefa a1 = new TarefaSimples("Tarefa 1", Tarefa.Prioridade.BAIXA);
        System.out.println(a1);
        a1.executar("Andrey");
        a1.setPrioridade(Tarefa.Prioridade.MEDIA);
        System.out.println(a1);
        a1.finalizar();


        System.out.println("---------------------------------------------");
        Executavel a2 = new TarefaSimples("Tarefa 2", Tarefa.Prioridade.ALTA);
        System.out.println(a2);
        //Por que a linha comentada abaixo gera um erro? Neste caso, o que você faria se
        // mudar a prioridade fosse importante para seu problema?
        //a2.setPrioridade(Prioridade.media).
        // RESPOSTA: O erro ocorre porque o upcasting de TarefaSimples para Executavel
        // faz com que a variavel a2 seja tratada como uma instância de Executavel,
        // que nao tem o metodo setPrioridade(Prioridade).
        // Para solucionar esse problemas eu evitaria fazer o upcasting ou
        // faria um downcasting para acessar o metodo especifico setPrioridade(Prioridade),
        // desde que fosse garantido que a2 realmente é uma instancia de TarefaSimples.


        // nesse caso vai ser sempre verdadeira, mas uma forma de garantir..
        if (a2 instanceof TarefaSimples) {
            TarefaSimples tarefa = (TarefaSimples) a2;
            tarefa.setPrioridade(Tarefa.Prioridade.BAIXA);
        } else {
            System.out.println("a2 nao e uma instancia de TarefaSimples");
        }

        a2.executar();
        System.out.println(a2);
        a2.finalizar();


        System.out.println("---------------------------------------------");
        // Codigo foi modificado para mostrar se Tarefa com prazo está/foi finalizada
        // dentro ou fora do prazo.
        Executavel a3 = new TarefaComPrazo("Tarefa 3", Tarefa.Prioridade.MEDIA, LocalDate.of(2024, 8, 31));
        System.out.println(a3);
        a3.executar();
        System.out.println(a3);
        a3.finalizar();


        System.out.println("---------------------------------------------");
        Projeto p1 = new Projeto("Projeto OO", LocalDate.of(2024, 9, 10), LocalDate.of(2024, 11, 30));

        Tarefa tarefaTODO = new TarefaSimples("-Tarefa simples com Status TODO-", Tarefa.Prioridade.ALTA);
        Executavel tarefaTODO2 = new TarefaComPrazo("Tarefa TODO 2", Tarefa.Prioridade.MEDIA, LocalDate.of(2024, 2, 11));

        // nao estao com status TO-DO
        p1.addTarefas(a1);
        p1.addTarefas(a2);
        p1.addTarefas(a3);

        // adicionado com sucesso, pois tem status to-do
        p1.addTarefas(tarefaTODO);

        // Tarefa com prazo fora do intervalo do projeto nao sera adicionada
        p1.addTarefas(tarefaTODO2);

        System.out.println();

        System.out.println(p1);
    }
}