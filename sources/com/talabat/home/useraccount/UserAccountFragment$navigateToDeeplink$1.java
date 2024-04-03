package com.talabat.home.useraccount;

import android.content.Context;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.home.useraccount.UserAccountFragment$navigateToDeeplink$1", f = "UserAccountFragment.kt", i = {}, l = {656}, m = "invokeSuspend", n = {}, s = {})
public final class UserAccountFragment$navigateToDeeplink$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f60919h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ UserAccountFragment f60920i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f60921j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UserAccountFragment$navigateToDeeplink$1(UserAccountFragment userAccountFragment, String str, Continuation<? super UserAccountFragment$navigateToDeeplink$1> continuation) {
        super(2, continuation);
        this.f60920i = userAccountFragment;
        this.f60921j = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new UserAccountFragment$navigateToDeeplink$1(this.f60920i, this.f60921j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((UserAccountFragment$navigateToDeeplink$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f60919h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            DeepLinkNavigator deepLinkNavigator = this.f60920i.getDeepLinkNavigator();
            String str = this.f60921j;
            this.f60919h = 1;
            obj = deepLinkNavigator.canHandleDeepLink(str, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (((Boolean) obj).booleanValue()) {
            Context context = this.f60920i.getContext();
            if (context != null) {
                UserAccountFragment userAccountFragment = this.f60920i;
                DeepLinkNavigator.DefaultImpls.navigateTo$default(userAccountFragment.getDeepLinkNavigator(), context, this.f60921j, (Function0) null, 4, (Object) null);
            }
        } else {
            IObservabilityManager observabilityManager = this.f60920i.getObservabilityManager();
            String str2 = this.f60921j;
            IObservabilityManager.DefaultImpls.trackUnExpectedScenario$default(observabilityManager, "Account page - Failed to handle deeplink: " + str2, (Map) null, 2, (Object) null);
        }
        return Unit.INSTANCE;
    }
}
