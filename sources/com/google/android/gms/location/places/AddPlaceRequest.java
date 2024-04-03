package com.google.android.gms.location.places;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.LatLng;
import com.huawei.hms.flutter.map.constants.Param;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@SafeParcelable.Class(creator = "AddPlaceRequestCreator")
@SafeParcelable.Reserved({1000})
@Deprecated
public class AddPlaceRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<AddPlaceRequest> CREATOR = new zzc();
    @SafeParcelable.Field(getter = "getLatLng", id = 2)
    private final LatLng latLng;
    @SafeParcelable.Field(getter = "getName", id = 1)

    /* renamed from: name  reason: collision with root package name */
    private final String f44505name;
    @SafeParcelable.Field(getter = "getAddress", id = 3)
    private final String zzf;
    @SafeParcelable.Field(getter = "getPlaceTypes", id = 4)
    private final List<Integer> zzg;
    @SafeParcelable.Field(getter = "getPhoneNumber", id = 5)
    private final String zzh;
    @SafeParcelable.Field(getter = "getWebsiteUri", id = 6)
    private final Uri zzi;

    @SafeParcelable.Constructor
    public AddPlaceRequest(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) LatLng latLng2, @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) List<Integer> list, @SafeParcelable.Param(id = 5) String str3, @SafeParcelable.Param(id = 6) Uri uri) {
        this.f44505name = Preconditions.checkNotEmpty(str);
        this.latLng = (LatLng) Preconditions.checkNotNull(latLng2);
        this.zzf = Preconditions.checkNotEmpty(str2);
        ArrayList arrayList = new ArrayList((Collection) Preconditions.checkNotNull(list));
        this.zzg = arrayList;
        boolean z11 = true;
        Preconditions.checkArgument(!arrayList.isEmpty(), "At least one place type should be provided.");
        if (TextUtils.isEmpty(str3) && uri == null) {
            z11 = false;
        }
        Preconditions.checkArgument(z11, "One of phone number or URI should be provided.");
        this.zzh = str3;
        this.zzi = uri;
    }

    public String getAddress() {
        return this.zzf;
    }

    public LatLng getLatLng() {
        return this.latLng;
    }

    public String getName() {
        return this.f44505name;
    }

    @Nullable
    public String getPhoneNumber() {
        return this.zzh;
    }

    public List<Integer> getPlaceTypes() {
        return this.zzg;
    }

    @Nullable
    public Uri getWebsiteUri() {
        return this.zzi;
    }

    public String toString() {
        return Objects.toStringHelper(this).add("name", this.f44505name).add(Param.LAT_LNG, this.latLng).add("address", this.zzf).add("placeTypes", this.zzg).add("phoneNumer", this.zzh).add("websiteUri", this.zzi).toString();
    }

    public void writeToParcel(Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getName(), false);
        SafeParcelWriter.writeParcelable(parcel, 2, getLatLng(), i11, false);
        SafeParcelWriter.writeString(parcel, 3, getAddress(), false);
        SafeParcelWriter.writeIntegerList(parcel, 4, getPlaceTypes(), false);
        SafeParcelWriter.writeString(parcel, 5, getPhoneNumber(), false);
        SafeParcelWriter.writeParcelable(parcel, 6, getWebsiteUri(), i11, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public AddPlaceRequest(String str, LatLng latLng2, String str2, List<Integer> list, String str3) {
        this(str, latLng2, str2, list, Preconditions.checkNotEmpty(str3), (Uri) null);
    }

    public AddPlaceRequest(String str, LatLng latLng2, String str2, List<Integer> list, Uri uri) {
        this(str, latLng2, str2, list, (String) null, (Uri) Preconditions.checkNotNull(uri));
    }
}
