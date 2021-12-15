import Controller.BibliotecaController;
import Controller.LivroController;
import DAO.BibliotecaDAO;
import DAO.GeneroDAO;
import DAO.InventarioDAO;
import DAO.LivroDAO;

public class Main {
    public static void initDatabase(){

        new LivroDAO().createLivroTable();
        new GeneroDAO().createGeneroTable();
        new BibliotecaDAO().createBibliotecaTable();
        new InventarioDAO().createInventarioTable();

    }

    public static void startApplication() {
        initDatabase();
    }

    public static void main(String[] args) {
        startApplication();


        BibliotecaController controller = new BibliotecaController();
        controller.start();
    }

}
