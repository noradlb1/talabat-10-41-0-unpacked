package com.talabat.sdsquad.data.vendorslist.response;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0017\b\b\u0018\u00002\u00020\u0001B7\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0013JJ\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\t2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0010\u0010\fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lcom/talabat/sdsquad/data/vendorslist/response/ActiveEvent;", "", "eid", "", "emg", "", "eva", "evt", "isac", "", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;)V", "getEid", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getEmg", "()Ljava/lang/String;", "getEva", "getEvt", "getIsac", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/talabat/sdsquad/data/vendorslist/response/ActiveEvent;", "equals", "other", "hashCode", "toString", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ActiveEvent {
    @SerializedName("eid")
    @Nullable
    private final Integer eid;
    @SerializedName("emg")
    @Nullable
    private final String emg;
    @SerializedName("eva")
    @Nullable
    private final Integer eva;
    @SerializedName("evt")
    @Nullable
    private final String evt;
    @SerializedName("isac")
    @Nullable
    private final Boolean isac;

    public ActiveEvent(@Nullable Integer num, @Nullable String str, @Nullable Integer num2, @Nullable String str2, @Nullable Boolean bool) {
        this.eid = num;
        this.emg = str;
        this.eva = num2;
        this.evt = str2;
        this.isac = bool;
    }

    public static /* synthetic */ ActiveEvent copy$default(ActiveEvent activeEvent, Integer num, String str, Integer num2, String str2, Boolean bool, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            num = activeEvent.eid;
        }
        if ((i11 & 2) != 0) {
            str = activeEvent.emg;
        }
        String str3 = str;
        if ((i11 & 4) != 0) {
            num2 = activeEvent.eva;
        }
        Integer num3 = num2;
        if ((i11 & 8) != 0) {
            str2 = activeEvent.evt;
        }
        String str4 = str2;
        if ((i11 & 16) != 0) {
            bool = activeEvent.isac;
        }
        return activeEvent.copy(num, str3, num3, str4, bool);
    }

    @Nullable
    public final Integer component1() {
        return this.eid;
    }

    @Nullable
    public final String component2() {
        return this.emg;
    }

    @Nullable
    public final Integer component3() {
        return this.eva;
    }

    @Nullable
    public final String component4() {
        return this.evt;
    }

    @Nullable
    public final Boolean component5() {
        return this.isac;
    }

    @NotNull
    public final ActiveEvent copy(@Nullable Integer num, @Nullable String str, @Nullable Integer num2, @Nullable String str2, @Nullable Boolean bool) {
        return new ActiveEvent(num, str, num2, str2, bool);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActiveEvent)) {
            return false;
        }
        ActiveEvent activeEvent = (ActiveEvent) obj;
        return Intrinsics.areEqual((Object) this.eid, (Object) activeEvent.eid) && Intrinsics.areEqual((Object) this.emg, (Object) activeEvent.emg) && Intrinsics.areEqual((Object) this.eva, (Object) activeEvent.eva) && Intrinsics.areEqual((Object) this.evt, (Object) activeEvent.evt) && Intrinsics.areEqual((Object) this.isac, (Object) activeEvent.isac);
    }

    @Nullable
    public final Integer getEid() {
        return this.eid;
    }

    @Nullable
    public final String getEmg() {
        return this.emg;
    }

    @Nullable
    public final Integer getEva() {
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
        Integer num = this.eid;
        int i11 = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.emg;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Integer num2 = this.eva;
        int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str2 = this.evt;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool = this.isac;
        if (bool != null) {
            i11 = bool.hashCode();
        }
        return hashCode4 + i11;
    }

    @NotNull
    public String toString() {
        Integer num = this.eid;
        String str = this.emg;
        Integer num2 = this.eva;
        String str2 = this.evt;
        Boolean bool = this.isac;
        return "ActiveEvent(eid=" + num + ", emg=" + str + ", eva=" + num2 + ", evt=" + str2 + ", isac=" + bool + ")";
    }
}
