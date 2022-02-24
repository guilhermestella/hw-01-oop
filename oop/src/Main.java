import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        BigDecimal valorMouse = new BigDecimal("250");

        List<Pagamento> pgtos = new ArrayList<>();
        Pagamento pgtoCredito = new Credito(valorMouse, 6);
        Pagamento pgtoTED = new TED(valorMouse);

        pgtos.add(pgtoCredito);
        pgtos.add(pgtoTED);

        for (Pagamento pgto : pgtos) {
            if ( pgto instanceof TED ) {
                ((TED) pgto).cancelar();
            }
        }

        BigDecimal sum = BigDecimal.ZERO;
        for (Pagamento pgto : pgtos) {
            sum = sum.add(pgto.valor);
        }
        System.out.println(sum);
    }
}
