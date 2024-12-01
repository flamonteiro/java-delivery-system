package FormaDescontoPedido;

import Interface.IFormaDescontoPedido;
import Model.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FormaDescontoPedidoPorCodigoCupom implements IFormaDescontoPedido {

    private Map<String, Double> descontoCodigoCupom = new HashMap<>();

    public FormaDescontoPedidoPorCodigoCupom() {
        descontoCodigoCupom.put("DESC10",0.1);
        descontoCodigoCupom.put("DESC20",0.2);
        descontoCodigoCupom.put("DESC30",0.3);
    }

    @Override
    public void calcularDescontoPedido(Pedido pedido) {
        Cliente thisCliente = pedido.getCliente();
        if(seAplicaDescontoPedido(pedido)) {
            double descontoCategoria = pedido.getValorPedido() * descontoCodigoCupom.get(thisCliente.getCupom());
            pedido.aplicarDescontoPedido((new CupomDescontoPedido("descontoCodigoCupom", descontoCategoria)));
        }
    }

    @Override
    public boolean seAplicaDescontoPedido(Pedido pedido) {
        boolean booleanCupom = false, booleanItem = false;

        for (CupomDescontoPedido cupom : pedido.getCuponsDescontoPedido()) {
            booleanCupom = cupom.getNomeMetodo().equals("descontoProdutoTipoItem");
        }
        for(Item item : pedido.getItens() ) {
            booleanItem =  descontoCodigoCupom.containsKey(item.getTipo());
        }

        return booleanItem && !booleanCupom;
    }
}
