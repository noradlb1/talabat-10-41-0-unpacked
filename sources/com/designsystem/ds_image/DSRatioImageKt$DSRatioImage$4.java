package com.designsystem.ds_image;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSRatioImageKt$DSRatioImage$4 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f31302g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ DSImageRatio f31303h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f31304i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f31305j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ float f31306k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ float f31307l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ ContentScale f31308m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ float f31309n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ Color f31310o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ Dp f31311p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ int f31312q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ int f31313r;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSRatioImageKt$DSRatioImage$4(String str, DSImageRatio dSImageRatio, Modifier modifier, String str2, float f11, float f12, ContentScale contentScale, float f13, Color color, Dp dp2, int i11, int i12) {
        super(2);
        this.f31302g = str;
        this.f31303h = dSImageRatio;
        this.f31304i = modifier;
        this.f31305j = str2;
        this.f31306k = f11;
        this.f31307l = f12;
        this.f31308m = contentScale;
        this.f31309n = f13;
        this.f31310o = color;
        this.f31311p = dp2;
        this.f31312q = i11;
        this.f31313r = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        DSRatioImageKt.m8361DSRatioImageDSyytA(this.f31302g, this.f31303h, this.f31304i, this.f31305j, this.f31306k, this.f31307l, this.f31308m, this.f31309n, this.f31310o, this.f31311p, composer, this.f31312q | 1, this.f31313r);
    }
}
