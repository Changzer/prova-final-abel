package View;

import Controller.BibliotecaController;
import Controller.GeneroController;
import Controller.LivroController;
import Model.Biblioteca;
import Model.Livro;

import java.sql.SQLException;
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
            System.out.println("5 - Inventario");

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

                case 5:

                        inventario();

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
        for (Biblioteca biblioteca : controller.getModels()) {
            System.out.printf("%d - %s\n", biblioteca.getId_biblioteca(), biblioteca.getNome_biblioteca());
        }
    }

    public void Livros(){
        LivroController controller = new LivroController();
        controller.start();
    }

    public void Genero(){
        GeneroController controller = new GeneroController();
        controller.start();
    }

    public void inventario() {

        System.out.println("adicionar livros ao inventario");

        if (controller.getModels().size() == 0) {
            System.out.println("não tem biblioteca aqui!");
            return;
        }

        Scanner ler = new Scanner(System.in);

        System.out.println("Selecione uma biblioteca por ID:");
        Long id = ler.nextLong();
        ler.nextLine();

        Biblioteca escolha = controller.getById(id);
        if (escolha == null) {
            System.out.println("biblioteca nao encontrada!");
            return;
        }

        System.out.println("Selecione um livro por ID:");
        ler.nextLine();

        LivroController controller2 = new LivroController();
        Livro escolha2 = controller2.getById(id);
        if (escolha == null) {
            System.out.println("livro nao encontrado!");
            return;
        }

        adicione(escolha,escolha2);




    }

    private void adicione(Biblioteca biblioteca, Livro livro) {

        System.out.printf("Livro: < %s > Adicionado à < %s >\n", livro.getTitulo_livro(), biblioteca.getNome_biblioteca());




    }

}
