package com.google.firebase.appindexing.internal;

import android.os.Parcelable;
import java.util.Comparator;

final /* synthetic */ class zzab implements Comparator {
    static final Comparator zza = new zzab();

    private zzab() {
    }

    public final int compare(Object obj, Object obj2) {
        String str = (String) obj;
        String str2 = (String) obj2;
        Parcelable.Creator<Thing> creator = Thing.CREATOR;
        if (str == null) {
            if (str2 != null) {
                return -1;
            }
            return 0;
        } else if (str2 == null) {
            return 1;
        } else {
            return str.compareTo(str2);
        }
    }
}
