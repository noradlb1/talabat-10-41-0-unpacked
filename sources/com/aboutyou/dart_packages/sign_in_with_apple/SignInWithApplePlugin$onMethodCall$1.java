package com.aboutyou.dart_packages.sign_in_with_apple;

import android.app.Activity;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class SignInWithApplePlugin$onMethodCall$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Activity f39824g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SignInWithApplePlugin$onMethodCall$1(Activity activity) {
        super(0);
        this.f39824g = activity;
    }

    public final void invoke() {
        Intent launchIntentForPackage = this.f39824g.getPackageManager().getLaunchIntentForPackage(this.f39824g.getPackageName());
        if (launchIntentForPackage != null) {
            launchIntentForPackage.setPackage((String) null);
        }
        if (launchIntentForPackage != null) {
            launchIntentForPackage.setFlags(67108864);
        }
        this.f39824g.startActivity(launchIntentForPackage);
    }
}
