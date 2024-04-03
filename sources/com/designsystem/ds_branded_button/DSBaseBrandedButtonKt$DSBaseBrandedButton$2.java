package com.designsystem.ds_branded_button;

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
public final class DSBaseBrandedButtonKt$DSBaseBrandedButton$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DSButtonTheme f30637g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f30638h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f30639i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Integer f30640j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f30641k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ boolean f30642l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ boolean f30643m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f30644n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f30645o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSBaseBrandedButtonKt$DSBaseBrandedButton$2(DSButtonTheme dSButtonTheme, String str, Modifier modifier, Integer num, boolean z11, boolean z12, boolean z13, Function0<Unit> function0, int i11) {
        super(2);
        this.f30637g = dSButtonTheme;
        this.f30638h = str;
        this.f30639i = modifier;
        this.f30640j = num;
        this.f30641k = z11;
        this.f30642l = z12;
        this.f30643m = z13;
        this.f30644n = function0;
        this.f30645o = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        DSBaseBrandedButtonKt.DSBaseBrandedButton(this.f30637g, this.f30638h, this.f30639i, this.f30640j, this.f30641k, this.f30642l, this.f30643m, this.f30644n, composer, this.f30645o | 1);
    }
}
