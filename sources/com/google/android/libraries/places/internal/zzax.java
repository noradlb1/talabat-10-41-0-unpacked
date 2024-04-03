package com.google.android.libraries.places.internal;

import androidx.annotation.Nullable;

final class zzax {
    @Nullable
    private String description;
    @Nullable
    private Integer distanceMeters;
    @Nullable
    private zzb[] matchedSubstrings;
    @Nullable
    private String placeId;
    @Nullable
    private zza structuredFormatting;
    @Nullable
    private String[] types;

    class zza {
        @Nullable
        private String mainText;
        @Nullable
        private zzb[] mainTextMatchedSubstrings;
        @Nullable
        private String secondaryText;
        @Nullable
        private zzb[] secondaryTextMatchedSubstrings;

        @Nullable
        public final zzge<zzb> zza() {
            zzb[] zzbArr = this.mainTextMatchedSubstrings;
            if (zzbArr != null) {
                return zzge.zzl(zzbArr);
            }
            return null;
        }

        @Nullable
        public final zzge<zzb> zzb() {
            zzb[] zzbArr = this.secondaryTextMatchedSubstrings;
            if (zzbArr != null) {
                return zzge.zzl(zzbArr);
            }
            return null;
        }

        @Nullable
        public final String zzc() {
            return this.mainText;
        }

        @Nullable
        public final String zzd() {
            return this.secondaryText;
        }
    }

    class zzb {
        @Nullable
        Integer length;
        @Nullable
        Integer offset;
    }

    @Nullable
    public final zza zza() {
        return this.structuredFormatting;
    }

    @Nullable
    public final zzge<zzb> zzb() {
        zzb[] zzbArr = this.matchedSubstrings;
        if (zzbArr != null) {
            return zzge.zzl(zzbArr);
        }
        return null;
    }

    @Nullable
    public final zzge<String> zzc() {
        String[] strArr = this.types;
        if (strArr != null) {
            return zzge.zzl(strArr);
        }
        return null;
    }

    @Nullable
    public final Integer zzd() {
        return this.distanceMeters;
    }

    @Nullable
    public final String zze() {
        return this.description;
    }

    @Nullable
    public final String zzf() {
        return this.placeId;
    }
}
