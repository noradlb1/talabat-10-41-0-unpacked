package retrofit2.converter.moshi;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonQualifier;
import com.squareup.moshi.Moshi;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

public final class MoshiConverterFactory extends Converter.Factory {
    private final boolean failOnUnknown;
    private final boolean lenient;
    private final Moshi moshi;
    private final boolean serializeNulls;

    private MoshiConverterFactory(Moshi moshi2, boolean z11, boolean z12, boolean z13) {
        this.moshi = moshi2;
        this.lenient = z11;
        this.failOnUnknown = z12;
        this.serializeNulls = z13;
    }

    public static MoshiConverterFactory create() {
        return create(new Moshi.Builder().build());
    }

    private static Set<? extends Annotation> jsonAnnotations(Annotation[] annotationArr) {
        LinkedHashSet linkedHashSet = null;
        for (Annotation annotation : annotationArr) {
            if (annotation.annotationType().isAnnotationPresent(JsonQualifier.class)) {
                if (linkedHashSet == null) {
                    linkedHashSet = new LinkedHashSet();
                }
                linkedHashSet.add(annotation);
            }
        }
        if (linkedHashSet != null) {
            return Collections.unmodifiableSet(linkedHashSet);
        }
        return Collections.emptySet();
    }

    public MoshiConverterFactory asLenient() {
        return new MoshiConverterFactory(this.moshi, true, this.failOnUnknown, this.serializeNulls);
    }

    public MoshiConverterFactory failOnUnknown() {
        return new MoshiConverterFactory(this.moshi, this.lenient, true, this.serializeNulls);
    }

    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, Retrofit retrofit) {
        JsonAdapter<T> adapter = this.moshi.adapter(type, jsonAnnotations(annotationArr));
        if (this.lenient) {
            adapter = adapter.lenient();
        }
        if (this.failOnUnknown) {
            adapter = adapter.failOnUnknown();
        }
        if (this.serializeNulls) {
            adapter = adapter.serializeNulls();
        }
        return new MoshiRequestBodyConverter(adapter);
    }

    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        JsonAdapter<T> adapter = this.moshi.adapter(type, jsonAnnotations(annotationArr));
        if (this.lenient) {
            adapter = adapter.lenient();
        }
        if (this.failOnUnknown) {
            adapter = adapter.failOnUnknown();
        }
        if (this.serializeNulls) {
            adapter = adapter.serializeNulls();
        }
        return new MoshiResponseBodyConverter(adapter);
    }

    public MoshiConverterFactory withNullSerialization() {
        return new MoshiConverterFactory(this.moshi, this.lenient, this.failOnUnknown, true);
    }

    public static MoshiConverterFactory create(Moshi moshi2) {
        if (moshi2 != null) {
            return new MoshiConverterFactory(moshi2, false, false, false);
        }
        throw new NullPointerException("moshi == null");
    }
}
