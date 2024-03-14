package site.andreantunes.crudmusic.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Artista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Enumerated(EnumType.STRING)
    private Tipo tipo;
    @OneToMany(mappedBy = "artista", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Musica> listaMusicas = new ArrayList<>();

    public Artista() {}

    public Artista(String nome, Tipo tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public List<Musica> getListaMusicas() {
        return listaMusicas;
    }

    public void adicionaMusica(Musica musica) {
        List<Musica> listaMusica = this.getListaMusicas();
        listaMusica.add(musica);
    }
}
