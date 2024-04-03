package library.talabat.mvp.cart;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.talabat.feature.foodcart2.domain.IFoodCartRepository;
import datamodels.CartMenuItem;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "library.talabat.mvp.cart.CartUtilityImpl$addItem$1$1$result$1", f = "CartUtility.kt", i = {}, l = {68}, m = "invokeSuspend", n = {}, s = {})
public final class CartUtilityImpl$addItem$1$1$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f26599h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ CartUtilityImpl f26600i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ CartMenuItem f26601j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f26602k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f26603l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ String f26604m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CartUtilityImpl$addItem$1$1$result$1(CartUtilityImpl cartUtilityImpl, CartMenuItem cartMenuItem, String str, int i11, String str2, Continuation<? super CartUtilityImpl$addItem$1$1$result$1> continuation) {
        super(2, continuation);
        this.f26600i = cartUtilityImpl;
        this.f26601j = cartMenuItem;
        this.f26602k = str;
        this.f26603l = i11;
        this.f26604m = str2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new CartUtilityImpl$addItem$1$1$result$1(this.f26600i, this.f26601j, this.f26602k, this.f26603l, this.f26604m, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((CartUtilityImpl$addItem$1$1$result$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f26599h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            IFoodCartRepository access$getFoodCartRepository$p = this.f26600i.foodCartRepository;
            Map mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("menuItemId", Boxing.boxInt(this.f26601j.f13861id)), TuplesKt.to("specialRequest", this.f26602k), TuplesKt.to(FirebaseAnalytics.Param.QUANTITY, Boxing.boxInt(this.f26601j.getQuantity())), TuplesKt.to("choices", this.f26600i.mapChoices(this.f26601j.selectedChoices)), TuplesKt.to("isFromUpsell", Boxing.boxBoolean(this.f26601j.isUpsellingItem)));
            int i12 = this.f26603l;
            String str = this.f26604m;
            this.f26599h = 1;
            if (access$getFoodCartRepository$p.addItem(mapOf, i12, str, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
