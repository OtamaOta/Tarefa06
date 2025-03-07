import java.util.Scanner;

// Classe principal que executa o programa
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PaymentProcessor paymentProcessor = new PaymentProcessor();

        // Menu de opções
        System.out.println("Escolha o método de pagamento:");
        System.out.println("1: Pix");
        System.out.println("2: Cartão de Crédito");
        System.out.println("3: Boleto");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha pendente

        String type = "";
        switch (choice) {
            case 1:
                type = "pix";
                break;
            case 2:
                type = "cartao";
                break;
            case 3:
                type = "boleto";
                break;
            default:
                System.out.println("Opção inválida.");
                return;
        }

        // Cria a estratégia de pagamento usando o Factory
        PaymentStrategy paymentStrategy = PaymentFactory.createPayment(type);
        paymentProcessor.setPaymentStrategy(paymentStrategy);

        // Solicita o valor da transação
        System.out.println("Digite o valor da transação:");
        double amount = scanner.nextDouble();

        // Processa o pagamento
        paymentProcessor.processPayment(amount);

        scanner.close();
    }
}