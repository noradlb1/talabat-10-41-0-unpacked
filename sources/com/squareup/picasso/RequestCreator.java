package com.squareup.picasso;

import android.app.Notification;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.RemoteViews;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RemoteViewsAction;
import com.squareup.picasso.Request;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import tracking.gtm.TalabatGTM;

public class RequestCreator {
    private static final AtomicInteger nextId = new AtomicInteger();
    private final Request.Builder data;
    private boolean deferred;
    private Drawable errorDrawable;
    private int errorResId;
    private int memoryPolicy;
    private int networkPolicy;
    private boolean noFade;
    private final Picasso picasso;
    private Drawable placeholderDrawable;
    private int placeholderResId;
    private boolean setPlaceholder;
    private Object tag;

    public RequestCreator(Picasso picasso2, Uri uri, int i11) {
        this.setPlaceholder = true;
        if (!picasso2.f53443k) {
            this.picasso = picasso2;
            this.data = new Request.Builder(uri, i11, picasso2.f53440h);
            return;
        }
        throw new IllegalStateException("Picasso instance already shut down. Cannot submit new requests.");
    }

    private Request createRequest(long j11) {
        int andIncrement = nextId.getAndIncrement();
        Request build = this.data.build();
        build.f53458a = andIncrement;
        build.f53459b = j11;
        boolean z11 = this.picasso.f53442j;
        if (z11) {
            Utils.u("Main", "created", build.f(), build.toString());
        }
        Request i11 = this.picasso.i(build);
        if (i11 != build) {
            i11.f53458a = andIncrement;
            i11.f53459b = j11;
            if (z11) {
                String c11 = i11.c();
                Utils.u("Main", "changed", c11, "into " + i11);
            }
        }
        return i11;
    }

    private Drawable getPlaceholderDrawable() {
        int i11 = this.placeholderResId;
        if (i11 != 0) {
            return this.picasso.f53433a.getDrawable(i11);
        }
        return this.placeholderDrawable;
    }

    private void performRemoteViewInto(RemoteViewsAction remoteViewsAction) {
        Bitmap f11;
        if (!MemoryPolicy.a(this.memoryPolicy) || (f11 = this.picasso.f(remoteViewsAction.b())) == null) {
            int i11 = this.placeholderResId;
            if (i11 != 0) {
                remoteViewsAction.m(i11);
            }
            this.picasso.d(remoteViewsAction);
            return;
        }
        remoteViewsAction.complete(f11, Picasso.LoadedFrom.MEMORY);
    }

    public RequestCreator a() {
        this.tag = null;
        return this;
    }

    public Object b() {
        return this.tag;
    }

    public RequestCreator c() {
        this.deferred = false;
        return this;
    }

    public RequestCreator centerCrop() {
        this.data.centerCrop(17);
        return this;
    }

    public RequestCreator centerInside() {
        this.data.centerInside();
        return this;
    }

    public RequestCreator config(@NonNull Bitmap.Config config) {
        this.data.config(config);
        return this;
    }

    public RequestCreator error(@DrawableRes int i11) {
        if (i11 == 0) {
            throw new IllegalArgumentException("Error image resource invalid.");
        } else if (this.errorDrawable == null) {
            this.errorResId = i11;
            return this;
        } else {
            throw new IllegalStateException("Error image already set.");
        }
    }

    public void fetch() {
        fetch((Callback) null);
    }

    public RequestCreator fit() {
        this.deferred = true;
        return this;
    }

    public Bitmap get() throws IOException {
        long nanoTime = System.nanoTime();
        Utils.d();
        if (this.deferred) {
            throw new IllegalStateException("Fit cannot be used with get.");
        } else if (!this.data.a()) {
            return null;
        } else {
            Request createRequest = createRequest(nanoTime);
            GetAction getAction = new GetAction(this.picasso, createRequest, this.memoryPolicy, this.networkPolicy, this.tag, Utils.h(createRequest, new StringBuilder()));
            Picasso picasso2 = this.picasso;
            return BitmapHunter.f(picasso2, picasso2.f53434b, picasso2.f53435c, picasso2.f53436d, getAction).s();
        }
    }

