package DAO;

import Factory.ConnectionFactory;
import Model.Biblioteca;
import Model.Livro;

import java.sql.*;

public class InventarioDAO {
    private String tableName = "inventario";
    private Connection connection = new ConnectionFactory().getConnection();



    public void createInventarioTable(){
        String sql = "CREATE SEQUENCE IF NOT EXISTS inventario_id_seq;";

        sql += "CREATE TABLE IF NOT EXISTS " + tableName + " (" +
                "id_biblioteca BIGINT, " +
                "id_livro BIGINT, " +
                "titulo_livro TEXT, " +
                "PRIMARY KEY (id_biblioteca, id_livro, titulo_livro), " +
                "CONSTRAINT fk_biblioteca_livro_biblioteca_id " +
                    "FOREIGN KEY (id_livro)" +
                    "REFERENCES livro(id_livro), " +
                "CONSTRAINT fk_biblioteca_livro_livro_id " +
                    "FOREIGN KEY (id_livro) " +
                    "REFERENCES livro(id_livro) " +
                ");";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();
            statement.close();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void addInventario(Biblioteca biblioteca, Livro livro) throws SQLException {
        if(biblioteca != null && livro != null ){
            String sql = "INSERT INTO " + tableName +
                    "(id_biblioteca, id_livro)" +
                    "VALUES (?, ?)";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setLong(1, biblioteca.getId_biblioteca());
            statement.setLong(2, livro.getId_livro());

            statement.execute();
        }
    }


}
