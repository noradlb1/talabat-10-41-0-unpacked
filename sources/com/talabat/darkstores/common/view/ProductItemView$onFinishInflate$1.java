package com.talabat.darkstores.common.view;

import com.talabat.darkstores.common.OnProductQuantityChangeListener;
import com.talabat.darkstores.common.view.ItemsCounter;
import com.talabat.darkstores.data.tracking.NewProductQuantityListener;
import com.talabat.feature.darkstorescart.data.model.Product;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/talabat/darkstores/common/view/ProductItemView$onFinishInflate$1", "Lcom/talabat/darkstores/common/view/ItemsCounter$QuantityChangeListener;", "onItemAdded", "", "onItemRemoved", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ProductItemView$onFinishInflate$1 implements ItemsCounter.QuantityChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ProductItemView f56180a;

    public ProductItemView$onFinishInflate$1(ProductItemView productItemView) {
        this.f56180a = productItemView;
    }

    public void onItemAdded() {
        Product access$getProduct$p = this.f56180a.product;
        if (access$getProduct$p != null) {
            ProductItemView productItemView = this.f56180a;
            OnProductQuantityChangeListener productQuantityChangeListener = productItemView.getProductQuantityChangeListener();
            if (productQuantityChangeListener != null) {
                OnProductQuantityChangeListener.DefaultImpls.increaseProductCount$default(productQuantityChangeListener, access$getProduct$p, access$getProduct$p.getCartCount() + 1, productItemView.listPosition, (Function0) null, 8, (Object) null);
            }
            NewProductQuantityListener newQuantityListener = productItemView.getNewQuantityListener();
            if (newQuantityListener != null) {
                newQuantityListener.onProductAdded(access$getProduct$p, access$getProduct$p.getCartCount() + 1, productItemView.listPosition);
            }
        }
    }

    public void onItemRemoved() {
        Product access$getProduct$p = this.f56180a.product;
        if (access$getProduct$p != null) {
            ProductItemView productItemView = this.f56180a;
            OnProductQuantityChangeListener productQuantityChangeListener = productItemView.getProductQuantityChangeListener();
            if (productQuantityChangeListener != null) {
                productQuantityChangeListener.decreaseProductCount(access$getProduct$p, access$getProduct$p.getCartCount() - 1, productItemView.listPosition);
            }
            NewProductQuantityListener newQuantityListener = productItemView.getNewQuantityListener();
            if (newQuantityListener != null) {
                newQuantityListener.onProductRemoved(access$getProduct$p, access$getProduct$p.getCartCount() + 1, productItemView.listPosition);
            }
        }
    }
}
