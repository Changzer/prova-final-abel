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

    public Biblioteca getById(Long id){
        String sql = "SELECT * FROM biblioteca WHERE id_biblioteca = ?";
        Biblioteca biblioteca = null;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1,id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                biblioteca = new Biblioteca();
                biblioteca.setId_biblioteca(resultSet.getLong("id_biblioteca"));
                biblioteca.setNome_biblioteca(resultSet.getString("nome_biblioteca"));
            }
        }   catch (SQLException e) {
            throw new RuntimeException(e);
        } return biblioteca;
    }

    private InventarioDAO inventarioDAO = new InventarioDAO();
    public void addInventario(Biblioteca biblioteca, Livro livro, String titulo_livro) throws SQLException{
        inventarioDAO.addInventario(biblioteca,livro, titulo_livro);
    }

    public List<Livro> bibliotecaInventario(Long id) {
     return inventarioDAO.bibliotecaInventario(id);
    }
}
