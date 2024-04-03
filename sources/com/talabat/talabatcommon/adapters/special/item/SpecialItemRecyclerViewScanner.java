package com.talabat.talabatcommon.adapters.special.item;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.talabatcommon.lifecycle.ContextLifecycleEventsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0018\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0002\u0010\u0007J\u001a\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\u0011\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\rH\u0016J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\u0014\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R \u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/talabat/talabatcommon/adapters/special/item/SpecialItemRecyclerViewScanner;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "createSpecialItemViewHolder", "Lkotlin/Function2;", "Landroid/content/Context;", "Landroid/view/ViewGroup;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "(Lkotlin/jvm/functions/Function2;)V", "onActivityCreated", "", "activity", "Landroid/app/Activity;", "state", "Landroid/os/Bundle;", "onActivityDestroyed", "onActivityPaused", "onActivityResumed", "onActivitySaveInstanceState", "outState", "onActivityStarted", "onActivityStopped", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SpecialItemRecyclerViewScanner implements Application.ActivityLifecycleCallbacks {
    /* access modifiers changed from: private */
    @NotNull
    public final Function2<Context, ViewGroup, RecyclerView.ViewHolder> createSpecialItemViewHolder;

    public SpecialItemRecyclerViewScanner(@NotNull Function2<? super Context, ? super ViewGroup, ? extends RecyclerView.ViewHolder> function2) {
        Intrinsics.checkNotNullParameter(function2, "createSpecialItemViewHolder");
        this.createSpecialItemViewHolder = function2;
    }

    public void onActivityCreated(@NotNull Activity activity, @Nullable Bundle bundle) {
        Pair pair;
        Pair pair2;
        Intrinsics.checkNotNullParameter(activity, "activity");
        SpecialItemRecyclerView specialItemRecyclerView = (SpecialItemRecyclerView) activity.getClass().getAnnotation(SpecialItemRecyclerView.class);
        if (specialItemRecyclerView != null && (pair = TuplesKt.to(specialItemRecyclerView.recyclerViewId(), Integer.valueOf(specialItemRecyclerView.specialItemIndex()))) != null && (pair2 = TuplesKt.to(Integer.valueOf(activity.getResources().getIdentifier((String) pair.getFirst(), "id", activity.getPackageName())), pair.getSecond())) != null) {
            ContextLifecycleEventsKt.withLifecycleEvents(activity, new SpecialItemRecyclerViewScanner$onActivityCreated$1$1(activity, pair2, this));
        }
    }

    public void onActivityDestroyed(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public void onActivityPaused(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public void onActivityResumed(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public void onActivitySaveInstanceState(@NotNull Activity activity, @NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(bundle, "outState");
    }

    public void onActivityStarted(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public void onActivityStopped(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }
}
