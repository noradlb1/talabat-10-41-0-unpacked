package a2;

import android.os.Bundle;
import androidx.fragment.app.FragmentKt;
import androidx.fragment.app.FragmentResultListener;
import kotlin.jvm.functions.Function2;

public final /* synthetic */ class e implements FragmentResultListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function2 f35592a;

    public /* synthetic */ e(Function2 function2) {
        this.f35592a = function2;
    }

    public final void onFragmentResult(String str, Bundle bundle) {
        FragmentKt.m9077setFragmentResultListener$lambda0(this.f35592a, str, bundle);
    }
}
