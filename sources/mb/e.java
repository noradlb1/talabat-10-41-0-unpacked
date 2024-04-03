package mb;

import com.instabug.library.internal.utils.stability.execution.ReturnableExecutable;
import com.instabug.library.model.common.Session;

public final /* synthetic */ class e implements ReturnableExecutable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ com.instabug.apm.cache.handler.session.e f47152a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Session f47153b;

    public /* synthetic */ e(com.instabug.apm.cache.handler.session.e eVar, Session session) {
        this.f47152a = eVar;
        this.f47153b = session;
    }

    public final Object execute() {
        return this.f47152a.b(this.f47153b);
    }
}
