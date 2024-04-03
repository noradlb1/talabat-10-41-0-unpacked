package coil.util;

import coil.ComponentRegistry;
import coil.decode.Decoder;
import coil.fetch.Fetcher;
import coil.map.Mapper;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import okio.BufferedSource;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0000\u001a5\u0010\u0004\u001a\u00020\u0005\"\b\b\u0000\u0010\u0006*\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u0002H\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0000¢\u0006\u0002\u0010\u000b\u001a)\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00060\r\"\b\b\u0000\u0010\u0006*\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u0002H\u0006H\u0000¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"mapData", "", "Lcoil/ComponentRegistry;", "data", "requireDecoder", "Lcoil/decode/Decoder;", "T", "source", "Lokio/BufferedSource;", "mimeType", "", "(Lcoil/ComponentRegistry;Ljava/lang/Object;Lokio/BufferedSource;Ljava/lang/String;)Lcoil/decode/Decoder;", "requireFetcher", "Lcoil/fetch/Fetcher;", "(Lcoil/ComponentRegistry;Ljava/lang/Object;)Lcoil/fetch/Fetcher;", "coil-base_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
@JvmName(name = "-ComponentRegistries")
/* renamed from: coil.util.-ComponentRegistries  reason: invalid class name */
public final class ComponentRegistries {
    @NotNull
    public static final Object mapData(@NotNull ComponentRegistry componentRegistry, @NotNull Object obj) {
        Intrinsics.checkNotNullParameter(componentRegistry, "<this>");
        Intrinsics.checkNotNullParameter(obj, "data");
        List<Pair<Mapper<? extends Object, ?>, Class<? extends Object>>> mappers$coil_base_release = componentRegistry.getMappers$coil_base_release();
        int size = mappers$coil_base_release.size() - 1;
        if (size >= 0) {
            int i11 = 0;
            while (true) {
                int i12 = i11 + 1;
                Pair pair = mappers$coil_base_release.get(i11);
                Mapper mapper = (Mapper) pair.component1();
                if (((Class) pair.component2()).isAssignableFrom(obj.getClass()) && mapper.handles(obj)) {
                    obj = mapper.map(obj);
                }
                if (i12 > size) {
                    break;
                }
                i11 = i12;
            }
        }
        return obj;
    }

    @NotNull
    public static final <T> Decoder requireDecoder(@NotNull ComponentRegistry componentRegistry, @NotNull T t11, @NotNull BufferedSource bufferedSource, @Nullable String str) {
        Decoder decoder;
        Intrinsics.checkNotNullParameter(componentRegistry, "<this>");
        Intrinsics.checkNotNullParameter(t11, "data");
        Intrinsics.checkNotNullParameter(bufferedSource, "source");
        List<Decoder> decoders$coil_base_release = componentRegistry.getDecoders$coil_base_release();
        int size = decoders$coil_base_release.size() - 1;
        if (size >= 0) {
            int i11 = 0;
            while (true) {
                int i12 = i11 + 1;
                decoder = decoders$coil_base_release.get(i11);
                if (decoder.handles(bufferedSource, str)) {
                    break;
                } else if (i12 > size) {
                    break;
                } else {
                    i11 = i12;
                }
            }
        }
        decoder = null;
        Decoder decoder2 = decoder;
        if (decoder2 != null) {
            return decoder2;
        }
        throw new IllegalStateException(Intrinsics.stringPlus("Unable to decode data. No decoder supports: ", t11).toString());
    }

    @NotNull
    public static final <T> Fetcher<T> requireFetcher(@NotNull ComponentRegistry componentRegistry, @NotNull T t11) {
        Pair<Fetcher<? extends Object>, Class<? extends Object>> pair;
        boolean z11;
        Intrinsics.checkNotNullParameter(componentRegistry, "<this>");
        Intrinsics.checkNotNullParameter(t11, "data");
        List<Pair<Fetcher<? extends Object>, Class<? extends Object>>> fetchers$coil_base_release = componentRegistry.getFetchers$coil_base_release();
        int size = fetchers$coil_base_release.size() - 1;
        if (size >= 0) {
            int i11 = 0;
            while (true) {
                int i12 = i11 + 1;
                pair = fetchers$coil_base_release.get(i11);
                Pair pair2 = pair;
                Fetcher fetcher = (Fetcher) pair2.component1();
                if (!((Class) pair2.component2()).isAssignableFrom(t11.getClass()) || !fetcher.handles(t11)) {
                    z11 = false;
                } else {
                    z11 = true;
                }
                if (z11) {
                    break;
                } else if (i12 > size) {
                    break;
                } else {
                    i11 = i12;
                }
            }
        }
        pair = null;
        Pair pair3 = pair;
        if (pair3 != null) {
            return (Fetcher) pair3.getFirst();
        }
        throw new IllegalStateException(Intrinsics.stringPlus("Unable to fetch data. No fetcher supports: ", t11).toString());
    }
}
