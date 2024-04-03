package com.google.android.gms.internal.p001authapi;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.identity.AuthorizationResult;
import com.google.android.gms.common.api.Status;

/* renamed from: com.google.android.gms.internal.auth-api.zby  reason: invalid package */
public abstract class zby extends zbb implements zbz {
    public zby() {
        super("com.google.android.gms.auth.api.identity.internal.IAuthorizationCallback");
    }

    public final boolean zba(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
        if (i11 != 1) {
            return false;
        }
        zbc.zbb(parcel);
        zbb((Status) zbc.zba(parcel, Status.CREATOR), (AuthorizationResult) zbc.zba(parcel, AuthorizationResult.CREATOR));
        return true;
    }
}
