package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pedido {
    private double taxaEntrega = 10.00;
    private Cliente cliente;
    private List<Item> listaItem;
    private List<CupomDescontoEntrega> listaCupons;
    private List<CupomDescontoPedido> listaCuponsPedido;

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.listaItem = new ArrayList<>();
        this.listaCupons = new ArrayList<>();
        this.listaCuponsPedido = new ArrayList<>();
    }

    public void adicionarItem(Item item) {
        listaItem.add(item);
    }

    public double getValorPedido() {
        double valorFinal = 0;
        valorFinal = getSomaItens() + taxaEntrega - (getDescontoConcedidoTaxa() + getDescontoConcedidoPedido());
        return valorFinal;
    }

    public double getSomaItens() {
        double valorFinal = 0;
        for(Item item : listaItem) {
            valorFinal += item.getValorTotal();
        }
        return valorFinal;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public List<Item> getItens() {
        return Collections.unmodifiableList(listaItem);
    }

    public double getTaxaEntrega() {
        return taxaEntrega;
    }

    public void aplicarDesconto(CupomDescontoEntrega desconto) {
        listaCupons.add(desconto);
    }

    public void aplicarDescontoPedido(CupomDescontoPedido desconto) {
        listaCuponsPedido.add(desconto);
    }

    public double getDescontoConcedidoTaxa() {
        double acumDesconto = 0.0;
        for(CupomDescontoEntrega cupom : listaCupons) {
            acumDesconto += cupom.getValorDesconto();
        }
        return Math.min(acumDesconto, taxaEntrega);
    }

    public double getDescontoConcedidoPedido() {
        double acumDesconto = 0.0;
        for(CupomDescontoPedido cupomDesconto : listaCuponsPedido) {
            acumDesconto += cupomDesconto.getValorDesconto();
        }
        return acumDesconto;
    }

    public List<CupomDescontoEntrega> getCuponsDescontoEntrega() {
        return Collections.unmodifiableList(listaCupons);
    }

    public List<CupomDescontoPedido> getCuponsDescontoPedido() {
        return Collections.unmodifiableList(listaCuponsPedido);
    }

    @Override
    public String toString() {
        return "Model.Pedido {" +
                "TaxaEntrega ='" + taxaEntrega + '\'' +
                ", Model.Cliente =" + cliente +
                ", ListaItens =" + getItens() +
                ", ListaCupons =" + getCuponsDescontoEntrega() +
                ", ListaCuponsPedido =" + getCuponsDescontoPedido() +
                '}';
    }
}

