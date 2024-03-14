package site.andreantunes.crudmusic;

import site.andreantunes.crudmusic.services.ArtistaRepository;

import java.util.Scanner;

public class App {
    // variaveis gerais
    private Scanner scanner = new Scanner(System.in);
    private ArtistaRepository repo;

    public App(ArtistaRepository repo) {
        this.repo = repo;
    }


    public void menu() {
        String escolher = "";

        while (!escolher.equals("9")) {
            System.out.println("""
                Escolha uma opção:
                
                1 - Cadastrar Artista
                2 - Cadastrar Musica
                3 - Listar Musicas
                4 - Listar musicas do artista
                5 - Descrever artista (GPT)
                
                9 - sair
            """);
            escolher = scanner.nextLine();
            switch (escolher) {
                case "1":
                    cadastrarArtista();
                    break;
                case "2":
                    cadastrarMusica();
                    break;
                case "3":
                    listarMusicas();
                    break;
                case "4":
                    listarMusicaArtista();
                    break;
                case "5":
                    descreverGPT();
                    break;
                case "9":
                default:
                    break;
            }
        }



    }

    private void cadastrarArtista() {
        System.out.print("Nome: ");
        String artista = scanner.nextLine();
        System.out.print("Tipo: ");
    }

    private void cadastrarMusica() {
    }

    private void listarMusicas() {
    }

    private void listarMusicaArtista() {
    }

    private void descreverGPT() {
    }


    // cadastrar artista (tipo enum)

    // cadastra musica
    // listar musicas
    // listar musicas por artista
    // descrever artista (gpt)
}
