package DAO;

import Factory.ConnectionFactory;
import Model.Genero;
import Model.Livro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GeneroDAO {

    private String tableName = "genero";
    private Connection connection = new ConnectionFactory().getConnection();

    public void createGeneroTable(){
        String sql = "CREATE SEQUENCE IF NOT EXISTS genero_id_seq;";

        sql += "CREATE TABLE IF NOT EXISTS " + tableName + "(" +
                "id_genero BIGINT PRIMARY KEY DEFAULT nextval('genero_id_seq')," +
                "nome_genero TEXT NOT NULL)";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();
            statement.close();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }

    }


    public Genero createGenero(Genero genero) {
        if (genero != null) {
            String sql = "INSERT INTO " + tableName + " (" +
                    "nome_genero)" + "VALUES (?)";

            try {
                PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

                statement.setString(1, genero.getNome_genero());
                statement.execute();
                ResultSet resultSet = statement.getGeneratedKeys();

                while (resultSet.next()) {
                    genero.setId_genero(resultSet.getLong(1));
                }
                return genero;
            } catch (SQLException e){
                return null;
            }
        }
        return null;
    }

    public List<Genero> listGenero(){
        String sql = "SELECT * FROM " + tableName;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            List<Genero> generoList = new ArrayList<>();
            while (resultSet.next()) {
                Genero novoGenero = new Genero();
                novoGenero.setId_genero(resultSet.getLong("id_genero"));
                novoGenero.setNome_genero(resultSet.getString("nome_genero"));

                generoList.add(novoGenero);
            }
            return generoList;
        }   catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

}
