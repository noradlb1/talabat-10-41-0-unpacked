package com.talabat.customer.di;

import android.content.Context;
import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.customer.data.LegacyCustomerRepository;
import com.talabat.customer.data.LegacyCustomerRepository_Factory;
import com.talabat.customer.data.convert.TokenizedBankCardMapper_Factory;
import com.talabat.customer.data.convert.TokenizedCreditCardMapper_Factory;
import com.talabat.customer.di.CustomerCoreLibComponent;
import com.talabat.customer.domain.CustomerRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;

@DaggerGenerated
public final class DaggerCustomerCoreLibComponent {

    public static final class CustomerCoreLibComponentImpl implements CustomerCoreLibComponent {
        private final CustomerCoreLibComponentImpl customerCoreLibComponentImpl;
        private Provider<CustomerRepository> customerRepositoryProvider;
        private Provider<Context> getContextProvider;
        private Provider<LegacyCustomerRepository> legacyCustomerRepositoryProvider;

        public static final class GetContextProvider implements Provider<Context> {
            private final ContextCoreLibApi contextCoreLibApi;

            public GetContextProvider(ContextCoreLibApi contextCoreLibApi2) {
                this.contextCoreLibApi = contextCoreLibApi2;
            }

            public Context get() {
                return (Context) Preconditions.checkNotNullFromComponent(this.contextCoreLibApi.getContext());
            }
        }

        private CustomerCoreLibComponentImpl(ContextCoreLibApi contextCoreLibApi) {
            this.customerCoreLibComponentImpl = this;
            initialize(contextCoreLibApi);
        }

        private void initialize(ContextCoreLibApi contextCoreLibApi) {
            GetContextProvider getContextProvider2 = new GetContextProvider(contextCoreLibApi);
            this.getContextProvider = getContextProvider2;
            LegacyCustomerRepository_Factory create = LegacyCustomerRepository_Factory.create(getContextProvider2, TokenizedBankCardMapper_Factory.create(), TokenizedCreditCardMapper_Factory.create(), LegacyCustomerModule_ProvideCustomerFactory.create());
            this.legacyCustomerRepositoryProvider = create;
            this.customerRepositoryProvider = SingleCheck.provider(create);
        }

        public CustomerRepository getRepository() {
            return this.customerRepositoryProvider.get();
        }
    }

    public static final class Factory implements CustomerCoreLibComponent.Factory {
        private Factory() {
        }

        public CustomerCoreLibComponent create(ContextCoreLibApi contextCoreLibApi) {
            Preconditions.checkNotNull(contextCoreLibApi);
            return new CustomerCoreLibComponentImpl(contextCoreLibApi);
        }
    }

    private DaggerCustomerCoreLibComponent() {
    }

    public static CustomerCoreLibComponent.Factory factory() {
        return new Factory();
    }
}
