package com.talabat.home.useraccount;

import android.content.Context;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.home.useraccount.UserAccountFragment$navigateToOnboarding$1", f = "UserAccountFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class UserAccountFragment$navigateToOnboarding$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f60922h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ UserAccountFragment f60923i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f60924j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UserAccountFragment$navigateToOnboarding$1(UserAccountFragment userAccountFragment, String str, Continuation<? super UserAccountFragment$navigateToOnboarding$1> continuation) {
        super(2, continuation);
        this.f60923i = userAccountFragment;
        this.f60924j = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new UserAccountFragment$navigateToOnboarding$1(this.f60923i, this.f60924j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((UserAccountFragment$navigateToOnboarding$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f60922h == 0) {
            ResultKt.throwOnFailure(obj);
            DeepLinkNavigator deepLinkNavigator = this.f60923i.getDeepLinkNavigator();
            Context requireContext = this.f60923i.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            DeepLinkNavigator.DefaultImpls.navigateTo$default(deepLinkNavigator, requireContext, this.f60924j, (Function0) null, 4, (Object) null);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
