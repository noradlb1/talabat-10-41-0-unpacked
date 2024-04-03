package com.designsystem.ds_progress_bar;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.ProgressIndicatorKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.platform.TestTagKt;
import com.designsystem.ds_theme.DSTheme;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSProgressBarKt$DSProgressBar$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ float f32457g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f32458h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Color f32459i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f32460j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSProgressBarKt$DSProgressBar$1(float f11, Modifier modifier, Color color, int i11) {
        super(2);
        this.f32457g = f11;
        this.f32458h = modifier;
        this.f32459i = color;
        this.f32460j = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        long j11;
        if (((i11 & 11) ^ 2) != 0 || !composer.getSkipping()) {
            float f11 = this.f32457g;
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(this.f32458h, 0.0f, 1, (Object) null);
            DSTheme dSTheme = DSTheme.INSTANCE;
            Modifier testTag = TestTagKt.testTag(SizeKt.m544height3ABfNKs(fillMaxWidth$default, dSTheme.getDimens(composer, 0).m8848getDsXxxsD9Ej5fM()), ProgressBar.ProgressBarTestTag);
            Color color = this.f32459i;
            if (color == null) {
                composer.startReplaceableGroup(1164113286);
                j11 = dSTheme.getColors(composer, 0).m8798getDsPromo1000d7_KjU();
                composer.endReplaceableGroup();
            } else {
                composer.startReplaceableGroup(1164113262);
                composer.endReplaceableGroup();
                j11 = color.m2929unboximpl();
            }
            ProgressIndicatorKt.m1330LinearProgressIndicatoreaDK9VM(f11, testTag, j11, dSTheme.getColors(composer, 0).m8759getDsNeutral100d7_KjU(), composer, (this.f32460j >> 3) & 14, 0);
            return;
        }
        composer.skipToGroupEnd();
    }
}
