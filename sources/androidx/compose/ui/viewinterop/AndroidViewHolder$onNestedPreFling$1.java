package androidx.compose.ui.viewinterop;

import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
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
@DebugMetadata(c = "androidx.compose.ui.viewinterop.AndroidViewHolder$onNestedPreFling$1", f = "AndroidViewHolder.android.kt", i = {}, l = {498}, m = "invokeSuspend", n = {}, s = {})
public final class AndroidViewHolder$onNestedPreFling$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f10306h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ AndroidViewHolder f10307i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ long f10308j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AndroidViewHolder$onNestedPreFling$1(AndroidViewHolder androidViewHolder, long j11, Continuation<? super AndroidViewHolder$onNestedPreFling$1> continuation) {
        super(2, continuation);
        this.f10307i = androidViewHolder;
        this.f10308j = j11;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AndroidViewHolder$onNestedPreFling$1(this.f10307i, this.f10308j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((AndroidViewHolder$onNestedPreFling$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f10306h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            NestedScrollDispatcher access$getDispatcher$p = this.f10307i.dispatcher;
            long j11 = this.f10308j;
            this.f10306h = 1;
            if (access$getDispatcher$p.m4204dispatchPreFlingQWom1Mo(j11, this) == coroutine_suspended) {
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
