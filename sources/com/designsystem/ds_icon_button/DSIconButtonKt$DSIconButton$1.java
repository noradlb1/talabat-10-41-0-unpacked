package com.designsystem.ds_icon_button;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import net.bytebuddy.jar.asm.Opcodes;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSIconButtonKt$DSIconButton$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f31267g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f31268h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f31269i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Color f31270j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ DSIconButtonSize f31271k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ boolean f31272l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f31273m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSIconButtonKt$DSIconButton$1(Modifier modifier, int i11, Function0<Unit> function0, Color color, DSIconButtonSize dSIconButtonSize, boolean z11, int i12) {
        super(2);
        this.f31267g = modifier;
        this.f31268h = i11;
        this.f31269i = function0;
        this.f31270j = color;
        this.f31271k = dSIconButtonSize;
        this.f31272l = z11;
        this.f31273m = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if (((i11 & 11) ^ 2) != 0 || !composer.getSkipping()) {
            Modifier modifier = this.f31267g;
            int i12 = this.f31268h;
            Function0<Unit> function0 = this.f31269i;
            Color color = this.f31270j;
            DSIconButtonSize dSIconButtonSize = this.f31271k;
            Boolean valueOf = Boolean.valueOf(this.f31272l);
            int i13 = this.f31273m;
            DSIconButtonComposablesKt.m8354IconButtonSurface_trzpw(modifier, i12, function0, color, dSIconButtonSize, valueOf, composer, (i13 & 14) | (i13 & 112) | (i13 & 896) | (i13 & 7168) | ((i13 >> 3) & 57344) | ((i13 << 3) & Opcodes.ASM7), 0);
            return;
        }
        composer.skipToGroupEnd();
    }
}
