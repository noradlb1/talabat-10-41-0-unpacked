package coil;

import coil.decode.Decoder;
import coil.fetch.Fetcher;
import coil.intercept.Interceptor;
import coil.map.Mapper;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0017B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B¿\u0001\b\u0002\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012P\u0010\u0006\u001aL\u0012$\u0012\"\u0012\u0010\u0012\u000e\u0012\u0006\b\u0001\u0012\u00020\u0001\u0012\u0002\b\u00030\b\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\t0\u00070\u0004j\"\u0012\u0010\u0012\u000e\u0012\u0006\b\u0001\u0012\u00020\u0001\u0012\u0002\b\u00030\b\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\t`\n\u0012H\u0010\u000b\u001aD\u0012 \u0012\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\f\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\t0\u00070\u0004j\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\f\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\t`\n\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0004¢\u0006\u0002\u0010\u000fJ\u0006\u0010\u0015\u001a\u00020\u0016R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011RV\u0010\u000b\u001aD\u0012 \u0012\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\f\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\t0\u00070\u0004j\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\f\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\t`\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R^\u0010\u0006\u001aL\u0012$\u0012\"\u0012\u0010\u0012\u000e\u0012\u0006\b\u0001\u0012\u00020\u0001\u0012\u0002\b\u00030\b\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\t0\u00070\u0004j\"\u0012\u0010\u0012\u000e\u0012\u0006\b\u0001\u0012\u00020\u0001\u0012\u0002\b\u00030\b\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\t`\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011¨\u0006\u0018"}, d2 = {"Lcoil/ComponentRegistry;", "", "()V", "interceptors", "", "Lcoil/intercept/Interceptor;", "mappers", "Lkotlin/Pair;", "Lcoil/map/Mapper;", "Ljava/lang/Class;", "Lcoil/util/MultiList;", "fetchers", "Lcoil/fetch/Fetcher;", "decoders", "Lcoil/decode/Decoder;", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getDecoders$coil_base_release", "()Ljava/util/List;", "getFetchers$coil_base_release", "getInterceptors$coil_base_release", "getMappers$coil_base_release", "newBuilder", "Lcoil/ComponentRegistry$Builder;", "Builder", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ComponentRegistry {
    @NotNull
    private final List<Decoder> decoders;
    @NotNull
    private final List<Pair<Fetcher<? extends Object>, Class<? extends Object>>> fetchers;
    @NotNull
    private final List<Interceptor> interceptors;
    @NotNull
    private final List<Pair<Mapper<? extends Object, ?>, Class<? extends Object>>> mappers;

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\bJ#\u0010\u0012\u001a\u00020\u0000\"\n\b\u0000\u0010\u0014\u0018\u0001*\u00020\u00012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\u000bH\bJ,\u0010\u0012\u001a\u00020\u0000\"\b\b\u0000\u0010\u0014*\u00020\u00012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\u000b2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00140\fJ\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u000fJ'\u0010\u0012\u001a\u00020\u0000\"\n\b\u0000\u0010\u0014\u0018\u0001*\u00020\u00012\u0010\u0010\u0018\u001a\f\u0012\u0004\u0012\u0002H\u0014\u0012\u0002\b\u00030\u0011H\bJ0\u0010\u0012\u001a\u00020\u0000\"\b\b\u0000\u0010\u0014*\u00020\u00012\u0010\u0010\u0018\u001a\f\u0012\u0004\u0012\u0002H\u0014\u0012\u0002\b\u00030\u00112\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00140\fJ\u0006\u0010\u0019\u001a\u00020\u0004R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000RP\u0010\t\u001aD\u0012 \u0012\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u000b\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\f0\n0\u0007j\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u000b\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\f`\rX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0007X\u0004¢\u0006\u0002\n\u0000RX\u0010\u0010\u001aL\u0012$\u0012\"\u0012\u0010\u0012\u000e\u0012\u0006\b\u0001\u0012\u00020\u0001\u0012\u0002\b\u00030\u0011\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\f0\n0\u0007j\"\u0012\u0010\u0012\u000e\u0012\u0006\b\u0001\u0012\u00020\u0001\u0012\u0002\b\u00030\u0011\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\f`\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcoil/ComponentRegistry$Builder;", "", "()V", "registry", "Lcoil/ComponentRegistry;", "(Lcoil/ComponentRegistry;)V", "decoders", "", "Lcoil/decode/Decoder;", "fetchers", "Lkotlin/Pair;", "Lcoil/fetch/Fetcher;", "Ljava/lang/Class;", "Lcoil/util/MultiMutableList;", "interceptors", "Lcoil/intercept/Interceptor;", "mappers", "Lcoil/map/Mapper;", "add", "decoder", "T", "fetcher", "type", "interceptor", "mapper", "build", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Builder {
        @NotNull
        private final List<Decoder> decoders;
        @NotNull
        private final List<Pair<Fetcher<? extends Object>, Class<? extends Object>>> fetchers;
        @NotNull
        private final List<Interceptor> interceptors;
        @NotNull
        private final List<Pair<Mapper<? extends Object, ?>, Class<? extends Object>>> mappers;

        public Builder() {
            this.interceptors = new ArrayList();
            this.mappers = new ArrayList();
            this.fetchers = new ArrayList();
            this.decoders = new ArrayList();
        }

        @NotNull
        public final Builder add(@NotNull Interceptor interceptor) {
            Intrinsics.checkNotNullParameter(interceptor, "interceptor");
            this.interceptors.add(interceptor);
            return this;
        }

        @NotNull
        public final ComponentRegistry build() {
            return new ComponentRegistry(CollectionsKt___CollectionsKt.toList(this.interceptors), CollectionsKt___CollectionsKt.toList(this.mappers), CollectionsKt___CollectionsKt.toList(this.fetchers), CollectionsKt___CollectionsKt.toList(this.decoders), (DefaultConstructorMarker) null);
        }

        public final /* synthetic */ <T> Builder add(Mapper<T, ?> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            Intrinsics.reifiedOperationMarker(4, "T");
            return add(mapper, Object.class);
        }

        @NotNull
        public final <T> Builder add(@NotNull Mapper<T, ?> mapper, @NotNull Class<T> cls) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            Intrinsics.checkNotNullParameter(cls, "type");
            this.mappers.add(TuplesKt.to(mapper, cls));
            return this;
        }

        public final /* synthetic */ <T> Builder add(Fetcher<T> fetcher) {
            Intrinsics.checkNotNullParameter(fetcher, "fetcher");
            Intrinsics.reifiedOperationMarker(4, "T");
            return add(fetcher, Object.class);
        }

        @NotNull
        public final <T> Builder add(@NotNull Fetcher<T> fetcher, @NotNull Class<T> cls) {
            Intrinsics.checkNotNullParameter(fetcher, "fetcher");
            Intrinsics.checkNotNullParameter(cls, "type");
            this.fetchers.add(TuplesKt.to(fetcher, cls));
            return this;
        }

        public Builder(@NotNull ComponentRegistry componentRegistry) {
            Intrinsics.checkNotNullParameter(componentRegistry, "registry");
            this.interceptors = CollectionsKt___CollectionsKt.toMutableList(componentRegistry.getInterceptors$coil_base_release());
            this.mappers = CollectionsKt___CollectionsKt.toMutableList(componentRegistry.getMappers$coil_base_release());
            this.fetchers = CollectionsKt___CollectionsKt.toMutableList(componentRegistry.getFetchers$coil_base_release());
            this.decoders = CollectionsKt___CollectionsKt.toMutableList(componentRegistry.getDecoders$coil_base_release());
        }

        @NotNull
        public final Builder add(@NotNull Decoder decoder) {
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            this.decoders.add(decoder);
            return this;
        }
    }

    private ComponentRegistry(List<? extends Interceptor> list, List<? extends Pair<? extends Mapper<? extends Object, ?>, ? extends Class<? extends Object>>> list2, List<? extends Pair<? extends Fetcher<? extends Object>, ? extends Class<? extends Object>>> list3, List<? extends Decoder> list4) {
        this.interceptors = list;
        this.mappers = list2;
        this.fetchers = list3;
        this.decoders = list4;
    }

    public /* synthetic */ ComponentRegistry(List list, List list2, List list3, List list4, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, list2, list3, list4);
    }

    @NotNull
    public final List<Decoder> getDecoders$coil_base_release() {
        return this.decoders;
    }

    @NotNull
    public final List<Pair<Fetcher<? extends Object>, Class<? extends Object>>> getFetchers$coil_base_release() {
        return this.fetchers;
    }

    @NotNull
    public final List<Interceptor> getInterceptors$coil_base_release() {
        return this.interceptors;
    }

    @NotNull
    public final List<Pair<Mapper<? extends Object, ?>, Class<? extends Object>>> getMappers$coil_base_release() {
        return this.mappers;
    }

    @NotNull
    public final Builder newBuilder() {
        return new Builder(this);
    }

    public ComponentRegistry() {
        this(CollectionsKt__CollectionsKt.emptyList(), CollectionsKt__CollectionsKt.emptyList(), CollectionsKt__CollectionsKt.emptyList(), CollectionsKt__CollectionsKt.emptyList());
    }
}
