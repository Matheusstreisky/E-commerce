package leonardo_matheus.e_commerce.Database;


public class Pessoas {
    private int id;
    private String Nome;
    private String Senha;
    private String CPF;
    private String DataNascimento;

    public Pessoas(String nome, String senha, String CPF, String dataNascimento) {
        setNome(nome);
        setSenha(senha);
        setCPF(CPF);
        setDataNascimento(dataNascimento);
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

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        Senha = senha;
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
}
