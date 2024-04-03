package com.designsystem.ds_small_button;

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
public final class DSBaseSmallButtonKt$DSBaseSmallButton$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DSButtonTheme f32697g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f32698h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f32699i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Integer f32700j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f32701k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ boolean f32702l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ boolean f32703m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ boolean f32704n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ boolean f32705o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f32706p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ int f32707q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ int f32708r;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSBaseSmallButtonKt$DSBaseSmallButton$2(DSButtonTheme dSButtonTheme, String str, Modifier modifier, Integer num, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, Function0<Unit> function0, int i11, int i12) {
        super(2);
        this.f32697g = dSButtonTheme;
        this.f32698h = str;
        this.f32699i = modifier;
        this.f32700j = num;
        this.f32701k = z11;
        this.f32702l = z12;
        this.f32703m = z13;
        this.f32704n = z14;
        this.f32705o = z15;
        this.f32706p = function0;
        this.f32707q = i11;
        this.f32708r = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        DSBaseSmallButtonKt.DSBaseSmallButton(this.f32697g, this.f32698h, this.f32699i, this.f32700j, this.f32701k, this.f32702l, this.f32703m, this.f32704n, this.f32705o, this.f32706p, composer, this.f32707q | 1, this.f32708r);
    }
}
