package FormaDescontoTaxa;

import java.util.HashMap;
import java.util.Map;
import Interface.IFormaDescontoTaxaDeEntrega;
import Model.*;

public class FormaDescontoTaxaPorTipoCliente implements IFormaDescontoTaxaDeEntrega {

    private Map<String, Double> descontoPorTipoCliente = new HashMap<>();

    public FormaDescontoTaxaPorTipoCliente() {
        descontoPorTipoCliente.put("Ouro", 0.3);
        descontoPorTipoCliente.put("Prata", 0.2);
        descontoPorTipoCliente.put("Bronze", 0.1);
    }

    @Override
    public void calcularDesconto(Pedido pedido) {
        Cliente thisCliente = pedido.getCliente();
        if(seAplica(pedido)) {
                double descontoTipo = pedido.getTaxaEntrega() * descontoPorTipoCliente.get(thisCliente.getTipo());
                pedido.aplicarDesconto((new CupomDescontoEntrega("descontoTipoCliente", descontoTipo)));
        }
    }

    @Override
    public boolean seAplica(Pedido pedido) {
        Cliente thisCliente = pedido.getCliente();
        return descontoPorTipoCliente.containsKey(thisCliente.getTipo());
    }
}
