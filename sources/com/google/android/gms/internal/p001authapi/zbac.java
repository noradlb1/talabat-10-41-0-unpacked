package com.google.android.gms.internal.p001authapi;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.auth.api.identity.BeginSignInResult;
import com.google.android.gms.common.api.Status;

/* renamed from: com.google.android.gms.internal.auth-api.zbac  reason: invalid package */
public interface zbac extends IInterface {
    void zbb(Status status, BeginSignInResult beginSignInResult) throws RemoteException;
}
