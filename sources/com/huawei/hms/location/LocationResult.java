package com.huawei.hms.location;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.api.location.common.LocationJsonUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class LocationResult implements Parcelable, IMessageEntity {
    public static final Parcelable.Creator<LocationResult> CREATOR = new yn();
    private static final String EXTRA_KEY = "com.huawei.hms.location.EXTRA_LOCATION_RESULT";
    private static final String TAG = "LocationResult";
    @Packed
    private List<HWLocation> locations;

    public static class yn implements Parcelable.Creator<LocationResult> {
        public Object createFromParcel(Parcel parcel) {
            return new LocationResult(parcel);
        }

        public Object[] newArray(int i11) {
            return new LocationResult[i11];
        }
    }

    public LocationResult(Parcel parcel) {
        this.locations = parcel.createTypedArrayList(HWLocation.CREATOR);
    }

    public LocationResult(List<HWLocation> list) {
        this.locations = list;
    }

    public static LocationResult create(List<HWLocation> list) {
        return new LocationResult(list);
    }

    public static LocationResult extractResult(Intent intent) {
        if (intent == null) {
            return null;
        }
        try {
            if (!intent.hasExtra(EXTRA_KEY)) {
                return null;
            }
            Parcelable parcelableExtra = intent.getParcelableExtra(EXTRA_KEY);
            if (!(parcelableExtra instanceof LocationResult)) {
                if (!(parcelableExtra instanceof Bundle)) {
                    return null;
                }
                Bundle bundle = (Bundle) parcelableExtra;
                if (bundle.getParcelable(EXTRA_KEY) == null) {
                    return null;
                }
                parcelableExtra = bundle.getParcelable(EXTRA_KEY);
            }
            return (LocationResult) parcelableExtra;
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean hasResult(Intent intent) {
        if (intent != null) {
            try {
                if (intent.hasExtra(EXTRA_KEY)) {
                    return true;
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.locations, ((LocationResult) obj).locations);
    }

    public final List<HWLocation> getHWLocationList() {
        return this.locations;
    }

    public final HWLocation getLastHWLocation() {
        int size = this.locations.size();
        if (size == 0) {
            return null;
        }
        return this.locations.get(size - 1);
    }

    public final Location getLastLocation() {
        int size = this.locations.size();
        if (size == 0) {
            return null;
        }
        return LocationJsonUtil.convertLocation(this.locations.get(size - 1));
    }

    public final List<Location> getLocations() {
        ArrayList arrayList = new ArrayList();
        for (HWLocation convertLocation : this.locations) {
            Location convertLocation2 = LocationJsonUtil.convertLocation(convertLocation);
            if (convertLocation2 != null) {
                arrayList.add(convertLocation2);
            }
        }
        return arrayList;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.locations});
    }

    public String toString() {
        return "LocationResult{locations=" + this.locations + AbstractJsonLexerKt.END_OBJ;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeTypedList(this.locations);
    }
}
