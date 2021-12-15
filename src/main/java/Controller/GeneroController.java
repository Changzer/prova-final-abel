package Controller;

import DAO.GeneroDAO;
import Model.Genero;
import View.GeneroView;

import java.util.List;

public class GeneroController {
    private GeneroView view;
    private GeneroDAO dao = new GeneroDAO();

    public GeneroController(){
        this.view = new GeneroView(this);
    }

    public Genero addGenero(Genero genero){
        return dao.createGenero(genero);
    }

    public void start() { view.menu();}

    public List<Genero>  getModels() {
        return dao.listGenero();
    }
}