    public void into(@NonNull Target target) {
        Bitmap f11;
        long nanoTime = System.nanoTime();
        Utils.c();
        if (target == null) {
            throw new IllegalArgumentException("Target must not be null.");
        } else if (!this.deferred) {
            Drawable drawable = null;
            if (!this.data.a()) {
                this.picasso.cancelRequest(target);
                if (this.setPlaceholder) {
                    drawable = getPlaceholderDrawable();
                }
                target.onPrepareLoad(drawable);
                return;
            }
            Request createRequest = createRequest(nanoTime);
            String g11 = Utils.g(createRequest);
            if (!MemoryPolicy.a(this.memoryPolicy) || (f11 = this.picasso.f(g11)) == null) {
                if (this.setPlaceholder) {
                    drawable = getPlaceholderDrawable();
                }
                target.onPrepareLoad(drawable);
                this.picasso.d(new TargetAction(this.picasso, target, createRequest, this.memoryPolicy, this.networkPolicy, this.errorDrawable, g11, this.tag, this.errorResId));
                return;
            }
            this.picasso.cancelRequest(target);
            target.onBitmapLoaded(f11, Picasso.LoadedFrom.MEMORY);
        } else {
            throw new IllegalStateException("Fit cannot be used with a Target.");
        }
    }

    public RequestCreator memoryPolicy(@NonNull MemoryPolicy memoryPolicy2, @NonNull MemoryPolicy... memoryPolicyArr) {
        if (memoryPolicy2 != null) {
            this.memoryPolicy = memoryPolicy2.f53426b | this.memoryPolicy;
            if (memoryPolicyArr != null) {
                if (memoryPolicyArr.length > 0) {
                    int length = memoryPolicyArr.length;
                    int i11 = 0;
                    while (i11 < length) {
                        MemoryPolicy memoryPolicy3 = memoryPolicyArr[i11];
                        if (memoryPolicy3 != null) {
                            this.memoryPolicy = memoryPolicy3.f53426b | this.memoryPolicy;
                            i11++;
                        } else {
                            throw new IllegalArgumentException("Memory policy cannot be null.");
                        }
                    }
                }
                return this;
            }
            throw new IllegalArgumentException("Memory policy cannot be null.");
        }
        throw new IllegalArgumentException("Memory policy cannot be null.");
    }

    public RequestCreator networkPolicy(@NonNull NetworkPolicy networkPolicy2, @NonNull NetworkPolicy... networkPolicyArr) {
        if (networkPolicy2 != null) {
            this.networkPolicy = networkPolicy2.f53427b | this.networkPolicy;
            if (networkPolicyArr != null) {
                if (networkPolicyArr.length > 0) {
                    int length = networkPolicyArr.length;
                    int i11 = 0;
                    while (i11 < length) {
                        NetworkPolicy networkPolicy3 = networkPolicyArr[i11];
                        if (networkPolicy3 != null) {
                            this.networkPolicy = networkPolicy3.f53427b | this.networkPolicy;
                            i11++;
                        } else {
                            throw new IllegalArgumentException("Network policy cannot be null.");
                        }
                    }
                }
                return this;
            }
            throw new IllegalArgumentException("Network policy cannot be null.");
        }
        throw new IllegalArgumentException("Network policy cannot be null.");
    }

    public RequestCreator noFade() {
        this.noFade = true;
        return this;
    }

    public RequestCreator noPlaceholder() {
        if (this.placeholderResId != 0) {
            throw new IllegalStateException("Placeholder resource already set.");
        } else if (this.placeholderDrawable == null) {
            this.setPlaceholder = false;
            return this;
        } else {
            throw new IllegalStateException("Placeholder image already set.");
        }
    }

    public RequestCreator onlyScaleDown() {
        this.data.onlyScaleDown();
        return this;
    }

    public RequestCreator placeholder(@DrawableRes int i11) {
        if (!this.setPlaceholder) {
            throw new IllegalStateException("Already explicitly declared as no placeholder.");
        } else if (i11 == 0) {
            throw new IllegalArgumentException("Placeholder image resource invalid.");
        } else if (this.placeholderDrawable == null) {
            this.placeholderResId = i11;
            return this;
        } else {
            throw new IllegalStateException("Placeholder image already set.");
        }
    }

    public RequestCreator priority(@NonNull Picasso.Priority priority) {
        this.data.priority(priority);
        return this;
    }

