package com.designsystem.ds_input_field;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSTextAreaFieldKt$DSTextAreaField$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f31487g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f31488h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ String f31489i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f31490j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function1<String, Unit> f31491k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function1<String, Unit> f31492l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ boolean f31493m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ DSInputFieldState f31494n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f31495o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ int f31496p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ int f31497q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ int f31498r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ int f31499s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ int f31500t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSTextAreaFieldKt$DSTextAreaField$2(Modifier modifier, String str, String str2, String str3, Function1<? super String, Unit> function1, Function1<? super String, Unit> function12, boolean z11, DSInputFieldState dSInputFieldState, int i11, int i12, int i13, int i14, int i15, int i16) {
        super(2);
        this.f31487g = modifier;
        this.f31488h = str;
        this.f31489i = str2;
        this.f31490j = str3;
        this.f31491k = function1;
        this.f31492l = function12;
        this.f31493m = z11;
        this.f31494n = dSInputFieldState;
        this.f31495o = i11;
        this.f31496p = i12;
        this.f31497q = i13;
        this.f31498r = i14;
        this.f31499s = i15;
        this.f31500t = i16;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        DSTextAreaFieldKt.m8384DSTextAreaFieldA1rYqW4(this.f31487g, this.f31488h, this.f31489i, this.f31490j, this.f31491k, this.f31492l, this.f31493m, this.f31494n, this.f31495o, this.f31496p, this.f31497q, composer, this.f31498r | 1, this.f31499s, this.f31500t);
    }
}
