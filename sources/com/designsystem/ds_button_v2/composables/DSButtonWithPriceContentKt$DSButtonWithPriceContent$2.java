package com.designsystem.ds_button_v2.composables;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import com.designsystem.ds_button_v2.DSButtonTheme;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSButtonWithPriceContentKt$DSButtonWithPriceContent$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DSButtonTheme f30865g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f30866h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ String f30867i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Modifier f30868j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Integer f30869k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ boolean f30870l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ boolean f30871m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ boolean f30872n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f30873o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ DSButtonWithPriceStyle f30874p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f30875q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ int f30876r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ int f30877s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSButtonWithPriceContentKt$DSButtonWithPriceContent$2(DSButtonTheme dSButtonTheme, String str, String str2, Modifier modifier, Integer num, boolean z11, boolean z12, boolean z13, MutableInteractionSource mutableInteractionSource, DSButtonWithPriceStyle dSButtonWithPriceStyle, Function0<Unit> function0, int i11, int i12) {
        super(2);
        this.f30865g = dSButtonTheme;
        this.f30866h = str;
        this.f30867i = str2;
        this.f30868j = modifier;
        this.f30869k = num;
        this.f30870l = z11;
        this.f30871m = z12;
        this.f30872n = z13;
        this.f30873o = mutableInteractionSource;
        this.f30874p = dSButtonWithPriceStyle;
        this.f30875q = function0;
        this.f30876r = i11;
        this.f30877s = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        DSButtonWithPriceContentKt.DSButtonWithPriceContent(this.f30865g, this.f30866h, this.f30867i, this.f30868j, this.f30869k, this.f30870l, this.f30871m, this.f30872n, this.f30873o, this.f30874p, this.f30875q, composer, this.f30876r | 1, this.f30877s);
    }
}
