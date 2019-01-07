package antoniogusmao.Optimizer;

public interface Validator<T extends IState> {
    boolean isValid(T s);
}
