package br.com.mdo.gooffice.domain.entity;
import br.com.mdo.gooffice.domain.model.Empregado;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Objects;

import static java.util.Objects.isNull;


@Entity
@Table(name = "allocation")
public class Locacao {

    public static final List<String> SORT_TABLE_FIELDS = List.of("dataInicio", "dataFim");

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Sala sala;

    @Embedded
    private Empregado empregado;

    @Column(name = "subject")
    private String subject;

    @Column(name = "start_at")
    private OffsetDateTime dataInicio;

    @Column(name = "end_at")
    private OffsetDateTime dataFim;

    @Column(name = "created_at")
    private OffsetDateTime dataCriacao;

    @Column(name = "update_at")
    private OffsetDateTime dataAtualizacao;

    public Locacao() {}

    public Locacao(Builder builder) {
        this.id = builder.id;
        this.sala = builder.sala;
        this.empregado = builder.empregado;
        this.subject = builder.subject;
        this.dataInicio = builder.dataInicio;
        this.dataFim = builder.dataFim;
        this.dataCriacao = builder.dataCriacao;
        this.dataAtualizacao = builder.dataAtualizacao;
    }

    @PrePersist
    public void prePersist(){
        if(isNull(dataCriacao)){
            dataCriacao = OffsetDateTime.now(); // criar dataUtils
        }
        dataAtualizacao = dataCriacao;
    }

    @PreUpdate
    public void preUpdate(){
        dataAtualizacao = OffsetDateTime.now(); // criar dataUtils
    }

    public Sala getSala() {
        return sala;
    }

    public Empregado getEmpregado() {
        return empregado;
    }

    public String getSubject() {
        return subject;
    }

    public OffsetDateTime getDataInicio() {
        return dataInicio;
    }

    public OffsetDateTime getDataFim() {
        return dataFim;
    }

    public OffsetDateTime getDataCriacao() {
        return dataCriacao;
    }

    public OffsetDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Locacao locacao = (Locacao) o;
        return id.equals(locacao.id) && sala.equals(locacao.sala) && empregado.equals(locacao.empregado) && subject.equals(locacao.subject) && dataInicio.equals(locacao.dataInicio) && dataFim.equals(locacao.dataFim) && dataCriacao.equals(locacao.dataCriacao) && dataAtualizacao.equals(locacao.dataAtualizacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sala, empregado, subject, dataInicio, dataFim, dataCriacao, dataAtualizacao);
    }

    @Override
    public String toString() {
        return "Locacao{" +
                "id=" + id +
                ", sala=" + sala +
                ", empregado=" + empregado +
                ", subject='" + subject + '\'' +
                ", dataInicio=" + dataInicio +
                ", dataFim=" + dataFim +
                ", dataCriacao=" + dataCriacao +
                ", dataAtualizacao=" + dataAtualizacao +
                '}';
    }


    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {
        public static List<String> SORT_TABLE_FIELDS = List.of("dataInicio", "dataFim");
        private Long id;
        private Sala sala;
        private Empregado empregado;
        private String subject;
        private OffsetDateTime dataInicio;
        private OffsetDateTime dataFim;
        private OffsetDateTime dataCriacao;
        private OffsetDateTime dataAtualizacao;

        private Builder() {
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder sala(Sala sala) {
            this.sala = sala;
            return this;
        }

        public Builder empregado(Empregado empregado) {
            this.empregado = empregado;
            return this;
        }

        public Builder subject(String subject) {
            this.subject = subject;
            return this;
        }

        public Builder dataInicio(OffsetDateTime dataInicio) {
            this.dataInicio = dataInicio;
            return this;
        }

        public Builder dataFim(OffsetDateTime dataFim) {
            this.dataFim = dataFim;
            return this;
        }

        public Builder dataCriacao(OffsetDateTime dataCriacao) {
            this.dataCriacao = dataCriacao;
            return this;
        }

        public Builder dataAtualizacao(OffsetDateTime dataAtualizacao) {
            this.dataAtualizacao = dataAtualizacao;
            return this;
        }

        public Locacao build() {
            return new Locacao(this);
        }
    }
}
