package pethersilva.com.calculator_clean_architecture_pattern_sample.domain.executor;

public interface MainThread {

    void post(final Runnable runnable);

}
