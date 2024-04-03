package com.talabat.darkstores.feature.product;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.talabat.darkstores.R;
import com.talabat.darkstores.common.OnProductQuantityChangeTrackingListener;
import com.talabat.darkstores.common.SwimlaneTrackingData;
import com.talabat.darkstores.common.base.BaseFragment;
import com.talabat.darkstores.feature.cart.CartFragmentViewModel;
import com.talabat.darkstores.feature.home.swimlane.ProductClickTrackingAttribute;
import com.talabat.darkstores.feature.product.views.AddToCartButton;
import com.talabat.darkstores.feature.tracking.TrackingCategoryId;
import com.talabat.feature.darkstorescart.data.model.Product;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import net.bytebuddy.jar.asm.Opcodes;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "<name for destructuring parameter 0>", "Lkotlin/Pair;", "", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ProductFragment$observerAddToCartButton$1 extends Lambda implements Function1<Pair<? extends Integer, ? extends Boolean>, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ProductFragment f56489g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProductFragment$observerAddToCartButton$1(ProductFragment productFragment) {
        super(1);
        this.f56489g = productFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Pair<Integer, Boolean>) (Pair) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Pair<Integer, Boolean> pair) {
        Intrinsics.checkNotNullParameter(pair, "<name for destructuring parameter 0>");
        int intValue = pair.component1().intValue();
        String str = null;
        if (pair.component2().booleanValue()) {
            CartFragmentViewModel cartFragmentViewModel = this.f56489g.getCartFragmentViewModel();
            Product product = this.f56489g.getViewModel().getProduct();
            ProductClickTrackingAttribute productClickTrackingAttribute = this.f56489g.getArgs().getProductClickTrackingAttribute();
            String swimlaneTitle = productClickTrackingAttribute != null ? productClickTrackingAttribute.getSwimlaneTitle() : null;
            ProductClickTrackingAttribute productClickTrackingAttribute2 = this.f56489g.getArgs().getProductClickTrackingAttribute();
            SwimlaneTrackingData swimlaneTrackingData = new SwimlaneTrackingData(swimlaneTitle, productClickTrackingAttribute2 != null ? Integer.valueOf(productClickTrackingAttribute2.getSwimlaneLength()) : null);
            String swimlaneRequestId = this.f56489g.getArgs().getSwimlaneRequestId();
            ProductClickTrackingAttribute productClickTrackingAttribute3 = this.f56489g.getArgs().getProductClickTrackingAttribute();
            if (productClickTrackingAttribute3 != null) {
                str = productClickTrackingAttribute3.getSwimlaneStrategy();
            }
            OnProductQuantityChangeTrackingListener.DefaultImpls.decreaseProductCount$default(cartFragmentViewModel, product, intValue, (Integer) null, (TrackingCategoryId) null, swimlaneTrackingData, swimlaneRequestId, str, false, Opcodes.L2I, (Object) null);
        } else {
            CartFragmentViewModel cartFragmentViewModel2 = this.f56489g.getCartFragmentViewModel();
            Product product2 = this.f56489g.getViewModel().getProduct();
            ProductClickTrackingAttribute productClickTrackingAttribute4 = this.f56489g.getArgs().getProductClickTrackingAttribute();
            String swimlaneTitle2 = productClickTrackingAttribute4 != null ? productClickTrackingAttribute4.getSwimlaneTitle() : null;
            ProductClickTrackingAttribute productClickTrackingAttribute5 = this.f56489g.getArgs().getProductClickTrackingAttribute();
            SwimlaneTrackingData swimlaneTrackingData2 = new SwimlaneTrackingData(swimlaneTitle2, productClickTrackingAttribute5 != null ? Integer.valueOf(productClickTrackingAttribute5.getSwimlaneLength()) : null);
            String swimlaneRequestId2 = this.f56489g.getArgs().getSwimlaneRequestId();
            ProductClickTrackingAttribute productClickTrackingAttribute6 = this.f56489g.getArgs().getProductClickTrackingAttribute();
            if (productClickTrackingAttribute6 != null) {
                str = productClickTrackingAttribute6.getSwimlaneStrategy();
            }
            String str2 = str;
            final ProductFragment productFragment = this.f56489g;
            OnProductQuantityChangeTrackingListener.DefaultImpls.increaseProductCount$default(cartFragmentViewModel2, product2, intValue, (Integer) null, (TrackingCategoryId) null, swimlaneTrackingData2, swimlaneRequestId2, str2, false, new Function0<Unit>() {
                public final void invoke() {
                    ProductFragment productFragment = productFragment;
                    MutableLiveData<Product> productReadyLiveData = productFragment.getViewModel().getProductReadyLiveData();
                    final ProductFragment productFragment2 = productFragment;
                    BaseFragment.observeNonNull$default(productFragment, productReadyLiveData, (LifecycleOwner) null, new Function1<Product, Unit>() {
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((Product) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Product product) {
                            Unit unit;
                            Pair<Integer, Integer> cartProductQuantityAndStock = productFragment2.getCartFragmentViewModel().cartProductQuantityAndStock(productFragment2.getArgs().getProduct().getId());
                            if (cartProductQuantityAndStock != null) {
                                ProductFragment productFragment = productFragment2;
                                ((AddToCartButton) productFragment._$_findCachedViewById(R.id.addToCartButton)).setupQuantityAndStock(cartProductQuantityAndStock.component1().intValue(), cartProductQuantityAndStock.component2().intValue());
                                unit = Unit.INSTANCE;
                            } else {
                                unit = null;
                            }
                            if (unit == null) {
                                ((AddToCartButton) productFragment2._$_findCachedViewById(R.id.addToCartButton)).setupQuantityAndStock(0, product.getStock());
                            }
                        }
                    }, 1, (Object) null);
                }
            }, Opcodes.L2I, (Object) null);
        }
        this.f56489g.getViewModel().quantityChanged(intValue);
    }
}
