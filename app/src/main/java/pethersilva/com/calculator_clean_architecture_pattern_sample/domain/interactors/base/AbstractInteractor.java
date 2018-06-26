package pethersilva.com.calculator_clean_architecture_pattern_sample.domain.interactors.base;

import pethersilva.com.calculator_clean_architecture_pattern_sample.domain.executor.Executor;
import pethersilva.com.calculator_clean_architecture_pattern_sample.domain.executor.MainThread;

public abstract class AbstractInteractor implements Interactor {

    protected Executor mThreadExecutor;
    protected MainThread mMainThread;

    protected volatile boolean mIsRunning;
    protected volatile boolean mIsCanceled;

    public AbstractInteractor(Executor executor, MainThread mainThread) {
        mThreadExecutor = executor;
        mMainThread = mainThread;
    }

    public abstract void run();

    public void cancel() {
        mIsCanceled = true;
        mIsRunning = false;
    }

    public boolean isIsRunning() {
        return mIsRunning;
    }

    public void onFinished() {
        mIsRunning = false;
        mIsCanceled = false;
    }

    public void execute() {
        mIsRunning = true;
        mThreadExecutor.execute(this);
    }
}
