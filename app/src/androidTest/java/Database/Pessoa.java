package Database;

/**
 * Created by leoal on 01/10/2017.
 */

public class Pessoa {
    private int id;
    private String Nome;
    private String Email;
    private String Senha;
    private int CPF;
    private String CEP;
    private String Cidade;
    private String Pais;
    private String Estado;
    private String Telefone;

    public Pessoa(String nome, String CEP, String cidade, String pais, String estado, String telefone) {
        this.setNome(nome);
        this.setCEP(CEP);
        this.setCidade(cidade);
        this.setPais(pais);
        this.setEstado(estado);
        this.setTelefone(telefone);
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

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String cidade) {
        Cidade = cidade;
    }

    public String getPais() {
        return Pais;
    }

    public void setPais(String pais) {
        Pais = pais;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String telefone) {
        Telefone = telefone;
    }

}
