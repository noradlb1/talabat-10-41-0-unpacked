package androidx.compose.ui.semantics;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004B\u0019\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\bJ\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0016R\u0015\u0010\u0007\u001a\u0004\u0018\u00018\u0000¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0013"}, d2 = {"Landroidx/compose/ui/semantics/AccessibilityAction;", "T", "Lkotlin/Function;", "", "", "label", "", "action", "(Ljava/lang/String;Lkotlin/Function;)V", "getAction", "()Lkotlin/Function;", "Lkotlin/Function;", "getLabel", "()Ljava/lang/String;", "equals", "other", "hashCode", "", "toString", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AccessibilityAction<T extends Function<? extends Boolean>> {
    public static final int $stable = 0;
    @Nullable
    private final T action;
    @Nullable
    private final String label;

    public AccessibilityAction(@Nullable String str, @Nullable T t11) {
        this.label = str;
        this.action = t11;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AccessibilityAction)) {
            return false;
        }
        AccessibilityAction accessibilityAction = (AccessibilityAction) obj;
        if (Intrinsics.areEqual((Object) this.label, (Object) accessibilityAction.label) && Intrinsics.areEqual((Object) this.action, (Object) accessibilityAction.action)) {
            return true;
        }
        return false;
    }

    @Nullable
    public final T getAction() {
        return this.action;
    }

    @Nullable
    public final String getLabel() {
        return this.label;
    }

    public int hashCode() {
        int i11;
        String str = this.label;
        int i12 = 0;
        if (str != null) {
            i11 = str.hashCode();
        } else {
            i11 = 0;
        }
        int i13 = i11 * 31;
        T t11 = this.action;
        if (t11 != null) {
            i12 = t11.hashCode();
        }
        return i13 + i12;
    }

    @NotNull
    public String toString() {
        return "AccessibilityAction(label=" + this.label + ", action=" + this.action + ')';
    }
}
