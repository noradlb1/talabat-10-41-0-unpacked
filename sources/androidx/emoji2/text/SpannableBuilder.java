package androidx.emoji2.text;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.Editable;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class SpannableBuilder extends SpannableStringBuilder {
    @NonNull
    private final Class<?> mWatcherClass;
    @NonNull
    private final List<WatcherWrapper> mWatchers = new ArrayList();

    public static class WatcherWrapper implements TextWatcher, SpanWatcher {

        /* renamed from: b  reason: collision with root package name */
        public final Object f35908b;
        private final AtomicInteger mBlockCalls = new AtomicInteger(0);

        public WatcherWrapper(Object obj) {
            this.f35908b = obj;
        }

        private boolean isEmojiSpan(Object obj) {
            return obj instanceof EmojiSpan;
        }

        public final void a() {
            this.mBlockCalls.incrementAndGet();
        }

        public void afterTextChanged(Editable editable) {
            ((TextWatcher) this.f35908b).afterTextChanged(editable);
        }

        public final void b() {
            this.mBlockCalls.decrementAndGet();
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            ((TextWatcher) this.f35908b).beforeTextChanged(charSequence, i11, i12, i13);
        }

        public void onSpanAdded(Spannable spannable, Object obj, int i11, int i12) {
            if (this.mBlockCalls.get() <= 0 || !isEmojiSpan(obj)) {
                ((SpanWatcher) this.f35908b).onSpanAdded(spannable, obj, i11, i12);
            }
        }

        public void onSpanChanged(Spannable spannable, Object obj, int i11, int i12, int i13, int i14) {
            int i15;
            int i16;
            if (this.mBlockCalls.get() <= 0 || !isEmojiSpan(obj)) {
                if (Build.VERSION.SDK_INT < 28) {
                    if (i11 > i12) {
                        i11 = 0;
                    }
                    if (i13 > i14) {
                        i16 = i11;
                        i15 = 0;
                        ((SpanWatcher) this.f35908b).onSpanChanged(spannable, obj, i16, i12, i15, i14);
                    }
                }
                i16 = i11;
                i15 = i13;
                ((SpanWatcher) this.f35908b).onSpanChanged(spannable, obj, i16, i12, i15, i14);
            }
        }

        public void onSpanRemoved(Spannable spannable, Object obj, int i11, int i12) {
            if (this.mBlockCalls.get() <= 0 || !isEmojiSpan(obj)) {
                ((SpanWatcher) this.f35908b).onSpanRemoved(spannable, obj, i11, i12);
            }
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            ((TextWatcher) this.f35908b).onTextChanged(charSequence, i11, i12, i13);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public SpannableBuilder(@NonNull Class<?> cls, @NonNull CharSequence charSequence) {
        super(charSequence);
        Preconditions.checkNotNull(cls, "watcherClass cannot be null");
        this.mWatcherClass = cls;
    }

    private void blockWatchers() {
        for (int i11 = 0; i11 < this.mWatchers.size(); i11++) {
            this.mWatchers.get(i11).a();
        }
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static SpannableBuilder create(@NonNull Class<?> cls, @NonNull CharSequence charSequence) {
        return new SpannableBuilder(cls, charSequence);
    }

    private void fireWatchers() {
        for (int i11 = 0; i11 < this.mWatchers.size(); i11++) {
            this.mWatchers.get(i11).onTextChanged(this, 0, length(), length());
        }
    }

    private WatcherWrapper getWatcherFor(Object obj) {
        for (int i11 = 0; i11 < this.mWatchers.size(); i11++) {
            WatcherWrapper watcherWrapper = this.mWatchers.get(i11);
            if (watcherWrapper.f35908b == obj) {
                return watcherWrapper;
            }
        }
        return null;
    }

    private boolean isWatcher(@Nullable Object obj) {
        return obj != null && isWatcher(obj.getClass());
    }

    private void unblockwatchers() {
        for (int i11 = 0; i11 < this.mWatchers.size(); i11++) {
            this.mWatchers.get(i11).b();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void beginBatchEdit() {
        blockWatchers();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void endBatchEdit() {
        unblockwatchers();
        fireWatchers();
    }

    public int getSpanEnd(@Nullable Object obj) {
        WatcherWrapper watcherFor;
        if (isWatcher(obj) && (watcherFor = getWatcherFor(obj)) != null) {
            obj = watcherFor;
        }
        return super.getSpanEnd(obj);
    }

    public int getSpanFlags(@Nullable Object obj) {
        WatcherWrapper watcherFor;
        if (isWatcher(obj) && (watcherFor = getWatcherFor(obj)) != null) {
            obj = watcherFor;
        }
        return super.getSpanFlags(obj);
    }

    public int getSpanStart(@Nullable Object obj) {
        WatcherWrapper watcherFor;
        if (isWatcher(obj) && (watcherFor = getWatcherFor(obj)) != null) {
            obj = watcherFor;
        }
        return super.getSpanStart(obj);
    }

    @SuppressLint({"UnknownNullness"})
    public <T> T[] getSpans(int i11, int i12, @NonNull Class<T> cls) {
        if (!isWatcher((Class<?>) cls)) {
            return super.getSpans(i11, i12, cls);
        }
        WatcherWrapper[] watcherWrapperArr = (WatcherWrapper[]) super.getSpans(i11, i12, WatcherWrapper.class);
        T[] tArr = (Object[]) Array.newInstance(cls, watcherWrapperArr.length);
        for (int i13 = 0; i13 < watcherWrapperArr.length; i13++) {
            tArr[i13] = watcherWrapperArr[i13].f35908b;
        }
        return tArr;
    }

    public int nextSpanTransition(int i11, int i12, @Nullable Class<WatcherWrapper> cls) {
        if (cls == null || isWatcher((Class<?>) cls)) {
            cls = WatcherWrapper.class;
        }
        return super.nextSpanTransition(i11, i12, cls);
    }

    public void removeSpan(@Nullable Object obj) {
        WatcherWrapper watcherWrapper;
        if (isWatcher(obj)) {
            watcherWrapper = getWatcherFor(obj);
            if (watcherWrapper != null) {
                obj = watcherWrapper;
            }
        } else {
            watcherWrapper = null;
        }
        super.removeSpan(obj);
        if (watcherWrapper != null) {
            this.mWatchers.remove(watcherWrapper);
        }
    }

    public void setSpan(@Nullable Object obj, int i11, int i12, int i13) {
        if (isWatcher(obj)) {
            WatcherWrapper watcherWrapper = new WatcherWrapper(obj);
            this.mWatchers.add(watcherWrapper);
            obj = watcherWrapper;
        }
        super.setSpan(obj, i11, i12, i13);
    }

    @SuppressLint({"UnknownNullness"})
    public CharSequence subSequence(int i11, int i12) {
        return new SpannableBuilder(this.mWatcherClass, this, i11, i12);
    }

    private boolean isWatcher(@NonNull Class<?> cls) {
        return this.mWatcherClass == cls;
    }

    @SuppressLint({"UnknownNullness"})
    public SpannableStringBuilder delete(int i11, int i12) {
        super.delete(i11, i12);
        return this;
    }

    @SuppressLint({"UnknownNullness"})
    public SpannableStringBuilder insert(int i11, CharSequence charSequence) {
        super.insert(i11, charSequence);
        return this;
    }

    @SuppressLint({"UnknownNullness"})
    public SpannableStringBuilder replace(int i11, int i12, CharSequence charSequence) {
        blockWatchers();
        super.replace(i11, i12, charSequence);
        unblockwatchers();
        return this;
    }

    @SuppressLint({"UnknownNullness"})
    public SpannableStringBuilder insert(int i11, CharSequence charSequence, int i12, int i13) {
        super.insert(i11, charSequence, i12, i13);
        return this;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public SpannableBuilder(@NonNull Class<?> cls, @NonNull CharSequence charSequence, int i11, int i12) {
        super(charSequence, i11, i12);
        Preconditions.checkNotNull(cls, "watcherClass cannot be null");
        this.mWatcherClass = cls;
    }

    @SuppressLint({"UnknownNullness"})
    public SpannableStringBuilder replace(int i11, int i12, CharSequence charSequence, int i13, int i14) {
        blockWatchers();
        super.replace(i11, i12, charSequence, i13, i14);
        unblockwatchers();
        return this;
    }

    @NonNull
    public SpannableStringBuilder append(@SuppressLint({"UnknownNullness"}) CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    @NonNull
    public SpannableStringBuilder append(char c11) {
        super.append(c11);
        return this;
    }

    @NonNull
    public SpannableStringBuilder append(@SuppressLint({"UnknownNullness"}) CharSequence charSequence, int i11, int i12) {
        super.append(charSequence, i11, i12);
        return this;
    }

    @SuppressLint({"UnknownNullness"})
    public SpannableStringBuilder append(CharSequence charSequence, Object obj, int i11) {
        super.append(charSequence, obj, i11);
        return this;
    }
}
