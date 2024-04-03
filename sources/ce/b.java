package ce;

import com.google.android.gms.tasks.OnFailureListener;

public final /* synthetic */ class b implements OnFailureListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ com.instabug.survey.b f50921a;

    public /* synthetic */ b(com.instabug.survey.b bVar) {
        this.f50921a = bVar;
    }

    public final void onFailure(Exception exc) {
        this.f50921a.onFailure(new Exception("GooglePlay in-app review flow request failed", exc));
    }
}
