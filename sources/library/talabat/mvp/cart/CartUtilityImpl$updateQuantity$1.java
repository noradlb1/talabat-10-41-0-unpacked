package library.talabat.mvp.cart;

import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "library.talabat.mvp.cart.CartUtilityImpl$updateQuantity$1", f = "CartUtility.kt", i = {}, l = {47}, m = "invokeSuspend", n = {}, s = {})
public final class CartUtilityImpl$updateQuantity$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f26617h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ CartUtilityImpl f26618i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f26619j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f26620k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f26621l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ List<Integer> f26622m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CartUtilityImpl$updateQuantity$1(CartUtilityImpl cartUtilityImpl, int i11, String str, int i12, List<Integer> list, Continuation<? super CartUtilityImpl$updateQuantity$1> continuation) {
        super(2, continuation);
        this.f26618i = cartUtilityImpl;
        this.f26619j = i11;
        this.f26620k = str;
        this.f26621l = i12;
        this.f26622m = list;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        CartUtilityImpl$updateQuantity$1 cartUtilityImpl$updateQuantity$1 = new CartUtilityImpl$updateQuantity$1(this.f26618i, this.f26619j, this.f26620k, this.f26621l, this.f26622m, continuation);
        cartUtilityImpl$updateQuantity$1.L$0 = obj;
        return cartUtilityImpl$updateQuantity$1;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((CartUtilityImpl$updateQuantity$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f26617h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            CartUtilityImpl cartUtilityImpl = this.f26618i;
            int i12 = this.f26619j;
            String str = this.f26620k;
            int i13 = this.f26621l;
            List<Integer> list = this.f26622m;
            Result.Companion companion = Result.Companion;
            Deferred async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new CartUtilityImpl$updateQuantity$1$1$result$1(cartUtilityImpl, i12, str, i13, list, (Continuation<? super CartUtilityImpl$updateQuantity$1$1$result$1>) null), 3, (Object) null);
            this.f26617h = 1;
            if (async$default.await(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.m6329constructorimpl(ResultKt.createFailure(th2));
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Result.m6329constructorimpl(Unit.INSTANCE);
        return Unit.INSTANCE;
    }
}
