package leonardo_matheus.e_commerce.Recycler;

/**
 * Created by leoal on 24/09/2017.
 */


public class Manga {
    private String nome;
    private String autor;
    private int cover;

    public Manga() {
    }

    public Manga(String nome, String autor, int cover) {
        this.nome = nome;
        this.autor = autor;
        this.cover = cover;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getCover() { return cover; }

    public void setCover(int cover) { this.cover = cover; }
}
