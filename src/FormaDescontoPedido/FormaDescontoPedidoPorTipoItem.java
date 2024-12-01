package FormaDescontoPedido;

import Interface.IFormaDescontoPedido;
import Model.CupomDescontoPedido;
import Model.Item;
import Model.Pedido;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FormaDescontoPedidoPorTipoItem implements IFormaDescontoPedido {
    private Map<String, Double> descontoPedidoTipoItem = new HashMap<>();

    public FormaDescontoPedidoPorTipoItem() {
        descontoPedidoTipoItem.put("Alimentação", 0.05);
        descontoPedidoTipoItem.put("Educação", 0.2);
        descontoPedidoTipoItem.put("Lazer", 0.15);
    }

    @Override
    public void calcularDescontoPedido(Pedido pedido) {
        double acumValor = 0.0;
        if(seAplicaDescontoPedido(pedido)) {
            for(Item item : pedido.getItens() ) {
                acumValor += pedido.getValorPedido() * descontoPedidoTipoItem.get(item.getTipo());
            }
            pedido.aplicarDescontoPedido(new CupomDescontoPedido("descontoProdutoTipoItem", acumValor));
        }
    }

    @Override
    public boolean seAplicaDescontoPedido(Pedido pedido) {
        boolean booleanCupom = false, booleanItem = false;

        for (CupomDescontoPedido cupom : pedido.getCuponsDescontoPedido()) {
            booleanCupom = cupom.getNomeMetodo().equals("descontoCategoriaCliente") || cupom.getNomeMetodo().equals("descontoCategoriaProduto");
        }
        for(Item item : pedido.getItens() ) {
            booleanItem =  descontoPedidoTipoItem.containsKey(item.getTipo());
        }

        return booleanItem && !booleanCupom;
    }
}
