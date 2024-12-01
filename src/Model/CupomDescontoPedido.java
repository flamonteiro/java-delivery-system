package Model;

public class CupomDescontoPedido {

        private String nomeMetodo;
        private double valorDesconto;

        public CupomDescontoPedido(String nomeMetodo, double valorDesconto) {
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
            return "Model.CupomDescontoPedido {" + "nomeMetodo ='" + nomeMetodo + '\'' + ", valorDesconto =" + valorDesconto + "}\n";
        }
}



