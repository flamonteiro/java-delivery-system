package FormaDescontoTaxa;
import java.util.HashMap;
import java.util.Map;
import Interface.IFormaDescontoTaxaDeEntrega;
import Model.*;

public class FormaDescontoTaxaPorBairro implements IFormaDescontoTaxaDeEntrega {
    private Map<String, Double> descontoTaxaBairro = new HashMap<>();

    public FormaDescontoTaxaPorBairro() {
        descontoTaxaBairro.put("Centro" , 0.2);
        descontoTaxaBairro.put("Bela Vista" , 0.3);
        descontoTaxaBairro.put("Cidade Maravilhosa" , 0.15);
    }

    @Override
    public void calcularDesconto(Pedido pedido) {
        Cliente thisCliente = pedido.getCliente();
        if(seAplica(pedido)) {
            double descontoBairro = pedido.getTaxaEntrega() * descontoTaxaBairro.get(thisCliente.getBairro());
            pedido.aplicarDesconto(new CupomDescontoEntrega("descontoTaxaBairro", descontoBairro));
        }
    }

    @Override
    public boolean seAplica(Pedido pedido) {
        Cliente thisCliente = pedido.getCliente();
        return descontoTaxaBairro.containsKey(thisCliente.getBairro());
    }
}
