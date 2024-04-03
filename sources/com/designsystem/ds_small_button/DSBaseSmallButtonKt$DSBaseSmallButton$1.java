package com.designsystem.ds_small_button;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import com.designsystem.ds_button_v2.DSButtonTheme;
import com.designsystem.ds_button_v2.composables.DSAnimatedShrinkButtonKt;
import com.designsystem.ds_small_button.composables.DSSmallButtonContentKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import net.bytebuddy.jar.asm.Opcodes;
import org.apache.commons.compress.archivers.cpio.CpioConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSBaseSmallButtonKt$DSBaseSmallButton$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DSButtonTheme f32675g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f32676h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f32677i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f32678j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f32679k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ String f32680l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Modifier f32681m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Integer f32682n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ boolean f32683o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ boolean f32684p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f32685q;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSBaseSmallButtonKt$DSBaseSmallButton$1(DSButtonTheme dSButtonTheme, boolean z11, boolean z12, boolean z13, int i11, String str, Modifier modifier, Integer num, boolean z14, boolean z15, Function0<Unit> function0) {
        super(2);
        this.f32675g = dSButtonTheme;
        this.f32676h = z11;
        this.f32677i = z12;
        this.f32678j = z13;
        this.f32679k = i11;
        this.f32680l = str;
        this.f32681m = modifier;
        this.f32682n = num;
        this.f32683o = z14;
        this.f32684p = z15;
        this.f32685q = function0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if (((i11 & 11) ^ 2) != 0 || !composer.getSkipping()) {
            DSButtonTheme dSButtonTheme = this.f32675g;
            boolean z11 = this.f32676h;
            boolean z12 = this.f32677i;
            boolean z13 = this.f32678j;
            final String str = this.f32680l;
            final Modifier modifier = this.f32681m;
            final Integer num = this.f32682n;
            final boolean z14 = this.f32683o;
            final boolean z15 = this.f32684p;
            int i12 = this.f32679k;
            final DSButtonTheme dSButtonTheme2 = dSButtonTheme;
            final boolean z16 = z11;
            final boolean z17 = z12;
            int i13 = i12;
            final boolean z18 = z13;
            boolean z19 = z12;
            AnonymousClass1 r15 = r2;
            final int i14 = i13;
            boolean z21 = z13;
            final Function0<Unit> function0 = this.f32685q;
            AnonymousClass1 r22 = new Function4<Boolean, MutableInteractionSource, Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    invoke(((Boolean) obj).booleanValue(), (MutableInteractionSource) obj2, (Composer) obj3, ((Number) obj4).intValue());
                    return Unit.INSTANCE;
                }

                @Composable
                public final void invoke(boolean z11, @NotNull MutableInteractionSource mutableInteractionSource, @Nullable Composer composer, int i11) {
                    int i12;
                    DSSmallButtonStyle dSSmallButtonStyle;
                    MutableInteractionSource mutableInteractionSource2 = mutableInteractionSource;
                    Composer composer2 = composer;
                    Intrinsics.checkNotNullParameter(mutableInteractionSource2, "interactionSource");
                    boolean z12 = z11;
                    if ((i11 & 14) == 0) {
                        i12 = i11 | (composer2.changed(z12) ? 4 : 2);
                    } else {
                        i12 = i11;
                    }
                    if ((i11 & 112) == 0) {
                        i12 |= composer2.changed((Object) mutableInteractionSource2) ? 32 : 16;
                    }
                    if (((i12 & 731) ^ Opcodes.I2C) != 0 || !composer.getSkipping()) {
                        DSButtonTheme dSButtonTheme = dSButtonTheme2;
                        String str = str;
                        Modifier modifier = modifier;
                        Integer num = num;
                        boolean z13 = z16;
                        boolean z14 = z17;
                        if (z18) {
                            composer2.startReplaceableGroup(-538525331);
                            boolean z15 = z14;
                            boolean z16 = z15;
                            int i13 = i14;
                            dSSmallButtonStyle = DSBaseSmallButtonKt.buttonMM2Style(z15, z16, composer2, ((i13 >> 21) & 112) | ((i13 >> 21) & 14));
                            composer.endReplaceableGroup();
                        } else {
                            composer2.startReplaceableGroup(-538525246);
                            dSSmallButtonStyle = DSBaseSmallButtonKt.buttonMM1Style(z14, composer2, (i14 >> 21) & 14);
                            composer.endReplaceableGroup();
                        }
                        Function0<Unit> function0 = function0;
                        int i14 = i14;
                        int i15 = i12 << 18;
                        DSSmallButtonContentKt.DSSmallButtonContent(dSButtonTheme, str, modifier, num, z13, z14, z11, mutableInteractionSource, dSSmallButtonStyle, function0, composer, (i14 & 1879048192) | (i15 & 29360128) | (i14 & 14) | (i14 & 112) | (i14 & 896) | (i14 & 7168) | (57344 & i14) | (458752 & i14) | (3670016 & i15));
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            };
            Composer composer2 = composer;
            ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer2, -819895411, true, r15);
            int i15 = this.f32679k;
            DSAnimatedShrinkButtonKt.DSAnimatedShrinkButton(dSButtonTheme, z11, z19, z21, composableLambda, composer2, (i15 & 14) | CpioConstants.C_ISBLK | ((i15 >> 9) & 112) | ((i15 >> 9) & 896) | ((i15 >> 9) & 7168), 0);
            return;
        }
        composer.skipToGroupEnd();
    }
}
