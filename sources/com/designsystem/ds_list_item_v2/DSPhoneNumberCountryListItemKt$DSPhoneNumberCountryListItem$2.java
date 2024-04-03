package com.designsystem.ds_list_item_v2;

import androidx.compose.material.TextKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.unit.LayoutDirection;
import com.designsystem.ds_theme.DSTheme;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSPhoneNumberCountryListItemKt$DSPhoneNumberCountryListItem$2 extends Lambda implements Function3<Boolean, Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f32025g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f32026h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSPhoneNumberCountryListItemKt$DSPhoneNumberCountryListItem$2(String str, int i11) {
        super(3);
        this.f32025g = str;
        this.f32026h = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke(((Boolean) obj).booleanValue(), (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(boolean z11, @Nullable Composer composer, int i11) {
        if (((i11 & 81) ^ 16) != 0 || !composer.getSkipping()) {
            ProvidedValue[] providedValueArr = {CompositionLocalsKt.getLocalLayoutDirection().provides(LayoutDirection.Ltr)};
            final String str = this.f32025g;
            final int i12 = this.f32026h;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(composer, -819896199, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                @Composable
                public final void invoke(@Nullable Composer composer, int i11) {
                    Composer composer2 = composer;
                    if (((i11 & 11) ^ 2) != 0 || !composer.getSkipping()) {
                        String str = str;
                        Composer composer3 = composer2;
                        DSTheme dSTheme = DSTheme.INSTANCE;
                        TextKt.m1461TextfLXpl1I(str, (Modifier) null, 0, 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m5046copyHL5avdY$default(dSTheme.getTypography(composer3, 0).getDsBody1(), dSTheme.getColors(composer3, 0).m8771getDsNeutral700d7_KjU(), 0, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0, (TextIndent) null, 262142, (Object) null), composer, (i12 >> 3) & 14, 64, 32766);
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            }), composer, 56);
            return;
        }
        composer.skipToGroupEnd();
    }
}
