package androidx.lifecycle;

import androidx.annotation.RequiresApi;
import j$.time.Duration;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u001a2\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007\u001a\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0006\u001a0\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0007¨\u0006\u000b"}, d2 = {"T", "Lkotlinx/coroutines/flow/Flow;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "timeoutInMs", "Landroidx/lifecycle/LiveData;", "asLiveData", "asFlow", "j$/time/Duration", "timeout", "lifecycle-livedata-ktx_release"}, k = 2, mv = {1, 4, 1})
@JvmName(name = "FlowLiveDataConversions")
public final class FlowLiveDataConversions {
    @NotNull
    public static final <T> Flow<T> asFlow(@NotNull LiveData<T> liveData) {
        Intrinsics.checkNotNullParameter(liveData, "$this$asFlow");
        return FlowKt.flow(new FlowLiveDataConversions$asFlow$1(liveData, (Continuation) null));
    }

    @NotNull
    @JvmOverloads
    public static final <T> LiveData<T> asLiveData(@NotNull Flow<? extends T> flow) {
        return asLiveData$default((Flow) flow, (CoroutineContext) null, 0, 3, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public static final <T> LiveData<T> asLiveData(@NotNull Flow<? extends T> flow, @NotNull CoroutineContext coroutineContext) {
        return asLiveData$default((Flow) flow, coroutineContext, 0, 2, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public static final <T> LiveData<T> asLiveData(@NotNull Flow<? extends T> flow, @NotNull CoroutineContext coroutineContext, long j11) {
        Intrinsics.checkNotNullParameter(flow, "$this$asLiveData");
        Intrinsics.checkNotNullParameter(coroutineContext, "context");
        return CoroutineLiveDataKt.liveData(coroutineContext, j11, new FlowLiveDataConversions$asLiveData$1(flow, (Continuation) null));
    }

    public static /* synthetic */ LiveData asLiveData$default(Flow flow, CoroutineContext coroutineContext, long j11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i11 & 2) != 0) {
            j11 = 5000;
        }
        return asLiveData(flow, coroutineContext, j11);
    }

    @RequiresApi(26)
    @NotNull
    public static final <T> LiveData<T> asLiveData(@NotNull Flow<? extends T> flow, @NotNull CoroutineContext coroutineContext, @NotNull Duration duration) {
        Intrinsics.checkNotNullParameter(flow, "$this$asLiveData");
        Intrinsics.checkNotNullParameter(coroutineContext, "context");
        Intrinsics.checkNotNullParameter(duration, "timeout");
        return asLiveData(flow, coroutineContext, duration.toMillis());
    }

    public static /* synthetic */ LiveData asLiveData$default(Flow flow, CoroutineContext coroutineContext, Duration duration, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        return asLiveData(flow, coroutineContext, duration);
    }
}
