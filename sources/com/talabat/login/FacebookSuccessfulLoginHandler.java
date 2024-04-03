package com.talabat.login;

import com.android.volley.Response;
import com.talabat.authentication.authenticate.domain.repository.ExchangeOwinTokenToAAATokenUseCase;
import com.talabat.authentication.token.domain.model.LegacyToken;
import com.talabat.authentication.token.domain.repository.TokenRepository;
import com.talabat.core.social.login.domain.FacebookUserData;
import datamodels.RegistrationRM;
import datamodels.Token;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.mvp.login.ILoginInteractor;
import library.talabat.mvp.login.ILoginPresenter;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J \u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\f\u0010\u000f\u001a\u00020\u0010*\u00020\bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/talabat/login/FacebookSuccessfulLoginHandler;", "", "tokenRepository", "Lcom/talabat/authentication/token/domain/repository/TokenRepository;", "(Lcom/talabat/authentication/token/domain/repository/TokenRepository;)V", "onRegisterNewUser", "", "facebookRegistrationModel", "Lcom/talabat/core/social/login/domain/FacebookUserData;", "loginPresenter", "Llibrary/talabat/mvp/login/ILoginPresenter;", "loginInteractor", "Llibrary/talabat/mvp/login/ILoginInteractor;", "onSuccessFulFBLogin", "facebookUserData", "toRegistrationRM", "Ldatamodels/RegistrationRM;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class FacebookSuccessfulLoginHandler {
    @NotNull
    private final TokenRepository tokenRepository;

    @Inject
    public FacebookSuccessfulLoginHandler(@NotNull TokenRepository tokenRepository2) {
        Intrinsics.checkNotNullParameter(tokenRepository2, "tokenRepository");
        this.tokenRepository = tokenRepository2;
    }

    private final RegistrationRM toRegistrationRM(FacebookUserData facebookUserData) {
        RegistrationRM registrationRM = new RegistrationRM();
        registrationRM.Email = facebookUserData.getEmail();
        registrationRM.token = facebookUserData.getToken();
        registrationRM.FirstName = facebookUserData.getFirstName();
        registrationRM.LastName = facebookUserData.getLastName();
        registrationRM.facebookUserId = facebookUserData.getProviderId();
        registrationRM.ProviderKey = facebookUserData.getProviderKey();
        registrationRM.BirthDate = "";
        return registrationRM;
    }

    public void onRegisterNewUser(@NotNull FacebookUserData facebookUserData, @NotNull ILoginPresenter iLoginPresenter, @NotNull ILoginInteractor iLoginInteractor) {
        Intrinsics.checkNotNullParameter(facebookUserData, "facebookRegistrationModel");
        Intrinsics.checkNotNullParameter(iLoginPresenter, "loginPresenter");
        Intrinsics.checkNotNullParameter(iLoginInteractor, "loginInteractor");
        iLoginPresenter.setUpFacebookLogin(toRegistrationRM(facebookUserData), 1);
        iLoginInteractor.faceBookLoginWithResult(toRegistrationRM(facebookUserData)).timeout(1, TimeUnit.MINUTES).blockingGet();
    }

    public void onSuccessFulFBLogin(@NotNull FacebookUserData facebookUserData, @NotNull ILoginPresenter iLoginPresenter, @NotNull ILoginInteractor iLoginInteractor) {
        Intrinsics.checkNotNullParameter(facebookUserData, "facebookUserData");
        Intrinsics.checkNotNullParameter(iLoginPresenter, "loginPresenter");
        Intrinsics.checkNotNullParameter(iLoginInteractor, "loginInteractor");
        iLoginPresenter.setUpFacebookLogin(toRegistrationRM(facebookUserData), 1);
        LegacyToken legacyToken = this.tokenRepository.getLegacyToken();
        Response.Listener<Token> onResultRecieved = iLoginInteractor.onResultRecieved(ExchangeOwinTokenToAAATokenUseCase.EXCHANGE_FLOW_LOGIN_SOCIAL);
        Token token = new Token();
        token.access_token = legacyToken.getAccessToken();
        token.expires_in = String.valueOf(legacyToken.getExpiresIn());
        token.refresh_token = "";
        token.token_type = legacyToken.getTokenType();
        onResultRecieved.onResponse(token);
    }
}
