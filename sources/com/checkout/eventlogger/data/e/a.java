package com.checkout.eventlogger.data.e;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class a {
    @SerializedName("correlationId")
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public final String f44216a;
    @SerializedName("loglevel")
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public final String f44217b;

    public a(@Nullable String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str2, "logLevel");
        this.f44216a = str;
        this.f44217b = str2;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Intrinsics.areEqual((Object) this.f44216a, (Object) aVar.f44216a) && Intrinsics.areEqual((Object) this.f44217b, (Object) aVar.f44217b);
    }

    public int hashCode() {
        String str = this.f44216a;
        int i11 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f44217b;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        return hashCode + i11;
    }

    @NotNull
    public String toString() {
        return "CkoMetadataDTO(correlationId=" + this.f44216a + ", logLevel=" + this.f44217b + ")";
    }
}
