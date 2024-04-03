package androidx.compose.ui.text.android;

import android.text.BoringLayout;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

@RequiresApi(33)
class BoringLayoutConstructor33 {
    private BoringLayoutConstructor33() {
    }

    @NonNull
    public static BoringLayout create(@NonNull CharSequence charSequence, @NonNull TextPaint textPaint, @IntRange(from = 0) int i11, @NonNull Layout.Alignment alignment, float f11, float f12, @NonNull BoringLayout.Metrics metrics, boolean z11, @Nullable TextUtils.TruncateAt truncateAt, @IntRange(from = 0) int i12, boolean z12) {
        return new BoringLayout(charSequence, textPaint, i11, alignment, f11, f12, metrics, z11, truncateAt, i12, z12);
    }
}
