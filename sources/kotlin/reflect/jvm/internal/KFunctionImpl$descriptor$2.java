package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class KFunctionImpl$descriptor$2 extends Lambda implements Function0<FunctionDescriptor> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ KFunctionImpl f24399g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f24400h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KFunctionImpl$descriptor$2(KFunctionImpl kFunctionImpl, String str) {
        super(0);
        this.f24399g = kFunctionImpl;
        this.f24400h = str;
    }

    public final FunctionDescriptor invoke() {
        return this.f24399g.getContainer().findFunctionDescriptor(this.f24400h, this.f24399g.signature);
    }
}
