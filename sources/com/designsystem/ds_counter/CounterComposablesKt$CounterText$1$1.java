package com.designsystem.ds_counter;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import com.designsystem.ds_text.DSTextKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class CounterComposablesKt$CounterText$1$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ BoxWithConstraintsScope f31038g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Animatable<Dp, AnimationVector1D> f31039h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ float f31040i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ float f31041j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f31042k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ long f31043l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ TextStyle f31044m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f31045n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CounterComposablesKt$CounterText$1$1(BoxWithConstraintsScope boxWithConstraintsScope, Animatable<Dp, AnimationVector1D> animatable, float f11, float f12, String str, long j11, TextStyle textStyle, int i11) {
        super(2);
        this.f31038g = boxWithConstraintsScope;
        this.f31039h = animatable;
        this.f31040i = f11;
        this.f31041j = f12;
        this.f31042k = str;
        this.f31043l = j11;
        this.f31044m = textStyle;
        this.f31045n = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if (((i11 & 11) ^ 2) != 0 || !composer.getSkipping()) {
            Modifier wrapContentSize$default = SizeKt.wrapContentSize$default(PaddingKt.m488paddingVpY3zN4$default(this.f31038g.align(OffsetKt.m473offsetVpY3zN4$default(Modifier.Companion, 0.0f, Dp.m5478constructorimpl(this.f31039h.getValue().m5492unboximpl() + this.f31040i), 1, (Object) null), Alignment.Companion.getCenter()), this.f31041j, 0.0f, 2, (Object) null), (Alignment) null, false, 3, (Object) null);
            String str = this.f31042k;
            long j11 = this.f31043l;
            TextStyle textStyle = this.f31044m;
            int i12 = this.f31045n;
            DSTextKt.m8635DSTextqBUjsXY(str, wrapContentSize$default, 0.0f, j11, 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, (Function1<? super TextLayoutResult, Unit>) null, textStyle, composer, ((i12 >> 6) & 14) | (i12 & 7168), ((i12 << 6) & 3670016) | 512, 65524);
            return;
        }
        composer.skipToGroupEnd();
    }
}
