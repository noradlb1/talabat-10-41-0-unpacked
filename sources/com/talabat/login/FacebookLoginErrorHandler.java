package com.talabat.login;

import com.talabat.core.social.login.domain.AaaAuthenticationForSocialLoginRepository;
import com.talabat.core.social.login.domain.SocialLoginException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.mvp.login.ILoginInteractor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/talabat/login/FacebookLoginErrorHandler;", "", "()V", "onFacebookLoginFailure", "", "throwable", "", "loginInteractor", "Llibrary/talabat/mvp/login/ILoginInteractor;", "facebookLoginErrorView", "Lcom/talabat/login/FacebookLoginErrorView;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class FacebookLoginErrorHandler {
    public void onFacebookLoginFailure(@NotNull Throwable th2, @NotNull ILoginInteractor iLoginInteractor, @Nullable FacebookLoginErrorView facebookLoginErrorView) {
        Intrinsics.checkNotNullParameter(th2, "throwable");
        Intrinsics.checkNotNullParameter(iLoginInteractor, "loginInteractor");
        boolean z11 = th2 instanceof SocialLoginException;
        if (z11 && ((SocialLoginException) th2).getType() == SocialLoginException.Type.FAILURE_TO_FETCH_EMAIL) {
            iLoginInteractor.handleLoginError(2, "", "");
            if (facebookLoginErrorView != null) {
                facebookLoginErrorView.facebookEmailNotAvailablePopup();
            }
        } else if (z11 && ((SocialLoginException) th2).getType() == SocialLoginException.Type.EMPTY_SOCIAL_TOKEN) {
            iLoginInteractor.handleAuthError();
        } else if (th2 instanceof AaaAuthenticationForSocialLoginRepository.InvalidCredentialsException) {
            iLoginInteractor.handleAuthError();
        } else if (th2 instanceof AaaAuthenticationForSocialLoginRepository.UnregisteredUserException) {
            iLoginInteractor.handleLoginError(0, ILoginInteractor.ERROR_REASON_EMAIL_NOT_REGISTERED, th2.getMessage());
        } else {
            iLoginInteractor.handleLoginError(0, "", th2.getMessage());
        }
    }
}
