package androidx.test.core.os;

import android.os.Parcel;
import android.os.Parcelable;

public final class Parcelables {
    private Parcelables() {
    }

    public static <T extends Parcelable> T forceParcel(T t11, Parcelable.Creator<T> creator) {
        Parcel obtain = Parcel.obtain();
        try {
            t11.writeToParcel(obtain, 0);
            obtain.setDataPosition(0);
            return (Parcelable) creator.createFromParcel(obtain);
        } finally {
            obtain.recycle();
        }
    }
}
