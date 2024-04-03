package i40;

import com.google.android.gms.tasks.OnFailureListener;
import tracking.gtm.TalabatFirebase;

public final /* synthetic */ class a implements OnFailureListener {
    public final void onFailure(Exception exc) {
        TalabatFirebase.Companion.m10950sendToFirebase$lambda1(exc);
    }
}
