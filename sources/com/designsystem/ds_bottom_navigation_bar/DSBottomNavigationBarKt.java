package com.designsystem.ds_bottom_navigation_bar;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import com.designsystem.ds_theme.DSThemeKt;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aE\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\tH\u0007¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"DSBottomNavigationBar", "", "modifier", "Landroidx/compose/ui/Modifier;", "items", "", "Lcom/designsystem/ds_bottom_navigation_bar/DSBottomNavigationBarItem;", "selectedItem", "onItemSelected", "Lkotlin/Function1;", "(Landroidx/compose/ui/Modifier;Ljava/util/List;Lcom/designsystem/ds_bottom_navigation_bar/DSBottomNavigationBarItem;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DSBottomNavigationBarKt {
    @Composable
    public static final void DSBottomNavigationBar(@Nullable Modifier modifier, @NotNull List<DSBottomNavigationBarItem> list, @Nullable DSBottomNavigationBarItem dSBottomNavigationBarItem, @NotNull Function1<? super DSBottomNavigationBarItem, Unit> function1, @Nullable Composer composer, int i11, int i12) {
        Intrinsics.checkNotNullParameter(list, FirebaseAnalytics.Param.ITEMS);
        Intrinsics.checkNotNullParameter(function1, "onItemSelected");
        Composer startRestartGroup = composer.startRestartGroup(-1967656518);
        if ((i12 & 1) != 0) {
            modifier = Modifier.Companion;
        }
        if ((i12 & 4) != 0) {
            dSBottomNavigationBarItem = null;
        }
        DSThemeKt.DSTheme(ComposableLambdaKt.composableLambda(startRestartGroup, -819895881, true, new DSBottomNavigationBarKt$DSBottomNavigationBar$1(modifier, list, dSBottomNavigationBarItem, function1, i11)), startRestartGroup, 6);
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DSBottomNavigationBarKt$DSBottomNavigationBar$2(modifier, list, dSBottomNavigationBarItem, function1, i11, i12));
        }
    }
}
