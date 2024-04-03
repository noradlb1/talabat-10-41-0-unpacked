package com.designsystem.ds_branded_button;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import com.designsystem.ds_branded_button.composables.DSBrandedButtonContentKt;
import com.designsystem.ds_button_v2.DSButtonTheme;
import com.designsystem.ds_button_v2.composables.DSAnimatedShrinkButtonKt;
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
public final class DSBaseBrandedButtonKt$DSBaseBrandedButton$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DSButtonTheme f30619g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f30620h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f30621i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f30622j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f30623k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ String f30624l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Modifier f30625m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Integer f30626n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f30627o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSBaseBrandedButtonKt$DSBaseBrandedButton$1(DSButtonTheme dSButtonTheme, boolean z11, boolean z12, int i11, boolean z13, String str, Modifier modifier, Integer num, Function0<Unit> function0) {
        super(2);
        this.f30619g = dSButtonTheme;
        this.f30620h = z11;
        this.f30621i = z12;
        this.f30622j = i11;
        this.f30623k = z13;
        this.f30624l = str;
        this.f30625m = modifier;
        this.f30626n = num;
        this.f30627o = function0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if (((i11 & 11) ^ 2) != 0 || !composer.getSkipping()) {
            DSButtonTheme dSButtonTheme = this.f30619g;
            boolean z11 = this.f30620h;
            boolean z12 = this.f30621i;
            final boolean z13 = this.f30623k;
            final String str = this.f30624l;
            final Modifier modifier = this.f30625m;
            final Integer num = this.f30626n;
            final Function0<Unit> function0 = this.f30627o;
            final int i12 = this.f30622j;
            final DSButtonTheme dSButtonTheme2 = dSButtonTheme;
            final boolean z14 = z11;
            final boolean z15 = z12;
            AnonymousClass1 r22 = new Function4<Boolean, MutableInteractionSource, Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    invoke(((Boolean) obj).booleanValue(), (MutableInteractionSource) obj2, (Composer) obj3, ((Number) obj4).intValue());
                    return Unit.INSTANCE;
                }

                @Composable
                public final void invoke(boolean z11, @NotNull MutableInteractionSource mutableInteractionSource, @Nullable Composer composer, int i11) {
                    int i12;
                    DSBrandedButtonStyle dSBrandedButtonStyle;
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
                            composer2.startReplaceableGroup(-366454531);
                            dSBrandedButtonStyle = DSBaseBrandedButtonKt.buttonMM2Style(composer2, 0);
                            composer.endReplaceableGroup();
                        } else {
                            composer2.startReplaceableGroup(-366454477);
                            dSBrandedButtonStyle = DSBaseBrandedButtonKt.buttonMM1Style(composer2, 0);
                            composer.endReplaceableGroup();
                        }
                        DSBrandedButtonStyle dSBrandedButtonStyle2 = dSBrandedButtonStyle;
                        DSButtonTheme dSButtonTheme = dSButtonTheme2;
                        String str = str;
                        Modifier modifier = modifier;
                        Integer num = num;
                        boolean z13 = z14;
                        boolean z14 = z15;
                        Function0<Unit> function0 = function0;
                        int i13 = i12;
                        int i14 = i12 << 18;
                        DSBrandedButtonContentKt.DSBrandedButtonContent(dSButtonTheme, str, modifier, num, z13, z14, z11, mutableInteractionSource, dSBrandedButtonStyle2, function0, composer, ((i13 << 6) & 1879048192) | (i14 & 29360128) | (i13 & 14) | (i13 & 112) | (i13 & 896) | (i13 & 7168) | (57344 & i13) | (458752 & i13) | (3670016 & i14));
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            };
            Composer composer2 = composer;
            ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer2, -819895681, true, r22);
            int i13 = this.f30622j;
            DSAnimatedShrinkButtonKt.DSAnimatedShrinkButton(dSButtonTheme, z11, z12, false, composableLambda, composer2, (i13 & 14) | CpioConstants.C_ISBLK | ((i13 >> 9) & 112) | ((i13 >> 9) & 896), 8);
            return;
        }
        composer.skipToGroupEnd();
    }
}
