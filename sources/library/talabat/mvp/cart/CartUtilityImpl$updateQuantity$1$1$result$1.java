package library.talabat.mvp.cart;

import com.talabat.feature.foodcart2.domain.IFoodCartRepository;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "library.talabat.mvp.cart.CartUtilityImpl$updateQuantity$1$1$result$1", f = "CartUtility.kt", i = {}, l = {40}, m = "invokeSuspend", n = {}, s = {})
public final class CartUtilityImpl$updateQuantity$1$1$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f26623h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ CartUtilityImpl f26624i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f26625j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f26626k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f26627l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ List<Integer> f26628m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CartUtilityImpl$updateQuantity$1$1$result$1(CartUtilityImpl cartUtilityImpl, int i11, String str, int i12, List<Integer> list, Continuation<? super CartUtilityImpl$updateQuantity$1$1$result$1> continuation) {
        super(2, continuation);
        this.f26624i = cartUtilityImpl;
        this.f26625j = i11;
        this.f26626k = str;
        this.f26627l = i12;
        this.f26628m = list;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new CartUtilityImpl$updateQuantity$1$1$result$1(this.f26624i, this.f26625j, this.f26626k, this.f26627l, this.f26628m, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((CartUtilityImpl$updateQuantity$1$1$result$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f26623h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            IFoodCartRepository access$getFoodCartRepository$p = this.f26624i.foodCartRepository;
            int i12 = this.f26625j;
            String str = this.f26626k;
            int i13 = this.f26627l;
            List<Integer> list = this.f26628m;
            this.f26623h = 1;
            if (access$getFoodCartRepository$p.updateQuantity(i12, str, i13, list, this) == coroutine_suspended) {
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
