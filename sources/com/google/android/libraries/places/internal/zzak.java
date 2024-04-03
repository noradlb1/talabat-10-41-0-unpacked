package com.google.android.libraries.places.internal;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.android.volley.NetworkResponse;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.libraries.places.api.net.PlacesStatusCodes;
import java.util.Map;

public final class zzak {
    private final RequestQueue zza;

    public zzak(RequestQueue requestQueue) {
        this.zza = requestQueue;
    }

    public static /* synthetic */ void zza(TaskCompletionSource taskCompletionSource, VolleyError volleyError) {
        ApiException apiException;
        try {
            NetworkResponse networkResponse = volleyError.networkResponse;
            if (networkResponse != null) {
                int i11 = networkResponse.statusCode;
                if (i11 == 400) {
                    apiException = new ApiException(new Status((int) PlacesStatusCodes.INVALID_REQUEST, "The provided parameters are invalid (did you include a max width or height?)."));
                } else if (i11 == 403) {
                    apiException = new ApiException(new Status((int) PlacesStatusCodes.REQUEST_DENIED, "The provided API key is invalid."));
                }
                taskCompletionSource.trySetException(apiException);
            }
            apiException = zzy.zza(volleyError);
            taskCompletionSource.trySetException(apiException);
        } catch (Error | RuntimeException e11) {
            zzdh.zzb(e11);
            throw e11;
        }
    }

    public static /* synthetic */ void zzc(zzaz zzaz, TaskCompletionSource taskCompletionSource, Bitmap bitmap) {
        try {
            zzaz.zzb(bitmap);
            taskCompletionSource.trySetResult(zzaz.zza());
        } catch (Error | RuntimeException e11) {
            zzdh.zzb(e11);
            throw e11;
        }
    }

    public final <HttpPhotoResponseT extends zzan> Task<HttpPhotoResponseT> zzb(zzam zzam, zzaz zzaz) {
        TaskCompletionSource taskCompletionSource;
        String zzc = zzam.zzc();
        Map<String, String> zzd = zzam.zzd();
        CancellationToken zza2 = zzam.zza();
        if (zza2 != null) {
            taskCompletionSource = new TaskCompletionSource(zza2);
        } else {
            taskCompletionSource = new TaskCompletionSource();
        }
        TaskCompletionSource taskCompletionSource2 = taskCompletionSource;
        zzaj zzaj = new zzaj(this, zzc, new zzah(zzaz, taskCompletionSource2, (byte[]) null), 0, 0, ImageView.ScaleType.CENTER, Bitmap.Config.ARGB_8888, new zzag(taskCompletionSource2), zzd);
        if (zza2 != null) {
            zza2.onCanceledRequested(new zzai(zzaj));
        }
        this.zza.add(zzaj);
        return taskCompletionSource2.getTask();
    }
}
