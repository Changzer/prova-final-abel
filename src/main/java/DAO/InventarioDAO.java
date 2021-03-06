package DAO;

import Factory.ConnectionFactory;
import Model.Biblioteca;
import Model.Livro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InventarioDAO {
    private String tableName = "inventario";
    private Connection connection = new ConnectionFactory().getConnection();



    public void createInventarioTable(){
        String sql = "CREATE SEQUENCE IF NOT EXISTS inventario_id_seq;";

        sql += "CREATE TABLE IF NOT EXISTS " + tableName + " (" +
                "id_biblioteca BIGINT NOT NULL, " +
                "id_livro BIGINT NOT NULL, " +
                "titulo_livro TEXT, " +
                "CONSTRAINT PK_inventario PRIMARY KEY (id_biblioteca, id_livro) " +
                ");";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();
            statement.close();
        } catch (SQLException e){
            throw new RuntimeException(e);

        }
    }

    public void addInventario(Biblioteca biblioteca, Livro livro, String titulo_livro) throws SQLException {
        if(biblioteca != null && livro != null ){
            String sql = "INSERT INTO " + tableName +
                    "(id_biblioteca, id_livro, titulo_livro)" +
                    "VALUES (?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setLong(1, biblioteca.getId_biblioteca());
            statement.setLong(2, livro.getId_livro());
            statement.setString(3, livro.getTitulo_livro());

            statement.execute();

        }
    }

    public List<Livro> bibliotecaInventario(Long id) {
        String sql = "SELECT id_livro, titulo_livro FROM inventario WHERE id_biblioteca = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1,id);
            ResultSet resultSet = statement.executeQuery();

            List<Livro> livroList = new ArrayList<>();
            while (resultSet.next()){
                Livro novoLivro = new Livro();
                novoLivro.setId_livro(resultSet.getLong("id_livro"));
                novoLivro.setTitulo_livro(resultSet.getString("titulo_livro"));

                livroList.add(novoLivro);
            }
            return livroList;
        }   catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
