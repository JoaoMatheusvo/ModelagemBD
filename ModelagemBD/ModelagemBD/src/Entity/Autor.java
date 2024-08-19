package Entity;

import java.util.ArrayList;

public class Autor {
    private int idAutor;
    private String nome;
    private String nacionalidade;


    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "idAutor = " + idAutor +
                ", nome ='" + nome + '\'' +
                ", nacionalidae ='" + nacionalidade + '\'' +
                '}';
    }
}
