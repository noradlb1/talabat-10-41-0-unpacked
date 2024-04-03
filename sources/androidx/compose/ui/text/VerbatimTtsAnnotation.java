package androidx.compose.ui.text;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, d2 = {"Landroidx/compose/ui/text/VerbatimTtsAnnotation;", "Landroidx/compose/ui/text/TtsAnnotation;", "verbatim", "", "(Ljava/lang/String;)V", "getVerbatim", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "", "toString", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class VerbatimTtsAnnotation extends TtsAnnotation {
    public static final int $stable = 0;
    @NotNull
    private final String verbatim;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VerbatimTtsAnnotation(@NotNull String str) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "verbatim");
        this.verbatim = str;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof VerbatimTtsAnnotation) && Intrinsics.areEqual((Object) this.verbatim, (Object) ((VerbatimTtsAnnotation) obj).verbatim)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getVerbatim() {
        return this.verbatim;
    }

    public int hashCode() {
        return this.verbatim.hashCode();
    }

    @NotNull
    public String toString() {
        return "VerbatimTtsAnnotation(verbatim=" + this.verbatim + ')';
    }
}
