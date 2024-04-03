package ed;

import android.view.View;
import android.view.ViewGroup;
import com.instabug.library.invocation.invocationdialog.h;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ h f56764b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ViewGroup f56765c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ View f56766d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f56767e;

    public /* synthetic */ a(h hVar, ViewGroup viewGroup, View view, int i11) {
        this.f56764b = hVar;
        this.f56765c = viewGroup;
        this.f56766d = view;
        this.f56767e = i11;
    }

    public final void onClick(View view) {
        this.f56764b.a(this.f56765c, this.f56766d, this.f56767e, view);
    }
}
