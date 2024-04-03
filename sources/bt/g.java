package bt;

import com.talabat.authentication.authenticate.domain.repository.ExchangeOwinTokenToAAATokenUseCase;
import com.talabat.registration.RegistrationInteractor;

public final /* synthetic */ class g implements ExchangeOwinTokenToAAATokenUseCase.IsGdmOwinAvailable {
    public final boolean isGdmOwinAvailable() {
        return RegistrationInteractor.lambda$exchangeOwinToAaaToken$6();
    }
}
