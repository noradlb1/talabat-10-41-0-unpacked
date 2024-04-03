package com.instabug.library.util.memory.predicate;

import android.graphics.Bitmap;
import androidx.annotation.Size;
import io.reactivex.annotations.Nullable;
import java.util.Arrays;

public class BitmapMemoryAvailablePredicate extends MemoryAvailablePredicate {
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final Bitmap.Config f52073b;
    @Size(2)

    /* renamed from: c  reason: collision with root package name */
    private final int[] f52074c;

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f52075a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                android.graphics.Bitmap$Config[] r0 = android.graphics.Bitmap.Config.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f52075a = r0
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ALPHA_8     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f52075a     // Catch:{ NoSuchFieldError -> 0x001d }
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.RGB_565     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f52075a     // Catch:{ NoSuchFieldError -> 0x0028 }
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ARGB_4444     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f52075a     // Catch:{ NoSuchFieldError -> 0x0033 }
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ARGB_8888     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f52075a     // Catch:{ NoSuchFieldError -> 0x0040 }
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.RGBA_F16     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.util.memory.predicate.BitmapMemoryAvailablePredicate.a.<clinit>():void");
        }
    }

    public BitmapMemoryAvailablePredicate(@Nullable Bitmap.Config config, @Size(2) int[] iArr) {
        this.f52073b = config;
        this.f52074c = Arrays.copyOf(iArr, 2);
    }

    private int b() {
        Bitmap.Config config = this.f52073b;
        if (config == null) {
            return 8;
        }
        int i11 = a.f52075a[config.ordinal()];
        int i12 = 1;
        if (i11 != 1) {
            i12 = 2;
            if (!(i11 == 2 || i11 == 3)) {
                i12 = 4;
                if (i11 != 4) {
                    return 8;
                }
            }
        }
        return i12;
    }

    public boolean check() {
        int[] iArr = this.f52074c;
        return b((long) (iArr[0] * iArr[1] * b()));
    }
}
