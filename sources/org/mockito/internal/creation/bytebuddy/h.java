package org.mockito.internal.creation.bytebuddy;

import java.util.concurrent.Callable;

public final /* synthetic */ class h implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TypeCachingBytecodeGenerator f63181b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MockFeatures f63182c;

    public /* synthetic */ h(TypeCachingBytecodeGenerator typeCachingBytecodeGenerator, MockFeatures mockFeatures) {
        this.f63181b = typeCachingBytecodeGenerator;
        this.f63182c = mockFeatures;
    }

    public final Object call() {
        return this.f63181b.lambda$mockClass$0(this.f63182c);
    }
}
