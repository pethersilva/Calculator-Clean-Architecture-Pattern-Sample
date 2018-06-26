package pethersilva.com.calculator_clean_architecture_pattern_sample.threading;

import pethersilva.com.calculator_clean_architecture_pattern_sample.domain.executor.MainThread;

public class TestMainThread implements MainThread {
    @Override
    public void post(Runnable runnable) {
        runnable.run();
    }
}
