package com.talabat.feature.darkstorescart.data.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import com.talabat.feature.darkstorescart.data.model.CartInfo;
import com.talabat.feature.darkstorescart.data.model.Product;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Database(entities = {Product.class, CartInfo.class}, exportSchema = false, version = 18)
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&¨\u0006\u0005"}, d2 = {"Lcom/talabat/feature/darkstorescart/data/local/CartDatabase;", "Landroidx/room/RoomDatabase;", "()V", "cartDao", "Lcom/talabat/feature/darkstorescart/data/local/CartDao;", "com_talabat_feature_darkstores-cart_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@TypeConverters({CampaignTriggerConverter.class, ProductUrlListTypeConverter.class})
public abstract class CartDatabase extends RoomDatabase {
    @NotNull
    public abstract CartDao cartDao();
}
