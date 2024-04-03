package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;

class TintResources extends ResourcesWrapper {
    private final WeakReference<Context> mContextRef;

    public TintResources(@NonNull Context context, @NonNull Resources resources) {
        super(resources);
        this.mContextRef = new WeakReference<>(context);
    }

    public Drawable getDrawable(int i11) throws Resources.NotFoundException {
        Drawable a11 = a(i11);
        Context context = this.mContextRef.get();
        if (!(a11 == null || context == null)) {
            ResourceManagerInternal.get().f(context, i11, a11);
        }
        return a11;
    }
}
