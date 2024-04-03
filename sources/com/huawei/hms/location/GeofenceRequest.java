package com.huawei.hms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.api.entity.location.fence.GeofenceEntity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class GeofenceRequest implements Parcelable, IMessageEntity {
    private static final int CONVERSIONS_MAX = 7;
    private static final int CONVERSIONS_MIN = 0;
    public static final int COORDINATE_TYPE_GCJ_02 = 0;
    public static final int COORDINATE_TYPE_WGS_84 = 1;
    public static final Parcelable.Creator<GeofenceRequest> CREATOR = new yn();
    public static final int DWELL_INIT_CONVERSION = 4;
    public static final int ENTER_INIT_CONVERSION = 1;
    public static final int EXIT_INIT_CONVERSION = 2;
    @Packed
    private int coordinateType;
    @Packed
    private List<GeofenceEntity> geofenceList;
    @Packed
    private int initConversions;

    public static final class Builder {
        private int coordinateType = 1;
        private final List<GeofenceEntity> geofenceList = new ArrayList();
        private int initConversions = 5;

        public GeofenceRequest build() {
            Preconditions.checkArgument(!this.geofenceList.isEmpty(), "No geofence has been added.");
            int i11 = this.coordinateType;
            if (!(i11 == 0 || i11 == 1)) {
                this.coordinateType = 1;
            }
            HashSet hashSet = new HashSet();
            for (GeofenceEntity uniqueId : this.geofenceList) {
                hashSet.add(uniqueId.getUniqueId());
            }
            if (hashSet.size() == this.geofenceList.size()) {
                int i12 = this.initConversions;
                if (i12 <= 7 && i12 >= 0) {
                    return new GeofenceRequest(this.geofenceList, i12, this.coordinateType);
                }
                throw new IllegalArgumentException("invalid initConversions");
            }
            throw new IllegalArgumentException("more than one geofence has same requestId.");
        }

        public Builder createGeofence(Geofence geofence) {
            Preconditions.checkNotNull(geofence, "geofence can't be null.");
            Preconditions.checkArgument(geofence instanceof GeofenceEntity, "Geofence must be instanceof GeofenceEntity");
            this.geofenceList.add((GeofenceEntity) geofence);
            return this;
        }

        public Builder createGeofenceList(List<Geofence> list) {
            if (list != null && !list.isEmpty()) {
                for (Geofence next : list) {
                    if (next != null) {
                        createGeofence(next);
                    }
                }
            }
            return this;
        }

        public Builder setCoordinateType(int i11) {
            this.coordinateType = i11;
            return this;
        }

        public Builder setInitConversions(int i11) {
            this.initConversions = i11;
            return this;
        }
    }

    public static class yn implements Parcelable.Creator<GeofenceRequest> {
        public Object createFromParcel(Parcel parcel) {
            return new GeofenceRequest(parcel, (yn) null);
        }

        public Object[] newArray(int i11) {
            return new GeofenceRequest[i11];
        }
    }

    public GeofenceRequest() {
    }

    private GeofenceRequest(Parcel parcel) {
        this.geofenceList = parcel.createTypedArrayList(GeofenceEntity.CREATOR);
        this.initConversions = parcel.readInt();
        this.coordinateType = parcel.readInt();
    }

    public /* synthetic */ GeofenceRequest(Parcel parcel, yn ynVar) {
        this(parcel);
    }

    public GeofenceRequest(List<GeofenceEntity> list, int i11, int i12) {
        this.geofenceList = list;
        this.initConversions = i11;
        this.coordinateType = i12;
    }

    public int describeContents() {
        return 0;
    }

    public int getCoordinateType() {
        return this.coordinateType;
    }

    public List<Geofence> getGeofences() {
        return this.geofenceList == null ? new ArrayList() : new ArrayList(this.geofenceList);
    }

    public int getInitConversions() {
        return this.initConversions;
    }

    public String toString() {
        return "GeofenceRequest{geofenceList=" + this.geofenceList + ", initConversions=" + this.initConversions + ", coordinateType=" + this.coordinateType + AbstractJsonLexerKt.END_OBJ;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeTypedList(this.geofenceList);
        parcel.writeInt(this.initConversions);
        parcel.writeInt(this.coordinateType);
    }
}
