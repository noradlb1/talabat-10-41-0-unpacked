package com.talabat.splash.domain.usecase;

import com.talabat.authentication.authenticate.domain.repository.ExchangeOwinTokenToAAATokenUseCase;
import com.talabat.helpers.GlobalDataModel;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/talabat/splash/domain/usecase/GetAuthenticationTokenUseCase$exchangeOwinTokenToAAATokenUseCase$2$isGdmAvailable$1", "Lcom/talabat/authentication/authenticate/domain/repository/ExchangeOwinTokenToAAATokenUseCase$IsGdmOwinAvailable;", "isGdmOwinAvailable", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetAuthenticationTokenUseCase$exchangeOwinTokenToAAATokenUseCase$2$isGdmAvailable$1 implements ExchangeOwinTokenToAAATokenUseCase.IsGdmOwinAvailable {
    public boolean isGdmOwinAvailable() {
        return GlobalDataModel.token != null;
    }
}
