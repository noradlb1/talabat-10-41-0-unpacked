package com.talabat.feature.tokenization.data.provider;

import android.content.Context;
import com.checkout.CheckoutApiServiceFactory;
import com.checkout.api.CheckoutApiService;
import com.checkout.base.model.Environment;
import com.talabat.core.context.domain.ApplicationContext;
import com.visa.checkout.Profile;
import dagger.Reusable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/talabat/feature/tokenization/data/provider/CheckoutApiClientProvider;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "provide", "Lcom/checkout/api/CheckoutApiService;", "publicKey", "", "environment", "Lcom/checkout/base/model/Environment;", "com_talabat_feature_tokenization_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Reusable
public final class CheckoutApiClientProvider {
    @NotNull
    private final Context context;

    @Inject
    public CheckoutApiClientProvider(@NotNull @ApplicationContext Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    @NotNull
    public final CheckoutApiService provide(@NotNull String str, @NotNull Environment environment, @NotNull Context context2) {
        Intrinsics.checkNotNullParameter(str, "publicKey");
        Intrinsics.checkNotNullParameter(environment, Profile.ENVIRONMENT);
        Intrinsics.checkNotNullParameter(context2, "context");
        return CheckoutApiServiceFactory.create(str, environment, context2);
    }
}
