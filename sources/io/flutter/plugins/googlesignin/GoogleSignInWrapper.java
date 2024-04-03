package io.flutter.plugins.googlesignin;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.Scope;

public class GoogleSignInWrapper {
    public GoogleSignInClient a(Context context, GoogleSignInOptions googleSignInOptions) {
        return GoogleSignIn.getClient(context, googleSignInOptions);
    }

    public GoogleSignInAccount b(Context context) {
        return GoogleSignIn.getLastSignedInAccount(context);
    }

    public boolean c(GoogleSignInAccount googleSignInAccount, Scope scope) {
        return GoogleSignIn.hasPermissions(googleSignInAccount, scope);
    }

    public void d(Activity activity, int i11, GoogleSignInAccount googleSignInAccount, Scope[] scopeArr) {
        GoogleSignIn.requestPermissions(activity, i11, googleSignInAccount, scopeArr);
    }
}
