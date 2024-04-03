package androidx.compose.material3;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.BasicTextFieldKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.VisualTransformation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import net.bytebuddy.jar.asm.Opcodes;
import org.apache.commons.compress.archivers.cpio.CpioConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class TextFieldKt$TextField$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    public final /* synthetic */ Function2<Composer, Integer, Unit> A;
    public final /* synthetic */ Shape B;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f8814g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ TextFieldColors f8815h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f8816i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f8817j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f8818k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function1<String, Unit> f8819l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ boolean f8820m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ boolean f8821n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ TextStyle f8822o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ KeyboardOptions f8823p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ KeyboardActions f8824q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ boolean f8825r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ int f8826s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ VisualTransformation f8827t;

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f8828u;

    /* renamed from: v  reason: collision with root package name */
    public final /* synthetic */ int f8829v;

    /* renamed from: w  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f8830w;

    /* renamed from: x  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f8831x;

    /* renamed from: y  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f8832y;

    /* renamed from: z  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f8833z;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextFieldKt$TextField$2(Modifier modifier, TextFieldColors textFieldColors, boolean z11, int i11, String str, Function1<? super String, Unit> function1, boolean z12, boolean z13, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z14, int i12, VisualTransformation visualTransformation, MutableInteractionSource mutableInteractionSource, int i13, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, Shape shape) {
        super(2);
        this.f8814g = modifier;
        this.f8815h = textFieldColors;
        this.f8816i = z11;
        this.f8817j = i11;
        this.f8818k = str;
        this.f8819l = function1;
        this.f8820m = z12;
        this.f8821n = z13;
        this.f8822o = textStyle;
        this.f8823p = keyboardOptions;
        this.f8824q = keyboardActions;
        this.f8825r = z14;
        this.f8826s = i12;
        this.f8827t = visualTransformation;
        this.f8828u = mutableInteractionSource;
        this.f8829v = i13;
        this.f8830w = function2;
        this.f8831x = function22;
        this.f8832y = function23;
        this.f8833z = function24;
        this.A = function25;
        this.B = shape;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        Composer composer2 = composer;
        int i12 = i11;
        if ((i12 & 11) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1197699922, i12, -1, "androidx.compose.material3.TextField.<anonymous> (TextField.kt:185)");
            }
            Modifier modifier = this.f8814g;
            TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
            Modifier r32 = SizeKt.m542defaultMinSizeVpY3zN4(modifier, textFieldDefaults.m1911getMinWidthD9Ej5fM(), textFieldDefaults.m1910getMinHeightD9Ej5fM());
            SolidColor solidColor = r1;
            TextFieldColors textFieldColors = this.f8815h;
            boolean z11 = this.f8816i;
            int i13 = this.f8817j;
            SolidColor solidColor2 = new SolidColor(textFieldColors.cursorColor$material3_release(z11, composer2, ((i13 >> 24) & 112) | ((i13 >> 3) & 14)).getValue().m2929unboximpl(), (DefaultConstructorMarker) null);
            String str = this.f8818k;
            Function1<String, Unit> function1 = this.f8819l;
            boolean z12 = this.f8820m;
            boolean z13 = z12;
            boolean z14 = this.f8821n;
            TextStyle textStyle = this.f8822o;
            KeyboardOptions keyboardOptions = this.f8823p;
            KeyboardActions keyboardActions = this.f8824q;
            boolean z15 = this.f8825r;
            boolean z16 = z15;
            int i14 = this.f8826s;
            boolean z17 = z12;
            VisualTransformation visualTransformation = this.f8827t;
            final boolean z18 = z15;
            VisualTransformation visualTransformation2 = visualTransformation;
            final VisualTransformation visualTransformation3 = visualTransformation;
            final boolean z19 = z17;
            MutableInteractionSource mutableInteractionSource = this.f8828u;
            final String str2 = str;
            String str3 = str;
            Function1<String, Unit> function12 = function1;
            boolean z21 = this.f8816i;
            Modifier modifier2 = r32;
            Function2<Composer, Integer, Unit> function2 = this.f8830w;
            boolean z22 = z13;
            Function2<Composer, Integer, Unit> function22 = this.f8831x;
            boolean z23 = z14;
            Function2<Composer, Integer, Unit> function23 = this.f8832y;
            TextStyle textStyle2 = textStyle;
            Function2<Composer, Integer, Unit> function24 = this.f8833z;
            KeyboardOptions keyboardOptions2 = keyboardOptions;
            Function2<Composer, Integer, Unit> function25 = this.A;
            KeyboardActions keyboardActions2 = keyboardActions;
            Shape shape = this.B;
            boolean z24 = z16;
            TextFieldColors textFieldColors2 = this.f8815h;
            int i15 = i14;
            final MutableInteractionSource mutableInteractionSource2 = mutableInteractionSource;
            final boolean z25 = z21;
            final Function2<Composer, Integer, Unit> function26 = function2;
            final Function2<Composer, Integer, Unit> function27 = function22;
            final Function2<Composer, Integer, Unit> function28 = function23;
            final Function2<Composer, Integer, Unit> function29 = function24;
            final Function2<Composer, Integer, Unit> function210 = function25;
            final Shape shape2 = shape;
            final TextFieldColors textFieldColors3 = textFieldColors2;
            final int i16 = this.f8829v;
            final int i17 = this.f8817j;
            ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer2, 172557367, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    invoke((Function2<? super Composer, ? super Integer, Unit>) (Function2) obj, (Composer) obj2, ((Number) obj3).intValue());
                    return Unit.INSTANCE;
                }

                @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
                @Composable
                public final void invoke(@NotNull Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Composer composer, int i11) {
                    int i12;
                    Function2<? super Composer, ? super Integer, Unit> function22 = function2;
                    Intrinsics.checkNotNullParameter(function22, "innerTextField");
                    Composer composer2 = composer;
                    if ((i11 & 14) == 0) {
                        i12 = i11 | (composer2.changed((Object) function22) ? 4 : 2);
                    } else {
                        i12 = i11;
                    }
                    if ((i12 & 91) != 18 || !composer.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(172557367, i12, -1, "androidx.compose.material3.TextField.<anonymous>.<anonymous> (TextField.kt:205)");
                        }
                        TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                        String str = str2;
                        boolean z11 = z19;
                        boolean z12 = z18;
                        VisualTransformation visualTransformation = visualTransformation3;
                        MutableInteractionSource mutableInteractionSource = mutableInteractionSource2;
                        boolean z13 = z25;
                        Function2<Composer, Integer, Unit> function23 = function26;
                        Function2<Composer, Integer, Unit> function24 = function27;
                        Function2<Composer, Integer, Unit> function25 = function28;
                        Function2<Composer, Integer, Unit> function26 = function29;
                        Function2<Composer, Integer, Unit> function27 = function210;
                        int i13 = i12;
                        Shape shape = shape2;
                        TextFieldColors textFieldColors = textFieldColors3;
                        int i14 = i16;
                        String str2 = str;
                        int i15 = i17;
                        textFieldDefaults.TextFieldDecorationBox(str2, function2, z11, z12, visualTransformation, mutableInteractionSource, z13, function23, function24, function25, function26, function27, shape, textFieldColors, (PaddingValues) null, (Function2<? super Composer, ? super Integer, Unit>) null, composer, ((i15 >> 6) & 7168) | (i14 & 14) | ((i13 << 3) & 112) | ((i14 >> 3) & 896) | ((i15 << 6) & 57344) | ((i15 >> 6) & Opcodes.ASM7) | ((i15 << 15) & 3670016) | ((i14 << 3) & 29360128) | ((i14 << 3) & 234881024) | ((i14 << 3) & 1879048192), ((i14 >> 27) & 14) | 1572864 | ((i15 << 3) & 112) | ((i15 >> 18) & 896) | ((i15 >> 18) & 7168), CpioConstants.C_ISSOCK);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            });
            int i18 = this.f8829v;
            int i19 = this.f8817j;
            int i21 = (i18 & 57344) | (i18 & 14) | (i18 & 112) | (i18 & 7168) | ((i19 << 9) & 3670016) | (KeyboardActions.$stable << 21) | ((i19 << 9) & 29360128) | ((i19 << 9) & 234881024) | (1879048192 & (i19 << 9));
            int i22 = ((i19 >> 6) & 14) | CpioConstants.C_ISBLK | ((i19 >> 15) & 896);
            BasicTextFieldKt.BasicTextField(str3, (Function1<? super String, Unit>) function12, modifier2, z22, z23, textStyle2, keyboardOptions2, keyboardActions2, z24, i15, visualTransformation2, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource, (Brush) solidColor, (Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit>) composableLambda, composer, i21, i22, 2048);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
