package com.google.firebase.appindexing;

import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.icing.zzfw;
import com.google.firebase.appindexing.builders.IndexableBuilder;
import com.google.firebase.appindexing.internal.zzac;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;

public interface Indexable {
    public static final int MAX_BYTE_SIZE = 30000;
    public static final int MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL = 1000;
    public static final int MAX_NESTING_DEPTH = 5;
    public static final int MAX_NUMBER_OF_FIELDS = 20;
    public static final int MAX_REPEATED_SIZE = 100;
    public static final int MAX_STRING_LENGTH = 20000;
    public static final int MAX_URL_LENGTH = 256;

    public static class Builder extends IndexableBuilder<Builder> {
        public Builder() {
            this("Thing");
        }

        public Builder(@NonNull String str) {
            super(str);
        }
    }

    public interface Metadata {

        public static final class Builder {
            private boolean zza = zzfw.zzd().zza();
            private int zzb = zzfw.zzd().zzb();
            private String zzc = zzfw.zzd().zzc();
            private final Bundle zzd = new Bundle();

            @NonNull
            public Builder setScope(int i11) {
                boolean z11;
                if (i11 <= 0 || i11 > 3) {
                    z11 = false;
                } else {
                    z11 = true;
                }
                StringBuilder sb2 = new StringBuilder(69);
                sb2.append("The scope of this indexable is not valid, scope value is ");
                sb2.append(i11);
                sb2.append(RealDiscoveryConfigurationRepository.VERSION_DELIMETER);
                Preconditions.checkArgument(z11, sb2.toString());
                IndexableBuilder.zzd(this.zzd, "scope", (long) i11);
                return this;
            }

            @NonNull
            public Builder setScore(int i11) {
                boolean z11;
                if (i11 >= 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                StringBuilder sb2 = new StringBuilder(53);
                sb2.append("Negative score values are invalid. Value: ");
                sb2.append(i11);
                Preconditions.checkArgument(z11, sb2.toString());
                this.zzb = i11;
                return this;
            }

            @NonNull
            public Builder setSliceUri(@NonNull Uri uri) {
                Preconditions.checkNotNull(uri);
                IndexableBuilder.zza(this.zzd, "sliceUri", uri.toString());
                return this;
            }

            @NonNull
            public Builder setWorksOffline(boolean z11) {
                this.zza = z11;
                return this;
            }

            public final zzac zza() {
                return new zzac(this.zza, this.zzb, this.zzc, this.zzd, (Bundle) null);
            }
        }
    }
}
