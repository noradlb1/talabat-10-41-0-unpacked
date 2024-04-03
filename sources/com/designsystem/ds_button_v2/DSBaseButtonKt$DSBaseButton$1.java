package com.designsystem.ds_button_v2;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import com.designsystem.ds_button_v2.composables.DSAnimatedShrinkButtonKt;
import com.designsystem.ds_button_v2.composables.DSButtonContentKt;
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
public final class DSBaseButtonKt$DSBaseButton$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DSButtonTheme f30689g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f30690h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f30691i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f30692j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f30693k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ boolean f30694l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ String f30695m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Modifier f30696n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ String f30697o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ Integer f30698p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f30699q;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSBaseButtonKt$DSBaseButton$1(DSButtonTheme dSButtonTheme, boolean z11, boolean z12, int i11, boolean z13, boolean z14, String str, Modifier modifier, String str2, Integer num, Function0<Unit> function0) {
        super(2);
        this.f30689g = dSButtonTheme;
        this.f30690h = z11;
        this.f30691i = z12;
        this.f30692j = i11;
        this.f30693k = z13;
        this.f30694l = z14;
        this.f30695m = str;
        this.f30696n = modifier;
        this.f30697o = str2;
        this.f30698p = num;
        this.f30699q = function0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if (((i11 & 11) ^ 2) != 0 || !composer.getSkipping()) {
            DSButtonTheme dSButtonTheme = this.f30689g;
            boolean z11 = this.f30690h;
            boolean z12 = this.f30691i;
            final boolean z13 = this.f30693k;
            final boolean z14 = this.f30694l;
            final int i12 = this.f30692j;
            final String str = this.f30695m;
            final Modifier modifier = this.f30696n;
            final String str2 = this.f30697o;
            final Integer num = this.f30698p;
            final DSButtonTheme dSButtonTheme2 = dSButtonTheme;
            final boolean z15 = z11;
            final boolean z16 = z12;
            boolean z17 = z12;
            AnonymousClass1 r15 = r2;
            final Function0<Unit> function0 = this.f30699q;
            AnonymousClass1 r22 = new Function4<Boolean, MutableInteractionSource, Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    invoke(((Boolean) obj).booleanValue(), (MutableInteractionSource) obj2, (Composer) obj3, ((Number) obj4).intValue());
                    return Unit.INSTANCE;
                }

                @Composable
                public final void invoke(boolean z11, @NotNull MutableInteractionSource mutableInteractionSource, @Nullable Composer composer, int i11) {
                    int i12;
                    DSButtonStyle dSButtonStyle;
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
                        if (z13) {
                            composer2.startReplaceableGroup(635274412);
                            dSButtonStyle = DSBaseButtonKt.buttonMM2Style(z14, composer2, (i12 >> 24) & 14);
                            composer.endReplaceableGroup();
                        } else {
                            composer2.startReplaceableGroup(635274483);
                            dSButtonStyle = DSBaseButtonKt.buttonMM1Style(composer2, 0);
                            composer.endReplaceableGroup();
                        }
                        DSButtonStyle dSButtonStyle2 = dSButtonStyle;
                        DSButtonTheme dSButtonTheme = dSButtonTheme2;
                        String str = str;
                        Modifier modifier = modifier;
                        String str2 = str2;
                        Integer num = num;
                        boolean z13 = z15;
                        boolean z14 = z16;
                        Function0<Unit> function0 = function0;
                        int i13 = i12;
                        int i14 = i12 << 21;
                        DSButtonContentKt.DSButtonContent(dSButtonTheme, str, modifier, str2, num, z13, z14, z11, mutableInteractionSource, dSButtonStyle2, function0, composer, (i13 & 896) | (i13 & 14) | (i13 & 112) | (i13 & 7168) | (57344 & i13) | (458752 & i13) | (3670016 & i13) | (29360128 & i14) | (i14 & 234881024), (i13 >> 27) & 14);
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            };
            Composer composer2 = composer;
            ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer2, -819895743, true, r15);
            int i13 = this.f30692j;
            DSAnimatedShrinkButtonKt.DSAnimatedShrinkButton(dSButtonTheme, z11, z17, false, composableLambda, composer2, (i13 & 14) | CpioConstants.C_ISBLK | ((i13 >> 12) & 112) | ((i13 >> 12) & 896), 8);
            return;
        }
        composer.skipToGroupEnd();
    }
}
