package br.com.mdo.gooffice.domain.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Empregado {

    @Column(name = "employee_name")
    private String nome;

    @Column(name = "employee_email")
    private String email;

    public Empregado(Builder builder) {
        this.nome = builder.nome;
        this.email = builder.email;
    }

    public Empregado(){}

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empregado empregado = (Empregado) o;
        return nome.equals(empregado.nome) && email.equals(empregado.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, email);
    }

    @Override
    public String toString() {
        return "Empregado{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {
        private String nome;
        private String email;

        private Builder() {
        }

        public Builder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Empregado build() {
            return new Empregado(this);
        }
    }
}
