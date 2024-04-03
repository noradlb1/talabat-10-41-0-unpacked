package com.google.android.libraries.places.api.model;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.libraries.places.api.model.Place;
import java.util.List;

final class zzq extends Place.Builder {
    private String zza;
    private AddressComponents zzb;
    private Place.BusinessStatus zzc;
    private List<String> zzd;
    private String zze;
    private LatLng zzf;
    private String zzg;
    private OpeningHours zzh;
    private String zzi;
    private List<PhotoMetadata> zzj;
    private PlusCode zzk;
    private Integer zzl;
    private Double zzm;
    private List<Place.Type> zzn;
    private Integer zzo;
    private Integer zzp;
    private LatLngBounds zzq;
    private Uri zzr;
    private String zzs;
    private Integer zzt;

    @Nullable
    public final String getAddress() {
        return this.zza;
    }

    @Nullable
    public final AddressComponents getAddressComponents() {
        return this.zzb;
    }

    @Nullable
    public final List<String> getAttributions() {
        return this.zzd;
    }

    @Nullable
    public final Place.BusinessStatus getBusinessStatus() {
        return this.zzc;
    }

    @Nullable
    public final Integer getIconBackgroundColor() {
        return this.zzt;
    }

    @Nullable
    public final String getIconUrl() {
        return this.zzs;
    }

    @Nullable
    public final String getId() {
        return this.zze;
    }

    @Nullable
    public final LatLng getLatLng() {
        return this.zzf;
    }

    @Nullable
    public final String getName() {
        return this.zzg;
    }

    @Nullable
    public final OpeningHours getOpeningHours() {
        return this.zzh;
    }

    @Nullable
    public final String getPhoneNumber() {
        return this.zzi;
    }

    @Nullable
    public final List<PhotoMetadata> getPhotoMetadatas() {
        return this.zzj;
    }

    @Nullable
    public final PlusCode getPlusCode() {
        return this.zzk;
    }

    @Nullable
    public final Integer getPriceLevel() {
        return this.zzl;
    }

    @Nullable
    public final Double getRating() {
        return this.zzm;
    }

    @Nullable
    public final List<Place.Type> getTypes() {
        return this.zzn;
    }

    @Nullable
    public final Integer getUserRatingsTotal() {
        return this.zzo;
    }

    @Nullable
    public final Integer getUtcOffsetMinutes() {
        return this.zzp;
    }

    @Nullable
    public final LatLngBounds getViewport() {
        return this.zzq;
    }

    @Nullable
    public final Uri getWebsiteUri() {
        return this.zzr;
    }

    public final Place.Builder setAddress(@Nullable String str) {
        this.zza = str;
        return this;
    }

    public final Place.Builder setAddressComponents(@Nullable AddressComponents addressComponents) {
        this.zzb = addressComponents;
        return this;
    }

    public final Place.Builder setAttributions(@Nullable List<String> list) {
        this.zzd = list;
        return this;
    }

    public final Place.Builder setBusinessStatus(@Nullable Place.BusinessStatus businessStatus) {
        this.zzc = businessStatus;
        return this;
    }

    public final Place.Builder setIconBackgroundColor(@Nullable Integer num) {
        this.zzt = num;
        return this;
    }

    public final Place.Builder setIconUrl(@Nullable String str) {
        this.zzs = str;
        return this;
    }

    public final Place.Builder setId(@Nullable String str) {
        this.zze = str;
        return this;
    }

    public final Place.Builder setLatLng(@Nullable LatLng latLng) {
        this.zzf = latLng;
        return this;
    }

    public final Place.Builder setName(@Nullable String str) {
        this.zzg = str;
        return this;
    }

    public final Place.Builder setOpeningHours(@Nullable OpeningHours openingHours) {
        this.zzh = openingHours;
        return this;
    }

    public final Place.Builder setPhoneNumber(@Nullable String str) {
        this.zzi = str;
        return this;
    }

    public final Place.Builder setPhotoMetadatas(@Nullable List<PhotoMetadata> list) {
        this.zzj = list;
        return this;
    }

    public final Place.Builder setPlusCode(@Nullable PlusCode plusCode) {
        this.zzk = plusCode;
        return this;
    }

    public final Place.Builder setPriceLevel(@Nullable Integer num) {
        this.zzl = num;
        return this;
    }

    public final Place.Builder setRating(@Nullable Double d11) {
        this.zzm = d11;
        return this;
    }

    public final Place.Builder setTypes(@Nullable List<Place.Type> list) {
        this.zzn = list;
        return this;
    }

    public final Place.Builder setUserRatingsTotal(@Nullable Integer num) {
        this.zzo = num;
        return this;
    }

    public final Place.Builder setUtcOffsetMinutes(@Nullable Integer num) {
        this.zzp = num;
        return this;
    }

    public final Place.Builder setViewport(@Nullable LatLngBounds latLngBounds) {
        this.zzq = latLngBounds;
        return this;
    }

    public final Place.Builder setWebsiteUri(@Nullable Uri uri) {
        this.zzr = uri;
        return this;
    }

    public final Place zza() {
        return new zzar(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzm, this.zzn, this.zzo, this.zzp, this.zzq, this.zzr, this.zzs, this.zzt);
    }
}
