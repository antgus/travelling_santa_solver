package antoniogusmao.Optimizer;

public interface TerminationCriteria {
    void init();
    boolean hasEnded();
}
