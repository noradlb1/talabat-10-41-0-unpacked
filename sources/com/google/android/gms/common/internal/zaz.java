package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.view.View;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

public final class zaz extends RemoteCreator {
    private static final zaz zaa = new zaz();

    private zaz() {
        super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
    }

    public static View zaa(Context context, int i11, int i12) throws RemoteCreator.RemoteCreatorException {
        zaz zaz = zaa;
        try {
            zax zax = new zax(1, i11, i12, (Scope[]) null);
            return (View) ObjectWrapper.unwrap(((zam) zaz.getRemoteCreatorInstance(context)).zae(ObjectWrapper.wrap(context), zax));
        } catch (Exception e11) {
            throw new RemoteCreator.RemoteCreatorException("Could not get button with size " + i11 + " and color " + i12, e11);
        }
    }

    public final /* synthetic */ Object getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
        if (queryLocalInterface instanceof zam) {
            return (zam) queryLocalInterface;
        }
        return new zam(iBinder);
    }
}
