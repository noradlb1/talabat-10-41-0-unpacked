package org.koin.core.qualifier;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0002\u0010\u0005J\r\u0010\b\u001a\u00060\u0003j\u0002`\u0004HÆ\u0003J\u0017\u0010\t\u001a\u00020\u00002\f\b\u0002\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\b\u0010\u0010\u001a\u00020\u0003H\u0016R\u0018\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lorg/koin/core/qualifier/StringQualifier;", "Lorg/koin/core/qualifier/Qualifier;", "value", "", "Lorg/koin/core/qualifier/QualifierValue;", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "koin-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class StringQualifier implements Qualifier {
    @NotNull
    private final String value;

    public StringQualifier(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        this.value = str;
    }

    public static /* synthetic */ StringQualifier copy$default(StringQualifier stringQualifier, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = stringQualifier.getValue();
        }
        return stringQualifier.copy(str);
    }

    @NotNull
    public final String component1() {
        return getValue();
    }

    @NotNull
    public final StringQualifier copy(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        return new StringQualifier(str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof StringQualifier) && Intrinsics.areEqual((Object) getValue(), (Object) ((StringQualifier) obj).getValue());
    }

    @NotNull
    public String getValue() {
        return this.value;
    }

    public int hashCode() {
        return getValue().hashCode();
    }

    @NotNull
    public String toString() {
        return getValue();
    }
}
