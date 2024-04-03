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
public final class DSIconButtonKt$DSIconButton$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f31274g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f31275h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f31276i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Color f31277j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f31278k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ DSIconButtonSize f31279l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f31280m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f31281n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSIconButtonKt$DSIconButton$2(Modifier modifier, int i11, Function0<Unit> function0, Color color, boolean z11, DSIconButtonSize dSIconButtonSize, int i12, int i13) {
        super(2);
        this.f31274g = modifier;
        this.f31275h = i11;
        this.f31276i = function0;
        this.f31277j = color;
        this.f31278k = z11;
        this.f31279l = dSIconButtonSize;
        this.f31280m = i12;
        this.f31281n = i13;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        DSIconButtonKt.m8355DSIconButton_trzpw(this.f31274g, this.f31275h, this.f31276i, this.f31277j, this.f31278k, this.f31279l, composer, this.f31280m | 1, this.f31281n);
    }
}
