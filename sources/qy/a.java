package qy;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.wallet.ui.subscriptionManagement.view.adapter.SubscriptionCancellationReasonAdapter;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SubscriptionCancellationReasonAdapter f24081b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ RecyclerView.ViewHolder f24082c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f24083d;

    public /* synthetic */ a(SubscriptionCancellationReasonAdapter subscriptionCancellationReasonAdapter, RecyclerView.ViewHolder viewHolder, int i11) {
        this.f24081b = subscriptionCancellationReasonAdapter;
        this.f24082c = viewHolder;
        this.f24083d = i11;
    }

    public final void onClick(View view) {
        SubscriptionCancellationReasonAdapter.m6024onBindViewHolder$lambda1(this.f24081b, this.f24082c, this.f24083d, view);
    }
}
