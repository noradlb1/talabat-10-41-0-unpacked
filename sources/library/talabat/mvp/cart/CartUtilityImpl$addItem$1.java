package library.talabat.mvp.cart;

import datamodels.CartMenuItem;
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
@DebugMetadata(c = "library.talabat.mvp.cart.CartUtilityImpl$addItem$1", f = "CartUtility.kt", i = {}, l = {80}, m = "invokeSuspend", n = {}, s = {})
public final class CartUtilityImpl$addItem$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f26593h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ CartUtilityImpl f26594i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ CartMenuItem f26595j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f26596k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f26597l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ String f26598m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CartUtilityImpl$addItem$1(CartUtilityImpl cartUtilityImpl, CartMenuItem cartMenuItem, String str, int i11, String str2, Continuation<? super CartUtilityImpl$addItem$1> continuation) {
        super(2, continuation);
        this.f26594i = cartUtilityImpl;
        this.f26595j = cartMenuItem;
        this.f26596k = str;
        this.f26597l = i11;
        this.f26598m = str2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        CartUtilityImpl$addItem$1 cartUtilityImpl$addItem$1 = new CartUtilityImpl$addItem$1(this.f26594i, this.f26595j, this.f26596k, this.f26597l, this.f26598m, continuation);
        cartUtilityImpl$addItem$1.L$0 = obj;
        return cartUtilityImpl$addItem$1;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((CartUtilityImpl$addItem$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f26593h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            CartUtilityImpl cartUtilityImpl = this.f26594i;
            CartMenuItem cartMenuItem = this.f26595j;
            String str = this.f26596k;
            int i12 = this.f26597l;
            String str2 = this.f26598m;
            Result.Companion companion = Result.Companion;
            Deferred async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new CartUtilityImpl$addItem$1$1$result$1(cartUtilityImpl, cartMenuItem, str, i12, str2, (Continuation<? super CartUtilityImpl$addItem$1$1$result$1>) null), 3, (Object) null);
            this.f26593h = 1;
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
