package retrofit2;

import j$.util.Optional;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import okhttp3.ResponseBody;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import retrofit2.Converter;

@IgnoreJRERequirement
final class OptionalConverterFactory extends Converter.Factory {
    static final Converter.Factory INSTANCE = new OptionalConverterFactory();

    @IgnoreJRERequirement
    public static final class OptionalConverter<T> implements Converter<ResponseBody, Optional<T>> {
        final Converter<ResponseBody, T> delegate;

        public OptionalConverter(Converter<ResponseBody, T> converter) {
            this.delegate = converter;
        }

        public Optional<T> convert(ResponseBody responseBody) throws IOException {
            return Optional.ofNullable(this.delegate.convert(responseBody));
        }
    }

    @Nullable
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        if (Converter.Factory.getRawType(type) != Optional.class) {
            return null;
        }
        return new OptionalConverter(retrofit.responseBodyConverter(Converter.Factory.getParameterUpperBound(0, (ParameterizedType) type), annotationArr));
    }
}
