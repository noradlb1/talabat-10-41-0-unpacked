package com.talabat.feature.darkstorescart.data.di;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.room.migration.Migration;
import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.dispatcher.domain.RxSchedulersFactory;
import com.talabat.feature.darkstorescart.data.di.DarkstoresCartComponent;
import com.talabat.feature.darkstorescart.data.local.CartDao;
import com.talabat.feature.darkstorescart.data.local.CartDatabase;
import com.talabat.feature.darkstorescart.data.local.CartLocalDataSource;
import com.talabat.feature.darkstorescart.data.local.CartLocalDataSource_Factory;
import com.talabat.feature.darkstorescart.data.repository.DarkstoresCartRepository;
import com.talabat.feature.darkstorescart.data.repository.DarkstoresCartRepository_Factory;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;
import dagger.internal.SetFactory;
import dagger.internal.SingleCheck;
import java.util.Set;
import javax.inject.Provider;

@DaggerGenerated
public final class DaggerDarkstoresCartComponent {

    public static final class DarkstoresCartComponentImpl implements DarkstoresCartComponent {
        private Provider<CartLocalDataSource> cartLocalDataSourceProvider;
        private final DarkstoresCartComponentImpl darkstoresCartComponentImpl;
        private Provider<DarkstoresCartRepository> darkstoresCartRepositoryProvider;
        private Provider<Context> getContextProvider;
        private Provider<RxSchedulersFactory> getRxSchedulersFactoryProvider;
        private Provider<CartDao> provideCartDaoProvider;
        private Provider<CartDatabase> provideCartDatabaseProvider;
        private Provider<SharedPreferences> provideSharedPreferencesProvider;
        private Provider<Set<Migration>> setOfMigrationProvider;

        public static final class GetContextProvider implements Provider<Context> {
            private final ContextCoreLibApi contextCoreLibApi;

            public GetContextProvider(ContextCoreLibApi contextCoreLibApi2) {
                this.contextCoreLibApi = contextCoreLibApi2;
            }

            public Context get() {
                return (Context) Preconditions.checkNotNullFromComponent(this.contextCoreLibApi.getContext());
            }
        }

        public static final class GetRxSchedulersFactoryProvider implements Provider<RxSchedulersFactory> {
            private final DispatcherCoreLibApi dispatcherCoreLibApi;

            public GetRxSchedulersFactoryProvider(DispatcherCoreLibApi dispatcherCoreLibApi2) {
                this.dispatcherCoreLibApi = dispatcherCoreLibApi2;
            }

            public RxSchedulersFactory get() {
                return (RxSchedulersFactory) Preconditions.checkNotNullFromComponent(this.dispatcherCoreLibApi.getRxSchedulersFactory());
            }
        }

        private DarkstoresCartComponentImpl(ContextCoreLibApi contextCoreLibApi, DispatcherCoreLibApi dispatcherCoreLibApi) {
            this.darkstoresCartComponentImpl = this;
            initialize(contextCoreLibApi, dispatcherCoreLibApi);
        }

        private void initialize(ContextCoreLibApi contextCoreLibApi, DispatcherCoreLibApi dispatcherCoreLibApi) {
            this.getContextProvider = new GetContextProvider(contextCoreLibApi);
            this.setOfMigrationProvider = SetFactory.builder(4, 0).addProvider(CartDatabaseModule_ProvideMigrationFrom7To8Factory.create()).addProvider(CartDatabaseModule_ProvideMigrationFrom8To9Factory.create()).addProvider(CartDatabaseModule_ProvideMigrationFrom12To13Factory.create()).addProvider(CartDatabaseModule_ProvideMigrationFrom13To14Factory.create()).build();
            CartDatabaseModule_ProvideCartDatabaseFactory create = CartDatabaseModule_ProvideCartDatabaseFactory.create(this.getContextProvider, CartDatabaseModule_ProvideCartDatabaseEnvironmentFactory.create(), this.setOfMigrationProvider);
            this.provideCartDatabaseProvider = create;
            this.provideCartDaoProvider = CartDatabaseModule_ProvideCartDaoFactory.create(create);
            CartDatabaseModule_ProvideSharedPreferencesFactory create2 = CartDatabaseModule_ProvideSharedPreferencesFactory.create(this.getContextProvider);
            this.provideSharedPreferencesProvider = create2;
            this.cartLocalDataSourceProvider = CartLocalDataSource_Factory.create(create2);
            GetRxSchedulersFactoryProvider getRxSchedulersFactoryProvider2 = new GetRxSchedulersFactoryProvider(dispatcherCoreLibApi);
            this.getRxSchedulersFactoryProvider = getRxSchedulersFactoryProvider2;
            this.darkstoresCartRepositoryProvider = SingleCheck.provider(DarkstoresCartRepository_Factory.create(this.provideCartDaoProvider, this.cartLocalDataSourceProvider, getRxSchedulersFactoryProvider2));
        }

        public DarkstoresCartRepository cartRepository() {
            return this.darkstoresCartRepositoryProvider.get();
        }
    }

    public static final class Factory implements DarkstoresCartComponent.Factory {
        private Factory() {
        }

        public DarkstoresCartComponent create(ContextCoreLibApi contextCoreLibApi, DispatcherCoreLibApi dispatcherCoreLibApi) {
            Preconditions.checkNotNull(contextCoreLibApi);
            Preconditions.checkNotNull(dispatcherCoreLibApi);
            return new DarkstoresCartComponentImpl(contextCoreLibApi, dispatcherCoreLibApi);
        }
    }

    private DaggerDarkstoresCartComponent() {
    }

    public static DarkstoresCartComponent.Factory factory() {
        return new Factory();
    }
}
