package leonardo_matheus.e_commerce.Database;

/**
 * Created by Streisky on 18/09/2017.
 */

public class Fornecedores {

    private int id;
    private String Nome;
    private String CEP;
    private String Cidade;
    private String Pais;
    private String Estado;
    private String Telefone;
    private String Complemento;

    public Fornecedores(String nome, String CEP, String cidade, String pais, String estado, String telefone, String complemento) {
        this.setNome(nome);
        this.setCEP(CEP);
        this.setCidade(cidade);
        this.setPais(pais);
        this.setEstado(estado);
        this.setTelefone(telefone);
        this.setcomplemento(complemento);
    }

    public Fornecedores() {

    }


    public int getid() {
        return id;
    }

    public void setid(int id) {
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

    public String getcomplemento() {
        return Complemento;
    }

    public void setcomplemento(String complemento) {
        complemento = complemento;
    }
}
