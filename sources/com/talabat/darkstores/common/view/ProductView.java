package com.talabat.darkstores.common.view;

import com.talabat.darkstores.common.OnProductQuantityChangeListener;
import com.talabat.darkstores.data.tracking.NewProductQuantityListener;
import com.talabat.feature.darkstorescart.data.model.Product;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J-\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015H&¢\u0006\u0002\u0010\u0016R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u0004\u0018\u00010\tX¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/talabat/darkstores/common/view/ProductView;", "", "newQuantityListener", "Lcom/talabat/darkstores/data/tracking/NewProductQuantityListener;", "getNewQuantityListener", "()Lcom/talabat/darkstores/data/tracking/NewProductQuantityListener;", "setNewQuantityListener", "(Lcom/talabat/darkstores/data/tracking/NewProductQuantityListener;)V", "productQuantityChangeListener", "Lcom/talabat/darkstores/common/OnProductQuantityChangeListener;", "getProductQuantityChangeListener", "()Lcom/talabat/darkstores/common/OnProductQuantityChangeListener;", "setProductQuantityChangeListener", "(Lcom/talabat/darkstores/common/OnProductQuantityChangeListener;)V", "setProduct", "", "product", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "canShowSponsored", "", "listPosition", "", "(Lcom/talabat/feature/darkstorescart/data/model/Product;ZLjava/lang/Integer;)V", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ProductView {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void setProduct$default(ProductView productView, Product product, boolean z11, Integer num, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 2) != 0) {
                    z11 = false;
                }
                if ((i11 & 4) != 0) {
                    num = null;
                }
                productView.setProduct(product, z11, num);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setProduct");
        }
    }

    @Nullable
    NewProductQuantityListener getNewQuantityListener();

    @Nullable
    OnProductQuantityChangeListener getProductQuantityChangeListener();

    void setNewQuantityListener(@Nullable NewProductQuantityListener newProductQuantityListener);

    void setProduct(@Nullable Product product, boolean z11, @Nullable Integer num);

    void setProductQuantityChangeListener(@Nullable OnProductQuantityChangeListener onProductQuantityChangeListener);
}
