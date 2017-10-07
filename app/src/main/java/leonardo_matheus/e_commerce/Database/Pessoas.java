package leonardo_matheus.e_commerce.Database;


public class Pessoas {
    private int id;
    private String Nome;
    private String CPF;
    private String DataNascimento;
    private String Senha;

    public Pessoas(String nome, String CPF, String dataNascimento, String senha) {
        setNome(nome);
        this.setCPF(CPF);
        setDataNascimento(dataNascimento);
        setSenha(senha);
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

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getDataNascimento() {
        return DataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        DataNascimento = dataNascimento;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }
}
