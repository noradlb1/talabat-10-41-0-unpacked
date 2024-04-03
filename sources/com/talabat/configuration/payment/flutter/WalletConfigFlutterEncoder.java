package com.talabat.configuration.payment.flutter;

import com.talabat.configuration.payment.TokenizedBankCard;
import com.talabat.configuration.payment.WalletConfig;
import com.talabat.mapper.ModelMapper;
import dagger.Reusable;
import java.util.ArrayList;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u001c\u0012\u0004\u0012\u00020\u0002\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00030\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001e\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/talabat/configuration/payment/flutter/WalletConfigFlutterEncoder;", "Lcom/talabat/mapper/ModelMapper;", "Lcom/talabat/configuration/payment/WalletConfig;", "", "", "", "tokenizedBankCardFlutterEncoder", "Lcom/talabat/configuration/payment/flutter/TokenizedBankCardFlutterEncoder;", "(Lcom/talabat/configuration/payment/flutter/TokenizedBankCardFlutterEncoder;)V", "apply", "source", "com_talabat_core_configuration_remote_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Reusable
public final class WalletConfigFlutterEncoder implements ModelMapper<WalletConfig, Map<String, ? extends Object>> {
    @NotNull
    private final TokenizedBankCardFlutterEncoder tokenizedBankCardFlutterEncoder;

    @Inject
    public WalletConfigFlutterEncoder(@NotNull TokenizedBankCardFlutterEncoder tokenizedBankCardFlutterEncoder2) {
        Intrinsics.checkNotNullParameter(tokenizedBankCardFlutterEncoder2, "tokenizedBankCardFlutterEncoder");
        this.tokenizedBankCardFlutterEncoder = tokenizedBankCardFlutterEncoder2;
    }

    @NotNull
    public Map<String, Object> apply(@NotNull WalletConfig walletConfig) {
        Intrinsics.checkNotNullParameter(walletConfig, "source");
        Pair[] pairArr = new Pair[2];
        pairArr[0] = TuplesKt.to("isAmexAvailable", Boolean.valueOf(walletConfig.isAmexAvailable()));
        Iterable<TokenizedBankCard> tokenizedBankCards = walletConfig.getTokenizedBankCards();
        TokenizedBankCardFlutterEncoder tokenizedBankCardFlutterEncoder2 = this.tokenizedBankCardFlutterEncoder;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(tokenizedBankCards, 10));
        for (TokenizedBankCard apply : tokenizedBankCards) {
            arrayList.add(tokenizedBankCardFlutterEncoder2.apply(apply));
        }
        pairArr[1] = TuplesKt.to("tokenizedBankCards", arrayList);
        return MapsKt__MapsKt.mapOf(pairArr);
    }
}
