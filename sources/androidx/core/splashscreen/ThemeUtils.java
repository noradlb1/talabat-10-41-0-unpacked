package androidx.core.splashscreen;

import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.WindowInsetsController;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@RequiresApi(31)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Landroidx/core/splashscreen/ThemeUtils;", "", "()V", "Api31", "core-splashscreen_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ThemeUtils {
    @NotNull
    public static final ThemeUtils INSTANCE = new ThemeUtils();

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\n\u0010\u0005\u001a\u00060\u0006R\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007¨\u0006\f"}, d2 = {"Landroidx/core/splashscreen/ThemeUtils$Api31;", "", "()V", "applyThemesSystemBarAppearance", "", "theme", "Landroid/content/res/Resources$Theme;", "Landroid/content/res/Resources;", "decor", "Landroid/view/View;", "tv", "Landroid/util/TypedValue;", "core-splashscreen_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Api31 {
        @NotNull
        public static final Api31 INSTANCE = new Api31();

        private Api31() {
        }

        @JvmStatic
        @DoNotInline
        @JvmOverloads
        public static final void applyThemesSystemBarAppearance(@NotNull Resources.Theme theme, @NotNull View view) {
            Intrinsics.checkNotNullParameter(theme, "theme");
            Intrinsics.checkNotNullParameter(view, "decor");
            applyThemesSystemBarAppearance$default(theme, view, (TypedValue) null, 4, (Object) null);
        }

        @JvmStatic
        @DoNotInline
        @JvmOverloads
        public static final void applyThemesSystemBarAppearance(@NotNull Resources.Theme theme, @NotNull View view, @NotNull TypedValue typedValue) {
            int i11;
            Intrinsics.checkNotNullParameter(theme, "theme");
            Intrinsics.checkNotNullParameter(view, "decor");
            Intrinsics.checkNotNullParameter(typedValue, "tv");
            if (!theme.resolveAttribute(16844000, typedValue, true) || typedValue.data == 0) {
                i11 = 0;
            } else {
                i11 = 8;
            }
            if (theme.resolveAttribute(16844140, typedValue, true) && typedValue.data != 0) {
                i11 |= 16;
            }
            WindowInsetsController a11 = view.getWindowInsetsController();
            Intrinsics.checkNotNull(a11);
            a11.setSystemBarsAppearance(i11, 24);
        }

        public static /* synthetic */ void applyThemesSystemBarAppearance$default(Resources.Theme theme, View view, TypedValue typedValue, int i11, Object obj) {
            if ((i11 & 4) != 0) {
                typedValue = new TypedValue();
            }
            applyThemesSystemBarAppearance(theme, view, typedValue);
        }
    }

    private ThemeUtils() {
    }
}
