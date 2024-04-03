package com.talabat.feature.darkstorescart.data.repository;

import com.talabat.feature.darkstorescart.data.local.CartLocalDataSource;
import com.talabat.feature.darkstorescart.data.model.CartVendor;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class DarkstoresCartRepository$createCartInfo$1 extends MutablePropertyReference0Impl {
    public DarkstoresCartRepository$createCartInfo$1(Object obj) {
        super(obj, CartLocalDataSource.class, "selectedVendor", "getSelectedVendor()Lcom/talabat/feature/darkstorescart/data/model/CartVendor;", 0);
    }

    @Nullable
    public Object get() {
        return ((CartLocalDataSource) this.receiver).getSelectedVendor();
    }

    public void set(@Nullable Object obj) {
        ((CartLocalDataSource) this.receiver).setSelectedVendor((CartVendor) obj);
    }
}
