package pethersilva.com.calculator_clean_architecture_pattern_sample.domain.interactors;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import pethersilva.com.calculator_clean_architecture_pattern_sample.domain.executor.Executor;
import pethersilva.com.calculator_clean_architecture_pattern_sample.domain.executor.MainThread;
import pethersilva.com.calculator_clean_architecture_pattern_sample.domain.interactors.impl.SumInteractorImpl;
import pethersilva.com.calculator_clean_architecture_pattern_sample.threading.TestMainThread;

public class SumTest {

    private MainThread mMainThread;
    @Mock private Executor mExecutor;
    @Mock private SumInteractor.Callback mCallback;

    @Before
    public void setup() throws Exception{

        MockitoAnnotations.initMocks(this);
        mMainThread = new TestMainThread();
    }

    @Test
    public void testSumCorrect() throws Exception {

        double expectedResult = 50;
        SumInteractorImpl sumInteractor = new SumInteractorImpl(mExecutor, mMainThread, mCallback,
                10, 40);
        sumInteractor.run();
        Mockito.verify(mCallback).onResultReceived(expectedResult);
    }
}