package com.talabat.darkstores.data.partialFulfillment.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import com.talabat.observability.squads.nfv.ObservableAttributesNames;
import com.tekartik.sqflite.Constant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0003\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003JE\u0010\u0019\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u00032\b\b\u0003\u0010\u0007\u001a\u00020\u00032\b\b\u0003\u0010\b\u001a\u00020\tHÆ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\u0013\u0010\u001c\u001a\u00020\t2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\u001bHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\u0019\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006&"}, d2 = {"Lcom/talabat/darkstores/data/partialFulfillment/model/Control;", "Landroid/os/Parcelable;", "code", "", "description", "imageUrl", "name", "type", "value", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getCode", "()Ljava/lang/String;", "getDescription", "getImageUrl", "getName", "getType", "getValue", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Parcelize
public final class Control implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<Control> CREATOR = new Creator();
    @NotNull
    private final String code;
    @NotNull
    private final String description;
    @NotNull
    private final String imageUrl;
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f56194name;
    @NotNull
    private final String type;
    private final boolean value;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<Control> {
        @NotNull
        public final Control createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new Control(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0);
        }

        @NotNull
        public final Control[] newArray(int i11) {
            return new Control[i11];
        }
    }

    public Control() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, false, 63, (DefaultConstructorMarker) null);
    }

    public Control(@NotNull @Json(name = "code") String str, @NotNull @Json(name = "description") String str2, @NotNull @Json(name = "image_url") String str3, @NotNull @Json(name = "name") String str4, @NotNull @Json(name = "type") String str5, @Json(name = "value") boolean z11) {
        Intrinsics.checkNotNullParameter(str, Constant.PARAM_ERROR_CODE);
        Intrinsics.checkNotNullParameter(str2, "description");
        Intrinsics.checkNotNullParameter(str3, ObservableAttributesNames.IMAGE_URL_V2);
        Intrinsics.checkNotNullParameter(str4, "name");
        Intrinsics.checkNotNullParameter(str5, "type");
        this.code = str;
        this.description = str2;
        this.imageUrl = str3;
        this.f56194name = str4;
        this.type = str5;
        this.value = z11;
    }

    public static /* synthetic */ Control copy$default(Control control, String str, String str2, String str3, String str4, String str5, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = control.code;
        }
        if ((i11 & 2) != 0) {
            str2 = control.description;
        }
        String str6 = str2;
        if ((i11 & 4) != 0) {
            str3 = control.imageUrl;
        }
        String str7 = str3;
        if ((i11 & 8) != 0) {
            str4 = control.f56194name;
        }
        String str8 = str4;
        if ((i11 & 16) != 0) {
            str5 = control.type;
        }
        String str9 = str5;
        if ((i11 & 32) != 0) {
            z11 = control.value;
        }
        return control.copy(str, str6, str7, str8, str9, z11);
    }

    @NotNull
    public final String component1() {
        return this.code;
    }

    @NotNull
    public final String component2() {
        return this.description;
    }

    @NotNull
    public final String component3() {
        return this.imageUrl;
    }

    @NotNull
    public final String component4() {
        return this.f56194name;
    }

    @NotNull
    public final String component5() {
        return this.type;
    }

    public final boolean component6() {
        return this.value;
    }

    @NotNull
    public final Control copy(@NotNull @Json(name = "code") String str, @NotNull @Json(name = "description") String str2, @NotNull @Json(name = "image_url") String str3, @NotNull @Json(name = "name") String str4, @NotNull @Json(name = "type") String str5, @Json(name = "value") boolean z11) {
        Intrinsics.checkNotNullParameter(str, Constant.PARAM_ERROR_CODE);
        Intrinsics.checkNotNullParameter(str2, "description");
        Intrinsics.checkNotNullParameter(str3, ObservableAttributesNames.IMAGE_URL_V2);
        Intrinsics.checkNotNullParameter(str4, "name");
        Intrinsics.checkNotNullParameter(str5, "type");
        return new Control(str, str2, str3, str4, str5, z11);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Control)) {
            return false;
        }
        Control control = (Control) obj;
        return Intrinsics.areEqual((Object) this.code, (Object) control.code) && Intrinsics.areEqual((Object) this.description, (Object) control.description) && Intrinsics.areEqual((Object) this.imageUrl, (Object) control.imageUrl) && Intrinsics.areEqual((Object) this.f56194name, (Object) control.f56194name) && Intrinsics.areEqual((Object) this.type, (Object) control.type) && this.value == control.value;
    }

    @NotNull
    public final String getCode() {
        return this.code;
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final String getImageUrl() {
        return this.imageUrl;
    }

    @NotNull
    public final String getName() {
        return this.f56194name;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    public final boolean getValue() {
        return this.value;
    }

    public int hashCode() {
        int hashCode = ((((((((this.code.hashCode() * 31) + this.description.hashCode()) * 31) + this.imageUrl.hashCode()) * 31) + this.f56194name.hashCode()) * 31) + this.type.hashCode()) * 31;
        boolean z11 = this.value;
        if (z11) {
            z11 = true;
        }
        return hashCode + (z11 ? 1 : 0);
    }

    @NotNull
    public String toString() {
        String str = this.code;
        String str2 = this.description;
        String str3 = this.imageUrl;
        String str4 = this.f56194name;
        String str5 = this.type;
        boolean z11 = this.value;
        return "Control(code=" + str + ", description=" + str2 + ", imageUrl=" + str3 + ", name=" + str4 + ", type=" + str5 + ", value=" + z11 + ")";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i11) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.code);
        parcel.writeString(this.description);
        parcel.writeString(this.imageUrl);
        parcel.writeString(this.f56194name);
        parcel.writeString(this.type);
        parcel.writeInt(this.value ? 1 : 0);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Control(java.lang.String r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, boolean r10, int r11, kotlin.jvm.internal.DefaultConstructorMarker r12) {
        /*
            r4 = this;
            r12 = r11 & 1
            java.lang.String r0 = ""
            if (r12 == 0) goto L_0x0008
            r12 = r0
            goto L_0x0009
        L_0x0008:
            r12 = r5
        L_0x0009:
            r5 = r11 & 2
            if (r5 == 0) goto L_0x000f
            r1 = r0
            goto L_0x0010
        L_0x000f:
            r1 = r6
        L_0x0010:
            r5 = r11 & 4
            if (r5 == 0) goto L_0x0016
            r2 = r0
            goto L_0x0017
        L_0x0016:
            r2 = r7
        L_0x0017:
            r5 = r11 & 8
            if (r5 == 0) goto L_0x001d
            r3 = r0
            goto L_0x001e
        L_0x001d:
            r3 = r8
        L_0x001e:
            r5 = r11 & 16
            if (r5 == 0) goto L_0x0023
            goto L_0x0024
        L_0x0023:
            r0 = r9
        L_0x0024:
            r5 = r11 & 32
            if (r5 == 0) goto L_0x0029
            r10 = 0
        L_0x0029:
            r11 = r10
            r5 = r4
            r6 = r12
            r7 = r1
            r8 = r2
            r9 = r3
            r10 = r0
            r5.<init>(r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.darkstores.data.partialFulfillment.model.Control.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
