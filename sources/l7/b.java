package l7;

import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import java.lang.reflect.Constructor;

public final /* synthetic */ class b implements DefaultExtractorsFactory.ExtensionLoader.ConstructorSupplier {
    public final Constructor getConstructor() {
        return DefaultExtractorsFactory.getFlacExtractorConstructor();
    }
}
