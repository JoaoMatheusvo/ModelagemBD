import DAO.AutorDAO;
import DAO.LivroDAO;
import Entity.Autor;
import Entity.Livro;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            AutorDAO autorDAO = new AutorDAO();
            LivroDAO livroDAO = new LivroDAO();

            // Listar autores e livros associados diretamente no loop
            System.out.println("\nLista de autores:");
            for (Autor a : autorDAO.listarAutores()) {
                System.out.println(a);
            }

            System.out.println("\nLista de Livros:");
            for (Livro l : livroDAO.listarLivros()) {
                System.out.println(l);
            }

            System.out.println("\nLivros por autor:");
            for (Autor a : autorDAO.listarAutores()) {
                System.out.println("Autor: " + a.getNome() +  " (ID: " + a.getIdAutor() + ")" + "\nNacionalidade: " + a.getNacionalidade() );
                for (Livro l : livroDAO.listarLivrosPorAutor(a.getIdAutor())) {
                    System.out.println("\nTitulo do Livro: " + l.getTitulo() + " (ID: " + l.getIdLivro() + ")");
                    System.out.println("Ano de Publicação: " + l.getAnoPublicado());
                    System.out.println("ID do Autor: " + l.getIdAutor());
                }
                if (livroDAO.listarLivrosPorAutor(a.getIdAutor()).isEmpty()) {
                    System.out.println("Nenhum livro encontrado para este autor.");
                }
                System.out.println(); // Linha em branco para separação
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
