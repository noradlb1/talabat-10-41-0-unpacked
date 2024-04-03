package q0;

import androidx.compose.runtime.State;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;

public final /* synthetic */ class b {
    public static /* synthetic */ State a(FontFamily.Resolver resolver, FontFamily fontFamily, FontWeight fontWeight, int i11, int i12, int i13, Object obj) {
        if (obj == null) {
            if ((i13 & 1) != 0) {
                fontFamily = null;
            }
            if ((i13 & 2) != 0) {
                fontWeight = FontWeight.Companion.getNormal();
            }
            if ((i13 & 4) != 0) {
                i11 = FontStyle.Companion.m5129getNormal_LCdwA();
            }
            if ((i13 & 8) != 0) {
                i12 = FontSynthesis.Companion.m5139getAllGVVA2EU();
            }
            return resolver.m5100resolveDPcqOEQ(fontFamily, fontWeight, i11, i12);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resolve-DPcqOEQ");
    }
}
