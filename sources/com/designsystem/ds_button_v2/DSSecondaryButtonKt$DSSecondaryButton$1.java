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
public final class DSSecondaryButtonKt$DSSecondaryButton$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f30780g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f30781h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ String f30782i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Integer f30783j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f30784k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ boolean f30785l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ boolean f30786m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f30787n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f30788o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ int f30789p;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSSecondaryButtonKt$DSSecondaryButton$1(String str, Modifier modifier, String str2, Integer num, boolean z11, boolean z12, boolean z13, Function0<Unit> function0, int i11, int i12) {
        super(2);
        this.f30780g = str;
        this.f30781h = modifier;
        this.f30782i = str2;
        this.f30783j = num;
        this.f30784k = z11;
        this.f30785l = z12;
        this.f30786m = z13;
        this.f30787n = function0;
        this.f30788o = i11;
        this.f30789p = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        DSSecondaryButtonKt.DSSecondaryButton(this.f30780g, this.f30781h, this.f30782i, this.f30783j, this.f30784k, this.f30785l, this.f30786m, this.f30787n, composer, this.f30788o | 1, this.f30789p);
    }
}
