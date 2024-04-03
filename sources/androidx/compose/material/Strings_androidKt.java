package androidx.compose.material;

import android.content.Context;
import android.content.res.Resources;
import androidx.compose.material.Strings;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.R;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001d\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0006"}, d2 = {"getString", "", "string", "Landroidx/compose/material/Strings;", "getString-4foXLRw", "(ILandroidx/compose/runtime/Composer;I)Ljava/lang/String;", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class Strings_androidKt {
    @NotNull
    @Composable
    /* renamed from: getString-4foXLRw  reason: not valid java name */
    public static final String m1382getString4foXLRw(int i11, @Nullable Composer composer, int i12) {
        String str;
        composer.startReplaceableGroup(-726638443);
        composer.consume(AndroidCompositionLocals_androidKt.getLocalConfiguration());
        Resources resources = ((Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext())).getResources();
        Strings.Companion companion = Strings.Companion;
        if (Strings.m1371equalsimpl0(i11, companion.m1379getNavigationMenuUdPEhr4())) {
            str = resources.getString(R.string.navigation_menu);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(R.string.navigation_menu)");
        } else if (Strings.m1371equalsimpl0(i11, companion.m1375getCloseDrawerUdPEhr4())) {
            str = resources.getString(R.string.close_drawer);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(R.string.close_drawer)");
        } else if (Strings.m1371equalsimpl0(i11, companion.m1376getCloseSheetUdPEhr4())) {
            str = resources.getString(R.string.close_sheet);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(R.string.close_sheet)");
        } else if (Strings.m1371equalsimpl0(i11, companion.m1377getDefaultErrorMessageUdPEhr4())) {
            str = resources.getString(R.string.default_error_message);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(R.st…ng.default_error_message)");
        } else if (Strings.m1371equalsimpl0(i11, companion.m1378getExposedDropdownMenuUdPEhr4())) {
            str = resources.getString(R.string.dropdown_menu);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(R.string.dropdown_menu)");
        } else if (Strings.m1371equalsimpl0(i11, companion.m1381getSliderRangeStartUdPEhr4())) {
            str = resources.getString(R.string.range_start);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(R.string.range_start)");
        } else if (Strings.m1371equalsimpl0(i11, companion.m1380getSliderRangeEndUdPEhr4())) {
            str = resources.getString(R.string.range_end);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(R.string.range_end)");
        } else {
            str = "";
        }
        composer.endReplaceableGroup();
        return str;
    }
}
