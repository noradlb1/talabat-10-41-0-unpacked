package rc;

import android.graphics.Path;
import com.instabug.library.annotation.AnnotationLayout;
import com.instabug.library.annotation.AnnotationView;

public final /* synthetic */ class b implements AnnotationView.h {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnnotationLayout f34654a;

    public /* synthetic */ b(AnnotationLayout annotationLayout) {
        this.f34654a = annotationLayout;
    }

    public final void a(Path path, Path path2) {
        this.f34654a.showShapeSuggestions(path, path2);
    }
}
