package library.talabat.mvp.login.data.api.response;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B7\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\nJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\bHÆ\u0003JJ\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\bHÖ\u0001R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0010\u0010\fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013¨\u0006!"}, d2 = {"Llibrary/talabat/mvp/login/data/api/response/ActiveEvent;", "", "isac", "", "eid", "", "eva", "evt", "", "emg", "(Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)V", "getEid", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getEmg", "()Ljava/lang/String;", "getEva", "getEvt", "getIsac", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)Llibrary/talabat/mvp/login/data/api/response/ActiveEvent;", "equals", "other", "hashCode", "", "toString", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ActiveEvent {
    @SerializedName("eid")
    @Nullable
    private final Long eid;
    @SerializedName("emg")
    @Nullable
    private final String emg;
    @SerializedName("eva")
    @Nullable
    private final Long eva;
    @SerializedName("evt")
    @Nullable
    private final String evt;
    @SerializedName("isac")
    @Nullable
    private final Boolean isac;

    public ActiveEvent(@Nullable Boolean bool, @Nullable Long l11, @Nullable Long l12, @Nullable String str, @Nullable String str2) {
        this.isac = bool;
        this.eid = l11;
        this.eva = l12;
        this.evt = str;
        this.emg = str2;
    }

    public static /* synthetic */ ActiveEvent copy$default(ActiveEvent activeEvent, Boolean bool, Long l11, Long l12, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            bool = activeEvent.isac;
        }
        if ((i11 & 2) != 0) {
            l11 = activeEvent.eid;
        }
        Long l13 = l11;
        if ((i11 & 4) != 0) {
            l12 = activeEvent.eva;
        }
        Long l14 = l12;
        if ((i11 & 8) != 0) {
            str = activeEvent.evt;
        }
        String str3 = str;
        if ((i11 & 16) != 0) {
            str2 = activeEvent.emg;
        }
        return activeEvent.copy(bool, l13, l14, str3, str2);
    }

    @Nullable
    public final Boolean component1() {
        return this.isac;
    }

    @Nullable
    public final Long component2() {
        return this.eid;
    }

    @Nullable
    public final Long component3() {
        return this.eva;
    }

    @Nullable
    public final String component4() {
        return this.evt;
    }

    @Nullable
    public final String component5() {
        return this.emg;
    }

    @NotNull
    public final ActiveEvent copy(@Nullable Boolean bool, @Nullable Long l11, @Nullable Long l12, @Nullable String str, @Nullable String str2) {
        return new ActiveEvent(bool, l11, l12, str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActiveEvent)) {
            return false;
        }
        ActiveEvent activeEvent = (ActiveEvent) obj;
        return Intrinsics.areEqual((Object) this.isac, (Object) activeEvent.isac) && Intrinsics.areEqual((Object) this.eid, (Object) activeEvent.eid) && Intrinsics.areEqual((Object) this.eva, (Object) activeEvent.eva) && Intrinsics.areEqual((Object) this.evt, (Object) activeEvent.evt) && Intrinsics.areEqual((Object) this.emg, (Object) activeEvent.emg);
    }

    @Nullable
    public final Long getEid() {
        return this.eid;
    }

    @Nullable
    public final String getEmg() {
        return this.emg;
    }

    @Nullable
    public final Long getEva() {
        return this.eva;
    }

    @Nullable
    public final String getEvt() {
        return this.evt;
    }

    @Nullable
    public final Boolean getIsac() {
        return this.isac;
    }

    public int hashCode() {
        Boolean bool = this.isac;
        int i11 = 0;
        int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Long l11 = this.eid;
        int hashCode2 = (hashCode + (l11 == null ? 0 : l11.hashCode())) * 31;
        Long l12 = this.eva;
        int hashCode3 = (hashCode2 + (l12 == null ? 0 : l12.hashCode())) * 31;
        String str = this.evt;
        int hashCode4 = (hashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.emg;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        return hashCode4 + i11;
    }

    @NotNull
    public String toString() {
        Boolean bool = this.isac;
        Long l11 = this.eid;
        Long l12 = this.eva;
        String str = this.evt;
        String str2 = this.emg;
        return "ActiveEvent(isac=" + bool + ", eid=" + l11 + ", eva=" + l12 + ", evt=" + str + ", emg=" + str2 + ")";
    }
}
