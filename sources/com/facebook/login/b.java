package com.facebook.login;

import android.util.Pair;
import androidx.activity.result.ActivityResultCallback;
import com.facebook.login.LoginManager;

public final /* synthetic */ class b implements ActivityResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LoginManager.AndroidxActivityResultRegistryOwnerStartActivityDelegate f33608a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LoginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder f33609b;

    public /* synthetic */ b(LoginManager.AndroidxActivityResultRegistryOwnerStartActivityDelegate androidxActivityResultRegistryOwnerStartActivityDelegate, LoginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder loginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder) {
        this.f33608a = androidxActivityResultRegistryOwnerStartActivityDelegate;
        this.f33609b = loginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder;
    }

    public final void onActivityResult(Object obj) {
        LoginManager.AndroidxActivityResultRegistryOwnerStartActivityDelegate.m9001startActivityForResult$lambda0(this.f33608a, this.f33609b, (Pair) obj);
    }
}
