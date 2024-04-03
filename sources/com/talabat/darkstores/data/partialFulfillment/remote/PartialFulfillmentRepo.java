package com.talabat.darkstores.data.partialFulfillment.remote;

import com.talabat.darkstores.data.ConfigurationParameters;
import com.talabat.darkstores.data.DarkstoresConstantsKt;
import com.talabat.darkstores.data.partialFulfillment.model.PartialFulfillmentSaveRequest;
import com.talabat.darkstores.data.partialFulfillment.model.PreferencesResponse;
import com.talabat.darkstores.di.LibScope;
import hi.a;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/talabat/darkstores/data/partialFulfillment/remote/PartialFulfillmentRepo;", "", "partialFulfillmentApi", "Lcom/talabat/darkstores/data/partialFulfillment/remote/PartialFulfillmentApi;", "configurationParameters", "Lcom/talabat/darkstores/data/ConfigurationParameters;", "(Lcom/talabat/darkstores/data/partialFulfillment/remote/PartialFulfillmentApi;Lcom/talabat/darkstores/data/ConfigurationParameters;)V", "getPreferences", "Lio/reactivex/Single;", "Lcom/talabat/darkstores/data/partialFulfillment/model/PreferencesResponse;", "savePreference", "Lio/reactivex/Completable;", "controlCode", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
@LibScope
public final class PartialFulfillmentRepo {
    @NotNull
    private final ConfigurationParameters configurationParameters;
    @NotNull
    private final PartialFulfillmentApi partialFulfillmentApi;

    @Inject
    public PartialFulfillmentRepo(@NotNull PartialFulfillmentApi partialFulfillmentApi2, @NotNull ConfigurationParameters configurationParameters2) {
        Intrinsics.checkNotNullParameter(partialFulfillmentApi2, "partialFulfillmentApi");
        Intrinsics.checkNotNullParameter(configurationParameters2, "configurationParameters");
        this.partialFulfillmentApi = partialFulfillmentApi2;
        this.configurationParameters = configurationParameters2;
    }

    /* access modifiers changed from: private */
    /* renamed from: getPreferences$lambda-0  reason: not valid java name */
    public static final PreferencesResponse m9725getPreferences$lambda0(PreferencesResponse preferencesResponse) {
        Intrinsics.checkNotNullParameter(preferencesResponse, "it");
        return preferencesResponse;
    }

    @NotNull
    public final Single<PreferencesResponse> getPreferences() {
        Single<R> subscribeOn = this.partialFulfillmentApi.getPreferences(DarkstoresConstantsKt.ITEM_UNAVAILABILITY_TAG, "options", this.configurationParameters.getLanguageCode()).map(new a()).subscribeOn(Schedulers.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "partialFulfillmentApi.ge…scribeOn(Schedulers.io())");
        return subscribeOn;
    }

    @NotNull
    public final Completable savePreference(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "controlCode");
        Completable subscribeOn = this.partialFulfillmentApi.savePreference(DarkstoresConstantsKt.ITEM_UNAVAILABILITY_TAG, "options", new PartialFulfillmentSaveRequest(DarkstoresConstantsKt.ITEM_UNAVAILABILITY_TAG, str)).subscribeOn(Schedulers.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "partialFulfillmentApi.sa…scribeOn(Schedulers.io())");
        return subscribeOn;
    }
}
