package com.designsystem.ds_icon_button;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSIconButtonComposablesKt$IconButtonSurface$4 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f31259g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f31260h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f31261i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Color f31262j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ DSIconButtonSize f31263k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Boolean f31264l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f31265m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f31266n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSIconButtonComposablesKt$IconButtonSurface$4(Modifier modifier, int i11, Function0<Unit> function0, Color color, DSIconButtonSize dSIconButtonSize, Boolean bool, int i12, int i13) {
        super(2);
        this.f31259g = modifier;
        this.f31260h = i11;
        this.f31261i = function0;
        this.f31262j = color;
        this.f31263k = dSIconButtonSize;
        this.f31264l = bool;
        this.f31265m = i12;
        this.f31266n = i13;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        DSIconButtonComposablesKt.m8354IconButtonSurface_trzpw(this.f31259g, this.f31260h, this.f31261i, this.f31262j, this.f31263k, this.f31264l, composer, this.f31265m | 1, this.f31266n);
    }
}
