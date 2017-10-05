package leonardo_matheus.e_commerce.Recycler;

/**
 * Created by leoal on 04/10/2017.
 */

public class Novel {
    private String nome;
    private String autor;
    private int cover;

    public Novel(String nome, String autor, int cover) {
        this.setNome(nome);
        this.setAutor(autor);
        this.setCover(cover);
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

    public int getCover() {
        return cover;
    }

    public void setCover(int cover) {
        this.cover = cover;
    }
}
