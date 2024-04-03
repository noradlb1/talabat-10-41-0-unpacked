package androidx.window.layout;

import androidx.annotation.RestrictTo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0015\b\u0017\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Landroidx/window/layout/WindowLayoutInfo;", "", "displayFeatures", "", "Landroidx/window/layout/DisplayFeature;", "(Ljava/util/List;)V", "getDisplayFeatures", "()Ljava/util/List;", "equals", "", "other", "hashCode", "", "toString", "", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WindowLayoutInfo {
    @NotNull
    private final List<DisplayFeature> displayFeatures;

    @RestrictTo({RestrictTo.Scope.TESTS})
    public WindowLayoutInfo(@NotNull List<? extends DisplayFeature> list) {
        Intrinsics.checkNotNullParameter(list, "displayFeatures");
        this.displayFeatures = list;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !Intrinsics.areEqual((Object) WindowLayoutInfo.class, (Object) obj.getClass())) {
            return false;
        }
        return Intrinsics.areEqual((Object) this.displayFeatures, (Object) ((WindowLayoutInfo) obj).displayFeatures);
    }

    @NotNull
    public final List<DisplayFeature> getDisplayFeatures() {
        return this.displayFeatures;
    }

    public int hashCode() {
        return this.displayFeatures.hashCode();
    }

    @NotNull
    public String toString() {
        return CollectionsKt___CollectionsKt.joinToString$default(this.displayFeatures, IndicativeSentencesGeneration.DEFAULT_SEPARATOR, "WindowLayoutInfo{ DisplayFeatures[", "] }", 0, (CharSequence) null, (Function1) null, 56, (Object) null);
    }
}
