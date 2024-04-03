package com.deliveryhero.fluid.widgets.utils;

import android.view.View;
import android.view.ViewGroup;
import com.deliveryhero.fluid.telemetry.log.Logger;
import com.deliveryhero.fluid.values.Size;
import com.deliveryhero.fluid.widgets.containers.HorizontalAlignment;
import com.deliveryhero.fluid.widgets.containers.VerticalAlignment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class LayoutParamsUtilsKt$updateLayoutParams$setLayoutProps$1 extends Lambda implements Function1<View, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ View f30291g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Size f30292h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Size f30293i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Logger f30294j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ HorizontalAlignment f30295k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ VerticalAlignment f30296l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f30297m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f30298n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f30299o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ int f30300p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ int f30301q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ int f30302r;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LayoutParamsUtilsKt$updateLayoutParams$setLayoutProps$1(View view, Size size, Size size2, Logger logger, HorizontalAlignment horizontalAlignment, VerticalAlignment verticalAlignment, int i11, int i12, int i13, int i14, int i15, int i16) {
        super(1);
        this.f30291g = view;
        this.f30292h = size;
        this.f30293i = size2;
        this.f30294j = logger;
        this.f30295k = horizontalAlignment;
        this.f30296l = verticalAlignment;
        this.f30297m = i11;
        this.f30298n = i12;
        this.f30299o = i13;
        this.f30300p = i14;
        this.f30301q = i15;
        this.f30302r = i16;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((View) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
        ViewGroup.LayoutParams layoutParams = this.f30291g.getLayoutParams();
        if (layoutParams != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            boolean updateSize = LayoutParamsUtilsKt.updateSize(this.f30291g, marginLayoutParams, this.f30292h, this.f30293i);
            boolean updateAlignments = LayoutParamsUtilsKt.updateAlignments(this.f30294j, marginLayoutParams, this.f30295k, this.f30296l);
            boolean updateMargins = LayoutParamsUtilsKt.updateMargins(marginLayoutParams, this.f30297m, this.f30298n, this.f30299o, this.f30300p);
            boolean updateResistances = LayoutParamsUtilsKt.updateResistances(marginLayoutParams, this.f30301q, this.f30302r);
            if (updateSize || updateAlignments || updateMargins || updateResistances) {
                this.f30291g.setLayoutParams(marginLayoutParams);
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }
}
