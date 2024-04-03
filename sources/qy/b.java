package qy;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.wallet.ui.subscriptionManagement.view.adapter.SubscriptionCancellationReasonAdapter;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SubscriptionCancellationReasonAdapter f24084b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ RecyclerView.ViewHolder f24085c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f24086d;

    public /* synthetic */ b(SubscriptionCancellationReasonAdapter subscriptionCancellationReasonAdapter, RecyclerView.ViewHolder viewHolder, int i11) {
        this.f24084b = subscriptionCancellationReasonAdapter;
        this.f24085c = viewHolder;
        this.f24086d = i11;
    }

    public final void onClick(View view) {
        SubscriptionCancellationReasonAdapter.m6025onBindViewHolder$lambda2(this.f24084b, this.f24085c, this.f24086d, view);
    }
}
