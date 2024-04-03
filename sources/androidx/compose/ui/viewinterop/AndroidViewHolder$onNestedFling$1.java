package androidx.compose.ui.viewinterop;

import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.unit.Velocity;
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

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "androidx.compose.ui.viewinterop.AndroidViewHolder$onNestedFling$1", f = "AndroidViewHolder.android.kt", i = {}, l = {480, 485}, m = "invokeSuspend", n = {}, s = {})
public final class AndroidViewHolder$onNestedFling$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f10302h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f10303i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ AndroidViewHolder f10304j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ long f10305k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AndroidViewHolder$onNestedFling$1(boolean z11, AndroidViewHolder androidViewHolder, long j11, Continuation<? super AndroidViewHolder$onNestedFling$1> continuation) {
        super(2, continuation);
        this.f10303i = z11;
        this.f10304j = androidViewHolder;
        this.f10305k = j11;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AndroidViewHolder$onNestedFling$1(this.f10303i, this.f10304j, this.f10305k, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((AndroidViewHolder$onNestedFling$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f10302h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            if (!this.f10303i) {
                NestedScrollDispatcher access$getDispatcher$p = this.f10304j.dispatcher;
                long r52 = Velocity.Companion.m5714getZero9UxMQ8M();
                long j11 = this.f10305k;
                this.f10302h = 1;
                if (access$getDispatcher$p.m4202dispatchPostFlingRZ2iAVY(r52, j11, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                NestedScrollDispatcher access$getDispatcher$p2 = this.f10304j.dispatcher;
                long j12 = this.f10305k;
                long r62 = Velocity.Companion.m5714getZero9UxMQ8M();
                this.f10302h = 2;
                if (access$getDispatcher$p2.m4202dispatchPostFlingRZ2iAVY(j12, r62, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i11 == 1 || i11 == 2) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
