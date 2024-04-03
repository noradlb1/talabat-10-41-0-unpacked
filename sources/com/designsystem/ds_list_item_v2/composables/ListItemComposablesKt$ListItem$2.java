package com.designsystem.ds_list_item_v2.composables;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class ListItemComposablesKt$ListItem$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f32226g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f32227h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ String f32228i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f32229j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Integer f32230k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f32231l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Integer f32232m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Integer f32233n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ float f32234o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> f32235p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ Function3<Boolean, Composer, Integer, Unit> f32236q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ boolean f32237r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ int f32238s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ int f32239t;

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ int f32240u;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ListItemComposablesKt$ListItem$2(String str, Modifier modifier, String str2, String str3, Integer num, Function0<Unit> function0, Integer num2, Integer num3, float f11, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Function3<? super Boolean, ? super Composer, ? super Integer, Unit> function32, boolean z11, int i11, int i12, int i13) {
        super(2);
        this.f32226g = str;
        this.f32227h = modifier;
        this.f32228i = str2;
        this.f32229j = str3;
        this.f32230k = num;
        this.f32231l = function0;
        this.f32232m = num2;
        this.f32233n = num3;
        this.f32234o = f11;
        this.f32235p = function3;
        this.f32236q = function32;
        this.f32237r = z11;
        this.f32238s = i11;
        this.f32239t = i12;
        this.f32240u = i13;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        ListItemComposablesKt.m8490ListItemwn8IZOc(this.f32226g, this.f32227h, this.f32228i, this.f32229j, this.f32230k, this.f32231l, this.f32232m, this.f32233n, this.f32234o, this.f32235p, this.f32236q, this.f32237r, composer, this.f32238s | 1, this.f32239t, this.f32240u);
    }
}
