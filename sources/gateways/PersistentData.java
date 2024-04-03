package gateways;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0003J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u0015\u0010\u0007\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÆ\u0001J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00018\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u000f"}, d2 = {"Lgateways/PersistentData;", "", "value", "(Ljava/lang/Object;)V", "getValue", "()Ljava/lang/Object;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PersistentData {
    @SerializedName("value")
    @Nullable
    private final Object value;

    public PersistentData(@Nullable Object obj) {
        this.value = obj;
    }

    public static /* synthetic */ PersistentData copy$default(PersistentData persistentData, Object obj, int i11, Object obj2) {
        if ((i11 & 1) != 0) {
            obj = persistentData.value;
        }
        return persistentData.copy(obj);
    }

    @Nullable
    public final Object component1() {
        return this.value;
    }

    @NotNull
    public final PersistentData copy(@Nullable Object obj) {
        return new PersistentData(obj);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PersistentData) && Intrinsics.areEqual(this.value, ((PersistentData) obj).value);
    }

    @Nullable
    public final Object getValue() {
        return this.value;
    }

    public int hashCode() {
        Object obj = this.value;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    @NotNull
    public String toString() {
        Object obj = this.value;
        return "PersistentData(value=" + obj + ")";
    }
}
