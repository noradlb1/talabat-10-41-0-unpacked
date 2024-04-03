package zr;

import android.content.SharedPreferences;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.talabat.helpers.TalabatApplication;

public final /* synthetic */ class s implements OnCompleteListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SharedPreferences.Editor f63117b;

    public /* synthetic */ s(SharedPreferences.Editor editor) {
        this.f63117b = editor;
    }

    public final void onComplete(Task task) {
        TalabatApplication.m10628getFireBaseToken$lambda9(this.f63117b, task);
    }
}
