package androidx.core.content.pm;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ShortcutInfo;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.os.UserHandle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.app.Person;
import androidx.core.content.LocusIdCompat;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.net.UriCompat;
import androidx.core.util.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ShortcutInfoCompat {
    private static final String EXTRA_LOCUS_ID = "extraLocusId";
    private static final String EXTRA_LONG_LIVED = "extraLongLived";
    private static final String EXTRA_PERSON_ = "extraPerson_";
    private static final String EXTRA_PERSON_COUNT = "extraPersonCount";
    private static final String EXTRA_SLICE_URI = "extraSliceUri";
    public static final int SURFACE_LAUNCHER = 1;
    public int A;
    public int B;

    /* renamed from: a  reason: collision with root package name */
    public Context f11240a;

    /* renamed from: b  reason: collision with root package name */
    public String f11241b;

    /* renamed from: c  reason: collision with root package name */
    public String f11242c;

    /* renamed from: d  reason: collision with root package name */
    public Intent[] f11243d;

    /* renamed from: e  reason: collision with root package name */
    public ComponentName f11244e;

    /* renamed from: f  reason: collision with root package name */
    public CharSequence f11245f;

    /* renamed from: g  reason: collision with root package name */
    public CharSequence f11246g;

    /* renamed from: h  reason: collision with root package name */
    public CharSequence f11247h;

    /* renamed from: i  reason: collision with root package name */
    public IconCompat f11248i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f11249j;

    /* renamed from: k  reason: collision with root package name */
    public Person[] f11250k;

    /* renamed from: l  reason: collision with root package name */
    public Set<String> f11251l;
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    public LocusIdCompat f11252m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f11253n;

    /* renamed from: o  reason: collision with root package name */
    public int f11254o;

    /* renamed from: p  reason: collision with root package name */
    public PersistableBundle f11255p;

    /* renamed from: q  reason: collision with root package name */
    public Bundle f11256q;

    /* renamed from: r  reason: collision with root package name */
    public long f11257r;

    /* renamed from: s  reason: collision with root package name */
    public UserHandle f11258s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f11259t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f11260u;

    /* renamed from: v  reason: collision with root package name */
    public boolean f11261v;

    /* renamed from: w  reason: collision with root package name */
    public boolean f11262w;

    /* renamed from: x  reason: collision with root package name */
    public boolean f11263x;

    /* renamed from: y  reason: collision with root package name */
    public boolean f11264y = true;

    /* renamed from: z  reason: collision with root package name */
    public boolean f11265z;

    public static class Builder {
        private Map<String, Map<String, List<String>>> mCapabilityBindingParams;
        private Set<String> mCapabilityBindings;
        private final ShortcutInfoCompat mInfo;
        private boolean mIsConversation;
        private Uri mSliceUri;

        public Builder(@NonNull Context context, @NonNull String str) {
            ShortcutInfoCompat shortcutInfoCompat = new ShortcutInfoCompat();
            this.mInfo = shortcutInfoCompat;
            shortcutInfoCompat.f11240a = context;
            shortcutInfoCompat.f11241b = str;
        }

        @SuppressLint({"MissingGetterMatchingBuilder"})
        @NonNull
        public Builder addCapabilityBinding(@NonNull String str) {
            if (this.mCapabilityBindings == null) {
                this.mCapabilityBindings = new HashSet();
            }
            this.mCapabilityBindings.add(str);
            return this;
        }

        @NonNull
        public ShortcutInfoCompat build() {
            String[] strArr;
            if (!TextUtils.isEmpty(this.mInfo.f11245f)) {
                ShortcutInfoCompat shortcutInfoCompat = this.mInfo;
                Intent[] intentArr = shortcutInfoCompat.f11243d;
                if (intentArr == null || intentArr.length == 0) {
                    throw new IllegalArgumentException("Shortcut must have an intent");
                }
                if (this.mIsConversation) {
                    if (shortcutInfoCompat.f11252m == null) {
                        shortcutInfoCompat.f11252m = new LocusIdCompat(shortcutInfoCompat.f11241b);
                    }
                    this.mInfo.f11253n = true;
                }
                if (this.mCapabilityBindings != null) {
                    ShortcutInfoCompat shortcutInfoCompat2 = this.mInfo;
                    if (shortcutInfoCompat2.f11251l == null) {
                        shortcutInfoCompat2.f11251l = new HashSet();
                    }
                    this.mInfo.f11251l.addAll(this.mCapabilityBindings);
                }
                if (this.mCapabilityBindingParams != null) {
                    ShortcutInfoCompat shortcutInfoCompat3 = this.mInfo;
                    if (shortcutInfoCompat3.f11255p == null) {
                        shortcutInfoCompat3.f11255p = new PersistableBundle();
                    }
                    for (String next : this.mCapabilityBindingParams.keySet()) {
                        Map map = this.mCapabilityBindingParams.get(next);
                        this.mInfo.f11255p.putStringArray(next, (String[]) map.keySet().toArray(new String[0]));
                        for (String str : map.keySet()) {
                            List list = (List) map.get(str);
                            PersistableBundle persistableBundle = this.mInfo.f11255p;
                            String str2 = next + "/" + str;
                            if (list == null) {
                                strArr = new String[0];
                            } else {
                                strArr = (String[]) list.toArray(new String[0]);
                            }
                            persistableBundle.putStringArray(str2, strArr);
                        }
                    }
                }
                if (this.mSliceUri != null) {
                    ShortcutInfoCompat shortcutInfoCompat4 = this.mInfo;
                    if (shortcutInfoCompat4.f11255p == null) {
                        shortcutInfoCompat4.f11255p = new PersistableBundle();
                    }
                    this.mInfo.f11255p.putString(ShortcutInfoCompat.EXTRA_SLICE_URI, UriCompat.toSafeString(this.mSliceUri));
                }
                return this.mInfo;
            }
            throw new IllegalArgumentException("Shortcut must have a non-empty label");
        }

        @NonNull
        public Builder setActivity(@NonNull ComponentName componentName) {
            this.mInfo.f11244e = componentName;
            return this;
        }

        @NonNull
        public Builder setAlwaysBadged() {
            this.mInfo.f11249j = true;
            return this;
        }

        @NonNull
        public Builder setCategories(@NonNull Set<String> set) {
            this.mInfo.f11251l = set;
            return this;
        }

        @NonNull
        public Builder setDisabledMessage(@NonNull CharSequence charSequence) {
            this.mInfo.f11247h = charSequence;
            return this;
        }

        @NonNull
        public Builder setExcludedFromSurfaces(int i11) {
            this.mInfo.B = i11;
            return this;
        }

        @NonNull
        public Builder setExtras(@NonNull PersistableBundle persistableBundle) {
            this.mInfo.f11255p = persistableBundle;
            return this;
        }

        @NonNull
        public Builder setIcon(IconCompat iconCompat) {
            this.mInfo.f11248i = iconCompat;
            return this;
        }

        @NonNull
        public Builder setIntent(@NonNull Intent intent) {
            return setIntents(new Intent[]{intent});
        }

        @NonNull
        public Builder setIntents(@NonNull Intent[] intentArr) {
            this.mInfo.f11243d = intentArr;
            return this;
        }

        @NonNull
        public Builder setIsConversation() {
            this.mIsConversation = true;
            return this;
        }

        @NonNull
        public Builder setLocusId(@Nullable LocusIdCompat locusIdCompat) {
            this.mInfo.f11252m = locusIdCompat;
            return this;
        }

        @NonNull
        public Builder setLongLabel(@NonNull CharSequence charSequence) {
            this.mInfo.f11246g = charSequence;
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setLongLived() {
            this.mInfo.f11253n = true;
            return this;
        }

        @NonNull
        public Builder setPerson(@NonNull Person person) {
            return setPersons(new Person[]{person});
        }

        @NonNull
        public Builder setPersons(@NonNull Person[] personArr) {
            this.mInfo.f11250k = personArr;
            return this;
        }

        @NonNull
        public Builder setRank(int i11) {
            this.mInfo.f11254o = i11;
            return this;
        }

        @NonNull
        public Builder setShortLabel(@NonNull CharSequence charSequence) {
            this.mInfo.f11245f = charSequence;
            return this;
        }

        @SuppressLint({"MissingGetterMatchingBuilder"})
        @NonNull
        public Builder setSliceUri(@NonNull Uri uri) {
            this.mSliceUri = uri;
            return this;
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public Builder setTransientExtras(@NonNull Bundle bundle) {
            this.mInfo.f11256q = (Bundle) Preconditions.checkNotNull(bundle);
            return this;
        }

        @NonNull
        public Builder setLongLived(boolean z11) {
            this.mInfo.f11253n = z11;
            return this;
        }

        @SuppressLint({"MissingGetterMatchingBuilder"})
        @NonNull
        public Builder addCapabilityBinding(@NonNull String str, @NonNull String str2, @NonNull List<String> list) {
            addCapabilityBinding(str);
            if (!list.isEmpty()) {
                if (this.mCapabilityBindingParams == null) {
                    this.mCapabilityBindingParams = new HashMap();
                }
                if (this.mCapabilityBindingParams.get(str) == null) {
                    this.mCapabilityBindingParams.put(str, new HashMap());
                }
                this.mCapabilityBindingParams.get(str).put(str2, list);
            }
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public Builder(@NonNull ShortcutInfoCompat shortcutInfoCompat) {
            ShortcutInfoCompat shortcutInfoCompat2 = new ShortcutInfoCompat();
            this.mInfo = shortcutInfoCompat2;
            shortcutInfoCompat2.f11240a = shortcutInfoCompat.f11240a;
            shortcutInfoCompat2.f11241b = shortcutInfoCompat.f11241b;
            shortcutInfoCompat2.f11242c = shortcutInfoCompat.f11242c;
            Intent[] intentArr = shortcutInfoCompat.f11243d;
            shortcutInfoCompat2.f11243d = (Intent[]) Arrays.copyOf(intentArr, intentArr.length);
            shortcutInfoCompat2.f11244e = shortcutInfoCompat.f11244e;
            shortcutInfoCompat2.f11245f = shortcutInfoCompat.f11245f;
            shortcutInfoCompat2.f11246g = shortcutInfoCompat.f11246g;
            shortcutInfoCompat2.f11247h = shortcutInfoCompat.f11247h;
            shortcutInfoCompat2.A = shortcutInfoCompat.A;
            shortcutInfoCompat2.f11248i = shortcutInfoCompat.f11248i;
            shortcutInfoCompat2.f11249j = shortcutInfoCompat.f11249j;
            shortcutInfoCompat2.f11258s = shortcutInfoCompat.f11258s;
            shortcutInfoCompat2.f11257r = shortcutInfoCompat.f11257r;
            shortcutInfoCompat2.f11259t = shortcutInfoCompat.f11259t;
            shortcutInfoCompat2.f11260u = shortcutInfoCompat.f11260u;
            shortcutInfoCompat2.f11261v = shortcutInfoCompat.f11261v;
            shortcutInfoCompat2.f11262w = shortcutInfoCompat.f11262w;
            shortcutInfoCompat2.f11263x = shortcutInfoCompat.f11263x;
            shortcutInfoCompat2.f11264y = shortcutInfoCompat.f11264y;
            shortcutInfoCompat2.f11252m = shortcutInfoCompat.f11252m;
            shortcutInfoCompat2.f11253n = shortcutInfoCompat.f11253n;
            shortcutInfoCompat2.f11265z = shortcutInfoCompat.f11265z;
            shortcutInfoCompat2.f11254o = shortcutInfoCompat.f11254o;
            Person[] personArr = shortcutInfoCompat.f11250k;
            if (personArr != null) {
                shortcutInfoCompat2.f11250k = (Person[]) Arrays.copyOf(personArr, personArr.length);
            }
            if (shortcutInfoCompat.f11251l != null) {
                shortcutInfoCompat2.f11251l = new HashSet(shortcutInfoCompat.f11251l);
            }
            PersistableBundle persistableBundle = shortcutInfoCompat.f11255p;
            if (persistableBundle != null) {
                shortcutInfoCompat2.f11255p = persistableBundle;
            }
            shortcutInfoCompat2.B = shortcutInfoCompat.B;
        }

        @RequiresApi(25)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public Builder(@NonNull Context context, @NonNull ShortcutInfo shortcutInfo) {
            ShortcutInfoCompat shortcutInfoCompat = new ShortcutInfoCompat();
            this.mInfo = shortcutInfoCompat;
            shortcutInfoCompat.f11240a = context;
            shortcutInfoCompat.f11241b = shortcutInfo.getId();
            shortcutInfoCompat.f11242c = shortcutInfo.getPackage();
            Intent[] a11 = shortcutInfo.getIntents();
            shortcutInfoCompat.f11243d = (Intent[]) Arrays.copyOf(a11, a11.length);
            shortcutInfoCompat.f11244e = shortcutInfo.getActivity();
            shortcutInfoCompat.f11245f = shortcutInfo.getShortLabel();
            shortcutInfoCompat.f11246g = shortcutInfo.getLongLabel();
            shortcutInfoCompat.f11247h = shortcutInfo.getDisabledMessage();
            int i11 = Build.VERSION.SDK_INT;
            if (i11 >= 28) {
                shortcutInfoCompat.A = shortcutInfo.getDisabledReason();
            } else {
                shortcutInfoCompat.A = shortcutInfo.isEnabled() ? 0 : 3;
            }
            shortcutInfoCompat.f11251l = shortcutInfo.getCategories();
            shortcutInfoCompat.f11250k = ShortcutInfoCompat.d(shortcutInfo.getExtras());
            shortcutInfoCompat.f11258s = shortcutInfo.getUserHandle();
            shortcutInfoCompat.f11257r = shortcutInfo.getLastChangedTimestamp();
            if (i11 >= 30) {
                shortcutInfoCompat.f11259t = shortcutInfo.isCached();
            }
            shortcutInfoCompat.f11260u = shortcutInfo.isDynamic();
            shortcutInfoCompat.f11261v = shortcutInfo.isPinned();
            shortcutInfoCompat.f11262w = shortcutInfo.isDeclaredInManifest();
            shortcutInfoCompat.f11263x = shortcutInfo.isImmutable();
            shortcutInfoCompat.f11264y = shortcutInfo.isEnabled();
            shortcutInfoCompat.f11265z = shortcutInfo.hasKeyFieldsOnly();
            shortcutInfoCompat.f11252m = ShortcutInfoCompat.c(shortcutInfo);
            shortcutInfoCompat.f11254o = shortcutInfo.getRank();
            shortcutInfoCompat.f11255p = shortcutInfo.getExtras();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Surface {
    }

    @RequiresApi(25)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static List<ShortcutInfoCompat> b(@NonNull Context context, @NonNull List<ShortcutInfo> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (ShortcutInfo builder : list) {
            arrayList.add(new Builder(context, builder).build());
        }
        return arrayList;
    }

    @RequiresApi(22)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    private PersistableBundle buildLegacyExtrasBundle() {
        if (this.f11255p == null) {
            this.f11255p = new PersistableBundle();
        }
        Person[] personArr = this.f11250k;
        if (personArr != null && personArr.length > 0) {
            this.f11255p.putInt(EXTRA_PERSON_COUNT, personArr.length);
            int i11 = 0;
            while (i11 < this.f11250k.length) {
                PersistableBundle persistableBundle = this.f11255p;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(EXTRA_PERSON_);
                int i12 = i11 + 1;
                sb2.append(i12);
                persistableBundle.putPersistableBundle(sb2.toString(), this.f11250k[i11].toPersistableBundle());
                i11 = i12;
            }
        }
        LocusIdCompat locusIdCompat = this.f11252m;
        if (locusIdCompat != null) {
            this.f11255p.putString(EXTRA_LOCUS_ID, locusIdCompat.getId());
        }
        this.f11255p.putBoolean(EXTRA_LONG_LIVED, this.f11253n);
        return this.f11255p;
    }

    @RequiresApi(25)
    @Nullable
    public static LocusIdCompat c(@NonNull ShortcutInfo shortcutInfo) {
        if (Build.VERSION.SDK_INT < 29) {
            return getLocusIdFromExtra(shortcutInfo.getExtras());
        }
        if (shortcutInfo.getLocusId() == null) {
            return null;
        }
        return LocusIdCompat.toLocusIdCompat(shortcutInfo.getLocusId());
    }

    @RequiresApi(25)
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @VisibleForTesting
    public static Person[] d(@NonNull PersistableBundle persistableBundle) {
        if (persistableBundle == null || !persistableBundle.containsKey(EXTRA_PERSON_COUNT)) {
            return null;
        }
        int i11 = persistableBundle.getInt(EXTRA_PERSON_COUNT);
        Person[] personArr = new Person[i11];
        int i12 = 0;
        while (i12 < i11) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(EXTRA_PERSON_);
            int i13 = i12 + 1;
            sb2.append(i13);
            personArr[i12] = Person.fromPersistableBundle(persistableBundle.getPersistableBundle(sb2.toString()));
            i12 = i13;
        }
        return personArr;
    }

    @RequiresApi(25)
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    private static LocusIdCompat getLocusIdFromExtra(@Nullable PersistableBundle persistableBundle) {
        String string;
        if (persistableBundle == null || (string = persistableBundle.getString(EXTRA_LOCUS_ID)) == null) {
            return null;
        }
        return new LocusIdCompat(string);
    }

    public Intent a(Intent intent) {
        Intent[] intentArr = this.f11243d;
        intent.putExtra("android.intent.extra.shortcut.INTENT", intentArr[intentArr.length - 1]).putExtra("android.intent.extra.shortcut.NAME", this.f11245f.toString());
        if (this.f11248i != null) {
            Drawable drawable = null;
            if (this.f11249j) {
                PackageManager packageManager = this.f11240a.getPackageManager();
                ComponentName componentName = this.f11244e;
                if (componentName != null) {
                    try {
                        drawable = packageManager.getActivityIcon(componentName);
                    } catch (PackageManager.NameNotFoundException unused) {
                    }
                }
                if (drawable == null) {
                    drawable = this.f11240a.getApplicationInfo().loadIcon(packageManager);
                }
            }
            this.f11248i.addToShortcutIntent(intent, drawable, this.f11240a);
        }
        return intent;
    }

    @Nullable
    public ComponentName getActivity() {
        return this.f11244e;
    }

    @Nullable
    public Set<String> getCategories() {
        return this.f11251l;
    }

    @Nullable
    public CharSequence getDisabledMessage() {
        return this.f11247h;
    }

    public int getDisabledReason() {
        return this.A;
    }

    public int getExcludedFromSurfaces() {
        return this.B;
    }

    @Nullable
    public PersistableBundle getExtras() {
        return this.f11255p;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public IconCompat getIcon() {
        return this.f11248i;
    }

    @NonNull
    public String getId() {
        return this.f11241b;
    }

    @NonNull
    public Intent getIntent() {
        Intent[] intentArr = this.f11243d;
        return intentArr[intentArr.length - 1];
    }

    @NonNull
    public Intent[] getIntents() {
        Intent[] intentArr = this.f11243d;
        return (Intent[]) Arrays.copyOf(intentArr, intentArr.length);
    }

    public long getLastChangedTimestamp() {
        return this.f11257r;
    }

    @Nullable
    public LocusIdCompat getLocusId() {
        return this.f11252m;
    }

    @Nullable
    public CharSequence getLongLabel() {
        return this.f11246g;
    }

    @NonNull
    public String getPackage() {
        return this.f11242c;
    }

    public int getRank() {
        return this.f11254o;
    }

    @NonNull
    public CharSequence getShortLabel() {
        return this.f11245f;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public Bundle getTransientExtras() {
        return this.f11256q;
    }

    @Nullable
    public UserHandle getUserHandle() {
        return this.f11258s;
    }

    public boolean hasKeyFieldsOnly() {
        return this.f11265z;
    }

    public boolean isCached() {
        return this.f11259t;
    }

    public boolean isDeclaredInManifest() {
        return this.f11262w;
    }

    public boolean isDynamic() {
        return this.f11260u;
    }

    public boolean isEnabled() {
        return this.f11264y;
    }

    public boolean isExcludedFromSurfaces(int i11) {
        return (i11 & this.B) != 0;
    }

    public boolean isImmutable() {
        return this.f11263x;
    }

    public boolean isPinned() {
        return this.f11261v;
    }

    @RequiresApi(25)
    public ShortcutInfo toShortcutInfo() {
        ShortcutInfo.Builder a11 = new ShortcutInfo.Builder(this.f11240a, this.f11241b).setShortLabel(this.f11245f).setIntents(this.f11243d);
        IconCompat iconCompat = this.f11248i;
        if (iconCompat != null) {
            ShortcutInfo.Builder unused = a11.setIcon(iconCompat.toIcon(this.f11240a));
        }
        if (!TextUtils.isEmpty(this.f11246g)) {
            ShortcutInfo.Builder unused2 = a11.setLongLabel(this.f11246g);
        }
        if (!TextUtils.isEmpty(this.f11247h)) {
            ShortcutInfo.Builder unused3 = a11.setDisabledMessage(this.f11247h);
        }
        ComponentName componentName = this.f11244e;
        if (componentName != null) {
            ShortcutInfo.Builder unused4 = a11.setActivity(componentName);
        }
        Set<String> set = this.f11251l;
        if (set != null) {
            ShortcutInfo.Builder unused5 = a11.setCategories(set);
        }
        ShortcutInfo.Builder unused6 = a11.setRank(this.f11254o);
        PersistableBundle persistableBundle = this.f11255p;
        if (persistableBundle != null) {
            ShortcutInfo.Builder unused7 = a11.setExtras(persistableBundle);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            Person[] personArr = this.f11250k;
            if (personArr != null && personArr.length > 0) {
                int length = personArr.length;
                android.app.Person[] personArr2 = new android.app.Person[length];
                for (int i11 = 0; i11 < length; i11++) {
                    personArr2[i11] = this.f11250k[i11].toAndroidPerson();
                }
                ShortcutInfo.Builder unused8 = a11.setPersons(personArr2);
            }
            LocusIdCompat locusIdCompat = this.f11252m;
            if (locusIdCompat != null) {
                ShortcutInfo.Builder unused9 = a11.setLocusId(locusIdCompat.toLocusId());
            }
            ShortcutInfo.Builder unused10 = a11.setLongLived(this.f11253n);
        } else {
            ShortcutInfo.Builder unused11 = a11.setExtras(buildLegacyExtrasBundle());
        }
        return a11.build();
    }
}
