package com.designsystem.ds_switch;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.material.SwitchColors;
import androidx.compose.material.SwitchDefaults;
import androidx.compose.material.SwitchKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import com.designsystem.ds_theme.DSTheme;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSSwitchKt$DSSwitch$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f33028g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function1<Boolean, Unit> f33029h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f33030i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f33031j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f33032k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSSwitchKt$DSSwitch$1(boolean z11, Function1<? super Boolean, Unit> function1, Modifier modifier, boolean z12, int i11) {
        super(2);
        this.f33028g = z11;
        this.f33029h = function1;
        this.f33030i = modifier;
        this.f33031j = z12;
        this.f33032k = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        Composer composer2 = composer;
        if (((i11 & 11) ^ 2) != 0 || !composer.getSkipping()) {
            SwitchDefaults switchDefaults = SwitchDefaults.INSTANCE;
            DSTheme dSTheme = DSTheme.INSTANCE;
            Composer composer3 = composer2;
            DSTheme dSTheme2 = dSTheme;
            SwitchColors r62 = switchDefaults.m1400colorsSQMK_m0(dSTheme.getColors(composer2, 0).m8793getDsPrimary1000d7_KjU(), dSTheme.getColors(composer2, 0).m8794getDsPrimary300d7_KjU(), 1.0f, dSTheme.getColors(composer2, 0).m8774getDsNeutralWhite0d7_KjU(), dSTheme.getColors(composer2, 0).m8764getDsNeutral350d7_KjU(), 1.0f, dSTheme.getColors(composer2, 0).m8794getDsPrimary300d7_KjU(), dSTheme.getColors(composer2, 0).m8792getDsPrimary100d7_KjU(), dSTheme2.getColors(composer3, 0).m8765getDsNeutral40d7_KjU(), dSTheme2.getColors(composer3, 0).m8759getDsNeutral100d7_KjU(), composer, 196992, 8, 0);
            boolean z11 = this.f33028g;
            Function1<Boolean, Unit> function1 = this.f33029h;
            Modifier modifier = this.f33030i;
            boolean z12 = this.f33031j;
            int i12 = this.f33032k;
            SwitchKt.Switch(z11, function1, modifier, z12, (MutableInteractionSource) null, r62, composer, ((i12 >> 3) & 14) | ((i12 >> 6) & 112) | ((i12 << 6) & 896) | ((i12 << 3) & 7168), 16);
            return;
        }
        composer.skipToGroupEnd();
    }
}
