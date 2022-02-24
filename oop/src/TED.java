import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TED extends Pagamento {

    private final LocalDateTime dataLiberacao;

    public TED(BigDecimal valor) {
        super(valor);
        this.dataLiberacao = dataPagamento.plusDays(1);
    }

    @Override
    protected BigDecimal tarifa() {
        return new BigDecimal("6");
    }

    public void cancelar() {
        if ( LocalDateTime.now().isBefore(dataLiberacao) ) {
            this.cancelado = true;
            System.out.printf("Pagamento %s Cancelado%n", uuid);
        } else {
            throw new IllegalArgumentException(String.format("Nao foi possivel cancelar o pagamento %s", uuid));
        }
    }

    @Override
    public String toString() {
        return "TED{" +
                "uuid=" + uuid +
                ", dataPagamento=" + dataPagamento +
                ", valor=" + valor +
                ", valorTotal=" + valorTotal +
                ", cancelado=" + cancelado +
                ", dataLiberacao=" + dataLiberacao +
                '}';
    }
}
