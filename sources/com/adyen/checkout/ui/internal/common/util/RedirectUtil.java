package com.adyen.checkout.ui.internal.common.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.adyen.checkout.base.internal.Parcelables;

public final class RedirectUtil {
    private static final String RESOLVER_ACTIVITY_PACKAGE_NAME = "android";

    public static final class ResolveResult implements Parcelable {
        @NonNull
        public static final Parcelable.Creator<ResolveResult> CREATOR = new Parcelable.Creator<ResolveResult>() {
            public ResolveResult createFromParcel(Parcel parcel) {
                return new ResolveResult(parcel);
            }

            public ResolveResult[] newArray(int i11) {
                return new ResolveResult[i11];
            }
        };
        private ResolveInfo mResolveInfo;
        private ResolveType mResolveType;

        public int describeContents() {
            return 0;
        }

        @Nullable
        public ResolveInfo getResolveInfo() {
            return this.mResolveInfo;
        }

        @NonNull
        public ResolveType getResolveType() {
            return this.mResolveType;
        }

        public void writeToParcel(@NonNull Parcel parcel, int i11) {
            Parcelables.writeSerializable(parcel, this.mResolveType);
            Parcelables.write(parcel, this.mResolveInfo);
        }

        public ResolveResult(@NonNull Parcel parcel) {
            this.mResolveType = (ResolveType) Parcelables.readSerializable(parcel);
            this.mResolveInfo = (ResolveInfo) Parcelables.read(parcel, ResolveInfo.class);
        }

        private ResolveResult(@NonNull ResolveType resolveType, @Nullable ResolveInfo resolveInfo) {
            this.mResolveType = resolveType;
            this.mResolveInfo = resolveInfo;
        }
    }

    public enum ResolveType {
        RESOLVER_ACTIVITY,
        DEFAULT_BROWSER,
        APPLICATION,
        UNKNOWN
    }

    private RedirectUtil() {
        throw new IllegalStateException("No instances.");
    }

    @NonNull
    public static ResolveResult determineResolveResult(@NonNull Context context, @NonNull Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW", uri);
        Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse("http://"));
        try {
            PackageManager packageManager = context.getPackageManager();
            ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 0);
            ResolveInfo resolveActivity2 = packageManager.resolveActivity(intent2, 65536);
            String str = resolveActivity != null ? resolveActivity.activityInfo.packageName : null;
            String str2 = resolveActivity2 != null ? resolveActivity2.activityInfo.packageName : null;
            if (str == null) {
                return new ResolveResult(ResolveType.UNKNOWN, (ResolveInfo) null);
            }
            if (str.equals("android")) {
                return new ResolveResult(ResolveType.RESOLVER_ACTIVITY, resolveActivity);
            }
            if (str.equals(str2)) {
                return new ResolveResult(ResolveType.DEFAULT_BROWSER, resolveActivity);
            }
            return new ResolveResult(ResolveType.APPLICATION, resolveActivity);
        } catch (Exception unused) {
            return new ResolveResult(ResolveType.UNKNOWN, (ResolveInfo) null);
        }
    }

    @NonNull
    public static ResolveResult determineResolveResult(@NonNull Context context, @NonNull String str) {
        PackageManager packageManager = context.getPackageManager();
        Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(str);
        if (launchIntentForPackage == null) {
            return new ResolveResult(ResolveType.UNKNOWN, (ResolveInfo) null);
        }
        return new ResolveResult(ResolveType.APPLICATION, packageManager.resolveActivity(launchIntentForPackage, 0));
    }
}
