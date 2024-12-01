package FormaDescontoTaxa;

import java.util.HashMap;
import java.util.Map;
import Interface.IFormaDescontoTaxaDeEntrega;
import Model.*;

public class FormaDescontoTipoItem implements IFormaDescontoTaxaDeEntrega {
    private Map<String, Double> descontoTipoItem = new HashMap<>();

    public FormaDescontoTipoItem() {
        descontoTipoItem.put("Alimentação", 0.05);
        descontoTipoItem.put("Educação", 0.2);
        descontoTipoItem.put("Lazer", 0.15);
    }

    @Override
    public void calcularDesconto(Pedido pedido) {
        double acumValor = 0.0;
        if(seAplica(pedido)) {
            for(Item item : pedido.getItens() ) {
                acumValor += pedido.getTaxaEntrega() * descontoTipoItem.get(item.getTipo());
            }
                pedido.aplicarDesconto(new CupomDescontoEntrega("descontoTipoItem", acumValor));
        }
    }

    @Override
    public boolean seAplica(Pedido pedido) {
        for(Item item : pedido.getItens() ) {
            return descontoTipoItem.containsKey(item.getTipo());
        }
        return false;
    }
}
