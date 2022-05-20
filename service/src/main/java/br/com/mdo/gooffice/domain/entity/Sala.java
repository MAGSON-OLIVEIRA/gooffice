package br.com.mdo.gooffice.domain.entity;
 /*
    imultave
    definindo o construtor como private
    definir um construto vazio por causa da JPA
 */

import javax.persistence.*;

import static java.util.Objects.hash;
import static java.util.Objects.isNull;

@Entity
@Table(name="room")
public class Sala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String nome;

    @Column(name = "seats", nullable = false)
    private Integer assentos;

    @Column(name = "active", nullable = false)
    private Boolean ativo;

    private Sala(Builder builder) {
        this.id = builder.id;
        this.nome = builder.nome;
        this.assentos = builder.assentos;
        this.ativo = builder.ativo;
    }
    private Sala(){}

    @PrePersist
    public void prePersist(){
        if(isNull(ativo)){
            ativo = true;
        }
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Integer getAssentos() {
        return assentos;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sala sala = (Sala) o;
        return id.equals(sala.id) && nome.equals(sala.nome) && assentos.equals(sala.assentos) && ativo.equals(sala.ativo);
    }

    @Override
    public int hashCode() {
        return hash(id, nome, assentos, ativo);
    }

    @Override
    public String toString() {
        return "Sala{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", assentos=" + assentos +
                ", ativo=" + ativo +
                '}';
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {
        private Long id;
        private String nome;
        private Integer assentos;
        private Boolean ativo;

        private Builder() {
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public Builder assentos(Integer assentos) {
            this.assentos = assentos;
            return this;
        }

        public Builder ativo(Boolean ativo) {
            this.ativo = ativo;
            return this;
        }

        public Sala build() {
            return new Sala(this);
        }
    }
}
