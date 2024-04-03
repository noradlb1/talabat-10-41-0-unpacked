package com.designsystem.ds_input_field;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.input.ImeAction;
import androidx.fragment.app.FragmentManager;
import com.designsystem.ds_input_field.country.DSCountryModel;
import com.designsystem.ds_theme.DSThemeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001aÁ\u0001\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u001e\b\u0002\u0010\u0007\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\b2\u001e\b\u0002\u0010\n\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\u0018\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0019"}, d2 = {"DSPhoneNumberField", "", "modifier", "Landroidx/compose/ui/Modifier;", "text", "", "hint", "onTextChange", "Lkotlin/Function2;", "Lcom/designsystem/ds_input_field/country/DSCountryModel;", "onKeyboardReturnButtonTap", "defaultCountryCode", "isEnabled", "", "state", "Lcom/designsystem/ds_input_field/DSInputFieldState;", "imeAction", "Landroidx/compose/ui/text/input/ImeAction;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "prefixSearchHint", "prefixSearchEmptyStateTitle", "prefixSearchEmptyStateDetails", "DSPhoneNumberField-MmlCLH8", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Ljava/lang/String;ZLcom/designsystem/ds_input_field/DSInputFieldState;ILandroidx/fragment/app/FragmentManager;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/Composer;III)V", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DSPhoneNumberFieldKt {
    @Composable
    /* renamed from: DSPhoneNumberField-MmlCLH8  reason: not valid java name */
    public static final void m8379DSPhoneNumberFieldMmlCLH8(@Nullable Modifier modifier, @Nullable String str, @Nullable String str2, @Nullable Function2<? super DSCountryModel, ? super String, Unit> function2, @Nullable Function2<? super DSCountryModel, ? super String, Unit> function22, @Nullable String str3, boolean z11, @Nullable DSInputFieldState dSInputFieldState, int i11, @NotNull FragmentManager fragmentManager, @NotNull String str4, @NotNull String str5, @NotNull String str6, @Nullable Composer composer, int i12, int i13, int i14) {
        int i15;
        int i16;
        int i17 = i14;
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(str4, "prefixSearchHint");
        Intrinsics.checkNotNullParameter(str5, "prefixSearchEmptyStateTitle");
        Intrinsics.checkNotNullParameter(str6, "prefixSearchEmptyStateDetails");
        Composer startRestartGroup = composer.startRestartGroup(732611452);
        Modifier modifier2 = (i17 & 1) != 0 ? Modifier.Companion : modifier;
        String str7 = (i17 & 2) != 0 ? null : str;
        String str8 = (i17 & 4) != 0 ? null : str2;
        Function2<? super DSCountryModel, ? super String, Unit> function23 = (i17 & 8) != 0 ? null : function2;
        Function2<? super DSCountryModel, ? super String, Unit> function24 = (i17 & 16) != 0 ? null : function22;
        String str9 = (i17 & 32) != 0 ? null : str3;
        boolean z12 = (i17 & 64) != 0 ? true : z11;
        DSInputFieldState dSInputFieldState2 = (i17 & 128) != 0 ? DSInputFieldState.Normal : dSInputFieldState;
        if ((i17 & 256) != 0) {
            i15 = ImeAction.Companion.m5188getDoneeUduSuo();
            i16 = i12 & -234881025;
        } else {
            i15 = i11;
            i16 = i12;
        }
        DSThemeKt.DSTheme(ComposableLambdaKt.composableLambda(startRestartGroup, -819893583, true, new DSPhoneNumberFieldKt$DSPhoneNumberField$1(modifier2, str7, str8, function23, function24, str9, z12, dSInputFieldState2, i15, fragmentManager, str4, str5, str6, i16, i13)), startRestartGroup, 6);
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DSPhoneNumberFieldKt$DSPhoneNumberField$2(modifier2, str7, str8, function23, function24, str9, z12, dSInputFieldState2, i15, fragmentManager, str4, str5, str6, i12, i13, i14));
        }
    }
}
