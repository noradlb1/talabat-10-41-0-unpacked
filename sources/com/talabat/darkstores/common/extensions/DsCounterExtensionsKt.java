package com.talabat.darkstores.common.extensions;

import android.view.View;
import androidx.compose.ui.Alignment;
import com.designsystem.ds_stepper.DSCollapsibleQuantityStepper;
import com.talabat.darkstores.common.OnProductQuantityChangeListener;
import com.talabat.darkstores.common.OnProductQuantityChangeTrackingListener;
import com.talabat.feature.darkstorescart.data.model.Product;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u001aD\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0000¨\u0006\u000f"}, d2 = {"setupDesignSystemStepper", "", "Lcom/designsystem/ds_stepper/DSCollapsibleQuantityStepper;", "view", "Landroid/view/View;", "product", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "onProductQuantityChangeTrackingListener", "Lcom/talabat/darkstores/common/OnProductQuantityChangeTrackingListener;", "onProductQuantityChangeListener", "Lcom/talabat/darkstores/common/OnProductQuantityChangeListener;", "listPosition", "", "swimlaneStrategy", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class DsCounterExtensionsKt {
    public static final void setupDesignSystemStepper(@NotNull DSCollapsibleQuantityStepper dSCollapsibleQuantityStepper, @NotNull View view, @NotNull Product product, @Nullable OnProductQuantityChangeTrackingListener onProductQuantityChangeTrackingListener, @Nullable OnProductQuantityChangeListener onProductQuantityChangeListener, int i11, @Nullable String str) {
        int i12;
        DSCollapsibleQuantityStepper dSCollapsibleQuantityStepper2 = dSCollapsibleQuantityStepper;
        Intrinsics.checkNotNullParameter(dSCollapsibleQuantityStepper, "<this>");
        View view2 = view;
        Intrinsics.checkNotNullParameter(view, "view");
        Product product2 = product;
        Intrinsics.checkNotNullParameter(product, "product");
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = product.getCartCount();
        dSCollapsibleQuantityStepper.setMax(product.getStock());
        dSCollapsibleQuantityStepper.setAlignment(Alignment.Companion.getEnd());
        dSCollapsibleQuantityStepper.setInitialValue(Integer.valueOf(intRef.element));
        if (product.getStock() < 1) {
            i12 = 4;
        } else {
            i12 = 0;
        }
        dSCollapsibleQuantityStepper.setVisibility(i12);
        dSCollapsibleQuantityStepper.setOnValueChanged(new DsCounterExtensionsKt$setupDesignSystemStepper$1(intRef, onProductQuantityChangeListener, product, i11, onProductQuantityChangeTrackingListener, str, dSCollapsibleQuantityStepper, view));
    }

    public static /* synthetic */ void setupDesignSystemStepper$default(DSCollapsibleQuantityStepper dSCollapsibleQuantityStepper, View view, Product product, OnProductQuantityChangeTrackingListener onProductQuantityChangeTrackingListener, OnProductQuantityChangeListener onProductQuantityChangeListener, int i11, String str, int i12, Object obj) {
        if ((i12 & 32) != 0) {
            str = null;
        }
        setupDesignSystemStepper(dSCollapsibleQuantityStepper, view, product, onProductQuantityChangeTrackingListener, onProductQuantityChangeListener, i11, str);
    }
}
