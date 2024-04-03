package io.flutter.embedding.engine.deferredcomponents;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.SparseArray;
import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.security.CertificateUtil;
import com.google.android.play.core.splitinstall.SplitInstallException;
import com.google.android.play.core.splitinstall.SplitInstallManager;
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory;
import com.google.android.play.core.splitinstall.SplitInstallRequest;
import com.google.android.play.core.splitinstall.SplitInstallSessionState;
import com.google.android.play.core.splitinstall.SplitInstallStateUpdatedListener;
import com.talabat.sidemenu.SideMenuRewardViewHolder;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.loader.ApplicationInfoLoader;
import io.flutter.embedding.engine.loader.FlutterApplicationInfo;
import io.flutter.embedding.engine.systemchannels.DeferredComponentChannel;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import net.bytebuddy.utility.JavaConstant;
import rz.a;
import rz.b;
import tracking.gtm.TalabatGTM;

public class PlayStoreDeferredComponentManager implements DeferredComponentManager {
    public static final String MAPPING_KEY = (DeferredComponentManager.class.getName() + ".loadingUnitMapping");
    private static final String TAG = "PlayStoreDeferredComponentManager";
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public SparseArray<String> f14185a = new SparseArray<>();
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public SparseArray<String> f14186b = new SparseArray<>();
    /* access modifiers changed from: private */
    @Nullable
    public DeferredComponentChannel channel;
    @NonNull
    private Context context;
    @NonNull
    private FlutterApplicationInfo flutterApplicationInfo;
    /* access modifiers changed from: private */
    @Nullable
    public FlutterJNI flutterJNI;
    private FeatureInstallStateUpdatedListener listener;
    @NonNull
    private Map<String, Integer> nameToSessionId = new HashMap();
    /* access modifiers changed from: private */
    @NonNull
    public SparseIntArray sessionIdToLoadingUnitId = new SparseIntArray();
    /* access modifiers changed from: private */
    @NonNull
    public SparseArray<String> sessionIdToName = new SparseArray<>();
    /* access modifiers changed from: private */
    @NonNull
    public SparseArray<String> sessionIdToState = new SparseArray<>();
    @NonNull
    private SplitInstallManager splitInstallManager;

    public class FeatureInstallStateUpdatedListener implements SplitInstallStateUpdatedListener {
        private FeatureInstallStateUpdatedListener() {
        }

