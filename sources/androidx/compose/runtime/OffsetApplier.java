package androidx.compose.runtime;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import w.a;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u000f\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000fJ\u001d\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0013J\u001d\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0013J \u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0005H\u0016J\u0018\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0005H\u0016J\b\u0010\u001a\u001a\u00020\fH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00028\u00008VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Landroidx/compose/runtime/OffsetApplier;", "N", "Landroidx/compose/runtime/Applier;", "applier", "offset", "", "(Landroidx/compose/runtime/Applier;I)V", "current", "getCurrent", "()Ljava/lang/Object;", "nesting", "clear", "", "down", "node", "(Ljava/lang/Object;)V", "insertBottomUp", "index", "instance", "(ILjava/lang/Object;)V", "insertTopDown", "move", "from", "to", "count", "remove", "up", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class OffsetApplier<N> implements Applier<N> {
    @NotNull
    private final Applier<N> applier;
    private int nesting;
    private final int offset;

    public OffsetApplier(@NotNull Applier<N> applier2, int i11) {
        Intrinsics.checkNotNullParameter(applier2, "applier");
        this.applier = applier2;
        this.offset = i11;
    }

    public void clear() {
        ComposerKt.composeRuntimeError("Clear is not valid on OffsetApplier".toString());
        throw new KotlinNothingValueException();
    }

    public void down(N n11) {
        this.nesting++;
        this.applier.down(n11);
    }

    public N getCurrent() {
        return this.applier.getCurrent();
    }

    public void insertBottomUp(int i11, N n11) {
        this.applier.insertBottomUp(i11 + (this.nesting == 0 ? this.offset : 0), n11);
    }

    public void insertTopDown(int i11, N n11) {
        this.applier.insertTopDown(i11 + (this.nesting == 0 ? this.offset : 0), n11);
    }

    public void move(int i11, int i12, int i13) {
        int i14;
        if (this.nesting == 0) {
            i14 = this.offset;
        } else {
            i14 = 0;
        }
        this.applier.move(i11 + i14, i12 + i14, i13);
    }

    public /* synthetic */ void onBeginChanges() {
        a.a(this);
    }

    public /* synthetic */ void onEndChanges() {
        a.b(this);
    }

    public void remove(int i11, int i12) {
        this.applier.remove(i11 + (this.nesting == 0 ? this.offset : 0), i12);
    }

    public void up() {
        boolean z11;
        int i11 = this.nesting;
        if (i11 > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            this.nesting = i11 - 1;
            this.applier.up();
            return;
        }
        ComposerKt.composeRuntimeError("OffsetApplier up called with no corresponding down".toString());
        throw new KotlinNothingValueException();
    }
}
