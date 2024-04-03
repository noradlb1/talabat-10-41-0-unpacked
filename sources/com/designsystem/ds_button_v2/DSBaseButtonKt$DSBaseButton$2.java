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
public final class DSBaseButtonKt$DSBaseButton$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DSButtonTheme f30711g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f30712h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f30713i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f30714j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Integer f30715k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ boolean f30716l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ boolean f30717m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ boolean f30718n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ boolean f30719o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f30720p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ int f30721q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ int f30722r;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSBaseButtonKt$DSBaseButton$2(DSButtonTheme dSButtonTheme, String str, Modifier modifier, String str2, Integer num, boolean z11, boolean z12, boolean z13, boolean z14, Function0<Unit> function0, int i11, int i12) {
        super(2);
        this.f30711g = dSButtonTheme;
        this.f30712h = str;
        this.f30713i = modifier;
        this.f30714j = str2;
        this.f30715k = num;
        this.f30716l = z11;
        this.f30717m = z12;
        this.f30718n = z13;
        this.f30719o = z14;
        this.f30720p = function0;
        this.f30721q = i11;
        this.f30722r = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        DSBaseButtonKt.DSBaseButton(this.f30711g, this.f30712h, this.f30713i, this.f30714j, this.f30715k, this.f30716l, this.f30717m, this.f30718n, this.f30719o, this.f30720p, composer, this.f30721q | 1, this.f30722r);
    }
}
