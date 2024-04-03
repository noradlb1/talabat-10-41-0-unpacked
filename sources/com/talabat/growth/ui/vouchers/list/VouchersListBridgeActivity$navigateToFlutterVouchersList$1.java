package com.talabat.growth.ui.vouchers.list;

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
@DebugMetadata(c = "com.talabat.growth.ui.vouchers.list.VouchersListBridgeActivity$navigateToFlutterVouchersList$1", f = "VouchersListBridgeActivity.kt", i = {}, l = {60}, m = "invokeSuspend", n = {}, s = {})
public final class VouchersListBridgeActivity$navigateToFlutterVouchersList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f60717h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ VouchersListBridgeActivity f60718i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f60719j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VouchersListBridgeActivity$navigateToFlutterVouchersList$1(VouchersListBridgeActivity vouchersListBridgeActivity, String str, Continuation<? super VouchersListBridgeActivity$navigateToFlutterVouchersList$1> continuation) {
        super(2, continuation);
        this.f60718i = vouchersListBridgeActivity;
        this.f60719j = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new VouchersListBridgeActivity$navigateToFlutterVouchersList$1(this.f60718i, this.f60719j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((VouchersListBridgeActivity$navigateToFlutterVouchersList$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f60717h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            DeepLinkNavigator deepLinkNavigator = this.f60718i.getDeepLinkNavigator();
            String str = this.f60719j;
            this.f60717h = 1;
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
            DeepLinkNavigator deepLinkNavigator2 = this.f60718i.getDeepLinkNavigator();
            final VouchersListBridgeActivity vouchersListBridgeActivity = this.f60718i;
            deepLinkNavigator2.navigateTo(vouchersListBridgeActivity, this.f60719j, new Function0<Unit>() {
                public final void invoke() {
                    vouchersListBridgeActivity.finish();
                }
            });
        } else {
            IObservabilityManager observabilityManager = this.f60718i.getObservabilityManager();
            String str2 = this.f60719j;
            IObservabilityManager.DefaultImpls.trackUnExpectedScenario$default(observabilityManager, "VouchersListBridgeActivity - Failed to handle deeplink: " + str2, (Map) null, 2, (Object) null);
            this.f60718i.navigateToNativeVouchersList();
        }
        return Unit.INSTANCE;
    }
}
