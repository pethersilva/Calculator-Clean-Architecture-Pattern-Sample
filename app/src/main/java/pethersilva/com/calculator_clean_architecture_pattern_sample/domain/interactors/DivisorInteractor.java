package pethersilva.com.calculator_clean_architecture_pattern_sample.domain.interactors;

import pethersilva.com.calculator_clean_architecture_pattern_sample.domain.interactors.base.Interactor;

public interface DivisorInteractor extends Interactor {

	interface Callback {

		void onResultReceived(double result);

		void onErrorReceived(String error);
	}
}
