package leonardo_matheus.e_commerce.Database;

/**
 * Created by Streisky on 05/10/2017.
 */

public class Produtos {
    private int id;
    private String Nome;
    private double Valor;
    private int Quantidade;
    private String Tipo;
    private String Descricao;

    public Produtos(String nome, double valor, int quantidade, String tipo, String descricao) {
        setNome(nome);
        setValor(valor);
        setQuantidade(quantidade);
        setTipo(tipo);
        setDescricao(descricao);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public double getValor() {
        return Valor;
    }

    public void setValor(double valor) {
        Valor = valor;
    }

    public int getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(int quantidade) {
        Quantidade = quantidade;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }
}
