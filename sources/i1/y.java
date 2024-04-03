package i1;

import android.location.Location;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.location.LocationListenerCompat;
import java.util.List;

public final /* synthetic */ class y {
    public static void a(LocationListenerCompat locationListenerCompat, int i11) {
    }

    public static void b(LocationListenerCompat locationListenerCompat, @NonNull List list) {
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            locationListenerCompat.onLocationChanged((Location) list.get(i11));
        }
    }

    public static void c(LocationListenerCompat locationListenerCompat, @NonNull String str) {
    }

    public static void d(LocationListenerCompat locationListenerCompat, @NonNull String str) {
    }

    public static void e(LocationListenerCompat locationListenerCompat, @NonNull String str, int i11, @Nullable Bundle bundle) {
    }
}
