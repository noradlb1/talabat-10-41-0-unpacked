package com.designsystem.ds_text_link;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004R\u0018\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/designsystem/ds_text_link/Tappable;", "", "isEnabled", "", "()Z", "onTap", "Lkotlin/Function0;", "", "getOnTap", "()Lkotlin/jvm/functions/Function0;", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface Tappable {
    @NotNull
    Function0<Unit> getOnTap();

    boolean isEnabled();
}
