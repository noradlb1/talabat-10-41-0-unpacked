package androidx.core.view;

import android.content.ClipData;
import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.ContentInfo;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import j$.util.function.Predicate;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import s1.d;

public final class ContentInfoCompat {
    public static final int FLAG_CONVERT_TO_PLAIN_TEXT = 1;
    public static final int SOURCE_APP = 0;
    public static final int SOURCE_AUTOFILL = 4;
    public static final int SOURCE_CLIPBOARD = 1;
    public static final int SOURCE_DRAG_AND_DROP = 3;
    public static final int SOURCE_INPUT_METHOD = 2;
    public static final int SOURCE_PROCESS_TEXT = 5;
    @NonNull
    private final Compat mCompat;

    @RequiresApi(31)
    public static final class Api31Impl {
        private Api31Impl() {
        }

        @DoNotInline
        @NonNull
        public static Pair<ContentInfo, ContentInfo> partition(@NonNull ContentInfo contentInfo, @NonNull Predicate<ClipData.Item> predicate) {
            ContentInfo contentInfo2;
            ClipData a11 = contentInfo.getClip();
            if (a11.getItemCount() == 1) {
                boolean test = predicate.test(a11.getItemAt(0));
                if (test) {
                    contentInfo2 = contentInfo;
                } else {
                    contentInfo2 = null;
                }
                if (test) {
                    contentInfo = null;
                }
                return Pair.create(contentInfo2, contentInfo);
            }
            Objects.requireNonNull(predicate);
            Pair<ClipData, ClipData> c11 = ContentInfoCompat.c(a11, new d(predicate));
            if (c11.first == null) {
                return Pair.create((Object) null, contentInfo);
            }
            if (c11.second == null) {
                return Pair.create(contentInfo, (Object) null);
            }
            return Pair.create(new ContentInfo.Builder(contentInfo).setClip((ClipData) c11.first).build(), new ContentInfo.Builder(contentInfo).setClip((ClipData) c11.second).build());
        }
    }

    public interface BuilderCompat {
        @NonNull
        ContentInfoCompat build();

        void setClip(@NonNull ClipData clipData);

        void setExtras(@Nullable Bundle bundle);

        void setFlags(int i11);

        void setLinkUri(@Nullable Uri uri);

        void setSource(int i11);
    }

    public interface Compat {
        @NonNull
        ClipData getClip();

        @Nullable
        Bundle getExtras();

        int getFlags();

        @Nullable
        Uri getLinkUri();

        int getSource();

        @Nullable
        ContentInfo getWrapped();
    }

    @RequiresApi(31)
    public static final class Compat31Impl implements Compat {
        @NonNull
        private final ContentInfo mWrapped;

        public Compat31Impl(@NonNull ContentInfo contentInfo) {
            this.mWrapped = (ContentInfo) Preconditions.checkNotNull(contentInfo);
        }

        @NonNull
        public ClipData getClip() {
            return this.mWrapped.getClip();
        }

        @Nullable
        public Bundle getExtras() {
            return this.mWrapped.getExtras();
        }

        public int getFlags() {
            return this.mWrapped.getFlags();
        }

        @Nullable
        public Uri getLinkUri() {
            return this.mWrapped.getLinkUri();
        }

        public int getSource() {
            return this.mWrapped.getSource();
        }

        @NonNull
        public ContentInfo getWrapped() {
            return this.mWrapped;
        }

        @NonNull
        public String toString() {
            return "ContentInfoCompat{" + this.mWrapped + "}";
        }
    }

    public static final class CompatImpl implements Compat {
        @NonNull
        private final ClipData mClip;
        @Nullable
        private final Bundle mExtras;
        private final int mFlags;
        @Nullable
        private final Uri mLinkUri;
        private final int mSource;

        public CompatImpl(BuilderCompatImpl builderCompatImpl) {
            this.mClip = (ClipData) Preconditions.checkNotNull(builderCompatImpl.f11458a);
            this.mSource = Preconditions.checkArgumentInRange(builderCompatImpl.f11459b, 0, 5, "source");
            this.mFlags = Preconditions.checkFlagsArgument(builderCompatImpl.f11460c, 1);
            this.mLinkUri = builderCompatImpl.f11461d;
            this.mExtras = builderCompatImpl.f11462e;
        }

        @NonNull
        public ClipData getClip() {
            return this.mClip;
        }

        @Nullable
        public Bundle getExtras() {
            return this.mExtras;
        }

        public int getFlags() {
            return this.mFlags;
        }

        @Nullable
        public Uri getLinkUri() {
            return this.mLinkUri;
        }

        public int getSource() {
            return this.mSource;
        }

        @Nullable
        public ContentInfo getWrapped() {
            return null;
        }

