package pethersilva.com.calculator_clean_architecture_pattern_sample.domain.executor;

import pethersilva.com.calculator_clean_architecture_pattern_sample.domain.interactors.base.AbstractInteractor;

public interface Executor {

    void execute(final AbstractInteractor interactor);
}
