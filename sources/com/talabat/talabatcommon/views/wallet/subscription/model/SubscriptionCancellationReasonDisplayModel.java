package com.talabat.talabatcommon.views.wallet.subscription.model;

import com.talabat.mapper.ModelMapping;
import com.talabat.talabatcommon.extentions.StringUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/subscription/model/SubscriptionCancellationReasonDisplayModel;", "", "()V", "displayOrder", "", "getDisplayOrder", "()I", "setDisplayOrder", "(I)V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "title", "getTitle", "setTitle", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionCancellationReasonDisplayModel {
    @ModelMapping({"displayOrder"})
    private int displayOrder;
    @NotNull
    @ModelMapping({"id"})

    /* renamed from: id  reason: collision with root package name */
    private String f11929id;
    @NotNull
    @ModelMapping({"title"})
    private String title;

    public SubscriptionCancellationReasonDisplayModel() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        this.f11929id = StringUtils.empty(stringCompanionObject);
        this.title = StringUtils.empty(stringCompanionObject);
    }

    public final int getDisplayOrder() {
        return this.displayOrder;
    }

    @NotNull
    public final String getId() {
        return this.f11929id;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public final void setDisplayOrder(int i11) {
        this.displayOrder = i11;
    }

    public final void setId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f11929id = str;
    }

    public final void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }
}
