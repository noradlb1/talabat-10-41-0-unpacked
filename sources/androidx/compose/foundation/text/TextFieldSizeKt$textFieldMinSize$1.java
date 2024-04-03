package androidx.compose.foundation.text;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class TextFieldSizeKt$textFieldMinSize$1 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TextStyle f3616g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextFieldSizeKt$textFieldMinSize$1(TextStyle textStyle) {
        super(3);
        this.f3616g = textStyle;
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-2  reason: not valid java name */
    public static final Object m924invoke$lambda2(State<? extends Object> state) {
        return state.getValue();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v0, resolved type: androidx.compose.ui.text.TextStyle} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v0, resolved type: androidx.compose.runtime.State} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v16, resolved type: androidx.compose.foundation.text.TextFieldSize} */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.NotNull
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.ui.Modifier invoke(@org.jetbrains.annotations.NotNull androidx.compose.ui.Modifier r11, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r12, int r13) {
        /*
            r10 = this;
            java.lang.String r0 = "$this$composed"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            r11 = 1582736677(0x5e56a525, float:3.86670229E18)
            r12.startReplaceableGroup(r11)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0017
            r0 = -1
            java.lang.String r1 = "androidx.compose.foundation.text.textFieldMinSize.<anonymous> (TextFieldSize.kt:38)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r11, r13, r0, r1)
        L_0x0017:
            androidx.compose.runtime.ProvidableCompositionLocal r11 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            java.lang.Object r11 = r12.consume(r11)
            androidx.compose.ui.unit.Density r11 = (androidx.compose.ui.unit.Density) r11
            androidx.compose.runtime.ProvidableCompositionLocal r13 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalFontFamilyResolver()
            java.lang.Object r13 = r12.consume(r13)
            androidx.compose.ui.text.font.FontFamily$Resolver r13 = (androidx.compose.ui.text.font.FontFamily.Resolver) r13
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            java.lang.Object r0 = r12.consume(r0)
            r6 = r0
            androidx.compose.ui.unit.LayoutDirection r6 = (androidx.compose.ui.unit.LayoutDirection) r6
            androidx.compose.ui.text.TextStyle r0 = r10.f3616g
            r1 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r12.startReplaceableGroup(r1)
            boolean r2 = r12.changed((java.lang.Object) r0)
            boolean r3 = r12.changed((java.lang.Object) r6)
            r2 = r2 | r3
            java.lang.Object r3 = r12.rememberedValue()
            if (r2 != 0) goto L_0x0055
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r3 != r2) goto L_0x005c
        L_0x0055:
            androidx.compose.ui.text.TextStyle r3 = androidx.compose.ui.text.TextStyleKt.resolveDefaults(r0, r6)
            r12.updateRememberedValue(r3)
        L_0x005c:
            r12.endReplaceableGroup()
            r7 = r3
            androidx.compose.ui.text.TextStyle r7 = (androidx.compose.ui.text.TextStyle) r7
            r12.startReplaceableGroup(r1)
            boolean r0 = r12.changed((java.lang.Object) r13)
            boolean r1 = r12.changed((java.lang.Object) r7)
            r0 = r0 | r1
            java.lang.Object r1 = r12.rememberedValue()
            if (r0 != 0) goto L_0x007c
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r1 != r0) goto L_0x00b5
        L_0x007c:
            androidx.compose.ui.text.font.FontFamily r0 = r7.getFontFamily()
            androidx.compose.ui.text.font.FontWeight r1 = r7.getFontWeight()
            if (r1 != 0) goto L_0x008c
            androidx.compose.ui.text.font.FontWeight$Companion r1 = androidx.compose.ui.text.font.FontWeight.Companion
            androidx.compose.ui.text.font.FontWeight r1 = r1.getNormal()
        L_0x008c:
            androidx.compose.ui.text.font.FontStyle r2 = r7.m5058getFontStyle4Lr2A7w()
            if (r2 == 0) goto L_0x0097
            int r2 = r2.m5127unboximpl()
            goto L_0x009d
        L_0x0097:
            androidx.compose.ui.text.font.FontStyle$Companion r2 = androidx.compose.ui.text.font.FontStyle.Companion
            int r2 = r2.m5129getNormal_LCdwA()
        L_0x009d:
            androidx.compose.ui.text.font.FontSynthesis r3 = r7.m5059getFontSynthesisZQGJjVo()
            if (r3 == 0) goto L_0x00a8
            int r3 = r3.m5138unboximpl()
            goto L_0x00ae
        L_0x00a8:
            androidx.compose.ui.text.font.FontSynthesis$Companion r3 = androidx.compose.ui.text.font.FontSynthesis.Companion
            int r3 = r3.m5139getAllGVVA2EU()
        L_0x00ae:
            androidx.compose.runtime.State r1 = r13.m5100resolveDPcqOEQ(r0, r1, r2, r3)
            r12.updateRememberedValue(r1)
        L_0x00b5:
            r12.endReplaceableGroup()
            r8 = r1
            androidx.compose.runtime.State r8 = (androidx.compose.runtime.State) r8
            androidx.compose.ui.text.TextStyle r4 = r10.f3616g
            r0 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r12.startReplaceableGroup(r0)
            java.lang.Object r0 = r12.rememberedValue()
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r0 != r1) goto L_0x00df
            androidx.compose.foundation.text.TextFieldSize r9 = new androidx.compose.foundation.text.TextFieldSize
            java.lang.Object r5 = m924invoke$lambda2(r8)
            r0 = r9
            r1 = r6
            r2 = r11
            r3 = r13
            r0.<init>(r1, r2, r3, r4, r5)
            r12.updateRememberedValue(r9)
        L_0x00df:
            r12.endReplaceableGroup()
            r9 = r0
            androidx.compose.foundation.text.TextFieldSize r9 = (androidx.compose.foundation.text.TextFieldSize) r9
            java.lang.Object r5 = m924invoke$lambda2(r8)
            r0 = r9
            r1 = r6
            r2 = r11
            r3 = r13
            r4 = r7
            r0.update(r1, r2, r3, r4, r5)
            androidx.compose.ui.Modifier$Companion r11 = androidx.compose.ui.Modifier.Companion
            androidx.compose.foundation.text.TextFieldSizeKt$textFieldMinSize$1$1 r13 = new androidx.compose.foundation.text.TextFieldSizeKt$textFieldMinSize$1$1
            r13.<init>(r9)
            androidx.compose.ui.Modifier r11 = androidx.compose.ui.layout.LayoutModifierKt.layout(r11, r13)
            boolean r13 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r13 == 0) goto L_0x0105
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0105:
            r12.endReplaceableGroup()
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.TextFieldSizeKt$textFieldMinSize$1.invoke(androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int):androidx.compose.ui.Modifier");
    }
}
