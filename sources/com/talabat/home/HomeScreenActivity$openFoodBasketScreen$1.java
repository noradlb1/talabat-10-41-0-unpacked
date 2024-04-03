package com.talabat.home;

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
@DebugMetadata(c = "com.talabat.home.HomeScreenActivity$openFoodBasketScreen$1", f = "HomeScreenActivity.kt", i = {}, l = {1487}, m = "invokeSuspend", n = {}, s = {})
public final class HomeScreenActivity$openFoodBasketScreen$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f60892h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ HomeScreenActivity f60893i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f60894j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeScreenActivity$openFoodBasketScreen$1(HomeScreenActivity homeScreenActivity, String str, Continuation<? super HomeScreenActivity$openFoodBasketScreen$1> continuation) {
        super(2, continuation);
        this.f60893i = homeScreenActivity;
        this.f60894j = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new HomeScreenActivity$openFoodBasketScreen$1(this.f60893i, this.f60894j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((HomeScreenActivity$openFoodBasketScreen$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f60892h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            DeepLinkNavigator deepLinkNavigator = this.f60893i.getDeepLinkNavigator();
            String str = this.f60894j;
            this.f60892h = 1;
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
            DeepLinkNavigator.DefaultImpls.navigateTo$default(this.f60893i.getDeepLinkNavigator(), this.f60893i, this.f60894j, (Function0) null, 4, (Object) null);
        } else {
            IObservabilityManager observabilityManager = this.f60893i.getObservabilityManager();
            String str2 = this.f60894j;
            IObservabilityManager.DefaultImpls.trackUnExpectedScenario$default(observabilityManager, "HomeScreenActivity - Failed to handle deeplink: " + str2, (Map) null, 2, (Object) null);
            this.f60893i.navigateFromHomeToCart();
        }
        return Unit.INSTANCE;
    }
}
