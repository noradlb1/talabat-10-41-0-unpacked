package com.talabat.splash.domain.entity;

import com.google.gson.annotations.SerializedName;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u000eJJ\u0010\u0017\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0002X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0002X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0002X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0002X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/talabat/splash/domain/entity/NewAppVersionEntity;", "", "_msg", "", "_message", "_ver", "_version", "shouldForceUpdate", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "message", "getMessage", "()Ljava/lang/String;", "getShouldForceUpdate", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "version", "getVersion", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/talabat/splash/domain/entity/NewAppVersionEntity;", "equals", "other", "hashCode", "", "toString", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NewAppVersionEntity {
    @SerializedName("message")
    @Nullable
    private final String _message;
    @SerializedName("msg")
    @Nullable
    private final String _msg;
    @SerializedName("ver")
    @Nullable
    private final String _ver;
    @SerializedName("version")
    @Nullable
    private final String _version;
    @SerializedName("_gson_ignore_message")
    @Nullable
    private final String message;
    @SerializedName("forc")
    @Nullable
    private final Boolean shouldForceUpdate;
    @SerializedName("_gson_ignore_version")
    @Nullable
    private final String version;

    public NewAppVersionEntity() {
        this((String) null, (String) null, (String) null, (String) null, (Boolean) null, 31, (DefaultConstructorMarker) null);
    }

    public NewAppVersionEntity(@Nullable @Json(name = "msg") String str, @Nullable @Json(name = "message") String str2, @Nullable @Json(name = "ver") String str3, @Nullable @Json(name = "version") String str4, @Nullable @Json(name = "forc") Boolean bool) {
        this._msg = str;
        this._message = str2;
        this._ver = str3;
        this._version = str4;
        this.shouldForceUpdate = bool;
        this.message = str == null ? str2 : str;
        this.version = str3 == null ? str4 : str3;
    }

    private final String component1() {
        return this._msg;
    }

    private final String component2() {
        return this._message;
    }

    private final String component3() {
        return this._ver;
    }

    private final String component4() {
        return this._version;
    }

    public static /* synthetic */ NewAppVersionEntity copy$default(NewAppVersionEntity newAppVersionEntity, String str, String str2, String str3, String str4, Boolean bool, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = newAppVersionEntity._msg;
        }
        if ((i11 & 2) != 0) {
            str2 = newAppVersionEntity._message;
        }
        String str5 = str2;
        if ((i11 & 4) != 0) {
            str3 = newAppVersionEntity._ver;
        }
        String str6 = str3;
        if ((i11 & 8) != 0) {
            str4 = newAppVersionEntity._version;
        }
        String str7 = str4;
        if ((i11 & 16) != 0) {
            bool = newAppVersionEntity.shouldForceUpdate;
        }
        return newAppVersionEntity.copy(str, str5, str6, str7, bool);
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
        return Intrinsics.areEqual((Object) this._msg, (Object) newAppVersionEntity._msg) && Intrinsics.areEqual((Object) this._message, (Object) newAppVersionEntity._message) && Intrinsics.areEqual((Object) this._ver, (Object) newAppVersionEntity._ver) && Intrinsics.areEqual((Object) this._version, (Object) newAppVersionEntity._version) && Intrinsics.areEqual((Object) this.shouldForceUpdate, (Object) newAppVersionEntity.shouldForceUpdate);
    }

    @Nullable
    public final String getMessage() {
        return this.message;
    }

    @Nullable
    public final Boolean getShouldForceUpdate() {
        return this.shouldForceUpdate;
    }

    @Nullable
    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        String str = this._msg;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this._message;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this._ver;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this._version;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Boolean bool = this.shouldForceUpdate;
        if (bool != null) {
            i11 = bool.hashCode();
        }
        return hashCode4 + i11;
    }

    @NotNull
    public String toString() {
        String str = this._msg;
        String str2 = this._message;
        String str3 = this._ver;
        String str4 = this._version;
        Boolean bool = this.shouldForceUpdate;
        return "NewAppVersionEntity(_msg=" + str + ", _message=" + str2 + ", _ver=" + str3 + ", _version=" + str4 + ", shouldForceUpdate=" + bool + ")";
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
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.splash.domain.entity.NewAppVersionEntity.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
