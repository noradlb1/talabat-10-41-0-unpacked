package com.google.android.gms.location.places.internal;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.internal.PlaceEntity;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public final class zzar extends zzaw implements Place {
    private final String placeId = zzb("place_id", "");
    private final zzai zzcf;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.google.android.gms.location.places.internal.zzai} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: com.google.android.gms.location.places.internal.zzai} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.google.android.gms.location.places.internal.zzai} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: com.google.android.gms.location.places.internal.zzai} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v10, resolved type: com.google.android.gms.location.places.internal.zzai} */
    /* JADX WARNING: type inference failed for: r8v7, types: [java.lang.String] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzar(com.google.android.gms.common.data.DataHolder r7, int r8) {
        /*
            r6 = this;
            r6.<init>(r7, r8)
            java.lang.String r7 = "place_id"
            java.lang.String r8 = ""
            java.lang.String r7 = r6.zzb((java.lang.String) r7, (java.lang.String) r8)
            r6.placeId = r7
            java.util.List r7 = r6.getPlaceTypes()
            int r7 = r7.size()
            if (r7 > 0) goto L_0x004b
            java.lang.CharSequence r7 = r6.getPhoneNumber()
            if (r7 == 0) goto L_0x0027
            java.lang.CharSequence r7 = r6.getPhoneNumber()
            int r7 = r7.length()
            if (r7 > 0) goto L_0x004b
        L_0x0027:
            android.net.Uri r7 = r6.getWebsiteUri()
            if (r7 == 0) goto L_0x0039
            android.net.Uri r7 = r6.getWebsiteUri()
            android.net.Uri r8 = android.net.Uri.EMPTY
            boolean r7 = r7.equals(r8)
            if (r7 == 0) goto L_0x004b
        L_0x0039:
            float r7 = r6.getRating()
            r8 = 0
            int r7 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
            if (r7 >= 0) goto L_0x004b
            int r7 = r6.getPriceLevel()
            if (r7 < 0) goto L_0x0049
            goto L_0x004b
        L_0x0049:
            r7 = 0
            goto L_0x004c
        L_0x004b:
            r7 = 1
        L_0x004c:
            r8 = 0
            if (r7 == 0) goto L_0x0075
            com.google.android.gms.location.places.internal.zzai r7 = new com.google.android.gms.location.places.internal.zzai
            java.util.List r1 = r6.getPlaceTypes()
            java.lang.CharSequence r0 = r6.getPhoneNumber()
            if (r0 == 0) goto L_0x0063
            java.lang.CharSequence r8 = r6.getPhoneNumber()
            java.lang.String r8 = r8.toString()
        L_0x0063:
            r2 = r8
            android.net.Uri r3 = r6.getWebsiteUri()
            float r4 = r6.getRating()
            int r5 = r6.getPriceLevel()
            r0 = r7
            r0.<init>(r1, r2, r3, r4, r5)
            r8 = r7
        L_0x0075:
            r6.zzcf = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.location.places.internal.zzar.<init>(com.google.android.gms.common.data.DataHolder, int):void");
    }

    private final List<String> zzl() {
        return zzc("place_attributions", (List<String>) Collections.emptyList());
    }

    public final /* synthetic */ Object freeze() {
        boolean z11;
        PlaceEntity.zzb zzb = new PlaceEntity.zzb().zzd(getAddress().toString()).zzd(zzl()).zzb(getId());
        if (!hasColumn("place_is_permanently_closed") || hasNull("place_is_permanently_closed")) {
            z11 = false;
        } else {
            z11 = getBoolean("place_is_permanently_closed");
        }
        PlaceEntity zzj = zzb.zzb(z11).zzb(getLatLng()).zzb(zzb("place_level_number", 0.0f)).zzc(getName().toString()).zze(getPhoneNumber().toString()).zzc(getPriceLevel()).zzc(getRating()).zzc(getPlaceTypes()).zzb(getViewport()).zzb(getWebsiteUri()).zzb((zzal) zzb("place_opening_hours", zzal.CREATOR)).zzb(this.zzcf).zzf(zzb("place_adr_address", "")).zzj();
        zzj.setLocale(getLocale());
        return zzj;
    }

    public final CharSequence getAddress() {
        return zzb("place_address", "");
    }

    public final CharSequence getAttributions() {
        return zzi.zzc(zzl());
    }

    public final String getId() {
        return this.placeId;
    }

    public final LatLng getLatLng() {
        return (LatLng) zzb("place_lat_lng", LatLng.CREATOR);
    }

    public final Locale getLocale() {
        String zzb = zzb("place_locale_language", "");
        if (!TextUtils.isEmpty(zzb)) {
            return new Locale(zzb, zzb("place_locale_country", ""));
        }
        String zzb2 = zzb("place_locale", "");
        if (!TextUtils.isEmpty(zzb2)) {
            return new Locale(zzb2);
        }
        return Locale.getDefault();
    }

    public final CharSequence getName() {
        return zzb("place_name", "");
    }

    public final CharSequence getPhoneNumber() {
        return zzb("place_phone_number", "");
    }

    public final List<Integer> getPlaceTypes() {
        return zzb("place_types", (List<Integer>) Collections.emptyList());
    }

    public final int getPriceLevel() {
        return zzc("place_price_level", -1);
    }

    public final float getRating() {
        return zzb("place_rating", -1.0f);
    }

    public final LatLngBounds getViewport() {
        return (LatLngBounds) zzb("place_viewport", LatLngBounds.CREATOR);
    }

    public final Uri getWebsiteUri() {
        String zzb = zzb("place_website_uri", (String) null);
        if (zzb == null) {
            return null;
        }
        return Uri.parse(zzb);
    }
}
