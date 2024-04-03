package tracking.firebaseauth;

import android.content.Intent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\n"}, d2 = {"Ltracking/firebaseauth/TalabatFirebaseAuth;", "", "signInWithEmailAndPassword", "", "signInWithEmailLink", "email", "", "verifyEmailLink", "intent", "Landroid/content/Intent;", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface TalabatFirebaseAuth {
    void signInWithEmailAndPassword();

    void signInWithEmailLink(@NotNull String str);

    void verifyEmailLink(@NotNull Intent intent, @NotNull String str);
}
