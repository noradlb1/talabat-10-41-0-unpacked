package tracking.firebaseauth;

import android.content.Intent;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.talabat.BuildConfig;
import com.talabat.secrets.Secrets;
import com.talabat.talabatcore.logger.LogManager;
import h40.a;
import h40.b;
import h40.c;
import h40.d;
import h40.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Ltracking/firebaseauth/TalabatFirebaseImpl;", "Ltracking/firebaseauth/TalabatFirebaseAuth;", "()V", "secrets", "Lcom/talabat/secrets/Secrets;", "getSecrets", "()Lcom/talabat/secrets/Secrets;", "signInWithEmailAndPassword", "", "signInWithEmailLink", "email", "", "verifyEmailLink", "intent", "Landroid/content/Intent;", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TalabatFirebaseImpl implements TalabatFirebaseAuth {
    @NotNull
    private final Secrets secrets = new Secrets();

    /* access modifiers changed from: private */
    /* renamed from: signInWithEmailAndPassword$lambda-2  reason: not valid java name */
    public static final void m10945signInWithEmailAndPassword$lambda2(Exception exc) {
        Intrinsics.checkNotNullParameter(exc, "it");
        LogManager.logException(exc);
    }

    /* access modifiers changed from: private */
    /* renamed from: signInWithEmailLink$lambda-0  reason: not valid java name */
    public static final void m10946signInWithEmailLink$lambda0(Task task) {
        Intrinsics.checkNotNullParameter(task, "it");
        task.isSuccessful();
    }

    /* access modifiers changed from: private */
    /* renamed from: signInWithEmailLink$lambda-1  reason: not valid java name */
    public static final void m10947signInWithEmailLink$lambda1(Exception exc) {
        Intrinsics.checkNotNullParameter(exc, "it");
        LogManager.logException(exc);
    }

    /* access modifiers changed from: private */
    /* renamed from: verifyEmailLink$lambda-3  reason: not valid java name */
    public static final void m10948verifyEmailLink$lambda3(Task task) {
        Intrinsics.checkNotNullParameter(task, "it");
        if (task.isSuccessful()) {
            AuthResult authResult = (AuthResult) task.getResult();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: verifyEmailLink$lambda-4  reason: not valid java name */
    public static final void m10949verifyEmailLink$lambda4(Exception exc) {
        Intrinsics.checkNotNullParameter(exc, "it");
        LogManager.logException(exc);
    }

    @NotNull
    public final Secrets getSecrets() {
        return this.secrets;
    }

    public void signInWithEmailAndPassword() {
        FirebaseAuth instance = FirebaseAuth.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance()");
        instance.signInWithEmailAndPassword(this.secrets.getGetDataLayerQaAuthEmail(), this.secrets.getGetDataLayerQaAuthPassword()).addOnFailureListener(new e());
    }

    public void signInWithEmailLink(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "email");
        ActionCodeSettings build = ActionCodeSettings.newBuilder().setUrl("https://datalayer.talabat.com").setHandleCodeInApp(true).setAndroidPackageName(BuildConfig.APPLICATION_ID, true, "12").build();
        Intrinsics.checkNotNullExpressionValue(build, "newBuilder()\n           …   )\n            .build()");
        FirebaseAuth instance = FirebaseAuth.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance()");
        instance.sendSignInLinkToEmail(str, build).addOnCompleteListener(new a()).addOnFailureListener(new b());
    }

    public void verifyEmailLink(@NotNull Intent intent, @NotNull String str) {
        Intrinsics.checkNotNullParameter(intent, CommonCode.Resolution.HAS_RESOLUTION_FROM_APK);
        Intrinsics.checkNotNullParameter(str, "email");
        FirebaseAuth instance = FirebaseAuth.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance()");
        String valueOf = String.valueOf(intent.getData());
        if (instance.isSignInWithEmailLink(valueOf)) {
            instance.signInWithEmailLink(str, valueOf).addOnCompleteListener(new c()).addOnFailureListener(new d());
        }
    }
}
