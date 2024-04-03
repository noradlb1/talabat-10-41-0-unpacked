package mz;

import android.graphics.Bitmap;
import com.uxcam.internals.eh;
import com.uxcam.internals.ei;
import com.uxcam.internals.fu;
import java.util.List;

public final /* synthetic */ class k implements eh {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ei f23974a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f23975b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ eh f23976c;

    public /* synthetic */ k(ei eiVar, List list, eh ehVar) {
        this.f23974a = eiVar;
        this.f23975b = list;
        this.f23976c = ehVar;
    }

    public final void a(Bitmap bitmap) {
        fu.a(this.f23974a, this.f23975b, this.f23976c, bitmap);
    }
}
