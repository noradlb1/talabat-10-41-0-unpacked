package androidx.compose.foundation.gestures;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Landroidx/compose/foundation/gestures/ScrollScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollExtensionsKt$scrollBy$2", f = "ScrollExtensions.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ScrollExtensionsKt$scrollBy$2 extends SuspendLambda implements Function2<ScrollScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f2154h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Ref.FloatRef f2155i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ float f2156j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScrollExtensionsKt$scrollBy$2(Ref.FloatRef floatRef, float f11, Continuation<? super ScrollExtensionsKt$scrollBy$2> continuation) {
        super(2, continuation);
        this.f2155i = floatRef;
        this.f2156j = f11;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ScrollExtensionsKt$scrollBy$2 scrollExtensionsKt$scrollBy$2 = new ScrollExtensionsKt$scrollBy$2(this.f2155i, this.f2156j, continuation);
        scrollExtensionsKt$scrollBy$2.L$0 = obj;
        return scrollExtensionsKt$scrollBy$2;
    }

    @Nullable
    public final Object invoke(@NotNull ScrollScope scrollScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ScrollExtensionsKt$scrollBy$2) create(scrollScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f2154h == 0) {
            ResultKt.throwOnFailure(obj);
            this.f2155i.element = ((ScrollScope) this.L$0).scrollBy(this.f2156j);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
