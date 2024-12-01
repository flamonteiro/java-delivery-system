import Model.Cliente;
import Model.Item;
import Model.Pedido;
import Service.CalculadoraDescontoService;
import Service.CalculadoraDescontoPedidoService;

public class Main {
    public static void main(String[] args) {

        Cliente cliJack = new Cliente("Jack", "Bronze",5.0,"Rua das Flores","Centro", "Campinas", "DESC10");
        Pedido pedidoJack = new Pedido(cliJack);
        CalculadoraDescontoService calculadora = new CalculadoraDescontoService();
        CalculadoraDescontoPedidoService calculadoraPedido = new CalculadoraDescontoPedidoService();

        Item pao = new Item("pao", 1, 0.50, "Alimentação");
        Item arroz = new Item("arroz", 1, 30.50, "Alimentação");
        Item leite = new Item("leite", 1, 5.50, "Alimentação");
        Item caneta = new Item("caneta", 1, 2.50, "Educação");
        Item bola = new Item("bola", 1, 15.00, "Lazer");

        pedidoJack.adicionarItem(pao);
        pedidoJack.adicionarItem(arroz);
        pedidoJack.adicionarItem(leite);
        pedidoJack.adicionarItem(caneta);
        pedidoJack.adicionarItem(bola);

        calculadora.calcularDesconto(pedidoJack);
        calculadoraPedido.calcularDescontoPedido(pedidoJack);
        System.out.println(pedidoJack.getValorPedido());
        System.out.println(pedidoJack.getDescontoConcedidoTaxa());
        System.out.println(pedidoJack.getDescontoConcedidoPedido());
        System.out.println(pedidoJack.getCuponsDescontoEntrega());
        System.out.println(pedidoJack.getCuponsDescontoPedido());
    }
}