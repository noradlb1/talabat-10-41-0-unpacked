package com.google.android.exoplayer2.text;

import android.os.Bundle;
import android.os.Parcel;
import com.apptimize.c;
import com.google.android.exoplayer2.util.BundleableUtil;
import java.util.ArrayList;
import java.util.List;

public final class CueEncoder {
    public byte[] encode(List<Cue> list) {
        ArrayList<Bundle> bundleArrayList = BundleableUtil.toBundleArrayList(list);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(c.f41585a, bundleArrayList);
        Parcel obtain = Parcel.obtain();
        obtain.writeBundle(bundle);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        return marshall;
    }
}
