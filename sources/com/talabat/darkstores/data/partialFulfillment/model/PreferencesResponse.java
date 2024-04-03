package com.talabat.darkstores.data.partialFulfillment.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import com.talabat.observability.squads.nfv.ObservableAttributesNames;
import com.tekartik.sqflite.Constant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001Be\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0003\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0003\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0003\u0010\b\u001a\u00020\u0003\u0012\b\b\u0003\u0010\t\u001a\u00020\u0003\u0012\b\b\u0003\u0010\n\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0003\u0010\f\u001a\u00020\u0003\u0012\b\b\u0003\u0010\r\u001a\u00020\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003Ji\u0010#\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\u000e\b\u0003\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0003\u0010\u0007\u001a\u00020\u00032\b\b\u0003\u0010\b\u001a\u00020\u00032\b\b\u0003\u0010\t\u001a\u00020\u00032\b\b\u0003\u0010\n\u001a\u00020\u00032\b\b\u0003\u0010\u000b\u001a\u00020\u00032\b\b\u0003\u0010\f\u001a\u00020\u00032\b\b\u0003\u0010\r\u001a\u00020\u0003HÆ\u0001J\t\u0010$\u001a\u00020%HÖ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020%HÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001J\u0019\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020%HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010¨\u00061"}, d2 = {"Lcom/talabat/darkstores/data/partialFulfillment/model/PreferencesResponse;", "Landroid/os/Parcelable;", "code", "", "controls", "", "Lcom/talabat/darkstores/data/partialFulfillment/model/Control;", "defaultValue", "description", "imageUrl", "name", "tag", "type", "value", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "getControls", "()Ljava/util/List;", "getDefaultValue", "getDescription", "getImageUrl", "getName", "getTag", "getType", "getValue", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Parcelize
public final class PreferencesResponse implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<PreferencesResponse> CREATOR = new Creator();
    @NotNull
    private final String code;
    @NotNull
    private final List<Control> controls;
    @NotNull
    private final String defaultValue;
    @NotNull
    private final String description;
    @NotNull
    private final String imageUrl;
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f56195name;
    @NotNull
    private final String tag;
    @NotNull
    private final String type;
    @NotNull
    private final String value;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<PreferencesResponse> {
        @NotNull
        public final PreferencesResponse createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String readString = parcel.readString();
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i11 = 0; i11 != readInt; i11++) {
                arrayList.add(Control.CREATOR.createFromParcel(parcel));
            }
            return new PreferencesResponse(readString, arrayList, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @NotNull
        public final PreferencesResponse[] newArray(int i11) {
            return new PreferencesResponse[i11];
        }
    }

    public PreferencesResponse() {
        this((String) null, (List) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 511, (DefaultConstructorMarker) null);
    }

    public PreferencesResponse(@NotNull @Json(name = "code") String str, @NotNull @Json(name = "controls") List<Control> list, @NotNull @Json(name = "defaultValue") String str2, @NotNull @Json(name = "description") String str3, @NotNull @Json(name = "imageUrl") String str4, @NotNull @Json(name = "name") String str5, @NotNull @Json(name = "tag") String str6, @NotNull @Json(name = "type") String str7, @NotNull @Json(name = "value") String str8) {
        Intrinsics.checkNotNullParameter(str, Constant.PARAM_ERROR_CODE);
        Intrinsics.checkNotNullParameter(list, "controls");
        Intrinsics.checkNotNullParameter(str2, "defaultValue");
        Intrinsics.checkNotNullParameter(str3, "description");
        Intrinsics.checkNotNullParameter(str4, ObservableAttributesNames.IMAGE_URL_V2);
        Intrinsics.checkNotNullParameter(str5, "name");
        Intrinsics.checkNotNullParameter(str6, "tag");
        Intrinsics.checkNotNullParameter(str7, "type");
        Intrinsics.checkNotNullParameter(str8, "value");
        this.code = str;
        this.controls = list;
        this.defaultValue = str2;
        this.description = str3;
        this.imageUrl = str4;
        this.f56195name = str5;
        this.tag = str6;
        this.type = str7;
        this.value = str8;
    }

    public static /* synthetic */ PreferencesResponse copy$default(PreferencesResponse preferencesResponse, String str, List list, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i11, Object obj) {
        PreferencesResponse preferencesResponse2 = preferencesResponse;
        int i12 = i11;
        return preferencesResponse.copy((i12 & 1) != 0 ? preferencesResponse2.code : str, (i12 & 2) != 0 ? preferencesResponse2.controls : list, (i12 & 4) != 0 ? preferencesResponse2.defaultValue : str2, (i12 & 8) != 0 ? preferencesResponse2.description : str3, (i12 & 16) != 0 ? preferencesResponse2.imageUrl : str4, (i12 & 32) != 0 ? preferencesResponse2.f56195name : str5, (i12 & 64) != 0 ? preferencesResponse2.tag : str6, (i12 & 128) != 0 ? preferencesResponse2.type : str7, (i12 & 256) != 0 ? preferencesResponse2.value : str8);
    }

    @NotNull
    public final String component1() {
        return this.code;
    }

    @NotNull
    public final List<Control> component2() {
        return this.controls;
    }

    @NotNull
    public final String component3() {
        return this.defaultValue;
    }

    @NotNull
    public final String component4() {
        return this.description;
    }

    @NotNull
    public final String component5() {
        return this.imageUrl;
    }

    @NotNull
    public final String component6() {
        return this.f56195name;
    }

    @NotNull
    public final String component7() {
        return this.tag;
    }

    @NotNull
    public final String component8() {
        return this.type;
    }

    @NotNull
    public final String component9() {
        return this.value;
    }

    @NotNull
    public final PreferencesResponse copy(@NotNull @Json(name = "code") String str, @NotNull @Json(name = "controls") List<Control> list, @NotNull @Json(name = "defaultValue") String str2, @NotNull @Json(name = "description") String str3, @NotNull @Json(name = "imageUrl") String str4, @NotNull @Json(name = "name") String str5, @NotNull @Json(name = "tag") String str6, @NotNull @Json(name = "type") String str7, @NotNull @Json(name = "value") String str8) {
        Intrinsics.checkNotNullParameter(str, Constant.PARAM_ERROR_CODE);
        Intrinsics.checkNotNullParameter(list, "controls");
        Intrinsics.checkNotNullParameter(str2, "defaultValue");
        Intrinsics.checkNotNullParameter(str3, "description");
        String str9 = str4;
        Intrinsics.checkNotNullParameter(str9, ObservableAttributesNames.IMAGE_URL_V2);
        String str10 = str5;
        Intrinsics.checkNotNullParameter(str10, "name");
        String str11 = str6;
        Intrinsics.checkNotNullParameter(str11, "tag");
        String str12 = str7;
        Intrinsics.checkNotNullParameter(str12, "type");
        String str13 = str8;
        Intrinsics.checkNotNullParameter(str13, "value");
        return new PreferencesResponse(str, list, str2, str3, str9, str10, str11, str12, str13);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PreferencesResponse)) {
            return false;
        }
        PreferencesResponse preferencesResponse = (PreferencesResponse) obj;
        return Intrinsics.areEqual((Object) this.code, (Object) preferencesResponse.code) && Intrinsics.areEqual((Object) this.controls, (Object) preferencesResponse.controls) && Intrinsics.areEqual((Object) this.defaultValue, (Object) preferencesResponse.defaultValue) && Intrinsics.areEqual((Object) this.description, (Object) preferencesResponse.description) && Intrinsics.areEqual((Object) this.imageUrl, (Object) preferencesResponse.imageUrl) && Intrinsics.areEqual((Object) this.f56195name, (Object) preferencesResponse.f56195name) && Intrinsics.areEqual((Object) this.tag, (Object) preferencesResponse.tag) && Intrinsics.areEqual((Object) this.type, (Object) preferencesResponse.type) && Intrinsics.areEqual((Object) this.value, (Object) preferencesResponse.value);
    }

    @NotNull
    public final String getCode() {
        return this.code;
    }

    @NotNull
    public final List<Control> getControls() {
        return this.controls;
    }

    @NotNull
    public final String getDefaultValue() {
        return this.defaultValue;
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
        return this.f56195name;
    }

    @NotNull
    public final String getTag() {
        return this.tag;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }

    public int hashCode() {
        return (((((((((((((((this.code.hashCode() * 31) + this.controls.hashCode()) * 31) + this.defaultValue.hashCode()) * 31) + this.description.hashCode()) * 31) + this.imageUrl.hashCode()) * 31) + this.f56195name.hashCode()) * 31) + this.tag.hashCode()) * 31) + this.type.hashCode()) * 31) + this.value.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.code;
        List<Control> list = this.controls;
        String str2 = this.defaultValue;
        String str3 = this.description;
        String str4 = this.imageUrl;
        String str5 = this.f56195name;
        String str6 = this.tag;
        String str7 = this.type;
        String str8 = this.value;
        return "PreferencesResponse(code=" + str + ", controls=" + list + ", defaultValue=" + str2 + ", description=" + str3 + ", imageUrl=" + str4 + ", name=" + str5 + ", tag=" + str6 + ", type=" + str7 + ", value=" + str8 + ")";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i11) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.code);
        List<Control> list = this.controls;
        parcel.writeInt(list.size());
        for (Control writeToParcel : list) {
            writeToParcel.writeToParcel(parcel, i11);
        }
        parcel.writeString(this.defaultValue);
        parcel.writeString(this.description);
        parcel.writeString(this.imageUrl);
        parcel.writeString(this.f56195name);
        parcel.writeString(this.tag);
        parcel.writeString(this.type);
        parcel.writeString(this.value);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PreferencesResponse(java.lang.String r11, java.util.List r12, java.lang.String r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, int r20, kotlin.jvm.internal.DefaultConstructorMarker r21) {
        /*
            r10 = this;
            r0 = r20
            r1 = r0 & 1
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x000a
            r1 = r2
            goto L_0x000b
        L_0x000a:
            r1 = r11
        L_0x000b:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0014
            java.util.List r3 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            goto L_0x0015
        L_0x0014:
            r3 = r12
        L_0x0015:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x001b
            r4 = r2
            goto L_0x001c
        L_0x001b:
            r4 = r13
        L_0x001c:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0022
            r5 = r2
            goto L_0x0023
        L_0x0022:
            r5 = r14
        L_0x0023:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0029
            r6 = r2
            goto L_0x002a
        L_0x0029:
            r6 = r15
        L_0x002a:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0030
            r7 = r2
            goto L_0x0032
        L_0x0030:
            r7 = r16
        L_0x0032:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0038
            r8 = r2
            goto L_0x003a
        L_0x0038:
            r8 = r17
        L_0x003a:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0040
            r9 = r2
            goto L_0x0042
        L_0x0040:
            r9 = r18
        L_0x0042:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0047
            goto L_0x0049
        L_0x0047:
            r2 = r19
        L_0x0049:
            r11 = r10
            r12 = r1
            r13 = r3
            r14 = r4
            r15 = r5
            r16 = r6
            r17 = r7
            r18 = r8
            r19 = r9
            r20 = r2
            r11.<init>(r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.darkstores.data.partialFulfillment.model.PreferencesResponse.<init>(java.lang.String, java.util.List, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
