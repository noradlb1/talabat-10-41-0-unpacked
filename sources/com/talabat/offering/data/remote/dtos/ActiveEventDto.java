package com.talabat.offering.data.remote.dtos;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\b\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0013JJ\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\t2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0007HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00018\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0012\u0010\fR\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\b\u0010\u0013¨\u0006 "}, d2 = {"Lcom/talabat/offering/data/remote/dtos/ActiveEventDto;", "", "eventId", "", "eventMsg", "eventValue", "eventType", "", "isActive", "", "(Ljava/lang/Integer;Ljava/lang/Object;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;)V", "getEventId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getEventMsg", "()Ljava/lang/Object;", "getEventType", "()Ljava/lang/String;", "getEventValue", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Ljava/lang/Object;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/talabat/offering/data/remote/dtos/ActiveEventDto;", "equals", "other", "hashCode", "toString", "com_talabat_NewArchi_Offering_Offering"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ActiveEventDto {
    @SerializedName("eid")
    @Nullable
    private final Integer eventId;
    @SerializedName("emg")
    @Nullable
    private final Object eventMsg;
    @SerializedName("evt")
    @Nullable
    private final String eventType;
    @SerializedName("eva")
    @Nullable
    private final Integer eventValue;
    @SerializedName("isac")
    @Nullable
    private final Boolean isActive;

    public ActiveEventDto() {
        this((Integer) null, (Object) null, (Integer) null, (String) null, (Boolean) null, 31, (DefaultConstructorMarker) null);
    }

    public ActiveEventDto(@Nullable Integer num, @Nullable Object obj, @Nullable Integer num2, @Nullable String str, @Nullable Boolean bool) {
        this.eventId = num;
        this.eventMsg = obj;
        this.eventValue = num2;
        this.eventType = str;
        this.isActive = bool;
    }

    public static /* synthetic */ ActiveEventDto copy$default(ActiveEventDto activeEventDto, Integer num, Object obj, Integer num2, String str, Boolean bool, int i11, Object obj2) {
        if ((i11 & 1) != 0) {
            num = activeEventDto.eventId;
        }
        if ((i11 & 2) != 0) {
            obj = activeEventDto.eventMsg;
        }
        Object obj3 = obj;
        if ((i11 & 4) != 0) {
            num2 = activeEventDto.eventValue;
        }
        Integer num3 = num2;
        if ((i11 & 8) != 0) {
            str = activeEventDto.eventType;
        }
        String str2 = str;
        if ((i11 & 16) != 0) {
            bool = activeEventDto.isActive;
        }
        return activeEventDto.copy(num, obj3, num3, str2, bool);
    }

    @Nullable
    public final Integer component1() {
        return this.eventId;
    }

    @Nullable
    public final Object component2() {
        return this.eventMsg;
    }

    @Nullable
    public final Integer component3() {
        return this.eventValue;
    }

    @Nullable
    public final String component4() {
        return this.eventType;
    }

    @Nullable
    public final Boolean component5() {
        return this.isActive;
    }

    @NotNull
    public final ActiveEventDto copy(@Nullable Integer num, @Nullable Object obj, @Nullable Integer num2, @Nullable String str, @Nullable Boolean bool) {
        return new ActiveEventDto(num, obj, num2, str, bool);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActiveEventDto)) {
            return false;
        }
        ActiveEventDto activeEventDto = (ActiveEventDto) obj;
        return Intrinsics.areEqual((Object) this.eventId, (Object) activeEventDto.eventId) && Intrinsics.areEqual(this.eventMsg, activeEventDto.eventMsg) && Intrinsics.areEqual((Object) this.eventValue, (Object) activeEventDto.eventValue) && Intrinsics.areEqual((Object) this.eventType, (Object) activeEventDto.eventType) && Intrinsics.areEqual((Object) this.isActive, (Object) activeEventDto.isActive);
    }

    @Nullable
    public final Integer getEventId() {
        return this.eventId;
    }

    @Nullable
    public final Object getEventMsg() {
        return this.eventMsg;
    }

    @Nullable
    public final String getEventType() {
        return this.eventType;
    }

    @Nullable
    public final Integer getEventValue() {
        return this.eventValue;
    }

    public int hashCode() {
        Integer num = this.eventId;
        int i11 = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Object obj = this.eventMsg;
        int hashCode2 = (hashCode + (obj == null ? 0 : obj.hashCode())) * 31;
        Integer num2 = this.eventValue;
        int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str = this.eventType;
        int hashCode4 = (hashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        Boolean bool = this.isActive;
        if (bool != null) {
            i11 = bool.hashCode();
        }
        return hashCode4 + i11;
    }

    @Nullable
    public final Boolean isActive() {
        return this.isActive;
    }

    @NotNull
    public String toString() {
        Integer num = this.eventId;
        Object obj = this.eventMsg;
        Integer num2 = this.eventValue;
        String str = this.eventType;
        Boolean bool = this.isActive;
        return "ActiveEventDto(eventId=" + num + ", eventMsg=" + obj + ", eventValue=" + num2 + ", eventType=" + str + ", isActive=" + bool + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ActiveEventDto(java.lang.Integer r5, java.lang.Object r6, java.lang.Integer r7, java.lang.String r8, java.lang.Boolean r9, int r10, kotlin.jvm.internal.DefaultConstructorMarker r11) {
        /*
            r4 = this;
            r11 = r10 & 1
            r0 = 0
            if (r11 == 0) goto L_0x0007
            r11 = r0
            goto L_0x0008
        L_0x0007:
            r11 = r5
        L_0x0008:
            r5 = r10 & 2
            if (r5 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r6
        L_0x000f:
            r5 = r10 & 4
            if (r5 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r7
        L_0x0016:
            r5 = r10 & 8
            if (r5 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r8
        L_0x001d:
            r5 = r10 & 16
            if (r5 == 0) goto L_0x0023
            r10 = r0
            goto L_0x0024
        L_0x0023:
            r10 = r9
        L_0x0024:
            r5 = r4
            r6 = r11
            r7 = r1
            r8 = r2
            r9 = r3
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.offering.data.remote.dtos.ActiveEventDto.<init>(java.lang.Integer, java.lang.Object, java.lang.Integer, java.lang.String, java.lang.Boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
