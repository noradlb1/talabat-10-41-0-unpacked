package com.designsystem.ds_counter;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class CounterComposablesKt$CounterLabels$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f31025g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ CounterChange f31026h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f31027i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f31028j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f31029k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ long f31030l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ long f31031m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ float f31032n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ float f31033o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ TextStyle f31034p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ Shape f31035q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ int f31036r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ int f31037s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CounterComposablesKt$CounterLabels$2(Modifier modifier, CounterChange counterChange, boolean z11, String str, String str2, long j11, long j12, float f11, float f12, TextStyle textStyle, Shape shape, int i11, int i12) {
        super(2);
        this.f31025g = modifier;
        this.f31026h = counterChange;
        this.f31027i = z11;
        this.f31028j = str;
        this.f31029k = str2;
        this.f31030l = j11;
        this.f31031m = j12;
        this.f31032n = f11;
        this.f31033o = f12;
        this.f31034p = textStyle;
        this.f31035q = shape;
        this.f31036r = i11;
        this.f31037s = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        CounterComposablesKt.m8326CounterLabelsQCWCmTk(this.f31025g, this.f31026h, this.f31027i, this.f31028j, this.f31029k, this.f31030l, this.f31031m, this.f31032n, this.f31033o, this.f31034p, this.f31035q, composer, this.f31036r | 1, this.f31037s);
    }
}
