package com.talabat.darkstores.di;

import com.talabat.darkstores.data.darkstores.mapper.CartResponseMapper;
import com.talabat.darkstores.feature.cart.multibasket.Cart;
import com.talabat.feature.darkstorescart.data.model.CartResponse;
import com.talabat.mapper.ModelMapper;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u0007H'¨\u0006\b"}, d2 = {"Lcom/talabat/darkstores/di/DarkstoresDataModule;", "", "bindCartResponseMapper", "Lcom/talabat/mapper/ModelMapper;", "Lcom/talabat/feature/darkstorescart/data/model/CartResponse;", "Lcom/talabat/darkstores/feature/cart/multibasket/Cart;", "cartResponseMapper", "Lcom/talabat/darkstores/data/darkstores/mapper/CartResponseMapper;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public interface DarkstoresDataModule {
    @NotNull
    @Binds
    ModelMapper<CartResponse, Cart> bindCartResponseMapper(@NotNull CartResponseMapper cartResponseMapper);
}
