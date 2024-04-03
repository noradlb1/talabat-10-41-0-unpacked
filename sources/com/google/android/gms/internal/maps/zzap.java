package com.google.android.gms.internal.maps;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.maps.model.Tile;
import javax.annotation.Nullable;

public interface zzap extends IInterface {
    @Nullable
    Tile zzb(int i11, int i12, int i13) throws RemoteException;
}
