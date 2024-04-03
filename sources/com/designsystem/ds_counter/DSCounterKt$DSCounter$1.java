package com.designsystem.ds_counter;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.text.TextStyle;
import com.designsystem.ds_theme.DSTheme;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSCounterKt$DSCounter$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f31054g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f31055h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ long f31056i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ long f31057j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f31058k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSCounterKt$DSCounter$1(Modifier modifier, int i11, long j11, long j12, int i12) {
        super(2);
        this.f31054g = modifier;
        this.f31055h = i11;
        this.f31056i = j11;
        this.f31057j = j12;
        this.f31058k = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if (((i11 & 11) ^ 2) != 0 || !composer.getSkipping()) {
            Modifier modifier = this.f31054g;
            int i12 = this.f31055h;
            long j11 = this.f31056i;
            long j12 = this.f31057j;
            DSTheme dSTheme = DSTheme.INSTANCE;
            float r72 = dSTheme.getDimens(composer, 0).m8842getDsSD9Ej5fM();
            float r82 = dSTheme.getDimens(composer, 0).m8842getDsSD9Ej5fM();
            TextStyle dsTag = dSTheme.getTypography(composer, 0).getDsTag();
            int i13 = this.f31058k;
            CounterComposablesKt.m8319CounterComposablesT9BRK9s(modifier, i12, j11, j12, r72, r82, dsTag, (Shape) null, composer, ((i13 >> 3) & 14) | ((i13 << 3) & 112) | (i13 & 896) | (i13 & 7168), 128);
            return;
        }
        composer.skipToGroupEnd();
    }
}
