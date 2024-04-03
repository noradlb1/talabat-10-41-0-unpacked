package xp;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.talabat.firebase.TalabatFirebaseMessagingService;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class c implements OnCompleteListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1 f63037b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Function1 f63038c;

    public /* synthetic */ c(Function1 function1, Function1 function12) {
        this.f63037b = function1;
        this.f63038c = function12;
    }

    public final void onComplete(Task task) {
        TalabatFirebaseMessagingService.Companion.m10443getFCMToken$lambda0(this.f63037b, this.f63038c, task);
    }
}
