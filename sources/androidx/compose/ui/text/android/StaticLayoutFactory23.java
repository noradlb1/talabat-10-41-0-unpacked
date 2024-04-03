package androidx.compose.ui.text.android;

import android.os.Build;
import android.text.StaticLayout;
import androidx.annotation.DoNotInline;
import androidx.annotation.OptIn;
import androidx.annotation.RequiresApi;
import androidx.core.os.BuildCompat;
import com.facebook.internal.NativeProtocol;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@RequiresApi(23)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0017J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\bH\u0017¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/text/android/StaticLayoutFactory23;", "Landroidx/compose/ui/text/android/StaticLayoutFactoryImpl;", "()V", "create", "Landroid/text/StaticLayout;", "params", "Landroidx/compose/ui/text/android/StaticLayoutParams;", "isFallbackLineSpacingEnabled", "", "layout", "useFallbackLineSpacing", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class StaticLayoutFactory23 implements StaticLayoutFactoryImpl {
    @NotNull
    @DoNotInline
    public StaticLayout create(@NotNull StaticLayoutParams staticLayoutParams) {
        Intrinsics.checkNotNullParameter(staticLayoutParams, NativeProtocol.WEB_DIALOG_PARAMS);
        StaticLayout.Builder obtain = StaticLayout.Builder.obtain(staticLayoutParams.getText(), staticLayoutParams.getStart(), staticLayoutParams.getEnd(), staticLayoutParams.getPaint(), staticLayoutParams.getWidth());
        obtain.setTextDirection(staticLayoutParams.getTextDir());
        obtain.setAlignment(staticLayoutParams.getAlignment());
        obtain.setMaxLines(staticLayoutParams.getMaxLines());
        obtain.setEllipsize(staticLayoutParams.getEllipsize());
        obtain.setEllipsizedWidth(staticLayoutParams.getEllipsizedWidth());
        obtain.setLineSpacing(staticLayoutParams.getLineSpacingExtra(), staticLayoutParams.getLineSpacingMultiplier());
        obtain.setIncludePad(staticLayoutParams.getIncludePadding());
        obtain.setBreakStrategy(staticLayoutParams.getBreakStrategy());
        obtain.setHyphenationFrequency(staticLayoutParams.getHyphenationFrequency());
        obtain.setIndents(staticLayoutParams.getLeftIndents(), staticLayoutParams.getRightIndents());
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 26) {
            Intrinsics.checkNotNullExpressionValue(obtain, "this");
            StaticLayoutFactory26.setJustificationMode(obtain, staticLayoutParams.getJustificationMode());
        }
        if (i11 >= 28) {
            Intrinsics.checkNotNullExpressionValue(obtain, "this");
            StaticLayoutFactory28.setUseLineSpacingFromFallbacks(obtain, staticLayoutParams.getUseFallbackLineSpacing());
        }
        if (i11 >= 33) {
            Intrinsics.checkNotNullExpressionValue(obtain, "this");
            StaticLayoutFactory33.setLineBreakConfig(obtain, staticLayoutParams.getLineBreakStyle(), staticLayoutParams.getLineBreakWordStyle());
        }
        StaticLayout build = obtain.build();
        Intrinsics.checkNotNullExpressionValue(build, "obtain(params.text, para…  }\n            }.build()");
        return build;
    }

    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    public boolean isFallbackLineSpacingEnabled(@NotNull StaticLayout staticLayout, boolean z11) {
        Intrinsics.checkNotNullParameter(staticLayout, TtmlNode.TAG_LAYOUT);
        if (BuildCompat.isAtLeastT()) {
            return StaticLayoutFactory33.isFallbackLineSpacingEnabled(staticLayout);
        }
        if (Build.VERSION.SDK_INT >= 28) {
            return z11;
        }
        return false;
    }
}
