package com.talabat.darkstores.feature.home;

import androidx.lifecycle.LiveData;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.talabat.darkstores.common.OnProductQuantityChangeTrackingListener;
import com.talabat.darkstores.feature.home.swimlane.ProductClickTrackingAttribute;
import com.talabat.darkstores.model.Swimlane;
import com.talabat.feature.darkstorescart.data.model.Product;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001Be\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0007\u0012 \u0010\t\u001a\u001c\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\b0\n\u0012\u0018\u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00110\u00100\u000f¢\u0006\u0002\u0010\u0012J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\u0015\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J#\u0010 \u001a\u001c\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\b0\nHÆ\u0003J\u001b\u0010!\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00110\u00100\u000fHÆ\u0003Js\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u00072\"\b\u0002\u0010\t\u001a\u001c\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\b0\n2\u001a\b\u0002\u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00110\u00100\u000fHÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u0011HÖ\u0001J\t\u0010'\u001a\u00020\fHÖ\u0001R#\u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00110\u00100\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R+\u0010\t\u001a\u001c\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006("}, d2 = {"Lcom/talabat/darkstores/feature/home/SwimlaneViewHolderData;", "", "swimlane", "Lcom/talabat/darkstores/model/Swimlane;", "listener", "Lcom/talabat/darkstores/common/OnProductQuantityChangeTrackingListener;", "onViewAllClickListener", "Lkotlin/Function1;", "", "onProductClickListener", "Lkotlin/Function3;", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "", "Lcom/talabat/darkstores/feature/home/swimlane/ProductClickTrackingAttribute;", "cartMapLiveData", "Landroidx/lifecycle/LiveData;", "", "", "(Lcom/talabat/darkstores/model/Swimlane;Lcom/talabat/darkstores/common/OnProductQuantityChangeTrackingListener;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Landroidx/lifecycle/LiveData;)V", "getCartMapLiveData", "()Landroidx/lifecycle/LiveData;", "getListener", "()Lcom/talabat/darkstores/common/OnProductQuantityChangeTrackingListener;", "getOnProductClickListener", "()Lkotlin/jvm/functions/Function3;", "getOnViewAllClickListener", "()Lkotlin/jvm/functions/Function1;", "getSwimlane", "()Lcom/talabat/darkstores/model/Swimlane;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SwimlaneViewHolderData {
    @NotNull
    private final LiveData<Map<String, Integer>> cartMapLiveData;
    @NotNull
    private final OnProductQuantityChangeTrackingListener listener;
    @NotNull
    private final Function3<Product, String, ProductClickTrackingAttribute, Unit> onProductClickListener;
    @NotNull
    private final Function1<Swimlane, Unit> onViewAllClickListener;
    @NotNull
    private final Swimlane swimlane;

    public SwimlaneViewHolderData(@NotNull Swimlane swimlane2, @NotNull OnProductQuantityChangeTrackingListener onProductQuantityChangeTrackingListener, @NotNull Function1<? super Swimlane, Unit> function1, @NotNull Function3<? super Product, ? super String, ? super ProductClickTrackingAttribute, Unit> function3, @NotNull LiveData<Map<String, Integer>> liveData) {
        Intrinsics.checkNotNullParameter(swimlane2, "swimlane");
        Intrinsics.checkNotNullParameter(onProductQuantityChangeTrackingListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Intrinsics.checkNotNullParameter(function1, "onViewAllClickListener");
        Intrinsics.checkNotNullParameter(function3, "onProductClickListener");
        Intrinsics.checkNotNullParameter(liveData, "cartMapLiveData");
        this.swimlane = swimlane2;
        this.listener = onProductQuantityChangeTrackingListener;
        this.onViewAllClickListener = function1;
        this.onProductClickListener = function3;
        this.cartMapLiveData = liveData;
    }

    public static /* synthetic */ SwimlaneViewHolderData copy$default(SwimlaneViewHolderData swimlaneViewHolderData, Swimlane swimlane2, OnProductQuantityChangeTrackingListener onProductQuantityChangeTrackingListener, Function1<Swimlane, Unit> function1, Function3<Product, String, ProductClickTrackingAttribute, Unit> function3, LiveData<Map<String, Integer>> liveData, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            swimlane2 = swimlaneViewHolderData.swimlane;
        }
        if ((i11 & 2) != 0) {
            onProductQuantityChangeTrackingListener = swimlaneViewHolderData.listener;
        }
        OnProductQuantityChangeTrackingListener onProductQuantityChangeTrackingListener2 = onProductQuantityChangeTrackingListener;
        if ((i11 & 4) != 0) {
            function1 = swimlaneViewHolderData.onViewAllClickListener;
        }
        Function1<Swimlane, Unit> function12 = function1;
        if ((i11 & 8) != 0) {
            function3 = swimlaneViewHolderData.onProductClickListener;
        }
        Function3<Product, String, ProductClickTrackingAttribute, Unit> function32 = function3;
        if ((i11 & 16) != 0) {
            liveData = swimlaneViewHolderData.cartMapLiveData;
        }
        return swimlaneViewHolderData.copy(swimlane2, onProductQuantityChangeTrackingListener2, function12, function32, liveData);
    }

    @NotNull
    public final Swimlane component1() {
        return this.swimlane;
    }

    @NotNull
    public final OnProductQuantityChangeTrackingListener component2() {
        return this.listener;
    }

    @NotNull
    public final Function1<Swimlane, Unit> component3() {
        return this.onViewAllClickListener;
    }

    @NotNull
    public final Function3<Product, String, ProductClickTrackingAttribute, Unit> component4() {
        return this.onProductClickListener;
    }

    @NotNull
    public final LiveData<Map<String, Integer>> component5() {
        return this.cartMapLiveData;
    }

    @NotNull
    public final SwimlaneViewHolderData copy(@NotNull Swimlane swimlane2, @NotNull OnProductQuantityChangeTrackingListener onProductQuantityChangeTrackingListener, @NotNull Function1<? super Swimlane, Unit> function1, @NotNull Function3<? super Product, ? super String, ? super ProductClickTrackingAttribute, Unit> function3, @NotNull LiveData<Map<String, Integer>> liveData) {
        Intrinsics.checkNotNullParameter(swimlane2, "swimlane");
        Intrinsics.checkNotNullParameter(onProductQuantityChangeTrackingListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Intrinsics.checkNotNullParameter(function1, "onViewAllClickListener");
        Intrinsics.checkNotNullParameter(function3, "onProductClickListener");
        Intrinsics.checkNotNullParameter(liveData, "cartMapLiveData");
        return new SwimlaneViewHolderData(swimlane2, onProductQuantityChangeTrackingListener, function1, function3, liveData);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SwimlaneViewHolderData)) {
            return false;
        }
        SwimlaneViewHolderData swimlaneViewHolderData = (SwimlaneViewHolderData) obj;
        return Intrinsics.areEqual((Object) this.swimlane, (Object) swimlaneViewHolderData.swimlane) && Intrinsics.areEqual((Object) this.listener, (Object) swimlaneViewHolderData.listener) && Intrinsics.areEqual((Object) this.onViewAllClickListener, (Object) swimlaneViewHolderData.onViewAllClickListener) && Intrinsics.areEqual((Object) this.onProductClickListener, (Object) swimlaneViewHolderData.onProductClickListener) && Intrinsics.areEqual((Object) this.cartMapLiveData, (Object) swimlaneViewHolderData.cartMapLiveData);
    }

    @NotNull
    public final LiveData<Map<String, Integer>> getCartMapLiveData() {
        return this.cartMapLiveData;
    }

    @NotNull
    public final OnProductQuantityChangeTrackingListener getListener() {
        return this.listener;
    }

    @NotNull
    public final Function3<Product, String, ProductClickTrackingAttribute, Unit> getOnProductClickListener() {
        return this.onProductClickListener;
    }

    @NotNull
    public final Function1<Swimlane, Unit> getOnViewAllClickListener() {
        return this.onViewAllClickListener;
    }

    @NotNull
    public final Swimlane getSwimlane() {
        return this.swimlane;
    }

    public int hashCode() {
        return (((((((this.swimlane.hashCode() * 31) + this.listener.hashCode()) * 31) + this.onViewAllClickListener.hashCode()) * 31) + this.onProductClickListener.hashCode()) * 31) + this.cartMapLiveData.hashCode();
    }

    @NotNull
    public String toString() {
        Swimlane swimlane2 = this.swimlane;
        OnProductQuantityChangeTrackingListener onProductQuantityChangeTrackingListener = this.listener;
        Function1<Swimlane, Unit> function1 = this.onViewAllClickListener;
        Function3<Product, String, ProductClickTrackingAttribute, Unit> function3 = this.onProductClickListener;
        LiveData<Map<String, Integer>> liveData = this.cartMapLiveData;
        return "SwimlaneViewHolderData(swimlane=" + swimlane2 + ", listener=" + onProductQuantityChangeTrackingListener + ", onViewAllClickListener=" + function1 + ", onProductClickListener=" + function3 + ", cartMapLiveData=" + liveData + ")";
    }
}