        @SuppressLint({"DefaultLocale"})
        public void onStateUpdate(@NonNull SplitInstallSessionState splitInstallSessionState) {
            int sessionId = splitInstallSessionState.sessionId();
            if (PlayStoreDeferredComponentManager.this.sessionIdToName.get(sessionId) != null) {
                switch (splitInstallSessionState.status()) {
                    case 1:
                        Log.d(PlayStoreDeferredComponentManager.TAG, String.format("Module \"%s\" (sessionId %d) install pending.", new Object[]{PlayStoreDeferredComponentManager.this.sessionIdToName.get(sessionId), Integer.valueOf(sessionId)}));
                        PlayStoreDeferredComponentManager.this.sessionIdToState.put(sessionId, "pending");
                        return;
                    case 2:
                        Log.d(PlayStoreDeferredComponentManager.TAG, String.format("Module \"%s\" (sessionId %d) downloading.", new Object[]{PlayStoreDeferredComponentManager.this.sessionIdToName.get(sessionId), Integer.valueOf(sessionId)}));
                        PlayStoreDeferredComponentManager.this.sessionIdToState.put(sessionId, "downloading");
                        return;
                    case 3:
                        Log.d(PlayStoreDeferredComponentManager.TAG, String.format("Module \"%s\" (sessionId %d) downloaded.", new Object[]{PlayStoreDeferredComponentManager.this.sessionIdToName.get(sessionId), Integer.valueOf(sessionId)}));
                        PlayStoreDeferredComponentManager.this.sessionIdToState.put(sessionId, "downloaded");
                        return;
                    case 4:
                        Log.d(PlayStoreDeferredComponentManager.TAG, String.format("Module \"%s\" (sessionId %d) installing.", new Object[]{PlayStoreDeferredComponentManager.this.sessionIdToName.get(sessionId), Integer.valueOf(sessionId)}));
                        PlayStoreDeferredComponentManager.this.sessionIdToState.put(sessionId, "installing");
                        return;
                    case 5:
                        Log.d(PlayStoreDeferredComponentManager.TAG, String.format("Module \"%s\" (sessionId %d) install successfully.", new Object[]{PlayStoreDeferredComponentManager.this.sessionIdToName.get(sessionId), Integer.valueOf(sessionId)}));
                        PlayStoreDeferredComponentManager playStoreDeferredComponentManager = PlayStoreDeferredComponentManager.this;
                        playStoreDeferredComponentManager.loadAssets(playStoreDeferredComponentManager.sessionIdToLoadingUnitId.get(sessionId), (String) PlayStoreDeferredComponentManager.this.sessionIdToName.get(sessionId));
                        if (PlayStoreDeferredComponentManager.this.sessionIdToLoadingUnitId.get(sessionId) > 0) {
                            PlayStoreDeferredComponentManager playStoreDeferredComponentManager2 = PlayStoreDeferredComponentManager.this;
                            playStoreDeferredComponentManager2.loadDartLibrary(playStoreDeferredComponentManager2.sessionIdToLoadingUnitId.get(sessionId), (String) PlayStoreDeferredComponentManager.this.sessionIdToName.get(sessionId));
                        }
                        if (PlayStoreDeferredComponentManager.this.channel != null) {
                            PlayStoreDeferredComponentManager.this.channel.completeInstallSuccess((String) PlayStoreDeferredComponentManager.this.sessionIdToName.get(sessionId));
                        }
                        PlayStoreDeferredComponentManager.this.sessionIdToName.delete(sessionId);
                        PlayStoreDeferredComponentManager.this.sessionIdToLoadingUnitId.delete(sessionId);
                        PlayStoreDeferredComponentManager.this.sessionIdToState.put(sessionId, "installed");
                        return;
                    case 6:
                        Log.e(PlayStoreDeferredComponentManager.TAG, String.format("Module \"%s\" (sessionId %d) install failed with: %s", new Object[]{PlayStoreDeferredComponentManager.this.sessionIdToName.get(sessionId), Integer.valueOf(sessionId), Integer.valueOf(splitInstallSessionState.errorCode())}));
                        FlutterJNI c11 = PlayStoreDeferredComponentManager.this.flutterJNI;
                        int i11 = PlayStoreDeferredComponentManager.this.sessionIdToLoadingUnitId.get(sessionId);
                        c11.deferredComponentInstallFailure(i11, "Module install failed with " + splitInstallSessionState.errorCode(), true);
                        if (PlayStoreDeferredComponentManager.this.channel != null) {
                            PlayStoreDeferredComponentManager.this.channel.completeInstallError((String) PlayStoreDeferredComponentManager.this.sessionIdToName.get(sessionId), "Android Deferred Component failed to install.");
                        }
                        PlayStoreDeferredComponentManager.this.sessionIdToName.delete(sessionId);
                        PlayStoreDeferredComponentManager.this.sessionIdToLoadingUnitId.delete(sessionId);
                        PlayStoreDeferredComponentManager.this.sessionIdToState.put(sessionId, TalabatGTM.FAILED);
                        return;
                    case 7:
                        Log.d(PlayStoreDeferredComponentManager.TAG, String.format("Module \"%s\" (sessionId %d) install canceled.", new Object[]{PlayStoreDeferredComponentManager.this.sessionIdToName.get(sessionId), Integer.valueOf(sessionId)}));
                        if (PlayStoreDeferredComponentManager.this.channel != null) {
                            PlayStoreDeferredComponentManager.this.channel.completeInstallError((String) PlayStoreDeferredComponentManager.this.sessionIdToName.get(sessionId), "Android Deferred Component installation canceled.");
                        }
                        PlayStoreDeferredComponentManager.this.sessionIdToName.delete(sessionId);
                        PlayStoreDeferredComponentManager.this.sessionIdToLoadingUnitId.delete(sessionId);
                        PlayStoreDeferredComponentManager.this.sessionIdToState.put(sessionId, AnalyticsEvents.PARAMETER_SHARE_OUTCOME_CANCELLED);
                        return;
                    case 8:
                        Log.d(PlayStoreDeferredComponentManager.TAG, String.format("Module \"%s\" (sessionId %d) install requires user confirmation.", new Object[]{PlayStoreDeferredComponentManager.this.sessionIdToName.get(sessionId), Integer.valueOf(sessionId)}));
                        PlayStoreDeferredComponentManager.this.sessionIdToState.put(sessionId, "requiresUserConfirmation");
                        return;
                    case 9:
                        Log.d(PlayStoreDeferredComponentManager.TAG, String.format("Module \"%s\" (sessionId %d) install canceling.", new Object[]{PlayStoreDeferredComponentManager.this.sessionIdToName.get(sessionId), Integer.valueOf(sessionId)}));
                        PlayStoreDeferredComponentManager.this.sessionIdToState.put(sessionId, "canceling");
                        return;
                    default:
                        Log.d(PlayStoreDeferredComponentManager.TAG, "Unknown status: " + splitInstallSessionState.status());
                        return;
                }
            }
        }
    }

