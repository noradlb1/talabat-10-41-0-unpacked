package com.google.android.libraries.places.internal;

import android.location.Location;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.libraries.places.api.model.LocationBias;
import com.google.android.libraries.places.api.model.LocationRestriction;
import com.google.android.libraries.places.api.model.RectangularBounds;
import com.visa.checkout.Profile;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public final class zzcj {
    private static final zzgg<zzr, String> zza;

    static {
        zzgf zzgf = new zzgf();
        zzgf.zza(zzr.zza, Profile.DataLevel.NONE);
        zzgf.zza(zzr.PSK, "WPA_PSK");
        zzgf.zza(zzr.EAP, "WPA_EAP");
        zzgf.zza(zzr.OTHER, "SECURED_NONE");
        zza = zzgf.zzb();
    }

    @Nullable
    public static Integer zza(@Nullable Location location) {
        if (location == null) {
            return null;
        }
        float accuracy = location.getAccuracy();
        if (!location.hasAccuracy() || accuracy <= 0.0f) {
            return null;
        }
        return Integer.valueOf(Math.round(accuracy * 100.0f));
    }

    @Nullable
    public static String zzb(List<String> list) {
        StringBuilder sb2 = new StringBuilder();
        Iterator<String> it = list.iterator();
        while (true) {
            String str = null;
            if (!it.hasNext()) {
                break;
            }
            String next = it.next();
            if (!TextUtils.isEmpty(next)) {
                String valueOf = String.valueOf(next.toLowerCase(Locale.US));
                if (valueOf.length() != 0) {
                    str = "country:".concat(valueOf);
                } else {
                    str = new String("country:");
                }
            }
            if (str != null) {
                if (sb2.length() != 0) {
                    sb2.append('|');
                }
                sb2.append(str);
            }
        }
        if (sb2.length() == 0) {
            return null;
        }
        return sb2.toString();
    }

    @Nullable
    public static String zzc(@Nullable Location location) {
        if (location == null) {
            return null;
        }
        return zzh(location.getLatitude(), location.getLongitude());
    }

    @Nullable
    public static String zzd(@Nullable LatLng latLng) {
        if (latLng == null) {
            return null;
        }
        return zzh(latLng.latitude, latLng.longitude);
    }

    @Nullable
    public static String zze(@Nullable LocationBias locationBias) {
        if (locationBias == null) {
            return null;
        }
        if (locationBias instanceof RectangularBounds) {
            return zzi((RectangularBounds) locationBias);
        }
        throw new AssertionError("Unknown LocationBias type.");
    }

    @Nullable
    public static String zzf(@Nullable LocationRestriction locationRestriction) {
        if (locationRestriction == null) {
            return null;
        }
        if (locationRestriction instanceof RectangularBounds) {
            return zzi((RectangularBounds) locationRestriction);
        }
        throw new AssertionError("Unknown LocationRestriction type.");
    }

    public static String zzg(zzge<zzs> zzge, int i11) {
        String str;
        String str2;
        StringBuilder sb2 = new StringBuilder();
        int size = zzge.size();
        int i12 = 0;
        while (i12 < size) {
            zzs zzs = zzge.get(i12);
            if (sb2.length() > 0) {
                str = "|";
            } else {
                str = "";
            }
            zzgf zzgf = new zzgf();
            zzgf.zza("mac", zzs.zzd());
            zzgf.zza("strength_dbm", Integer.valueOf(zzs.zzb()));
            zzgf.zza("wifi_auth_type", zza.get(zzs.zzc()));
            zzgf.zza("is_connected", Boolean.valueOf(zzs.zze()));
            zzgf.zza("frequency_mhz", Integer.valueOf(zzs.zza()));
            zzgg zzb = zzgf.zzb();
            zzfh zzb2 = zzfh.zzb(",");
            Iterator it = zzb.entrySet().iterator();
            StringBuilder sb3 = new StringBuilder();
            try {
                zzff.zza(sb3, it, zzb2, "=");
                String valueOf = String.valueOf(sb3.toString());
                if (valueOf.length() != 0) {
                    str2 = str.concat(valueOf);
                } else {
                    str2 = new String(str);
                }
                if (sb2.length() + str2.length() > 4000) {
                    break;
                }
                sb2.append(str2);
                i12++;
            } catch (IOException e11) {
                throw new AssertionError(e11);
            }
        }
        return sb2.toString();
    }

    private static String zzh(double d11, double d12) {
        return String.format(Locale.US, "%.15f,%.15f", new Object[]{Double.valueOf(d11), Double.valueOf(d12)});
    }

    private static String zzi(RectangularBounds rectangularBounds) {
        LatLng southwest = rectangularBounds.getSouthwest();
        double d11 = southwest.latitude;
        double d12 = southwest.longitude;
        LatLng northeast = rectangularBounds.getNortheast();
        double d13 = northeast.latitude;
        double d14 = northeast.longitude;
        return String.format(Locale.US, "rectangle:%.15f,%.15f|%.15f,%.15f", new Object[]{Double.valueOf(d11), Double.valueOf(d12), Double.valueOf(d13), Double.valueOf(d14)});
    }
}