    public RequestCreator purgeable() {
        this.data.purgeable();
        return this;
    }

    public RequestCreator resize(int i11, int i12) {
        this.data.resize(i11, i12);
        return this;
    }

    public RequestCreator resizeDimen(int i11, int i12) {
        Resources resources = this.picasso.f53433a.getResources();
        return resize(resources.getDimensionPixelSize(i11), resources.getDimensionPixelSize(i12));
    }

    public RequestCreator rotate(float f11) {
        this.data.rotate(f11);
        return this;
    }

    public RequestCreator stableKey(@NonNull String str) {
        this.data.stableKey(str);
        return this;
    }

    public RequestCreator tag(@NonNull Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Tag invalid.");
        } else if (this.tag == null) {
            this.tag = obj;
            return this;
        } else {
            throw new IllegalStateException("Tag already set.");
        }
    }

    public RequestCreator transform(@NonNull Transformation transformation) {
        this.data.transform(transformation);
        return this;
    }

    public RequestCreator centerCrop(int i11) {
        this.data.centerCrop(i11);
        return this;
    }

    public void fetch(@Nullable Callback callback) {
        long nanoTime = System.nanoTime();
        if (this.deferred) {
            throw new IllegalStateException("Fit cannot be used with fetch.");
        } else if (this.data.a()) {
            if (!this.data.b()) {
                this.data.priority(Picasso.Priority.LOW);
            }
            Request createRequest = createRequest(nanoTime);
            String h11 = Utils.h(createRequest, new StringBuilder());
            if (!MemoryPolicy.a(this.memoryPolicy) || this.picasso.f(h11) == null) {
                this.picasso.h(new FetchAction(this.picasso, createRequest, this.memoryPolicy, this.networkPolicy, this.tag, h11, callback));
                return;
            }
            if (this.picasso.f53442j) {
                String f11 = createRequest.f();
                Utils.u("Main", TalabatGTM.COMPLETED, f11, "from " + Picasso.LoadedFrom.MEMORY);
            }
            if (callback != null) {
                callback.onSuccess();
            }
        }
    }

    public RequestCreator rotate(float f11, float f12, float f13) {
        this.data.rotate(f11, f12, f13);
        return this;
    }

    public RequestCreator transform(@NonNull List<? extends Transformation> list) {
        this.data.transform(list);
        return this;
    }

    public RequestCreator error(@NonNull Drawable drawable) {
        if (drawable == null) {
            throw new IllegalArgumentException("Error image may not be null.");
        } else if (this.errorResId == 0) {
            this.errorDrawable = drawable;
            return this;
        } else {
            throw new IllegalStateException("Error image already set.");
        }
    }

    @VisibleForTesting
    public RequestCreator() {
        this.setPlaceholder = true;
        this.picasso = null;
        this.data = new Request.Builder((Uri) null, 0, (Bitmap.Config) null);
    }

    public RequestCreator placeholder(@NonNull Drawable drawable) {
        if (!this.setPlaceholder) {
            throw new IllegalStateException("Already explicitly declared as no placeholder.");
        } else if (this.placeholderResId == 0) {
            this.placeholderDrawable = drawable;
            return this;
        } else {
            throw new IllegalStateException("Placeholder image already set.");
        }
    }

    public void into(@NonNull RemoteViews remoteViews, @IdRes int i11, int i12, @NonNull Notification notification) {
        into(remoteViews, i11, i12, notification, (String) null);
    }

    public void into(@NonNull RemoteViews remoteViews, @IdRes int i11, int i12, @NonNull Notification notification, @Nullable String str) {
        into(remoteViews, i11, i12, notification, str, (Callback) null);
    }

    public void into(@NonNull RemoteViews remoteViews, @IdRes int i11, int i12, @NonNull Notification notification, @Nullable String str, Callback callback) {
        long nanoTime = System.nanoTime();
        if (remoteViews == null) {
            throw new IllegalArgumentException("RemoteViews must not be null.");
        } else if (notification == null) {
            throw new IllegalArgumentException("Notification must not be null.");
        } else if (this.deferred) {
            throw new IllegalStateException("Fit cannot be used with RemoteViews.");
        } else if (this.placeholderDrawable == null && this.placeholderResId == 0 && this.errorDrawable == null) {
            Request createRequest = createRequest(nanoTime);
            RemoteViews remoteViews2 = remoteViews;
            int i13 = i11;
            int i14 = i12;
            Notification notification2 = notification;
            String str2 = str;
            performRemoteViewInto(new RemoteViewsAction.NotificationAction(this.picasso, createRequest, remoteViews2, i13, i14, notification2, str2, this.memoryPolicy, this.networkPolicy, Utils.h(createRequest, new StringBuilder()), this.tag, this.errorResId, callback));
        } else {
            throw new IllegalArgumentException("Cannot use placeholder or error drawables with remote views.");
        }
    }

    public void into(@NonNull RemoteViews remoteViews, @IdRes int i11, @NonNull int[] iArr) {
        into(remoteViews, i11, iArr, (Callback) null);
    }

    public void into(@NonNull RemoteViews remoteViews, @IdRes int i11, @NonNull int[] iArr, Callback callback) {
        long nanoTime = System.nanoTime();
        if (remoteViews == null) {
            throw new IllegalArgumentException("remoteViews must not be null.");
        } else if (iArr == null) {
            throw new IllegalArgumentException("appWidgetIds must not be null.");
        } else if (this.deferred) {
            throw new IllegalStateException("Fit cannot be used with remote views.");
        } else if (this.placeholderDrawable == null && this.placeholderResId == 0 && this.errorDrawable == null) {
            Request createRequest = createRequest(nanoTime);
            RemoteViews remoteViews2 = remoteViews;
            int i12 = i11;
            int[] iArr2 = iArr;
            performRemoteViewInto(new RemoteViewsAction.AppWidgetAction(this.picasso, createRequest, remoteViews2, i12, iArr2, this.memoryPolicy, this.networkPolicy, Utils.h(createRequest, new StringBuilder()), this.tag, this.errorResId, callback));
        } else {
            throw new IllegalArgumentException("Cannot use placeholder or error drawables with remote views.");
        }
    }

    public void into(ImageView imageView) {
        into(imageView, (Callback) null);
    }

    public void into(ImageView imageView, Callback callback) {
        Bitmap f11;
        ImageView imageView2 = imageView;
        Callback callback2 = callback;
        long nanoTime = System.nanoTime();
        Utils.c();
        if (imageView2 == null) {
            throw new IllegalArgumentException("Target must not be null.");
        } else if (!this.data.a()) {
            this.picasso.cancelRequest(imageView2);
            if (this.setPlaceholder) {
                PicassoDrawable.b(imageView2, getPlaceholderDrawable());
            }
        } else {
            if (this.deferred) {
                if (!this.data.c()) {
                    int width = imageView.getWidth();
                    int height = imageView.getHeight();
                    if (width == 0 || height == 0) {
                        if (this.setPlaceholder) {
                            PicassoDrawable.b(imageView2, getPlaceholderDrawable());
                        }
                        this.picasso.c(imageView2, new DeferredRequestCreator(this, imageView2, callback2));
                        return;
                    }
                    this.data.resize(width, height);
                } else {
                    throw new IllegalStateException("Fit cannot be used with resize.");
                }
            }
            Request createRequest = createRequest(nanoTime);
            String g11 = Utils.g(createRequest);
            if (!MemoryPolicy.a(this.memoryPolicy) || (f11 = this.picasso.f(g11)) == null) {
                if (this.setPlaceholder) {
                    PicassoDrawable.b(imageView2, getPlaceholderDrawable());
                }
                this.picasso.d(new ImageViewAction(this.picasso, imageView, createRequest, this.memoryPolicy, this.networkPolicy, this.errorResId, this.errorDrawable, g11, this.tag, callback, this.noFade));
                return;
            }
            this.picasso.cancelRequest(imageView2);
            Picasso picasso2 = this.picasso;
            Context context = picasso2.f53433a;
            Picasso.LoadedFrom loadedFrom = Picasso.LoadedFrom.MEMORY;
            PicassoDrawable.a(imageView, context, f11, loadedFrom, this.noFade, picasso2.f53441i);
            if (this.picasso.f53442j) {
                String f12 = createRequest.f();
                Utils.u("Main", TalabatGTM.COMPLETED, f12, "from " + loadedFrom);
            }
            if (callback2 != null) {
                callback.onSuccess();
            }
        }
    }
}
