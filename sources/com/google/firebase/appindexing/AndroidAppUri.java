package com.google.firebase.appindexing;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Objects;
import java.util.List;

public final class AndroidAppUri {
    private final Uri zza;

    private AndroidAppUri(Uri uri) {
        this.zza = uri;
    }

    @NonNull
    public static AndroidAppUri newAndroidAppUri(@NonNull Uri uri) {
        AndroidAppUri androidAppUri = new AndroidAppUri(uri);
        if (!"android-app".equals(androidAppUri.zza.getScheme())) {
            throw new IllegalArgumentException("android-app scheme is required.");
        } else if (!TextUtils.isEmpty(androidAppUri.getPackageName())) {
            return androidAppUri;
        } else {
            throw new IllegalArgumentException("Package name is empty.");
        }
    }

    public boolean equals(@NonNull Object obj) {
        if (obj instanceof AndroidAppUri) {
            return this.zza.equals(((AndroidAppUri) obj).zza);
        }
        return false;
    }

    @NonNull
    public Uri getDeepLinkUri() {
        List<String> pathSegments = this.zza.getPathSegments();
        if (pathSegments.size() <= 0) {
            return null;
        }
        Uri.Builder builder = new Uri.Builder();
        builder.scheme(pathSegments.get(0));
        if (pathSegments.size() > 1) {
            builder.authority(pathSegments.get(1));
            for (int i11 = 2; i11 < pathSegments.size(); i11++) {
                builder.appendPath(pathSegments.get(i11));
            }
        }
        builder.encodedQuery(this.zza.getEncodedQuery());
        builder.encodedFragment(this.zza.getEncodedFragment());
        return builder.build();
    }

    @NonNull
    public String getPackageName() {
        return this.zza.getAuthority();
    }

    public int hashCode() {
        return Objects.hashCode(this.zza);
    }

    @NonNull
    public String toString() {
        return this.zza.toString();
    }
}
