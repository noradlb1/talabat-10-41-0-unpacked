package com.talabat.fluttercore.domain.entities;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/talabat/fluttercore/domain/entities/FlutterVertical;", "", "verticalId", "", "verticalName", "verticalIds", "", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getVerticalId", "()Ljava/lang/String;", "getVerticalIds", "()Ljava/util/List;", "getVerticalName", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "com_talabat_NewArchi_TalabatFlutterCore_TalabatFlutterCore"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FlutterVertical {
    @NotNull
    private final String verticalId;
    @NotNull
    private final List<Integer> verticalIds;
    @NotNull
    private final String verticalName;

    public FlutterVertical(@NotNull String str, @NotNull String str2, @NotNull List<Integer> list) {
        Intrinsics.checkNotNullParameter(str, "verticalId");
        Intrinsics.checkNotNullParameter(str2, "verticalName");
        Intrinsics.checkNotNullParameter(list, "verticalIds");
        this.verticalId = str;
        this.verticalName = str2;
        this.verticalIds = list;
    }

    public static /* synthetic */ FlutterVertical copy$default(FlutterVertical flutterVertical, String str, String str2, List<Integer> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = flutterVertical.verticalId;
        }
        if ((i11 & 2) != 0) {
            str2 = flutterVertical.verticalName;
        }
        if ((i11 & 4) != 0) {
            list = flutterVertical.verticalIds;
        }
        return flutterVertical.copy(str, str2, list);
    }

    @NotNull
    public final String component1() {
        return this.verticalId;
    }

    @NotNull
    public final String component2() {
        return this.verticalName;
    }

    @NotNull
    public final List<Integer> component3() {
        return this.verticalIds;
    }

    @NotNull
    public final FlutterVertical copy(@NotNull String str, @NotNull String str2, @NotNull List<Integer> list) {
        Intrinsics.checkNotNullParameter(str, "verticalId");
        Intrinsics.checkNotNullParameter(str2, "verticalName");
        Intrinsics.checkNotNullParameter(list, "verticalIds");
        return new FlutterVertical(str, str2, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FlutterVertical)) {
            return false;
        }
        FlutterVertical flutterVertical = (FlutterVertical) obj;
        return Intrinsics.areEqual((Object) this.verticalId, (Object) flutterVertical.verticalId) && Intrinsics.areEqual((Object) this.verticalName, (Object) flutterVertical.verticalName) && Intrinsics.areEqual((Object) this.verticalIds, (Object) flutterVertical.verticalIds);
    }

    @NotNull
    public final String getVerticalId() {
        return this.verticalId;
    }

    @NotNull
    public final List<Integer> getVerticalIds() {
        return this.verticalIds;
    }

    @NotNull
    public final String getVerticalName() {
        return this.verticalName;
    }

    public int hashCode() {
        return (((this.verticalId.hashCode() * 31) + this.verticalName.hashCode()) * 31) + this.verticalIds.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.verticalId;
        String str2 = this.verticalName;
        List<Integer> list = this.verticalIds;
        return "FlutterVertical(verticalId=" + str + ", verticalName=" + str2 + ", verticalIds=" + list + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FlutterVertical(String str, String str2, List list, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i11 & 4) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list);
    }
}
