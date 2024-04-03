package com.talabat.helpcenter.presentation.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/talabat/helpcenter/presentation/model/GlobalHelpCenterMessageModel;", "", "type", "", "id", "payload", "Lcom/talabat/helpcenter/presentation/model/Payload;", "(Ljava/lang/String;Ljava/lang/String;Lcom/talabat/helpcenter/presentation/model/Payload;)V", "getId", "()Ljava/lang/String;", "getPayload", "()Lcom/talabat/helpcenter/presentation/model/Payload;", "getType", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_TalabatHelpCenter_TalabatHelpCenter"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GlobalHelpCenterMessageModel {
    @NotNull

    /* renamed from: id  reason: collision with root package name */
    private final String f60756id;
    @NotNull
    private final Payload payload;
    @NotNull
    private final String type;

    public GlobalHelpCenterMessageModel(@NotNull String str, @NotNull String str2, @NotNull Payload payload2) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(str2, "id");
        Intrinsics.checkNotNullParameter(payload2, "payload");
        this.type = str;
        this.f60756id = str2;
        this.payload = payload2;
    }

    public static /* synthetic */ GlobalHelpCenterMessageModel copy$default(GlobalHelpCenterMessageModel globalHelpCenterMessageModel, String str, String str2, Payload payload2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = globalHelpCenterMessageModel.type;
        }
        if ((i11 & 2) != 0) {
            str2 = globalHelpCenterMessageModel.f60756id;
        }
        if ((i11 & 4) != 0) {
            payload2 = globalHelpCenterMessageModel.payload;
        }
        return globalHelpCenterMessageModel.copy(str, str2, payload2);
    }

    @NotNull
    public final String component1() {
        return this.type;
    }

    @NotNull
    public final String component2() {
        return this.f60756id;
    }

    @NotNull
    public final Payload component3() {
        return this.payload;
    }

    @NotNull
    public final GlobalHelpCenterMessageModel copy(@NotNull String str, @NotNull String str2, @NotNull Payload payload2) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(str2, "id");
        Intrinsics.checkNotNullParameter(payload2, "payload");
        return new GlobalHelpCenterMessageModel(str, str2, payload2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GlobalHelpCenterMessageModel)) {
            return false;
        }
        GlobalHelpCenterMessageModel globalHelpCenterMessageModel = (GlobalHelpCenterMessageModel) obj;
        return Intrinsics.areEqual((Object) this.type, (Object) globalHelpCenterMessageModel.type) && Intrinsics.areEqual((Object) this.f60756id, (Object) globalHelpCenterMessageModel.f60756id) && Intrinsics.areEqual((Object) this.payload, (Object) globalHelpCenterMessageModel.payload);
    }

    @NotNull
    public final String getId() {
        return this.f60756id;
    }

    @NotNull
    public final Payload getPayload() {
        return this.payload;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        return (((this.type.hashCode() * 31) + this.f60756id.hashCode()) * 31) + this.payload.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.type;
        String str2 = this.f60756id;
        Payload payload2 = this.payload;
        return "GlobalHelpCenterMessageModel(type=" + str + ", id=" + str2 + ", payload=" + payload2 + ")";
    }
}
