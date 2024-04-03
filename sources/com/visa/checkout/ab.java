package com.visa.checkout;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONException;
import org.json.JSONObject;

final class ab implements Parcelable {
    public static final Parcelable.Creator<ab> CREATOR = new Parcelable.Creator<ab>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new ab(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i11) {
            return new ab[i11];
        }
    };

    /* renamed from: ʻ  reason: contains not printable characters */
    private static char[] f137 = {355, 350, 360, 347, 359, 351, 366};

    /* renamed from: ʼ  reason: contains not printable characters */
    private static boolean f138 = true;

    /* renamed from: ʽ  reason: contains not printable characters */
    private static int f139 = 0;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private static int f140 = 1;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private static int f141 = 250;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private static boolean f142 = true;

    /* renamed from: ˊ  reason: contains not printable characters */
    private String f143;

    /* renamed from: ˋ  reason: contains not printable characters */
    private JSONObject f144;

    /* renamed from: ˎ  reason: contains not printable characters */
    private Object f145;

    /* renamed from: ˏ  reason: contains not printable characters */
    private String f146;

    /* renamed from: ॱ  reason: contains not printable characters */
    private String f147;

    static {
        int i11 = f140 + 17;
        f139 = i11 % 128;
        int i12 = i11 % 2;
    }

    public ab(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        this.f146 = jSONObject.getString(m6110(127, (String) null, (int[]) null, "").intern());
        this.f143 = jSONObject.getString(m6110(127, (String) null, (int[]) null, "").intern());
        if (jSONObject.has(m6110(127, (String) null, (int[]) null, "").intern())) {
            this.f145 = jSONObject.get(m6110(127, (String) null, (int[]) null, "").intern());
        }
        this.f144 = jSONObject;
        this.f147 = str;
    }

    public final int describeContents() {
        int i11 = f140 + 69;
        int i12 = i11 % 128;
        f139 = i12;
        int i13 = i11 % 2;
        int i14 = i12 + 33;
        f140 = i14 % 128;
        if ((i14 % 2 == 0 ? '/' : 'Q') == 'Q') {
            return 0;
        }
        throw null;
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        int i12 = f139 + 101;
        f140 = i12 % 128;
        int i13 = i12 % 2;
        parcel.writeString(this.f147);
        int i14 = f139 + 59;
        f140 = i14 % 128;
        int i15 = i14 % 2;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final String m6111() {
        int i11 = f140 + 51;
        int i12 = i11 % 128;
        f139 = i12;
        int i13 = i11 % 2;
        String str = this.f147;
        int i14 = i12 + 45;
        f140 = i14 % 128;
        int i15 = i14 % 2;
        return str;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public final Object m6113() {
        int i11 = f139 + 19;
        int i12 = i11 % 128;
        f140 = i12;
        if (!(i11 % 2 == 0)) {
            Object obj = this.f145;
            int i13 = i12 + 111;
            f139 = i13 % 128;
            if ((i13 % 2 != 0 ? 22 : '>') == '>') {
                return obj;
            }
            throw null;
        }
        throw null;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final String m6115() {
        int i11 = f140 + 19;
        int i12 = i11 % 128;
        f139 = i12;
        int i13 = i11 % 2;
        String str = this.f146;
        int i14 = i12 + 55;
        f140 = i14 % 128;
        int i15 = i14 % 2;
        return str;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public final String m6116() {
        int i11 = f139 + 55;
        f140 = i11 % 128;
        if (!(i11 % 2 == 0)) {
            return this.f143;
        }
        throw null;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final String m6112(String str) throws Exception {
        int i11 = f140 + 55;
        f139 = i11 % 128;
        int i12 = i11 % 2;
        String string = this.f144.getString(str);
        int i13 = f139 + 59;
        f140 = i13 % 128;
        int i14 = i13 % 2;
        return string;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public final JSONObject m6114(String str) throws Exception {
        int i11 = f140 + 77;
        f139 = i11 % 128;
        if (!(i11 % 2 != 0)) {
            JSONObject jSONObject = this.f144.getJSONObject(str);
            int i12 = f140 + 123;
            f139 = i12 % 128;
            int i13 = i12 % 2;
            return jSONObject;
        }
        this.f144.getJSONObject(str);
        throw null;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public final JSONObject m6117(String str) {
        JSONObject jSONObject;
        int i11 = f139 + 117;
        f140 = i11 % 128;
        if (!(i11 % 2 == 0 ? true : true)) {
            jSONObject = this.f144.optJSONObject(str);
            int i12 = 71 / 0;
        } else {
            jSONObject = this.f144.optJSONObject(str);
        }
        int i13 = f140 + 25;
        f139 = i13 % 128;
        int i14 = i13 % 2;
        return jSONObject;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v13, resolved type: char[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v8, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v14, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v15, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v9, resolved type: java.lang.String} */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: ˋ  reason: contains not printable characters */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String m6110(int r6, java.lang.String r7, int[] r8, java.lang.String r9) {
        /*
            int r0 = f140
            int r0 = r0 + 31
            int r1 = r0 % 128
            f139 = r1
            r1 = 2
            int r0 = r0 % r1
            r0 = 0
            r2 = 1
            if (r9 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0011
        L_0x0010:
            r3 = r0
        L_0x0011:
            if (r3 == 0) goto L_0x0019
            java.lang.String r3 = "ISO-8859-1"
            byte[] r9 = r9.getBytes(r3)
        L_0x0019:
            byte[] r9 = (byte[]) r9
            if (r7 == 0) goto L_0x002a
            int r3 = f140
            int r3 = r3 + 47
            int r4 = r3 % 128
            f139 = r4
            int r3 = r3 % r1
            char[] r7 = r7.toCharArray()
        L_0x002a:
            char[] r7 = (char[]) r7
            char[] r3 = f137
            int r4 = f141
            boolean r5 = f138
            if (r5 == 0) goto L_0x006b
            int r7 = f140
            int r7 = r7 + 77
            int r8 = r7 % 128
            f139 = r8
            int r7 = r7 % r1
            if (r7 == 0) goto L_0x0041
            r7 = r2
            goto L_0x0042
        L_0x0041:
            r7 = r0
        L_0x0042:
            if (r7 == 0) goto L_0x0049
            int r7 = r9.length
            char[] r8 = new char[r7]
            r0 = r2
            goto L_0x004c
        L_0x0049:
            int r7 = r9.length
            char[] r8 = new char[r7]
        L_0x004c:
            r1 = 29
            if (r0 >= r7) goto L_0x0052
            r2 = r1
            goto L_0x0054
        L_0x0052:
            r2 = 30
        L_0x0054:
            if (r2 == r1) goto L_0x005c
            java.lang.String r6 = new java.lang.String
            r6.<init>(r8)
            return r6
        L_0x005c:
            int r1 = r7 + -1
            int r1 = r1 - r0
            byte r1 = r9[r1]
            int r1 = r1 + r6
            char r1 = r3[r1]
            int r1 = r1 - r4
            char r1 = (char) r1
            r8[r0] = r1
            int r0 = r0 + 1
            goto L_0x004c
        L_0x006b:
            boolean r9 = f142
            if (r9 == 0) goto L_0x00a2
            int r8 = f140
            int r8 = r8 + 45
            int r9 = r8 % 128
            f139 = r9
            int r8 = r8 % r1
            r9 = 14
            if (r8 == 0) goto L_0x007e
            r8 = r9
            goto L_0x007f
        L_0x007e:
            r8 = r1
        L_0x007f:
            int r8 = r7.length
            char[] r9 = new char[r8]
        L_0x0082:
            if (r0 >= r8) goto L_0x009c
            int r2 = f139
            int r2 = r2 + 115
            int r5 = r2 % 128
            f140 = r5
            int r2 = r2 % r1
            int r2 = r8 + -1
            int r2 = r2 - r0
            char r2 = r7[r2]
            int r2 = r2 - r6
            char r2 = r3[r2]
            int r2 = r2 - r4
            char r2 = (char) r2
            r9[r0] = r2
            int r0 = r0 + 1
            goto L_0x0082
        L_0x009c:
            java.lang.String r6 = new java.lang.String
            r6.<init>(r9)
            return r6
        L_0x00a2:
            int r7 = r8.length
            char[] r9 = new char[r7]
        L_0x00a5:
            if (r0 >= r7) goto L_0x00b6
            int r1 = r7 + -1
            int r1 = r1 - r0
            r1 = r8[r1]
            int r1 = r1 - r6
            char r1 = r3[r1]
            int r1 = r1 - r4
            char r1 = (char) r1
            r9[r0] = r1
            int r0 = r0 + 1
            goto L_0x00a5
        L_0x00b6:
            java.lang.String r6 = new java.lang.String
            r6.<init>(r9)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.visa.checkout.ab.m6110(int, java.lang.String, int[], java.lang.String):java.lang.String");
    }

    public ab(Parcel parcel) {
        this.f147 = parcel.readString();
    }
}
