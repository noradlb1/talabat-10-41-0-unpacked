package com.google.android.play.integrity.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class f extends a implements h {
    public f(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.integrity.protocol.IIntegrityService");
    }

    public final void c(Bundle bundle, j jVar) throws RemoteException {
        Parcel a11 = a();
        c.c(a11, bundle);
        c.d(a11, jVar);
        b(2, a11);
    }
}
