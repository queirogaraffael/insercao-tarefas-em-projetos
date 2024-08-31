package entities;


import java.time.LocalDate;

public class TarefaComPrazo extends Tarefa {
    private LocalDate prazo;

    public TarefaComPrazo(String descricao, Prioridade prioridade, LocalDate prazo) {
        super(descricao, prioridade);
        this.prazo = prazo;
    }

    public LocalDate getPrazo() {
        return prazo;
    }

    public void setPrazo(LocalDate prazo) {
        this.prazo = prazo;
    }

    private String determinaStatusDePrazo() {
        boolean prazoFoiCumprido = this.prazo.isEqual(LocalDate.now()) || this.prazo.isBefore(LocalDate.now());

        if (prazoFoiCumprido) {
            return "dentro do prazo.";
        } else {
            return "fora do prazo.";
        }
    }


    @Override
    public void executar() {
        System.out.println("A tarefa com prazo "+ this.prazo + " e descrição "+ getDescricao() + " está sendo executada " + determinaStatusDePrazo());
        setStatus(Status.DOING);
    }

    @Override
    public void finalizar() {
        System.out.println("A tarefa com prazo "+ this.prazo + " e descricao "+  getDescricao() + " está finalizada " + determinaStatusDePrazo());
        setStatus(Status.DONE);
    }

    @Override
    public String toString() {
        return  "O tarefa "+ getDescricao() + " tem prazo " +getPrazo();
    }

}