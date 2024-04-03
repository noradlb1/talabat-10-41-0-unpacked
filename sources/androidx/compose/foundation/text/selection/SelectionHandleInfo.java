package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.Handle;
import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0018\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\r\u001a\u00020\u0005HÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\nJ*\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0019"}, d2 = {"Landroidx/compose/foundation/text/selection/SelectionHandleInfo;", "", "handle", "Landroidx/compose/foundation/text/Handle;", "position", "Landroidx/compose/ui/geometry/Offset;", "(Landroidx/compose/foundation/text/Handle;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getHandle", "()Landroidx/compose/foundation/text/Handle;", "getPosition-F1C5BW0", "()J", "J", "component1", "component2", "component2-F1C5BW0", "copy", "copy-Uv8p0NA", "(Landroidx/compose/foundation/text/Handle;J)Landroidx/compose/foundation/text/selection/SelectionHandleInfo;", "equals", "", "other", "hashCode", "", "toString", "", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SelectionHandleInfo {
    @NotNull
    private final Handle handle;
    private final long position;

    private SelectionHandleInfo(Handle handle2, long j11) {
        this.handle = handle2;
        this.position = j11;
    }

    public /* synthetic */ SelectionHandleInfo(Handle handle2, long j11, DefaultConstructorMarker defaultConstructorMarker) {
        this(handle2, j11);
    }

    /* renamed from: copy-Uv8p0NA$default  reason: not valid java name */
    public static /* synthetic */ SelectionHandleInfo m978copyUv8p0NA$default(SelectionHandleInfo selectionHandleInfo, Handle handle2, long j11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            handle2 = selectionHandleInfo.handle;
        }
        if ((i11 & 2) != 0) {
            j11 = selectionHandleInfo.position;
        }
        return selectionHandleInfo.m980copyUv8p0NA(handle2, j11);
    }

    @NotNull
    public final Handle component1() {
        return this.handle;
    }

    /* renamed from: component2-F1C5BW0  reason: not valid java name */
    public final long m979component2F1C5BW0() {
        return this.position;
    }

    @NotNull
    /* renamed from: copy-Uv8p0NA  reason: not valid java name */
    public final SelectionHandleInfo m980copyUv8p0NA(@NotNull Handle handle2, long j11) {
        Intrinsics.checkNotNullParameter(handle2, "handle");
        return new SelectionHandleInfo(handle2, j11, (DefaultConstructorMarker) null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SelectionHandleInfo)) {
            return false;
        }
        SelectionHandleInfo selectionHandleInfo = (SelectionHandleInfo) obj;
        return this.handle == selectionHandleInfo.handle && Offset.m2673equalsimpl0(this.position, selectionHandleInfo.position);
    }

    @NotNull
    public final Handle getHandle() {
        return this.handle;
    }

    /* renamed from: getPosition-F1C5BW0  reason: not valid java name */
    public final long m981getPositionF1C5BW0() {
        return this.position;
    }

    public int hashCode() {
        return (this.handle.hashCode() * 31) + Offset.m2678hashCodeimpl(this.position);
    }

    @NotNull
    public String toString() {
        return "SelectionHandleInfo(handle=" + this.handle + ", position=" + Offset.m2684toStringimpl(this.position) + ')';
    }
}
