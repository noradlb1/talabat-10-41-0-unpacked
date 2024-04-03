package com.talabat.feature.darkstorescarrierbag.data;

import bm.a;
import bm.b;
import com.talabat.feature.darkstorescarrierbag.data.datasource.DarkstoresCarrierBagLocalDataSource;
import com.talabat.feature.darkstorescarrierbag.domain.repository.DarkstoresCarrierBagRepository;
import io.reactivex.Completable;
import io.reactivex.Single;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/talabat/feature/darkstorescarrierbag/data/DarkstoresCarrierBagRepositoryImpl;", "Lcom/talabat/feature/darkstorescarrierbag/domain/repository/DarkstoresCarrierBagRepository;", "dataSource", "Lcom/talabat/feature/darkstorescarrierbag/data/datasource/DarkstoresCarrierBagLocalDataSource;", "(Lcom/talabat/feature/darkstorescarrierbag/data/datasource/DarkstoresCarrierBagLocalDataSource;)V", "isDarkstoresCarrierBagFakeDoorTestShown", "Lio/reactivex/Single;", "", "setDarkstoresCarrierBagFakeDoorTestShown", "Lio/reactivex/Completable;", "shown", "com_talabat_feature_darkstores-carrier-bag_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DarkstoresCarrierBagRepositoryImpl implements DarkstoresCarrierBagRepository {
    @NotNull
    private final DarkstoresCarrierBagLocalDataSource dataSource;

    @Inject
    public DarkstoresCarrierBagRepositoryImpl(@NotNull DarkstoresCarrierBagLocalDataSource darkstoresCarrierBagLocalDataSource) {
        Intrinsics.checkNotNullParameter(darkstoresCarrierBagLocalDataSource, "dataSource");
        this.dataSource = darkstoresCarrierBagLocalDataSource;
    }

    /* access modifiers changed from: private */
    /* renamed from: isDarkstoresCarrierBagFakeDoorTestShown$lambda-0  reason: not valid java name */
    public static final Boolean m10153isDarkstoresCarrierBagFakeDoorTestShown$lambda0(DarkstoresCarrierBagRepositoryImpl darkstoresCarrierBagRepositoryImpl) {
        Intrinsics.checkNotNullParameter(darkstoresCarrierBagRepositoryImpl, "this$0");
        return Boolean.valueOf(darkstoresCarrierBagRepositoryImpl.dataSource.isDarkstoresCarrierBagFakeDoorTestShown());
    }

    /* access modifiers changed from: private */
    /* renamed from: setDarkstoresCarrierBagFakeDoorTestShown$lambda-1  reason: not valid java name */
    public static final Unit m10154setDarkstoresCarrierBagFakeDoorTestShown$lambda1(DarkstoresCarrierBagRepositoryImpl darkstoresCarrierBagRepositoryImpl, boolean z11) {
        Intrinsics.checkNotNullParameter(darkstoresCarrierBagRepositoryImpl, "this$0");
        darkstoresCarrierBagRepositoryImpl.dataSource.setDarkstoresCarrierBagFakeDoorTestShown(z11);
        return Unit.INSTANCE;
    }

    @NotNull
    public Single<Boolean> isDarkstoresCarrierBagFakeDoorTestShown() {
        Single<Boolean> fromCallable = Single.fromCallable(new a(this));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "fromCallable {\n         …DoorTestShown()\n        }");
        return fromCallable;
    }

    @NotNull
    public Completable setDarkstoresCarrierBagFakeDoorTestShown(boolean z11) {
        Completable fromCallable = Completable.fromCallable(new b(this, z11));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "fromCallable {\n         …estShown(shown)\n        }");
        return fromCallable;
    }
}
