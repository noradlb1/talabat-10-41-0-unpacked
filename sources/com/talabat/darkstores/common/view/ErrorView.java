package com.talabat.darkstores.common.view;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\t\u001a\u00020\u0004H&J\b\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH&R\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/talabat/darkstores/common/view/ErrorView;", "", "onReloadClicked", "Lkotlin/Function0;", "", "getOnReloadClicked", "()Lkotlin/jvm/functions/Function0;", "setOnReloadClicked", "(Lkotlin/jvm/functions/Function0;)V", "hide", "isVisible", "", "show", "error", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ErrorView {
    @NotNull
    Function0<Unit> getOnReloadClicked();

    void hide();

    boolean isVisible();

    void setOnReloadClicked(@NotNull Function0<Unit> function0);

    void show(@NotNull Throwable th2);
}
