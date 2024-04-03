package androidx.compose.material3;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
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
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.VisualTransformation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.apache.commons.compress.archivers.cpio.CpioConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class OutlinedTextFieldKt$OutlinedTextField$5 extends Lambda implements Function2<Composer, Integer, Unit> {
    public final /* synthetic */ Function2<Composer, Integer, Unit> A;
    public final /* synthetic */ Shape B;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7693g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f7694h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ TextFieldColors f7695i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f7696j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f7697k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ TextFieldValue f7698l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Function1<TextFieldValue, Unit> f7699m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ boolean f7700n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ boolean f7701o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ TextStyle f7702p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ KeyboardOptions f7703q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ KeyboardActions f7704r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ boolean f7705s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ int f7706t;

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ VisualTransformation f7707u;

    /* renamed from: v  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f7708v;

    /* renamed from: w  reason: collision with root package name */
    public final /* synthetic */ int f7709w;

    /* renamed from: x  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7710x;

    /* renamed from: y  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7711y;

    /* renamed from: z  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7712z;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OutlinedTextFieldKt$OutlinedTextField$5(Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, TextFieldColors textFieldColors, boolean z11, int i11, TextFieldValue textFieldValue, Function1<? super TextFieldValue, Unit> function1, boolean z12, boolean z13, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z14, int i12, VisualTransformation visualTransformation, MutableInteractionSource mutableInteractionSource, int i13, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, Shape shape) {
        super(2);
        this.f7693g = function2;
        this.f7694h = modifier;
        this.f7695i = textFieldColors;
        this.f7696j = z11;
        this.f7697k = i11;
        this.f7698l = textFieldValue;
        this.f7699m = function1;
        this.f7700n = z12;
        this.f7701o = z13;
        this.f7702p = textStyle;
        this.f7703q = keyboardOptions;
        this.f7704r = keyboardActions;
        this.f7705s = z14;
        this.f7706t = i12;
        this.f7707u = visualTransformation;
        this.f7708v = mutableInteractionSource;
        this.f7709w = i13;
        this.f7710x = function22;
        this.f7711y = function23;
        this.f7712z = function24;
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
        Modifier modifier;
        Composer composer2 = composer;
        int i12 = i11;
        if ((i12 & 11) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-719341509, i12, -1, "androidx.compose.material3.OutlinedTextField.<anonymous> (OutlinedTextField.kt:311)");
            }
            if (this.f7693g != null) {
                modifier = PaddingKt.m490paddingqDBjuR0$default(SemanticsModifierKt.semantics(this.f7694h, true, AnonymousClass1.INSTANCE), 0.0f, OutlinedTextFieldKt.getOutlinedTextFieldTopPadding(), 0.0f, 0.0f, 13, (Object) null);
            } else {
                modifier = this.f7694h;
            }
            TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
            Modifier r32 = SizeKt.m542defaultMinSizeVpY3zN4(modifier, textFieldDefaults.m1911getMinWidthD9Ej5fM(), textFieldDefaults.m1910getMinHeightD9Ej5fM());
            SolidColor solidColor = r1;
            TextFieldColors textFieldColors = this.f7695i;
            boolean z11 = this.f7696j;
            int i13 = this.f7697k;
            SolidColor solidColor2 = new SolidColor(textFieldColors.cursorColor$material3_release(z11, composer2, ((i13 >> 24) & 112) | ((i13 >> 3) & 14)).getValue().m2929unboximpl(), (DefaultConstructorMarker) null);
            TextFieldValue textFieldValue = this.f7698l;
            TextFieldValue textFieldValue2 = textFieldValue;
            Function1<TextFieldValue, Unit> function1 = this.f7699m;
            boolean z12 = this.f7700n;
            boolean z13 = z12;
            boolean z14 = this.f7701o;
            TextStyle textStyle = this.f7702p;
            KeyboardOptions keyboardOptions = this.f7703q;
            KeyboardActions keyboardActions = this.f7704r;
            boolean z15 = this.f7705s;
            boolean z16 = z15;
            final boolean z17 = z15;
            int i14 = this.f7706t;
            VisualTransformation visualTransformation = this.f7707u;
            final boolean z18 = z12;
            final TextFieldValue textFieldValue3 = textFieldValue;
            MutableInteractionSource mutableInteractionSource = this.f7708v;
            TextFieldValue textFieldValue4 = textFieldValue2;
            final VisualTransformation visualTransformation2 = visualTransformation;
            Function1<TextFieldValue, Unit> function12 = function1;
            boolean z19 = this.f7696j;
            Modifier modifier2 = r32;
            Function2<Composer, Integer, Unit> function2 = this.f7693g;
            boolean z21 = z13;
            Function2<Composer, Integer, Unit> function22 = this.f7710x;
            boolean z22 = z14;
            Function2<Composer, Integer, Unit> function23 = this.f7711y;
            TextStyle textStyle2 = textStyle;
            Function2<Composer, Integer, Unit> function24 = this.f7712z;
            KeyboardOptions keyboardOptions2 = keyboardOptions;
            Function2<Composer, Integer, Unit> function25 = this.A;
            KeyboardActions keyboardActions2 = keyboardActions;
            TextFieldColors textFieldColors2 = this.f7695i;
            boolean z23 = z16;
            int i15 = this.f7709w;
            int i16 = i14;
            final MutableInteractionSource mutableInteractionSource2 = mutableInteractionSource;
            final boolean z24 = z19;
            final Function2<Composer, Integer, Unit> function26 = function2;
            final Function2<Composer, Integer, Unit> function27 = function22;
            final Function2<Composer, Integer, Unit> function28 = function23;
            final Function2<Composer, Integer, Unit> function29 = function24;
            final Function2<Composer, Integer, Unit> function210 = function25;
            final TextFieldColors textFieldColors3 = textFieldColors2;
            final int i17 = i15;
            final int i18 = this.f7697k;
            final Shape shape = this.B;
            ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer2, 342910148, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    invoke((Function2<? super Composer, ? super Integer, Unit>) (Function2) obj, (Composer) obj2, ((Number) obj3).intValue());
                    return Unit.INSTANCE;
                }

                @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
                @Composable
                public final void invoke(@NotNull Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Composer composer, int i11) {
                    int i12;
                    Function2<? super Composer, ? super Integer, Unit> function22 = function2;
                    Composer composer2 = composer;
                    Intrinsics.checkNotNullParameter(function22, "innerTextField");
                    if ((i11 & 14) == 0) {
                        i12 = i11 | (composer2.changed((Object) function22) ? 4 : 2);
                    } else {
                        i12 = i11;
                    }
                    if ((i12 & 91) != 18 || !composer.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(342910148, i12, -1, "androidx.compose.material3.OutlinedTextField.<anonymous>.<anonymous> (OutlinedTextField.kt:339)");
                        }
                        TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                        String text = textFieldValue3.getText();
                        boolean z11 = z18;
                        boolean z12 = z11;
                        boolean z13 = z17;
                        VisualTransformation visualTransformation = visualTransformation2;
                        MutableInteractionSource mutableInteractionSource = mutableInteractionSource2;
                        MutableInteractionSource mutableInteractionSource2 = mutableInteractionSource;
                        boolean z14 = z24;
                        boolean z15 = z14;
                        Function2<Composer, Integer, Unit> function23 = function26;
                        Function2<Composer, Integer, Unit> function24 = function27;
                        final boolean z16 = z14;
                        Function2<Composer, Integer, Unit> function25 = function28;
                        final MutableInteractionSource mutableInteractionSource3 = mutableInteractionSource;
                        Function2<Composer, Integer, Unit> function26 = function29;
                        final boolean z17 = z11;
                        Function2<Composer, Integer, Unit> function27 = function210;
                        TextFieldColors textFieldColors = textFieldColors3;
                        int i13 = i12;
                        TextFieldColors textFieldColors2 = textFieldColors;
                        String str = text;
                        boolean z18 = z12;
                        final TextFieldColors textFieldColors3 = textFieldColors;
                        final Shape shape = shape;
                        final int i14 = i17;
                        final int i15 = i18;
                        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer2, 119108444, true, new Function2<Composer, Integer, Unit>() {
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                            @Composable
                            public final void invoke(@Nullable Composer composer, int i11) {
                                int i12 = i11;
                                if ((i12 & 11) != 2 || !composer.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(119108444, i12, -1, "androidx.compose.material3.OutlinedTextField.<anonymous>.<anonymous>.<anonymous> (OutlinedTextField.kt:354)");
                                    }
                                    TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                                    boolean z11 = z17;
                                    boolean z12 = z16;
                                    MutableInteractionSource mutableInteractionSource = mutableInteractionSource3;
                                    TextFieldColors textFieldColors = textFieldColors3;
                                    Shape shape = shape;
                                    int i13 = i15;
                                    textFieldDefaults.m1908OutlinedBorderContainerBoxnbWgWpA(z11, z12, mutableInteractionSource, textFieldColors, shape, 0.0f, 0.0f, composer, ((i14 >> 9) & 14) | 12582912 | (i13 & 112) | ((i13 >> 15) & 896) | ((i13 >> 18) & 7168) | ((i13 >> 12) & 57344), 96);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer.skipToGroupEnd();
                            }
                        });
                        int i16 = i17;
                        int i17 = i18;
                        textFieldDefaults.OutlinedTextFieldDecorationBox(str, function2, z18, z13, visualTransformation, mutableInteractionSource2, z15, function23, function24, function25, function26, function27, textFieldColors2, (PaddingValues) null, composableLambda, composer, ((i13 << 3) & 112) | ((i16 >> 3) & 896) | ((i17 >> 6) & 7168) | ((i17 << 6) & 57344) | (458752 & (i17 >> 6)) | ((i17 << 15) & 3670016) | ((i16 << 3) & 29360128) | ((i16 << 3) & 234881024) | ((i16 << 3) & 1879048192), ((i16 >> 27) & 14) | 221184 | ((i17 << 3) & 112) | ((i17 >> 21) & 896), 8192);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            });
            int i19 = this.f7709w;
            int i21 = this.f7697k;
            int i22 = (i19 & 57344) | (i19 & 14) | (i19 & 112) | (i19 & 7168) | ((i21 << 9) & 3670016) | (KeyboardActions.$stable << 21) | ((i21 << 9) & 29360128) | ((i21 << 9) & 234881024) | (1879048192 & (i21 << 9));
            int i23 = ((i21 >> 6) & 14) | CpioConstants.C_ISBLK | ((i21 >> 15) & 896);
            BasicTextFieldKt.BasicTextField(textFieldValue4, (Function1<? super TextFieldValue, Unit>) function12, modifier2, z21, z22, textStyle2, keyboardOptions2, keyboardActions2, z23, i16, visualTransformation, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource, (Brush) solidColor, (Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit>) composableLambda, composer, i22, i23, 2048);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
