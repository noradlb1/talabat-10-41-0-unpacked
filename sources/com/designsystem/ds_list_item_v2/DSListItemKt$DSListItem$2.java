package com.designsystem.ds_list_item_v2;

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
public final class DSListItemKt$DSListItem$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f31992g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f31993h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ String f31994i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f31995j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Integer f31996k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f31997l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Integer f31998m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Integer f31999n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ float f32000o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ Function3<Boolean, Composer, Integer, Unit> f32001p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ boolean f32002q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ int f32003r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ int f32004s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ int f32005t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSListItemKt$DSListItem$2(String str, Modifier modifier, String str2, String str3, Integer num, Function0<Unit> function0, Integer num2, Integer num3, float f11, Function3<? super Boolean, ? super Composer, ? super Integer, Unit> function3, boolean z11, int i11, int i12, int i13) {
        super(2);
        this.f31992g = str;
        this.f31993h = modifier;
        this.f31994i = str2;
        this.f31995j = str3;
        this.f31996k = num;
        this.f31997l = function0;
        this.f31998m = num2;
        this.f31999n = num3;
        this.f32000o = f11;
        this.f32001p = function3;
        this.f32002q = z11;
        this.f32003r = i11;
        this.f32004s = i12;
        this.f32005t = i13;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        DSListItemKt.m8481DSListItemWu8B24Y(this.f31992g, this.f31993h, this.f31994i, this.f31995j, this.f31996k, this.f31997l, this.f31998m, this.f31999n, this.f32000o, this.f32001p, this.f32002q, composer, this.f32003r | 1, this.f32004s, this.f32005t);
    }
}
