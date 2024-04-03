package kotlinx.coroutines.flow.internal;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b \u0018\u0000*\f\b\u0000\u0010\u0002*\u0006\u0012\u0002\b\u00030\u00012\u00060\u0003j\u0002`\u0004B\u0007¢\u0006\u0004\b$\u0010\u0017J\u000f\u0010\u0005\u001a\u00028\u0000H$¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\t2\u0006\u0010\b\u001a\u00020\u0007H$¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00028\u0000H\u0004¢\u0006\u0004\b\f\u0010\u0006J\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00028\u0000H\u0004¢\u0006\u0004\b\u000f\u0010\u0010R>\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\t2\u0010\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\t8\u0004@BX\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R$\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00078\u0004@BX\u000e¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u0019R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00070 8F¢\u0006\u0006\u001a\u0004\b!\u0010\"¨\u0006%"}, d2 = {"Lkotlinx/coroutines/flow/internal/AbstractSharedFlow;", "Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "S", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "createSlot", "()Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "", "size", "", "createSlotArray", "(I)[Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "a", "slot", "", "b", "(Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;)V", "<set-?>", "slots", "[Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "d", "()[Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "getSlots$annotations", "()V", "nCollectors", "I", "c", "()I", "nextIndex", "Lkotlinx/coroutines/flow/internal/SubscriptionCountStateFlow;", "_subscriptionCount", "Lkotlinx/coroutines/flow/internal/SubscriptionCountStateFlow;", "Lkotlinx/coroutines/flow/StateFlow;", "getSubscriptionCount", "()Lkotlinx/coroutines/flow/StateFlow;", "subscriptionCount", "<init>", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public abstract class AbstractSharedFlow<S extends AbstractSharedFlowSlot<?>> {
    @Nullable
    private SubscriptionCountStateFlow _subscriptionCount;
    /* access modifiers changed from: private */
    public int nCollectors;
    private int nextIndex;
    /* access modifiers changed from: private */
    @Nullable
    public S[] slots;

    @NotNull
    public final S a() {
        S s11;
        SubscriptionCountStateFlow subscriptionCountStateFlow;
        synchronized (this) {
            S[] sArr = this.slots;
            if (sArr == null) {
                sArr = createSlotArray(2);
                this.slots = sArr;
            } else if (this.nCollectors >= sArr.length) {
                S[] copyOf = Arrays.copyOf(sArr, sArr.length * 2);
                Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
                this.slots = (AbstractSharedFlowSlot[]) copyOf;
                sArr = (AbstractSharedFlowSlot[]) copyOf;
            }
            int i11 = this.nextIndex;
            do {
                s11 = sArr[i11];
                if (s11 == null) {
                    s11 = createSlot();
                    sArr[i11] = s11;
                }
                i11++;
                if (i11 >= sArr.length) {
                    i11 = 0;
                }
            } while (!s11.allocateLocked(this));
            this.nextIndex = i11;
            this.nCollectors++;
            subscriptionCountStateFlow = this._subscriptionCount;
        }
        if (subscriptionCountStateFlow != null) {
            subscriptionCountStateFlow.increment(1);
        }
        return s11;
    }

    public final void b(@NotNull S s11) {
        SubscriptionCountStateFlow subscriptionCountStateFlow;
        int i11;
        Continuation[] freeLocked;
        synchronized (this) {
            int i12 = this.nCollectors - 1;
            this.nCollectors = i12;
            subscriptionCountStateFlow = this._subscriptionCount;
            if (i12 == 0) {
                this.nextIndex = 0;
            }
            freeLocked = s11.freeLocked(this);
        }
        for (Continuation continuation : freeLocked) {
            if (continuation != null) {
                Result.Companion companion = Result.Companion;
                continuation.resumeWith(Result.m6329constructorimpl(Unit.INSTANCE));
            }
        }
        if (subscriptionCountStateFlow != null) {
            subscriptionCountStateFlow.increment(-1);
        }
    }

    public final int c() {
        return this.nCollectors;
    }

    @NotNull
    public abstract S createSlot();

    @NotNull
    public abstract S[] createSlotArray(int i11);

    @Nullable
    public final S[] d() {
        return this.slots;
    }

    @NotNull
    public final StateFlow<Integer> getSubscriptionCount() {
        SubscriptionCountStateFlow subscriptionCountStateFlow;
        synchronized (this) {
            subscriptionCountStateFlow = this._subscriptionCount;
            if (subscriptionCountStateFlow == null) {
                subscriptionCountStateFlow = new SubscriptionCountStateFlow(this.nCollectors);
                this._subscriptionCount = subscriptionCountStateFlow;
            }
        }
        return subscriptionCountStateFlow;
    }
}
