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

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0000H@"}, d2 = {"Lkotlinx/coroutines/channels/ProducerScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "kotlinx.coroutines.channels.TickerChannelsKt$ticker$3", f = "TickerChannels.kt", i = {}, l = {72, 73}, m = "invokeSuspend", n = {}, s = {})
public final class TickerChannelsKt$ticker$3 extends SuspendLambda implements Function2<ProducerScope<? super Unit>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f25388h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ TickerMode f25389i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ long f25390j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ long f25391k;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TickerMode.values().length];
            iArr[TickerMode.FIXED_PERIOD.ordinal()] = 1;
            iArr[TickerMode.FIXED_DELAY.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TickerChannelsKt$ticker$3(TickerMode tickerMode, long j11, long j12, Continuation<? super TickerChannelsKt$ticker$3> continuation) {
        super(2, continuation);
        this.f25389i = tickerMode;
        this.f25390j = j11;
        this.f25391k = j12;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        TickerChannelsKt$ticker$3 tickerChannelsKt$ticker$3 = new TickerChannelsKt$ticker$3(this.f25389i, this.f25390j, this.f25391k, continuation);
        tickerChannelsKt$ticker$3.L$0 = obj;
        return tickerChannelsKt$ticker$3;
    }

    @Nullable
    public final Object invoke(@NotNull ProducerScope<? super Unit> producerScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TickerChannelsKt$ticker$3) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f25388h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            ProducerScope producerScope = (ProducerScope) this.L$0;
            int i12 = WhenMappings.$EnumSwitchMapping$0[this.f25389i.ordinal()];
            if (i12 == 1) {
                long j11 = this.f25390j;
                long j12 = this.f25391k;
                SendChannel channel = producerScope.getChannel();
                this.f25388h = 1;
                if (TickerChannelsKt.fixedPeriodTicker(j11, j12, channel, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i12 == 2) {
                long j13 = this.f25390j;
                long j14 = this.f25391k;
                SendChannel channel2 = producerScope.getChannel();
                this.f25388h = 2;
                if (TickerChannelsKt.fixedDelayTicker(j13, j14, channel2, this) == coroutine_suspended) {
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
