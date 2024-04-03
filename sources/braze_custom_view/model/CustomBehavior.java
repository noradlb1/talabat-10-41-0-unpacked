package braze_custom_view.model;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0006\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\n\u001a\u00020\u000bHÖ\u0001J\t\u0010\f\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u000e"}, d2 = {"Lbraze_custom_view/model/CustomBehavior;", "", "isEnabled", "", "(Z)V", "()Z", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CustomBehavior {
    private final boolean isEnabled;

    public CustomBehavior(boolean z11) {
        this.isEnabled = z11;
    }

    public static /* synthetic */ CustomBehavior copy$default(CustomBehavior customBehavior, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = customBehavior.isEnabled;
        }
        return customBehavior.copy(z11);
    }

    public final boolean component1() {
        return this.isEnabled;
    }

    @NotNull
    public final CustomBehavior copy(boolean z11) {
        return new CustomBehavior(z11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof CustomBehavior) && this.isEnabled == ((CustomBehavior) obj).isEnabled;
    }

    public int hashCode() {
        boolean z11 = this.isEnabled;
        if (z11) {
            return 1;
        }
        return z11 ? 1 : 0;
    }

    public final boolean isEnabled() {
        return this.isEnabled;
    }

    @NotNull
    public String toString() {
        boolean z11 = this.isEnabled;
        return "CustomBehavior(isEnabled=" + z11 + ")";
    }
}
