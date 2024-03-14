package site.andreantunes.crudmusic;

import site.andreantunes.crudmusic.models.Artista;
import site.andreantunes.crudmusic.models.Musica;
import site.andreantunes.crudmusic.models.Tipo;
import site.andreantunes.crudmusic.services.ApiGPT;
import site.andreantunes.crudmusic.services.ArtistaRepository;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

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
        String nome = scanner.nextLine();
        System.out.print("Tipo (Solo, Dupla ou Banda): ");
        String tipo = scanner.nextLine();
        Artista artista = new Artista(nome, Tipo.converteTipo(tipo));
        repo.save(artista);
    }

    private void cadastrarMusica() {
        System.out.print("Nome do autor: ");
        String nome = scanner.nextLine();
        Optional<Artista> artista = repo.findByNomeContainingIgnoreCase(nome);

        if (artista.isPresent()) {
            System.out.println(artista.get().getNome());
            System.out.println("nome da musica: ");
            String nomeMusica = scanner.nextLine();
            System.out.println("Nome do album: ");
            String nomeAlbum = scanner.nextLine();

            Musica musica = new Musica(nomeMusica, nomeAlbum, artista.get());
            artista.get().adicionaMusica(musica);
            repo.save(artista.get());
        } else {
            System.out.println("Artista não encontrado, deseja cadastrar? (s/n)");
            String opcao = scanner.nextLine();
            if (opcao.equalsIgnoreCase("s")) {
                this.cadastrarArtista();
            }
        }

    }

    private void listarMusicas() {
        List<Artista> listaArtista = repo.findAll();
        List<Musica> musicas = listaArtista.stream().flatMap(a -> a.getListaMusicas().stream()).toList();
        musicas.forEach(System.out::println);
    }

    private void listarMusicaArtista() {
        System.out.println("nome do artista no qual deseja listar as musicas: ");
        String nomeArtista = scanner.nextLine();
        Optional<Artista> artista = repo.findByNomeContainingIgnoreCase(nomeArtista);

        if(artista.isPresent()) {
            artista.get().getListaMusicas().forEach(System.out::println);
        }  else {
            System.out.println("Artista não encontrado");
        }
    }

    private void descreverGPT() {
        System.out.println("nome do artista no qual deseja a descricao: ");
        String nomeArtista = scanner.nextLine();

        System.out.println(ApiGPT.obterDescricao(nomeArtista));
    }


    // cadastrar artista (tipo enum)

    // cadastra musica
    // listar musicas
    // listar musicas por artista
    // descrever artista (gpt)
}
