package com.designsystem.ds_button_v2;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSPrimaryButtonKt$DSPrimaryButton$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f30737g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f30738h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ String f30739i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Integer f30740j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f30741k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ boolean f30742l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ boolean f30743m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f30744n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f30745o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ int f30746p;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSPrimaryButtonKt$DSPrimaryButton$1(String str, Modifier modifier, String str2, Integer num, boolean z11, boolean z12, boolean z13, Function0<Unit> function0, int i11, int i12) {
        super(2);
        this.f30737g = str;
        this.f30738h = modifier;
        this.f30739i = str2;
        this.f30740j = num;
        this.f30741k = z11;
        this.f30742l = z12;
        this.f30743m = z13;
        this.f30744n = function0;
        this.f30745o = i11;
        this.f30746p = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        DSPrimaryButtonKt.DSPrimaryButton(this.f30737g, this.f30738h, this.f30739i, this.f30740j, this.f30741k, this.f30742l, this.f30743m, this.f30744n, composer, this.f30745o | 1, this.f30746p);
    }
}
