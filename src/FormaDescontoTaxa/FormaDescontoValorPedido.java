package FormaDescontoTaxa;
import Interface.IFormaDescontoTaxaDeEntrega;
import Model.*;

public class FormaDescontoValorPedido implements IFormaDescontoTaxaDeEntrega {
    private double limiteValorPedido;
    private double VALOR_DESCONTO = 0.15;

    public FormaDescontoValorPedido(double limiteValorPedido) {
        this.limiteValorPedido = limiteValorPedido;
    }

    @Override
    public void calcularDesconto(Pedido pedido) {
        if(seAplica(pedido)) {
            pedido.aplicarDesconto(new CupomDescontoEntrega("descontoValorPedido", pedido.getTaxaEntrega() * VALOR_DESCONTO));
        }
    }

    @Override
    public boolean seAplica(Pedido pedido) {
        return (pedido.getValorPedido() > limiteValorPedido);
    }
}
