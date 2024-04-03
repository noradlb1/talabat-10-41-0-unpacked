package com.huawei.hms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.common.parcel.ParcelReader;
import com.huawei.hms.common.parcel.ParcelWrite;

public class MapStyleOptions implements Parcelable {
    public static final Parcelable.Creator<MapStyleOptions> CREATOR = new Parcelable.Creator<MapStyleOptions>() {
        /* renamed from: a */
        public MapStyleOptions createFromParcel(Parcel parcel) {
            return new MapStyleOptions(parcel);
        }

        /* renamed from: a */
        public MapStyleOptions[] newArray(int i11) {
            return new MapStyleOptions[i11];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f49504a;

    public MapStyleOptions(Parcel parcel) {
        this.f49504a = new ParcelReader(parcel).createString(2, (String) null);
    }

    public MapStyleOptions(String str) {
        this.f49504a = str;
    }

    public static MapStyleOptions loadAssetResouceStyle(String str) {
        return new MapStyleOptions(str);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:16|17|18) */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0040, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0058, code lost:
        throw new android.content.res.Resources.NotFoundException("MapStyleOptions read resource failure: " + r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x005d, code lost:
        com.huawei.hms.maps.utils.LogM.e("MapStyleOptions", "IOException");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0064, code lost:
        com.huawei.hms.maps.utils.LogM.e("MapStyleOptions", "IOException");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0067, code lost:
        throw r7;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0042 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.huawei.hms.maps.model.MapStyleOptions loadRawResourceStyle(android.content.Context r6, int r7) {
        /*
            java.lang.String r0 = "IOException"
            java.lang.String r1 = "MapStyleOptions"
            android.content.res.Resources r6 = r6.getResources()
            java.io.InputStream r6 = r6.openRawResource(r7)
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream
            r2.<init>()
            r3 = 4096(0x1000, float:5.74E-42)
            byte[] r3 = new byte[r3]
        L_0x0015:
            int r4 = r6.read(r3)     // Catch:{ IOException -> 0x0042 }
            r5 = -1
            if (r4 == r5) goto L_0x0021
            r5 = 0
            r2.write(r3, r5, r4)     // Catch:{ IOException -> 0x0042 }
            goto L_0x0015
        L_0x0021:
            java.lang.String r3 = new java.lang.String     // Catch:{ IOException -> 0x0042 }
            byte[] r4 = r2.toByteArray()     // Catch:{ IOException -> 0x0042 }
            java.lang.String r5 = "UTF-8"
            r3.<init>(r4, r5)     // Catch:{ IOException -> 0x0042 }
            com.huawei.hms.maps.model.MapStyleOptions r4 = new com.huawei.hms.maps.model.MapStyleOptions     // Catch:{ IOException -> 0x0042 }
            r4.<init>((java.lang.String) r3)     // Catch:{ IOException -> 0x0042 }
            r6.close()     // Catch:{ IOException -> 0x0035 }
            goto L_0x0038
        L_0x0035:
            com.huawei.hms.maps.utils.LogM.e(r1, r0)
        L_0x0038:
            r2.close()     // Catch:{ IOException -> 0x003c }
            goto L_0x003f
        L_0x003c:
            com.huawei.hms.maps.utils.LogM.e(r1, r0)
        L_0x003f:
            return r4
        L_0x0040:
            r7 = move-exception
            goto L_0x0059
        L_0x0042:
            android.content.res.Resources$NotFoundException r3 = new android.content.res.Resources$NotFoundException     // Catch:{ all -> 0x0040 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0040 }
            r4.<init>()     // Catch:{ all -> 0x0040 }
            java.lang.String r5 = "MapStyleOptions read resource failure: "
            r4.append(r5)     // Catch:{ all -> 0x0040 }
            r4.append(r7)     // Catch:{ all -> 0x0040 }
            java.lang.String r7 = r4.toString()     // Catch:{ all -> 0x0040 }
            r3.<init>(r7)     // Catch:{ all -> 0x0040 }
            throw r3     // Catch:{ all -> 0x0040 }
        L_0x0059:
            r6.close()     // Catch:{ IOException -> 0x005d }
            goto L_0x0060
        L_0x005d:
            com.huawei.hms.maps.utils.LogM.e(r1, r0)
        L_0x0060:
            r2.close()     // Catch:{ IOException -> 0x0064 }
            goto L_0x0067
        L_0x0064:
            com.huawei.hms.maps.utils.LogM.e(r1, r0)
        L_0x0067:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.maps.model.MapStyleOptions.loadRawResourceStyle(android.content.Context, int):com.huawei.hms.maps.model.MapStyleOptions");
    }

    public int describeContents() {
        return 0;
    }

    public String getJson() {
        return this.f49504a;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        ParcelWrite parcelWrite = new ParcelWrite(parcel);
        int beginObjectHeader = parcelWrite.beginObjectHeader();
        parcelWrite.writeString(2, this.f49504a, false);
        parcelWrite.finishObjectHeader(beginObjectHeader);
    }
}
