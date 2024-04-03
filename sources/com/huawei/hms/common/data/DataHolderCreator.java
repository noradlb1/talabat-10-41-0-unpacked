package com.huawei.hms.common.data;

import android.os.Parcelable;

public final class DataHolderCreator implements Parcelable.Creator<DataHolder> {
    /* JADX WARNING: type inference failed for: r2v4, types: [java.lang.Object[]] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.huawei.hms.common.data.DataHolder createFromParcel(android.os.Parcel r11) {
        /*
            r10 = this;
            int r0 = com.huawei.hms.common.internal.safeparcel.SafeParcelReader.validateObjectHeader(r11)
            r1 = 0
            r2 = 0
            r3 = r1
            r6 = r3
            r4 = r2
            r5 = r4
            r7 = r5
        L_0x000b:
            if (r1 > r0) goto L_0x004f
            int r2 = r11.dataPosition()
            if (r2 >= r0) goto L_0x004f
            int r1 = r1 + 1
            int r2 = com.huawei.hms.common.internal.safeparcel.SafeParcelReader.readHeader(r11)
            int r8 = com.huawei.hms.common.internal.safeparcel.SafeParcelReader.getFieldId(r2)
            r9 = 1000(0x3e8, float:1.401E-42)
            if (r8 == r9) goto L_0x004a
            r9 = 1
            if (r8 == r9) goto L_0x0045
            r9 = 2
            if (r8 == r9) goto L_0x003b
            r9 = 3
            if (r8 == r9) goto L_0x0036
            r9 = 4
            if (r8 == r9) goto L_0x0031
            com.huawei.hms.common.internal.safeparcel.SafeParcelReader.skipUnknownField(r11, r2)
            goto L_0x000b
        L_0x0031:
            android.os.Bundle r7 = com.huawei.hms.common.internal.safeparcel.SafeParcelReader.createBundle(r11, r2)
            goto L_0x000b
        L_0x0036:
            int r6 = com.huawei.hms.common.internal.safeparcel.SafeParcelReader.readInt(r11, r2)
            goto L_0x000b
        L_0x003b:
            android.os.Parcelable$Creator r5 = android.database.CursorWindow.CREATOR
            java.lang.Object[] r2 = com.huawei.hms.common.internal.safeparcel.SafeParcelReader.createTypedArray(r11, r2, r5)
            r5 = r2
            android.database.CursorWindow[] r5 = (android.database.CursorWindow[]) r5
            goto L_0x000b
        L_0x0045:
            java.lang.String[] r4 = com.huawei.hms.common.internal.safeparcel.SafeParcelReader.createStringArray(r11, r2)
            goto L_0x000b
        L_0x004a:
            int r3 = com.huawei.hms.common.internal.safeparcel.SafeParcelReader.readInt(r11, r2)
            goto L_0x000b
        L_0x004f:
            com.huawei.hms.common.internal.safeparcel.SafeParcelReader.ensureAtEnd(r11, r0)
            com.huawei.hms.common.data.DataHolder r11 = new com.huawei.hms.common.data.DataHolder
            r2 = r11
            r2.<init>((int) r3, (java.lang.String[]) r4, (android.database.CursorWindow[]) r5, (int) r6, (android.os.Bundle) r7)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.common.data.DataHolderCreator.createFromParcel(android.os.Parcel):com.huawei.hms.common.data.DataHolder");
    }

    public final DataHolder[] newArray(int i11) {
        return new DataHolder[i11];
    }
}
