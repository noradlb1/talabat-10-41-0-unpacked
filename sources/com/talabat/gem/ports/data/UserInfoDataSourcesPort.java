package com.talabat.gem.ports.data;

import com.talabat.gem.domain.entities.Location;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003H\u0016J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¨\u0006\b"}, d2 = {"Lcom/talabat/gem/ports/data/UserInfoDataSourcesPort;", "", "observeOnLocalization", "Lio/reactivex/Observable;", "", "observeOnUserLocation", "Lcom/talabat/gem/domain/entities/Location;", "observeOnUserName", "com_talabat_Components_gem-core_gem-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface UserInfoDataSourcesPort {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        @NotNull
        public static Observable<String> observeOnLocalization(@NotNull UserInfoDataSourcesPort userInfoDataSourcesPort) {
            Observable<String> empty = Observable.empty();
            Intrinsics.checkNotNullExpressionValue(empty, "empty()");
            return empty;
        }

        @NotNull
        public static Observable<Location> observeOnUserLocation(@NotNull UserInfoDataSourcesPort userInfoDataSourcesPort) {
            Observable<Location> empty = Observable.empty();
            Intrinsics.checkNotNullExpressionValue(empty, "empty()");
            return empty;
        }

        @NotNull
        public static Observable<String> observeOnUserName(@NotNull UserInfoDataSourcesPort userInfoDataSourcesPort) {
            Observable<String> empty = Observable.empty();
            Intrinsics.checkNotNullExpressionValue(empty, "empty()");
            return empty;
        }
    }

    @NotNull
    Observable<String> observeOnLocalization();

    @NotNull
    Observable<Location> observeOnUserLocation();

    @NotNull
    Observable<String> observeOnUserName();
}
