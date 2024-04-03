package py;

import android.view.View;
import com.talabat.wallet.ui.subscriptionManagement.view.SubscriptionManagementAdapter;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SubscriptionManagementAdapter f24062b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f24063c;

    public /* synthetic */ a(SubscriptionManagementAdapter subscriptionManagementAdapter, int i11) {
        this.f24062b = subscriptionManagementAdapter;
        this.f24063c = i11;
    }

    public final void onClick(View view) {
        SubscriptionManagementAdapter.m6018addListener$lambda1(this.f24062b, this.f24063c, view);
    }
}
