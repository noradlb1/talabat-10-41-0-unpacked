package library.talabat.mvp.cart;

import com.talabat.feature.foodcart2.domain.IFoodCartRepository;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "library.talabat.mvp.cart.CartUtilityImpl$setCurrentCartId$1$1$result$1", f = "CartUtility.kt", i = {}, l = {89}, m = "invokeSuspend", n = {}, s = {})
public final class CartUtilityImpl$setCurrentCartId$1$1$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f26613h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ CartUtilityImpl f26614i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f26615j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function1<Boolean, Unit> f26616k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CartUtilityImpl$setCurrentCartId$1$1$result$1(CartUtilityImpl cartUtilityImpl, int i11, Function1<? super Boolean, Unit> function1, Continuation<? super CartUtilityImpl$setCurrentCartId$1$1$result$1> continuation) {
        super(2, continuation);
        this.f26614i = cartUtilityImpl;
        this.f26615j = i11;
        this.f26616k = function1;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new CartUtilityImpl$setCurrentCartId$1$1$result$1(this.f26614i, this.f26615j, this.f26616k, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((CartUtilityImpl$setCurrentCartId$1$1$result$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f26613h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            IFoodCartRepository access$getFoodCartRepository$p = this.f26614i.foodCartRepository;
            int i12 = this.f26615j;
            this.f26613h = 1;
            obj = access$getFoodCartRepository$p.setCurrentCartId(i12, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.f26616k.invoke(Boxing.boxBoolean(((Boolean) obj).booleanValue()));
        return Unit.INSTANCE;
    }
}
