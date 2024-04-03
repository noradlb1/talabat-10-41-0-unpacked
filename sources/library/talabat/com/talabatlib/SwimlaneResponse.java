package library.talabat.com.talabatlib;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Llibrary/talabat/com/talabatlib/SwimlaneResponse;", "", "result", "Llibrary/talabat/com/talabatlib/SwimlaneData;", "(Llibrary/talabat/com/talabatlib/SwimlaneData;)V", "getResult", "()Llibrary/talabat/com/talabatlib/SwimlaneData;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SwimlaneResponse {
    @SerializedName("result")
    @Nullable
    private final SwimlaneData result;

    public SwimlaneResponse() {
        this((SwimlaneData) null, 1, (DefaultConstructorMarker) null);
    }

    public SwimlaneResponse(@Nullable SwimlaneData swimlaneData) {
        this.result = swimlaneData;
    }

    public static /* synthetic */ SwimlaneResponse copy$default(SwimlaneResponse swimlaneResponse, SwimlaneData swimlaneData, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            swimlaneData = swimlaneResponse.result;
        }
        return swimlaneResponse.copy(swimlaneData);
    }

    @Nullable
    public final SwimlaneData component1() {
        return this.result;
    }

    @NotNull
    public final SwimlaneResponse copy(@Nullable SwimlaneData swimlaneData) {
        return new SwimlaneResponse(swimlaneData);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SwimlaneResponse) && Intrinsics.areEqual((Object) this.result, (Object) ((SwimlaneResponse) obj).result);
    }

    @Nullable
    public final SwimlaneData getResult() {
        return this.result;
    }

    public int hashCode() {
        SwimlaneData swimlaneData = this.result;
        if (swimlaneData == null) {
            return 0;
        }
        return swimlaneData.hashCode();
    }

    @NotNull
    public String toString() {
        SwimlaneData swimlaneData = this.result;
        return "SwimlaneResponse(result=" + swimlaneData + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SwimlaneResponse(SwimlaneData swimlaneData, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : swimlaneData);
    }
}
