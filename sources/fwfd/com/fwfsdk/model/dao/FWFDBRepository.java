package fwfd.com.fwfsdk.model.dao;

import android.content.Context;
import fwfd.com.fwfsdk.model.db.FWFFeature;
import fwfd.com.fwfsdk.model.db.FWFFlagId;
import fwfd.com.fwfsdk.model.db.FWFFlagKey;
import fwfd.com.fwfsdk.model.db.FWFSDKInfo;
import fwfd.com.fwfsdk.util.FWFDBRoom;
import fwfd.com.fwfsdk.util.FWFResultCallback;
import fwfd.com.fwfsdk.util.GenericAsyncTask;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FWFDBRepository {
    /* access modifiers changed from: private */
    public static final Integer SELECT_LIMIT = 998;
    /* access modifiers changed from: private */
    public FWFDBDAO dao;

    public FWFDBRepository(Context context) {
        this.dao = FWFDBRoom.getDatabase(context).dao();
    }

    public void deleteAllFlagRecords() {
        new GenericAsyncTask<Void>((GenericAsyncTask.GenericAsyncTaskCallback) null) {
            public Void doAsync() {
                FWFDBRepository.this.dao.deleteAllFlagRecords();
                return null;
            }
        }.start();
    }

    public void deleteAllFlagsFromEnvironment(final String str) {
        new GenericAsyncTask<Void>((GenericAsyncTask.GenericAsyncTaskCallback) null) {
            public Void doAsync() {
                FWFDBRepository.this.dao.deleteAllFlagsFromEnvironment(str);
                return null;
            }
        }.start();
    }

    public void deleteAndInsertNewFlagKeys(final List<FWFFlagKey> list, final String str) {
        new GenericAsyncTask<Void>((GenericAsyncTask.GenericAsyncTaskCallback) null) {
            public Void doAsync() {
                FWFDBRepository.this.dao.deleteAndInsertNewFlagKeys(list, str);
                return null;
            }
        }.start();
    }

    public void getAllExperiments(final FWFResultCallback<List<FWFFeature>> fWFResultCallback) {
        new GenericAsyncTask<List<FWFFeature>>(new GenericAsyncTask.GenericAsyncTaskCallback<List<FWFFeature>>() {
            public void onResult(List<FWFFeature> list) {
                if (list != null) {
                    fWFResultCallback.onResponse(list);
                } else {
                    fWFResultCallback.onError("FunWithFlags: DB Error");
                }
            }
        }) {
            public List<FWFFeature> doAsync() {
                return FWFDBRepository.this.dao.getAllExperiments();
            }
        }.start();
    }

    public void getAllFlagKeysByRelevantContext(final String str, final FWFResultCallback<List<FWFFlagId>> fWFResultCallback) {
        new GenericAsyncTask<List<FWFFlagId>>(new GenericAsyncTask.GenericAsyncTaskCallback<List<FWFFlagId>>() {
            public void onResult(List<FWFFlagId> list) {
                if (list != null) {
                    fWFResultCallback.onResponse(list);
                } else {
                    fWFResultCallback.onError("FunWithFlags: DB Error");
                }
            }
        }) {
            public List<FWFFlagId> doAsync() {
                FWFDBDAO access$000 = FWFDBRepository.this.dao;
                return access$000.getAllFlagKeysByRelevantContext("%" + str + "%");
            }
        }.start();
    }

    public void getAllFlags(final FWFResultCallback<List<FWFFeature>> fWFResultCallback) {
        new GenericAsyncTask<List<FWFFeature>>(new GenericAsyncTask.GenericAsyncTaskCallback<List<FWFFeature>>() {
            public void onResult(List<FWFFeature> list) {
                if (list != null) {
                    fWFResultCallback.onResponse(list);
                } else {
                    fWFResultCallback.onError("FunWithFlags: DB Error");
                }
            }
        }) {
            public List<FWFFeature> doAsync() {
                return FWFDBRepository.this.dao.getAllFlags();
            }
        }.start();
    }

    public void getAllFlagsFromEnvironment(final String str, final FWFResultCallback<List<FWFFeature>> fWFResultCallback) {
        new GenericAsyncTask<List<FWFFeature>>(new GenericAsyncTask.GenericAsyncTaskCallback<List<FWFFeature>>() {
            public void onResult(List<FWFFeature> list) {
                if (list != null) {
                    fWFResultCallback.onResponse(list);
                } else {
                    fWFResultCallback.onError("FunWithFlags: DB Error");
                }
            }
        }) {
            public List<FWFFeature> doAsync() {
                return FWFDBRepository.this.dao.getAllFlagsFromEnvironment(str);
            }
        }.start();
    }

    public void getFlagById(final String str, final String str2, final FWFResultCallback<FWFFeature> fWFResultCallback) {
        new GenericAsyncTask<FWFFeature>(new GenericAsyncTask.GenericAsyncTaskCallback<FWFFeature>() {
            public void onResult(FWFFeature fWFFeature) {
                if (fWFFeature != null) {
                    fWFResultCallback.onResponse(fWFFeature);
                } else {
                    fWFResultCallback.onError("FunWithFlags: DB Error");
                }
            }
        }) {
            public FWFFeature doAsync() {
                return FWFDBRepository.this.dao.getFlagById(str, str2);
            }
        }.start();
    }

    public void getFlagKeys(final String str, final FWFResultCallback<List<FWFFlagKey>> fWFResultCallback) {
        new GenericAsyncTask<List<FWFFlagKey>>(new GenericAsyncTask.GenericAsyncTaskCallback<List<FWFFlagKey>>() {
            public void onResult(List<FWFFlagKey> list) {
                if (list != null) {
                    fWFResultCallback.onResponse(list);
                } else {
                    fWFResultCallback.onError("FunWithFlags: DB Error");
                }
            }
        }) {
            public List<FWFFlagKey> doAsync() {
                return FWFDBRepository.this.dao.getFlagKeys(str);
            }
        }.start();
    }

    public void getFlagsById(final List<String> list, final String str, final FWFResultCallback<List<FWFFeature>> fWFResultCallback) {
        new GenericAsyncTask<List<FWFFeature>>(new GenericAsyncTask.GenericAsyncTaskCallback<List<FWFFeature>>() {
            public void onResult(List<FWFFeature> list) {
                if (list != null) {
                    fWFResultCallback.onResponse(list);
                } else {
                    fWFResultCallback.onError("FunWithFlags: DB Error");
                }
            }
        }) {
            public List<FWFFeature> doAsync() {
                int i11;
                if (list.size() <= FWFDBRepository.SELECT_LIMIT.intValue()) {
                    return FWFDBRepository.this.dao.getFlagsById(list, str);
                }
                int size = list.size() / FWFDBRepository.SELECT_LIMIT.intValue();
                int size2 = list.size() % FWFDBRepository.SELECT_LIMIT.intValue();
                if (size2 > 0) {
                    size++;
                }
                ArrayList arrayList = new ArrayList();
                int i12 = 0;
                int i13 = 0;
                while (i12 < size) {
                    if (i12 != size - 1 || size2 <= 0) {
                        i11 = FWFDBRepository.SELECT_LIMIT.intValue() + i13;
                    } else {
                        i11 = i13 + size2;
                    }
                    arrayList.addAll(FWFDBRepository.this.dao.getFlagsById(list.subList(i13, i11), str));
                    i12++;
                    i13 = i11;
                }
                return arrayList;
            }
        }.start();
    }

    public void getLastSDKInfo(final FWFResultCallback<FWFSDKInfo> fWFResultCallback) {
        new GenericAsyncTask<FWFSDKInfo>(new GenericAsyncTask.GenericAsyncTaskCallback<FWFSDKInfo>() {
            public void onResult(FWFSDKInfo fWFSDKInfo) {
                if (fWFSDKInfo != null) {
                    fWFResultCallback.onResponse(fWFSDKInfo);
                } else {
                    fWFResultCallback.onError("FunWithFlags: DB Error");
                }
            }
        }) {
            public FWFSDKInfo doAsync() {
                return FWFDBRepository.this.dao.getLastSDKInfo();
            }
        }.start();
    }

    public void getOldestUpdatedFlagFromEnvironment(final String str, final FWFResultCallback<Boolean> fWFResultCallback) {
        new GenericAsyncTask<FWFFlagId>(new GenericAsyncTask.GenericAsyncTaskCallback<FWFFlagId>() {
            public void onResult(FWFFlagId fWFFlagId) {
                if (fWFFlagId != null) {
                    fWFResultCallback.onResponse(Boolean.valueOf(!fWFFlagId.requiresUpdate().booleanValue()));
                } else {
                    fWFResultCallback.onError("FunWithFlags: DB Error");
                }
            }
        }) {
            public FWFFlagId doAsync() {
                return FWFDBRepository.this.dao.getOldestUpdatedFlagFromEnvironment(str);
            }
        }.start();
    }

    public void getSubscribedFlagIds(final FWFResultCallback<List<FWFFlagId>> fWFResultCallback) {
        new GenericAsyncTask<List<FWFFlagId>>(new GenericAsyncTask.GenericAsyncTaskCallback<List<FWFFlagId>>() {
            public void onResult(List<FWFFlagId> list) {
                if (list != null) {
                    fWFResultCallback.onResponse(list);
                } else {
                    fWFResultCallback.onError("FunWithFlags: DB Error");
                }
            }
        }) {
            public List<FWFFlagId> doAsync() {
                return FWFDBRepository.this.dao.getSubscribedFlagIds();
            }
        }.start();
    }

    public void insertFlag(final FWFFeature fWFFeature) {
        new GenericAsyncTask<Void>((GenericAsyncTask.GenericAsyncTaskCallback) null) {
            public Void doAsync() {
                FWFDBRepository.this.dao.insertFlag(fWFFeature);
                return null;
            }
        }.start();
    }

    public void insertFlagCheckingSubscribe(final FWFFeature fWFFeature) {
        new GenericAsyncTask<Void>((GenericAsyncTask.GenericAsyncTaskCallback) null) {
            public Void doAsync() {
                FWFFeature flagById = FWFDBRepository.this.dao.getFlagById(fWFFeature.getKey(), fWFFeature.getAccessToken());
                if (flagById != null && flagById.getSubscribe() == 1) {
                    fWFFeature.setSubscribe(1);
                }
                FWFDBRepository.this.dao.insertFlag(fWFFeature);
                return null;
            }
        }.start();
    }

    public void insertFlags(final List<FWFFeature> list) {
        new GenericAsyncTask<Void>((GenericAsyncTask.GenericAsyncTaskCallback) null) {
            public Void doAsync() {
                FWFDBRepository.this.dao.insertFlags(list);
                return null;
            }
        }.start();
    }

    public void insertSDKInfo(final FWFSDKInfo fWFSDKInfo) {
        new GenericAsyncTask<Void>((GenericAsyncTask.GenericAsyncTaskCallback) null) {
            public Void doAsync() {
                FWFDBRepository.this.dao.insertSDKInfo(fWFSDKInfo);
                return null;
            }
        }.start();
    }

    public void getAllFlagKeysByRelevantContext(final List<String> list, final FWFResultCallback<Set<FWFFlagId>> fWFResultCallback) {
        new GenericAsyncTask<Set<FWFFlagId>>(new GenericAsyncTask.GenericAsyncTaskCallback<Set<FWFFlagId>>() {
            public void onResult(Set<FWFFlagId> set) {
                if (set != null) {
                    fWFResultCallback.onResponse(set);
                } else {
                    fWFResultCallback.onError("FunWithFlags: DB Error");
                }
            }
        }) {
            public Set<FWFFlagId> doAsync() {
                HashSet hashSet = new HashSet();
                for (String str : list) {
                    FWFDBDAO access$000 = FWFDBRepository.this.dao;
                    List<FWFFlagId> allFlagKeysByRelevantContext = access$000.getAllFlagKeysByRelevantContext("%" + str + "%");
                    if (allFlagKeysByRelevantContext != null && !allFlagKeysByRelevantContext.isEmpty()) {
                        hashSet.addAll(allFlagKeysByRelevantContext);
                    }
                }
                return hashSet;
            }
        }.start();
    }
}
