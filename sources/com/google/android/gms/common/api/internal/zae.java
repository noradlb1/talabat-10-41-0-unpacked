package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.Preconditions;

public final class zae extends zai {
    protected final BaseImplementation.ApiMethodImpl zaa;

    public zae(int i11, BaseImplementation.ApiMethodImpl apiMethodImpl) {
        super(i11);
        this.zaa = (BaseImplementation.ApiMethodImpl) Preconditions.checkNotNull(apiMethodImpl, "Null methods are not runnable.");
    }

    public final void zad(@NonNull Status status) {
        try {
            this.zaa.setFailedResult(status);
        } catch (IllegalStateException e11) {
            Log.w("ApiCallRunner", "Exception reporting failure", e11);
        }
    }

    public final void zae(@NonNull Exception exc) {
        String simpleName = exc.getClass().getSimpleName();
        String localizedMessage = exc.getLocalizedMessage();
        try {
            this.zaa.setFailedResult(new Status(10, simpleName + ": " + localizedMessage));
        } catch (IllegalStateException e11) {
            Log.w("ApiCallRunner", "Exception reporting failure", e11);
        }
    }

    public final void zaf(zabq zabq) throws DeadObjectException {
        try {
            this.zaa.run(zabq.zaf());
        } catch (RuntimeException e11) {
            zae(e11);
        }
    }

    public final void zag(@NonNull zaad zaad, boolean z11) {
        zaad.zac(this.zaa, z11);
    }
}
