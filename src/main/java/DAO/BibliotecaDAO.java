package DAO;

import Factory.ConnectionFactory;
import Model.Biblioteca;
import Model.Livro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BibliotecaDAO {

    private String tableName = "biblioteca";
    private Connection connection = new ConnectionFactory().getConnection();


    public void createBibliotecaTable(){
        String sql = "CREATE SEQUENCE IF NOT EXISTS biblioteca_id_seq;";

        sql += "CREATE TABLE IF NOT EXISTS " + tableName + "(" +
                "id_biblioteca BIGINT PRIMARY KEY DEFAULT nextval('biblioteca_id_seq')," +
                "nome_biblioteca TEXT NOT NULL," +
                "titulo_livro TEXT )";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.execute();
            statement.close();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public Biblioteca createBiblioteca(Biblioteca biblioteca){
        if (biblioteca != null) {
            String sql = "INSERT INTO " + tableName + " (nome_biblioteca) " + " VALUES (?) ";

            try {
                PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

                statement.setString(1,biblioteca.getNome_biblioteca());
                statement.execute();
                ResultSet resultSet = statement.getGeneratedKeys();

                while ( resultSet.next()) {
                    biblioteca.setId_biblioteca(resultSet.getLong(1));
                } return biblioteca;
            } catch (SQLException e){
                return null;
            }

        } return null;
    }

    public List<Biblioteca> listBiblioteca() {
        String sql = "SELECT * FROM " + tableName;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            List<Biblioteca> bibliotecaList = new ArrayList<>();
            while (resultSet.next()) {
                Biblioteca novoBiblioteca = new Biblioteca();
                novoBiblioteca.setId_biblioteca(resultSet.getLong("id_biblioteca"));
                novoBiblioteca.setNome_biblioteca(resultSet.getString("nome_biblioteca"));

                bibliotecaList.add(novoBiblioteca);
            }
            return bibliotecaList;
        }   catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
