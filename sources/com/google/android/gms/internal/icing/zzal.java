package com.google.android.gms.internal.icing;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import androidx.webkit.ProxyConfig;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndexApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import java.util.List;
import net.bytebuddy.jar.asm.Opcodes;

public final class zzal implements AppIndexApi, zzz {
    private static final String zza = "zzal";

    public static Intent zzb(String str, Uri uri) {
        zzc(str, uri);
        if (uri != null && zzd(uri)) {
            return new Intent("android.intent.action.VIEW", uri);
        }
        if (uri == null || !zze(uri)) {
            String valueOf = String.valueOf(uri);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 70);
            sb2.append("appIndexingUri is neither an HTTP(S) URL nor an \"android-app://\" URL: ");
            sb2.append(valueOf);
            throw new RuntimeException(sb2.toString());
        }
        List<String> pathSegments = uri.getPathSegments();
        Uri.Builder builder = new Uri.Builder();
        builder.scheme(pathSegments.get(0));
        if (pathSegments.size() > 1) {
            builder.authority(pathSegments.get(1));
            for (int i11 = 2; i11 < pathSegments.size(); i11++) {
                builder.appendPath(pathSegments.get(i11));
            }
        } else {
            String str2 = zza;
            String valueOf2 = String.valueOf(uri);
            StringBuilder sb3 = new StringBuilder(valueOf2.length() + 88);
            sb3.append("The app URI must have the format: android-app://<package_name>/<scheme>/<path>. But got ");
            sb3.append(valueOf2);
            Log.e(str2, sb3.toString());
        }
        builder.encodedQuery(uri.getEncodedQuery());
        builder.encodedFragment(uri.getEncodedFragment());
        return new Intent("android.intent.action.VIEW", builder.build());
    }

    private static void zzc(String str, Uri uri) {
        if (uri != null && zzd(uri)) {
            String host = uri.getHost();
            if (host != null && host.isEmpty()) {
                String valueOf = String.valueOf(uri);
                StringBuilder sb2 = new StringBuilder(valueOf.length() + 98);
                sb2.append("AppIndex: The web URL must have a host (follow the format http(s)://<host>/<path>). Provided URI: ");
                sb2.append(valueOf);
                throw new IllegalArgumentException(sb2.toString());
            }
        } else if (uri == null || !zze(uri)) {
            String valueOf2 = String.valueOf(uri);
            StringBuilder sb3 = new StringBuilder(valueOf2.length() + Opcodes.ARETURN);
            sb3.append("AppIndex: The URI scheme must either be 'http(s)' or 'android-app'. If the latter, it must follow the format 'android-app://<package_name>/<scheme>/<host_path>'. Provided URI: ");
            sb3.append(valueOf2);
            throw new IllegalArgumentException(sb3.toString());
        } else if (str == null || str.equals(uri.getHost())) {
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments.isEmpty() || pathSegments.get(0).isEmpty()) {
                String valueOf3 = String.valueOf(uri);
                StringBuilder sb4 = new StringBuilder(valueOf3.length() + 128);
                sb4.append("AppIndex: The app URI scheme must exist and follow the format android-app://<package_name>/<scheme>/<host_path>). Provided URI: ");
                sb4.append(valueOf3);
                throw new IllegalArgumentException(sb4.toString());
            }
        } else {
            String valueOf4 = String.valueOf(uri);
            StringBuilder sb5 = new StringBuilder(valueOf4.length() + 150);
            sb5.append("AppIndex: The android-app URI host must match the package name and follow the format android-app://<package_name>/<scheme>/<host_path>. Provided URI: ");
            sb5.append(valueOf4);
            throw new IllegalArgumentException(sb5.toString());
        }
    }

    private static boolean zzd(Uri uri) {
        String scheme = uri.getScheme();
        if (ProxyConfig.MATCH_HTTP.equals(scheme) || "https".equals(scheme)) {
            return true;
        }
        return false;
    }

    private static boolean zze(Uri uri) {
        return "android-app".equals(uri.getScheme());
    }

    private final PendingResult<Status> zzf(GoogleApiClient googleApiClient, Action action, int i11) {
        return zza(googleApiClient, zzaf.zza(action, System.currentTimeMillis(), googleApiClient.getContext().getPackageName(), i11));
    }

    public final AppIndexApi.ActionResult action(GoogleApiClient googleApiClient, Action action) {
        return new zzah(this, zzf(googleApiClient, action, 1), action);
    }

    public final PendingResult<Status> end(GoogleApiClient googleApiClient, Action action) {
        return zzf(googleApiClient, action, 2);
    }

    public final PendingResult<Status> start(GoogleApiClient googleApiClient, Action action) {
        return zzf(googleApiClient, action, 1);
    }

    public final PendingResult<Status> view(GoogleApiClient googleApiClient, Activity activity, Intent intent, String str, Uri uri, List<AppIndexApi.AppIndexingLink> list) {
        String packageName = googleApiClient.getContext().getPackageName();
        if (list != null) {
            for (AppIndexApi.AppIndexingLink appIndexingLink : list) {
                zzc((String) null, appIndexingLink.appIndexingUrl);
            }
        }
        return zza(googleApiClient, new zzx(packageName, intent, str, uri, (String) null, list, 1));
    }

    public final PendingResult<Status> viewEnd(GoogleApiClient googleApiClient, Activity activity, Intent intent) {
        String packageName = googleApiClient.getContext().getPackageName();
        zzw zzw = new zzw();
        zzw.zza(zzx.zza(packageName, intent));
        zzw.zzb(System.currentTimeMillis());
        zzw.zzc(0);
        zzw.zzf(2);
        return zza(googleApiClient, zzw.zzg());
    }

    public final PendingResult<Status> zza(GoogleApiClient googleApiClient, zzx... zzxArr) {
        return googleApiClient.enqueue(new zzag(this, googleApiClient, zzxArr));
    }

    public final PendingResult<Status> view(GoogleApiClient googleApiClient, Activity activity, Uri uri, String str, Uri uri2, List<AppIndexApi.AppIndexingLink> list) {
        String packageName = googleApiClient.getContext().getPackageName();
        zzc(packageName, uri);
        Intent zzb = zzb(packageName, uri);
        String packageName2 = googleApiClient.getContext().getPackageName();
        if (list != null) {
            for (AppIndexApi.AppIndexingLink appIndexingLink : list) {
                zzc((String) null, appIndexingLink.appIndexingUrl);
            }
        }
        return zza(googleApiClient, new zzx(packageName2, zzb, str, uri2, (String) null, list, 1));
    }

    public final PendingResult<Status> viewEnd(GoogleApiClient googleApiClient, Activity activity, Uri uri) {
        Intent zzb = zzb(googleApiClient.getContext().getPackageName(), uri);
        String packageName = googleApiClient.getContext().getPackageName();
        zzw zzw = new zzw();
        zzw.zza(zzx.zza(packageName, zzb));
        zzw.zzb(System.currentTimeMillis());
        zzw.zzc(0);
        zzw.zzf(2);
        return zza(googleApiClient, zzw.zzg());
    }
}
