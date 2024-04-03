package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u001a2\u00020\u0001:\u0003\u0018\u0019\u001aB\u000f\b\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0010\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0013H\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/facebook/share/model/AppGroupCreationContent;", "Lcom/facebook/share/model/ShareModel;", "builder", "Lcom/facebook/share/model/AppGroupCreationContent$Builder;", "(Lcom/facebook/share/model/AppGroupCreationContent$Builder;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "appGroupPrivacy", "Lcom/facebook/share/model/AppGroupCreationContent$AppGroupPrivacy;", "getAppGroupPrivacy", "()Lcom/facebook/share/model/AppGroupCreationContent$AppGroupPrivacy;", "description", "", "getDescription", "()Ljava/lang/String;", "name", "getName", "describeContents", "", "writeToParcel", "", "out", "flags", "AppGroupPrivacy", "Builder", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class AppGroupCreationContent implements ShareModel {
    @NotNull
    @JvmField
    public static final Parcelable.Creator<AppGroupCreationContent> CREATOR = new AppGroupCreationContent$Companion$CREATOR$1();
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Nullable
    private final AppGroupPrivacy appGroupPrivacy;
    @Nullable
    private final String description;
    @Nullable

    /* renamed from: name  reason: collision with root package name */
    private final String f33610name;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/facebook/share/model/AppGroupCreationContent$AppGroupPrivacy;", "", "(Ljava/lang/String;I)V", "Open", "Closed", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum AppGroupPrivacy {
        Open,
        Closed
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0013\u001a\u00020\u0002H\u0016J\u0012\u0010\u0014\u001a\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0016\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u0017\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010\u0018\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/facebook/share/model/AppGroupCreationContent$Builder;", "Lcom/facebook/share/model/ShareModelBuilder;", "Lcom/facebook/share/model/AppGroupCreationContent;", "()V", "appGroupPrivacy", "Lcom/facebook/share/model/AppGroupCreationContent$AppGroupPrivacy;", "getAppGroupPrivacy$facebook_common_release", "()Lcom/facebook/share/model/AppGroupCreationContent$AppGroupPrivacy;", "setAppGroupPrivacy$facebook_common_release", "(Lcom/facebook/share/model/AppGroupCreationContent$AppGroupPrivacy;)V", "description", "", "getDescription$facebook_common_release", "()Ljava/lang/String;", "setDescription$facebook_common_release", "(Ljava/lang/String;)V", "name", "getName$facebook_common_release", "setName$facebook_common_release", "build", "readFrom", "content", "setAppGroupPrivacy", "setDescription", "setName", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Builder implements ShareModelBuilder<AppGroupCreationContent, Builder> {
        @Nullable
        private AppGroupPrivacy appGroupPrivacy;
        @Nullable
        private String description;
        @Nullable

        /* renamed from: name  reason: collision with root package name */
        private String f33611name;

        @Nullable
        public final AppGroupPrivacy getAppGroupPrivacy$facebook_common_release() {
            return this.appGroupPrivacy;
        }

        @Nullable
        public final String getDescription$facebook_common_release() {
            return this.description;
        }

        @Nullable
        public final String getName$facebook_common_release() {
            return this.f33611name;
        }

        @NotNull
        public final Builder setAppGroupPrivacy(@Nullable AppGroupPrivacy appGroupPrivacy2) {
            this.appGroupPrivacy = appGroupPrivacy2;
            return this;
        }

        public final void setAppGroupPrivacy$facebook_common_release(@Nullable AppGroupPrivacy appGroupPrivacy2) {
            this.appGroupPrivacy = appGroupPrivacy2;
        }

        @NotNull
        public final Builder setDescription(@Nullable String str) {
            this.description = str;
            return this;
        }

        public final void setDescription$facebook_common_release(@Nullable String str) {
            this.description = str;
        }

        @NotNull
        public final Builder setName(@Nullable String str) {
            this.f33611name = str;
            return this;
        }

        public final void setName$facebook_common_release(@Nullable String str) {
            this.f33611name = str;
        }

        @NotNull
        public AppGroupCreationContent build() {
            return new AppGroupCreationContent(this, (DefaultConstructorMarker) null);
        }

        @NotNull
        public Builder readFrom(@Nullable AppGroupCreationContent appGroupCreationContent) {
            if (appGroupCreationContent == null) {
                return this;
            }
            return setName(appGroupCreationContent.getName()).setDescription(appGroupCreationContent.getDescription()).setAppGroupPrivacy(appGroupCreationContent.getAppGroupPrivacy());
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/facebook/share/model/AppGroupCreationContent$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/share/model/AppGroupCreationContent;", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private AppGroupCreationContent(Builder builder) {
        this.f33610name = builder.getName$facebook_common_release();
        this.description = builder.getDescription$facebook_common_release();
        this.appGroupPrivacy = builder.getAppGroupPrivacy$facebook_common_release();
    }

    public /* synthetic */ AppGroupCreationContent(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    public int describeContents() {
        return 0;
    }

    @Nullable
    public final AppGroupPrivacy getAppGroupPrivacy() {
        return this.appGroupPrivacy;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final String getName() {
        return this.f33610name;
    }

    public void writeToParcel(@NotNull Parcel parcel, int i11) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.f33610name);
        parcel.writeString(this.description);
        parcel.writeSerializable(this.appGroupPrivacy);
    }

    public AppGroupCreationContent(@NotNull Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.f33610name = parcel.readString();
        this.description = parcel.readString();
        this.appGroupPrivacy = (AppGroupPrivacy) parcel.readSerializable();
    }
}
