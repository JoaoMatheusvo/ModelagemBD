package DAO;

import ConexaoBD.ConexaoBD;
import Entity.Livro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LivroDAO {
    private Connection connection;

    public LivroDAO() throws SQLException{
        this.connection = ConexaoBD.getInstancia().getConnection();

    }
    public void inserirLivro(Livro livro) throws SQLException{
        String sql = "INSERT INTO Livro (Titulo, Ano_Publicacao, ID_Autor) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setString(1,livro.getTitulo());
            stmt.setInt(2,livro.getAnoPublicado());
            stmt.setInt(3,livro.getIdAutor());
            stmt.executeUpdate();


        }
    }

    public void atualizaLivro(Livro livro)throws SQLException{
        String sql = "UPDATE Livro SET Titulo = ?, Ano_Publicacao = ?, ID_Autor = ? WHERE ID_Livro = ?";
        try(PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, livro.getTitulo());
            stmt.setInt(2, livro.getAnoPublicado());
            stmt.setInt(3, livro.getIdAutor());
            stmt.setInt(4,livro.getIdLivro());
            stmt.executeUpdate();

        }
    }

    public void excluirLivro(int idLivro) throws SQLException {
        String sql = "DELETE FROM Livro WHERE ID_Livro = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idLivro);
            stmt.executeUpdate();
        }
    }

    public List<Livro>listarLivros() throws SQLException{
        List<Livro>livros = new ArrayList<>();
        String sql = "SELECT * FROM Livro";

        try(Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            while (rs.next()){
                Livro livro = new Livro();
                livro.setIdLivro(rs.getInt("ID_Livro"));
                livro.setTitulo(rs.getString("Titulo"));
                livro.setAnoPublicado(rs.getInt("Ano_Publicacao"));
                livro.setIdAutor(rs.getInt("ID_Autor"));
                livros.add(livro);
            }
        }
        return livros;
    }

    public List<Livro> listarLivrosPorAutor(int idAutor) throws SQLException {
        List<Livro> livros = new ArrayList<>();
        String sql = "SELECT * FROM Livro WHERE ID_Autor = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idAutor);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Livro livro = new Livro();
                    livro.setIdLivro(rs.getInt("ID_Livro"));
                    livro.setTitulo(rs.getString("Titulo"));
                    livro.setAnoPublicado(rs.getInt("Ano_Publicacao"));
                    livro.setIdAutor(rs.getInt("ID_Autor"));
                    livros.add(livro);
                }
            }
        }
        return livros;
    }
}
