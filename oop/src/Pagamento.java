import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public abstract class Pagamento {

    protected final UUID uuid;
    protected final LocalDateTime dataPagamento;
    protected final BigDecimal valor;
    protected BigDecimal valorTotal;
    protected Boolean cancelado;

    protected abstract BigDecimal tarifa();

    protected Pagamento(BigDecimal valor) {
        this.uuid = UUID.randomUUID();
        this.dataPagamento = LocalDateTime.now();
        this.valor = valor;
        this.valorTotal = valor.add(tarifa());
        this.cancelado = false;
    }

    @Override
    public String toString() {
        return "Pagamento{" +
                "uuid=" + uuid +
                ", dataPagamento=" + dataPagamento +
                ", valor=" + valor +
                ", valorTotal=" + valorTotal +
                ", cancelado=" + cancelado +
                '}';
    }
}
