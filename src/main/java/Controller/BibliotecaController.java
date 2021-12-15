package Controller;

import DAO.BibliotecaDAO;
import DAO.InventarioDAO;
import DAO.LivroDAO;
import Model.Biblioteca;
import Model.Livro;
import View.BibliotecaView;

import java.sql.SQLException;
import java.util.List;

public class BibliotecaController {
    private BibliotecaView view;
    private BibliotecaDAO dao = new BibliotecaDAO();
    private InventarioDAO daoinventario = new InventarioDAO();

    public BibliotecaController(){
        this.view = new BibliotecaView(this);
    }


    public void start(){
        view.menu();
    }

    public Biblioteca addBiblioteca(Biblioteca biblioteca) {
        return dao.createBiblioteca(biblioteca);
    }

    public List<Biblioteca> getModels() {return dao.listBiblioteca();}

    public Biblioteca getById(Long id){
        return dao.getById(id);
    }

    public void addInventario(Biblioteca biblioteca, Livro livro) throws SQLException {
        dao.addInventario(biblioteca, livro);
    }

}
