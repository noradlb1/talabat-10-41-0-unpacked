package androidx.constraintlayout.core.motion.utils;

import androidx.constraintlayout.core.motion.CustomAttribute;
import androidx.constraintlayout.core.motion.CustomVariable;
import java.io.PrintStream;
import java.util.Arrays;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public class KeyFrameArray {

    public static class CustomArray {
        private static final int EMPTY = 999;

        /* renamed from: a  reason: collision with root package name */
        public int[] f10586a = new int[101];

        /* renamed from: b  reason: collision with root package name */
        public CustomAttribute[] f10587b = new CustomAttribute[101];

        /* renamed from: c  reason: collision with root package name */
        public int f10588c;

        public CustomArray() {
            clear();
        }

        public void append(int i11, CustomAttribute customAttribute) {
            if (this.f10587b[i11] != null) {
                remove(i11);
            }
            this.f10587b[i11] = customAttribute;
            int[] iArr = this.f10586a;
            int i12 = this.f10588c;
            this.f10588c = i12 + 1;
            iArr[i12] = i11;
            Arrays.sort(iArr);
        }

        public void clear() {
            Arrays.fill(this.f10586a, 999);
            Arrays.fill(this.f10587b, (Object) null);
            this.f10588c = 0;
        }

        public void dump() {
            String str;
            PrintStream printStream = System.out;
            printStream.println("V: " + Arrays.toString(Arrays.copyOf(this.f10586a, this.f10588c)));
            System.out.print("K: [");
            for (int i11 = 0; i11 < this.f10588c; i11++) {
                PrintStream printStream2 = System.out;
                StringBuilder sb2 = new StringBuilder();
                if (i11 == 0) {
                    str = "";
                } else {
                    str = IndicativeSentencesGeneration.DEFAULT_SEPARATOR;
                }
                sb2.append(str);
                sb2.append(valueAt(i11));
                printStream2.print(sb2.toString());
            }
            System.out.println("]");
        }

        public int keyAt(int i11) {
            return this.f10586a[i11];
        }

        public void remove(int i11) {
            this.f10587b[i11] = null;
            int i12 = 0;
            int i13 = 0;
            while (true) {
                int i14 = this.f10588c;
                if (i12 < i14) {
                    int[] iArr = this.f10586a;
                    if (i11 == iArr[i12]) {
                        iArr[i12] = 999;
                        i13++;
                    }
                    if (i12 != i13) {
                        iArr[i12] = iArr[i13];
                    }
                    i13++;
                    i12++;
                } else {
                    this.f10588c = i14 - 1;
                    return;
                }
            }
        }

        public int size() {
            return this.f10588c;
        }

        public CustomAttribute valueAt(int i11) {
            return this.f10587b[this.f10586a[i11]];
        }
    }

    public static class CustomVar {
        private static final int EMPTY = 999;

        /* renamed from: a  reason: collision with root package name */
        public int[] f10589a = new int[101];

        /* renamed from: b  reason: collision with root package name */
        public CustomVariable[] f10590b = new CustomVariable[101];

        /* renamed from: c  reason: collision with root package name */
        public int f10591c;

        public CustomVar() {
            clear();
        }

        public void append(int i11, CustomVariable customVariable) {
            if (this.f10590b[i11] != null) {
                remove(i11);
            }
            this.f10590b[i11] = customVariable;
            int[] iArr = this.f10589a;
            int i12 = this.f10591c;
            this.f10591c = i12 + 1;
            iArr[i12] = i11;
            Arrays.sort(iArr);
        }

        public void clear() {
            Arrays.fill(this.f10589a, 999);
            Arrays.fill(this.f10590b, (Object) null);
            this.f10591c = 0;
        }

        public void dump() {
            String str;
            PrintStream printStream = System.out;
            printStream.println("V: " + Arrays.toString(Arrays.copyOf(this.f10589a, this.f10591c)));
            System.out.print("K: [");
            for (int i11 = 0; i11 < this.f10591c; i11++) {
                PrintStream printStream2 = System.out;
                StringBuilder sb2 = new StringBuilder();
                if (i11 == 0) {
                    str = "";
                } else {
                    str = IndicativeSentencesGeneration.DEFAULT_SEPARATOR;
                }
                sb2.append(str);
                sb2.append(valueAt(i11));
                printStream2.print(sb2.toString());
            }
            System.out.println("]");
        }

        public int keyAt(int i11) {
            return this.f10589a[i11];
        }

        public void remove(int i11) {
            this.f10590b[i11] = null;
            int i12 = 0;
            int i13 = 0;
            while (true) {
                int i14 = this.f10591c;
                if (i12 < i14) {
                    int[] iArr = this.f10589a;
                    if (i11 == iArr[i12]) {
                        iArr[i12] = 999;
                        i13++;
                    }
                    if (i12 != i13) {
                        iArr[i12] = iArr[i13];
                    }
                    i13++;
                    i12++;
                } else {
                    this.f10591c = i14 - 1;
                    return;
                }
            }
        }

        public int size() {
            return this.f10591c;
        }

        public CustomVariable valueAt(int i11) {
            return this.f10590b[this.f10589a[i11]];
        }
    }

    public static class FloatArray {
        private static final int EMPTY = 999;

        /* renamed from: a  reason: collision with root package name */
        public int[] f10592a = new int[101];

        /* renamed from: b  reason: collision with root package name */
        public float[][] f10593b = new float[101][];

        /* renamed from: c  reason: collision with root package name */
        public int f10594c;

        public FloatArray() {
            clear();
        }

        public void append(int i11, float[] fArr) {
            if (this.f10593b[i11] != null) {
                remove(i11);
            }
            this.f10593b[i11] = fArr;
            int[] iArr = this.f10592a;
            int i12 = this.f10594c;
            this.f10594c = i12 + 1;
            iArr[i12] = i11;
            Arrays.sort(iArr);
        }

        public void clear() {
            Arrays.fill(this.f10592a, 999);
            Arrays.fill(this.f10593b, (Object) null);
            this.f10594c = 0;
        }

        public void dump() {
            String str;
            PrintStream printStream = System.out;
            printStream.println("V: " + Arrays.toString(Arrays.copyOf(this.f10592a, this.f10594c)));
            System.out.print("K: [");
            for (int i11 = 0; i11 < this.f10594c; i11++) {
                PrintStream printStream2 = System.out;
                StringBuilder sb2 = new StringBuilder();
                if (i11 == 0) {
                    str = "";
                } else {
                    str = IndicativeSentencesGeneration.DEFAULT_SEPARATOR;
                }
                sb2.append(str);
                sb2.append(Arrays.toString(valueAt(i11)));
                printStream2.print(sb2.toString());
            }
            System.out.println("]");
        }

        public int keyAt(int i11) {
            return this.f10592a[i11];
        }

        public void remove(int i11) {
            this.f10593b[i11] = null;
            int i12 = 0;
            int i13 = 0;
            while (true) {
                int i14 = this.f10594c;
                if (i12 < i14) {
                    int[] iArr = this.f10592a;
                    if (i11 == iArr[i12]) {
                        iArr[i12] = 999;
                        i13++;
                    }
                    if (i12 != i13) {
                        iArr[i12] = iArr[i13];
                    }
                    i13++;
                    i12++;
                } else {
                    this.f10594c = i14 - 1;
                    return;
                }
            }
        }

        public int size() {
            return this.f10594c;
        }

        public float[] valueAt(int i11) {
            return this.f10593b[this.f10592a[i11]];
        }
    }
}
