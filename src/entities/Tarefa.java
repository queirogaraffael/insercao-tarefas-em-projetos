package entities;


import interfaces.Executavel;

public abstract class Tarefa implements Executavel {

    private String descricao;
    private Status status;
    private Prioridade prioridade;

    protected enum Status{TODO, DOING, DONE}
    public enum Prioridade{BAIXA, MEDIA, ALTA}

    protected Tarefa(String descricao, Prioridade prioridade) {
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.status = Status.TODO;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    protected Status getStatus() {
        return status;
    }

    protected void setStatus(Status status) {
        this.status = status;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    @Override
    public String toString() {
        return "A tarefa com descricao "+ this.descricao + " tem priodade "+ this.prioridade + " e status " + this.status;
    }

    @Override
    public void executar() {
        System.out.println("A tarefa "+ this.descricao + " está sendo executada.");
        setStatus(Status.DOING);
    }

    public void executar(String nome) {
        System.out.println("A tarefa" + this.descricao + " está sendo executada por "+ nome);
    }

    @Override
    public void finalizar() {
        System.out.println("A tarefa "+ this.descricao + " foi finalizada.");
        setStatus(Status.DONE);

    }
}