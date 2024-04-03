package com.talabat.home.useraccount;

import android.content.Context;
import android.content.Intent;
import com.talabat.OrderListScreen;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.helpers.TalabatBase;
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
@DebugMetadata(c = "com.talabat.home.useraccount.UserAccountFragment$onSideMenuNavigation$1", f = "UserAccountFragment.kt", i = {}, l = {513}, m = "invokeSuspend", n = {}, s = {})
public final class UserAccountFragment$onSideMenuNavigation$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f60928h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ UserAccountFragment f60929i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f60930j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UserAccountFragment$onSideMenuNavigation$1(UserAccountFragment userAccountFragment, String str, Continuation<? super UserAccountFragment$onSideMenuNavigation$1> continuation) {
        super(2, continuation);
        this.f60929i = userAccountFragment;
        this.f60930j = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new UserAccountFragment$onSideMenuNavigation$1(this.f60929i, this.f60930j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((UserAccountFragment$onSideMenuNavigation$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f60928h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            DeepLinkNavigator deepLinkNavigator = this.f60929i.getDeepLinkNavigator();
            String str = this.f60930j;
            this.f60928h = 1;
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
            Context context = this.f60929i.getContext();
            if (context != null) {
                UserAccountFragment userAccountFragment = this.f60929i;
                DeepLinkNavigator.DefaultImpls.navigateTo$default(userAccountFragment.getDeepLinkNavigator(), context, this.f60930j, (Function0) null, 4, (Object) null);
            }
        } else {
            IObservabilityManager observabilityManager = this.f60929i.getObservabilityManager();
            String str2 = this.f60930j;
            IObservabilityManager.DefaultImpls.trackUnExpectedScenario$default(observabilityManager, "Account page - Failed to handle deeplink: " + str2, (Map) null, 2, (Object) null);
            Intent intent = new Intent(this.f60929i.requireContext(), OrderListScreen.class);
            intent.putExtra(TalabatBase.EXTRA_DISABLE_SIDEMENU, true);
            this.f60929i.startActivity(intent);
        }
        return Unit.INSTANCE;
    }
}
