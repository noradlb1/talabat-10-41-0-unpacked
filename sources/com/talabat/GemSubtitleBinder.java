package com.talabat;

import android.widget.TextView;
import buisnessmodels.GEMEngine;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/talabat/GemSubtitleBinder;", "Lio/reactivex/functions/Consumer;", "Landroid/widget/TextView;", "()V", "accept", "", "textView", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GemSubtitleBinder implements Consumer<TextView> {
    public void accept(@Nullable TextView textView) {
        GEMEngine instance = GEMEngine.getInstance();
        GemDialogSwitcherViewsKt.bindGemSubtitle$default(instance != null ? instance.getGems() : null, (Function1) null, new GemSubtitleBinder$accept$1(textView), 2, (Object) null);
    }
}
