package Model;

public class Cliente {
    private String nome;
    private String tipo;
    private double fidelidade;
    private String logradouro;
    private String bairro;
    private String cidade;
    private String cupom;

    public Cliente(String nome, String tipo, double fidelidade, String logradouro, String bairro, String cidade, String cupom) {
        this.nome = nome;
        this.tipo = tipo;
        this.fidelidade = fidelidade;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cupom = cupom;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public double getFidelidade() {
        return fidelidade;
    }

    public String getCupom() { return cupom; }

    public void setFidelidade( double fidelidade) {
        this.fidelidade = fidelidade;
    }

    public String toString() {
        return "Model.Cliente {" +
                "nome ='" + getNome() + '\'' +
                ", tipo =" + getTipo() +
                ", fidelidade =" + getFidelidade() +
                ", logradouro =" + getLogradouro() +
                ", bairro =" + getBairro() +
                ", cidade =" + getCidade() +
                ", cupom =" + getCupom() +
                '}';
    }
}
