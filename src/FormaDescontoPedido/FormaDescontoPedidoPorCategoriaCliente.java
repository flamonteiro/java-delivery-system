package FormaDescontoPedido;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import Interface.IFormaDescontoPedido;
import Model.*;

public class FormaDescontoPedidoPorCategoriaCliente implements IFormaDescontoPedido {

    private Map<String, Double> descontoCategoriaCliente = new HashMap<>();

    public FormaDescontoPedidoPorCategoriaCliente() {
        descontoCategoriaCliente.put("Ouro",0.3);
        descontoCategoriaCliente.put("Prata",0.2);
        descontoCategoriaCliente.put("Bronze",0.1);
    }

    @Override
    public void calcularDescontoPedido(Pedido pedido) {
        Cliente thisCliente = pedido.getCliente();
        if(seAplicaDescontoPedido(pedido)) {
            double descontoCategoria = pedido.getValorPedido() * descontoCategoriaCliente.get(thisCliente.getTipo());
            pedido.aplicarDescontoPedido((new CupomDescontoPedido("descontoCategoriaCliente", descontoCategoria)));
        }
    }

    @Override
    public boolean seAplicaDescontoPedido(Pedido pedido) {
        boolean booleanCupom = false, booleanItem = false;

        for (CupomDescontoPedido cupom : pedido.getCuponsDescontoPedido()) {
            booleanCupom = cupom.getNomeMetodo().equals("descontoProdutoTipoItem");
        }
        for(Item item : pedido.getItens() ) {
            booleanItem =  descontoCategoriaCliente.containsKey(item.getTipo());
        }

        return booleanItem && !booleanCupom;
    }
}
