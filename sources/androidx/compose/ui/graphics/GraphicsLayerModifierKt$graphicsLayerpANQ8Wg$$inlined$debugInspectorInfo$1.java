package androidx.compose.ui.graphics;

import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;", "invoke", "androidx/compose/ui/platform/InspectableValueKt$debugInspectorInfo$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* renamed from: androidx.compose.ui.graphics.GraphicsLayerModifierKt$graphicsLayer-pANQ8Wg$$inlined$debugInspectorInfo$1  reason: invalid class name */
public final class GraphicsLayerModifierKt$graphicsLayerpANQ8Wg$$inlined$debugInspectorInfo$1 extends Lambda implements Function1<InspectorInfo, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ float f9614g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ float f9615h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ float f9616i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ float f9617j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ float f9618k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ float f9619l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ float f9620m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ float f9621n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ float f9622o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ float f9623p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ long f9624q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ Shape f9625r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ boolean f9626s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ RenderEffect f9627t;

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ long f9628u;

    /* renamed from: v  reason: collision with root package name */
    public final /* synthetic */ long f9629v;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GraphicsLayerModifierKt$graphicsLayerpANQ8Wg$$inlined$debugInspectorInfo$1(float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19, float f21, long j11, Shape shape, boolean z11, RenderEffect renderEffect, long j12, long j13) {
        super(1);
        this.f9614g = f11;
        this.f9615h = f12;
        this.f9616i = f13;
        this.f9617j = f14;
        this.f9618k = f15;
        this.f9619l = f16;
        this.f9620m = f17;
        this.f9621n = f18;
        this.f9622o = f19;
        this.f9623p = f21;
        this.f9624q = j11;
        this.f9625r = shape;
        this.f9626s = z11;
        this.f9627t = renderEffect;
        this.f9628u = j12;
        this.f9629v = j13;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((InspectorInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull InspectorInfo inspectorInfo) {
        Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
        inspectorInfo.setName("graphicsLayer");
        inspectorInfo.getProperties().set("scaleX", Float.valueOf(this.f9614g));
        inspectorInfo.getProperties().set("scaleY", Float.valueOf(this.f9615h));
        inspectorInfo.getProperties().set("alpha", Float.valueOf(this.f9616i));
        inspectorInfo.getProperties().set("translationX", Float.valueOf(this.f9617j));
        inspectorInfo.getProperties().set("translationY", Float.valueOf(this.f9618k));
        inspectorInfo.getProperties().set("shadowElevation", Float.valueOf(this.f9619l));
        inspectorInfo.getProperties().set("rotationX", Float.valueOf(this.f9620m));
        inspectorInfo.getProperties().set("rotationY", Float.valueOf(this.f9621n));
        inspectorInfo.getProperties().set("rotationZ", Float.valueOf(this.f9622o));
        inspectorInfo.getProperties().set("cameraDistance", Float.valueOf(this.f9623p));
        inspectorInfo.getProperties().set("transformOrigin", TransformOrigin.m3279boximpl(this.f9624q));
        inspectorInfo.getProperties().set("shape", this.f9625r);
        inspectorInfo.getProperties().set("clip", Boolean.valueOf(this.f9626s));
        inspectorInfo.getProperties().set("renderEffect", this.f9627t);
        inspectorInfo.getProperties().set("ambientShadowColor", Color.m2909boximpl(this.f9628u));
        inspectorInfo.getProperties().set("spotShadowColor", Color.m2909boximpl(this.f9629v));
    }
}
