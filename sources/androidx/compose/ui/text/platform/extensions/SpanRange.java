package androidx.compose.ui.text.platform.extensions;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006J\t\u0010\f\u001a\u00020\u0001HÆ\u0003J\t\u0010\r\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\b¨\u0006\u0016"}, d2 = {"Landroidx/compose/ui/text/platform/extensions/SpanRange;", "", "span", "start", "", "end", "(Ljava/lang/Object;II)V", "getEnd", "()I", "getSpan", "()Ljava/lang/Object;", "getStart", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class SpanRange {
    private final int end;
    @NotNull
    private final Object span;
    private final int start;

    public SpanRange(@NotNull Object obj, int i11, int i12) {
        Intrinsics.checkNotNullParameter(obj, TtmlNode.TAG_SPAN);
        this.span = obj;
        this.start = i11;
        this.end = i12;
    }

    public static /* synthetic */ SpanRange copy$default(SpanRange spanRange, Object obj, int i11, int i12, int i13, Object obj2) {
        if ((i13 & 1) != 0) {
            obj = spanRange.span;
        }
        if ((i13 & 2) != 0) {
            i11 = spanRange.start;
        }
        if ((i13 & 4) != 0) {
            i12 = spanRange.end;
        }
        return spanRange.copy(obj, i11, i12);
    }

    @NotNull
    public final Object component1() {
        return this.span;
    }

    public final int component2() {
        return this.start;
    }

    public final int component3() {
        return this.end;
    }

    @NotNull
    public final SpanRange copy(@NotNull Object obj, int i11, int i12) {
        Intrinsics.checkNotNullParameter(obj, TtmlNode.TAG_SPAN);
        return new SpanRange(obj, i11, i12);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SpanRange)) {
            return false;
        }
        SpanRange spanRange = (SpanRange) obj;
        return Intrinsics.areEqual(this.span, spanRange.span) && this.start == spanRange.start && this.end == spanRange.end;
    }

    public final int getEnd() {
        return this.end;
    }

    @NotNull
    public final Object getSpan() {
        return this.span;
    }

    public final int getStart() {
        return this.start;
    }

    public int hashCode() {
        return (((this.span.hashCode() * 31) + this.start) * 31) + this.end;
    }

    @NotNull
    public String toString() {
        return "SpanRange(span=" + this.span + ", start=" + this.start + ", end=" + this.end + ')';
    }
}
