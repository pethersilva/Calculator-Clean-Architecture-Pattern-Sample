package pethersilva.com.calculator_clean_architecture_pattern_sample.domain.interactors;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import pethersilva.com.calculator_clean_architecture_pattern_sample.domain.executor.Executor;
import pethersilva.com.calculator_clean_architecture_pattern_sample.domain.executor.MainThread;
import pethersilva.com.calculator_clean_architecture_pattern_sample.domain.interactors.impl.MinusInteractorImpl;
import pethersilva.com.calculator_clean_architecture_pattern_sample.threading.TestMainThread;

public class MinusTest {

	private MainThread mMainThread;
	@Mock private Executor mExecutor;
	@Mock private MinusInteractor.Callback mCallback;

	@Before
	public void setup() throws Exception{

		MockitoAnnotations.initMocks(this);
		mMainThread = new TestMainThread();
	}

	@Test
	public void testMinusCorrect() throws Exception {

		double expectedResult = -30;
		MinusInteractorImpl minusInteractor = new MinusInteractorImpl(mExecutor, mMainThread, mCallback,
				10, 40);
		minusInteractor.run();
		Mockito.verify(mCallback).onResultReceived(expectedResult);
	}
}
