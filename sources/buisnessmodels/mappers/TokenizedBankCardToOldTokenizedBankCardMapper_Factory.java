package buisnessmodels.mappers;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class TokenizedBankCardToOldTokenizedBankCardMapper_Factory implements Factory<TokenizedBankCardToOldTokenizedBankCardMapper> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final TokenizedBankCardToOldTokenizedBankCardMapper_Factory INSTANCE = new TokenizedBankCardToOldTokenizedBankCardMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static TokenizedBankCardToOldTokenizedBankCardMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static TokenizedBankCardToOldTokenizedBankCardMapper newInstance() {
        return new TokenizedBankCardToOldTokenizedBankCardMapper();
    }

    public TokenizedBankCardToOldTokenizedBankCardMapper get() {
        return newInstance();
    }
}
