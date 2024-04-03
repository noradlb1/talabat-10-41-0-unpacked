package com.talabat;

import com.integration.IntegrationAppTracker;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.mvp.newrate.INewRatePresenter;
import library.talabat.mvp.newrate.INewRateView;
import library.talabat.mvp.newrate.NewRateInteractor;
import library.talabat.mvp.newrate.NewRatePresenter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.IAppTracker;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\b\u0010\u0012\u001a\u00020\u0004H\u0007R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/talabat/NewRateActivityDependencyProvider;", "", "()V", "appTracker", "Ltracking/IAppTracker;", "getAppTracker", "()Ltracking/IAppTracker;", "setAppTracker", "(Ltracking/IAppTracker;)V", "mockNewRateActivityPresenter", "Llibrary/talabat/mvp/newrate/INewRatePresenter;", "getMockNewRateActivityPresenter", "()Llibrary/talabat/mvp/newrate/INewRatePresenter;", "setMockNewRateActivityPresenter", "(Llibrary/talabat/mvp/newrate/INewRatePresenter;)V", "getNewRatePresenter", "view", "Llibrary/talabat/mvp/newrate/INewRateView;", "getTracker", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NewRateActivityDependencyProvider {
    @NotNull
    public static final NewRateActivityDependencyProvider INSTANCE = new NewRateActivityDependencyProvider();
    @Nullable
    private static IAppTracker appTracker;
    @Nullable
    private static INewRatePresenter mockNewRateActivityPresenter;

    private NewRateActivityDependencyProvider() {
    }

    @JvmStatic
    @NotNull
    public static final INewRatePresenter getNewRatePresenter(@NotNull INewRateView iNewRateView) {
        Intrinsics.checkNotNullParameter(iNewRateView, "view");
        INewRatePresenter iNewRatePresenter = mockNewRateActivityPresenter;
        if (iNewRatePresenter == null) {
            return new NewRatePresenter(iNewRateView, new NewRateInteractor());
        }
        return iNewRatePresenter;
    }

    @JvmStatic
    @NotNull
    public static final IAppTracker getTracker() {
        IAppTracker iAppTracker = appTracker;
        return iAppTracker == null ? IntegrationAppTracker.Companion.getAppTracker() : iAppTracker;
    }

    @Nullable
    public final IAppTracker getAppTracker() {
        return appTracker;
    }

    @Nullable
    public final INewRatePresenter getMockNewRateActivityPresenter() {
        return mockNewRateActivityPresenter;
    }

    public final void setAppTracker(@Nullable IAppTracker iAppTracker) {
        appTracker = iAppTracker;
    }

    public final void setMockNewRateActivityPresenter(@Nullable INewRatePresenter iNewRatePresenter) {
        mockNewRateActivityPresenter = iNewRatePresenter;
    }
}
