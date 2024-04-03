package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0003\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00018\u0000H@"}, d2 = {"", "E", "it", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$requireNoNulls$1", f = "Deprecated.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ChannelsKt__DeprecatedKt$requireNoNulls$1 extends SuspendLambda implements Function2 {

    /* renamed from: h  reason: collision with root package name */
    public int f25318h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f25319i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ ReceiveChannel f25320j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChannelsKt__DeprecatedKt$requireNoNulls$1(ReceiveChannel receiveChannel, Continuation continuation) {
        super(2, continuation);
        this.f25320j = receiveChannel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ChannelsKt__DeprecatedKt$requireNoNulls$1 channelsKt__DeprecatedKt$requireNoNulls$1 = new ChannelsKt__DeprecatedKt$requireNoNulls$1(this.f25320j, continuation);
        channelsKt__DeprecatedKt$requireNoNulls$1.f25319i = obj;
        return channelsKt__DeprecatedKt$requireNoNulls$1;
    }

    @Nullable
    public final Object invoke(@Nullable Object obj, @Nullable Continuation continuation) {
        return ((ChannelsKt__DeprecatedKt$requireNoNulls$1) create(obj, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f25318h == 0) {
            ResultKt.throwOnFailure(obj);
            Object obj2 = this.f25319i;
            if (obj2 != null) {
                return obj2;
            }
            throw new IllegalArgumentException("null element found in " + this.f25320j + '.');
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
