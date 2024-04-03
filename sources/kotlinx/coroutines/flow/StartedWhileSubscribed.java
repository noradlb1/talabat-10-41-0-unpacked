package kotlinx.coroutines.flow;

import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import l.a;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u000bH\u0017J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/flow/StartedWhileSubscribed;", "Lkotlinx/coroutines/flow/SharingStarted;", "stopTimeout", "", "replayExpiration", "(JJ)V", "command", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/SharingCommand;", "subscriptionCount", "Lkotlinx/coroutines/flow/StateFlow;", "", "equals", "", "other", "", "hashCode", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
final class StartedWhileSubscribed implements SharingStarted {
    /* access modifiers changed from: private */
    public final long replayExpiration;
    /* access modifiers changed from: private */
    public final long stopTimeout;

    public StartedWhileSubscribed(long j11, long j12) {
        boolean z11;
        this.stopTimeout = j11;
        this.replayExpiration = j12;
        boolean z12 = true;
        if (j11 >= 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            if (!(j12 < 0 ? false : z12)) {
                throw new IllegalArgumentException(("replayExpiration(" + j12 + " ms) cannot be negative").toString());
            }
            return;
        }
        throw new IllegalArgumentException(("stopTimeout(" + j11 + " ms) cannot be negative").toString());
    }

    @NotNull
    public Flow<SharingCommand> command(@NotNull StateFlow<Integer> stateFlow) {
        return FlowKt.distinctUntilChanged(FlowKt.dropWhile(FlowKt.transformLatest(stateFlow, new StartedWhileSubscribed$command$1(this, (Continuation<? super StartedWhileSubscribed$command$1>) null)), new StartedWhileSubscribed$command$2((Continuation<? super StartedWhileSubscribed$command$2>) null)));
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof StartedWhileSubscribed) {
            StartedWhileSubscribed startedWhileSubscribed = (StartedWhileSubscribed) obj;
            if (this.stopTimeout == startedWhileSubscribed.stopTimeout && this.replayExpiration == startedWhileSubscribed.replayExpiration) {
                return true;
            }
            return false;
        }
        return false;
    }

    @IgnoreJRERequirement
    public int hashCode() {
        return (a.a(this.stopTimeout) * 31) + a.a(this.replayExpiration);
    }

    @NotNull
    public String toString() {
        List createListBuilder = CollectionsKt__CollectionsJVMKt.createListBuilder(2);
        if (this.stopTimeout > 0) {
            createListBuilder.add("stopTimeout=" + this.stopTimeout + "ms");
        }
        if (this.replayExpiration < Long.MAX_VALUE) {
            createListBuilder.add("replayExpiration=" + this.replayExpiration + "ms");
        }
        List build = CollectionsKt__CollectionsJVMKt.build(createListBuilder);
        return "SharingStarted.WhileSubscribed(" + CollectionsKt___CollectionsKt.joinToString$default(build, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null) + ')';
    }
}
