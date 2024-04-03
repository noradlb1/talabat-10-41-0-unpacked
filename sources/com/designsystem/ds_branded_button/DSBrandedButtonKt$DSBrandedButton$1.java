package com.designsystem.ds_branded_button;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSBrandedButtonKt$DSBrandedButton$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f30648g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f30649h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Integer f30650i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f30651j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f30652k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ boolean f30653l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f30654m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f30655n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f30656o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSBrandedButtonKt$DSBrandedButton$1(String str, Modifier modifier, Integer num, boolean z11, boolean z12, boolean z13, Function0<Unit> function0, int i11, int i12) {
        super(2);
        this.f30648g = str;
        this.f30649h = modifier;
        this.f30650i = num;
        this.f30651j = z11;
        this.f30652k = z12;
        this.f30653l = z13;
        this.f30654m = function0;
        this.f30655n = i11;
        this.f30656o = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        DSBrandedButtonKt.DSBrandedButton(this.f30648g, this.f30649h, this.f30650i, this.f30651j, this.f30652k, this.f30653l, this.f30654m, composer, this.f30655n | 1, this.f30656o);
    }
}
