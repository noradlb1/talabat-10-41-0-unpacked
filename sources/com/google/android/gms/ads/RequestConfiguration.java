package com.google.android.gms.ads;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.internal.ads.zzciz;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;

public class RequestConfiguration {
    @RecentlyNonNull
    public static final String MAX_AD_CONTENT_RATING_G = "G";
    @RecentlyNonNull
    public static final String MAX_AD_CONTENT_RATING_MA = "MA";
    @RecentlyNonNull
    public static final String MAX_AD_CONTENT_RATING_PG = "PG";
    @RecentlyNonNull
    public static final String MAX_AD_CONTENT_RATING_T = "T";
    @RecentlyNonNull
    public static final String MAX_AD_CONTENT_RATING_UNSPECIFIED = "";
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_FALSE = 0;
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_TRUE = 1;
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_UNSPECIFIED = -1;
    public static final int TAG_FOR_UNDER_AGE_OF_CONSENT_FALSE = 0;
    public static final int TAG_FOR_UNDER_AGE_OF_CONSENT_TRUE = 1;
    public static final int TAG_FOR_UNDER_AGE_OF_CONSENT_UNSPECIFIED = -1;
    @RecentlyNonNull
    public static final List<String> zza = Arrays.asList(new String[]{MAX_AD_CONTENT_RATING_MA, "T", MAX_AD_CONTENT_RATING_PG, MAX_AD_CONTENT_RATING_G});
    private final int zzb;
    private final int zzc;
    @Nullable
    private final String zzd;
    private final List<String> zze;

    public static class Builder {
        private int zza = -1;
        private int zzb = -1;
        @Nullable
        private String zzc = null;
        private final List<String> zzd = new ArrayList();

        @RecentlyNonNull
        public RequestConfiguration build() {
            return new RequestConfiguration(this.zza, this.zzb, this.zzc, this.zzd, (zzc) null);
        }

        @RecentlyNonNull
        public Builder setMaxAdContentRating(@Nullable String str) {
            String str2;
            if (str == null || "".equals(str)) {
                this.zzc = null;
            } else if (RequestConfiguration.MAX_AD_CONTENT_RATING_G.equals(str) || RequestConfiguration.MAX_AD_CONTENT_RATING_PG.equals(str) || "T".equals(str) || RequestConfiguration.MAX_AD_CONTENT_RATING_MA.equals(str)) {
                this.zzc = str;
            } else {
                if (str.length() != 0) {
                    str2 = "Invalid value passed to setMaxAdContentRating: ".concat(str);
                } else {
                    str2 = new String("Invalid value passed to setMaxAdContentRating: ");
                }
                zzciz.zzj(str2);
            }
            return this;
        }

        @RecentlyNonNull
        public Builder setTagForChildDirectedTreatment(int i11) {
            if (i11 == -1 || i11 == 0 || i11 == 1) {
                this.zza = i11;
            } else {
                StringBuilder sb2 = new StringBuilder(68);
                sb2.append("Invalid value passed to setTagForChildDirectedTreatment: ");
                sb2.append(i11);
                zzciz.zzj(sb2.toString());
            }
            return this;
        }

        @RecentlyNonNull
        public Builder setTagForUnderAgeOfConsent(int i11) {
            if (i11 == -1 || i11 == 0 || i11 == 1) {
                this.zzb = i11;
            } else {
                StringBuilder sb2 = new StringBuilder(63);
                sb2.append("Invalid value passed to setTagForUnderAgeOfConsent: ");
                sb2.append(i11);
                zzciz.zzj(sb2.toString());
            }
            return this;
        }

        @RecentlyNonNull
        public Builder setTestDeviceIds(@Nullable List<String> list) {
            this.zzd.clear();
            if (list != null) {
                this.zzd.addAll(list);
            }
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface MaxAdContentRating {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface TagForChildDirectedTreatment {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface TagForUnderAgeOfConsent {
    }

    public /* synthetic */ RequestConfiguration(int i11, int i12, String str, List list, zzc zzc2) {
        this.zzb = i11;
        this.zzc = i12;
        this.zzd = str;
        this.zze = list;
    }

    @RecentlyNonNull
    public String getMaxAdContentRating() {
        String str = this.zzd;
        return str == null ? "" : str;
    }

    public int getTagForChildDirectedTreatment() {
        return this.zzb;
    }

    public int getTagForUnderAgeOfConsent() {
        return this.zzc;
    }

    @RecentlyNonNull
    public List<String> getTestDeviceIds() {
        return new ArrayList(this.zze);
    }

    @RecentlyNonNull
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.setTagForChildDirectedTreatment(this.zzb);
        builder.setTagForUnderAgeOfConsent(this.zzc);
        builder.setMaxAdContentRating(this.zzd);
        builder.setTestDeviceIds(this.zze);
        return builder;
    }
}
