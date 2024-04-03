package androidx.palette.graphics;

import android.graphics.Color;
import android.util.TimingLogger;
import androidx.annotation.Nullable;
import androidx.core.graphics.ColorUtils;
import androidx.palette.graphics.Palette;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

final class ColorCutQuantizer {
    private static final String LOG_TAG = "ColorCutQuantizer";
    private static final boolean LOG_TIMINGS = false;
    private static final int QUANTIZE_WORD_MASK = 31;
    private static final int QUANTIZE_WORD_WIDTH = 5;
    private static final Comparator<Vbox> VBOX_COMPARATOR_VOLUME = new Comparator<Vbox>() {
        public int compare(Vbox vbox, Vbox vbox2) {
            return vbox2.g() - vbox.g();
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final int[] f37269a;

    /* renamed from: b  reason: collision with root package name */
    public final int[] f37270b;

    /* renamed from: c  reason: collision with root package name */
    public final List<Palette.Swatch> f37271c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public final TimingLogger f37272d = null;

    /* renamed from: e  reason: collision with root package name */
    public final Palette.Filter[] f37273e;
    private final float[] mTempHsl = new float[3];

    public class Vbox {
        private int mLowerIndex;
        private int mMaxBlue;
        private int mMaxGreen;
        private int mMaxRed;
        private int mMinBlue;
        private int mMinGreen;
        private int mMinRed;
        private int mPopulation;
        private int mUpperIndex;

        public Vbox(int i11, int i12) {
            this.mLowerIndex = i11;
            this.mUpperIndex = i12;
            c();
        }

        public final boolean a() {
            return e() > 1;
        }

        public final int b() {
            int f11 = f();
            ColorCutQuantizer colorCutQuantizer = ColorCutQuantizer.this;
            int[] iArr = colorCutQuantizer.f37269a;
            int[] iArr2 = colorCutQuantizer.f37270b;
            ColorCutQuantizer.c(iArr, f11, this.mLowerIndex, this.mUpperIndex);
            Arrays.sort(iArr, this.mLowerIndex, this.mUpperIndex + 1);
            ColorCutQuantizer.c(iArr, f11, this.mLowerIndex, this.mUpperIndex);
            int i11 = this.mPopulation / 2;
            int i12 = this.mLowerIndex;
            int i13 = 0;
            while (true) {
                int i14 = this.mUpperIndex;
                if (i12 > i14) {
                    return this.mLowerIndex;
                }
                i13 += iArr2[iArr[i12]];
                if (i13 >= i11) {
                    return Math.min(i14 - 1, i12);
                }
                i12++;
            }
        }

        public final void c() {
            ColorCutQuantizer colorCutQuantizer = ColorCutQuantizer.this;
            int[] iArr = colorCutQuantizer.f37269a;
            int[] iArr2 = colorCutQuantizer.f37270b;
            int i11 = Integer.MAX_VALUE;
            int i12 = Integer.MIN_VALUE;
            int i13 = Integer.MIN_VALUE;
            int i14 = Integer.MIN_VALUE;
            int i15 = 0;
            int i16 = Integer.MAX_VALUE;
            int i17 = Integer.MAX_VALUE;
            for (int i18 = this.mLowerIndex; i18 <= this.mUpperIndex; i18++) {
                int i19 = iArr[i18];
                i15 += iArr2[i19];
                int f11 = ColorCutQuantizer.f(i19);
                int e11 = ColorCutQuantizer.e(i19);
                int d11 = ColorCutQuantizer.d(i19);
                if (f11 > i12) {
                    i12 = f11;
                }
                if (f11 < i11) {
                    i11 = f11;
                }
                if (e11 > i13) {
                    i13 = e11;
                }
                if (e11 < i16) {
                    i16 = e11;
                }
                if (d11 > i14) {
                    i14 = d11;
                }
                if (d11 < i17) {
                    i17 = d11;
                }
            }
            this.mMinRed = i11;
            this.mMaxRed = i12;
            this.mMinGreen = i16;
            this.mMaxGreen = i13;
            this.mMinBlue = i17;
            this.mMaxBlue = i14;
            this.mPopulation = i15;
        }

        public final Palette.Swatch d() {
            ColorCutQuantizer colorCutQuantizer = ColorCutQuantizer.this;
            int[] iArr = colorCutQuantizer.f37269a;
            int[] iArr2 = colorCutQuantizer.f37270b;
            int i11 = 0;
            int i12 = 0;
            int i13 = 0;
            int i14 = 0;
            for (int i15 = this.mLowerIndex; i15 <= this.mUpperIndex; i15++) {
                int i16 = iArr[i15];
                int i17 = iArr2[i16];
                i12 += i17;
                i11 += ColorCutQuantizer.f(i16) * i17;
                i13 += ColorCutQuantizer.e(i16) * i17;
                i14 += i17 * ColorCutQuantizer.d(i16);
            }
            float f11 = (float) i12;
            return new Palette.Swatch(ColorCutQuantizer.a(Math.round(((float) i11) / f11), Math.round(((float) i13) / f11), Math.round(((float) i14) / f11)), i12);
        }

        public final int e() {
            return (this.mUpperIndex + 1) - this.mLowerIndex;
        }

        public final int f() {
            int i11 = this.mMaxRed - this.mMinRed;
            int i12 = this.mMaxGreen - this.mMinGreen;
            int i13 = this.mMaxBlue - this.mMinBlue;
            if (i11 >= i12 && i11 >= i13) {
                return -3;
            }
            if (i12 < i11 || i12 < i13) {
                return -1;
            }
            return -2;
        }

        public final int g() {
            return ((this.mMaxRed - this.mMinRed) + 1) * ((this.mMaxGreen - this.mMinGreen) + 1) * ((this.mMaxBlue - this.mMinBlue) + 1);
        }

        public final Vbox h() {
            if (a()) {
                int b11 = b();
                Vbox vbox = new Vbox(b11 + 1, this.mUpperIndex);
                this.mUpperIndex = b11;
                c();
                return vbox;
            }
            throw new IllegalStateException("Can not split a box with only 1 color");
        }
    }

    public ColorCutQuantizer(int[] iArr, int i11, Palette.Filter[] filterArr) {
        this.f37273e = filterArr;
        int[] iArr2 = new int[32768];
        this.f37270b = iArr2;
        for (int i12 = 0; i12 < iArr.length; i12++) {
            int quantizeFromRgb888 = quantizeFromRgb888(iArr[i12]);
            iArr[i12] = quantizeFromRgb888;
            iArr2[quantizeFromRgb888] = iArr2[quantizeFromRgb888] + 1;
        }
        int i13 = 0;
        for (int i14 = 0; i14 < 32768; i14++) {
            if (iArr2[i14] > 0 && shouldIgnoreColor(i14)) {
                iArr2[i14] = 0;
            }
            if (iArr2[i14] > 0) {
                i13++;
            }
        }
        int[] iArr3 = new int[i13];
        this.f37269a = iArr3;
        int i15 = 0;
        for (int i16 = 0; i16 < 32768; i16++) {
            if (iArr2[i16] > 0) {
                iArr3[i15] = i16;
                i15++;
            }
        }
        if (i13 <= i11) {
            this.f37271c = new ArrayList();
            for (int i17 = 0; i17 < i13; i17++) {
                int i18 = iArr3[i17];
                this.f37271c.add(new Palette.Swatch(approximateToRgb888(i18), iArr2[i18]));
            }
            return;
        }
        this.f37271c = quantizePixels(i11);
    }

    public static int a(int i11, int i12, int i13) {
        return Color.rgb(modifyWordWidth(i11, 5, 8), modifyWordWidth(i12, 5, 8), modifyWordWidth(i13, 5, 8));
    }

    private static int approximateToRgb888(int i11) {
        return a(f(i11), e(i11), d(i11));
    }

    public static void c(int[] iArr, int i11, int i12, int i13) {
        if (i11 == -2) {
            while (i12 <= i13) {
                int i14 = iArr[i12];
                iArr[i12] = d(i14) | (e(i14) << 10) | (f(i14) << 5);
                i12++;
            }
        } else if (i11 == -1) {
            while (i12 <= i13) {
                int i15 = iArr[i12];
                iArr[i12] = f(i15) | (d(i15) << 10) | (e(i15) << 5);
                i12++;
            }
        }
    }

    public static int d(int i11) {
        return i11 & 31;
    }

    public static int e(int i11) {
        return (i11 >> 5) & 31;
    }

    public static int f(int i11) {
        return (i11 >> 10) & 31;
    }

    private List<Palette.Swatch> generateAverageColors(Collection<Vbox> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (Vbox d11 : collection) {
            Palette.Swatch d12 = d11.d();
            if (!shouldIgnoreColor(d12)) {
                arrayList.add(d12);
            }
        }
        return arrayList;
    }

    private static int modifyWordWidth(int i11, int i12, int i13) {
        return (i13 > i12 ? i11 << (i13 - i12) : i11 >> (i12 - i13)) & ((1 << i13) - 1);
    }

    private static int quantizeFromRgb888(int i11) {
        return modifyWordWidth(Color.blue(i11), 8, 5) | (modifyWordWidth(Color.red(i11), 8, 5) << 10) | (modifyWordWidth(Color.green(i11), 8, 5) << 5);
    }

    private List<Palette.Swatch> quantizePixels(int i11) {
        PriorityQueue priorityQueue = new PriorityQueue(i11, VBOX_COMPARATOR_VOLUME);
        priorityQueue.offer(new Vbox(0, this.f37269a.length - 1));
        splitBoxes(priorityQueue, i11);
        return generateAverageColors(priorityQueue);
    }

    private boolean shouldIgnoreColor(int i11) {
        int approximateToRgb888 = approximateToRgb888(i11);
        ColorUtils.colorToHSL(approximateToRgb888, this.mTempHsl);
        return shouldIgnoreColor(approximateToRgb888, this.mTempHsl);
    }

    private void splitBoxes(PriorityQueue<Vbox> priorityQueue, int i11) {
        Vbox poll;
        while (priorityQueue.size() < i11 && (poll = priorityQueue.poll()) != null && poll.a()) {
            priorityQueue.offer(poll.h());
            priorityQueue.offer(poll);
        }
    }

    public List<Palette.Swatch> b() {
        return this.f37271c;
    }

    private boolean shouldIgnoreColor(Palette.Swatch swatch) {
        return shouldIgnoreColor(swatch.getRgb(), swatch.getHsl());
    }

    private boolean shouldIgnoreColor(int i11, float[] fArr) {
        Palette.Filter[] filterArr = this.f37273e;
        if (filterArr != null && filterArr.length > 0) {
            int length = filterArr.length;
            for (int i12 = 0; i12 < length; i12++) {
                if (!this.f37273e[i12].isAllowed(i11, fArr)) {
                    return true;
                }
            }
        }
        return false;
    }
}
