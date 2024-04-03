package com.deliveryhero.fluid.template.sources;

import android.util.LruCache;
import com.deliveryhero.fluid.template.TemplateBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0001J\u0017\u0010\u0002\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0003\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0004J/\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00028\u00002\u0006\u0010\t\u001a\u00028\u00012\b\u0010\n\u001a\u0004\u0018\u00018\u0001H\u0014¢\u0006\u0002\u0010\u000bJ\u001d\u0010\f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00028\u0001H\u0014¢\u0006\u0002\u0010\u000f¨\u0006\u0010¸\u0006\u0000"}, d2 = {"androidx/core/util/LruCacheKt$lruCache$4", "Landroid/util/LruCache;", "create", "key", "(Ljava/lang/Object;)Ljava/lang/Object;", "entryRemoved", "", "evicted", "", "oldValue", "newValue", "(ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "sizeOf", "", "value", "(Ljava/lang/Object;Ljava/lang/Object;)I", "core-ktx_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TemplateLruMemorySource$special$$inlined$lruCache$default$1 extends LruCache<String, TemplateBuilder> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f30229a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TemplateLruMemorySource$special$$inlined$lruCache$default$1(int i11) {
        super(i11);
        this.f30229a = i11;
    }

    @Nullable
    public TemplateBuilder create(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return null;
    }

    public void entryRemoved(boolean z11, @NotNull String str, @NotNull TemplateBuilder templateBuilder, @Nullable TemplateBuilder templateBuilder2) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(templateBuilder, "oldValue");
    }

    public int sizeOf(@NotNull String str, @NotNull TemplateBuilder templateBuilder) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(templateBuilder, "value");
        return 1;
    }
}
