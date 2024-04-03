package com.designsystem.ds_input_field;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.fragment.app.FragmentManager;
import com.designsystem.ds_theme.DSThemeKt;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0001\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0002\u0010\u0016¨\u0006\u0017"}, d2 = {"DSDateField", "", "modifier", "Landroidx/compose/ui/Modifier;", "date", "", "dateFormat", "", "hint", "helperText", "onDateChange", "Lkotlin/Function1;", "isEnabled", "", "state", "Lcom/designsystem/ds_input_field/DSInputFieldState;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "locale", "Ljava/util/Locale;", "firstDate", "lastDate", "(Landroidx/compose/ui/Modifier;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;ZLcom/designsystem/ds_input_field/DSInputFieldState;Landroidx/fragment/app/FragmentManager;Ljava/util/Locale;Ljava/lang/Long;Ljava/lang/Long;Landroidx/compose/runtime/Composer;III)V", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DSDateFieldKt {
    @Composable
    public static final void DSDateField(@Nullable Modifier modifier, @Nullable Long l11, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Function1<? super Long, Unit> function1, boolean z11, @Nullable DSInputFieldState dSInputFieldState, @NotNull FragmentManager fragmentManager, @Nullable Locale locale, @Nullable Long l12, @Nullable Long l13, @Nullable Composer composer, int i11, int i12, int i13) {
        int i14;
        Locale locale2;
        int i15 = i13;
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Composer startRestartGroup = composer.startRestartGroup(-1650168585);
        Modifier modifier2 = (i15 & 1) != 0 ? Modifier.Companion : modifier;
        Long l14 = (i15 & 2) != 0 ? null : l11;
        String str4 = (i15 & 4) != 0 ? DateInputField.DefaultDateFormat : str;
        String str5 = (i15 & 8) != 0 ? null : str2;
        String str6 = (i15 & 16) != 0 ? null : str3;
        Function1<? super Long, Unit> function12 = (i15 & 32) != 0 ? null : function1;
        boolean z12 = (i15 & 64) != 0 ? true : z11;
        DSInputFieldState dSInputFieldState2 = (i15 & 128) != 0 ? DSInputFieldState.Normal : dSInputFieldState;
        if ((i15 & 512) != 0) {
            locale2 = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale2, "getDefault()");
            i14 = i11 & -1879048193;
        } else {
            locale2 = locale;
            i14 = i11;
        }
        Long l15 = (i15 & 1024) != 0 ? null : l12;
        Long l16 = (i15 & 2048) != 0 ? null : l13;
        DSThemeKt.DSTheme(ComposableLambdaKt.composableLambda(startRestartGroup, -819892941, true, new DSDateFieldKt$DSDateField$1(modifier2, l14, str4, str5, str6, function12, z12, dSInputFieldState2, fragmentManager, locale2, l15, l16, i14, i12)), startRestartGroup, 6);
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            Long l17 = l15;
            DSDateFieldKt$DSDateField$2 dSDateFieldKt$DSDateField$2 = r0;
            DSDateFieldKt$DSDateField$2 dSDateFieldKt$DSDateField$22 = new DSDateFieldKt$DSDateField$2(modifier2, l14, str4, str5, str6, function12, z12, dSInputFieldState2, fragmentManager, locale2, l17, l16, i11, i12, i13);
            endRestartGroup.updateScope(dSDateFieldKt$DSDateField$2);
        }
    }
}
