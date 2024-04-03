package com.afollestad.materialdialogs.utils;

import android.view.View;
import android.view.ViewTreeObserver;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\t\u001a\u00020\nH\u0016R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\b\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"com/afollestad/materialdialogs/utils/MDUtil$waitForWidth$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "lastWidth", "", "getLastWidth", "()Ljava/lang/Integer;", "setLastWidth", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "onGlobalLayout", "", "com.afollestad.material-dialogs.core"}, k = 1, mv = {1, 1, 15})
public final class MDUtil$waitForWidth$1 implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f40409b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Function1 f40410c;
    @Nullable
    private Integer lastWidth;

    public MDUtil$waitForWidth$1(T t11, Function1 function1) {
        this.f40409b = t11;
        this.f40410c = function1;
    }

    @Nullable
    public final Integer getLastWidth() {
        return this.lastWidth;
    }

    public void onGlobalLayout() {
        Integer num = this.lastWidth;
        if (num != null) {
            int measuredWidth = this.f40409b.getMeasuredWidth();
            if (num != null && num.intValue() == measuredWidth) {
                this.f40409b.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                return;
            }
        }
        if (this.f40409b.getMeasuredWidth() > 0 && this.f40409b.getMeasuredHeight() > 0) {
            Integer num2 = this.lastWidth;
            int measuredWidth2 = this.f40409b.getMeasuredWidth();
            if (num2 == null || num2.intValue() != measuredWidth2) {
                this.lastWidth = Integer.valueOf(this.f40409b.getMeasuredWidth());
                this.f40410c.invoke(this.f40409b);
            }
        }
    }

    public final void setLastWidth(@Nullable Integer num) {
        this.lastWidth = num;
    }
}
