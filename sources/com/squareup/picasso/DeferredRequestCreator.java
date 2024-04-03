package com.squareup.picasso;

import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import androidx.annotation.VisibleForTesting;
import java.lang.ref.WeakReference;

class DeferredRequestCreator implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {
    @VisibleForTesting

    /* renamed from: b  reason: collision with root package name */
    public final WeakReference<ImageView> f53396b;
    @VisibleForTesting

    /* renamed from: c  reason: collision with root package name */
    public Callback f53397c;
    private final RequestCreator creator;

    public DeferredRequestCreator(RequestCreator requestCreator, ImageView imageView, Callback callback) {
        this.creator = requestCreator;
        this.f53396b = new WeakReference<>(imageView);
        this.f53397c = callback;
        imageView.addOnAttachStateChangeListener(this);
        if (imageView.getWindowToken() != null) {
            onViewAttachedToWindow(imageView);
        }
    }

    public void a() {
        this.creator.a();
        this.f53397c = null;
        ImageView imageView = this.f53396b.get();
        if (imageView != null) {
            this.f53396b.clear();
            imageView.removeOnAttachStateChangeListener(this);
            ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this);
            }
        }
    }

    public Object b() {
        return this.creator.b();
    }

    public boolean onPreDraw() {
        ImageView imageView = this.f53396b.get();
        if (imageView == null) {
            return true;
        }
        ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
        if (!viewTreeObserver.isAlive()) {
            return true;
        }
        int width = imageView.getWidth();
        int height = imageView.getHeight();
        if (width > 0 && height > 0) {
            imageView.removeOnAttachStateChangeListener(this);
            viewTreeObserver.removeOnPreDrawListener(this);
            this.f53396b.clear();
            this.creator.c().resize(width, height).into(imageView, this.f53397c);
        }
        return true;
    }

    public void onViewAttachedToWindow(View view) {
        view.getViewTreeObserver().addOnPreDrawListener(this);
    }

    public void onViewDetachedFromWindow(View view) {
        view.getViewTreeObserver().removeOnPreDrawListener(this);
    }
}
