package fwfd.com.fwfsdk.manager;

import android.content.Context;
import androidx.annotation.Nullable;
import fwfd.com.fwfsdk.FunWithFlags;
import fwfd.com.fwfsdk.constant.FWFConstants;
import fwfd.com.fwfsdk.manager.callback.FWFFeatureCallback;
import fwfd.com.fwfsdk.manager.callback.FWFFeaturesCallback;
import fwfd.com.fwfsdk.manager.callback.FWFFlagKeysCallback;
import fwfd.com.fwfsdk.model.api.FWFPut;
import fwfd.com.fwfsdk.model.api.FWFSubscribeObservable;
import fwfd.com.fwfsdk.model.api.FWFSubscribeResult;
import fwfd.com.fwfsdk.model.api.FlagKey;
import fwfd.com.fwfsdk.model.api.FlagKeysContainer;
import fwfd.com.fwfsdk.model.dao.FWFAPIDAO;
import fwfd.com.fwfsdk.model.dao.FWFDBRepository;
import fwfd.com.fwfsdk.model.db.FWFFallback;
import fwfd.com.fwfsdk.model.db.FWFFeature;
import fwfd.com.fwfsdk.model.db.FWFFlagId;
import fwfd.com.fwfsdk.model.db.FWFFlagKey;
import fwfd.com.fwfsdk.model.db.FWFResult;
import fwfd.com.fwfsdk.model.db.FWFSDKInfo;
import fwfd.com.fwfsdk.util.FWFDBCallback;
import fwfd.com.fwfsdk.util.FWFHelper;
import fwfd.com.fwfsdk.util.FWFLogger;
import fwfd.com.fwfsdk.util.FWFResultCallback;
import fwfd.com.fwfsdk.util.FWFSubscribeObserverCallback;
import fwfd.com.fwfsdk.util.FWFTrackingCallback;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FWFDataManager {
    private static FWFDataManager instance;
    private static final FWFSubscribeObservable observable = new FWFSubscribeObservable();

    /* access modifiers changed from: private */
    public String buildExperimentsResult(List<FWFFeature> list) {
        String str;
        StringBuilder stringForTracking = getStringForTracking(list);
        Object[] objArr = new Object[1];
        if (stringForTracking.length() == 0) {
            str = "";
        } else {
            str = stringForTracking.substring(0, stringForTracking.length() - 1);
        }
        objArr[0] = str;
        return String.format("eventAbTestCampaigns: \"%s\"", objArr);
    }

    /* access modifiers changed from: private */
    public List<FlagKey> buildFlagKeys(List<FWFFlagKey> list) {
        ArrayList arrayList = new ArrayList();
        for (FWFFlagKey flagKey : list) {
            arrayList.add(flagKey.toFlagKey());
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public HashMap<String, FWFResult> buildFlagsResult(List<FWFFeature> list) {
        HashMap<String, FWFResult> hashMap = new HashMap<>();
        for (FWFFeature next : list) {
            hashMap.put(next.getKey(), next.toFWFResult());
        }
        return hashMap;
    }

    /* access modifiers changed from: private */
    public String buildFlagsToTrackResult(List<FWFFeature> list) {
        String str;
        StringBuilder stringForTracking = getStringForTracking(list);
        Object[] objArr = new Object[1];
        if (stringForTracking.length() == 0) {
            str = "";
        } else {
            str = stringForTracking.substring(0, stringForTracking.length() - 1);
        }
        objArr[0] = str;
        return String.format("eventFwfFeatures: \"%s\"", objArr);
    }

    private void createFWFResultForObserver(String str, String str2, FWFResult fWFResult, FWFSubscribeResult.FWFSubscribeCallbackExplanation fWFSubscribeCallbackExplanation) {
        observable.notify(str, new FWFSubscribeResult(str2, fWFResult, fWFSubscribeCallbackExplanation));
    }

    /* access modifiers changed from: private */
    public void deleteAllFlagRecords(Context context) {
        new FWFDBRepository(context).deleteAllFlagRecords();
    }

    /* access modifiers changed from: private */
    public void deleteAllFlagsFromEnvironment(Context context, String str) {
        new FWFDBRepository(context).deleteAllFlagsFromEnvironment(str);
    }

    private void getAllFlagsByRelevantContext(Context context, String str, final FWFDBCallback<List<FWFFlagId>> fWFDBCallback) {
        new FWFDBRepository(context).getAllFlagKeysByRelevantContext(str, (FWFResultCallback<List<FWFFlagId>>) new FWFResultCallback<List<FWFFlagId>>() {
            public void onError(String str) {
                fWFDBCallback.onResponse(new ArrayList());
            }

            public void onResponse(List<FWFFlagId> list) {
                fWFDBCallback.onResponse(list);
            }
        });
    }

    private void getFlagById(Context context, String str, String str2, final FWFDBCallback<FWFFeature> fWFDBCallback) {
        new FWFDBRepository(context).getFlagById(str, str2, new FWFResultCallback<FWFFeature>() {
            public void onError(String str) {
                fWFDBCallback.onResponse(null);
            }

            public void onResponse(FWFFeature fWFFeature) {
                fWFDBCallback.onResponse(fWFFeature);
            }
        });
    }

    /* access modifiers changed from: private */
    public void getFlagKeysFromAPI(final String str, final FWFFlagKeysCallback fWFFlagKeysCallback, final Context context) {
        new FWFAPIDAO(FWFHelper.FROM_METHOD_GET_FLAG_KEYS).getFWFFlagKeys(str, new FWFResultCallback<FlagKeysContainer>() {
            public void onError(String str) {
                FWFLogger.logError(str);
                FWFDataManager.this.getFlagKeysFromDB(context, str, new FWFDBCallback<List<FWFFlagKey>>() {
                    public void onResponse(List<FWFFlagKey> list) {
                        AnonymousClass21 r02 = AnonymousClass21.this;
                        fWFFlagKeysCallback.onResponse(new FlagKeysContainer(FWFDataManager.this.buildFlagKeys(list)));
                    }
                });
            }

            public void onResponse(FlagKeysContainer flagKeysContainer) {
                if (FunWithFlags.getInstance().getFlagKeysExpirationTime() != null) {
                    FWFDataManager.this.saveFlagKeys(flagKeysContainer.getFlagKeys(), str, context);
                }
                fWFFlagKeysCallback.onResponse(flagKeysContainer);
            }
        });
    }

    /* access modifiers changed from: private */
    public void getFlagKeysFromDB(Context context, String str, final FWFDBCallback<List<FWFFlagKey>> fWFDBCallback) {
        new FWFDBRepository(context).getFlagKeys(str, new FWFResultCallback<List<FWFFlagKey>>() {
            public void onError(String str) {
                fWFDBCallback.onResponse(new ArrayList());
            }

            public void onResponse(List<FWFFlagKey> list) {
                fWFDBCallback.onResponse(list);
            }
        });
    }

    /* access modifiers changed from: private */
    public List<String> getFlagKeysFromResult(List<FWFFeature> list) {
        ArrayList arrayList = new ArrayList();
        for (FWFFeature key : list) {
            arrayList.add(key.getKey());
        }
        return arrayList;
    }

    private void getFlagsById(Context context, List<String> list, String str, final FWFDBCallback<List<FWFFeature>> fWFDBCallback) {
        new FWFDBRepository(context).getFlagsById(list, str, new FWFResultCallback<List<FWFFeature>>() {
            public void onError(String str) {
                fWFDBCallback.onResponse(new ArrayList());
            }

            public void onResponse(List<FWFFeature> list) {
                fWFDBCallback.onResponse(list);
            }
        });
    }

    /* access modifiers changed from: private */
    public void getFlagsFromAPI(final Context context, final String str, final FWFFeaturesCallback fWFFeaturesCallback) {
        new FWFAPIDAO(FWFHelper.FROM_METHOD_GET_ALL_FLAGS).getFWFFeatures(str, new FWFResultCallback<LinkedHashMap<String, FWFPut>>() {
            public void onError(String str) {
                fWFFeaturesCallback.onFwfResponse(new HashMap());
                FWFLogger.logError(str);
            }

            public void onResponse(LinkedHashMap<String, FWFPut> linkedHashMap) {
                HashMap hashMap = new HashMap();
                ArrayList arrayList = new ArrayList();
                for (Map.Entry next : linkedHashMap.entrySet()) {
                    FWFFeature fWFFeature = new FWFFeature((String) next.getKey(), (FWFPut) next.getValue(), 1, str);
                    if (fWFFeature.getVariation() != null) {
                        arrayList.add(fWFFeature);
                        hashMap.put(fWFFeature.getKey(), new FWFResult(fWFFeature.getVariation(), fWFFeature.getAbTest(), fWFFeature.getExplanation(), fWFFeature.getTrackInfo(), fWFFeature.getHoldoutsEvaluations()));
                    }
                }
                FWFDataManager.this.deleteAllFlagsFromEnvironment(context, str);
                FWFDataManager.this.insertFlagsInDB(context, arrayList);
                fWFFeaturesCallback.onFwfResponse(hashMap);
            }
        });
    }

    /* access modifiers changed from: private */
    public void getFlagsFromDB(Context context, String str, final FWFDBCallback<List<FWFFeature>> fWFDBCallback) {
        new FWFDBRepository(context).getAllFlagsFromEnvironment(str, new FWFResultCallback<List<FWFFeature>>() {
            public void onError(String str) {
                fWFDBCallback.onResponse(new ArrayList());
            }

            public void onResponse(List<FWFFeature> list) {
                fWFDBCallback.onResponse(list);
            }
        });
    }

    public static FWFDataManager getInstance() {
        if (instance == null) {
            instance = new FWFDataManager();
        }
        return instance;
    }

    private void getLastSDKInfo(Context context, final FWFDBCallback<FWFSDKInfo> fWFDBCallback) {
        new FWFDBRepository(context).getLastSDKInfo(new FWFResultCallback<FWFSDKInfo>() {
            public void onError(String str) {
                fWFDBCallback.onResponse(null);
            }

            public void onResponse(FWFSDKInfo fWFSDKInfo) {
                fWFDBCallback.onResponse(fWFSDKInfo);
            }
        });
    }

    private StringBuilder getStringForTracking(List<FWFFeature> list) {
        StringBuilder sb2 = new StringBuilder();
        for (FWFFeature next : list) {
            Object variation = next.getVariation();
            String key = next.getKey();
            if (!(variation == null || key == null)) {
                sb2.append(String.format("%s:%s,", new Object[]{key, variation.toString()}));
            }
        }
        return sb2;
    }

    private void getSubscribedFlagsFromDB(Context context, final FWFDBCallback<List<FWFFlagId>> fWFDBCallback) {
        new FWFDBRepository(context).getSubscribedFlagIds(new FWFResultCallback<List<FWFFlagId>>() {
            public void onError(String str) {
                fWFDBCallback.onResponse(null);
                FWFLogger.logError(str);
            }

            public void onResponse(List<FWFFlagId> list) {
                fWFDBCallback.onResponse(list);
            }
        });
    }

    private void getSubscribedFromAPI(String[] strArr, final String str, String str2, @Nullable final FWFFeaturesCallback fWFFeaturesCallback) {
        final Context context = FunWithFlags.getInstance().getContext();
        new FWFAPIDAO(str2).getFWFFeatures(strArr, str, new FWFResultCallback<LinkedHashMap<String, FWFPut>>() {
            public void onError(String str) {
                FWFLogger.logError("FunWithFlags: Error updating subscribed features." + str);
                FWFFeaturesCallback fWFFeaturesCallback = fWFFeaturesCallback;
                if (fWFFeaturesCallback != null) {
                    fWFFeaturesCallback.onFwfResponse(new HashMap());
                }
            }

            public void onResponse(LinkedHashMap<String, FWFPut> linkedHashMap) {
                HashMap hashMap = new HashMap();
                ArrayList arrayList = new ArrayList();
                for (Map.Entry next : linkedHashMap.entrySet()) {
                    if (!(next.getValue() == null || ((FWFPut) next.getValue()).getVariation() == null)) {
                        FWFFeature fWFFeature = new FWFFeature((String) next.getKey(), (FWFPut) next.getValue(), 1, str);
                        arrayList.add(fWFFeature);
                        hashMap.put(fWFFeature.getKey(), new FWFResult(fWFFeature.getVariation(), fWFFeature.getAbTest(), fWFFeature.getExplanation(), fWFFeature.getTrackInfo(), fWFFeature.getHoldoutsEvaluations()));
                    }
                }
                FWFDataManager.this.insertFlagsInDB(context, arrayList);
                FWFDataManager.this.notifyObserver(hashMap, str, FWFSubscribeResult.FWFSubscribeCallbackExplanation.BACKGROUND_UPDATE);
                FWFFeaturesCallback fWFFeaturesCallback = fWFFeaturesCallback;
                if (fWFFeaturesCallback != null) {
                    fWFFeaturesCallback.onFwfResponse(hashMap);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void insertFlagCheckingSubscribe(Context context, FWFFeature fWFFeature) {
        new FWFDBRepository(context).insertFlagCheckingSubscribe(fWFFeature);
    }

    /* access modifiers changed from: private */
    public void insertFlagInDB(Context context, FWFFeature fWFFeature) {
        new FWFDBRepository(context).insertFlag(fWFFeature);
    }

    /* access modifiers changed from: private */
    public void insertFlagsInDB(Context context, List<FWFFeature> list) {
        new FWFDBRepository(context).insertFlags(list);
    }

    /* access modifiers changed from: private */
    public void insertSDKInfo(Context context, FWFSDKInfo fWFSDKInfo) {
        new FWFDBRepository(context).insertSDKInfo(fWFSDKInfo);
    }

    private void isValidExpirationForFlags(Context context, String str, final FWFDBCallback<Boolean> fWFDBCallback) {
        new FWFDBRepository(context).getOldestUpdatedFlagFromEnvironment(str, new FWFResultCallback<Boolean>() {
            public void onError(String str) {
                fWFDBCallback.onResponse(Boolean.FALSE);
            }

            public void onResponse(Boolean bool) {
                fWFDBCallback.onResponse(bool);
            }
        });
    }

    /* access modifiers changed from: private */
    public void notifyObserver(String str, String str2, FWFResult fWFResult, FWFSubscribeResult.FWFSubscribeCallbackExplanation fWFSubscribeCallbackExplanation) {
        createFWFResultForObserver(str2, str, fWFResult, fWFSubscribeCallbackExplanation);
    }

    /* access modifiers changed from: private */
    public void saveFlagKeys(List<FlagKey> list, String str, Context context) {
        ArrayList arrayList = new ArrayList();
        for (FlagKey fWFFlagKey : list) {
            arrayList.add(fWFFlagKey.toFWFFlagKey(str));
        }
        new FWFDBRepository(context).deleteAndInsertNewFlagKeys(arrayList, str);
    }

    /* access modifiers changed from: private */
    public void updateSubscribedFlagsFromAPI(List<FWFFlagId> list, String str) {
        if (list != null && !list.isEmpty()) {
            HashMap hashMap = new HashMap();
            for (FWFFlagId next : list) {
                if (!(next == null || next.getAccessToken() == null)) {
                    if (next.requiresUpdate().booleanValue() || str.equals(FWFHelper.FROM_METHOD_RELEVANT_CONTEXT)) {
                        List list2 = (List) hashMap.get(next.getAccessToken());
                        if (list2 != null) {
                            list2.add(next.getKey());
                            hashMap.put(next.getAccessToken(), list2);
                        } else {
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(next.getKey());
                            hashMap.put(next.getAccessToken(), arrayList);
                        }
                    }
                }
            }
            for (Map.Entry entry : hashMap.entrySet()) {
                List list3 = (List) entry.getValue();
                if (list3.size() > 1) {
                    getSubscribedFromAPI((String[]) list3.toArray(new String[0]), (String) entry.getKey(), str, (FWFFeaturesCallback) null);
                } else if (!list3.isEmpty()) {
                    getSubscribedFromAPI((String) list3.get(0), (String) entry.getKey(), str);
                }
            }
        }
    }

    public void addObserver(@Nullable String str, FWFSubscribeObserverCallback fWFSubscribeObserverCallback) {
        observable.addObserver(new FWFSubscribeObservable.FWFSubscribeResultObserver(fWFSubscribeObserverCallback, str));
    }

    public void cleanDBOnVersionUpdate() {
        final Context context = FunWithFlags.getInstance().getContext();
        getLastSDKInfo(context, new FWFDBCallback<FWFSDKInfo>() {
            public void onResponse(FWFSDKInfo fWFSDKInfo) {
                if (fWFSDKInfo == null || (fWFSDKInfo.getVersionNumber().intValue() < FWFConstants.SDK_VERSION_NUMBER.intValue() && !fWFSDKInfo.getSdkVersion().equals(FWFConstants.SDK_VERSION))) {
                    FWFDataManager.this.insertSDKInfo(context, new FWFSDKInfo(FWFConstants.SDK_VERSION, FWFConstants.SDK_VERSION_NUMBER));
                    FWFDataManager.this.deleteAllFlagRecords(context);
                    FWFLogger.logInfo(FWFHelper.SDK_UPDATED);
                    return;
                }
                FWFLogger.logInfo(FWFHelper.SDK_NO_NEW_VERSION);
            }
        });
    }

    public void deleteAllFlags() {
        new FWFDBRepository(FunWithFlags.getInstance().getContext()).deleteAllFlagRecords();
    }

    public void getAllExperiments(Context context, final FWFTrackingCallback fWFTrackingCallback) {
        new FWFDBRepository(context).getAllExperiments(new FWFResultCallback<List<FWFFeature>>() {
            public void onError(String str) {
                fWFTrackingCallback.onResponse(FWFDataManager.this.buildExperimentsResult(new ArrayList()));
            }

            public void onResponse(List<FWFFeature> list) {
                fWFTrackingCallback.onResponse(FWFDataManager.this.buildExperimentsResult(list));
            }
        });
    }

    public void getFlagKeys(final String str, final FWFFlagKeysCallback fWFFlagKeysCallback) {
        final Context context = FunWithFlags.getInstance().getContext();
        if (context == null || FunWithFlags.getInstance().getFlagKeysExpirationTime() == null) {
            getFlagKeysFromAPI(str, fWFFlagKeysCallback, context);
        } else {
            getFlagKeysFromDB(context, str, new FWFDBCallback<List<FWFFlagKey>>() {
                public void onResponse(List<FWFFlagKey> list) {
                    if (list.isEmpty()) {
                        FWFDataManager.this.getFlagKeysFromAPI(str, fWFFlagKeysCallback, context);
                    } else if (list.get(0).isValid().booleanValue()) {
                        fWFFlagKeysCallback.onResponse(new FlagKeysContainer(FWFDataManager.this.buildFlagKeys(list)));
                    } else {
                        FWFDataManager.this.getFlagKeysFromAPI(str, fWFFlagKeysCallback, context);
                    }
                }
            });
        }
    }

    public void getFlags(final String str, Boolean bool, final FWFFeaturesCallback fWFFeaturesCallback) {
        final Context context = FunWithFlags.getInstance().getContext();
        if (bool.booleanValue()) {
            getFlagsFromAPI(context, str, fWFFeaturesCallback);
        } else {
            isValidExpirationForFlags(context, str, new FWFDBCallback<Boolean>() {
                public void onResponse(Boolean bool) {
                    if (!bool.booleanValue()) {
                        FWFDataManager.this.getFlagsFromAPI(context, str, fWFFeaturesCallback);
                    } else {
                        FWFDataManager.this.getFlagsFromDB(context, str, new FWFDBCallback<List<FWFFeature>>() {
                            public void onResponse(List<FWFFeature> list) {
                                if (list.isEmpty()) {
                                    AnonymousClass23 r11 = AnonymousClass23.this;
                                    FWFDataManager.this.getFlagsFromAPI(context, str, fWFFeaturesCallback);
                                    return;
                                }
                                HashMap hashMap = new HashMap();
                                for (FWFFeature next : list) {
                                    if (next.getVariation() != null) {
                                        hashMap.put(next.getKey(), new FWFResult(next.getVariation(), next.getAbTest(), next.getExplanation(), next.getTrackInfo(), next.getHoldoutsEvaluations()));
                                    }
                                }
                                fWFFeaturesCallback.onFwfResponse(hashMap);
                            }
                        });
                    }
                }
            });
        }
    }

    public void getFlagsToTrack(Context context, final FWFTrackingCallback fWFTrackingCallback) {
        new FWFDBRepository(context).getAllFlags(new FWFResultCallback<List<FWFFeature>>() {
            public void onError(String str) {
                fWFTrackingCallback.onResponse(FWFDataManager.this.buildExperimentsResult(new ArrayList()));
            }

            public void onResponse(List<FWFFeature> list) {
                fWFTrackingCallback.onResponse(FWFDataManager.this.buildFlagsToTrackResult(list));
            }
        });
    }

    public FWFSubscribeObservable getObservable() {
        return observable;
    }

    public void getVariationFromApi(String str, String str2, FWFFallback fWFFallback, FWFSubscribeResult.FWFSubscribeCallbackExplanation fWFSubscribeCallbackExplanation, boolean z11, FWFFeatureCallback fWFFeatureCallback) {
        final Context context = FunWithFlags.getInstance().getContext();
        final String str3 = str;
        final String str4 = str2;
        final FWFFeatureCallback fWFFeatureCallback2 = fWFFeatureCallback;
        final FWFSubscribeResult.FWFSubscribeCallbackExplanation fWFSubscribeCallbackExplanation2 = fWFSubscribeCallbackExplanation;
        final FWFFallback fWFFallback2 = fWFFallback;
        new FWFAPIDAO(FWFHelper.getVariationFromMethod(z11)).getFWFFeature(str, str2, new FWFResultCallback<FWFPut>() {
            public void onError(String str) {
                FWFFallbackManager.createFWFResultFallback(context, str3, str4, fWFFallback2, str, fWFFeatureCallback2);
            }

            public void onResponse(FWFPut fWFPut) {
                if (fWFPut == null || fWFPut.getVariation() == null) {
                    FWFFallbackManager.createFWFResultFallback(context, str3, str4, fWFFallback2, "ERROR IN FLAG", fWFFeatureCallback2);
                    return;
                }
                FWFFeature fWFFeature = new FWFFeature(str3, fWFPut, str4);
                FWFResult fWFResult = fWFFeature.toFWFResult();
                fWFFeatureCallback2.onFwfResponse(fWFResult);
                FWFDataManager.this.notifyObserver(str3, str4, fWFResult, fWFSubscribeCallbackExplanation2);
                FWFDataManager.this.insertFlagCheckingSubscribe(context, fWFFeature);
            }
        });
    }

    public void getVariationFromDB(String str, String str2, FWFFallback fWFFallback, FWFSubscribeResult.FWFSubscribeCallbackExplanation fWFSubscribeCallbackExplanation, FWFFeatureCallback fWFFeatureCallback) {
        final FWFFeatureCallback fWFFeatureCallback2 = fWFFeatureCallback;
        final String str3 = str;
        final String str4 = str2;
        final FWFFallback fWFFallback2 = fWFFallback;
        final FWFSubscribeResult.FWFSubscribeCallbackExplanation fWFSubscribeCallbackExplanation2 = fWFSubscribeCallbackExplanation;
        getFlagById(FunWithFlags.getInstance().getContext(), str, str2, new FWFDBCallback<FWFFeature>() {
            public void onResponse(FWFFeature fWFFeature) {
                if (fWFFeature == null || fWFFeature.getVariation() == null || fWFFeature.requiresUpdate()) {
                    FWFDataManager.this.getVariationFromApi(str3, str4, fWFFallback2, fWFSubscribeCallbackExplanation2, false, fWFFeatureCallback2);
                } else {
                    fWFFeatureCallback2.onFwfResponse(fWFFeature.toFWFResult());
                }
            }
        });
    }

    public void getVariationsFromAPI(HashMap<String, FWFFallback> hashMap, String str, FWFSubscribeResult.FWFSubscribeCallbackExplanation fWFSubscribeCallbackExplanation, boolean z11, final FWFFeaturesCallback fWFFeaturesCallback) {
        final Context context = FunWithFlags.getInstance().getContext();
        final String[] strArr = (String[]) hashMap.keySet().toArray(new String[0]);
        if (strArr.length > 1) {
            final String str2 = str;
            final HashMap<String, FWFFallback> hashMap2 = hashMap;
            final FWFSubscribeResult.FWFSubscribeCallbackExplanation fWFSubscribeCallbackExplanation2 = fWFSubscribeCallbackExplanation;
            final FWFFeaturesCallback fWFFeaturesCallback2 = fWFFeaturesCallback;
            new FWFAPIDAO(FWFHelper.getVariationsFromMethod(z11)).getFWFFeatures(strArr, str, new FWFResultCallback<LinkedHashMap<String, FWFPut>>() {
                public void onError(String str) {
                    FWFLogger.logError(str);
                    FWFFallbackManager.createFWFResultsFallback(context, hashMap2, str2, str, fWFFeaturesCallback2);
                }

                public void onResponse(LinkedHashMap<String, FWFPut> linkedHashMap) {
                    final HashMap hashMap = new HashMap();
                    HashMap hashMap2 = new HashMap();
                    for (Map.Entry next : linkedHashMap.entrySet()) {
                        FWFFeature fWFFeature = new FWFFeature((String) next.getKey(), (FWFPut) next.getValue(), str2);
                        if (fWFFeature.getVariation() != null) {
                            FWFDataManager.this.insertFlagCheckingSubscribe(context, fWFFeature);
                            hashMap.put(fWFFeature.getKey(), new FWFResult(fWFFeature.getVariation(), fWFFeature.getAbTest(), fWFFeature.getExplanation(), fWFFeature.getTrackInfo(), fWFFeature.getHoldoutsEvaluations()));
                        } else {
                            hashMap2.put((String) next.getKey(), (FWFFallback) hashMap2.get(next.getKey()));
                        }
                    }
                    if (hashMap2.isEmpty()) {
                        FWFDataManager.this.notifyObserver(hashMap, str2, fWFSubscribeCallbackExplanation2);
                        fWFFeaturesCallback2.onFwfResponse(hashMap);
                        return;
                    }
                    FWFFallbackManager.createFWFResultsFallback(context, hashMap2, str2, "ERROR IN FLAG", new FWFFeaturesCallback() {
                        public void onFwfResponse(HashMap<String, FWFResult> hashMap) {
                            hashMap.putAll(hashMap);
                            fWFFeaturesCallback2.onFwfResponse(hashMap);
                            AnonymousClass5 r42 = AnonymousClass5.this;
                            FWFDataManager.this.notifyObserver(hashMap, str2, fWFSubscribeCallbackExplanation2);
                        }
                    });
                }
            });
        } else if (strArr.length == 1) {
            getVariationFromApi(strArr[0], str, hashMap.get(strArr[0]), fWFSubscribeCallbackExplanation, z11, new FWFFeatureCallback() {
                public void onFwfResponse(FWFResult fWFResult) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(strArr[0], fWFResult);
                    fWFFeaturesCallback.onFwfResponse(hashMap);
                }
            });
        } else {
            FWFLogger.logWarning(FWFHelper.FLAG_REQUEST_EMPTY);
            fWFFeaturesCallback.onFwfResponse(new HashMap());
        }
    }

    public void getVariationsFromDB(HashMap<String, FWFFallback> hashMap, String str, FWFSubscribeResult.FWFSubscribeCallbackExplanation fWFSubscribeCallbackExplanation, FWFFeaturesCallback fWFFeaturesCallback) {
        final HashMap<String, FWFFallback> hashMap2 = hashMap;
        final String str2 = str;
        final FWFSubscribeResult.FWFSubscribeCallbackExplanation fWFSubscribeCallbackExplanation2 = fWFSubscribeCallbackExplanation;
        final FWFFeaturesCallback fWFFeaturesCallback2 = fWFFeaturesCallback;
        getFlagsById(FunWithFlags.getInstance().getContext(), new ArrayList(hashMap.keySet()), str, new FWFDBCallback<List<FWFFeature>>() {
            public void onResponse(final List<FWFFeature> list) {
                if (list == null || list.isEmpty()) {
                    FWFDataManager.this.getVariationsFromAPI(hashMap2, str2, fWFSubscribeCallbackExplanation2, false, fWFFeaturesCallback2);
                    return;
                }
                HashMap hashMap = new HashMap();
                for (FWFFeature next : list) {
                    if (next.requiresUpdate()) {
                        hashMap.put(next.getKey(), (FWFFallback) hashMap2.get(next.getKey()));
                    }
                }
                List access$200 = FWFDataManager.this.getFlagKeysFromResult(list);
                for (Map.Entry entry : hashMap2.entrySet()) {
                    if (!access$200.contains(entry.getKey())) {
                        hashMap.put((String) entry.getKey(), (FWFFallback) entry.getValue());
                    }
                }
                if (!hashMap.isEmpty()) {
                    FWFDataManager.this.getVariationsFromAPI(hashMap, str2, fWFSubscribeCallbackExplanation2, false, new FWFFeaturesCallback() {
                        public void onFwfResponse(HashMap<String, FWFResult> hashMap) {
                            HashMap access$300 = FWFDataManager.this.buildFlagsResult(list);
                            access$300.putAll(hashMap);
                            fWFFeaturesCallback2.onFwfResponse(access$300);
                        }
                    });
                } else {
                    fWFFeaturesCallback2.onFwfResponse(FWFDataManager.this.buildFlagsResult(list));
                }
            }
        });
    }

    public void subscribeFeatures(String[] strArr, String str) {
        if (strArr.length > 0) {
            getSubscribedFromAPI(strArr, str, FWFHelper.FROM_METHOD_SUBSCRIBE_INIT, (FWFFeaturesCallback) null);
        }
    }

    public void updateFlagsWithRelevantContext(String str) {
        getAllFlagsByRelevantContext(FunWithFlags.getInstance().getContext(), str, (FWFDBCallback<List<FWFFlagId>>) new FWFDBCallback<List<FWFFlagId>>() {
            public void onResponse(List<FWFFlagId> list) {
                FWFDataManager.this.updateSubscribedFlagsFromAPI(list, FWFHelper.FROM_METHOD_RELEVANT_CONTEXT);
            }
        });
    }

    public void updateSubscribedFeatures() {
        getSubscribedFlagsFromDB(FunWithFlags.getInstance().getContext(), new FWFDBCallback<List<FWFFlagId>>() {
            public void onResponse(List<FWFFlagId> list) {
                FWFDataManager.this.updateSubscribedFlagsFromAPI(list, FWFHelper.FROM_METHOD_SUBSCRIBE_UPDATE);
            }
        });
    }

    private void getAllFlagsByRelevantContext(Context context, List<String> list, final FWFDBCallback<List<FWFFlagId>> fWFDBCallback) {
        new FWFDBRepository(context).getAllFlagKeysByRelevantContext(list, (FWFResultCallback<Set<FWFFlagId>>) new FWFResultCallback<Set<FWFFlagId>>() {
            public void onError(String str) {
                fWFDBCallback.onResponse(new ArrayList());
            }

            public void onResponse(Set<FWFFlagId> set) {
                fWFDBCallback.onResponse(new ArrayList(set));
            }
        });
    }

    /* access modifiers changed from: private */
    public void notifyObserver(HashMap<String, FWFResult> hashMap, String str, FWFSubscribeResult.FWFSubscribeCallbackExplanation fWFSubscribeCallbackExplanation) {
        observable.notify(str, new FWFSubscribeResult(hashMap, fWFSubscribeCallbackExplanation));
    }

    public void subscribeFeatures(String[] strArr, String str, FWFFeaturesCallback fWFFeaturesCallback) {
        if (strArr.length > 0) {
            getSubscribedFromAPI(strArr, str, FWFHelper.FROM_METHOD_SUBSCRIBE_INIT, fWFFeaturesCallback);
        }
    }

    public void updateFlagsWithRelevantContext(List<String> list) {
        getAllFlagsByRelevantContext(FunWithFlags.getInstance().getContext(), list, (FWFDBCallback<List<FWFFlagId>>) new FWFDBCallback<List<FWFFlagId>>() {
            public void onResponse(List<FWFFlagId> list) {
                FWFDataManager.this.updateSubscribedFlagsFromAPI(list, FWFHelper.FROM_METHOD_RELEVANT_CONTEXT);
            }
        });
    }

    private void getSubscribedFromAPI(final String str, final String str2, String str3) {
        final Context context = FunWithFlags.getInstance().getContext();
        new FWFAPIDAO(str3).getFWFFeature(str, str2, new FWFResultCallback<FWFPut>() {
            public void onError(String str) {
                FWFLogger.logError("FunWithFlags: Error updating subscribed feature." + str);
            }

            public void onResponse(FWFPut fWFPut) {
                if (fWFPut != null && fWFPut.getVariation() != null) {
                    FWFFeature fWFFeature = new FWFFeature(str, fWFPut, 1, str2);
                    FWFDataManager.this.insertFlagInDB(context, fWFFeature);
                    FWFDataManager.this.notifyObserver(str, str2, new FWFResult(fWFFeature.getVariation(), fWFFeature.getAbTest(), fWFFeature.getExplanation(), fWFFeature.getTrackInfo(), fWFFeature.getHoldoutsEvaluations()), FWFSubscribeResult.FWFSubscribeCallbackExplanation.BACKGROUND_UPDATE);
                }
            }
        });
    }
}
