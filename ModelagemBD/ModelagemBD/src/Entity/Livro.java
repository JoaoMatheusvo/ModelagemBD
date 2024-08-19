package Entity;

import java.sql.Date;
import java.time.Year;

public class Livro {
    private int idLivro;
    private String titulo;
    private int anoPublicado;
    private int idAutor;

    public int getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnoPublicado() {
        return anoPublicado;
    }

    public void setAnoPublicado(int anoPublicado) {
        this.anoPublicado = anoPublicado;
    }

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "idLivro = " + idLivro +
                ", titulo ='" + titulo + '\'' +
                ", anoPublicado = " + anoPublicado +
                ", idAutor = " + idAutor +
                '}';
    }
}
