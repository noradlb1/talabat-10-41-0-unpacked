package androidx.compose.runtime;

import androidx.compose.runtime.collection.IdentityArraySet;
import androidx.compose.runtime.snapshots.Snapshot;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CancellableContinuation;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/CancellableContinuation;", "", "frameTime", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class Recomposer$runFrameLoop$2 extends Lambda implements Function1<Long, CancellableContinuation<? super Unit>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Recomposer f9183g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ List<ControlledComposition> f9184h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ List<ControlledComposition> f9185i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ ProduceFrameSignal f9186j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Recomposer$runFrameLoop$2(Recomposer recomposer, List<ControlledComposition> list, List<ControlledComposition> list2, ProduceFrameSignal produceFrameSignal) {
        super(1);
        this.f9183g = recomposer;
        this.f9184h = list;
        this.f9185i = list2;
        this.f9186j = produceFrameSignal;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).longValue());
    }

    @Nullable
    public final CancellableContinuation<Unit> invoke(long j11) {
        int i11;
        CancellableContinuation<Unit> access$deriveStateLocked;
        if (this.f9183g.broadcastFrameClock.getHasAwaiters()) {
            Recomposer recomposer = this.f9183g;
            Trace trace = Trace.INSTANCE;
            Object beginSection = trace.beginSection("Recomposer:animation");
            try {
                recomposer.broadcastFrameClock.sendFrame(j11);
                Snapshot.Companion.sendApplyNotifications();
                Unit unit = Unit.INSTANCE;
                trace.endSection(beginSection);
            } catch (Throwable th2) {
                Trace.INSTANCE.endSection(beginSection);
                throw th2;
            }
        }
        Recomposer recomposer2 = this.f9183g;
        List<ControlledComposition> list = this.f9184h;
        List<ControlledComposition> list2 = this.f9185i;
        ProduceFrameSignal produceFrameSignal = this.f9186j;
        Object beginSection2 = Trace.INSTANCE.beginSection("Recomposer:recompose");
        synchronized (recomposer2.stateLock) {
            recomposer2.recordComposerModificationsLocked();
            List access$getCompositionsAwaitingApply$p = recomposer2.compositionsAwaitingApply;
            int size = access$getCompositionsAwaitingApply$p.size();
            for (int i12 = 0; i12 < size; i12++) {
                list2.add((ControlledComposition) access$getCompositionsAwaitingApply$p.get(i12));
            }
            recomposer2.compositionsAwaitingApply.clear();
            List access$getCompositionInvalidations$p = recomposer2.compositionInvalidations;
            int size2 = access$getCompositionInvalidations$p.size();
            for (int i13 = 0; i13 < size2; i13++) {
                list.add((ControlledComposition) access$getCompositionInvalidations$p.get(i13));
            }
            recomposer2.compositionInvalidations.clear();
            produceFrameSignal.takeFrameRequestLocked();
            Unit unit2 = Unit.INSTANCE;
        }
        IdentityArraySet identityArraySet = new IdentityArraySet();
        try {
            int size3 = list.size();
            for (int i14 = 0; i14 < size3; i14++) {
                ControlledComposition access$performRecompose = recomposer2.performRecompose(list.get(i14), identityArraySet);
                if (access$performRecompose != null) {
                    list2.add(access$performRecompose);
                }
            }
            list.clear();
            if (!list2.isEmpty()) {
                recomposer2.changeCount = recomposer2.getChangeCount() + 1;
            }
            int size4 = list2.size();
            for (i11 = 0; i11 < size4; i11++) {
                list2.get(i11).applyChanges();
            }
            list2.clear();
            synchronized (recomposer2.stateLock) {
                access$deriveStateLocked = recomposer2.deriveStateLocked();
            }
            Trace.INSTANCE.endSection(beginSection2);
            return access$deriveStateLocked;
        } catch (Throwable th3) {
            Trace.INSTANCE.endSection(beginSection2);
            throw th3;
        }
    }
}
