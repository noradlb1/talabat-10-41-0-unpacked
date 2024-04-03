package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "T", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class KClassImpl$Data$qualifiedName$2 extends Lambda implements Function0<String> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ KClassImpl<T> f24381g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KClassImpl$Data$qualifiedName$2(KClassImpl<T> kClassImpl) {
        super(0);
        this.f24381g = kClassImpl;
    }

    @Nullable
    public final String invoke() {
        if (this.f24381g.getJClass().isAnonymousClass()) {
            return null;
        }
        ClassId access$getClassId = this.f24381g.getClassId();
        if (access$getClassId.isLocal()) {
            return null;
        }
        return access$getClassId.asSingleFqName().asString();
    }
}
