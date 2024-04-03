package e0;

import androidx.compose.ui.graphics.ImageBitmap;

public final /* synthetic */ class d1 {
    static {
        ImageBitmap.Companion companion = ImageBitmap.Companion;
    }

    public static /* synthetic */ void a(ImageBitmap imageBitmap, int[] iArr, int i11, int i12, int i13, int i14, int i15, int i16, int i17, Object obj) {
        int i18;
        int i19;
        int i21;
        int i22;
        int i23;
        if (obj == null) {
            int i24 = 0;
            if ((i17 & 2) != 0) {
                i18 = 0;
            } else {
                i18 = i11;
            }
            if ((i17 & 4) != 0) {
                i19 = 0;
            } else {
                i19 = i12;
            }
            if ((i17 & 8) != 0) {
                i21 = imageBitmap.getWidth();
            } else {
                i21 = i13;
            }
            if ((i17 & 16) != 0) {
                i22 = imageBitmap.getHeight();
            } else {
                i22 = i14;
            }
            if ((i17 & 32) == 0) {
                i24 = i15;
            }
            if ((i17 & 64) != 0) {
                i23 = i21;
            } else {
                i23 = i16;
            }
            imageBitmap.readPixels(iArr, i18, i19, i21, i22, i24, i23);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readPixels");
    }
}
