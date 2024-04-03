package com.talabat.darkstores.common.extensions;

import android.view.View;
import com.designsystem.ds_stepper.DSCollapsibleQuantityStepper;
import com.talabat.darkstores.common.OnProductQuantityChangeListener;
import com.talabat.darkstores.common.OnProductQuantityChangeTrackingListener;
import com.talabat.darkstores.common.SwimlaneTrackingData;
import com.talabat.darkstores.feature.tracking.TrackingCategoryId;
import com.talabat.feature.darkstorescart.data.model.Product;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import net.bytebuddy.jar.asm.Opcodes;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "newValue", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class DsCounterExtensionsKt$setupDesignSystemStepper$1 extends Lambda implements Function1<Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f56112g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ OnProductQuantityChangeListener f56113h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Product f56114i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f56115j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ OnProductQuantityChangeTrackingListener f56116k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ String f56117l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ DSCollapsibleQuantityStepper f56118m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ View f56119n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DsCounterExtensionsKt$setupDesignSystemStepper$1(Ref.IntRef intRef, OnProductQuantityChangeListener onProductQuantityChangeListener, Product product, int i11, OnProductQuantityChangeTrackingListener onProductQuantityChangeTrackingListener, String str, DSCollapsibleQuantityStepper dSCollapsibleQuantityStepper, View view) {
        super(1);
        this.f56112g = intRef;
        this.f56113h = onProductQuantityChangeListener;
        this.f56114i = product;
        this.f56115j = i11;
        this.f56116k = onProductQuantityChangeTrackingListener;
        this.f56117l = str;
        this.f56118m = dSCollapsibleQuantityStepper;
        this.f56119n = view;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i11) {
        int i12 = i11;
        if (this.f56112g.element > i12) {
            OnProductQuantityChangeListener onProductQuantityChangeListener = this.f56113h;
            if (onProductQuantityChangeListener != null) {
                onProductQuantityChangeListener.decreaseProductCount(this.f56114i, i12, Integer.valueOf(this.f56115j));
            }
            OnProductQuantityChangeTrackingListener onProductQuantityChangeTrackingListener = this.f56116k;
            if (onProductQuantityChangeTrackingListener != null) {
                OnProductQuantityChangeTrackingListener.DefaultImpls.decreaseProductCount$default(onProductQuantityChangeTrackingListener, this.f56114i, i11, Integer.valueOf(this.f56115j), (TrackingCategoryId) null, (SwimlaneTrackingData) null, (String) null, this.f56117l, false, Opcodes.INVOKESTATIC, (Object) null);
            }
        } else {
            OnProductQuantityChangeListener onProductQuantityChangeListener2 = this.f56113h;
            if (onProductQuantityChangeListener2 != null) {
                Product product = this.f56114i;
                Integer valueOf = Integer.valueOf(this.f56115j);
                final DSCollapsibleQuantityStepper dSCollapsibleQuantityStepper = this.f56118m;
                final View view = this.f56119n;
                final Product product2 = this.f56114i;
                final OnProductQuantityChangeTrackingListener onProductQuantityChangeTrackingListener2 = this.f56116k;
                final OnProductQuantityChangeListener onProductQuantityChangeListener3 = this.f56113h;
                final int i13 = this.f56115j;
                final String str = this.f56117l;
                onProductQuantityChangeListener2.increaseProductCount(product, i12, valueOf, new Function0<Unit>() {
                    public final void invoke() {
                        DsCounterExtensionsKt.setupDesignSystemStepper(dSCollapsibleQuantityStepper, view, product2, onProductQuantityChangeTrackingListener2, onProductQuantityChangeListener3, i13, str);
                    }
                });
            }
            OnProductQuantityChangeTrackingListener onProductQuantityChangeTrackingListener3 = this.f56116k;
            if (onProductQuantityChangeTrackingListener3 != null) {
                Product product3 = this.f56114i;
                Integer valueOf2 = Integer.valueOf(this.f56115j);
                String str2 = this.f56117l;
                final DSCollapsibleQuantityStepper dSCollapsibleQuantityStepper2 = this.f56118m;
                View view2 = this.f56119n;
                Product product4 = this.f56114i;
                OnProductQuantityChangeTrackingListener onProductQuantityChangeTrackingListener4 = this.f56116k;
                final OnProductQuantityChangeListener onProductQuantityChangeListener4 = this.f56113h;
                final View view3 = view2;
                final Product product5 = product4;
                final OnProductQuantityChangeTrackingListener onProductQuantityChangeTrackingListener5 = onProductQuantityChangeTrackingListener4;
                final int i14 = this.f56115j;
                final String str3 = str2;
                OnProductQuantityChangeTrackingListener.DefaultImpls.increaseProductCount$default(onProductQuantityChangeTrackingListener3, product3, i11, valueOf2, (TrackingCategoryId) null, (SwimlaneTrackingData) null, (String) null, str2, false, new Function0<Unit>() {
                    public final void invoke() {
                        DsCounterExtensionsKt.setupDesignSystemStepper(dSCollapsibleQuantityStepper2, view3, product5, onProductQuantityChangeTrackingListener5, onProductQuantityChangeListener4, i14, str3);
                    }
                }, Opcodes.INVOKESTATIC, (Object) null);
            }
        }
        DSCollapsibleQuantityStepper dSCollapsibleQuantityStepper3 = this.f56118m;
        boolean z11 = true;
        if (i12 != 1) {
            z11 = false;
        }
        dSCollapsibleQuantityStepper3.setShouldShowBinIcon(z11);
        this.f56112g.element = i12;
    }
}
