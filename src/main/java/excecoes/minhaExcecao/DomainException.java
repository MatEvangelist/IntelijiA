package excecoes.minhaExcecao;

public class DomainException extends RuntimeException {

    public DomainException(String msg) {
        super(msg);
    }
}