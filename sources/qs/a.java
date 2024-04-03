package qs;

import android.view.View;
import androidx.activity.ComponentActivity;
import com.talabat.login.FacebookLoginScreenDelegate;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineScope;
import library.talabat.mvp.login.ILoginInteractor;
import library.talabat.mvp.login.ILoginPresenter;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ComponentActivity f62835b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Function0 f62836c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ CoroutineScope f62837d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ FacebookLoginScreenDelegate f62838e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ ILoginPresenter f62839f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ILoginInteractor f62840g;

    public /* synthetic */ a(ComponentActivity componentActivity, Function0 function0, CoroutineScope coroutineScope, FacebookLoginScreenDelegate facebookLoginScreenDelegate, ILoginPresenter iLoginPresenter, ILoginInteractor iLoginInteractor) {
        this.f62835b = componentActivity;
        this.f62836c = function0;
        this.f62837d = coroutineScope;
        this.f62838e = facebookLoginScreenDelegate;
        this.f62839f = iLoginPresenter;
        this.f62840g = iLoginInteractor;
    }

    public final void onClick(View view) {
        FacebookLoginScreenDelegate.m10682onSetUpFacebookLoginButtons$lambda0(this.f62835b, this.f62836c, this.f62837d, this.f62838e, this.f62839f, this.f62840g, view);
    }
}
