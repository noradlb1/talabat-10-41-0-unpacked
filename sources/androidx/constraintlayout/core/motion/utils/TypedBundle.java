package androidx.constraintlayout.core.motion.utils;

import java.util.Arrays;

public class TypedBundle {
    private static final int INITIAL_BOOLEAN = 4;
    private static final int INITIAL_FLOAT = 10;
    private static final int INITIAL_INT = 10;
    private static final int INITIAL_STRING = 5;

    /* renamed from: a  reason: collision with root package name */
    public int[] f10640a = new int[10];

    /* renamed from: b  reason: collision with root package name */
    public int[] f10641b = new int[10];

    /* renamed from: c  reason: collision with root package name */
    public int f10642c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int[] f10643d = new int[10];

    /* renamed from: e  reason: collision with root package name */
    public float[] f10644e = new float[10];

    /* renamed from: f  reason: collision with root package name */
    public int f10645f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int[] f10646g = new int[5];

    /* renamed from: h  reason: collision with root package name */
    public String[] f10647h = new String[5];

    /* renamed from: i  reason: collision with root package name */
    public int f10648i = 0;

    /* renamed from: j  reason: collision with root package name */
    public int[] f10649j = new int[4];

    /* renamed from: k  reason: collision with root package name */
    public boolean[] f10650k = new boolean[4];

    /* renamed from: l  reason: collision with root package name */
    public int f10651l = 0;

    public void add(int i11, int i12) {
        int i13 = this.f10642c;
        int[] iArr = this.f10640a;
        if (i13 >= iArr.length) {
            this.f10640a = Arrays.copyOf(iArr, iArr.length * 2);
            int[] iArr2 = this.f10641b;
            this.f10641b = Arrays.copyOf(iArr2, iArr2.length * 2);
        }
        int[] iArr3 = this.f10640a;
        int i14 = this.f10642c;
        iArr3[i14] = i11;
        int[] iArr4 = this.f10641b;
        this.f10642c = i14 + 1;
        iArr4[i14] = i12;
    }

    public void addIfNotNull(int i11, String str) {
        if (str != null) {
            add(i11, str);
        }
    }

    public void applyDelta(TypedValues typedValues) {
        for (int i11 = 0; i11 < this.f10642c; i11++) {
            typedValues.setValue(this.f10640a[i11], this.f10641b[i11]);
        }
        for (int i12 = 0; i12 < this.f10645f; i12++) {
            typedValues.setValue(this.f10643d[i12], this.f10644e[i12]);
        }
        for (int i13 = 0; i13 < this.f10648i; i13++) {
            typedValues.setValue(this.f10646g[i13], this.f10647h[i13]);
        }
        for (int i14 = 0; i14 < this.f10651l; i14++) {
            typedValues.setValue(this.f10649j[i14], this.f10650k[i14]);
        }
    }

    public void clear() {
        this.f10651l = 0;
        this.f10648i = 0;
        this.f10645f = 0;
        this.f10642c = 0;
    }

    public int getInteger(int i11) {
        for (int i12 = 0; i12 < this.f10642c; i12++) {
            if (this.f10640a[i12] == i11) {
                return this.f10641b[i12];
            }
        }
        return -1;
    }

    public void add(int i11, float f11) {
        int i12 = this.f10645f;
        int[] iArr = this.f10643d;
        if (i12 >= iArr.length) {
            this.f10643d = Arrays.copyOf(iArr, iArr.length * 2);
            float[] fArr = this.f10644e;
            this.f10644e = Arrays.copyOf(fArr, fArr.length * 2);
        }
        int[] iArr2 = this.f10643d;
        int i13 = this.f10645f;
        iArr2[i13] = i11;
        float[] fArr2 = this.f10644e;
        this.f10645f = i13 + 1;
        fArr2[i13] = f11;
    }

    public void applyDelta(TypedBundle typedBundle) {
        for (int i11 = 0; i11 < this.f10642c; i11++) {
            typedBundle.add(this.f10640a[i11], this.f10641b[i11]);
        }
        for (int i12 = 0; i12 < this.f10645f; i12++) {
            typedBundle.add(this.f10643d[i12], this.f10644e[i12]);
        }
        for (int i13 = 0; i13 < this.f10648i; i13++) {
            typedBundle.add(this.f10646g[i13], this.f10647h[i13]);
        }
        for (int i14 = 0; i14 < this.f10651l; i14++) {
            typedBundle.add(this.f10649j[i14], this.f10650k[i14]);
        }
    }

    public void add(int i11, String str) {
        int i12 = this.f10648i;
        int[] iArr = this.f10646g;
        if (i12 >= iArr.length) {
            this.f10646g = Arrays.copyOf(iArr, iArr.length * 2);
            String[] strArr = this.f10647h;
            this.f10647h = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
        }
        int[] iArr2 = this.f10646g;
        int i13 = this.f10648i;
        iArr2[i13] = i11;
        String[] strArr2 = this.f10647h;
        this.f10648i = i13 + 1;
        strArr2[i13] = str;
    }

    public void add(int i11, boolean z11) {
        int i12 = this.f10651l;
        int[] iArr = this.f10649j;
        if (i12 >= iArr.length) {
            this.f10649j = Arrays.copyOf(iArr, iArr.length * 2);
            boolean[] zArr = this.f10650k;
            this.f10650k = Arrays.copyOf(zArr, zArr.length * 2);
        }
        int[] iArr2 = this.f10649j;
        int i13 = this.f10651l;
        iArr2[i13] = i11;
        boolean[] zArr2 = this.f10650k;
        this.f10651l = i13 + 1;
        zArr2[i13] = z11;
    }
}
