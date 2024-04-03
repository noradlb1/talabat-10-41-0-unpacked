package com.talabat.feature.darkstoresflutter.data.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/talabat/feature/darkstoresflutter/data/model/FlutterTracking;", "", "nmrAdId", "", "(Ljava/lang/String;)V", "getNmrAdId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_darkstores-flutter_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FlutterTracking {
    @Nullable
    private final String nmrAdId;

    public FlutterTracking(@Nullable @Json(name = "nmrAdId") String str) {
        this.nmrAdId = str;
    }

    public static /* synthetic */ FlutterTracking copy$default(FlutterTracking flutterTracking, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = flutterTracking.nmrAdId;
        }
        return flutterTracking.copy(str);
    }

    @Nullable
    public final String component1() {
        return this.nmrAdId;
    }

    @NotNull
    public final FlutterTracking copy(@Nullable @Json(name = "nmrAdId") String str) {
        return new FlutterTracking(str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FlutterTracking) && Intrinsics.areEqual((Object) this.nmrAdId, (Object) ((FlutterTracking) obj).nmrAdId);
    }

    @Nullable
    public final String getNmrAdId() {
        return this.nmrAdId;
    }

    public int hashCode() {
        String str = this.nmrAdId;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.nmrAdId;
        return "FlutterTracking(nmrAdId=" + str + ")";
    }
}
