package com.deliveryhero.fluid.template.sources;

import com.deliveryhero.fluid.ParseConfig;
import com.deliveryhero.fluid.template.TemplateBuilder;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0014J\u0011\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J'\u0010\f\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0011\u0012\u0004\u0012\u00020\r0\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0013H¦\u0002R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/deliveryhero/fluid/template/sources/ReadableTemplateSource;", "", "debugName", "", "getDebugName", "()Ljava/lang/String;", "name", "getName", "parseConfig", "Lcom/deliveryhero/fluid/ParseConfig;", "getParseConfig", "()Lcom/deliveryhero/fluid/ParseConfig;", "get", "Lcom/deliveryhero/fluid/template/TemplateBuilder;", "request", "Lcom/deliveryhero/fluid/template/sources/ReadableTemplateSource$Request;", "", "Lcom/deliveryhero/fluid/template/TemplateId;", "requests", "", "Request", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ReadableTemplateSource {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        @NotNull
        public static TemplateBuilder get(@NotNull ReadableTemplateSource readableTemplateSource, @NotNull Request request) throws Throwable {
            Intrinsics.checkNotNullParameter(request, "request");
            return (TemplateBuilder) CollectionsKt___CollectionsKt.single(readableTemplateSource.get((Set<Request>) SetsKt__SetsJVMKt.setOf(request)).values());
        }

        @NotNull
        public static String getDebugName(@NotNull ReadableTemplateSource readableTemplateSource) {
            return readableTemplateSource.getName() + "_template_source";
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u0006¢\u0006\u0002\u0010\u0007J\r\u0010\u000b\u001a\u00060\u0003j\u0002`\u0004HÆ\u0003J\r\u0010\f\u001a\u00060\u0003j\u0002`\u0006HÆ\u0003J%\u0010\r\u001a\u00020\u00002\f\b\u0002\u0010\u0002\u001a\u00060\u0003j\u0002`\u00042\f\b\u0002\u0010\u0005\u001a\u00060\u0003j\u0002`\u0006HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0015\u0010\u0005\u001a\u00060\u0003j\u0002`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/deliveryhero/fluid/template/sources/ReadableTemplateSource$Request;", "", "id", "", "Lcom/deliveryhero/fluid/template/TemplateId;", "hash", "Lcom/deliveryhero/fluid/template/sources/TemplateHash;", "(Ljava/lang/String;Ljava/lang/String;)V", "getHash", "()Ljava/lang/String;", "getId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Request {
        @NotNull
        private final String hash;
        @NotNull

        /* renamed from: id  reason: collision with root package name */
        private final String f30214id;

        public Request(@NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "hash");
            this.f30214id = str;
            this.hash = str2;
        }

        public static /* synthetic */ Request copy$default(Request request, String str, String str2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = request.f30214id;
            }
            if ((i11 & 2) != 0) {
                str2 = request.hash;
            }
            return request.copy(str, str2);
        }

        @NotNull
        public final String component1() {
            return this.f30214id;
        }

        @NotNull
        public final String component2() {
            return this.hash;
        }

        @NotNull
        public final Request copy(@NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "hash");
            return new Request(str, str2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Request)) {
                return false;
            }
            Request request = (Request) obj;
            return Intrinsics.areEqual((Object) this.f30214id, (Object) request.f30214id) && Intrinsics.areEqual((Object) this.hash, (Object) request.hash);
        }

        @NotNull
        public final String getHash() {
            return this.hash;
        }

        @NotNull
        public final String getId() {
            return this.f30214id;
        }

        public int hashCode() {
            return (this.f30214id.hashCode() * 31) + this.hash.hashCode();
        }

        @NotNull
        public String toString() {
            return "Request(id=" + this.f30214id + ", hash=" + this.hash + ')';
        }
    }

    @NotNull
    TemplateBuilder get(@NotNull Request request) throws Throwable;

    @NotNull
    Map<String, TemplateBuilder> get(@NotNull Set<Request> set) throws Throwable;

    @NotNull
    String getDebugName();

    @NotNull
    String getName();

    @NotNull
    ParseConfig getParseConfig();
}
