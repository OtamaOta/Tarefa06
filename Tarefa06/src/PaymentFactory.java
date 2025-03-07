// Classe Factory que cria instâncias de estratégias de pagamento
public class PaymentFactory {
    // Método estático para criar a estratégia de pagamento com base no tipo
    public static PaymentStrategy createPayment(String type) {
        switch (type.toLowerCase()) {
            case "pix":
                return new PixPayment();
            case "cartão":
            case "cartao":
                return new CreditCardPayment();
            case "boleto":
                return new BoletoPayment();
            default:
                throw new IllegalArgumentException("Tipo de pagamento desconhecido: " + type);
        }
    }
}