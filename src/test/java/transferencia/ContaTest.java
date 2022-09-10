package transferencia;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContaTest {
    Cliente xuxa;
    Cliente silvioSantos;
    Conta contaXuxa;
    Conta contaSilvioSantos;

    @BeforeEach
    void setUp() {
        xuxa = new Cliente("Xuxa","12345678909","111111");
        silvioSantos = new Cliente("Xuxa","12345678909","111111");
        contaXuxa = new Conta("0025","1234", 2500.00, xuxa);
        contaSilvioSantos = new Conta("2500","4321", 1500.00, silvioSantos);

    }

    @Test
    @DisplayName("Realizar Transacao")
    public void realizarTransacao(){
        contaXuxa.realizarTransferencia(1000,contaSilvioSantos);
        assertEquals(1500, contaXuxa.getSaldo());
        assertEquals(2500, contaSilvioSantos.getSaldo());
    }

    @Test
    @DisplayName("Realizar Deposito")
    public void realizarDeposito(){
        contaXuxa.realizarDeposito(1000);
        assertEquals(3500, contaXuxa.getSaldo());
    }
    @Test
    @DisplayName("Realizar Saque Invalido")
    public void realizarSaqueInvalido(){
        contaXuxa.realizarSaque(2500);
        assertEquals(0,contaXuxa.getSaldo());
    }

    @Test
    void getAgencia() {
        String agencia = contaXuxa.getAgencia();
        assertEquals("0025",
                            agencia);
    }

    @Test
    void getNumeroConta() {
        String conta = contaXuxa.getNumeroConta();
        assertEquals("1234",conta);
    }

    @Test
    void getSaldo() {
        double saldo = contaXuxa.getSaldo();
        assertEquals(2500.00,saldo);
    }

    @Test
    void getProprietario() {
        Cliente proprietario = contaXuxa.getProprietario();
        assertEquals(xuxa,proprietario);
    }
    @Test
    void getNome() {
        String nome = xuxa.getNome();
        assertEquals("Xuxa",nome);
    }

    @Test
    void getCpf() {
        String cpf = xuxa.getCpf();
        assertEquals("12345678909",cpf);
    }

    @Test
    void getRg() {
        String rg = xuxa.getRg();
        assertEquals("111111",rg);
    }
}
