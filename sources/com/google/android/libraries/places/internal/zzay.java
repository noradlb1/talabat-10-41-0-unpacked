package com.google.android.libraries.places.internal;

import com.facebook.internal.AnalyticsEvents;
import com.google.android.libraries.places.api.model.PhotoMetadata;
import com.google.android.libraries.places.api.net.FetchPhotoRequest;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

final class zzay extends zzbr<Object, FetchPhotoRequest> {
    public zzay(FetchPhotoRequest fetchPhotoRequest, String str, boolean z11, zzdl zzdl) {
        super(fetchPhotoRequest, (Locale) null, str, false, zzdl);
    }

    public final String zze() {
        return AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PHOTO;
    }

    public final Map<String, String> zzf() {
        FetchPhotoRequest fetchPhotoRequest = (FetchPhotoRequest) zzb();
        PhotoMetadata photoMetadata = fetchPhotoRequest.getPhotoMetadata();
        HashMap hashMap = new HashMap();
        zzbr.zzg(hashMap, "maxheight", fetchPhotoRequest.getMaxHeight(), (Object) null);
        zzbr.zzg(hashMap, "maxwidth", fetchPhotoRequest.getMaxWidth(), (Object) null);
        hashMap.put("photoreference", photoMetadata.zza());
        return hashMap;
    }
}
