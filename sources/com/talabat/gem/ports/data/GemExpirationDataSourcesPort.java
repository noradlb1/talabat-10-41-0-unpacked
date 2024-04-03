package com.talabat.gem.ports.data;

import com.talabat.gem.domain.entities.GemOffer;
import com.talabat.talabatcommon.extentions.Flag;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0003H\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0005H\u0016¨\u0006\u0010"}, d2 = {"Lcom/talabat/gem/ports/data/GemExpirationDataSourcesPort;", "", "isExpirationAlertShown", "", "loadExpiredOffer", "Lcom/talabat/gem/domain/entities/GemOffer;", "loadTriggerExpirationAlertFlag", "Lcom/talabat/talabatcommon/extentions/Flag;", "observeOnExpiredOffer", "Lio/reactivex/Observable;", "resetTriggerExpirationAlertFlag", "", "setExpirationAlertShown", "isAlertShown", "updateExpiredOffer", "offer", "com_talabat_Components_gem-core_gem-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface GemExpirationDataSourcesPort {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static boolean isExpirationAlertShown(@NotNull GemExpirationDataSourcesPort gemExpirationDataSourcesPort) {
            return false;
        }

        @Nullable
        public static GemOffer loadExpiredOffer(@NotNull GemExpirationDataSourcesPort gemExpirationDataSourcesPort) {
            return null;
        }

        @NotNull
        public static Flag loadTriggerExpirationAlertFlag(@NotNull GemExpirationDataSourcesPort gemExpirationDataSourcesPort) {
            return new Flag(true);
        }

        @NotNull
        public static Observable<GemOffer> observeOnExpiredOffer(@NotNull GemExpirationDataSourcesPort gemExpirationDataSourcesPort) {
            Observable<GemOffer> empty = Observable.empty();
            Intrinsics.checkNotNullExpressionValue(empty, "empty()");
            return empty;
        }

        public static void resetTriggerExpirationAlertFlag(@NotNull GemExpirationDataSourcesPort gemExpirationDataSourcesPort) {
        }

        public static void setExpirationAlertShown(@NotNull GemExpirationDataSourcesPort gemExpirationDataSourcesPort, boolean z11) {
        }

        public static void updateExpiredOffer(@NotNull GemExpirationDataSourcesPort gemExpirationDataSourcesPort, @NotNull GemOffer gemOffer) {
            Intrinsics.checkNotNullParameter(gemOffer, "offer");
        }
    }

    boolean isExpirationAlertShown();

    @Nullable
    GemOffer loadExpiredOffer();

    @NotNull
    Flag loadTriggerExpirationAlertFlag();

    @NotNull
    Observable<GemOffer> observeOnExpiredOffer();

    void resetTriggerExpirationAlertFlag();

    void setExpirationAlertShown(boolean z11);

    void updateExpiredOffer(@NotNull GemOffer gemOffer);
}
