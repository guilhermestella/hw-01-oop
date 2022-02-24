import java.math.BigDecimal;

public class Credito extends Pagamento {

    private final Integer parcelas;

    public Credito(BigDecimal valor) {
        this(valor, 1);
    }

    public Credito(BigDecimal valor, Integer parcelas) {
        super(valor);
        this.parcelas = parcelas;
        this.valorTotal = this.valorTotal.add(new BigDecimal("0.15").multiply(BigDecimal.valueOf(parcelas)));
    }

    @Override
    protected BigDecimal tarifa() {
        return new BigDecimal("0.03").multiply(this.valor);
    }

    @Override
    public String toString() {
        return "Credito{" +
                "parcelas=" + parcelas +
                ", uuid=" + uuid +
                ", dataPagamento=" + dataPagamento +
                ", valor=" + valor +
                ", valorTotal=" + valorTotal +
                ", cancelado=" + cancelado +
                '}';
    }
}
