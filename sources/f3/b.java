package f3;

import android.graphics.Canvas;
import android.graphics.PostProcessor;
import coil.transform.AnimatedTransformation;
import coil.util.GifExtensions;

public final /* synthetic */ class b implements PostProcessor {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnimatedTransformation f44293a;

    public /* synthetic */ b(AnimatedTransformation animatedTransformation) {
        this.f44293a = animatedTransformation;
    }

    public final int onPostProcess(Canvas canvas) {
        return GifExtensions.m9135asPostProcessor$lambda0(this.f44293a, canvas);
    }
}
