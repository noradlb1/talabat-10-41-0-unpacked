package ce;

import com.google.android.gms.tasks.OnFailureListener;
import com.instabug.survey.a;

public final /* synthetic */ class d implements OnFailureListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f50923a;

    public /* synthetic */ d(a aVar) {
        this.f50923a = aVar;
    }

    public final void onFailure(Exception exc) {
        this.f50923a.onFailure(new Exception("GooglePlay in-app review request failed", exc));
    }
}
