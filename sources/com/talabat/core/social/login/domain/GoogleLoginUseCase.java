package com.talabat.core.social.login.domain;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001Ja\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052F\u0010\u0006\u001aB\b\u0001\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u000e\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"Lcom/talabat/core/social/login/domain/GoogleLoginUseCase;", "", "requestGoogleAuth", "", "requestCode", "", "registrationBlock", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "email", "token", "Lkotlin/coroutines/Continuation;", "(ILkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_core_social-login_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface GoogleLoginUseCase {
    @Nullable
    Object requestGoogleAuth(int i11, @NotNull Function3<? super String, ? super String, ? super Continuation<? super Unit>, ? extends Object> function3, @NotNull Continuation<? super Unit> continuation) throws SocialLoginException;
}
