package l9;

import android.content.Context;
import com.google.firebase.FirebaseApp;
import com.google.firebase.inject.Provider;

public final /* synthetic */ class a implements Provider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FirebaseApp f50651a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f50652b;

    public /* synthetic */ a(FirebaseApp firebaseApp, Context context) {
        this.f50651a = firebaseApp;
        this.f50652b = context;
    }

    public final Object get() {
        return this.f50651a.lambda$new$0(this.f50652b);
    }
}
