package com.bumptech.glide.request.transition;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.request.transition.Transition;

public abstract class BitmapContainerTransitionFactory<R> implements TransitionFactory<R> {
    private final TransitionFactory<Drawable> realFactory;

    public final class BitmapGlideAnimation implements Transition<R> {
        private final Transition<Drawable> transition;

        public BitmapGlideAnimation(Transition<Drawable> transition2) {
            this.transition = transition2;
        }

        public boolean transition(R r11, Transition.ViewAdapter viewAdapter) {
            return this.transition.transition(new BitmapDrawable(viewAdapter.getView().getResources(), BitmapContainerTransitionFactory.this.getBitmap(r11)), viewAdapter);
        }
    }

    public BitmapContainerTransitionFactory(TransitionFactory<Drawable> transitionFactory) {
        this.realFactory = transitionFactory;
    }

    public Transition<R> build(DataSource dataSource, boolean z11) {
        return new BitmapGlideAnimation(this.realFactory.build(dataSource, z11));
    }

    public abstract Bitmap getBitmap(R r11);
}
