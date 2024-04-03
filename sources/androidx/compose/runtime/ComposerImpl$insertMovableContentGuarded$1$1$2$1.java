package androidx.compose.runtime;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class ComposerImpl$insertMovableContentGuarded$1$1$2$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ComposerImpl f9062g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> f9063h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ SlotReader f9064i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ MovableContentStateReference f9065j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ComposerImpl$insertMovableContentGuarded$1$1$2$1(ComposerImpl composerImpl, List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> list, SlotReader slotReader, MovableContentStateReference movableContentStateReference) {
        super(0);
        this.f9062g = composerImpl;
        this.f9063h = list;
        this.f9064i = slotReader;
        this.f9065j = movableContentStateReference;
    }

    public final void invoke() {
        SlotReader access$getReader$p;
        int[] access$getNodeCountOverrides$p;
        ComposerImpl composerImpl = this.f9062g;
        List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> list = this.f9063h;
        SlotReader slotReader = this.f9064i;
        MovableContentStateReference movableContentStateReference = this.f9065j;
        List access$getChanges$p = composerImpl.changes;
        try {
            composerImpl.changes = list;
            access$getReader$p = composerImpl.reader;
            access$getNodeCountOverrides$p = composerImpl.nodeCountOverrides;
            composerImpl.nodeCountOverrides = null;
            composerImpl.reader = slotReader;
            composerImpl.invokeMovableContentLambda(movableContentStateReference.getContent$runtime_release(), movableContentStateReference.getLocals$runtime_release(), movableContentStateReference.getParameter$runtime_release(), true);
            Unit unit = Unit.INSTANCE;
            composerImpl.reader = access$getReader$p;
            composerImpl.nodeCountOverrides = access$getNodeCountOverrides$p;
            composerImpl.changes = access$getChanges$p;
        } catch (Throwable th2) {
            composerImpl.changes = access$getChanges$p;
            throw th2;
        }
    }
}
