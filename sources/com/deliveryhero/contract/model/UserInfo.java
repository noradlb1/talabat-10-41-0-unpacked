package com.deliveryhero.contract.model;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001d\u001eB-\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tB\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\nJ\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J!\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cHÇ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/deliveryhero/contract/model/UserInfo;", "", "seen1", "", "id", "", "dhAuthToken", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;)V", "getDhAuthToken", "()Ljava/lang/String;", "getId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Serializable
public final class UserInfo {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private final String dhAuthToken;
    @NotNull

    /* renamed from: id  reason: collision with root package name */
    private final String f29723id;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/deliveryhero/contract/model/UserInfo$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/deliveryhero/contract/model/UserInfo;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final KSerializer<UserInfo> serializer() {
            return UserInfo$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ UserInfo(int i11, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i11 & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i11, 3, UserInfo$$serializer.INSTANCE.getDescriptor());
        }
        this.f29723id = str;
        this.dhAuthToken = str2;
    }

    public static /* synthetic */ UserInfo copy$default(UserInfo userInfo, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = userInfo.f29723id;
        }
        if ((i11 & 2) != 0) {
            str2 = userInfo.dhAuthToken;
        }
        return userInfo.copy(str, str2);
    }

    @JvmStatic
    public static final void write$Self(@NotNull UserInfo userInfo, @NotNull CompositeEncoder compositeEncoder, @NotNull SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(userInfo, "self");
        Intrinsics.checkNotNullParameter(compositeEncoder, "output");
        Intrinsics.checkNotNullParameter(serialDescriptor, "serialDesc");
        compositeEncoder.encodeStringElement(serialDescriptor, 0, userInfo.f29723id);
        compositeEncoder.encodeStringElement(serialDescriptor, 1, userInfo.dhAuthToken);
    }

    @NotNull
    public final String component1() {
        return this.f29723id;
    }

    @NotNull
    public final String component2() {
        return this.dhAuthToken;
    }

    @NotNull
    public final UserInfo copy(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "dhAuthToken");
        return new UserInfo(str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserInfo)) {
            return false;
        }
        UserInfo userInfo = (UserInfo) obj;
        return Intrinsics.areEqual((Object) this.f29723id, (Object) userInfo.f29723id) && Intrinsics.areEqual((Object) this.dhAuthToken, (Object) userInfo.dhAuthToken);
    }

    @NotNull
    public final String getDhAuthToken() {
        return this.dhAuthToken;
    }

    @NotNull
    public final String getId() {
        return this.f29723id;
    }

    public int hashCode() {
        return (this.f29723id.hashCode() * 31) + this.dhAuthToken.hashCode();
    }

    @NotNull
    public String toString() {
        return "UserInfo(id=" + this.f29723id + ", dhAuthToken=" + this.dhAuthToken + ')';
    }

    public UserInfo(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "dhAuthToken");
        this.f29723id = str;
        this.dhAuthToken = str2;
    }
}
