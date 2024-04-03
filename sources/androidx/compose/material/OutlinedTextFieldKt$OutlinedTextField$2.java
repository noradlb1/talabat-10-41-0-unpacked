package androidx.compose.material;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.text.input.VisualTransformation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import net.bytebuddy.jar.asm.Opcodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class OutlinedTextFieldKt$OutlinedTextField$2 extends Lambda implements Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f4826g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f4827h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f4828i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ VisualTransformation f4829j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f4830k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ boolean f4831l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f4832m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f4833n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f4834o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f4835p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ TextFieldColors f4836q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ int f4837r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ int f4838s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ Shape f4839t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OutlinedTextFieldKt$OutlinedTextField$2(String str, boolean z11, boolean z12, VisualTransformation visualTransformation, MutableInteractionSource mutableInteractionSource, boolean z13, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, TextFieldColors textFieldColors, int i11, int i12, Shape shape) {
        super(3);
        this.f4826g = str;
        this.f4827h = z11;
        this.f4828i = z12;
        this.f4829j = visualTransformation;
        this.f4830k = mutableInteractionSource;
        this.f4831l = z13;
        this.f4832m = function2;
        this.f4833n = function22;
        this.f4834o = function23;
        this.f4835p = function24;
        this.f4836q = textFieldColors;
        this.f4837r = i11;
        this.f4838s = i12;
        this.f4839t = shape;
    }

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
            TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
            String str = this.f4826g;
            boolean z11 = this.f4827h;
            boolean z12 = this.f4828i;
            VisualTransformation visualTransformation = this.f4829j;
            MutableInteractionSource mutableInteractionSource = this.f4830k;
            MutableInteractionSource mutableInteractionSource2 = mutableInteractionSource;
            boolean z13 = this.f4831l;
            boolean z14 = z13;
            Function2<Composer, Integer, Unit> function23 = this.f4832m;
            Function2<Composer, Integer, Unit> function24 = this.f4833n;
            Function2<Composer, Integer, Unit> function25 = this.f4834o;
            final boolean z15 = z13;
            Function2<Composer, Integer, Unit> function26 = this.f4835p;
            TextFieldColors textFieldColors = this.f4836q;
            final MutableInteractionSource mutableInteractionSource3 = mutableInteractionSource;
            TextFieldColors textFieldColors2 = textFieldColors;
            final boolean z16 = z11;
            TextFieldDefaults textFieldDefaults2 = textFieldDefaults;
            final TextFieldColors textFieldColors3 = textFieldColors;
            final Shape shape = this.f4839t;
            final int i13 = this.f4837r;
            final int i14 = this.f4838s;
            ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer2, 329542189, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                @Composable
                public final void invoke(@Nullable Composer composer, int i11) {
                    if ((i11 & 11) != 2 || !composer.getSkipping()) {
                        TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                        boolean z11 = z16;
                        boolean z12 = z15;
                        MutableInteractionSource mutableInteractionSource = mutableInteractionSource3;
                        TextFieldColors textFieldColors = textFieldColors3;
                        Shape shape = shape;
                        int i12 = i14;
                        textFieldDefaults.m1432BorderBoxnbWgWpA(z11, z12, mutableInteractionSource, textFieldColors, shape, 0.0f, 0.0f, composer, ((i13 >> 9) & 14) | 12582912 | ((i12 << 3) & 112) | ((i12 >> 12) & 896) | ((i12 >> 15) & 7168) | ((i12 >> 9) & 57344), 96);
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            });
            int i15 = this.f4837r;
            int i16 = this.f4838s;
            textFieldDefaults2.OutlinedTextFieldDecorationBox(str, function2, z11, z12, visualTransformation, mutableInteractionSource2, z14, function23, function24, function25, function26, textFieldColors2, (PaddingValues) null, composableLambda, composer, (i15 & 14) | ((i12 << 3) & 112) | ((i15 >> 3) & 896) | ((i16 >> 3) & 7168) | ((i16 << 9) & 57344) | ((i16 >> 3) & Opcodes.ASM7) | ((i16 << 18) & 3670016) | ((i15 << 3) & 29360128) | ((i15 << 3) & 234881024) | ((i15 << 3) & 1879048192), ((i15 >> 27) & 14) | 27648 | ((i16 >> 21) & 112), 4096);
            return;
        }
        composer.skipToGroupEnd();
    }
}
