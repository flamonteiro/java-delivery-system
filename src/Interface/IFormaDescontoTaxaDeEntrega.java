package Interface;
import Model.Pedido;

public interface IFormaDescontoTaxaDeEntrega {

    public void calcularDesconto(Pedido pedido);
    public boolean seAplica(Pedido pedido);
}
