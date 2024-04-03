package com.google.android.gms.location.places.internal;

import android.os.Parcelable;

public final class zzag implements Parcelable.Creator<PlaceEntity> {
    /* JADX WARNING: type inference failed for: r2v3, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r2v4, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r2v5, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r2v6, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r2v7, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object createFromParcel(android.os.Parcel r24) {
        /*
            r23 = this;
            r0 = r24
            int r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.validateObjectHeader(r24)
            r2 = 0
            r3 = 0
            r4 = 0
            r6 = r2
            r7 = r6
            r8 = r7
            r9 = r8
            r10 = r9
            r11 = r10
            r12 = r11
            r14 = r12
            r15 = r14
            r16 = r15
            r20 = r16
            r21 = r20
            r22 = r21
            r13 = r3
            r18 = r13
            r17 = r4
            r19 = r17
        L_0x0021:
            int r2 = r24.dataPosition()
            if (r2 >= r1) goto L_0x00a9
            int r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readHeader(r24)
            int r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.getFieldId(r2)
            switch(r3) {
                case 1: goto L_0x00a3;
                case 2: goto L_0x0032;
                case 3: goto L_0x0032;
                case 4: goto L_0x0098;
                case 5: goto L_0x0093;
                case 6: goto L_0x0089;
                case 7: goto L_0x0084;
                case 8: goto L_0x0079;
                case 9: goto L_0x0074;
                case 10: goto L_0x006f;
                case 11: goto L_0x006a;
                case 12: goto L_0x0032;
                case 13: goto L_0x0032;
                case 14: goto L_0x0065;
                case 15: goto L_0x0060;
                case 16: goto L_0x0032;
                case 17: goto L_0x005b;
                case 18: goto L_0x0032;
                case 19: goto L_0x0056;
                case 20: goto L_0x0051;
                case 21: goto L_0x0046;
                case 22: goto L_0x003b;
                case 23: goto L_0x0036;
                default: goto L_0x0032;
            }
        L_0x0032:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.skipUnknownField(r0, r2)
            goto L_0x0021
        L_0x0036:
            java.lang.String r22 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x0021
        L_0x003b:
            android.os.Parcelable$Creator<com.google.android.gms.location.places.internal.zzai> r3 = com.google.android.gms.location.places.internal.zzai.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r21 = r2
            com.google.android.gms.location.places.internal.zzai r21 = (com.google.android.gms.location.places.internal.zzai) r21
            goto L_0x0021
        L_0x0046:
            android.os.Parcelable$Creator<com.google.android.gms.location.places.internal.zzal> r3 = com.google.android.gms.location.places.internal.zzal.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r20 = r2
            com.google.android.gms.location.places.internal.zzal r20 = (com.google.android.gms.location.places.internal.zzal) r20
            goto L_0x0021
        L_0x0051:
            java.util.ArrayList r7 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createIntegerList(r0, r2)
            goto L_0x0021
        L_0x0056:
            java.lang.String r8 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x0021
        L_0x005b:
            java.util.ArrayList r11 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createStringList(r0, r2)
            goto L_0x0021
        L_0x0060:
            java.lang.String r10 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x0021
        L_0x0065:
            java.lang.String r9 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x0021
        L_0x006a:
            int r19 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r0, r2)
            goto L_0x0021
        L_0x006f:
            float r18 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readFloat(r0, r2)
            goto L_0x0021
        L_0x0074:
            boolean r17 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readBoolean(r0, r2)
            goto L_0x0021
        L_0x0079:
            android.os.Parcelable$Creator r3 = android.net.Uri.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r16 = r2
            android.net.Uri r16 = (android.net.Uri) r16
            goto L_0x0021
        L_0x0084:
            java.lang.String r15 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x0021
        L_0x0089:
            android.os.Parcelable$Creator<com.google.android.gms.maps.model.LatLngBounds> r3 = com.google.android.gms.maps.model.LatLngBounds.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r14 = r2
            com.google.android.gms.maps.model.LatLngBounds r14 = (com.google.android.gms.maps.model.LatLngBounds) r14
            goto L_0x0021
        L_0x0093:
            float r13 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readFloat(r0, r2)
            goto L_0x0021
        L_0x0098:
            android.os.Parcelable$Creator<com.google.android.gms.maps.model.LatLng> r3 = com.google.android.gms.maps.model.LatLng.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r12 = r2
            com.google.android.gms.maps.model.LatLng r12 = (com.google.android.gms.maps.model.LatLng) r12
            goto L_0x0021
        L_0x00a3:
            java.lang.String r6 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x0021
        L_0x00a9:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ensureAtEnd(r0, r1)
            com.google.android.gms.location.places.internal.PlaceEntity r0 = new com.google.android.gms.location.places.internal.PlaceEntity
            r5 = r0
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.location.places.internal.zzag.createFromParcel(android.os.Parcel):java.lang.Object");
    }

    public final /* synthetic */ Object[] newArray(int i11) {
        return new PlaceEntity[i11];
    }
}
