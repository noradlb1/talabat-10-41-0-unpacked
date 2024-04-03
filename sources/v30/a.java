package v30;

import java.lang.reflect.Field;
import org.mockito.internal.configuration.injection.filter.OngoingInjector;
import org.mockito.internal.configuration.injection.filter.TerminalMockCandidateFilter;
import org.mockito.plugins.MemberAccessor;

public final /* synthetic */ class a implements OngoingInjector {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Object f63580a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Field f63581b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f63582c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ MemberAccessor f63583d;

    public /* synthetic */ a(Object obj, Field field, Object obj2, MemberAccessor memberAccessor) {
        this.f63580a = obj;
        this.f63581b = field;
        this.f63582c = obj2;
        this.f63583d = memberAccessor;
    }

    public final Object thenInject() {
        return TerminalMockCandidateFilter.lambda$filterCandidate$0(this.f63580a, this.f63581b, this.f63582c, this.f63583d);
    }
}
