package com.talabat.feature.darkstorestooltip;

import com.talabat.feature.darkstorestooltip.domain.di.DarkstoresTooltipRepository;
import com.talabat.feature.darkstorestooltip.domain.model.TooltipKey;
import io.reactivex.Completable;
import io.reactivex.Single;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import qm.a;
import qm.b;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\f2\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/talabat/feature/darkstorestooltip/DarkstoresTooltipRepositoryImpl;", "Lcom/talabat/feature/darkstorestooltip/domain/di/DarkstoresTooltipRepository;", "dataSource", "Lcom/talabat/feature/darkstorestooltip/DarkstoresTooltipDataSource;", "(Lcom/talabat/feature/darkstorestooltip/DarkstoresTooltipDataSource;)V", "setTooltipShown", "Lio/reactivex/Completable;", "key", "Lcom/talabat/feature/darkstorestooltip/domain/model/TooltipKey;", "isShown", "", "wasTooltipAlreadyShown", "Lio/reactivex/Single;", "com_talabat_feature_darkstores-tooltip_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DarkstoresTooltipRepositoryImpl implements DarkstoresTooltipRepository {
    @NotNull
    private final DarkstoresTooltipDataSource dataSource;

    @Inject
    public DarkstoresTooltipRepositoryImpl(@NotNull DarkstoresTooltipDataSource darkstoresTooltipDataSource) {
        Intrinsics.checkNotNullParameter(darkstoresTooltipDataSource, "dataSource");
        this.dataSource = darkstoresTooltipDataSource;
    }

    /* access modifiers changed from: private */
    /* renamed from: setTooltipShown$lambda-1  reason: not valid java name */
    public static final Unit m10210setTooltipShown$lambda1(DarkstoresTooltipRepositoryImpl darkstoresTooltipRepositoryImpl, TooltipKey tooltipKey, boolean z11) {
        Intrinsics.checkNotNullParameter(darkstoresTooltipRepositoryImpl, "this$0");
        Intrinsics.checkNotNullParameter(tooltipKey, "$key");
        darkstoresTooltipRepositoryImpl.dataSource.setTooltipShown(tooltipKey.getKey(), z11);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    /* renamed from: wasTooltipAlreadyShown$lambda-0  reason: not valid java name */
    public static final Boolean m10211wasTooltipAlreadyShown$lambda0(DarkstoresTooltipRepositoryImpl darkstoresTooltipRepositoryImpl, TooltipKey tooltipKey) {
        Intrinsics.checkNotNullParameter(darkstoresTooltipRepositoryImpl, "this$0");
        Intrinsics.checkNotNullParameter(tooltipKey, "$key");
        return Boolean.valueOf(darkstoresTooltipRepositoryImpl.dataSource.wasTooltipAlreadyShown(tooltipKey.getKey()));
    }

    @NotNull
    public Completable setTooltipShown(@NotNull TooltipKey tooltipKey, boolean z11) {
        Intrinsics.checkNotNullParameter(tooltipKey, "key");
        Completable fromCallable = Completable.fromCallable(new a(this, tooltipKey, z11));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "fromCallable {\n         …y.key, isShown)\n        }");
        return fromCallable;
    }

    @NotNull
    public Single<Boolean> wasTooltipAlreadyShown(@NotNull TooltipKey tooltipKey) {
        Intrinsics.checkNotNullParameter(tooltipKey, "key");
        Single<Boolean> fromCallable = Single.fromCallable(new b(this, tooltipKey));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "fromCallable {\n         …yShown(key.key)\n        }");
        return fromCallable;
    }
}
