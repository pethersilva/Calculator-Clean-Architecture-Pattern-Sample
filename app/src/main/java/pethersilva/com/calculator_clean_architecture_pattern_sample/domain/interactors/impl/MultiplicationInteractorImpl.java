package pethersilva.com.calculator_clean_architecture_pattern_sample.domain.interactors.impl;

import pethersilva.com.calculator_clean_architecture_pattern_sample.domain.executor.Executor;
import pethersilva.com.calculator_clean_architecture_pattern_sample.domain.executor.MainThread;
import pethersilva.com.calculator_clean_architecture_pattern_sample.domain.interactors.base.AbstractInteractor;
import pethersilva.com.calculator_clean_architecture_pattern_sample.domain.interactors.MultiplicationInteractor;

public class MultiplicationInteractorImpl extends AbstractInteractor implements MultiplicationInteractor {

	private MultiplicationInteractor.Callback mCallback;
	private double mValue1;
	private double mValue2;

	public MultiplicationInteractorImpl(Executor executor, MainThread mainThread, Callback callback,
										double value1, double value2) {
		super(executor, mainThread);
		mCallback = callback;
		mValue1 = value1;
		mValue2 = value2;
	}

	@Override
	public void run() {
		postMessage(mValue1 * mValue2);
	}

	private void notifyError() {
		mMainThread.post(new Runnable() {
			@Override
			public void run() {
				mCallback.onErrorReceived("Error calculating!!!!");
			}
		});
	}

	private void postMessage(final double result) {
		mMainThread.post(new Runnable() {
			@Override
			public void run() {
				mCallback.onResultReceived(result);
			}
		});
	}
}
