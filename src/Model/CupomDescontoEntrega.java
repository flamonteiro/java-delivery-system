package Model;

public class CupomDescontoEntrega {
    private String nomeMetodo;
    private double valorDesconto;

    public CupomDescontoEntrega(String nomeMetodo, double valorDesconto) {
        this.nomeMetodo = nomeMetodo;
        this.valorDesconto = valorDesconto;
    }

    public double getValorDesconto() {
        return valorDesconto;
    }

    public String getNomeMetodo() {
        return nomeMetodo;
    }

    public String toString() {
        return "Model.CupomDescontoEntrega {" + "nomeMetodo ='" + nomeMetodo + '\'' + ", valorDesconto =" + valorDesconto + "}\n";
    }
}
