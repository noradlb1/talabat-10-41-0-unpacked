package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

final class zzk implements DynamiteModule.VersionPolicy {
    public final DynamiteModule.VersionPolicy.SelectionResult selectModule(Context context, String str, DynamiteModule.VersionPolicy.IVersions iVersions) throws DynamiteModule.LoadingException {
        DynamiteModule.VersionPolicy.SelectionResult selectionResult = new DynamiteModule.VersionPolicy.SelectionResult();
        selectionResult.localVersion = iVersions.zza(context, str);
        int zzb = iVersions.zzb(context, str, true);
        selectionResult.remoteVersion = zzb;
        int i11 = selectionResult.localVersion;
        if (i11 == 0) {
            i11 = 0;
            if (zzb == 0) {
                selectionResult.selection = 0;
                return selectionResult;
            }
        }
        if (zzb >= i11) {
            selectionResult.selection = 1;
        } else {
            selectionResult.selection = -1;
        }
        return selectionResult;
    }
}
