package Service;


import FormaDescontoTaxa.FormaDescontoTaxaPorBairro;
import FormaDescontoTaxa.FormaDescontoTaxaPorTipoCliente;
import FormaDescontoTaxa.FormaDescontoTipoItem;
import FormaDescontoTaxa.FormaDescontoValorPedido;
import Interface.IFormaDescontoTaxaDeEntrega;
import Model.*;

import java.util.ArrayList;

public class CalculadoraDescontoService {
    ArrayList<IFormaDescontoTaxaDeEntrega> arrayDescontos = new ArrayList<>();

    public CalculadoraDescontoService() {
        arrayDescontos.add(new FormaDescontoTipoItem());
        arrayDescontos.add(new FormaDescontoTaxaPorBairro());
        arrayDescontos.add(new FormaDescontoValorPedido(2000.0));
        arrayDescontos.add(new FormaDescontoTaxaPorTipoCliente());
    }

    public void calcularDesconto(Pedido pedido) {
        for(IFormaDescontoTaxaDeEntrega formaDesconto : arrayDescontos) {
            if(formaDesconto.seAplica(pedido)) {
                formaDesconto.calcularDesconto(pedido);
            }
        }
    }
}
