package org.junit.jupiter.api;

import org.apiguardian.api.API;
import org.junit.platform.commons.util.Preconditions;

@API(since = "5.8", status = API.Status.STABLE)
public interface Named<T> {

    /* renamed from: org.junit.jupiter.api.Named$-CC  reason: invalid class name */
    public final /* synthetic */ class CC<T> {
        public static <T> Named<T> a(String str, T t11) {
            return b(str, t11);
        }

        public static <T> Named<T> b(String str, T t11) {
            Preconditions.notBlank(str, "name must not be null or blank");
            return new Named<T>(str, t11) {

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f57105a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Object f57106b;

                {
                    this.f57105a = r1;
                    this.f57106b = r2;
                }

                public String getName() {
                    return this.f57105a;
                }

                public T getPayload() {
                    return this.f57106b;
                }

                public String toString() {
                    return this.f57105a;
                }
            };
        }
    }

    String getName();

    T getPayload();
}
