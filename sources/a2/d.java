package a2;

import android.content.Context;
import androidx.activity.contextaware.OnContextAvailableListener;
import androidx.fragment.app.FragmentActivity;

public final /* synthetic */ class d implements OnContextAvailableListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f35591a;

    public /* synthetic */ d(FragmentActivity fragmentActivity) {
        this.f35591a = fragmentActivity;
    }

    public final void onContextAvailable(Context context) {
        this.f35591a.lambda$init$3(context);
    }
}
