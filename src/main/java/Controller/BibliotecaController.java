package Controller;

import DAO.BibliotecaDAO;
import Model.Biblioteca;
import View.BibliotecaView;

public class BibliotecaController {
    private BibliotecaView view;
    private BibliotecaDAO dao = new BibliotecaDAO();

    public BibliotecaController(){
        this.view = new BibliotecaView(this);
    }


    public void start(){
        view.menu();
    }

    public Biblioteca addBiblioteca(Biblioteca biblioteca) {
        return dao.createBiblioteca(biblioteca);
    }
}
