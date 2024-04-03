package dq;

import android.view.View;
import com.talabat.fluid.image.TalabatImageLoader;
import kotlin.jvm.functions.Function0;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TalabatImageLoader f61953b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f61954c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Function0 f61955d;

    public /* synthetic */ a(TalabatImageLoader talabatImageLoader, View view, Function0 function0) {
        this.f61953b = talabatImageLoader;
        this.f61954c = view;
        this.f61955d = function0;
    }

    public final void run() {
        TalabatImageLoader.m10466postIfContextIsValid$lambda0(this.f61953b, this.f61954c, this.f61955d);
    }
}
