package x2;

import android.content.Context;
import bo.app.r1;
import com.google.android.gms.tasks.OnSuccessListener;
import java.util.List;

public final /* synthetic */ class p implements OnSuccessListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f44436a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f44437b;

    public /* synthetic */ p(Context context, List list) {
        this.f44436a = context;
        this.f44437b = list;
    }

    public final void onSuccess(Object obj) {
        r1.a(this.f44436a, this.f44437b, (Void) obj);
    }
}
