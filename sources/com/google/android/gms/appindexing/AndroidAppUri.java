package com.google.android.gms.appindexing;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.List;
import javax.annotation.Nullable;

@Deprecated
@VisibleForTesting
public final class AndroidAppUri {
    private final Uri zza;

    private AndroidAppUri(Uri uri) {
        this.zza = uri;
    }

    @NonNull
    @Deprecated
    @VisibleForTesting
    public static AndroidAppUri newAndroidAppUri(@NonNull Uri uri) {
        AndroidAppUri androidAppUri = new AndroidAppUri(uri);
        if (!"android-app".equals(androidAppUri.zza.getScheme())) {
            throw new IllegalArgumentException("android-app scheme is required.");
        } else if (!TextUtils.isEmpty(androidAppUri.getPackageName())) {
            if (androidAppUri.zza.equals(newAndroidAppUri(androidAppUri.getPackageName(), androidAppUri.getDeepLinkUri()).toUri())) {
                return androidAppUri;
            }
            throw new IllegalArgumentException("URI is not canonical.");
        } else {
            throw new IllegalArgumentException("Package name is empty.");
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof AndroidAppUri) {
            return this.zza.equals(((AndroidAppUri) obj).zza);
        }
        return false;
    }

    @androidx.annotation.Nullable
    @VisibleForTesting
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

    @androidx.annotation.Nullable
    @VisibleForTesting
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

    @NonNull
    @VisibleForTesting
    public Uri toUri() {
        return this.zza;
    }

    @NonNull
    @Deprecated
    @VisibleForTesting
    public static AndroidAppUri newAndroidAppUri(@Nullable String str, @Nullable Uri uri) {
        Uri.Builder authority = new Uri.Builder().scheme("android-app").authority(str);
        if (uri != null) {
            String scheme = uri.getScheme();
            if (scheme != null) {
                authority.appendPath(scheme);
            }
            String authority2 = uri.getAuthority();
            if (authority2 != null) {
                authority.appendPath(authority2);
            }
            for (String appendPath : uri.getPathSegments()) {
                authority.appendPath(appendPath);
            }
            authority.encodedQuery(uri.getEncodedQuery()).encodedFragment(uri.getEncodedFragment());
        }
        return new AndroidAppUri(authority.build());
    }
}
