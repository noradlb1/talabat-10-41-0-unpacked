package com.talabat.card_tokenization.provider;

import android.content.Context;
import com.checkout.CheckoutApiServiceFactory;
import com.checkout.api.CheckoutApiService;
import com.checkout.base.model.Environment;
import com.visa.checkout.Profile;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lcom/talabat/card_tokenization/provider/CheckoutApiClientProvider;", "", "()V", "provide", "Lcom/checkout/api/CheckoutApiService;", "publicKey", "", "environment", "Lcom/checkout/base/model/Environment;", "context", "Landroid/content/Context;", "card_tokenization_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CheckoutApiClientProvider {
    @NotNull
    public final CheckoutApiService provide(@NotNull String str, @NotNull Environment environment, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(str, "publicKey");
        Intrinsics.checkNotNullParameter(environment, Profile.ENVIRONMENT);
        Intrinsics.checkNotNullParameter(context, "context");
        return CheckoutApiServiceFactory.create(str, environment, context);
    }
}
