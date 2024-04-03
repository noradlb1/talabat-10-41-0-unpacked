package com.talabat.feature.darkstorescart.data.di;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import com.talabat.core.buildconfig.TalabatEnvironment;
import com.talabat.core.context.domain.ApplicationContext;
import com.talabat.feature.darkstorescart.data.local.CartDao;
import com.talabat.feature.darkstorescart.data.local.CartDatabase;
import com.talabat.feature.darkstorescart.data.local.CartDatabaseEnvironment;
import com.visa.checkout.Profile;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import java.util.Arrays;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J-\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0011\u0010\f\u001a\r\u0012\t\u0012\u00070\u000e¢\u0006\u0002\b\u000f0\rH\u0007J\b\u0010\u0010\u001a\u00020\u000bH\u0007J\b\u0010\u0011\u001a\u00020\u000eH\u0007J\b\u0010\u0012\u001a\u00020\u000eH\u0007J\b\u0010\u0013\u001a\u00020\u000eH\u0007J\b\u0010\u0014\u001a\u00020\u000eH\u0007J\u0012\u0010\u0015\u001a\u00020\u00162\b\b\u0001\u0010\b\u001a\u00020\tH\u0007¨\u0006\u0017"}, d2 = {"Lcom/talabat/feature/darkstorescart/data/di/CartDatabaseModule;", "", "()V", "provideCartDao", "Lcom/talabat/feature/darkstorescart/data/local/CartDao;", "cartDatabase", "Lcom/talabat/feature/darkstorescart/data/local/CartDatabase;", "provideCartDatabase", "context", "Landroid/content/Context;", "environment", "Lcom/talabat/feature/darkstorescart/data/local/CartDatabaseEnvironment;", "migrations", "", "Landroidx/room/migration/Migration;", "Lkotlin/jvm/JvmSuppressWildcards;", "provideCartDatabaseEnvironment", "provideMigrationFrom12To13", "provideMigrationFrom13To14", "provideMigrationFrom7To8", "provideMigrationFrom8To9", "provideSharedPreferences", "Landroid/content/SharedPreferences;", "com_talabat_feature_darkstores-cart_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public final class CartDatabaseModule {
    @NotNull
    public static final CartDatabaseModule INSTANCE = new CartDatabaseModule();

    private CartDatabaseModule() {
    }

    @NotNull
    @Provides
    public final CartDao provideCartDao(@NotNull CartDatabase cartDatabase) {
        Intrinsics.checkNotNullParameter(cartDatabase, "cartDatabase");
        return cartDatabase.cartDao();
    }

    @NotNull
    @Provides
    public final CartDatabase provideCartDatabase(@NotNull @ApplicationContext Context context, @NotNull CartDatabaseEnvironment cartDatabaseEnvironment, @NotNull Set<Migration> set) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(cartDatabaseEnvironment, Profile.ENVIRONMENT);
        Intrinsics.checkNotNullParameter(set, "migrations");
        String name2 = cartDatabaseEnvironment.name();
        RoomDatabase.Builder<CartDatabase> databaseBuilder = Room.databaseBuilder(context, CartDatabase.class, "cart-" + name2);
        Object[] array = set.toArray(new Migration[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        Migration[] migrationArr = (Migration[]) array;
        databaseBuilder.addMigrations((Migration[]) Arrays.copyOf(migrationArr, migrationArr.length));
        CartDatabase build = databaseBuilder.fallbackToDestructiveMigration().build();
        Intrinsics.checkNotNullExpressionValue(build, "databaseBuilder(\n       …ration()\n        .build()");
        return build;
    }

    @NotNull
    @Provides
    public final CartDatabaseEnvironment provideCartDatabaseEnvironment() {
        return CartDatabaseEnvironment.Companion.get(TalabatEnvironment.INSTANCE.getEnvironment(), "release");
    }

    @NotNull
    @IntoSet
    @Provides
    public final Migration provideMigrationFrom12To13() {
        return new CartDatabaseModule$provideMigrationFrom12To13$1();
    }

    @NotNull
    @IntoSet
    @Provides
    public final Migration provideMigrationFrom13To14() {
        return new CartDatabaseModule$provideMigrationFrom13To14$1();
    }

    @NotNull
    @IntoSet
    @Provides
    public final Migration provideMigrationFrom7To8() {
        return new CartDatabaseModule$provideMigrationFrom7To8$1();
    }

    @NotNull
    @IntoSet
    @Provides
    public final Migration provideMigrationFrom8To9() {
        return new CartDatabaseModule$provideMigrationFrom8To9$1();
    }

    @NotNull
    @Provides
    public final SharedPreferences provideSharedPreferences(@NotNull @ApplicationContext Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences sharedPreferences = context.getSharedPreferences("darkstores_preferences", 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…xt.MODE_PRIVATE\n        )");
        return sharedPreferences;
    }
}
