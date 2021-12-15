package View;

import Controller.LivroController;
import Model.Genero;
import Model.Livro;

import java.util.Scanner;

public class LivroView {
    private LivroController controller;

    public LivroView(LivroController controller){
        this.controller = controller;
    }

    public void Menu(){
        Scanner ler = new Scanner(System.in);

        while (true){
            System.out.println("Menu Livros");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Editar");


            int escolha = ler.nextInt();
            ler.nextLine();

            switch (escolha) {
                case 0: return;

                case 1:
                    CadastrarLivros();
                    break;

                case 2:
                    ListarLivros();
                    break;

                case 3:
                    EditarLivros();
                    break;


            }
        }
    }

    public void CadastrarLivros(){
        Scanner ler = new Scanner(System.in);
        Livro livro = new Livro();
        System.out.println("cadastre um livro");

        System.out.println("Qual o Titulo do Livro?");
        livro.setTitulo_livro(ler.nextLine());

        System.out.println("Qual o Genero do Livro?");
        livro.setNome_genero(ler.nextLine());

        controller.addLivros(livro);

    }

    public void ListarLivros(){
        for (Livro livro : controller.getModels()) {
            System.out.printf("%d - %s\n", livro.getId_livro(), livro.getTitulo_livro());
        }
    }

    public void EditarLivros(){
        if (controller.getModels().size() == 0) {
            System.out.println("Não tem livro pra editar");
            return;
        }
        Scanner ler = new Scanner(System.in);

        System.out.println("Escolha um ID de livro: ");
        Long id = ler.nextLong();
        ler.nextLine();

        Livro escolha = controller.getById(id);
        if (escolha == null) {
            System.out.println("Livro não encontrado");
            return;
        }
        edite(escolha);
    }

    public void edite(Livro livro) {
        Scanner ler = new Scanner(System.in);
        while (true){
            System.out.println("Edite um livro:");
            System.out.printf("%s \n", livro.getTitulo_livro());

            System.out.println("Escolha um novo nome: ");
            livro.setTitulo_livro(ler.nextLine());

            System.out.println("Escolha um novo genero: ");
            livro.setNome_genero(ler.nextLine());

            controller.editeLivro(livro);
            break;
        }
    }


}
