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
public final class DSPrimaryButtonWithPriceKt$DSPrimaryButtonWithPrice$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f30768g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f30769h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f30770i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Integer f30771j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f30772k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ boolean f30773l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ boolean f30774m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f30775n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f30776o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ int f30777p;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSPrimaryButtonWithPriceKt$DSPrimaryButtonWithPrice$2(String str, String str2, Modifier modifier, Integer num, boolean z11, boolean z12, boolean z13, Function0<Unit> function0, int i11, int i12) {
        super(2);
        this.f30768g = str;
        this.f30769h = str2;
        this.f30770i = modifier;
        this.f30771j = num;
        this.f30772k = z11;
        this.f30773l = z12;
        this.f30774m = z13;
        this.f30775n = function0;
        this.f30776o = i11;
        this.f30777p = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        DSPrimaryButtonWithPriceKt.DSPrimaryButtonWithPrice(this.f30768g, this.f30769h, this.f30770i, this.f30771j, this.f30772k, this.f30773l, this.f30774m, this.f30775n, composer, this.f30776o | 1, this.f30777p);
    }
}
