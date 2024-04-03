package com.google.android.gms.internal.ads;

import android.app.DownloadManager;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Environment;
import com.google.android.gms.ads.internal.zzt;

final class zzcal implements DialogInterface.OnClickListener {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzcan zzc;

    public zzcal(zzcan zzcan, String str, String str2) {
        this.zzc = zzcan;
        this.zza = str;
        this.zzb = str2;
    }

    public final void onClick(DialogInterface dialogInterface, int i11) {
        DownloadManager downloadManager = (DownloadManager) this.zzc.zzb.getSystemService("download");
        try {
            String str = this.zza;
            String str2 = this.zzb;
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str));
            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, str2);
            zzt.zzp();
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(1);
            downloadManager.enqueue(request);
        } catch (IllegalStateException unused) {
            this.zzc.zzg("Could not store picture.");
        }
    }
}
