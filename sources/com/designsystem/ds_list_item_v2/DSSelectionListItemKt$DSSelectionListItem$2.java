package com.designsystem.ds_list_item_v2;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSSelectionListItemKt$DSSelectionListItem$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f32101g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f32102h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function1<Boolean, Unit> f32103i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Modifier f32104j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f32105k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ String f32106l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Integer f32107m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Integer f32108n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ Integer f32109o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ float f32110p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ boolean f32111q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ String f32112r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ String f32113s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ boolean f32114t;

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ Function3<Boolean, Composer, Integer, Unit> f32115u;

    /* renamed from: v  reason: collision with root package name */
    public final /* synthetic */ int f32116v;

    /* renamed from: w  reason: collision with root package name */
    public final /* synthetic */ int f32117w;

    /* renamed from: x  reason: collision with root package name */
    public final /* synthetic */ int f32118x;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSSelectionListItemKt$DSSelectionListItem$2(String str, boolean z11, Function1<? super Boolean, Unit> function1, Modifier modifier, String str2, String str3, Integer num, Integer num2, Integer num3, float f11, boolean z12, String str4, String str5, boolean z13, Function3<? super Boolean, ? super Composer, ? super Integer, Unit> function3, int i11, int i12, int i13) {
        super(2);
        this.f32101g = str;
        this.f32102h = z11;
        this.f32103i = function1;
        this.f32104j = modifier;
        this.f32105k = str2;
        this.f32106l = str3;
        this.f32107m = num;
        this.f32108n = num2;
        this.f32109o = num3;
        this.f32110p = f11;
        this.f32111q = z12;
        this.f32112r = str4;
        this.f32113s = str5;
        this.f32114t = z13;
        this.f32115u = function3;
        this.f32116v = i11;
        this.f32117w = i12;
        this.f32118x = i13;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        Composer composer2 = composer;
        String str = this.f32101g;
        String str2 = str;
        DSSelectionListItemKt.m8485DSSelectionListItem_zuBKE(str2, this.f32102h, this.f32103i, this.f32104j, this.f32105k, this.f32106l, this.f32107m, this.f32108n, this.f32109o, this.f32110p, this.f32111q, this.f32112r, this.f32113s, this.f32114t, this.f32115u, composer2, this.f32116v | 1, this.f32117w, this.f32118x);
    }
}
