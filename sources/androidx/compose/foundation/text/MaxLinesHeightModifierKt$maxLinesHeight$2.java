package androidx.compose.foundation.text;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.TextStyleKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class MaxLinesHeightModifierKt$maxLinesHeight$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f3534g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ TextStyle f3535h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MaxLinesHeightModifierKt$maxLinesHeight$2(int i11, TextStyle textStyle) {
        super(3);
        this.f3534g = i11;
        this.f3535h = textStyle;
    }

    /* renamed from: invoke$lambda-3  reason: not valid java name */
    private static final Object m888invoke$lambda3(State<? extends Object> state) {
        return state.getValue();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    @NotNull
    @Composable
    public final Modifier invoke(@NotNull Modifier modifier, @Nullable Composer composer, int i11) {
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(modifier, "$this$composed");
        composer2.startReplaceableGroup(-1027014173);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1027014173, i11, -1, "androidx.compose.foundation.text.maxLinesHeight.<anonymous> (MaxLinesHeightModifier.kt:47)");
        }
        int i12 = this.f3534g;
        if (!(i12 > 0)) {
            throw new IllegalArgumentException("maxLines must be greater than 0".toString());
        } else if (i12 == Integer.MAX_VALUE) {
            Modifier.Companion companion = Modifier.Companion;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return companion;
        } else {
            Density density = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
            FontFamily.Resolver resolver = (FontFamily.Resolver) composer2.consume(CompositionLocalsKt.getLocalFontFamilyResolver());
            LayoutDirection layoutDirection = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
            TextStyle textStyle = this.f3535h;
            composer2.startReplaceableGroup(511388516);
            boolean changed = composer2.changed((Object) textStyle) | composer2.changed((Object) layoutDirection);
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = TextStyleKt.resolveDefaults(textStyle, layoutDirection);
                composer2.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceableGroup();
            TextStyle textStyle2 = (TextStyle) rememberedValue;
            composer2.startReplaceableGroup(511388516);
            boolean changed2 = composer2.changed((Object) resolver) | composer2.changed((Object) textStyle2);
            Object rememberedValue2 = composer.rememberedValue();
            if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                FontFamily fontFamily = textStyle2.getFontFamily();
                FontWeight fontWeight = textStyle2.getFontWeight();
                if (fontWeight == null) {
                    fontWeight = FontWeight.Companion.getNormal();
                }
                FontStyle r92 = textStyle2.m5058getFontStyle4Lr2A7w();
                int r93 = r92 != null ? r92.m5127unboximpl() : FontStyle.Companion.m5129getNormal_LCdwA();
                FontSynthesis r11 = textStyle2.m5059getFontSynthesisZQGJjVo();
                rememberedValue2 = resolver.m5100resolveDPcqOEQ(fontFamily, fontWeight, r93, r11 != null ? r11.m5138unboximpl() : FontSynthesis.Companion.m5139getAllGVVA2EU());
                composer2.updateRememberedValue(rememberedValue2);
            }
            composer.endReplaceableGroup();
            State state = (State) rememberedValue2;
            Object[] objArr = {density, resolver, this.f3535h, layoutDirection, m888invoke$lambda3(state)};
            composer2.startReplaceableGroup(-568225417);
            boolean z11 = false;
            for (int i13 = 0; i13 < 5; i13++) {
                z11 |= composer2.changed(objArr[i13]);
            }
            Object rememberedValue3 = composer.rememberedValue();
            if (z11 || rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = Integer.valueOf(IntSize.m5637getHeightimpl(TextFieldDelegateKt.computeSizeForDefaultText(textStyle2, density, resolver, TextFieldDelegateKt.getEmptyTextReplacement(), 1)));
                composer2.updateRememberedValue(rememberedValue3);
            }
            composer.endReplaceableGroup();
            int intValue = ((Number) rememberedValue3).intValue();
            Object[] objArr2 = {density, resolver, this.f3535h, layoutDirection, m888invoke$lambda3(state)};
            composer2.startReplaceableGroup(-568225417);
            boolean z12 = false;
            for (int i14 = 0; i14 < 5; i14++) {
                z12 |= composer2.changed(objArr2[i14]);
            }
            Object rememberedValue4 = composer.rememberedValue();
            if (z12 || rememberedValue4 == Composer.Companion.getEmpty()) {
                rememberedValue4 = Integer.valueOf(IntSize.m5637getHeightimpl(TextFieldDelegateKt.computeSizeForDefaultText(textStyle2, density, resolver, TextFieldDelegateKt.getEmptyTextReplacement() + 10 + TextFieldDelegateKt.getEmptyTextReplacement(), 2)));
                composer2.updateRememberedValue(rememberedValue4);
            }
            composer.endReplaceableGroup();
            Modifier r22 = SizeKt.m546heightInVpY3zN4$default(Modifier.Companion, 0.0f, density.m5444toDpu2uoSUM(intValue + ((((Number) rememberedValue4).intValue() - intValue) * (this.f3534g - 1))), 1, (Object) null);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return r22;
        }
    }
}
