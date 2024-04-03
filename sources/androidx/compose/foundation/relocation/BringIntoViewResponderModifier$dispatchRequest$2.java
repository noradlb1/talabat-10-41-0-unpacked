package androidx.compose.foundation.relocation;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "androidx.compose.foundation.relocation.BringIntoViewResponderModifier$dispatchRequest$2", f = "BringIntoViewResponder.kt", i = {}, l = {284}, m = "invokeSuspend", n = {}, s = {})
public final class BringIntoViewResponderModifier$dispatchRequest$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f3202h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ BringIntoViewResponderModifier f3203i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ LayoutCoordinates f3204j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Rect f3205k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Rect f3206l;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "androidx.compose.foundation.relocation.BringIntoViewResponderModifier$dispatchRequest$2$1", f = "BringIntoViewResponder.kt", i = {}, l = {278}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.foundation.relocation.BringIntoViewResponderModifier$dispatchRequest$2$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: h  reason: collision with root package name */
        public int f3207h;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(bringIntoViewResponderModifier, rect, continuation);
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i11 = this.f3207h;
            if (i11 == 0) {
                ResultKt.throwOnFailure(obj);
                BringIntoViewResponder responder = bringIntoViewResponderModifier.getResponder();
                final Rect rect = rect;
                AnonymousClass1 r12 = new Function0<Rect>() {
                    @Nullable
                    public final Rect invoke() {
                        return rect;
                    }
                };
                this.f3207h = 1;
                if (responder.bringChildIntoView(r12, this) == coroutine_suspended) {
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

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BringIntoViewResponderModifier$dispatchRequest$2(BringIntoViewResponderModifier bringIntoViewResponderModifier, LayoutCoordinates layoutCoordinates, Rect rect, Rect rect2, Continuation<? super BringIntoViewResponderModifier$dispatchRequest$2> continuation) {
        super(2, continuation);
        this.f3203i = bringIntoViewResponderModifier;
        this.f3204j = layoutCoordinates;
        this.f3205k = rect;
        this.f3206l = rect2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        BringIntoViewResponderModifier$dispatchRequest$2 bringIntoViewResponderModifier$dispatchRequest$2 = new BringIntoViewResponderModifier$dispatchRequest$2(this.f3203i, this.f3204j, this.f3205k, this.f3206l, continuation);
        bringIntoViewResponderModifier$dispatchRequest$2.L$0 = obj;
        return bringIntoViewResponderModifier$dispatchRequest$2;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((BringIntoViewResponderModifier$dispatchRequest$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f3202h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            final BringIntoViewResponderModifier bringIntoViewResponderModifier = this.f3203i;
            final Rect rect = this.f3205k;
            Job unused = BuildersKt__Builders_commonKt.launch$default((CoroutineScope) this.L$0, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 3, (Object) null);
            BringIntoViewParent b11 = this.f3203i.b();
            LayoutCoordinates layoutCoordinates = this.f3204j;
            final Rect rect2 = this.f3206l;
            AnonymousClass2 r32 = new Function0<Rect>() {
                @Nullable
                public final Rect invoke() {
                    return rect2;
                }
            };
            this.f3202h = 1;
            if (b11.bringChildIntoView(layoutCoordinates, r32, this) == coroutine_suspended) {
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
