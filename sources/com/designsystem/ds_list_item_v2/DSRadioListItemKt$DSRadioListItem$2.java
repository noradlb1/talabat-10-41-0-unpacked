package com.designsystem.ds_list_item_v2;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSRadioListItemKt$DSRadioListItem$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f32060g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f32061h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function1<Boolean, Unit> f32062i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Modifier f32063j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f32064k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ String f32065l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Integer f32066m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Integer f32067n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ Integer f32068o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ float f32069p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ boolean f32070q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ String f32071r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ String f32072s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ boolean f32073t;

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ int f32074u;

    /* renamed from: v  reason: collision with root package name */
    public final /* synthetic */ int f32075v;

    /* renamed from: w  reason: collision with root package name */
    public final /* synthetic */ int f32076w;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSRadioListItemKt$DSRadioListItem$2(String str, boolean z11, Function1<? super Boolean, Unit> function1, Modifier modifier, String str2, String str3, Integer num, Integer num2, Integer num3, float f11, boolean z12, String str4, String str5, boolean z13, int i11, int i12, int i13) {
        super(2);
        this.f32060g = str;
        this.f32061h = z11;
        this.f32062i = function1;
        this.f32063j = modifier;
        this.f32064k = str2;
        this.f32065l = str3;
        this.f32066m = num;
        this.f32067n = num2;
        this.f32068o = num3;
        this.f32069p = f11;
        this.f32070q = z12;
        this.f32071r = str4;
        this.f32072s = str5;
        this.f32073t = z13;
        this.f32074u = i11;
        this.f32075v = i12;
        this.f32076w = i13;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        Composer composer2 = composer;
        String str = this.f32060g;
        String str2 = str;
        DSRadioListItemKt.m8482DSRadioListItempU6N4AM(str2, this.f32061h, this.f32062i, this.f32063j, this.f32064k, this.f32065l, this.f32066m, this.f32067n, this.f32068o, this.f32069p, this.f32070q, this.f32071r, this.f32072s, this.f32073t, composer2, this.f32074u | 1, this.f32075v, this.f32076w);
    }
}
