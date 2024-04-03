package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0004\u001a\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00018\u0000H@"}, d2 = {"", "E", "it", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNotNull$1", f = "Deprecated.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ChannelsKt__DeprecatedKt$filterNotNull$1 extends SuspendLambda implements Function2<E, Continuation<? super Boolean>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f25243h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f25244i;

    public ChannelsKt__DeprecatedKt$filterNotNull$1(Continuation<? super ChannelsKt__DeprecatedKt$filterNotNull$1> continuation) {
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ChannelsKt__DeprecatedKt$filterNotNull$1 channelsKt__DeprecatedKt$filterNotNull$1 = new ChannelsKt__DeprecatedKt$filterNotNull$1(continuation);
        channelsKt__DeprecatedKt$filterNotNull$1.f25244i = obj;
        return channelsKt__DeprecatedKt$filterNotNull$1;
    }

    @Nullable
    public final Object invoke(@Nullable E e11, @Nullable Continuation<? super Boolean> continuation) {
        return ((ChannelsKt__DeprecatedKt$filterNotNull$1) create(e11, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        boolean z11;
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f25243h == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.f25244i != null) {
                z11 = true;
            } else {
                z11 = false;
            }
            return Boxing.boxBoolean(z11);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
