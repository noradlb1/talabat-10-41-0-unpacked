package com.talabat.itemdetailsbottomsheet.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.talabat.talabatcore.viewmodel.BaseViewModel;
import datamodels.CartMenuItem;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH&J\u0010\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH&J\u0010\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH&J\u001a\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u001b2\b\b\u0002\u0010 \u001a\u00020\u0015H&R!\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048FX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR!\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00048FX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0012\u0010\u0007R!\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00048FX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\t\u001a\u0004\b\u0016\u0010\u0007¨\u0006!"}, d2 = {"Lcom/talabat/itemdetailsbottomsheet/viewmodel/ItemDetailsViewModel;", "Lcom/talabat/talabatcore/viewmodel/BaseViewModel;", "()V", "imageUrl", "Landroidx/lifecycle/MutableLiveData;", "", "getImageUrl", "()Landroidx/lifecycle/MutableLiveData;", "imageUrl$delegate", "Lkotlin/Lazy;", "mDisposables", "Lio/reactivex/disposables/CompositeDisposable;", "getMDisposables", "()Lio/reactivex/disposables/CompositeDisposable;", "setMDisposables", "(Lio/reactivex/disposables/CompositeDisposable;)V", "price", "", "getPrice", "price$delegate", "quantity", "", "getQuantity", "quantity$delegate", "addItemToCart", "", "cartMenuItem", "Ldatamodels/CartMenuItem;", "onDecreaseQuantityClicked", "onIncreaseQuantityClicked", "setImage", "item", "screenWidth", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class ItemDetailsViewModel extends BaseViewModel {
    @NotNull
    private final Lazy imageUrl$delegate;
    @NotNull
    private CompositeDisposable mDisposables = new CompositeDisposable();
    @NotNull
    private final Lazy price$delegate;
    @NotNull
    private final Lazy quantity$delegate;

    public ItemDetailsViewModel() {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.quantity$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, ItemDetailsViewModel$quantity$2.INSTANCE);
        this.price$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, ItemDetailsViewModel$price$2.INSTANCE);
        this.imageUrl$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, ItemDetailsViewModel$imageUrl$2.INSTANCE);
    }

    public static /* synthetic */ void setImage$default(ItemDetailsViewModel itemDetailsViewModel, CartMenuItem cartMenuItem, int i11, int i12, Object obj) {
        if (obj == null) {
            if ((i12 & 2) != 0) {
                i11 = 0;
            }
            itemDetailsViewModel.setImage(cartMenuItem, i11);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setImage");
    }

    public abstract void addItemToCart(@NotNull CartMenuItem cartMenuItem);

    @NotNull
    public final MutableLiveData<String> getImageUrl() {
        return (MutableLiveData) this.imageUrl$delegate.getValue();
    }

    @NotNull
    public final CompositeDisposable getMDisposables() {
        return this.mDisposables;
    }

    @NotNull
    public final MutableLiveData<Float> getPrice() {
        return (MutableLiveData) this.price$delegate.getValue();
    }

    @NotNull
    public final MutableLiveData<Integer> getQuantity() {
        return (MutableLiveData) this.quantity$delegate.getValue();
    }

    public abstract void onDecreaseQuantityClicked(@NotNull CartMenuItem cartMenuItem);

    public abstract void onIncreaseQuantityClicked(@NotNull CartMenuItem cartMenuItem);

    public abstract void setImage(@NotNull CartMenuItem cartMenuItem, int i11);

    public final void setMDisposables(@NotNull CompositeDisposable compositeDisposable) {
        Intrinsics.checkNotNullParameter(compositeDisposable, "<set-?>");
        this.mDisposables = compositeDisposable;
    }
}
