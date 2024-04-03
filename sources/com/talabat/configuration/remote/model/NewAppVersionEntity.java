package com.talabat.configuration.remote.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0011JJ\u0010\u0019\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006 "}, d2 = {"Lcom/talabat/configuration/remote/model/NewAppVersionEntity;", "", "msg", "", "message", "ver", "version", "shouldForceUpdate", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getMessage", "getGetMessage", "()Ljava/lang/String;", "getVersion", "getGetVersion", "getMsg", "getShouldForceUpdate", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getVer", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/talabat/configuration/remote/model/NewAppVersionEntity;", "equals", "other", "hashCode", "", "toString", "com_talabat_core_configuration_remote_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NewAppVersionEntity {
    @Nullable
    private final String getMessage;
    @Nullable
    private final String getVersion;
    @Nullable
    private final String message;
    @Nullable
    private final String msg;
    @Nullable
    private final Boolean shouldForceUpdate;
    @Nullable
    private final String ver;
    @Nullable
    private final String version;

    public NewAppVersionEntity() {
        this((String) null, (String) null, (String) null, (String) null, (Boolean) null, 31, (DefaultConstructorMarker) null);
    }

    public NewAppVersionEntity(@Nullable @Json(name = "msg") String str, @Nullable @Json(name = "message") String str2, @Nullable @Json(name = "ver") String str3, @Nullable @Json(name = "version") String str4, @Nullable @Json(name = "forc") Boolean bool) {
        this.msg = str;
        this.message = str2;
        this.ver = str3;
        this.version = str4;
        this.shouldForceUpdate = bool;
        this.getMessage = str == null ? str2 : str;
        this.getVersion = str3 == null ? str4 : str3;
    }

    public static /* synthetic */ NewAppVersionEntity copy$default(NewAppVersionEntity newAppVersionEntity, String str, String str2, String str3, String str4, Boolean bool, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = newAppVersionEntity.msg;
        }
        if ((i11 & 2) != 0) {
            str2 = newAppVersionEntity.message;
        }
        String str5 = str2;
        if ((i11 & 4) != 0) {
            str3 = newAppVersionEntity.ver;
        }
        String str6 = str3;
        if ((i11 & 8) != 0) {
            str4 = newAppVersionEntity.version;
        }
        String str7 = str4;
        if ((i11 & 16) != 0) {
            bool = newAppVersionEntity.shouldForceUpdate;
        }
        return newAppVersionEntity.copy(str, str5, str6, str7, bool);
    }

    @Nullable
    public final String component1() {
        return this.msg;
    }

    @Nullable
    public final String component2() {
        return this.message;
    }

    @Nullable
    public final String component3() {
        return this.ver;
    }

    @Nullable
    public final String component4() {
        return this.version;
    }

    @Nullable
    public final Boolean component5() {
        return this.shouldForceUpdate;
    }

    @NotNull
    public final NewAppVersionEntity copy(@Nullable @Json(name = "msg") String str, @Nullable @Json(name = "message") String str2, @Nullable @Json(name = "ver") String str3, @Nullable @Json(name = "version") String str4, @Nullable @Json(name = "forc") Boolean bool) {
        return new NewAppVersionEntity(str, str2, str3, str4, bool);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NewAppVersionEntity)) {
            return false;
        }
        NewAppVersionEntity newAppVersionEntity = (NewAppVersionEntity) obj;
        return Intrinsics.areEqual((Object) this.msg, (Object) newAppVersionEntity.msg) && Intrinsics.areEqual((Object) this.message, (Object) newAppVersionEntity.message) && Intrinsics.areEqual((Object) this.ver, (Object) newAppVersionEntity.ver) && Intrinsics.areEqual((Object) this.version, (Object) newAppVersionEntity.version) && Intrinsics.areEqual((Object) this.shouldForceUpdate, (Object) newAppVersionEntity.shouldForceUpdate);
    }

    @Nullable
    public final String getGetMessage() {
        return this.getMessage;
    }

    @Nullable
    public final String getGetVersion() {
        return this.getVersion;
    }

    @Nullable
    public final String getMessage() {
        return this.message;
    }

    @Nullable
    public final String getMsg() {
        return this.msg;
    }

    @Nullable
    public final Boolean getShouldForceUpdate() {
        return this.shouldForceUpdate;
    }

    @Nullable
    public final String getVer() {
        return this.ver;
    }

    @Nullable
    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        String str = this.msg;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.message;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.ver;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.version;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Boolean bool = this.shouldForceUpdate;
        if (bool != null) {
            i11 = bool.hashCode();
        }
        return hashCode4 + i11;
    }

    @NotNull
    public String toString() {
        String str = this.msg;
        String str2 = this.message;
        String str3 = this.ver;
        String str4 = this.version;
        Boolean bool = this.shouldForceUpdate;
        return "NewAppVersionEntity(msg=" + str + ", message=" + str2 + ", ver=" + str3 + ", version=" + str4 + ", shouldForceUpdate=" + bool + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ NewAppVersionEntity(java.lang.String r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.Boolean r9, int r10, kotlin.jvm.internal.DefaultConstructorMarker r11) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.configuration.remote.model.NewAppVersionEntity.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
