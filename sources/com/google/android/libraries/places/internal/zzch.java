package com.google.android.libraries.places.internal;

import androidx.annotation.Nullable;

final class zzch {
    @Nullable
    private zza[] addressComponents;
    @Nullable
    private String businessStatus;
    @Nullable
    private String formattedAddress;
    @Nullable
    private zzb geometry;
    @Nullable
    private String icon;
    @Nullable
    private String iconBackgroundColor;
    @Nullable
    private String iconMaskBaseUri;
    @Nullable
    private String internationalPhoneNumber;
    @Nullable

    /* renamed from: name  reason: collision with root package name */
    private String f44519name;
    @Nullable
    private zzc openingHours;
    @Nullable
    private zzd[] photos;
    @Nullable
    private String placeId;
    @Nullable
    private zze plusCode;
    @Nullable
    private Integer priceLevel;
    @Nullable
    private Double rating;
    @Nullable
    private String[] types;
    @Nullable
    private Integer userRatingsTotal;
    @Nullable
    private Integer utcOffset;
    @Nullable
    private String website;

    class zza {
        @Nullable
        private String longName;
        @Nullable
        private String shortName;
        @Nullable
        private String[] types;

        @Nullable
        public final zzge<String> zza() {
            String[] strArr = this.types;
            if (strArr != null) {
                return zzge.zzl(strArr);
            }
            return null;
        }

        @Nullable
        public final String zzb() {
            return this.longName;
        }

        @Nullable
        public final String zzc() {
            return this.shortName;
        }
    }

    class zzb {
        @Nullable
        private zza location;
        @Nullable
        private C0048zzb viewport;

        class zza {
            @Nullable
            private Double lat;
            @Nullable
            private Double lng;

            @Nullable
            public final Double zza() {
                return this.lat;
            }

            @Nullable
            public final Double zzb() {
                return this.lng;
            }
        }

        /* renamed from: com.google.android.libraries.places.internal.zzch$zzb$zzb  reason: collision with other inner class name */
        class C0048zzb {
            @Nullable
            private zza northeast;
            @Nullable
            private zza southwest;

            @Nullable
            public final zza zza() {
                return this.northeast;
            }

            @Nullable
            public final zza zzb() {
                return this.southwest;
            }
        }

        @Nullable
        public final zza zza() {
            return this.location;
        }

        @Nullable
        public final C0048zzb zzb() {
            return this.viewport;
        }
    }

    class zzc {
        @Nullable
        private zza[] periods;
        @Nullable
        private String[] weekdayText;

        class zza {
            @Nullable
            private zzb close;
            @Nullable
            private zzb open;

            @Nullable
            public final zzb zza() {
                return this.close;
            }

            @Nullable
            public final zzb zzb() {
                return this.open;
            }
        }

        class zzb {
            @Nullable
            private Integer day;
            @Nullable
            private String time;

            @Nullable
            public final Integer zza() {
                return this.day;
            }

            @Nullable
            public final String zzb() {
                return this.time;
            }
        }

        @Nullable
        public final zzge<zza> zza() {
            zza[] zzaArr = this.periods;
            if (zzaArr != null) {
                return zzge.zzl(zzaArr);
            }
            return null;
        }

        @Nullable
        public final zzge<String> zzb() {
            String[] strArr = this.weekdayText;
            if (strArr != null) {
                return zzge.zzl(strArr);
            }
            return null;
        }
    }

    class zzd {
        @Nullable
        private Integer height;
        @Nullable
        private String[] htmlAttributions;
        @Nullable
        private String photoReference;
        @Nullable
        private Integer width;

        @Nullable
        public final zzge<String> zza() {
            String[] strArr = this.htmlAttributions;
            if (strArr != null) {
                return zzge.zzl(strArr);
            }
            return null;
        }

        @Nullable
        public final Integer zzb() {
            return this.height;
        }

        @Nullable
        public final Integer zzc() {
            return this.width;
        }

        @Nullable
        public final String zzd() {
            return this.photoReference;
        }
    }

    class zze {
        @Nullable
        private String compoundCode;
        @Nullable
        private String globalCode;

        @Nullable
        public final String zza() {
            return this.compoundCode;
        }

        @Nullable
        public final String zzb() {
            return this.globalCode;
        }
    }

    @Nullable
    public final zzb zza() {
        return this.geometry;
    }

    @Nullable
    public final zzc zzb() {
        return this.openingHours;
    }

    @Nullable
    public final zze zzc() {
        return this.plusCode;
    }

    @Nullable
    public final zzge<zza> zzd() {
        zza[] zzaArr = this.addressComponents;
        if (zzaArr != null) {
            return zzge.zzl(zzaArr);
        }
        return null;
    }

    @Nullable
    public final zzge<zzd> zze() {
        zzd[] zzdArr = this.photos;
        if (zzdArr != null) {
            return zzge.zzl(zzdArr);
        }
        return null;
    }

    @Nullable
    public final zzge<String> zzf() {
        String[] strArr = this.types;
        if (strArr != null) {
            return zzge.zzl(strArr);
        }
        return null;
    }

    @Nullable
    public final Double zzg() {
        return this.rating;
    }

    @Nullable
    public final Integer zzh() {
        return this.priceLevel;
    }

    @Nullable
    public final Integer zzi() {
        return this.userRatingsTotal;
    }

    @Nullable
    public final Integer zzj() {
        return this.utcOffset;
    }

    @Nullable
    public final String zzk() {
        return this.businessStatus;
    }

    @Nullable
    public final String zzl() {
        return this.formattedAddress;
    }

    @Nullable
    public final String zzm() {
        return this.iconBackgroundColor;
    }

    @Nullable
    public final String zzn() {
        return this.iconMaskBaseUri;
    }

    @Nullable
    public final String zzo() {
        return this.internationalPhoneNumber;
    }

    @Nullable
    public final String zzp() {
        return this.f44519name;
    }

    @Nullable
    public final String zzq() {
        return this.placeId;
    }

    @Nullable
    public final String zzr() {
        return this.website;
    }
}
