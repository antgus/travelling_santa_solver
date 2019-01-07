package antoniogusmao.Optimizer;

public class Optimizer {
    private Scorer scorer;
    private Validator<IState> validator;
    private TerminationCriteria terminator;
    private Strategy strategy;
    
    public Optimizer setScorer(Scorer scorer) {
        this.scorer = scorer;
        return this;
    }
    
    public Optimizer setValidator(Validator validator) {
        this.validator = validator;
        return this;
    }

    // an optimizer is the component responsible for finding the best scoring state (local optima)
    public void addBaseActions() {
        // These are the base actions that the environment provides
    }
    
    public void addCompoundActions() {
        // TODO -- does it even make sense to differentiate these?
        // is it possible for the optimizer to infer which actions are redundant? Yes.
        // Because redundancy relates to score - if having action a and b doesn't improve things compared
        // to having just action a, or just action b, then those are redundant.
    }
    
    public void optimizeUntil(TerminationCriteria terminator) {
        throw new UnsupportedOperationException("TODO");
//        // TODO Keep best distinct candidates
//        IState s =
//        while(!terminator.hasEnded()) {
//            Action a = strategy.getNextAction(); // this strategy may actually..
//            s.apply(a);
//            validator.isValid(s); // a validator is not strictly necessary as part of the optimization.
//            scorer.update(s, a);
//        }
    }
    
    public void optimizeFor(int durationInMs) {

        throw new RuntimeException("TODO"); // call optimizeUntil using a time limit termination criteria
        //this.optimizeUntil();
    }

    public Scorer getScorer() {
        return this.scorer;
    }

    public TerminationCriteria getTerminationCriteria() {
        return this.terminator;
    }

    public Validator getValidator() {
        return this.validator;
    }

    public Strategy getStrategy() {
        return this.strategy;
    }
}
