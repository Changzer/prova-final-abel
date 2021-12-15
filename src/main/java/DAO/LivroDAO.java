package DAO;

import Factory.ConnectionFactory;
import Model.Biblioteca;
import Model.Livro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LivroDAO {

    private String tableName = "livro";
    private Connection connection = new ConnectionFactory().getConnection();
    private InventarioDAO inventarioDAO = new InventarioDAO();


    public void createLivroTable(){
        String sql = "CREATE SEQUENCE IF NOT EXISTS livro_id_seq;";

        sql += "CREATE TABLE IF NOT EXISTS " + tableName + "(" +
                "id_livro BIGINT PRIMARY KEY DEFAULT nextval('livro_id_seq')," +
                "titulo_livro TEXT NOT NULL," +
                "nome_genero TEXT " +
                ")";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.execute();
            statement.close();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public Livro createLivro(Livro livro){
        if (livro != null) {
            String sql = "INSERT INTO " + tableName + " (" +
                    "titulo_livro, nome_genero)" + "VALUES (?, ?)";

            try {
                PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

                statement.setString(1, livro.getTitulo_livro());
                statement.setString(2,livro.getNome_genero());
                statement.execute();
                ResultSet resultSet = statement.getGeneratedKeys();

                while (resultSet.next()) {
                    livro.setId_livro(resultSet.getLong(1));
                }
                return livro;
            } catch (SQLException e){
                return null;
            }
        }
        return null;
    }

    public List<Livro> listLivros(){
        String sql = "SELECT * FROM " + tableName;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            List<Livro> livroList = new ArrayList<>();
            while (resultSet.next()) {
                Livro novoLivro = new Livro();
                novoLivro.setId_livro(resultSet.getLong("id_livro"));
                novoLivro.setTitulo_livro(resultSet.getString("titulo_livro"));

                livroList.add(novoLivro);
            }
            return livroList;
        }   catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void editeLivro(Livro livro){
        String sql = "UPDATE " + tableName + " SET titulo_livro = ?, nome_genero = ?" +
                " WHERE id_livro = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, livro.getTitulo_livro());
            statement.setString(2, livro.getNome_genero());
            statement.setLong(3, livro.getId_livro());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Livro getById(Long id){
        String sql = "SELECT * FROM livro WHERE id_livro = ?";
        Livro livro = null;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1,id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                livro = new Livro();
                livro.setId_livro(resultSet.getLong("id_livro"));
                livro.setTitulo_livro(resultSet.getString("titulo_livro"));
            }
        }   catch (SQLException e) {
            throw new RuntimeException(e);
        } return livro;
    }

    public void addInventario(Biblioteca biblioteca, Livro livro) throws SQLException, NullPointerException {
        inventarioDAO.addInventario(biblioteca, livro, livro.getTitulo_livro());
    }
}