        @NonNull
        public String toString() {
            String str;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("ContentInfoCompat{clip=");
            sb2.append(this.mClip.getDescription());
            sb2.append(", source=");
            sb2.append(ContentInfoCompat.d(this.mSource));
            sb2.append(", flags=");
            sb2.append(ContentInfoCompat.b(this.mFlags));
            String str2 = "";
            if (this.mLinkUri == null) {
                str = str2;
            } else {
                str = ", hasLinkUri(" + this.mLinkUri.toString().length() + ")";
            }
            sb2.append(str);
            if (this.mExtras != null) {
                str2 = ", hasExtras";
            }
            sb2.append(str2);
            sb2.append("}");
            return sb2.toString();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Source {
    }

    public ContentInfoCompat(@NonNull Compat compat) {
        this.mCompat = compat;
    }

    @NonNull
    public static ClipData a(@NonNull ClipDescription clipDescription, @NonNull List<ClipData.Item> list) {
        ClipData clipData = new ClipData(new ClipDescription(clipDescription), list.get(0));
        for (int i11 = 1; i11 < list.size(); i11++) {
            clipData.addItem(list.get(i11));
        }
        return clipData;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static String b(int i11) {
        if ((i11 & 1) != 0) {
            return "FLAG_CONVERT_TO_PLAIN_TEXT";
        }
        return String.valueOf(i11);
    }

    @NonNull
    public static Pair<ClipData, ClipData> c(@NonNull ClipData clipData, @NonNull androidx.core.util.Predicate<ClipData.Item> predicate) {
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        for (int i11 = 0; i11 < clipData.getItemCount(); i11++) {
            ClipData.Item itemAt = clipData.getItemAt(i11);
            if (predicate.test(itemAt)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(itemAt);
            } else {
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                }
                arrayList2.add(itemAt);
            }
        }
        if (arrayList == null) {
            return Pair.create((Object) null, clipData);
        }
        if (arrayList2 == null) {
            return Pair.create(clipData, (Object) null);
        }
        return Pair.create(a(clipData.getDescription(), arrayList), a(clipData.getDescription(), arrayList2));
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static String d(int i11) {
        return i11 != 0 ? i11 != 1 ? i11 != 2 ? i11 != 3 ? i11 != 4 ? i11 != 5 ? String.valueOf(i11) : "SOURCE_PROCESS_TEXT" : "SOURCE_AUTOFILL" : "SOURCE_DRAG_AND_DROP" : "SOURCE_INPUT_METHOD" : "SOURCE_CLIPBOARD" : "SOURCE_APP";
    }

    @RequiresApi(31)
    @NonNull
    public static ContentInfoCompat toContentInfoCompat(@NonNull ContentInfo contentInfo) {
        return new ContentInfoCompat(new Compat31Impl(contentInfo));
    }

    @NonNull
    public ClipData getClip() {
        return this.mCompat.getClip();
    }

    @Nullable
    public Bundle getExtras() {
        return this.mCompat.getExtras();
    }

    public int getFlags() {
        return this.mCompat.getFlags();
    }

    @Nullable
    public Uri getLinkUri() {
        return this.mCompat.getLinkUri();
    }

    public int getSource() {
        return this.mCompat.getSource();
    }

    @NonNull
    public Pair<ContentInfoCompat, ContentInfoCompat> partition(@NonNull androidx.core.util.Predicate<ClipData.Item> predicate) {
        ClipData clip = this.mCompat.getClip();
        ContentInfoCompat contentInfoCompat = null;
        if (clip.getItemCount() == 1) {
            boolean test = predicate.test(clip.getItemAt(0));
            ContentInfoCompat contentInfoCompat2 = test ? this : null;
            if (!test) {
                contentInfoCompat = this;
            }
            return Pair.create(contentInfoCompat2, contentInfoCompat);
        }
        Pair<ClipData, ClipData> c11 = c(clip, predicate);
        if (c11.first == null) {
            return Pair.create((Object) null, this);
        }
        if (c11.second == null) {
            return Pair.create(this, (Object) null);
        }
        return Pair.create(new Builder(this).setClip((ClipData) c11.first).build(), new Builder(this).setClip((ClipData) c11.second).build());
    }

    @RequiresApi(31)
    @NonNull
    public ContentInfo toContentInfo() {
        ContentInfo wrapped = this.mCompat.getWrapped();
        Objects.requireNonNull(wrapped);
        ContentInfo contentInfo = wrapped;
        return wrapped;
    }

    @NonNull
    public String toString() {
        return this.mCompat.toString();
    }

    @RequiresApi(31)
    public static final class BuilderCompat31Impl implements BuilderCompat {
        @NonNull
        private final ContentInfo.Builder mPlatformBuilder;

        public BuilderCompat31Impl(@NonNull ClipData clipData, int i11) {
            this.mPlatformBuilder = new ContentInfo.Builder(clipData, i11);
        }

        @NonNull
        public ContentInfoCompat build() {
            return new ContentInfoCompat(new Compat31Impl(this.mPlatformBuilder.build()));
        }

        public void setClip(@NonNull ClipData clipData) {
            ContentInfo.Builder unused = this.mPlatformBuilder.setClip(clipData);
        }

        public void setExtras(@Nullable Bundle bundle) {
            ContentInfo.Builder unused = this.mPlatformBuilder.setExtras(bundle);
        }

        public void setFlags(int i11) {
            ContentInfo.Builder unused = this.mPlatformBuilder.setFlags(i11);
        }

        public void setLinkUri(@Nullable Uri uri) {
            ContentInfo.Builder unused = this.mPlatformBuilder.setLinkUri(uri);
        }

        public void setSource(int i11) {
            ContentInfo.Builder unused = this.mPlatformBuilder.setSource(i11);
        }

        public BuilderCompat31Impl(@NonNull ContentInfoCompat contentInfoCompat) {
            this.mPlatformBuilder = new ContentInfo.Builder(contentInfoCompat.toContentInfo());
        }
    }

    public static final class BuilderCompatImpl implements BuilderCompat {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        public ClipData f11458a;

        /* renamed from: b  reason: collision with root package name */
        public int f11459b;

        /* renamed from: c  reason: collision with root package name */
        public int f11460c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        public Uri f11461d;
        @Nullable

        /* renamed from: e  reason: collision with root package name */
        public Bundle f11462e;

        public BuilderCompatImpl(@NonNull ClipData clipData, int i11) {
            this.f11458a = clipData;
            this.f11459b = i11;
        }

        @NonNull
        public ContentInfoCompat build() {
            return new ContentInfoCompat(new CompatImpl(this));
        }

        public void setClip(@NonNull ClipData clipData) {
            this.f11458a = clipData;
        }

        public void setExtras(@Nullable Bundle bundle) {
            this.f11462e = bundle;
        }

        public void setFlags(int i11) {
            this.f11460c = i11;
        }

        public void setLinkUri(@Nullable Uri uri) {
            this.f11461d = uri;
        }

        public void setSource(int i11) {
            this.f11459b = i11;
        }

        public BuilderCompatImpl(@NonNull ContentInfoCompat contentInfoCompat) {
            this.f11458a = contentInfoCompat.getClip();
            this.f11459b = contentInfoCompat.getSource();
            this.f11460c = contentInfoCompat.getFlags();
            this.f11461d = contentInfoCompat.getLinkUri();
            this.f11462e = contentInfoCompat.getExtras();
        }
    }

    public static final class Builder {
        @NonNull
        private final BuilderCompat mBuilderCompat;

        public Builder(@NonNull ContentInfoCompat contentInfoCompat) {
            if (Build.VERSION.SDK_INT >= 31) {
                this.mBuilderCompat = new BuilderCompat31Impl(contentInfoCompat);
            } else {
                this.mBuilderCompat = new BuilderCompatImpl(contentInfoCompat);
            }
        }

        @NonNull
        public ContentInfoCompat build() {
            return this.mBuilderCompat.build();
        }

        @NonNull
        public Builder setClip(@NonNull ClipData clipData) {
            this.mBuilderCompat.setClip(clipData);
            return this;
        }

        @NonNull
        public Builder setExtras(@Nullable Bundle bundle) {
            this.mBuilderCompat.setExtras(bundle);
            return this;
        }

        @NonNull
        public Builder setFlags(int i11) {
            this.mBuilderCompat.setFlags(i11);
            return this;
        }

        @NonNull
        public Builder setLinkUri(@Nullable Uri uri) {
            this.mBuilderCompat.setLinkUri(uri);
            return this;
        }

        @NonNull
        public Builder setSource(int i11) {
            this.mBuilderCompat.setSource(i11);
            return this;
        }

        public Builder(@NonNull ClipData clipData, int i11) {
            if (Build.VERSION.SDK_INT >= 31) {
                this.mBuilderCompat = new BuilderCompat31Impl(clipData, i11);
            } else {
                this.mBuilderCompat = new BuilderCompatImpl(clipData, i11);
            }
        }
    }

    @RequiresApi(31)
    @NonNull
    public static Pair<ContentInfo, ContentInfo> partition(@NonNull ContentInfo contentInfo, @NonNull Predicate<ClipData.Item> predicate) {
        return Api31Impl.partition(contentInfo, predicate);
    }
}
