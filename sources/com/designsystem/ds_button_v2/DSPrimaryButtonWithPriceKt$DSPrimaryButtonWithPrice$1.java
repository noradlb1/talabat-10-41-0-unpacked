package com.designsystem.ds_button_v2;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import com.designsystem.DSConfiguration;
import com.designsystem.ds_button_v2.composables.DSAnimatedShrinkButtonKt;
import com.designsystem.ds_button_v2.composables.DSButtonWithPriceContentKt;
import com.designsystem.ds_button_v2.composables.DSButtonWithPriceStyle;
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
public final class DSPrimaryButtonWithPriceKt$DSPrimaryButtonWithPrice$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f30749g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f30750h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f30751i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f30752j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Integer f30753k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ String f30754l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ String f30755m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Modifier f30756n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f30757o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSPrimaryButtonWithPriceKt$DSPrimaryButtonWithPrice$1(boolean z11, boolean z12, boolean z13, int i11, Integer num, String str, String str2, Modifier modifier, Function0<Unit> function0) {
        super(2);
        this.f30749g = z11;
        this.f30750h = z12;
        this.f30751i = z13;
        this.f30752j = i11;
        this.f30753k = num;
        this.f30754l = str;
        this.f30755m = str2;
        this.f30756n = modifier;
        this.f30757o = function0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        Composer composer2 = composer;
        if (((i11 & 11) ^ 2) != 0 || !composer.getSkipping()) {
            boolean z11 = false;
            final boolean z12 = this.f30749g || DSConfiguration.Companion.getInstance().getButtonWithPriceM2Enabled();
            DSDefaultButtonTheme primaryButtonTheme = DSButtonDefaults.INSTANCE.primaryButtonTheme(z12, composer2, 0, 0);
            boolean z13 = this.f30750h;
            if (z12 && this.f30751i) {
                z11 = true;
            }
            final boolean z14 = this.f30751i;
            final Integer num = this.f30753k;
            final String str = this.f30754l;
            final String str2 = this.f30755m;
            final Modifier modifier = this.f30756n;
            Function0<Unit> function0 = this.f30757o;
            final int i12 = this.f30752j;
            final Function0<Unit> function02 = function0;
            final DSDefaultButtonTheme dSDefaultButtonTheme = primaryButtonTheme;
            AnonymousClass1 r52 = r7;
            final boolean z15 = z13;
            AnonymousClass1 r72 = new Function4<Boolean, MutableInteractionSource, Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    invoke(((Boolean) obj).booleanValue(), (MutableInteractionSource) obj2, (Composer) obj3, ((Number) obj4).intValue());
                    return Unit.INSTANCE;
                }

                @Composable
                public final void invoke(boolean z11, @NotNull MutableInteractionSource mutableInteractionSource, @Nullable Composer composer, int i11) {
                    int i12;
                    DSButtonWithPriceStyle dSButtonWithPriceStyle;
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
                        boolean z13 = z12;
                        boolean z14 = true;
                        boolean z15 = z13 && z14;
                        if (z13) {
                            composer2.startReplaceableGroup(1663661652);
                            if (num == null) {
                                z14 = false;
                            }
                            dSButtonWithPriceStyle = DSButtonWithPriceContentKt.buttonWithPriceMM2Style(z14, composer2, 0);
                            composer.endReplaceableGroup();
                        } else {
                            composer2.startReplaceableGroup(1663661750);
                            dSButtonWithPriceStyle = DSButtonWithPriceContentKt.buttonWithPriceMM1Style(composer2, 0);
                            composer.endReplaceableGroup();
                        }
                        DSButtonWithPriceStyle dSButtonWithPriceStyle2 = dSButtonWithPriceStyle;
                        DSDefaultButtonTheme dSDefaultButtonTheme = dSDefaultButtonTheme;
                        String str = str;
                        String str2 = str2;
                        Modifier modifier = modifier;
                        Integer num = num;
                        boolean z16 = z15;
                        Function0<Unit> function0 = function02;
                        int i13 = i12;
                        int i14 = i12 << 21;
                        DSButtonWithPriceContentKt.DSButtonWithPriceContent(dSDefaultButtonTheme, str, str2, modifier, num, z16, z15, z11, mutableInteractionSource, dSButtonWithPriceStyle2, function0, composer, ((i13 << 3) & 896) | ((i13 << 3) & 112) | ((i13 << 3) & 7168) | ((i13 << 3) & 57344) | ((i13 << 3) & Opcodes.ASM7) | (29360128 & i14) | (i14 & 234881024), (i13 >> 21) & 14);
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            };
            DSAnimatedShrinkButtonKt.DSAnimatedShrinkButton(primaryButtonTheme, z13, z11, false, ComposableLambdaKt.composableLambda(composer2, -819893032, true, r52), composer, ((this.f30752j >> 9) & 112) | CpioConstants.C_ISBLK, 8);
            return;
        }
        composer.skipToGroupEnd();
    }
}
