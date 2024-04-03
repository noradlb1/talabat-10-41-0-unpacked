package com.bumptech.glide;

import android.graphics.drawable.Drawable;
import android.widget.AbsListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Util;
import java.util.List;
import java.util.Queue;

public class ListPreloader<T> implements AbsListView.OnScrollListener {
    private boolean isIncreasing = true;
    private int lastEnd;
    private int lastFirstVisible = -1;
    private int lastStart;
    private final int maxPreload;
    private final PreloadSizeProvider<T> preloadDimensionProvider;
    private final PreloadModelProvider<T> preloadModelProvider;
    private final PreloadTargetQueue preloadTargetQueue;
    private final RequestManager requestManager;
    private int totalItemCount;

    public interface PreloadModelProvider<U> {
        @NonNull
        List<U> getPreloadItems(int i11);

        @Nullable
        RequestBuilder<?> getPreloadRequestBuilder(@NonNull U u11);
    }

    public interface PreloadSizeProvider<T> {
        @Nullable
        int[] getPreloadSize(@NonNull T t11, int i11, int i12);
    }

    public static final class PreloadTarget implements Target<Object> {
        int photoHeight;
        int photoWidth;
        @Nullable
        private Request request;

        @Nullable
        public Request getRequest() {
            return this.request;
        }

        public void getSize(@NonNull SizeReadyCallback sizeReadyCallback) {
            sizeReadyCallback.onSizeReady(this.photoWidth, this.photoHeight);
        }

        public void onDestroy() {
        }

        public void onLoadCleared(@Nullable Drawable drawable) {
        }

        public void onLoadFailed(@Nullable Drawable drawable) {
        }

        public void onLoadStarted(@Nullable Drawable drawable) {
        }

        public void onResourceReady(@NonNull Object obj, @Nullable Transition<? super Object> transition) {
        }

        public void onStart() {
        }

        public void onStop() {
        }

        public void removeCallback(@NonNull SizeReadyCallback sizeReadyCallback) {
        }

        public void setRequest(@Nullable Request request2) {
            this.request = request2;
        }
    }

    public static final class PreloadTargetQueue {
        final Queue<PreloadTarget> queue;

        public PreloadTargetQueue(int i11) {
            this.queue = Util.createQueue(i11);
            for (int i12 = 0; i12 < i11; i12++) {
                this.queue.offer(new PreloadTarget());
            }
        }

        public PreloadTarget next(int i11, int i12) {
            PreloadTarget poll = this.queue.poll();
            this.queue.offer(poll);
            poll.photoWidth = i11;
            poll.photoHeight = i12;
            return poll;
        }
    }

    public ListPreloader(@NonNull RequestManager requestManager2, @NonNull PreloadModelProvider<T> preloadModelProvider2, @NonNull PreloadSizeProvider<T> preloadSizeProvider, int i11) {
        this.requestManager = requestManager2;
        this.preloadModelProvider = preloadModelProvider2;
        this.preloadDimensionProvider = preloadSizeProvider;
        this.maxPreload = i11;
        this.preloadTargetQueue = new PreloadTargetQueue(i11 + 1);
    }

    private void cancelAll() {
        for (int i11 = 0; i11 < this.preloadTargetQueue.queue.size(); i11++) {
            this.requestManager.clear((Target<?>) this.preloadTargetQueue.next(0, 0));
        }
    }

    private void preload(int i11, boolean z11) {
        if (this.isIncreasing != z11) {
            this.isIncreasing = z11;
            cancelAll();
        }
        preload(i11, (z11 ? this.maxPreload : -this.maxPreload) + i11);
    }

    private void preloadAdapterPosition(List<T> list, int i11, boolean z11) {
        int size = list.size();
        if (z11) {
            for (int i12 = 0; i12 < size; i12++) {
                preloadItem(list.get(i12), i11, i12);
            }
            return;
        }
        for (int i13 = size - 1; i13 >= 0; i13--) {
            preloadItem(list.get(i13), i11, i13);
        }
    }

    private void preloadItem(@Nullable T t11, int i11, int i12) {
        int[] preloadSize;
        RequestBuilder<?> preloadRequestBuilder;
        if (t11 != null && (preloadSize = this.preloadDimensionProvider.getPreloadSize(t11, i11, i12)) != null && (preloadRequestBuilder = this.preloadModelProvider.getPreloadRequestBuilder(t11)) != null) {
            preloadRequestBuilder.into(this.preloadTargetQueue.next(preloadSize[0], preloadSize[1]));
        }
    }

    public void onScroll(AbsListView absListView, int i11, int i12, int i13) {
        this.totalItemCount = i13;
        int i14 = this.lastFirstVisible;
        if (i11 > i14) {
            preload(i12 + i11, true);
        } else if (i11 < i14) {
            preload(i11, false);
        }
        this.lastFirstVisible = i11;
    }

    public void onScrollStateChanged(AbsListView absListView, int i11) {
    }

    private void preload(int i11, int i12) {
        int i13;
        int i14;
        if (i11 < i12) {
            i13 = Math.max(this.lastEnd, i11);
            i14 = i12;
        } else {
            i14 = Math.min(this.lastStart, i11);
            i13 = i12;
        }
        int min = Math.min(this.totalItemCount, i14);
        int min2 = Math.min(this.totalItemCount, Math.max(0, i13));
        if (i11 < i12) {
            for (int i15 = min2; i15 < min; i15++) {
                preloadAdapterPosition(this.preloadModelProvider.getPreloadItems(i15), i15, true);
            }
        } else {
            for (int i16 = min - 1; i16 >= min2; i16--) {
                preloadAdapterPosition(this.preloadModelProvider.getPreloadItems(i16), i16, false);
            }
        }
        this.lastStart = min2;
        this.lastEnd = min;
    }
}
