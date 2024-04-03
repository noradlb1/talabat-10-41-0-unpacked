package com.google.android.gms.common;

import android.app.Activity;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.HideFirstParty;
import com.google.android.gms.common.internal.zag;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;

public final class GooglePlayServicesUtil extends GooglePlayServicesUtilLight {
    @NonNull
    public static final String GMS_ERROR_DIALOG = "GooglePlayServicesErrorDialog";
    @NonNull
    @Deprecated
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    @Deprecated
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    @NonNull
    public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";

    private GooglePlayServicesUtil() {
    }

    @Deprecated
    @Nullable
    public static Dialog getErrorDialog(int i11, @NonNull Activity activity, int i12) {
        return getErrorDialog(i11, activity, i12, (DialogInterface.OnCancelListener) null);
    }

    @NonNull
    @Deprecated
    public static PendingIntent getErrorPendingIntent(int i11, @NonNull Context context, int i12) {
        return GooglePlayServicesUtilLight.getErrorPendingIntent(i11, context, i12);
    }

    @NonNull
    @Deprecated
    @VisibleForTesting
    public static String getErrorString(int i11) {
        return GooglePlayServicesUtilLight.getErrorString(i11);
    }

    @NonNull
    public static Context getRemoteContext(@NonNull Context context) {
        return GooglePlayServicesUtilLight.getRemoteContext(context);
    }

    @NonNull
    public static Resources getRemoteResource(@NonNull Context context) {
        return GooglePlayServicesUtilLight.getRemoteResource(context);
    }

    @ResultIgnorabilityUnspecified
    @Deprecated
    @HideFirstParty
    public static int isGooglePlayServicesAvailable(@NonNull Context context) {
        return GooglePlayServicesUtilLight.isGooglePlayServicesAvailable(context);
    }

    @Deprecated
    public static boolean isUserRecoverableError(int i11) {
        return GooglePlayServicesUtilLight.isUserRecoverableError(i11);
    }

    @ResultIgnorabilityUnspecified
    @Deprecated
    public static boolean showErrorDialogFragment(int i11, @NonNull Activity activity, int i12) {
        return showErrorDialogFragment(i11, activity, i12, (DialogInterface.OnCancelListener) null);
    }

    @Deprecated
    public static void showErrorNotification(int i11, @NonNull Context context) {
        GoogleApiAvailability instance = GoogleApiAvailability.getInstance();
        if (GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating(context, i11) || GooglePlayServicesUtilLight.isPlayStorePossiblyUpdating(context, i11)) {
            instance.zaf(context);
        } else {
            instance.showErrorNotification(context, i11);
        }
    }

    @Deprecated
    @Nullable
    public static Dialog getErrorDialog(int i11, @NonNull Activity activity, int i12, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        if (true == GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating(activity, i11)) {
            i11 = 18;
        }
        return GoogleApiAvailability.getInstance().getErrorDialog(activity, i11, i12, onCancelListener);
    }

    @KeepForSdk
    @Deprecated
    public static int isGooglePlayServicesAvailable(@NonNull Context context, int i11) {
        return GooglePlayServicesUtilLight.isGooglePlayServicesAvailable(context, i11);
    }

    @ResultIgnorabilityUnspecified
    @Deprecated
    public static boolean showErrorDialogFragment(int i11, @NonNull Activity activity, int i12, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        return showErrorDialogFragment(i11, activity, (Fragment) null, i12, onCancelListener);
    }

    @ResultIgnorabilityUnspecified
    public static boolean showErrorDialogFragment(int i11, @NonNull Activity activity, @Nullable Fragment fragment, int i12, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        if (true == GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating(activity, i11)) {
            i11 = 18;
        }
        int i13 = i11;
        GoogleApiAvailability instance = GoogleApiAvailability.getInstance();
        if (fragment == null) {
            return instance.showErrorDialogFragment(activity, i13, i12, onCancelListener);
        }
        Dialog zaa = instance.zaa(activity, i13, zag.zac(fragment, GoogleApiAvailability.getInstance().getErrorResolutionIntent(activity, i13, "d"), i12), onCancelListener, (DialogInterface.OnClickListener) null);
        if (zaa == null) {
            return false;
        }
        instance.zad(activity, zaa, GMS_ERROR_DIALOG, onCancelListener);
        return true;
    }
}
