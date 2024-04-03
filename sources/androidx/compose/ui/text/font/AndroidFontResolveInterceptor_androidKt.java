package androidx.compose.ui.text.font;

import android.content.Context;
import android.os.Build;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004"}, d2 = {"AndroidFontResolveInterceptor", "Landroidx/compose/ui/text/font/AndroidFontResolveInterceptor;", "context", "Landroid/content/Context;", "ui-text_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class AndroidFontResolveInterceptor_androidKt {
    @NotNull
    public static final AndroidFontResolveInterceptor AndroidFontResolveInterceptor(@NotNull Context context) {
        int i11;
        Intrinsics.checkNotNullParameter(context, "context");
        if (Build.VERSION.SDK_INT >= 31) {
            i11 = context.getResources().getConfiguration().fontWeightAdjustment;
        } else {
            i11 = 0;
        }
        return new AndroidFontResolveInterceptor(i11);
    }
}
