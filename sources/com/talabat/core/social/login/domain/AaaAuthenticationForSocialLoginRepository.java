package com.talabat.core.social.login.domain;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001:\u0003\t\n\u000bJ!\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J!\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lcom/talabat/core/social/login/domain/AaaAuthenticationForSocialLoginRepository;", "", "authenticateWithFacebookAuth", "", "email", "", "socialToken", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "authenticateWithGoogleAuth", "AaaAuthenticationException", "InvalidCredentialsException", "UnregisteredUserException", "com_talabat_core_social-login_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface AaaAuthenticationForSocialLoginRepository {

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0007\b\u0004¢\u0006\u0002\u0010\u0003\u0001\u0002\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/talabat/core/social/login/domain/AaaAuthenticationForSocialLoginRepository$AaaAuthenticationException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "()V", "Lcom/talabat/core/social/login/domain/AaaAuthenticationForSocialLoginRepository$UnregisteredUserException;", "Lcom/talabat/core/social/login/domain/AaaAuthenticationForSocialLoginRepository$InvalidCredentialsException;", "com_talabat_core_social-login_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static abstract class AaaAuthenticationException extends Exception {
        private AaaAuthenticationException() {
        }

        public /* synthetic */ AaaAuthenticationException(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/core/social/login/domain/AaaAuthenticationForSocialLoginRepository$InvalidCredentialsException;", "Lcom/talabat/core/social/login/domain/AaaAuthenticationForSocialLoginRepository$AaaAuthenticationException;", "()V", "com_talabat_core_social-login_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class InvalidCredentialsException extends AaaAuthenticationException {
        public InvalidCredentialsException() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/core/social/login/domain/AaaAuthenticationForSocialLoginRepository$UnregisteredUserException;", "Lcom/talabat/core/social/login/domain/AaaAuthenticationForSocialLoginRepository$AaaAuthenticationException;", "()V", "com_talabat_core_social-login_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class UnregisteredUserException extends AaaAuthenticationException {
        public UnregisteredUserException() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Nullable
    Object authenticateWithFacebookAuth(@NotNull String str, @NotNull String str2, @NotNull Continuation<? super Unit> continuation) throws AaaAuthenticationException;

    @Nullable
    Object authenticateWithGoogleAuth(@NotNull String str, @NotNull String str2, @NotNull Continuation<? super Unit> continuation) throws AaaAuthenticationException;
}
