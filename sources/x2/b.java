package x2;

import bo.app.f;
import bo.app.j2;
import bo.app.o0;
import com.braze.events.IEventSubscriber;

public final /* synthetic */ class b implements IEventSubscriber {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ f f44410a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ j2 f44411b;

    public /* synthetic */ b(f fVar, j2 j2Var) {
        this.f44410a = fVar;
        this.f44411b = j2Var;
    }

    public final void trigger(Object obj) {
        f.a(this.f44410a, this.f44411b, (o0) obj);
    }
}
