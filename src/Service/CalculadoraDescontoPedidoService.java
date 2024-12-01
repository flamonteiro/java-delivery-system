package Service;

import Interface.IFormaDescontoPedido;
import FormaDescontoPedido.*;
import Model.Pedido;
import java.util.ArrayList;

public class CalculadoraDescontoPedidoService {
    ArrayList<IFormaDescontoPedido> arrayDescontoPedido;

    public CalculadoraDescontoPedidoService(){
        this.arrayDescontoPedido = new ArrayList<>();
        arrayDescontoPedido.add(new FormaDescontoPedidoPorCategoriaCliente());
        arrayDescontoPedido.add(new FormaDescontoPedidoPorCodigoCupom());
        arrayDescontoPedido.add(new FormaDescontoPedidoPorTipoItem());
    }

    public void calcularDescontoPedido(Pedido pedido) {
        for(IFormaDescontoPedido formaDesconto : arrayDescontoPedido) {
            if(formaDesconto.seAplicaDescontoPedido(pedido)) {
                formaDesconto.calcularDescontoPedido(pedido);
            }
        }
    }
}
