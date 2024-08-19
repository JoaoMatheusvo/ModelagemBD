import DAO.AutorDAO;
import DAO.LivroDAO;
import Entity.Autor;
import Entity.Livro;
import java.io.PrintStream;
import java.sql.SQLException;
import java.util.Iterator;

public class Main {
   public static void main(String[] args) {
      try {
         AutorDAO autorDAO = new AutorDAO();
         LivroDAO livroDAO = new LivroDAO();
         System.out.println("\nLista de autores:");
         Iterator var3 = autorDAO.listarAutores().iterator();

         Autor a;
         while(var3.hasNext()) {
            a = (Autor)var3.next();
            System.out.println(a);
         }

         System.out.println("\nLista de Livros:");
         var3 = livroDAO.listarLivros().iterator();

         while(var3.hasNext()) {
            Livro l = (Livro)var3.next();
            System.out.println(l);
         }

         System.out.println("\nLivros por autor:");

         for(var3 = autorDAO.listarAutores().iterator(); var3.hasNext(); System.out.println()) {
            a = (Autor)var3.next();
            PrintStream var10000 = System.out;
            String var10001 = a.getNome();
            var10000.println("Autor: " + var10001 + " (ID: " + a.getIdAutor() + ")\nNacionalidade: " + a.getNacionalidade());
            Iterator var5 = livroDAO.listarLivrosPorAutor(a.getIdAutor()).iterator();

            while(var5.hasNext()) {
               Livro l = (Livro)var5.next();
               var10000 = System.out;
               var10001 = l.getTitulo();
               var10000.println("\nTitulo do Livro: " + var10001 + " (ID: " + l.getIdLivro() + ")");
               System.out.println("Ano de Publicação: " + l.getAnoPublicado());
               System.out.println("ID do Autor: " + l.getIdAutor());
            }

            if (livroDAO.listarLivrosPorAutor(a.getIdAutor()).isEmpty()) {
               System.out.println("Nenhum livro encontrado para este autor.");
            }
         }
      } catch (SQLException var7) {
         var7.printStackTrace();
      }

   }
}
