package Model;

public class Item {
    private String nome;
    private int quantidade;
    private double valorUnitario;
    private String tipo;

    public Item(String nome, int quantidade, double valorUnitario, String tipo) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
        this.tipo = tipo;
    }

    public double getValorTotal() {
        return valorUnitario * quantidade;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "Pessoa {" +
                "nome='" + nome + '\'' +
                ", quantidade=" + quantidade +
                ", valorUnitario=" + valorUnitario +
                ", tipo=" + tipo +
                '}';
        }
}