package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Landroidx/compose/runtime/OpaqueKey;", "", "key", "", "(Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class OpaqueKey {
    @NotNull
    private final String key;

    public OpaqueKey(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        this.key = str;
    }

    public static /* synthetic */ OpaqueKey copy$default(OpaqueKey opaqueKey, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = opaqueKey.key;
        }
        return opaqueKey.copy(str);
    }

    @NotNull
    public final String component1() {
        return this.key;
    }

    @NotNull
    public final OpaqueKey copy(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return new OpaqueKey(str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof OpaqueKey) && Intrinsics.areEqual((Object) this.key, (Object) ((OpaqueKey) obj).key);
    }

    @NotNull
    public final String getKey() {
        return this.key;
    }

    public int hashCode() {
        return this.key.hashCode();
    }

    @NotNull
    public String toString() {
        return "OpaqueKey(key=" + this.key + ')';
    }
}
