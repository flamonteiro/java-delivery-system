package Interface;
import Model.Pedido;

public interface IFormaDescontoPedido {

    public void calcularDescontoPedido(Pedido pedido);
    public boolean seAplicaDescontoPedido(Pedido pedido);
}
