package com.designsystem.ds_input_field;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSCreditCardFieldKt$DSCreditCardField$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ VisualTransformation f31349g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f31350h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ String f31351i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f31352j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f31353k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function1<String, Unit> f31354l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Function1<String, Unit> f31355m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ boolean f31356n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ DSInputFieldState f31357o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ Integer f31358p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ int f31359q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ int f31360r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ int f31361s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ int f31362t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSCreditCardFieldKt$DSCreditCardField$1(VisualTransformation visualTransformation, Modifier modifier, String str, String str2, String str3, Function1<? super String, Unit> function1, Function1<? super String, Unit> function12, boolean z11, DSInputFieldState dSInputFieldState, Integer num, int i11, int i12, int i13, int i14) {
        super(2);
        this.f31349g = visualTransformation;
        this.f31350h = modifier;
        this.f31351i = str;
        this.f31352j = str2;
        this.f31353k = str3;
        this.f31354l = function1;
        this.f31355m = function12;
        this.f31356n = z11;
        this.f31357o = dSInputFieldState;
        this.f31358p = num;
        this.f31359q = i11;
        this.f31360r = i12;
        this.f31361s = i13;
        this.f31362t = i14;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        Composer composer2 = composer;
        if (((i11 & 11) ^ 2) != 0 || !composer.getSkipping()) {
            float r16 = InputFieldCommon.INSTANCE.m8409getSingleLineContainerMinHeightD9Ej5fM();
            VisualTransformation visualTransformation = this.f31349g;
            if (visualTransformation == null) {
                visualTransformation = VisualTransformation.Companion.getNone();
            }
            VisualTransformation visualTransformation2 = visualTransformation;
            int r17 = KeyboardType.Companion.m5223getNumberPjHm6EE();
            Modifier modifier = this.f31350h;
            String str = this.f31351i;
            String str2 = this.f31352j;
            String str3 = this.f31353k;
            Function1<String, Unit> function1 = this.f31354l;
            Function1<String, Unit> function12 = this.f31355m;
            final boolean z11 = this.f31356n;
            boolean z12 = z11;
            DSInputFieldState dSInputFieldState = this.f31357o;
            final int i12 = this.f31362t;
            final int i13 = this.f31360r;
            ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer2, -819893283, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                @Composable
                public final void invoke(@Nullable Composer composer, int i11) {
                    if (((i11 & 11) ^ 2) != 0 || !composer.getSkipping()) {
                        Integer valueOf = Integer.valueOf(i12);
                        boolean z11 = z11;
                        int i12 = i13;
                        LeadingComposablesKt.InputFieldLeadingImage(valueOf, z11, composer, ((i12 >> 15) & 112) | ((i12 >> 24) & 14), 0);
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            });
            final DSInputFieldState dSInputFieldState2 = this.f31357o;
            final boolean z13 = this.f31356n;
            final int i14 = this.f31360r;
            ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda(composer2, -819893882, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                @Composable
                public final void invoke(@Nullable Composer composer, int i11) {
                    if (((i11 & 11) ^ 2) != 0 || !composer.getSkipping()) {
                        DSInputFieldState dSInputFieldState = dSInputFieldState2;
                        boolean z11 = z13;
                        int i12 = i14;
                        InputFieldCommonComposablesKt.InputFieldTrailingIconContainer((Integer) null, dSInputFieldState, z11, (Function0<Unit>) null, false, composer, ((i12 >> 18) & 112) | ((i12 >> 12) & 896), 25);
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            });
            Integer num = this.f31358p;
            KeyboardType r172 = KeyboardType.m5213boximpl(r17);
            ImeAction r18 = ImeAction.m5180boximpl(this.f31359q);
            int i15 = this.f31360r;
            InputFieldCommonComposablesKt.m8413InputFieldmytMHeg(modifier, str, str2, str3, function1, function12, z12, dSInputFieldState, composableLambda, (Function2<? super Composer, ? super Integer, Unit>) null, composableLambda2, 1, (Dp) null, num, visualTransformation2, r16, r172, r18, (Function0<Unit>) null, (Function1<? super TextFieldValue, TextFieldValue>) null, false, false, composer, (i15 & 14) | 100663296 | (i15 & 112) | (i15 & 896) | (i15 & 7168) | (57344 & i15) | (458752 & i15) | (3670016 & i15) | (i15 & 29360128), ((this.f31361s << 6) & 7168) | 18874422, 6, 2888192);
            return;
        }
        composer.skipToGroupEnd();
    }
}
