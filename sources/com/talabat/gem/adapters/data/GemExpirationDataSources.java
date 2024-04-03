package com.talabat.gem.adapters.data;

import com.talabat.gem.domain.entities.GemOffer;
import com.talabat.gem.ports.data.GemExpirationDataSourcesPort;
import com.talabat.talabatcommon.extentions.Flag;
import com.talabat.talabatcommon.extentions.RxKt;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0004H\u0016J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0006H\u0016¨\u0006\u0011"}, d2 = {"Lcom/talabat/gem/adapters/data/GemExpirationDataSources;", "Lcom/talabat/gem/ports/data/GemExpirationDataSourcesPort;", "()V", "isExpirationAlertShown", "", "loadExpiredOffer", "Lcom/talabat/gem/domain/entities/GemOffer;", "loadTriggerExpirationAlertFlag", "Lcom/talabat/talabatcommon/extentions/Flag;", "observeOnExpiredOffer", "Lio/reactivex/Observable;", "resetTriggerExpirationAlertFlag", "", "setExpirationAlertShown", "isAlertShown", "updateExpiredOffer", "offer", "com_talabat_Components_gem_gem"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GemExpirationDataSources implements GemExpirationDataSourcesPort {
    public boolean isExpirationAlertShown() {
        return CacheKt.getExpirationAlertShown();
    }

    @Nullable
    public GemOffer loadExpiredOffer() {
        return (GemOffer) RxKt.invoke(CacheKt.getExpiredOffer());
    }

    @NotNull
    public Flag loadTriggerExpirationAlertFlag() {
        return CacheKt.getExpirationTrigger();
    }

    @NotNull
    public Observable<GemOffer> observeOnExpiredOffer() {
        Observable<GemOffer> share = CacheKt.getExpiredOffer().share();
        Intrinsics.checkNotNullExpressionValue(share, "expiredOffer.share()");
        return share;
    }

    public void resetTriggerExpirationAlertFlag() {
        CacheKt.setExpirationTrigger(new Flag(true));
    }

    public void setExpirationAlertShown(boolean z11) {
        CacheKt.setExpirationAlertShown(z11);
    }

    public void updateExpiredOffer(@NotNull GemOffer gemOffer) {
        Intrinsics.checkNotNullParameter(gemOffer, "offer");
        CacheKt.getExpiredOffer().onNext(gemOffer);
    }
}
