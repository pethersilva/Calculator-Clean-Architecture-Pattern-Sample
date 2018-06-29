package pethersilva.com.calculator_clean_architecture_pattern_sample.domain.interactors;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import pethersilva.com.calculator_clean_architecture_pattern_sample.domain.executor.Executor;
import pethersilva.com.calculator_clean_architecture_pattern_sample.domain.executor.MainThread;
import pethersilva.com.calculator_clean_architecture_pattern_sample.domain.interactors.impl.DivisorInteractorImpl;
import pethersilva.com.calculator_clean_architecture_pattern_sample.domain.interactors.impl.MinusInteractorImpl;
import pethersilva.com.calculator_clean_architecture_pattern_sample.threading.TestMainThread;

public class DivisorTest {

	private MainThread mMainThread;
	@Mock private Executor mExecutor;
	@Mock private DivisorInteractor.Callback mCallback;

	@Before
	public void setup() throws Exception{

		MockitoAnnotations.initMocks(this);
		mMainThread = new TestMainThread();
	}

	@Test
	public void testDivisorCorrect() throws Exception {

		double expectedResult = 5;
		DivisorInteractorImpl divisorInteractor = new DivisorInteractorImpl(mExecutor, mMainThread, mCallback,
				10, 2);
		divisorInteractor.run();
		Mockito.verify(mCallback).onResultReceived(expectedResult);
	}

	@Test
	public void testDivisorByZero() throws Exception {

		double expectedResult = Double.POSITIVE_INFINITY;
		DivisorInteractorImpl divisorInteractor = new DivisorInteractorImpl(mExecutor, mMainThread, mCallback,
				10, 0);
		divisorInteractor.run();
		Mockito.verify(mCallback).onResultReceived(expectedResult);
	}
}
