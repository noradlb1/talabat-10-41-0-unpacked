package com.talabat.home;

import android.content.Context;
import android.os.Bundle;
import androidx.navigation.ActivityNavigator;
import androidx.navigation.NavDestination;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.mvp.home.IHomePresenter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J0\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/talabat/home/SearchNavigator;", "Landroidx/navigation/ActivityNavigator;", "context", "Landroid/content/Context;", "homePresenter", "Llibrary/talabat/mvp/home/IHomePresenter;", "(Landroid/content/Context;Llibrary/talabat/mvp/home/IHomePresenter;)V", "navigate", "Landroidx/navigation/NavDestination;", "destination", "Landroidx/navigation/ActivityNavigator$Destination;", "args", "Landroid/os/Bundle;", "navOptions", "Landroidx/navigation/NavOptions;", "navigatorExtras", "Landroidx/navigation/Navigator$Extras;", "popBackStack", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Navigator.Name("home-search")
public final class SearchNavigator extends ActivityNavigator {
    @Nullable
    private final IHomePresenter homePresenter;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SearchNavigator(@NotNull Context context, @Nullable IHomePresenter iHomePresenter) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.homePresenter = iHomePresenter;
    }

    public boolean popBackStack() {
        return true;
    }

    @Nullable
    public NavDestination navigate(@NotNull ActivityNavigator.Destination destination, @Nullable Bundle bundle, @Nullable NavOptions navOptions, @Nullable Navigator.Extras extras) {
        Intrinsics.checkNotNullParameter(destination, "destination");
        IHomePresenter iHomePresenter = this.homePresenter;
        if (iHomePresenter != null) {
            iHomePresenter.toolbarSearchSelection();
        }
        return destination;
    }
}
