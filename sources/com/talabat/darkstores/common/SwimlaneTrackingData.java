package com.talabat.darkstores.common;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\bJ&\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/talabat/darkstores/common/SwimlaneTrackingData;", "", "swimlaneTitle", "", "swimlaneLength", "", "(Ljava/lang/String;Ljava/lang/Integer;)V", "getSwimlaneLength", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSwimlaneTitle", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Integer;)Lcom/talabat/darkstores/common/SwimlaneTrackingData;", "equals", "", "other", "hashCode", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SwimlaneTrackingData {
    @Nullable
    private final Integer swimlaneLength;
    @Nullable
    private final String swimlaneTitle;

    public SwimlaneTrackingData() {
        this((String) null, (Integer) null, 3, (DefaultConstructorMarker) null);
    }

    public SwimlaneTrackingData(@Nullable String str, @Nullable Integer num) {
        this.swimlaneTitle = str;
        this.swimlaneLength = num;
    }

    public static /* synthetic */ SwimlaneTrackingData copy$default(SwimlaneTrackingData swimlaneTrackingData, String str, Integer num, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = swimlaneTrackingData.swimlaneTitle;
        }
        if ((i11 & 2) != 0) {
            num = swimlaneTrackingData.swimlaneLength;
        }
        return swimlaneTrackingData.copy(str, num);
    }

    @Nullable
    public final String component1() {
        return this.swimlaneTitle;
    }

    @Nullable
    public final Integer component2() {
        return this.swimlaneLength;
    }

    @NotNull
    public final SwimlaneTrackingData copy(@Nullable String str, @Nullable Integer num) {
        return new SwimlaneTrackingData(str, num);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SwimlaneTrackingData)) {
            return false;
        }
        SwimlaneTrackingData swimlaneTrackingData = (SwimlaneTrackingData) obj;
        return Intrinsics.areEqual((Object) this.swimlaneTitle, (Object) swimlaneTrackingData.swimlaneTitle) && Intrinsics.areEqual((Object) this.swimlaneLength, (Object) swimlaneTrackingData.swimlaneLength);
    }

    @Nullable
    public final Integer getSwimlaneLength() {
        return this.swimlaneLength;
    }

    @Nullable
    public final String getSwimlaneTitle() {
        return this.swimlaneTitle;
    }

    public int hashCode() {
        String str = this.swimlaneTitle;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.swimlaneLength;
        if (num != null) {
            i11 = num.hashCode();
        }
        return hashCode + i11;
    }

    @NotNull
    public String toString() {
        String str = this.swimlaneTitle;
        Integer num = this.swimlaneLength;
        return "SwimlaneTrackingData(swimlaneTitle=" + str + ", swimlaneLength=" + num + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SwimlaneTrackingData(String str, Integer num, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : num);
    }
}
