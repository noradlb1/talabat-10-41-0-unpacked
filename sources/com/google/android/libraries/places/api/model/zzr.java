package com.google.android.libraries.places.api.model;

import android.net.Uri;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.libraries.places.api.model.Place;
import java.util.List;

abstract class zzr extends Place {
    private final String zza;
    private final AddressComponents zzb;
    private final Place.BusinessStatus zzc;
    private final List<String> zzd;
    private final String zze;
    private final LatLng zzf;
    private final String zzg;
    private final OpeningHours zzh;
    private final String zzi;
    private final List<PhotoMetadata> zzj;
    private final PlusCode zzk;
    private final Integer zzl;
    private final Double zzm;
    private final List<Place.Type> zzn;
    private final Integer zzo;
    private final Integer zzp;
    private final LatLngBounds zzq;
    private final Uri zzr;
    private final String zzs;
    private final Integer zzt;

    public zzr(@Nullable String str, @Nullable AddressComponents addressComponents, @Nullable Place.BusinessStatus businessStatus, @Nullable List<String> list, @Nullable String str2, @Nullable LatLng latLng, @Nullable String str3, @Nullable OpeningHours openingHours, @Nullable String str4, @Nullable List<PhotoMetadata> list2, @Nullable PlusCode plusCode, @Nullable Integer num, @Nullable Double d11, @Nullable List<Place.Type> list3, @Nullable Integer num2, @Nullable Integer num3, @Nullable LatLngBounds latLngBounds, @Nullable Uri uri, @Nullable String str5, @Nullable Integer num4) {
        this.zza = str;
        this.zzb = addressComponents;
        this.zzc = businessStatus;
        this.zzd = list;
        this.zze = str2;
        this.zzf = latLng;
        this.zzg = str3;
        this.zzh = openingHours;
        this.zzi = str4;
        this.zzj = list2;
        this.zzk = plusCode;
        this.zzl = num;
        this.zzm = d11;
        this.zzn = list3;
        this.zzo = num2;
        this.zzp = num3;
        this.zzq = latLngBounds;
        this.zzr = uri;
        this.zzs = str5;
        this.zzt = num4;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Place) {
            Place place = (Place) obj;
            String str = this.zza;
            if (str != null ? str.equals(place.getAddress()) : place.getAddress() == null) {
                AddressComponents addressComponents = this.zzb;
                if (addressComponents != null ? addressComponents.equals(place.getAddressComponents()) : place.getAddressComponents() == null) {
                    Place.BusinessStatus businessStatus = this.zzc;
                    if (businessStatus != null ? businessStatus.equals(place.getBusinessStatus()) : place.getBusinessStatus() == null) {
                        List<String> list = this.zzd;
                        if (list != null ? list.equals(place.getAttributions()) : place.getAttributions() == null) {
                            String str2 = this.zze;
                            if (str2 != null ? str2.equals(place.getId()) : place.getId() == null) {
                                LatLng latLng = this.zzf;
                                if (latLng != null ? latLng.equals(place.getLatLng()) : place.getLatLng() == null) {
                                    String str3 = this.zzg;
                                    if (str3 != null ? str3.equals(place.getName()) : place.getName() == null) {
                                        OpeningHours openingHours = this.zzh;
                                        if (openingHours != null ? openingHours.equals(place.getOpeningHours()) : place.getOpeningHours() == null) {
                                            String str4 = this.zzi;
                                            if (str4 != null ? str4.equals(place.getPhoneNumber()) : place.getPhoneNumber() == null) {
                                                List<PhotoMetadata> list2 = this.zzj;
                                                if (list2 != null ? list2.equals(place.getPhotoMetadatas()) : place.getPhotoMetadatas() == null) {
                                                    PlusCode plusCode = this.zzk;
                                                    if (plusCode != null ? plusCode.equals(place.getPlusCode()) : place.getPlusCode() == null) {
                                                        Integer num = this.zzl;
                                                        if (num != null ? num.equals(place.getPriceLevel()) : place.getPriceLevel() == null) {
                                                            Double d11 = this.zzm;
                                                            if (d11 != null ? d11.equals(place.getRating()) : place.getRating() == null) {
                                                                List<Place.Type> list3 = this.zzn;
                                                                if (list3 != null ? list3.equals(place.getTypes()) : place.getTypes() == null) {
                                                                    Integer num2 = this.zzo;
                                                                    if (num2 != null ? num2.equals(place.getUserRatingsTotal()) : place.getUserRatingsTotal() == null) {
                                                                        Integer num3 = this.zzp;
                                                                        if (num3 != null ? num3.equals(place.getUtcOffsetMinutes()) : place.getUtcOffsetMinutes() == null) {
                                                                            LatLngBounds latLngBounds = this.zzq;
                                                                            if (latLngBounds != null ? latLngBounds.equals(place.getViewport()) : place.getViewport() == null) {
                                                                                Uri uri = this.zzr;
                                                                                if (uri != null ? uri.equals(place.getWebsiteUri()) : place.getWebsiteUri() == null) {
                                                                                    String str5 = this.zzs;
                                                                                    if (str5 != null ? str5.equals(place.getIconUrl()) : place.getIconUrl() == null) {
                                                                                        Integer num4 = this.zzt;
                                                                                        if (num4 != null ? num4.equals(place.getIconBackgroundColor()) : place.getIconBackgroundColor() == null) {
                                                                                            return true;
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

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

    @ColorInt
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

    @IntRange(from = 0, to = 4)
    @Nullable
    public final Integer getPriceLevel() {
        return this.zzl;
    }

    @FloatRange(from = 1.0d, to = 5.0d)
    @Nullable
    public final Double getRating() {
        return this.zzm;
    }

    @Nullable
    public final List<Place.Type> getTypes() {
        return this.zzn;
    }

    @IntRange(from = 0)
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

    public final int hashCode() {
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        int i29;
        int i31;
        String str = this.zza;
        int i32 = 0;
        if (str == null) {
            i11 = 0;
        } else {
            i11 = str.hashCode();
        }
        int i33 = (i11 ^ 1000003) * 1000003;
        AddressComponents addressComponents = this.zzb;
        if (addressComponents == null) {
            i12 = 0;
        } else {
            i12 = addressComponents.hashCode();
        }
        int i34 = (i33 ^ i12) * 1000003;
        Place.BusinessStatus businessStatus = this.zzc;
        if (businessStatus == null) {
            i13 = 0;
        } else {
            i13 = businessStatus.hashCode();
        }
        int i35 = (i34 ^ i13) * 1000003;
        List<String> list = this.zzd;
        if (list == null) {
            i14 = 0;
        } else {
            i14 = list.hashCode();
        }
        int i36 = (i35 ^ i14) * 1000003;
        String str2 = this.zze;
        if (str2 == null) {
            i15 = 0;
        } else {
            i15 = str2.hashCode();
        }
        int i37 = (i36 ^ i15) * 1000003;
        LatLng latLng = this.zzf;
        if (latLng == null) {
            i16 = 0;
        } else {
            i16 = latLng.hashCode();
        }
        int i38 = (i37 ^ i16) * 1000003;
        String str3 = this.zzg;
        if (str3 == null) {
            i17 = 0;
        } else {
            i17 = str3.hashCode();
        }
        int i39 = (i38 ^ i17) * 1000003;
        OpeningHours openingHours = this.zzh;
        if (openingHours == null) {
            i18 = 0;
        } else {
            i18 = openingHours.hashCode();
        }
        int i41 = (i39 ^ i18) * 1000003;
        String str4 = this.zzi;
        if (str4 == null) {
            i19 = 0;
        } else {
            i19 = str4.hashCode();
        }
        int i42 = (i41 ^ i19) * 1000003;
        List<PhotoMetadata> list2 = this.zzj;
        if (list2 == null) {
            i21 = 0;
        } else {
            i21 = list2.hashCode();
        }
        int i43 = (i42 ^ i21) * 1000003;
        PlusCode plusCode = this.zzk;
        if (plusCode == null) {
            i22 = 0;
        } else {
            i22 = plusCode.hashCode();
        }
        int i44 = (i43 ^ i22) * 1000003;
        Integer num = this.zzl;
        if (num == null) {
            i23 = 0;
        } else {
            i23 = num.hashCode();
        }
        int i45 = (i44 ^ i23) * 1000003;
        Double d11 = this.zzm;
        if (d11 == null) {
            i24 = 0;
        } else {
            i24 = d11.hashCode();
        }
        int i46 = (i45 ^ i24) * 1000003;
        List<Place.Type> list3 = this.zzn;
        if (list3 == null) {
            i25 = 0;
        } else {
            i25 = list3.hashCode();
        }
        int i47 = (i46 ^ i25) * 1000003;
        Integer num2 = this.zzo;
        if (num2 == null) {
            i26 = 0;
        } else {
            i26 = num2.hashCode();
        }
        int i48 = (i47 ^ i26) * 1000003;
        Integer num3 = this.zzp;
        if (num3 == null) {
            i27 = 0;
        } else {
            i27 = num3.hashCode();
        }
        int i49 = (i48 ^ i27) * 1000003;
        LatLngBounds latLngBounds = this.zzq;
        if (latLngBounds == null) {
            i28 = 0;
        } else {
            i28 = latLngBounds.hashCode();
        }
        int i50 = (i49 ^ i28) * 1000003;
        Uri uri = this.zzr;
        if (uri == null) {
            i29 = 0;
        } else {
            i29 = uri.hashCode();
        }
        int i51 = (i50 ^ i29) * 1000003;
        String str5 = this.zzs;
        if (str5 == null) {
            i31 = 0;
        } else {
            i31 = str5.hashCode();
        }
        int i52 = (i51 ^ i31) * 1000003;
        Integer num4 = this.zzt;
        if (num4 != null) {
            i32 = num4.hashCode();
        }
        return i52 ^ i32;
    }

    public final String toString() {
        String str = this.zza;
        String valueOf = String.valueOf(this.zzb);
        String valueOf2 = String.valueOf(this.zzc);
        String valueOf3 = String.valueOf(this.zzd);
        String str2 = this.zze;
        String valueOf4 = String.valueOf(this.zzf);
        String str3 = this.zzg;
        String valueOf5 = String.valueOf(this.zzh);
        String str4 = this.zzi;
        String valueOf6 = String.valueOf(this.zzj);
        String valueOf7 = String.valueOf(this.zzk);
        String valueOf8 = String.valueOf(this.zzl);
        String valueOf9 = String.valueOf(this.zzm);
        String valueOf10 = String.valueOf(this.zzn);
        String valueOf11 = String.valueOf(this.zzo);
        String valueOf12 = String.valueOf(this.zzp);
        String valueOf13 = String.valueOf(this.zzq);
        String valueOf14 = String.valueOf(this.zzr);
        String str5 = this.zzs;
        String valueOf15 = String.valueOf(this.zzt);
        int length = String.valueOf(str).length();
        int length2 = valueOf.length();
        int length3 = valueOf2.length();
        int length4 = valueOf3.length();
        int length5 = String.valueOf(str2).length();
        int length6 = valueOf4.length();
        int length7 = String.valueOf(str3).length();
        int length8 = valueOf5.length();
        int length9 = String.valueOf(str4).length();
        int length10 = valueOf6.length();
        int length11 = valueOf7.length();
        int length12 = valueOf8.length();
        int length13 = valueOf9.length();
        int length14 = valueOf10.length();
        int length15 = valueOf11.length();
        int length16 = valueOf12.length();
        int length17 = valueOf13.length();
        int length18 = valueOf14.length();
        String str6 = valueOf15;
        StringBuilder sb2 = new StringBuilder(length + 269 + length2 + length3 + length4 + length5 + length6 + length7 + length8 + length9 + length10 + length11 + length12 + length13 + length14 + length15 + length16 + length17 + length18 + String.valueOf(str5).length() + valueOf15.length());
        sb2.append("Place{address=");
        sb2.append(str);
        sb2.append(", addressComponents=");
        sb2.append(valueOf);
        sb2.append(", businessStatus=");
        sb2.append(valueOf2);
        sb2.append(", attributions=");
        sb2.append(valueOf3);
        sb2.append(", id=");
        sb2.append(str2);
        sb2.append(", latLng=");
        sb2.append(valueOf4);
        sb2.append(", name=");
        sb2.append(str3);
        sb2.append(", openingHours=");
        sb2.append(valueOf5);
        sb2.append(", phoneNumber=");
        sb2.append(str4);
        sb2.append(", photoMetadatas=");
        sb2.append(valueOf6);
        sb2.append(", plusCode=");
        sb2.append(valueOf7);
        sb2.append(", priceLevel=");
        sb2.append(valueOf8);
        sb2.append(", rating=");
        sb2.append(valueOf9);
        sb2.append(", types=");
        sb2.append(valueOf10);
        sb2.append(", userRatingsTotal=");
        sb2.append(valueOf11);
        sb2.append(", utcOffsetMinutes=");
        sb2.append(valueOf12);
        sb2.append(", viewport=");
        sb2.append(valueOf13);
        sb2.append(", websiteUri=");
        sb2.append(valueOf14);
        sb2.append(", iconUrl=");
        sb2.append(str5);
        sb2.append(", iconBackgroundColor=");
        sb2.append(str6);
        sb2.append("}");
        return sb2.toString();
    }
}
