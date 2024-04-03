package com.talabat.sdsquad.data.swimlanes.responses;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/talabat/sdsquad/data/swimlanes/responses/Result;", "", "comment", "", "swimLanes", "", "Lcom/talabat/sdsquad/data/swimlanes/responses/SwimLane;", "(Ljava/lang/String;Ljava/util/List;)V", "getComment", "()Ljava/lang/String;", "getSwimLanes", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Result {
    @SerializedName("comment")
    @Nullable
    private final String comment;
    @SerializedName("swimLanes")
    @Nullable
    private final List<SwimLane> swimLanes;

    public Result(@Nullable String str, @Nullable List<SwimLane> list) {
        this.comment = str;
        this.swimLanes = list;
    }

    public static /* synthetic */ Result copy$default(Result result, String str, List<SwimLane> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = result.comment;
        }
        if ((i11 & 2) != 0) {
            list = result.swimLanes;
        }
        return result.copy(str, list);
    }

    @Nullable
    public final String component1() {
        return this.comment;
    }

    @Nullable
    public final List<SwimLane> component2() {
        return this.swimLanes;
    }

    @NotNull
    public final Result copy(@Nullable String str, @Nullable List<SwimLane> list) {
        return new Result(str, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Result)) {
            return false;
        }
        Result result = (Result) obj;
        return Intrinsics.areEqual((Object) this.comment, (Object) result.comment) && Intrinsics.areEqual((Object) this.swimLanes, (Object) result.swimLanes);
    }

    @Nullable
    public final String getComment() {
        return this.comment;
    }

    @Nullable
    public final List<SwimLane> getSwimLanes() {
        return this.swimLanes;
    }

    public int hashCode() {
        String str = this.comment;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        List<SwimLane> list = this.swimLanes;
        if (list != null) {
            i11 = list.hashCode();
        }
        return hashCode + i11;
    }

    @NotNull
    public String toString() {
        String str = this.comment;
        List<SwimLane> list = this.swimLanes;
        return "Result(comment=" + str + ", swimLanes=" + list + ")";
    }
}
