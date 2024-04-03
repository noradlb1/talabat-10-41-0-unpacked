package com.google.firebase.appindexing;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.appindexing.builders.IndexableBuilder;
import com.google.firebase.appindexing.internal.zzb;
import com.google.firebase.appindexing.internal.zzc;
import com.google.firebase.appindexing.internal.zzw;
import java.util.Arrays;

public interface Action {

    public interface Metadata {

        public static class Builder {
            private boolean zza = true;

            @NonNull
            public Builder setUpload(boolean z11) {
                this.zza = z11;
                return this;
            }

            public final zzb zza() {
                return new zzb(this.zza, (String) null, (String) null, (byte[]) null, false);
            }
        }
    }

    public static class Builder {
        @NonNull
        public static final String ACTIVATE_ACTION = "ActivateAction";
        @NonNull
        public static final String ADD_ACTION = "AddAction";
        @NonNull
        public static final String BOOKMARK_ACTION = "BookmarkAction";
        @NonNull
        public static final String COMMENT_ACTION = "CommentAction";
        @NonNull
        public static final String LIKE_ACTION = "LikeAction";
        @NonNull
        public static final String LISTEN_ACTION = "ListenAction";
        @NonNull
        public static final String SEND_ACTION = "SendAction";
        @NonNull
        public static final String SHARE_ACTION = "ShareAction";
        @NonNull
        public static final String STATUS_TYPE_ACTIVE = "http://schema.org/ActiveActionStatus";
        @NonNull
        public static final String STATUS_TYPE_COMPLETED = "http://schema.org/CompletedActionStatus";
        @NonNull
        public static final String STATUS_TYPE_FAILED = "http://schema.org/FailedActionStatus";
        @NonNull
        public static final String VIEW_ACTION = "ViewAction";
        @NonNull
        public static final String WATCH_ACTION = "WatchAction";
        private final Bundle zza = new Bundle();
        private final String zzb;
        private String zzc;
        private String zzd;
        private String zze;
        private zzb zzf;
        private String zzg;

        public Builder(@NonNull String str) {
            this.zzb = str;
        }

        @NonNull
        public Action build() {
            Preconditions.checkNotNull(this.zzc, "setObject is required before calling build().");
            Preconditions.checkNotNull(this.zzd, "setObject is required before calling build().");
            String str = this.zzb;
            String str2 = this.zzc;
            String str3 = this.zzd;
            String str4 = this.zze;
            zzb zzb2 = this.zzf;
            if (zzb2 == null) {
                zzb2 = new Metadata.Builder().zza();
            }
            return new zzc(str, str2, str3, str4, zzb2, this.zzg, this.zza);
        }

        @NonNull
        public Builder put(@NonNull String str, @NonNull double... dArr) {
            Bundle bundle = this.zza;
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(dArr);
            int length = dArr.length;
            if (length > 0) {
                if (length >= 100) {
                    zzw.zza("Input Array of elements is too big, cutting off.");
                    dArr = Arrays.copyOf(dArr, 100);
                }
                bundle.putDoubleArray(str, dArr);
            } else {
                zzw.zza("Double array is empty and is ignored by put method.");
            }
            return this;
        }

        @NonNull
        public Builder setActionStatus(@NonNull String str) {
            Preconditions.checkNotNull(str);
            this.zzg = str;
            return this;
        }

        @NonNull
        public Builder setMetadata(@NonNull Metadata.Builder builder) {
            Preconditions.checkNotNull(builder);
            this.zzf = builder.zza();
            return this;
        }

        @NonNull
        public final Builder setName(@NonNull String str) {
            Preconditions.checkNotNull(str);
            this.zzc = str;
            return put("name", str);
        }

        @NonNull
        public Builder setObject(@NonNull String str, @NonNull String str2) {
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(str2);
            this.zzc = str;
            this.zzd = str2;
            return this;
        }

        @NonNull
        public Builder setResult(@NonNull Indexable... indexableArr) throws FirebaseAppIndexingInvalidArgumentException {
            return put("result", indexableArr);
        }

        @NonNull
        public final Builder setUrl(@NonNull String str) {
            Preconditions.checkNotNull(str);
            this.zzd = str;
            return put("url", str);
        }

        @NonNull
        public final String zza() {
            String str = this.zzc;
            if (str == null) {
                return null;
            }
            return new String(str);
        }

        @NonNull
        public final String zzb() {
            String str = this.zzd;
            if (str == null) {
                return null;
            }
            return new String(str);
        }

        @NonNull
        public final String zzc() {
            return new String(this.zzg);
        }

        @NonNull
        public Builder setObject(@NonNull String str, @NonNull String str2, @NonNull String str3) {
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(str2);
            Preconditions.checkNotNull(str3);
            this.zzc = str;
            this.zzd = str2;
            this.zze = str3;
            return this;
        }

        @NonNull
        public Builder put(@NonNull String str, @NonNull long... jArr) {
            IndexableBuilder.zzd(this.zza, str, jArr);
            return this;
        }

        @NonNull
        public Builder put(@NonNull String str, @NonNull Indexable... indexableArr) throws FirebaseAppIndexingInvalidArgumentException {
            IndexableBuilder.zzb(this.zza, str, indexableArr);
            return this;
        }

        @NonNull
        public Builder put(@NonNull String str, @NonNull String... strArr) {
            IndexableBuilder.zza(this.zza, str, strArr);
            return this;
        }

        @NonNull
        public Builder put(@NonNull String str, @NonNull boolean... zArr) {
            IndexableBuilder.zzc(this.zza, str, zArr);
            return this;
        }
    }
}
