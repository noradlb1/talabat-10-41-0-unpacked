package com.designsystem.ds_small_button;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSSecondarySmallButtonKt$DSSecondarySmallButton$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f32733g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f32734h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Integer f32735i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f32736j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f32737k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ boolean f32738l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f32739m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f32740n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f32741o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSSecondarySmallButtonKt$DSSecondarySmallButton$1(String str, Modifier modifier, Integer num, boolean z11, boolean z12, boolean z13, Function0<Unit> function0, int i11, int i12) {
        super(2);
        this.f32733g = str;
        this.f32734h = modifier;
        this.f32735i = num;
        this.f32736j = z11;
        this.f32737k = z12;
        this.f32738l = z13;
        this.f32739m = function0;
        this.f32740n = i11;
        this.f32741o = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        DSSecondarySmallButtonKt.DSSecondarySmallButton(this.f32733g, this.f32734h, this.f32735i, this.f32736j, this.f32737k, this.f32738l, this.f32739m, composer, this.f32740n | 1, this.f32741o);
    }
}
