package com.talabat.core.social.login.domain;

import android.app.Activity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J=\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\"\u0010\u0006\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007H¦@ø\u0001\u0000¢\u0006\u0002\u0010\n\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"Lcom/talabat/core/social/login/domain/FacebookLoginUseCase;", "", "requestFacebookAuth", "Lcom/talabat/core/social/login/domain/FacebookUserData;", "activity", "Landroid/app/Activity;", "registrationBlock", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(Landroid/app/Activity;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_core_social-login_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface FacebookLoginUseCase {
    @Nullable
    Object requestFacebookAuth(@NotNull Activity activity, @NotNull Function2<? super FacebookUserData, ? super Continuation<? super Unit>, ? extends Object> function2, @NotNull Continuation<? super FacebookUserData> continuation) throws SocialLoginException;
}
