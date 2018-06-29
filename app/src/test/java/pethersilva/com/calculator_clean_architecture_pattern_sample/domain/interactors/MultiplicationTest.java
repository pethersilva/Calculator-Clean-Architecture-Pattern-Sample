package pethersilva.com.calculator_clean_architecture_pattern_sample.domain.interactors;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import pethersilva.com.calculator_clean_architecture_pattern_sample.domain.executor.Executor;
import pethersilva.com.calculator_clean_architecture_pattern_sample.domain.executor.MainThread;
import pethersilva.com.calculator_clean_architecture_pattern_sample.domain.interactors.impl.MultiplicationInteractorImpl;
import pethersilva.com.calculator_clean_architecture_pattern_sample.threading.TestMainThread;

public class MultiplicationTest {

	private MainThread mMainThread;
	@Mock private Executor mExecutor;
	@Mock private MultiplicationInteractor.Callback mCallback;

	@Before
	public void setup() throws Exception{

		MockitoAnnotations.initMocks(this);
		mMainThread = new TestMainThread();
	}

	@Test
	public void testMultiplicationCorrect() throws Exception {

		double expectedResult = 400;
		MultiplicationInteractorImpl multiplicationInteractor = new MultiplicationInteractorImpl(mExecutor, mMainThread, mCallback,
				10, 40);
		multiplicationInteractor.run();
		Mockito.verify(mCallback).onResultReceived(expectedResult);
	}
}
