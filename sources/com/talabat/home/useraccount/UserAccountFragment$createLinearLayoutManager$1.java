package com.talabat.home.useraccount;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.core.observabilityNew.domain.squads.home.UserAccountScreenPerformanceParams;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/talabat/home/useraccount/UserAccountFragment$createLinearLayoutManager$1", "Landroidx/recyclerview/widget/LinearLayoutManager;", "onLayoutCompleted", "", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UserAccountFragment$createLinearLayoutManager$1 extends LinearLayoutManager {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UserAccountFragment f60918b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UserAccountFragment$createLinearLayoutManager$1(Context context, UserAccountFragment userAccountFragment) {
        super(context);
        this.f60918b = userAccountFragment;
        setOrientation(1);
    }

    public void onLayoutCompleted(@Nullable RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.f60918b.getScreenTracker().stopTrace(UserAccountScreenPerformanceParams.INSTANCE.createScreenTrackerParams());
    }
}