    public PlayStoreDeferredComponentManager(@NonNull Context context2, @Nullable FlutterJNI flutterJNI2) {
        this.context = context2;
        this.flutterJNI = flutterJNI2;
        this.flutterApplicationInfo = ApplicationInfoLoader.load(context2);
        this.splitInstallManager = SplitInstallManagerFactory.create(context2);
        FeatureInstallStateUpdatedListener featureInstallStateUpdatedListener = new FeatureInstallStateUpdatedListener();
        this.listener = featureInstallStateUpdatedListener;
        this.splitInstallManager.registerListener(featureInstallStateUpdatedListener);
        initLoadingUnitMappingToComponentNames();
    }

    @NonNull
    private ApplicationInfo getApplicationInfo() {
        try {
            return this.context.getPackageManager().getApplicationInfo(this.context.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException e11) {
            throw new RuntimeException(e11);
        }
    }

    private void initLoadingUnitMappingToComponentNames() {
        Bundle bundle;
        ApplicationInfo applicationInfo = getApplicationInfo();
        if (applicationInfo != null && (bundle = applicationInfo.metaData) != null) {
            String str = MAPPING_KEY;
            String string = bundle.getString(str, (String) null);
            if (string == null) {
                Log.e(TAG, "No loading unit to dynamic feature module name found. Ensure '" + str + "' is defined in the base module's AndroidManifest.");
            } else if (!string.equals("")) {
                for (String split : string.split(",")) {
                    String[] split2 = split.split(CertificateUtil.DELIMITER, -1);
                    int parseInt = Integer.parseInt(split2[0]);
                    this.f14185a.put(parseInt, split2[1]);
                    if (split2.length > 2) {
                        this.f14186b.put(parseInt, split2[2]);
                    }
                }
            }
        }
    }

    private /* synthetic */ void lambda$installDeferredComponent$0(String str, int i11, Integer num) {
        this.sessionIdToName.put(num.intValue(), str);
        this.sessionIdToLoadingUnitId.put(num.intValue(), i11);
        if (this.nameToSessionId.containsKey(str)) {
            this.sessionIdToState.remove(this.nameToSessionId.get(str).intValue());
        }
        this.nameToSessionId.put(str, num);
        this.sessionIdToState.put(num.intValue(), "Requested");
    }

    private /* synthetic */ void lambda$installDeferredComponent$1(int i11, String str, Exception exc) {
        SplitInstallException splitInstallException = (SplitInstallException) exc;
        int errorCode = splitInstallException.getErrorCode();
        if (errorCode == -6) {
            this.flutterJNI.deferredComponentInstallFailure(i11, String.format("Install of deferred component module \"%s\" failed with a network error", new Object[]{str}), true);
        } else if (errorCode != -2) {
            this.flutterJNI.deferredComponentInstallFailure(i11, String.format("Install of deferred component module \"%s\" failed with error %d: %s", new Object[]{str, Integer.valueOf(splitInstallException.getErrorCode()), splitInstallException.getMessage()}), false);
        } else {
            this.flutterJNI.deferredComponentInstallFailure(i11, String.format("Install of deferred component module \"%s\" failed as it is unavailable", new Object[]{str}), false);
        }
    }

    private boolean verifyJNI() {
        if (this.flutterJNI != null) {
            return true;
        }
        Log.e(TAG, "No FlutterJNI provided. `setJNI` must be called on the DeferredComponentManager before attempting to load dart libraries or invoking with platform channels.");
        return false;
    }

    public void destroy() {
        this.splitInstallManager.unregisterListener(this.listener);
        this.channel = null;
        this.flutterJNI = null;
    }

    @NonNull
    public String getDeferredComponentInstallState(int i11, @Nullable String str) {
        if (str == null) {
            str = this.f14185a.get(i11);
        }
        if (str == null) {
            Log.e(TAG, "Deferred component name was null and could not be resolved from loading unit id.");
            return "unknown";
        } else if (this.nameToSessionId.containsKey(str)) {
            return this.sessionIdToState.get(this.nameToSessionId.get(str).intValue());
        } else if (this.splitInstallManager.getInstalledModules().contains(str)) {
            return "installedPendingLoad";
        } else {
            return "unknown";
        }
    }

    public void installDeferredComponent(int i11, @Nullable String str) {
        String str2;
        if (str != null) {
            str2 = str;
        } else {
            str2 = this.f14185a.get(i11);
        }
        if (str2 == null) {
            Log.e(TAG, "Deferred component name was null and could not be resolved from loading unit id.");
        } else if (!str2.equals("") || i11 <= 0) {
            this.splitInstallManager.startInstall(SplitInstallRequest.newBuilder().addModule(str2).build()).addOnSuccessListener(new a(this, str2, i11)).addOnFailureListener(new b(this, i11, str));
        } else {
            loadDartLibrary(i11, str2);
        }
    }

    public void loadAssets(int i11, @NonNull String str) {
        if (verifyJNI()) {
            try {
                Context context2 = this.context;
                Context createPackageContext = context2.createPackageContext(context2.getPackageName(), 0);
                this.context = createPackageContext;
                this.flutterJNI.updateJavaAssetManager(createPackageContext.getAssets(), this.flutterApplicationInfo.flutterAssetsDir);
            } catch (PackageManager.NameNotFoundException e11) {
                throw new RuntimeException(e11);
            }
        }
    }

    public void loadDartLibrary(int i11, @NonNull String str) {
        if (verifyJNI() && i11 >= 0) {
            String str2 = this.f14186b.get(i11);
            if (str2 == null) {
                str2 = this.flutterApplicationInfo.aotSharedLibraryName + SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE + i11 + ".part.so";
            }
            String str3 = Build.SUPPORTED_ABIS[0];
            String replace = str3.replace(SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE, JavaConstant.Dynamic.DEFAULT_NAME);
            ArrayList<String> arrayList = new ArrayList<>();
            ArrayList<String> arrayList2 = new ArrayList<>();
            LinkedList linkedList = new LinkedList();
            linkedList.add(this.context.getFilesDir());
            for (String file : this.context.getApplicationInfo().splitSourceDirs) {
                linkedList.add(new File(file));
            }
            while (!linkedList.isEmpty()) {
                File file2 = (File) linkedList.remove();
                if (file2 == null || !file2.isDirectory() || file2.listFiles() == null) {
                    String name2 = file2.getName();
                    if (name2.endsWith(".apk") && ((name2.startsWith(str) || name2.startsWith("split_config")) && name2.contains(replace))) {
                        arrayList.add(file2.getAbsolutePath());
                    } else if (name2.equals(str2)) {
                        arrayList2.add(file2.getAbsolutePath());
                    }
                } else {
                    for (File add : file2.listFiles()) {
                        linkedList.add(add);
                    }
                }
            }
            ArrayList arrayList3 = new ArrayList();
            arrayList3.add(str2);
            for (String str4 : arrayList) {
                arrayList3.add(str4 + "!lib/" + str3 + "/" + str2);
            }
            for (String add2 : arrayList2) {
                arrayList3.add(add2);
            }
            this.flutterJNI.loadDartDeferredLibrary(i11, (String[]) arrayList3.toArray(new String[arrayList3.size()]));
        }
    }

    public void setDeferredComponentChannel(@NonNull DeferredComponentChannel deferredComponentChannel) {
        this.channel = deferredComponentChannel;
    }

    public void setJNI(@NonNull FlutterJNI flutterJNI2) {
        this.flutterJNI = flutterJNI2;
    }

    public boolean uninstallDeferredComponent(int i11, @Nullable String str) {
        if (str == null) {
            str = this.f14185a.get(i11);
        }
        if (str == null) {
            Log.e(TAG, "Deferred component name was null and could not be resolved from loading unit id.");
            return false;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        this.splitInstallManager.deferredUninstall(arrayList);
        if (this.nameToSessionId.get(str) == null) {
            return true;
        }
        this.sessionIdToState.delete(this.nameToSessionId.get(str).intValue());
        return true;
    }
}
