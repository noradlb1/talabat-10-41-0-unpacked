package buisnessmodels.mappers;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class OldTokenizedBankCardToTokenizedBankCardMapper_Factory implements Factory<OldTokenizedBankCardToTokenizedBankCardMapper> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final OldTokenizedBankCardToTokenizedBankCardMapper_Factory INSTANCE = new OldTokenizedBankCardToTokenizedBankCardMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static OldTokenizedBankCardToTokenizedBankCardMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static OldTokenizedBankCardToTokenizedBankCardMapper newInstance() {
        return new OldTokenizedBankCardToTokenizedBankCardMapper();
    }

    public OldTokenizedBankCardToTokenizedBankCardMapper get() {
        return newInstance();
    }
}
