package site.andreantunes.crudmusic.models;

import jakarta.persistence.*;

@Entity
public class Musica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String album;
    @ManyToOne
    private Artista artista;

    public Musica() {}
    public Musica(String nome, String album, Artista artista) {
        this.nome = nome;
        this.album = album;
        this.artista = artista;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    @Override
    public String toString() {
        return "nome='" + nome + '\'' +
                ", album='" + album + '\'' +
                ", artista=" + artista.getNome();
    }
}
