package View;

import Controller.GeneroController;
import Model.Genero;

import java.util.Scanner;

public class GeneroView {

    private GeneroController controller;

    public GeneroView(GeneroController controller) {
        this.controller = controller;
    }

    public void menu(){
        Scanner ler = new Scanner(System.in);

        while (true){
            System.out.println("Generos de Livros");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Editar");

            int escolha = ler.nextInt();
            ler.nextLine();

            switch (escolha){
                case 0: return;
                case 1:
                    CadastrarGenero();
                    break;

                case 2:
                    ListarGenero();
                    break;

                case 3:
                    break;
            }
        }
    }


    public void CadastrarGenero(){
        Scanner ler = new Scanner(System.in);
        Genero genero = new Genero();
        System.out.println("cadastre uma categoria");
        System.out.println("nome da categoria");
        genero.setNome_genero(ler.nextLine());

        controller.addGenero(genero);
    }

    public void ListarGenero(){
        for (Genero genero : controller.getModels()) {
            System.out.printf("%d - %s\n", genero.getId_genero(), genero.getNome_genero());
        }
    }

}
