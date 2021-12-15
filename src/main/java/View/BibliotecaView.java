package View;

import Controller.BibliotecaController;
import Controller.GeneroController;
import Controller.LivroController;
import Model.Biblioteca;
import Model.Genero;
import Model.Livro;

import java.util.Scanner;

public class BibliotecaView {

    private BibliotecaController controller;

    public BibliotecaView(BibliotecaController controller) {
        this.controller = controller;
    }

    public void menu(){
        Scanner ler = new Scanner(System.in);

        while(true) {
            System.out.println("Bem vindo a biblioteca");
            System.out.println("1 - Cadastrar Biblioteca");
            System.out.println("2 - Listar Biblioteca");
            System.out.println("3 - Livros");
            System.out.println("4 - Generos");

            int escolha = ler.nextInt();
            ler.nextLine();

            switch (escolha) {
                case 0: return;

                case 1:
                    CadastrarBiblioteca();
                    break;

                case 2:
                    ListarBiblioteca();
                    break;

                case 3:
                    Livros();
                    break;

                case 4:
                    Genero();
                    break;

            }
        }
    }

    public void CadastrarBiblioteca(){

        Scanner ler = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();
        System.out.println(" Nomeie uma Biblioteca ");
        biblioteca.setNome_biblioteca(ler.nextLine());

        controller.addBiblioteca(biblioteca);

    }

    public void ListarBiblioteca(){

    }

    public void Livros(){
        LivroController controller = new LivroController();
        controller.start();
    }

    public void Genero(){
        GeneroController controller = new GeneroController();
        controller.start();
    }

}
