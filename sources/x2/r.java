package x2;

import android.content.Context;
import bo.app.r1;
import com.google.android.gms.tasks.OnSuccessListener;
import java.util.List;

public final /* synthetic */ class r implements OnSuccessListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f44438a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f44439b;

    public /* synthetic */ r(Context context, List list) {
        this.f44438a = context;
        this.f44439b = list;
    }

    public final void onSuccess(Object obj) {
        r1.b(this.f44438a, this.f44439b, (Void) obj);
    }
}
