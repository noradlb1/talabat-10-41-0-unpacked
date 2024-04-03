package fwfd.com.fwfsdk.model.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.talabat.authentication.token.data.local.impl.LegacyTokenLocalDataSourceImpl;
import fwfd.com.fwfsdk.constant.FWFConstants;
import fwfd.com.fwfsdk.model.api.FWFExplanation;
import fwfd.com.fwfsdk.model.api.FWFTrackInfo;
import fwfd.com.fwfsdk.model.db.FWFFeature;
import fwfd.com.fwfsdk.model.db.FWFFlagId;
import fwfd.com.fwfsdk.model.db.FWFFlagKey;
import fwfd.com.fwfsdk.model.db.FWFSDKInfo;
import fwfd.com.fwfsdk.util.FWFAnyConverter;
import fwfd.com.fwfsdk.util.FWFMapConverter;
import fwfd.com.fwfsdk.util.FWFStringListConverter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class FWFDBDAO_Impl extends FWFDBDAO {
    private final RoomDatabase __db;
    /* access modifiers changed from: private */
    public final FWFAnyConverter __fWFAnyConverter = new FWFAnyConverter();
    private final EntityInsertionAdapter<FWFFeature> __insertionAdapterOfFWFFeature;
    private final EntityInsertionAdapter<FWFFlagKey> __insertionAdapterOfFWFFlagKey;
    private final EntityInsertionAdapter<FWFSDKInfo> __insertionAdapterOfFWFSDKInfo;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAllFlagKeys;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAllFlagRecords;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAllFlagsFromEnvironment;

    public FWFDBDAO_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfFWFFeature = new EntityInsertionAdapter<FWFFeature>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR REPLACE INTO `FWFFeature` (`key`,`variation`,`abTest`,`accessToken`,`date`,`relevantContext`,`subscribe`,`holdoutsEvaluations`,`kind`,`from`,`ruleIndex`,`evaluatedAttributes`,`evaluatedFlags`,`error`,`variationName`,`flagType`,`flagEnabled`,`trackerServices`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, FWFFeature fWFFeature) {
                if (fWFFeature.getKey() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, fWFFeature.getKey());
                }
                byte[] fWFAnyConverter = FWFDBDAO_Impl.this.__fWFAnyConverter.toString(fWFFeature.getVariation());
                if (fWFAnyConverter == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindBlob(2, fWFAnyConverter);
                }
                supportSQLiteStatement.bindLong(3, fWFFeature.getAbTest() ? 1 : 0);
                if (fWFFeature.getAccessToken() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, fWFFeature.getAccessToken());
                }
                supportSQLiteStatement.bindLong(5, fWFFeature.getDate());
                if (fWFFeature.getRelevantContext() == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindString(6, fWFFeature.getRelevantContext());
                }
                supportSQLiteStatement.bindLong(7, (long) fWFFeature.getSubscribe());
                String fromMap = FWFMapConverter.fromMap(fWFFeature.getHoldoutsEvaluations());
                if (fromMap == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindString(8, fromMap);
                }
                FWFExplanation explanation = fWFFeature.getExplanation();
                if (explanation != null) {
                    if (explanation.getKind() == null) {
                        supportSQLiteStatement.bindNull(9);
                    } else {
                        supportSQLiteStatement.bindString(9, explanation.getKind());
                    }
                    if (explanation.getFrom() == null) {
                        supportSQLiteStatement.bindNull(10);
                    } else {
                        supportSQLiteStatement.bindString(10, explanation.getFrom());
                    }
                    if (explanation.getRuleIndex() == null) {
                        supportSQLiteStatement.bindNull(11);
                    } else {
                        supportSQLiteStatement.bindString(11, explanation.getRuleIndex());
                    }
                    String fromArrayList = FWFStringListConverter.fromArrayList(explanation.getEvaluatedAttributes());
                    if (fromArrayList == null) {
                        supportSQLiteStatement.bindNull(12);
                    } else {
                        supportSQLiteStatement.bindString(12, fromArrayList);
                    }
                    String fromArrayList2 = FWFStringListConverter.fromArrayList(explanation.getEvaluatedFlags());
                    if (fromArrayList2 == null) {
                        supportSQLiteStatement.bindNull(13);
                    } else {
                        supportSQLiteStatement.bindString(13, fromArrayList2);
                    }
                    if (explanation.getError() == null) {
                        supportSQLiteStatement.bindNull(14);
                    } else {
                        supportSQLiteStatement.bindString(14, explanation.getError());
                    }
                } else {
                    supportSQLiteStatement.bindNull(9);
                    supportSQLiteStatement.bindNull(10);
                    supportSQLiteStatement.bindNull(11);
                    supportSQLiteStatement.bindNull(12);
                    supportSQLiteStatement.bindNull(13);
                    supportSQLiteStatement.bindNull(14);
                }
                FWFTrackInfo trackInfo = fWFFeature.getTrackInfo();
                if (trackInfo != null) {
                    byte[] fWFAnyConverter2 = FWFDBDAO_Impl.this.__fWFAnyConverter.toString(trackInfo.getVariationName());
                    if (fWFAnyConverter2 == null) {
                        supportSQLiteStatement.bindNull(15);
                    } else {
                        supportSQLiteStatement.bindBlob(15, fWFAnyConverter2);
                    }
                    if (trackInfo.getFlagType() == null) {
                        supportSQLiteStatement.bindNull(16);
                    } else {
                        supportSQLiteStatement.bindString(16, trackInfo.getFlagType());
                    }
                    Integer valueOf = trackInfo.getFlagEnabled() == null ? null : Integer.valueOf(trackInfo.getFlagEnabled().booleanValue() ? 1 : 0);
                    if (valueOf == null) {
                        supportSQLiteStatement.bindNull(17);
                    } else {
                        supportSQLiteStatement.bindLong(17, (long) valueOf.intValue());
                    }
                    String fromArrayList3 = FWFStringListConverter.fromArrayList(trackInfo.getTrackerServices());
                    if (fromArrayList3 == null) {
                        supportSQLiteStatement.bindNull(18);
                    } else {
                        supportSQLiteStatement.bindString(18, fromArrayList3);
                    }
                } else {
                    supportSQLiteStatement.bindNull(15);
                    supportSQLiteStatement.bindNull(16);
                    supportSQLiteStatement.bindNull(17);
                    supportSQLiteStatement.bindNull(18);
                }
            }
        };
        this.__insertionAdapterOfFWFFlagKey = new EntityInsertionAdapter<FWFFlagKey>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR REPLACE INTO `FWFFlagKey` (`key`,`token`,`kind`,`enabled`,`date`) VALUES (?,?,?,?,?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, FWFFlagKey fWFFlagKey) {
                if (fWFFlagKey.getKey() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, fWFFlagKey.getKey());
                }
                if (fWFFlagKey.getToken() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, fWFFlagKey.getToken());
                }
                if (fWFFlagKey.getKind() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, fWFFlagKey.getKind());
                }
                Integer valueOf = fWFFlagKey.getEnabled() == null ? null : Integer.valueOf(fWFFlagKey.getEnabled().booleanValue() ? 1 : 0);
                if (valueOf == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindLong(4, (long) valueOf.intValue());
                }
                if (fWFFlagKey.getDate() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindLong(5, fWFFlagKey.getDate().longValue());
                }
            }
        };
        this.__insertionAdapterOfFWFSDKInfo = new EntityInsertionAdapter<FWFSDKInfo>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR IGNORE INTO `FWFSDKInfo` (`sdkVersion`,`versionNumber`) VALUES (?,?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, FWFSDKInfo fWFSDKInfo) {
                if (fWFSDKInfo.getSdkVersion() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, fWFSDKInfo.getSdkVersion());
                }
                if (fWFSDKInfo.getVersionNumber() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindLong(2, (long) fWFSDKInfo.getVersionNumber().intValue());
                }
            }
        };
        this.__preparedStmtOfDeleteAllFlagRecords = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM FWFFeature";
            }
        };
        this.__preparedStmtOfDeleteAllFlagsFromEnvironment = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM FWFFeature WHERE accessToken = ?";
            }
        };
        this.__preparedStmtOfDeleteAllFlagKeys = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM FWFFlagKey WHERE token = ?";
            }
        };
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    public void deleteAllFlagKeys(String str) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeleteAllFlagKeys.acquire();
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteAllFlagKeys.release(acquire);
        }
    }

    public void deleteAllFlagRecords() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeleteAllFlagRecords.acquire();
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteAllFlagRecords.release(acquire);
        }
    }

    public void deleteAllFlagsFromEnvironment(String str) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeleteAllFlagsFromEnvironment.acquire();
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteAllFlagsFromEnvironment.release(acquire);
        }
    }

    public void deleteAndInsertNewFlagKeys(List<FWFFlagKey> list, String str) {
        this.__db.beginTransaction();
        try {
            super.deleteAndInsertNewFlagKeys(list, str);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x021e A[Catch:{ all -> 0x0270 }] */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0238 A[Catch:{ all -> 0x0270 }] */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x023d A[Catch:{ all -> 0x0270 }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x014d A[Catch:{ all -> 0x0270 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x014e A[Catch:{ all -> 0x0270 }] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x01c1 A[Catch:{ all -> 0x0270 }] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x01c5 A[Catch:{ all -> 0x0270 }] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01d6 A[Catch:{ all -> 0x0270 }] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x01d8 A[Catch:{ all -> 0x0270 }] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x01e9 A[Catch:{ all -> 0x0270 }] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01ec A[Catch:{ all -> 0x0270 }] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x01f8 A[Catch:{ all -> 0x0270 }] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x01fc A[Catch:{ all -> 0x0270 }] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x021c A[Catch:{ all -> 0x0270 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<fwfd.com.fwfsdk.model.db.FWFFeature> getAllExperiments() {
        /*
            r27 = this;
            r1 = r27
            java.lang.String r0 = "SELECT * FROM FWFFeature WHERE abTest = 1"
            r2 = 0
            androidx.room.RoomSQLiteQuery r3 = androidx.room.RoomSQLiteQuery.acquire(r0, r2)
            androidx.room.RoomDatabase r0 = r1.__db
            r0.assertNotSuspendingTransaction()
            androidx.room.RoomDatabase r0 = r1.__db
            r4 = 0
            android.database.Cursor r5 = androidx.room.util.DBUtil.query(r0, r3, r2, r4)
            java.lang.String r0 = "key"
            int r0 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r5, r0)     // Catch:{ all -> 0x0272 }
            java.lang.String r6 = "variation"
            int r6 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r5, r6)     // Catch:{ all -> 0x0272 }
            java.lang.String r7 = "abTest"
            int r7 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r5, r7)     // Catch:{ all -> 0x0272 }
            java.lang.String r8 = "accessToken"
            int r8 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r5, r8)     // Catch:{ all -> 0x0272 }
            java.lang.String r9 = "date"
            int r9 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r5, r9)     // Catch:{ all -> 0x0272 }
            java.lang.String r10 = "relevantContext"
            int r10 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r5, r10)     // Catch:{ all -> 0x0272 }
            java.lang.String r11 = "subscribe"
            int r11 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r5, r11)     // Catch:{ all -> 0x0272 }
            java.lang.String r12 = "holdoutsEvaluations"
            int r12 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r5, r12)     // Catch:{ all -> 0x0272 }
            java.lang.String r13 = "kind"
            int r13 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r5, r13)     // Catch:{ all -> 0x0272 }
            java.lang.String r14 = "from"
            int r14 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r5, r14)     // Catch:{ all -> 0x0272 }
            java.lang.String r15 = "ruleIndex"
            int r15 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r5, r15)     // Catch:{ all -> 0x0272 }
            java.lang.String r2 = "evaluatedAttributes"
            int r2 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r5, r2)     // Catch:{ all -> 0x0272 }
            java.lang.String r4 = "evaluatedFlags"
            int r4 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r5, r4)     // Catch:{ all -> 0x0272 }
            java.lang.String r1 = "error"
            int r1 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r5, r1)     // Catch:{ all -> 0x0272 }
            r16 = r3
            java.lang.String r3 = "variationName"
            int r3 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r5, r3)     // Catch:{ all -> 0x0270 }
            r17 = r12
            java.lang.String r12 = "flagType"
            int r12 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r5, r12)     // Catch:{ all -> 0x0270 }
            r18 = r11
            java.lang.String r11 = "flagEnabled"
            int r11 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r5, r11)     // Catch:{ all -> 0x0270 }
            r19 = r10
            java.lang.String r10 = "trackerServices"
            int r10 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r5, r10)     // Catch:{ all -> 0x0270 }
            r20 = r9
            java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ all -> 0x0270 }
            r21 = r8
            int r8 = r5.getCount()     // Catch:{ all -> 0x0270 }
            r9.<init>(r8)     // Catch:{ all -> 0x0270 }
        L_0x0096:
            boolean r8 = r5.moveToNext()     // Catch:{ all -> 0x0270 }
            if (r8 == 0) goto L_0x0269
            boolean r8 = r5.isNull(r13)     // Catch:{ all -> 0x0270 }
            if (r8 == 0) goto L_0x00c6
            boolean r8 = r5.isNull(r14)     // Catch:{ all -> 0x0270 }
            if (r8 == 0) goto L_0x00c6
            boolean r8 = r5.isNull(r15)     // Catch:{ all -> 0x0270 }
            if (r8 == 0) goto L_0x00c6
            boolean r8 = r5.isNull(r2)     // Catch:{ all -> 0x0270 }
            if (r8 == 0) goto L_0x00c6
            boolean r8 = r5.isNull(r4)     // Catch:{ all -> 0x0270 }
            if (r8 == 0) goto L_0x00c6
            boolean r8 = r5.isNull(r1)     // Catch:{ all -> 0x0270 }
            if (r8 != 0) goto L_0x00c1
            goto L_0x00c6
        L_0x00c1:
            r23 = r13
            r8 = 0
            goto L_0x0133
        L_0x00c6:
            fwfd.com.fwfsdk.model.api.FWFExplanation r8 = new fwfd.com.fwfsdk.model.api.FWFExplanation     // Catch:{ all -> 0x0270 }
            r8.<init>()     // Catch:{ all -> 0x0270 }
            boolean r22 = r5.isNull(r13)     // Catch:{ all -> 0x0270 }
            if (r22 == 0) goto L_0x00d5
            r23 = r13
            r13 = 0
            goto L_0x00dd
        L_0x00d5:
            java.lang.String r22 = r5.getString(r13)     // Catch:{ all -> 0x0270 }
            r23 = r13
            r13 = r22
        L_0x00dd:
            r8.setKind(r13)     // Catch:{ all -> 0x0270 }
            boolean r13 = r5.isNull(r14)     // Catch:{ all -> 0x0270 }
            if (r13 == 0) goto L_0x00e8
            r13 = 0
            goto L_0x00ec
        L_0x00e8:
            java.lang.String r13 = r5.getString(r14)     // Catch:{ all -> 0x0270 }
        L_0x00ec:
            r8.setFrom(r13)     // Catch:{ all -> 0x0270 }
            boolean r13 = r5.isNull(r15)     // Catch:{ all -> 0x0270 }
            if (r13 == 0) goto L_0x00f7
            r13 = 0
            goto L_0x00fb
        L_0x00f7:
            java.lang.String r13 = r5.getString(r15)     // Catch:{ all -> 0x0270 }
        L_0x00fb:
            r8.setRuleIndex(r13)     // Catch:{ all -> 0x0270 }
            boolean r13 = r5.isNull(r2)     // Catch:{ all -> 0x0270 }
            if (r13 == 0) goto L_0x0106
            r13 = 0
            goto L_0x010a
        L_0x0106:
            java.lang.String r13 = r5.getString(r2)     // Catch:{ all -> 0x0270 }
        L_0x010a:
            java.util.List r13 = fwfd.com.fwfsdk.util.FWFStringListConverter.fromString(r13)     // Catch:{ all -> 0x0270 }
            r8.setEvaluatedAttributes(r13)     // Catch:{ all -> 0x0270 }
            boolean r13 = r5.isNull(r4)     // Catch:{ all -> 0x0270 }
            if (r13 == 0) goto L_0x0119
            r13 = 0
            goto L_0x011d
        L_0x0119:
            java.lang.String r13 = r5.getString(r4)     // Catch:{ all -> 0x0270 }
        L_0x011d:
            java.util.List r13 = fwfd.com.fwfsdk.util.FWFStringListConverter.fromString(r13)     // Catch:{ all -> 0x0270 }
            r8.setEvaluatedFlags(r13)     // Catch:{ all -> 0x0270 }
            boolean r13 = r5.isNull(r1)     // Catch:{ all -> 0x0270 }
            if (r13 == 0) goto L_0x012c
            r13 = 0
            goto L_0x0130
        L_0x012c:
            java.lang.String r13 = r5.getString(r1)     // Catch:{ all -> 0x0270 }
        L_0x0130:
            r8.setError(r13)     // Catch:{ all -> 0x0270 }
        L_0x0133:
            boolean r13 = r5.isNull(r3)     // Catch:{ all -> 0x0270 }
            r22 = 1
            if (r13 == 0) goto L_0x0152
            boolean r13 = r5.isNull(r12)     // Catch:{ all -> 0x0270 }
            if (r13 == 0) goto L_0x0152
            boolean r13 = r5.isNull(r11)     // Catch:{ all -> 0x0270 }
            if (r13 == 0) goto L_0x0152
            boolean r13 = r5.isNull(r10)     // Catch:{ all -> 0x0270 }
            if (r13 != 0) goto L_0x014e
            goto L_0x0152
        L_0x014e:
            r25 = r1
            r13 = 0
            goto L_0x01b6
        L_0x0152:
            fwfd.com.fwfsdk.model.api.FWFTrackInfo r13 = new fwfd.com.fwfsdk.model.api.FWFTrackInfo     // Catch:{ all -> 0x0270 }
            r13.<init>()     // Catch:{ all -> 0x0270 }
            boolean r24 = r5.isNull(r3)     // Catch:{ all -> 0x0270 }
            if (r24 == 0) goto L_0x0162
            r25 = r1
            r24 = 0
            goto L_0x0168
        L_0x0162:
            byte[] r24 = r5.getBlob(r3)     // Catch:{ all -> 0x0270 }
            r25 = r1
        L_0x0168:
            java.lang.Object r1 = fwfd.com.fwfsdk.util.FWFAnyConverter.toObject(r24)     // Catch:{ all -> 0x0270 }
            r13.setVariationName(r1)     // Catch:{ all -> 0x0270 }
            boolean r1 = r5.isNull(r12)     // Catch:{ all -> 0x0270 }
            if (r1 == 0) goto L_0x0177
            r1 = 0
            goto L_0x017b
        L_0x0177:
            java.lang.String r1 = r5.getString(r12)     // Catch:{ all -> 0x0270 }
        L_0x017b:
            r13.setFlagType(r1)     // Catch:{ all -> 0x0270 }
            boolean r1 = r5.isNull(r11)     // Catch:{ all -> 0x0270 }
            if (r1 == 0) goto L_0x0186
            r1 = 0
            goto L_0x018e
        L_0x0186:
            int r1 = r5.getInt(r11)     // Catch:{ all -> 0x0270 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x0270 }
        L_0x018e:
            if (r1 != 0) goto L_0x0192
            r1 = 0
            goto L_0x01a0
        L_0x0192:
            int r1 = r1.intValue()     // Catch:{ all -> 0x0270 }
            if (r1 == 0) goto L_0x019b
            r1 = r22
            goto L_0x019c
        L_0x019b:
            r1 = 0
        L_0x019c:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch:{ all -> 0x0270 }
        L_0x01a0:
            r13.setFlagEnabled(r1)     // Catch:{ all -> 0x0270 }
            boolean r1 = r5.isNull(r10)     // Catch:{ all -> 0x0270 }
            if (r1 == 0) goto L_0x01ab
            r1 = 0
            goto L_0x01af
        L_0x01ab:
            java.lang.String r1 = r5.getString(r10)     // Catch:{ all -> 0x0270 }
        L_0x01af:
            java.util.List r1 = fwfd.com.fwfsdk.util.FWFStringListConverter.fromString(r1)     // Catch:{ all -> 0x0270 }
            r13.setTrackerServices(r1)     // Catch:{ all -> 0x0270 }
        L_0x01b6:
            fwfd.com.fwfsdk.model.db.FWFFeature r1 = new fwfd.com.fwfsdk.model.db.FWFFeature     // Catch:{ all -> 0x0270 }
            r1.<init>()     // Catch:{ all -> 0x0270 }
            boolean r24 = r5.isNull(r0)     // Catch:{ all -> 0x0270 }
            if (r24 == 0) goto L_0x01c5
            r26 = r0
            r0 = 0
            goto L_0x01cd
        L_0x01c5:
            java.lang.String r24 = r5.getString(r0)     // Catch:{ all -> 0x0270 }
            r26 = r0
            r0 = r24
        L_0x01cd:
            r1.setKey(r0)     // Catch:{ all -> 0x0270 }
            boolean r0 = r5.isNull(r6)     // Catch:{ all -> 0x0270 }
            if (r0 == 0) goto L_0x01d8
            r0 = 0
            goto L_0x01dc
        L_0x01d8:
            byte[] r0 = r5.getBlob(r6)     // Catch:{ all -> 0x0270 }
        L_0x01dc:
            java.lang.Object r0 = fwfd.com.fwfsdk.util.FWFAnyConverter.toObject(r0)     // Catch:{ all -> 0x0270 }
            r1.setVariation(r0)     // Catch:{ all -> 0x0270 }
            int r0 = r5.getInt(r7)     // Catch:{ all -> 0x0270 }
            if (r0 == 0) goto L_0x01ec
            r0 = r22
            goto L_0x01ed
        L_0x01ec:
            r0 = 0
        L_0x01ed:
            r1.setAbTest(r0)     // Catch:{ all -> 0x0270 }
            r0 = r21
            boolean r21 = r5.isNull(r0)     // Catch:{ all -> 0x0270 }
            if (r21 == 0) goto L_0x01fc
            r22 = r0
            r0 = 0
            goto L_0x0204
        L_0x01fc:
            java.lang.String r21 = r5.getString(r0)     // Catch:{ all -> 0x0270 }
            r22 = r0
            r0 = r21
        L_0x0204:
            r1.setAccessToken(r0)     // Catch:{ all -> 0x0270 }
            r21 = r3
            r0 = r20
            r20 = r2
            long r2 = r5.getLong(r0)     // Catch:{ all -> 0x0270 }
            r1.setDate(r2)     // Catch:{ all -> 0x0270 }
            r2 = r19
            boolean r3 = r5.isNull(r2)     // Catch:{ all -> 0x0270 }
            if (r3 == 0) goto L_0x021e
            r3 = 0
            goto L_0x0222
        L_0x021e:
            java.lang.String r3 = r5.getString(r2)     // Catch:{ all -> 0x0270 }
        L_0x0222:
            r1.setRelevantContext(r3)     // Catch:{ all -> 0x0270 }
            r3 = r18
            r18 = r0
            int r0 = r5.getInt(r3)     // Catch:{ all -> 0x0270 }
            r1.setSubscribe(r0)     // Catch:{ all -> 0x0270 }
            r0 = r17
            boolean r17 = r5.isNull(r0)     // Catch:{ all -> 0x0270 }
            if (r17 == 0) goto L_0x023d
            r19 = r0
            r17 = 0
            goto L_0x0243
        L_0x023d:
            java.lang.String r17 = r5.getString(r0)     // Catch:{ all -> 0x0270 }
            r19 = r0
        L_0x0243:
            java.util.Map r0 = fwfd.com.fwfsdk.util.FWFMapConverter.fromString(r17)     // Catch:{ all -> 0x0270 }
            r1.setHoldoutsEvaluations(r0)     // Catch:{ all -> 0x0270 }
            r1.setExplanation(r8)     // Catch:{ all -> 0x0270 }
            r1.setTrackInfo(r13)     // Catch:{ all -> 0x0270 }
            r9.add(r1)     // Catch:{ all -> 0x0270 }
            r17 = r19
            r13 = r23
            r1 = r25
            r0 = r26
            r19 = r2
            r2 = r20
            r20 = r18
            r18 = r3
            r3 = r21
            r21 = r22
            goto L_0x0096
        L_0x0269:
            r5.close()
            r16.release()
            return r9
        L_0x0270:
            r0 = move-exception
            goto L_0x0275
        L_0x0272:
            r0 = move-exception
            r16 = r3
        L_0x0275:
            r5.close()
            r16.release()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fwfd.com.fwfsdk.model.dao.FWFDBDAO_Impl.getAllExperiments():java.util.List");
    }

    public List<FWFFlagId> getAllFlagKeysByRelevantContext(String str) {
        String str2;
        String str3;
        Long l11;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT `key`, accessToken, date FROM FWFFeature WHERE relevantContext LIKE ? AND subscribe = 1", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "key");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "accessToken");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "date");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                if (query.isNull(columnIndexOrThrow)) {
                    str2 = null;
                } else {
                    str2 = query.getString(columnIndexOrThrow);
                }
                if (query.isNull(columnIndexOrThrow2)) {
                    str3 = null;
                } else {
                    str3 = query.getString(columnIndexOrThrow2);
                }
                if (query.isNull(columnIndexOrThrow3)) {
                    l11 = null;
                } else {
                    l11 = Long.valueOf(query.getLong(columnIndexOrThrow3));
                }
                arrayList.add(new FWFFlagId(str2, str3, l11));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x021e A[Catch:{ all -> 0x0270 }] */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0238 A[Catch:{ all -> 0x0270 }] */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x023d A[Catch:{ all -> 0x0270 }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x014d A[Catch:{ all -> 0x0270 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x014e A[Catch:{ all -> 0x0270 }] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x01c1 A[Catch:{ all -> 0x0270 }] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x01c5 A[Catch:{ all -> 0x0270 }] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01d6 A[Catch:{ all -> 0x0270 }] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x01d8 A[Catch:{ all -> 0x0270 }] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x01e9 A[Catch:{ all -> 0x0270 }] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01ec A[Catch:{ all -> 0x0270 }] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x01f8 A[Catch:{ all -> 0x0270 }] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x01fc A[Catch:{ all -> 0x0270 }] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x021c A[Catch:{ all -> 0x0270 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<fwfd.com.fwfsdk.model.db.FWFFeature> getAllFlags() {
        /*
            r27 = this;
            r1 = r27
            java.lang.String r0 = "SELECT * FROM FWFFeature"
            r2 = 0
            androidx.room.RoomSQLiteQuery r3 = androidx.room.RoomSQLiteQuery.acquire(r0, r2)
            androidx.room.RoomDatabase r0 = r1.__db
            r0.assertNotSuspendingTransaction()
            androidx.room.RoomDatabase r0 = r1.__db
            r4 = 0
            android.database.Cursor r5 = androidx.room.util.DBUtil.query(r0, r3, r2, r4)
            java.lang.String r0 = "key"
            int r0 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r5, r0)     // Catch:{ all -> 0x0272 }
            java.lang.String r6 = "variation"
            int r6 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r5, r6)     // Catch:{ all -> 0x0272 }
            java.lang.String r7 = "abTest"
            int r7 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r5, r7)     // Catch:{ all -> 0x0272 }
            java.lang.String r8 = "accessToken"
            int r8 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r5, r8)     // Catch:{ all -> 0x0272 }
            java.lang.String r9 = "date"
            int r9 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r5, r9)     // Catch:{ all -> 0x0272 }
            java.lang.String r10 = "relevantContext"
            int r10 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r5, r10)     // Catch:{ all -> 0x0272 }
            java.lang.String r11 = "subscribe"
            int r11 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r5, r11)     // Catch:{ all -> 0x0272 }
            java.lang.String r12 = "holdoutsEvaluations"
            int r12 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r5, r12)     // Catch:{ all -> 0x0272 }
            java.lang.String r13 = "kind"
            int r13 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r5, r13)     // Catch:{ all -> 0x0272 }
            java.lang.String r14 = "from"
            int r14 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r5, r14)     // Catch:{ all -> 0x0272 }
            java.lang.String r15 = "ruleIndex"
            int r15 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r5, r15)     // Catch:{ all -> 0x0272 }
            java.lang.String r2 = "evaluatedAttributes"
            int r2 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r5, r2)     // Catch:{ all -> 0x0272 }
            java.lang.String r4 = "evaluatedFlags"
            int r4 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r5, r4)     // Catch:{ all -> 0x0272 }
            java.lang.String r1 = "error"
            int r1 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r5, r1)     // Catch:{ all -> 0x0272 }
            r16 = r3
            java.lang.String r3 = "variationName"
            int r3 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r5, r3)     // Catch:{ all -> 0x0270 }
            r17 = r12
            java.lang.String r12 = "flagType"
            int r12 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r5, r12)     // Catch:{ all -> 0x0270 }
            r18 = r11
            java.lang.String r11 = "flagEnabled"
            int r11 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r5, r11)     // Catch:{ all -> 0x0270 }
            r19 = r10
            java.lang.String r10 = "trackerServices"
            int r10 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r5, r10)     // Catch:{ all -> 0x0270 }
            r20 = r9
            java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ all -> 0x0270 }
            r21 = r8
            int r8 = r5.getCount()     // Catch:{ all -> 0x0270 }
            r9.<init>(r8)     // Catch:{ all -> 0x0270 }
        L_0x0096:
            boolean r8 = r5.moveToNext()     // Catch:{ all -> 0x0270 }
            if (r8 == 0) goto L_0x0269
            boolean r8 = r5.isNull(r13)     // Catch:{ all -> 0x0270 }
            if (r8 == 0) goto L_0x00c6
            boolean r8 = r5.isNull(r14)     // Catch:{ all -> 0x0270 }
            if (r8 == 0) goto L_0x00c6
            boolean r8 = r5.isNull(r15)     // Catch:{ all -> 0x0270 }
            if (r8 == 0) goto L_0x00c6
            boolean r8 = r5.isNull(r2)     // Catch:{ all -> 0x0270 }
            if (r8 == 0) goto L_0x00c6
            boolean r8 = r5.isNull(r4)     // Catch:{ all -> 0x0270 }
            if (r8 == 0) goto L_0x00c6
            boolean r8 = r5.isNull(r1)     // Catch:{ all -> 0x0270 }
            if (r8 != 0) goto L_0x00c1
            goto L_0x00c6
        L_0x00c1:
            r23 = r13
            r8 = 0
            goto L_0x0133
        L_0x00c6:
            fwfd.com.fwfsdk.model.api.FWFExplanation r8 = new fwfd.com.fwfsdk.model.api.FWFExplanation     // Catch:{ all -> 0x0270 }
            r8.<init>()     // Catch:{ all -> 0x0270 }
            boolean r22 = r5.isNull(r13)     // Catch:{ all -> 0x0270 }
            if (r22 == 0) goto L_0x00d5
            r23 = r13
            r13 = 0
            goto L_0x00dd
        L_0x00d5:
            java.lang.String r22 = r5.getString(r13)     // Catch:{ all -> 0x0270 }
            r23 = r13
            r13 = r22
        L_0x00dd:
            r8.setKind(r13)     // Catch:{ all -> 0x0270 }
            boolean r13 = r5.isNull(r14)     // Catch:{ all -> 0x0270 }
            if (r13 == 0) goto L_0x00e8
            r13 = 0
            goto L_0x00ec
        L_0x00e8:
            java.lang.String r13 = r5.getString(r14)     // Catch:{ all -> 0x0270 }
        L_0x00ec:
            r8.setFrom(r13)     // Catch:{ all -> 0x0270 }
            boolean r13 = r5.isNull(r15)     // Catch:{ all -> 0x0270 }
            if (r13 == 0) goto L_0x00f7
            r13 = 0
            goto L_0x00fb
        L_0x00f7:
            java.lang.String r13 = r5.getString(r15)     // Catch:{ all -> 0x0270 }
        L_0x00fb:
            r8.setRuleIndex(r13)     // Catch:{ all -> 0x0270 }
            boolean r13 = r5.isNull(r2)     // Catch:{ all -> 0x0270 }
            if (r13 == 0) goto L_0x0106
            r13 = 0
            goto L_0x010a
        L_0x0106:
            java.lang.String r13 = r5.getString(r2)     // Catch:{ all -> 0x0270 }
        L_0x010a:
            java.util.List r13 = fwfd.com.fwfsdk.util.FWFStringListConverter.fromString(r13)     // Catch:{ all -> 0x0270 }
            r8.setEvaluatedAttributes(r13)     // Catch:{ all -> 0x0270 }
            boolean r13 = r5.isNull(r4)     // Catch:{ all -> 0x0270 }
            if (r13 == 0) goto L_0x0119
            r13 = 0
            goto L_0x011d
        L_0x0119:
            java.lang.String r13 = r5.getString(r4)     // Catch:{ all -> 0x0270 }
        L_0x011d:
            java.util.List r13 = fwfd.com.fwfsdk.util.FWFStringListConverter.fromString(r13)     // Catch:{ all -> 0x0270 }
            r8.setEvaluatedFlags(r13)     // Catch:{ all -> 0x0270 }
            boolean r13 = r5.isNull(r1)     // Catch:{ all -> 0x0270 }
            if (r13 == 0) goto L_0x012c
            r13 = 0
            goto L_0x0130
        L_0x012c:
            java.lang.String r13 = r5.getString(r1)     // Catch:{ all -> 0x0270 }
        L_0x0130:
            r8.setError(r13)     // Catch:{ all -> 0x0270 }
        L_0x0133:
            boolean r13 = r5.isNull(r3)     // Catch:{ all -> 0x0270 }
            r22 = 1
            if (r13 == 0) goto L_0x0152
            boolean r13 = r5.isNull(r12)     // Catch:{ all -> 0x0270 }
            if (r13 == 0) goto L_0x0152
            boolean r13 = r5.isNull(r11)     // Catch:{ all -> 0x0270 }
            if (r13 == 0) goto L_0x0152
            boolean r13 = r5.isNull(r10)     // Catch:{ all -> 0x0270 }
            if (r13 != 0) goto L_0x014e
            goto L_0x0152
        L_0x014e:
            r25 = r1
            r13 = 0
            goto L_0x01b6
        L_0x0152:
            fwfd.com.fwfsdk.model.api.FWFTrackInfo r13 = new fwfd.com.fwfsdk.model.api.FWFTrackInfo     // Catch:{ all -> 0x0270 }
            r13.<init>()     // Catch:{ all -> 0x0270 }
            boolean r24 = r5.isNull(r3)     // Catch:{ all -> 0x0270 }
            if (r24 == 0) goto L_0x0162
            r25 = r1
            r24 = 0
            goto L_0x0168
        L_0x0162:
            byte[] r24 = r5.getBlob(r3)     // Catch:{ all -> 0x0270 }
            r25 = r1
        L_0x0168:
            java.lang.Object r1 = fwfd.com.fwfsdk.util.FWFAnyConverter.toObject(r24)     // Catch:{ all -> 0x0270 }
            r13.setVariationName(r1)     // Catch:{ all -> 0x0270 }
            boolean r1 = r5.isNull(r12)     // Catch:{ all -> 0x0270 }
            if (r1 == 0) goto L_0x0177
            r1 = 0
            goto L_0x017b
        L_0x0177:
            java.lang.String r1 = r5.getString(r12)     // Catch:{ all -> 0x0270 }
        L_0x017b:
            r13.setFlagType(r1)     // Catch:{ all -> 0x0270 }
            boolean r1 = r5.isNull(r11)     // Catch:{ all -> 0x0270 }
            if (r1 == 0) goto L_0x0186
            r1 = 0
            goto L_0x018e
        L_0x0186:
            int r1 = r5.getInt(r11)     // Catch:{ all -> 0x0270 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x0270 }
        L_0x018e:
            if (r1 != 0) goto L_0x0192
            r1 = 0
            goto L_0x01a0
        L_0x0192:
            int r1 = r1.intValue()     // Catch:{ all -> 0x0270 }
            if (r1 == 0) goto L_0x019b
            r1 = r22
            goto L_0x019c
        L_0x019b:
            r1 = 0
        L_0x019c:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch:{ all -> 0x0270 }
        L_0x01a0:
            r13.setFlagEnabled(r1)     // Catch:{ all -> 0x0270 }
            boolean r1 = r5.isNull(r10)     // Catch:{ all -> 0x0270 }
            if (r1 == 0) goto L_0x01ab
            r1 = 0
            goto L_0x01af
        L_0x01ab:
            java.lang.String r1 = r5.getString(r10)     // Catch:{ all -> 0x0270 }
        L_0x01af:
            java.util.List r1 = fwfd.com.fwfsdk.util.FWFStringListConverter.fromString(r1)     // Catch:{ all -> 0x0270 }
            r13.setTrackerServices(r1)     // Catch:{ all -> 0x0270 }
        L_0x01b6:
            fwfd.com.fwfsdk.model.db.FWFFeature r1 = new fwfd.com.fwfsdk.model.db.FWFFeature     // Catch:{ all -> 0x0270 }
            r1.<init>()     // Catch:{ all -> 0x0270 }
            boolean r24 = r5.isNull(r0)     // Catch:{ all -> 0x0270 }
            if (r24 == 0) goto L_0x01c5
            r26 = r0
            r0 = 0
            goto L_0x01cd
        L_0x01c5:
            java.lang.String r24 = r5.getString(r0)     // Catch:{ all -> 0x0270 }
            r26 = r0
            r0 = r24
        L_0x01cd:
            r1.setKey(r0)     // Catch:{ all -> 0x0270 }
            boolean r0 = r5.isNull(r6)     // Catch:{ all -> 0x0270 }
            if (r0 == 0) goto L_0x01d8
            r0 = 0
            goto L_0x01dc
        L_0x01d8:
            byte[] r0 = r5.getBlob(r6)     // Catch:{ all -> 0x0270 }
        L_0x01dc:
            java.lang.Object r0 = fwfd.com.fwfsdk.util.FWFAnyConverter.toObject(r0)     // Catch:{ all -> 0x0270 }
            r1.setVariation(r0)     // Catch:{ all -> 0x0270 }
            int r0 = r5.getInt(r7)     // Catch:{ all -> 0x0270 }
            if (r0 == 0) goto L_0x01ec
            r0 = r22
            goto L_0x01ed
        L_0x01ec:
            r0 = 0
        L_0x01ed:
            r1.setAbTest(r0)     // Catch:{ all -> 0x0270 }
            r0 = r21
            boolean r21 = r5.isNull(r0)     // Catch:{ all -> 0x0270 }
            if (r21 == 0) goto L_0x01fc
            r22 = r0
            r0 = 0
            goto L_0x0204
        L_0x01fc:
            java.lang.String r21 = r5.getString(r0)     // Catch:{ all -> 0x0270 }
            r22 = r0
            r0 = r21
        L_0x0204:
            r1.setAccessToken(r0)     // Catch:{ all -> 0x0270 }
            r21 = r3
            r0 = r20
            r20 = r2
            long r2 = r5.getLong(r0)     // Catch:{ all -> 0x0270 }
            r1.setDate(r2)     // Catch:{ all -> 0x0270 }
            r2 = r19
            boolean r3 = r5.isNull(r2)     // Catch:{ all -> 0x0270 }
            if (r3 == 0) goto L_0x021e
            r3 = 0
            goto L_0x0222
        L_0x021e:
            java.lang.String r3 = r5.getString(r2)     // Catch:{ all -> 0x0270 }
        L_0x0222:
            r1.setRelevantContext(r3)     // Catch:{ all -> 0x0270 }
            r3 = r18
            r18 = r0
            int r0 = r5.getInt(r3)     // Catch:{ all -> 0x0270 }
            r1.setSubscribe(r0)     // Catch:{ all -> 0x0270 }
            r0 = r17
            boolean r17 = r5.isNull(r0)     // Catch:{ all -> 0x0270 }
            if (r17 == 0) goto L_0x023d
            r19 = r0
            r17 = 0
            goto L_0x0243
        L_0x023d:
            java.lang.String r17 = r5.getString(r0)     // Catch:{ all -> 0x0270 }
            r19 = r0
        L_0x0243:
            java.util.Map r0 = fwfd.com.fwfsdk.util.FWFMapConverter.fromString(r17)     // Catch:{ all -> 0x0270 }
            r1.setHoldoutsEvaluations(r0)     // Catch:{ all -> 0x0270 }
            r1.setExplanation(r8)     // Catch:{ all -> 0x0270 }
            r1.setTrackInfo(r13)     // Catch:{ all -> 0x0270 }
            r9.add(r1)     // Catch:{ all -> 0x0270 }
            r17 = r19
            r13 = r23
            r1 = r25
            r0 = r26
            r19 = r2
            r2 = r20
            r20 = r18
            r18 = r3
            r3 = r21
            r21 = r22
            goto L_0x0096
        L_0x0269:
            r5.close()
            r16.release()
            return r9
        L_0x0270:
            r0 = move-exception
            goto L_0x0275
        L_0x0272:
            r0 = move-exception
            r16 = r3
        L_0x0275:
            r5.close()
            r16.release()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fwfd.com.fwfsdk.model.dao.FWFDBDAO_Impl.getAllFlags():java.util.List");
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x0204 A[Catch:{ all -> 0x027a }] */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0224 A[Catch:{ all -> 0x027a }] */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0226 A[Catch:{ all -> 0x027a }] */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0240 A[Catch:{ all -> 0x027a }] */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0245 A[Catch:{ all -> 0x027a }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0157 A[Catch:{ all -> 0x027a }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0158 A[Catch:{ all -> 0x027a }] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01ca A[Catch:{ all -> 0x027a }] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x01ce A[Catch:{ all -> 0x027a }] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x01df A[Catch:{ all -> 0x027a }] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01e1 A[Catch:{ all -> 0x027a }] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x01f2 A[Catch:{ all -> 0x027a }] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x01f4 A[Catch:{ all -> 0x027a }] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0200 A[Catch:{ all -> 0x027a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<fwfd.com.fwfsdk.model.db.FWFFeature> getAllFlagsFromEnvironment(java.lang.String r28) {
        /*
            r27 = this;
            r1 = r27
            r0 = r28
            java.lang.String r2 = "SELECT * FROM FWFFeature WHERE accessToken = ?"
            r3 = 1
            androidx.room.RoomSQLiteQuery r2 = androidx.room.RoomSQLiteQuery.acquire(r2, r3)
            if (r0 != 0) goto L_0x0011
            r2.bindNull(r3)
            goto L_0x0014
        L_0x0011:
            r2.bindString(r3, r0)
        L_0x0014:
            androidx.room.RoomDatabase r0 = r1.__db
            r0.assertNotSuspendingTransaction()
            androidx.room.RoomDatabase r0 = r1.__db
            r4 = 0
            r5 = 0
            android.database.Cursor r6 = androidx.room.util.DBUtil.query(r0, r2, r4, r5)
            java.lang.String r0 = "key"
            int r0 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r6, r0)     // Catch:{ all -> 0x027c }
            java.lang.String r7 = "variation"
            int r7 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r6, r7)     // Catch:{ all -> 0x027c }
            java.lang.String r8 = "abTest"
            int r8 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r6, r8)     // Catch:{ all -> 0x027c }
            java.lang.String r9 = "accessToken"
            int r9 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r6, r9)     // Catch:{ all -> 0x027c }
            java.lang.String r10 = "date"
            int r10 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r6, r10)     // Catch:{ all -> 0x027c }
            java.lang.String r11 = "relevantContext"
            int r11 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r6, r11)     // Catch:{ all -> 0x027c }
            java.lang.String r12 = "subscribe"
            int r12 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r6, r12)     // Catch:{ all -> 0x027c }
            java.lang.String r13 = "holdoutsEvaluations"
            int r13 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r6, r13)     // Catch:{ all -> 0x027c }
            java.lang.String r14 = "kind"
            int r14 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r6, r14)     // Catch:{ all -> 0x027c }
            java.lang.String r15 = "from"
            int r15 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r6, r15)     // Catch:{ all -> 0x027c }
            java.lang.String r3 = "ruleIndex"
            int r3 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r6, r3)     // Catch:{ all -> 0x027c }
            java.lang.String r4 = "evaluatedAttributes"
            int r4 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r6, r4)     // Catch:{ all -> 0x027c }
            java.lang.String r5 = "evaluatedFlags"
            int r5 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r6, r5)     // Catch:{ all -> 0x027c }
            java.lang.String r1 = "error"
            int r1 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r6, r1)     // Catch:{ all -> 0x027c }
            r16 = r2
            java.lang.String r2 = "variationName"
            int r2 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r6, r2)     // Catch:{ all -> 0x027a }
            r17 = r13
            java.lang.String r13 = "flagType"
            int r13 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r6, r13)     // Catch:{ all -> 0x027a }
            r18 = r12
            java.lang.String r12 = "flagEnabled"
            int r12 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r6, r12)     // Catch:{ all -> 0x027a }
            r19 = r11
            java.lang.String r11 = "trackerServices"
            int r11 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r6, r11)     // Catch:{ all -> 0x027a }
            r20 = r10
            java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ all -> 0x027a }
            r21 = r9
            int r9 = r6.getCount()     // Catch:{ all -> 0x027a }
            r10.<init>(r9)     // Catch:{ all -> 0x027a }
        L_0x00a2:
            boolean r9 = r6.moveToNext()     // Catch:{ all -> 0x027a }
            if (r9 == 0) goto L_0x0273
            boolean r9 = r6.isNull(r14)     // Catch:{ all -> 0x027a }
            if (r9 == 0) goto L_0x00d2
            boolean r9 = r6.isNull(r15)     // Catch:{ all -> 0x027a }
            if (r9 == 0) goto L_0x00d2
            boolean r9 = r6.isNull(r3)     // Catch:{ all -> 0x027a }
            if (r9 == 0) goto L_0x00d2
            boolean r9 = r6.isNull(r4)     // Catch:{ all -> 0x027a }
            if (r9 == 0) goto L_0x00d2
            boolean r9 = r6.isNull(r5)     // Catch:{ all -> 0x027a }
            if (r9 == 0) goto L_0x00d2
            boolean r9 = r6.isNull(r1)     // Catch:{ all -> 0x027a }
            if (r9 != 0) goto L_0x00cd
            goto L_0x00d2
        L_0x00cd:
            r23 = r14
            r9 = 0
            goto L_0x013f
        L_0x00d2:
            fwfd.com.fwfsdk.model.api.FWFExplanation r9 = new fwfd.com.fwfsdk.model.api.FWFExplanation     // Catch:{ all -> 0x027a }
            r9.<init>()     // Catch:{ all -> 0x027a }
            boolean r22 = r6.isNull(r14)     // Catch:{ all -> 0x027a }
            if (r22 == 0) goto L_0x00e1
            r23 = r14
            r14 = 0
            goto L_0x00e9
        L_0x00e1:
            java.lang.String r22 = r6.getString(r14)     // Catch:{ all -> 0x027a }
            r23 = r14
            r14 = r22
        L_0x00e9:
            r9.setKind(r14)     // Catch:{ all -> 0x027a }
            boolean r14 = r6.isNull(r15)     // Catch:{ all -> 0x027a }
            if (r14 == 0) goto L_0x00f4
            r14 = 0
            goto L_0x00f8
        L_0x00f4:
            java.lang.String r14 = r6.getString(r15)     // Catch:{ all -> 0x027a }
        L_0x00f8:
            r9.setFrom(r14)     // Catch:{ all -> 0x027a }
            boolean r14 = r6.isNull(r3)     // Catch:{ all -> 0x027a }
            if (r14 == 0) goto L_0x0103
            r14 = 0
            goto L_0x0107
        L_0x0103:
            java.lang.String r14 = r6.getString(r3)     // Catch:{ all -> 0x027a }
        L_0x0107:
            r9.setRuleIndex(r14)     // Catch:{ all -> 0x027a }
            boolean r14 = r6.isNull(r4)     // Catch:{ all -> 0x027a }
            if (r14 == 0) goto L_0x0112
            r14 = 0
            goto L_0x0116
        L_0x0112:
            java.lang.String r14 = r6.getString(r4)     // Catch:{ all -> 0x027a }
        L_0x0116:
            java.util.List r14 = fwfd.com.fwfsdk.util.FWFStringListConverter.fromString(r14)     // Catch:{ all -> 0x027a }
            r9.setEvaluatedAttributes(r14)     // Catch:{ all -> 0x027a }
            boolean r14 = r6.isNull(r5)     // Catch:{ all -> 0x027a }
            if (r14 == 0) goto L_0x0125
            r14 = 0
            goto L_0x0129
        L_0x0125:
            java.lang.String r14 = r6.getString(r5)     // Catch:{ all -> 0x027a }
        L_0x0129:
            java.util.List r14 = fwfd.com.fwfsdk.util.FWFStringListConverter.fromString(r14)     // Catch:{ all -> 0x027a }
            r9.setEvaluatedFlags(r14)     // Catch:{ all -> 0x027a }
            boolean r14 = r6.isNull(r1)     // Catch:{ all -> 0x027a }
            if (r14 == 0) goto L_0x0138
            r14 = 0
            goto L_0x013c
        L_0x0138:
            java.lang.String r14 = r6.getString(r1)     // Catch:{ all -> 0x027a }
        L_0x013c:
            r9.setError(r14)     // Catch:{ all -> 0x027a }
        L_0x013f:
            boolean r14 = r6.isNull(r2)     // Catch:{ all -> 0x027a }
            if (r14 == 0) goto L_0x015c
            boolean r14 = r6.isNull(r13)     // Catch:{ all -> 0x027a }
            if (r14 == 0) goto L_0x015c
            boolean r14 = r6.isNull(r12)     // Catch:{ all -> 0x027a }
            if (r14 == 0) goto L_0x015c
            boolean r14 = r6.isNull(r11)     // Catch:{ all -> 0x027a }
            if (r14 != 0) goto L_0x0158
            goto L_0x015c
        L_0x0158:
            r24 = r1
            r14 = 0
            goto L_0x01bf
        L_0x015c:
            fwfd.com.fwfsdk.model.api.FWFTrackInfo r14 = new fwfd.com.fwfsdk.model.api.FWFTrackInfo     // Catch:{ all -> 0x027a }
            r14.<init>()     // Catch:{ all -> 0x027a }
            boolean r22 = r6.isNull(r2)     // Catch:{ all -> 0x027a }
            if (r22 == 0) goto L_0x016c
            r24 = r1
            r22 = 0
            goto L_0x0172
        L_0x016c:
            byte[] r22 = r6.getBlob(r2)     // Catch:{ all -> 0x027a }
            r24 = r1
        L_0x0172:
            java.lang.Object r1 = fwfd.com.fwfsdk.util.FWFAnyConverter.toObject(r22)     // Catch:{ all -> 0x027a }
            r14.setVariationName(r1)     // Catch:{ all -> 0x027a }
            boolean r1 = r6.isNull(r13)     // Catch:{ all -> 0x027a }
            if (r1 == 0) goto L_0x0181
            r1 = 0
            goto L_0x0185
        L_0x0181:
            java.lang.String r1 = r6.getString(r13)     // Catch:{ all -> 0x027a }
        L_0x0185:
            r14.setFlagType(r1)     // Catch:{ all -> 0x027a }
            boolean r1 = r6.isNull(r12)     // Catch:{ all -> 0x027a }
            if (r1 == 0) goto L_0x0190
            r1 = 0
            goto L_0x0198
        L_0x0190:
            int r1 = r6.getInt(r12)     // Catch:{ all -> 0x027a }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x027a }
        L_0x0198:
            if (r1 != 0) goto L_0x019c
            r1 = 0
            goto L_0x01a9
        L_0x019c:
            int r1 = r1.intValue()     // Catch:{ all -> 0x027a }
            if (r1 == 0) goto L_0x01a4
            r1 = 1
            goto L_0x01a5
        L_0x01a4:
            r1 = 0
        L_0x01a5:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch:{ all -> 0x027a }
        L_0x01a9:
            r14.setFlagEnabled(r1)     // Catch:{ all -> 0x027a }
            boolean r1 = r6.isNull(r11)     // Catch:{ all -> 0x027a }
            if (r1 == 0) goto L_0x01b4
            r1 = 0
            goto L_0x01b8
        L_0x01b4:
            java.lang.String r1 = r6.getString(r11)     // Catch:{ all -> 0x027a }
        L_0x01b8:
            java.util.List r1 = fwfd.com.fwfsdk.util.FWFStringListConverter.fromString(r1)     // Catch:{ all -> 0x027a }
            r14.setTrackerServices(r1)     // Catch:{ all -> 0x027a }
        L_0x01bf:
            fwfd.com.fwfsdk.model.db.FWFFeature r1 = new fwfd.com.fwfsdk.model.db.FWFFeature     // Catch:{ all -> 0x027a }
            r1.<init>()     // Catch:{ all -> 0x027a }
            boolean r22 = r6.isNull(r0)     // Catch:{ all -> 0x027a }
            if (r22 == 0) goto L_0x01ce
            r25 = r0
            r0 = 0
            goto L_0x01d6
        L_0x01ce:
            java.lang.String r22 = r6.getString(r0)     // Catch:{ all -> 0x027a }
            r25 = r0
            r0 = r22
        L_0x01d6:
            r1.setKey(r0)     // Catch:{ all -> 0x027a }
            boolean r0 = r6.isNull(r7)     // Catch:{ all -> 0x027a }
            if (r0 == 0) goto L_0x01e1
            r0 = 0
            goto L_0x01e5
        L_0x01e1:
            byte[] r0 = r6.getBlob(r7)     // Catch:{ all -> 0x027a }
        L_0x01e5:
            java.lang.Object r0 = fwfd.com.fwfsdk.util.FWFAnyConverter.toObject(r0)     // Catch:{ all -> 0x027a }
            r1.setVariation(r0)     // Catch:{ all -> 0x027a }
            int r0 = r6.getInt(r8)     // Catch:{ all -> 0x027a }
            if (r0 == 0) goto L_0x01f4
            r0 = 1
            goto L_0x01f5
        L_0x01f4:
            r0 = 0
        L_0x01f5:
            r1.setAbTest(r0)     // Catch:{ all -> 0x027a }
            r0 = r21
            boolean r21 = r6.isNull(r0)     // Catch:{ all -> 0x027a }
            if (r21 == 0) goto L_0x0204
            r22 = r0
            r0 = 0
            goto L_0x020c
        L_0x0204:
            java.lang.String r21 = r6.getString(r0)     // Catch:{ all -> 0x027a }
            r22 = r0
            r0 = r21
        L_0x020c:
            r1.setAccessToken(r0)     // Catch:{ all -> 0x027a }
            r21 = r2
            r0 = r20
            r20 = r3
            long r2 = r6.getLong(r0)     // Catch:{ all -> 0x027a }
            r1.setDate(r2)     // Catch:{ all -> 0x027a }
            r2 = r19
            boolean r3 = r6.isNull(r2)     // Catch:{ all -> 0x027a }
            if (r3 == 0) goto L_0x0226
            r3 = 0
            goto L_0x022a
        L_0x0226:
            java.lang.String r3 = r6.getString(r2)     // Catch:{ all -> 0x027a }
        L_0x022a:
            r1.setRelevantContext(r3)     // Catch:{ all -> 0x027a }
            r3 = r18
            r18 = r0
            int r0 = r6.getInt(r3)     // Catch:{ all -> 0x027a }
            r1.setSubscribe(r0)     // Catch:{ all -> 0x027a }
            r0 = r17
            boolean r17 = r6.isNull(r0)     // Catch:{ all -> 0x027a }
            if (r17 == 0) goto L_0x0245
            r19 = r0
            r17 = 0
            goto L_0x024b
        L_0x0245:
            java.lang.String r17 = r6.getString(r0)     // Catch:{ all -> 0x027a }
            r19 = r0
        L_0x024b:
            java.util.Map r0 = fwfd.com.fwfsdk.util.FWFMapConverter.fromString(r17)     // Catch:{ all -> 0x027a }
            r1.setHoldoutsEvaluations(r0)     // Catch:{ all -> 0x027a }
            r1.setExplanation(r9)     // Catch:{ all -> 0x027a }
            r1.setTrackInfo(r14)     // Catch:{ all -> 0x027a }
            r10.add(r1)     // Catch:{ all -> 0x027a }
            r17 = r19
            r14 = r23
            r1 = r24
            r0 = r25
            r19 = r2
            r2 = r21
            r21 = r22
            r26 = r18
            r18 = r3
            r3 = r20
            r20 = r26
            goto L_0x00a2
        L_0x0273:
            r6.close()
            r16.release()
            return r10
        L_0x027a:
            r0 = move-exception
            goto L_0x027f
        L_0x027c:
            r0 = move-exception
            r16 = r2
        L_0x027f:
            r6.close()
            r16.release()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fwfd.com.fwfsdk.model.dao.FWFDBDAO_Impl.getAllFlagsFromEnvironment(java.lang.String):java.util.List");
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x01eb A[Catch:{ all -> 0x023c }] */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x01ed A[Catch:{ all -> 0x023c }] */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0205 A[Catch:{ all -> 0x023c }] */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0207 A[Catch:{ all -> 0x023c }] */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x021f A[Catch:{ all -> 0x023c }] */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0221 A[Catch:{ all -> 0x023c }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0151 A[Catch:{ all -> 0x023c }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0152 A[Catch:{ all -> 0x023c }] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x01bd A[Catch:{ all -> 0x023c }] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01bf A[Catch:{ all -> 0x023c }] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x01cc A[Catch:{ all -> 0x023c }] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x01ce A[Catch:{ all -> 0x023c }] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x01df A[Catch:{ all -> 0x023c }] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x01e1 A[Catch:{ all -> 0x023c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public fwfd.com.fwfsdk.model.db.FWFFeature getFlagById(java.lang.String r23, java.lang.String r24) {
        /*
            r22 = this;
            r1 = r22
            r0 = r23
            r2 = r24
            java.lang.String r3 = "SELECT * FROM FWFFeature WHERE `key` = ? AND accessToken = ? LIMIT 1"
            r4 = 2
            androidx.room.RoomSQLiteQuery r3 = androidx.room.RoomSQLiteQuery.acquire(r3, r4)
            r5 = 1
            if (r0 != 0) goto L_0x0014
            r3.bindNull(r5)
            goto L_0x0017
        L_0x0014:
            r3.bindString(r5, r0)
        L_0x0017:
            if (r2 != 0) goto L_0x001d
            r3.bindNull(r4)
            goto L_0x0020
        L_0x001d:
            r3.bindString(r4, r2)
        L_0x0020:
            androidx.room.RoomDatabase r0 = r1.__db
            r0.assertNotSuspendingTransaction()
            androidx.room.RoomDatabase r0 = r1.__db
            r2 = 0
            r4 = 0
            android.database.Cursor r6 = androidx.room.util.DBUtil.query(r0, r3, r2, r4)
            java.lang.String r0 = "key"
            int r0 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r6, r0)     // Catch:{ all -> 0x023e }
            java.lang.String r7 = "variation"
            int r7 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r6, r7)     // Catch:{ all -> 0x023e }
            java.lang.String r8 = "abTest"
            int r8 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r6, r8)     // Catch:{ all -> 0x023e }
            java.lang.String r9 = "accessToken"
            int r9 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r6, r9)     // Catch:{ all -> 0x023e }
            java.lang.String r10 = "date"
            int r10 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r6, r10)     // Catch:{ all -> 0x023e }
            java.lang.String r11 = "relevantContext"
            int r11 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r6, r11)     // Catch:{ all -> 0x023e }
            java.lang.String r12 = "subscribe"
            int r12 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r6, r12)     // Catch:{ all -> 0x023e }
            java.lang.String r13 = "holdoutsEvaluations"
            int r13 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r6, r13)     // Catch:{ all -> 0x023e }
            java.lang.String r14 = "kind"
            int r14 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r6, r14)     // Catch:{ all -> 0x023e }
            java.lang.String r15 = "from"
            int r15 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r6, r15)     // Catch:{ all -> 0x023e }
            java.lang.String r2 = "ruleIndex"
            int r2 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r6, r2)     // Catch:{ all -> 0x023e }
            java.lang.String r4 = "evaluatedAttributes"
            int r4 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r6, r4)     // Catch:{ all -> 0x023e }
            java.lang.String r5 = "evaluatedFlags"
            int r5 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r6, r5)     // Catch:{ all -> 0x023e }
            java.lang.String r1 = "error"
            int r1 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r6, r1)     // Catch:{ all -> 0x023e }
            r16 = r3
            java.lang.String r3 = "variationName"
            int r3 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r6, r3)     // Catch:{ all -> 0x023c }
            r17 = r13
            java.lang.String r13 = "flagType"
            int r13 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r6, r13)     // Catch:{ all -> 0x023c }
            r18 = r12
            java.lang.String r12 = "flagEnabled"
            int r12 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r6, r12)     // Catch:{ all -> 0x023c }
            r19 = r11
            java.lang.String r11 = "trackerServices"
            int r11 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r6, r11)     // Catch:{ all -> 0x023c }
            boolean r20 = r6.moveToFirst()     // Catch:{ all -> 0x023c }
            if (r20 == 0) goto L_0x0234
            boolean r20 = r6.isNull(r14)     // Catch:{ all -> 0x023c }
            if (r20 == 0) goto L_0x00d0
            boolean r20 = r6.isNull(r15)     // Catch:{ all -> 0x023c }
            if (r20 == 0) goto L_0x00d0
            boolean r20 = r6.isNull(r2)     // Catch:{ all -> 0x023c }
            if (r20 == 0) goto L_0x00d0
            boolean r20 = r6.isNull(r4)     // Catch:{ all -> 0x023c }
            if (r20 == 0) goto L_0x00d0
            boolean r20 = r6.isNull(r5)     // Catch:{ all -> 0x023c }
            if (r20 == 0) goto L_0x00d0
            boolean r20 = r6.isNull(r1)     // Catch:{ all -> 0x023c }
            if (r20 != 0) goto L_0x00cc
            goto L_0x00d0
        L_0x00cc:
            r20 = r10
            r10 = 0
            goto L_0x0139
        L_0x00d0:
            r20 = r10
            fwfd.com.fwfsdk.model.api.FWFExplanation r10 = new fwfd.com.fwfsdk.model.api.FWFExplanation     // Catch:{ all -> 0x023c }
            r10.<init>()     // Catch:{ all -> 0x023c }
            boolean r21 = r6.isNull(r14)     // Catch:{ all -> 0x023c }
            if (r21 == 0) goto L_0x00df
            r14 = 0
            goto L_0x00e3
        L_0x00df:
            java.lang.String r14 = r6.getString(r14)     // Catch:{ all -> 0x023c }
        L_0x00e3:
            r10.setKind(r14)     // Catch:{ all -> 0x023c }
            boolean r14 = r6.isNull(r15)     // Catch:{ all -> 0x023c }
            if (r14 == 0) goto L_0x00ee
            r14 = 0
            goto L_0x00f2
        L_0x00ee:
            java.lang.String r14 = r6.getString(r15)     // Catch:{ all -> 0x023c }
        L_0x00f2:
            r10.setFrom(r14)     // Catch:{ all -> 0x023c }
            boolean r14 = r6.isNull(r2)     // Catch:{ all -> 0x023c }
            if (r14 == 0) goto L_0x00fd
            r2 = 0
            goto L_0x0101
        L_0x00fd:
            java.lang.String r2 = r6.getString(r2)     // Catch:{ all -> 0x023c }
        L_0x0101:
            r10.setRuleIndex(r2)     // Catch:{ all -> 0x023c }
            boolean r2 = r6.isNull(r4)     // Catch:{ all -> 0x023c }
            if (r2 == 0) goto L_0x010c
            r2 = 0
            goto L_0x0110
        L_0x010c:
            java.lang.String r2 = r6.getString(r4)     // Catch:{ all -> 0x023c }
        L_0x0110:
            java.util.List r2 = fwfd.com.fwfsdk.util.FWFStringListConverter.fromString(r2)     // Catch:{ all -> 0x023c }
            r10.setEvaluatedAttributes(r2)     // Catch:{ all -> 0x023c }
            boolean r2 = r6.isNull(r5)     // Catch:{ all -> 0x023c }
            if (r2 == 0) goto L_0x011f
            r2 = 0
            goto L_0x0123
        L_0x011f:
            java.lang.String r2 = r6.getString(r5)     // Catch:{ all -> 0x023c }
        L_0x0123:
            java.util.List r2 = fwfd.com.fwfsdk.util.FWFStringListConverter.fromString(r2)     // Catch:{ all -> 0x023c }
            r10.setEvaluatedFlags(r2)     // Catch:{ all -> 0x023c }
            boolean r2 = r6.isNull(r1)     // Catch:{ all -> 0x023c }
            if (r2 == 0) goto L_0x0132
            r1 = 0
            goto L_0x0136
        L_0x0132:
            java.lang.String r1 = r6.getString(r1)     // Catch:{ all -> 0x023c }
        L_0x0136:
            r10.setError(r1)     // Catch:{ all -> 0x023c }
        L_0x0139:
            boolean r1 = r6.isNull(r3)     // Catch:{ all -> 0x023c }
            if (r1 == 0) goto L_0x0154
            boolean r1 = r6.isNull(r13)     // Catch:{ all -> 0x023c }
            if (r1 == 0) goto L_0x0154
            boolean r1 = r6.isNull(r12)     // Catch:{ all -> 0x023c }
            if (r1 == 0) goto L_0x0154
            boolean r1 = r6.isNull(r11)     // Catch:{ all -> 0x023c }
            if (r1 != 0) goto L_0x0152
            goto L_0x0154
        L_0x0152:
            r1 = 0
            goto L_0x01b2
        L_0x0154:
            fwfd.com.fwfsdk.model.api.FWFTrackInfo r1 = new fwfd.com.fwfsdk.model.api.FWFTrackInfo     // Catch:{ all -> 0x023c }
            r1.<init>()     // Catch:{ all -> 0x023c }
            boolean r2 = r6.isNull(r3)     // Catch:{ all -> 0x023c }
            if (r2 == 0) goto L_0x0161
            r2 = 0
            goto L_0x0165
        L_0x0161:
            byte[] r2 = r6.getBlob(r3)     // Catch:{ all -> 0x023c }
        L_0x0165:
            java.lang.Object r2 = fwfd.com.fwfsdk.util.FWFAnyConverter.toObject(r2)     // Catch:{ all -> 0x023c }
            r1.setVariationName(r2)     // Catch:{ all -> 0x023c }
            boolean r2 = r6.isNull(r13)     // Catch:{ all -> 0x023c }
            if (r2 == 0) goto L_0x0174
            r2 = 0
            goto L_0x0178
        L_0x0174:
            java.lang.String r2 = r6.getString(r13)     // Catch:{ all -> 0x023c }
        L_0x0178:
            r1.setFlagType(r2)     // Catch:{ all -> 0x023c }
            boolean r2 = r6.isNull(r12)     // Catch:{ all -> 0x023c }
            if (r2 == 0) goto L_0x0183
            r2 = 0
            goto L_0x018b
        L_0x0183:
            int r2 = r6.getInt(r12)     // Catch:{ all -> 0x023c }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x023c }
        L_0x018b:
            if (r2 != 0) goto L_0x018f
            r2 = 0
            goto L_0x019c
        L_0x018f:
            int r2 = r2.intValue()     // Catch:{ all -> 0x023c }
            if (r2 == 0) goto L_0x0197
            r2 = 1
            goto L_0x0198
        L_0x0197:
            r2 = 0
        L_0x0198:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)     // Catch:{ all -> 0x023c }
        L_0x019c:
            r1.setFlagEnabled(r2)     // Catch:{ all -> 0x023c }
            boolean r2 = r6.isNull(r11)     // Catch:{ all -> 0x023c }
            if (r2 == 0) goto L_0x01a7
            r2 = 0
            goto L_0x01ab
        L_0x01a7:
            java.lang.String r2 = r6.getString(r11)     // Catch:{ all -> 0x023c }
        L_0x01ab:
            java.util.List r2 = fwfd.com.fwfsdk.util.FWFStringListConverter.fromString(r2)     // Catch:{ all -> 0x023c }
            r1.setTrackerServices(r2)     // Catch:{ all -> 0x023c }
        L_0x01b2:
            fwfd.com.fwfsdk.model.db.FWFFeature r2 = new fwfd.com.fwfsdk.model.db.FWFFeature     // Catch:{ all -> 0x023c }
            r2.<init>()     // Catch:{ all -> 0x023c }
            boolean r3 = r6.isNull(r0)     // Catch:{ all -> 0x023c }
            if (r3 == 0) goto L_0x01bf
            r0 = 0
            goto L_0x01c3
        L_0x01bf:
            java.lang.String r0 = r6.getString(r0)     // Catch:{ all -> 0x023c }
        L_0x01c3:
            r2.setKey(r0)     // Catch:{ all -> 0x023c }
            boolean r0 = r6.isNull(r7)     // Catch:{ all -> 0x023c }
            if (r0 == 0) goto L_0x01ce
            r0 = 0
            goto L_0x01d2
        L_0x01ce:
            byte[] r0 = r6.getBlob(r7)     // Catch:{ all -> 0x023c }
        L_0x01d2:
            java.lang.Object r0 = fwfd.com.fwfsdk.util.FWFAnyConverter.toObject(r0)     // Catch:{ all -> 0x023c }
            r2.setVariation(r0)     // Catch:{ all -> 0x023c }
            int r0 = r6.getInt(r8)     // Catch:{ all -> 0x023c }
            if (r0 == 0) goto L_0x01e1
            r5 = 1
            goto L_0x01e2
        L_0x01e1:
            r5 = 0
        L_0x01e2:
            r2.setAbTest(r5)     // Catch:{ all -> 0x023c }
            boolean r0 = r6.isNull(r9)     // Catch:{ all -> 0x023c }
            if (r0 == 0) goto L_0x01ed
            r0 = 0
            goto L_0x01f1
        L_0x01ed:
            java.lang.String r0 = r6.getString(r9)     // Catch:{ all -> 0x023c }
        L_0x01f1:
            r2.setAccessToken(r0)     // Catch:{ all -> 0x023c }
            r0 = r20
            long r3 = r6.getLong(r0)     // Catch:{ all -> 0x023c }
            r2.setDate(r3)     // Catch:{ all -> 0x023c }
            r0 = r19
            boolean r3 = r6.isNull(r0)     // Catch:{ all -> 0x023c }
            if (r3 == 0) goto L_0x0207
            r0 = 0
            goto L_0x020b
        L_0x0207:
            java.lang.String r0 = r6.getString(r0)     // Catch:{ all -> 0x023c }
        L_0x020b:
            r2.setRelevantContext(r0)     // Catch:{ all -> 0x023c }
            r0 = r18
            int r0 = r6.getInt(r0)     // Catch:{ all -> 0x023c }
            r2.setSubscribe(r0)     // Catch:{ all -> 0x023c }
            r0 = r17
            boolean r3 = r6.isNull(r0)     // Catch:{ all -> 0x023c }
            if (r3 == 0) goto L_0x0221
            r4 = 0
            goto L_0x0225
        L_0x0221:
            java.lang.String r4 = r6.getString(r0)     // Catch:{ all -> 0x023c }
        L_0x0225:
            java.util.Map r0 = fwfd.com.fwfsdk.util.FWFMapConverter.fromString(r4)     // Catch:{ all -> 0x023c }
            r2.setHoldoutsEvaluations(r0)     // Catch:{ all -> 0x023c }
            r2.setExplanation(r10)     // Catch:{ all -> 0x023c }
            r2.setTrackInfo(r1)     // Catch:{ all -> 0x023c }
            r4 = r2
            goto L_0x0235
        L_0x0234:
            r4 = 0
        L_0x0235:
            r6.close()
            r16.release()
            return r4
        L_0x023c:
            r0 = move-exception
            goto L_0x0241
        L_0x023e:
            r0 = move-exception
            r16 = r3
        L_0x0241:
            r6.close()
            r16.release()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fwfd.com.fwfsdk.model.dao.FWFDBDAO_Impl.getFlagById(java.lang.String, java.lang.String):fwfd.com.fwfsdk.model.db.FWFFeature");
    }

    public List<FWFFlagKey> getFlagKeys(String str) {
        String str2;
        String str3;
        String str4;
        Integer num;
        Boolean bool;
        Long l11;
        boolean z11;
        String str5 = str;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM FWFFlagKey WHERE token = ?", 1);
        if (str5 == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str5);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "key");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, LegacyTokenLocalDataSourceImpl.KEY);
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, FWFConstants.EXPLANATION_TYPE_KIND);
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "enabled");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "date");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                if (query.isNull(columnIndexOrThrow)) {
                    str2 = null;
                } else {
                    str2 = query.getString(columnIndexOrThrow);
                }
                if (query.isNull(columnIndexOrThrow2)) {
                    str3 = null;
                } else {
                    str3 = query.getString(columnIndexOrThrow2);
                }
                if (query.isNull(columnIndexOrThrow3)) {
                    str4 = null;
                } else {
                    str4 = query.getString(columnIndexOrThrow3);
                }
                if (query.isNull(columnIndexOrThrow4)) {
                    num = null;
                } else {
                    num = Integer.valueOf(query.getInt(columnIndexOrThrow4));
                }
                if (num == null) {
                    bool = null;
                } else {
                    if (num.intValue() != 0) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    bool = Boolean.valueOf(z11);
                }
                if (query.isNull(columnIndexOrThrow5)) {
                    l11 = null;
                } else {
                    l11 = Long.valueOf(query.getLong(columnIndexOrThrow5));
                }
                arrayList.add(new FWFFlagKey(str2, str3, str4, bool, l11));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x022c A[Catch:{ all -> 0x02b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x022e A[Catch:{ all -> 0x02b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x023a A[Catch:{ all -> 0x02b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x023e A[Catch:{ all -> 0x02b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x025e A[Catch:{ all -> 0x02b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x0260 A[Catch:{ all -> 0x02b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x027a A[Catch:{ all -> 0x02b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x027f A[Catch:{ all -> 0x02b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0191 A[Catch:{ all -> 0x02b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0192 A[Catch:{ all -> 0x02b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0204 A[Catch:{ all -> 0x02b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0208 A[Catch:{ all -> 0x02b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0219 A[Catch:{ all -> 0x02b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x021b A[Catch:{ all -> 0x02b4 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<fwfd.com.fwfsdk.model.db.FWFFeature> getFlagsById(java.util.List<java.lang.String> r28, java.lang.String r29) {
        /*
            r27 = this;
            r1 = r27
            r0 = r29
            java.lang.StringBuilder r2 = androidx.room.util.StringUtil.newStringBuilder()
            java.lang.String r3 = "SELECT * FROM FWFFeature WHERE `key` IN ("
            r2.append(r3)
            int r3 = r28.size()
            androidx.room.util.StringUtil.appendPlaceholders(r2, r3)
            java.lang.String r4 = ") AND accessToken = "
            r2.append(r4)
            java.lang.String r4 = "?"
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            r4 = 1
            int r3 = r3 + r4
            androidx.room.RoomSQLiteQuery r2 = androidx.room.RoomSQLiteQuery.acquire(r2, r3)
            java.util.Iterator r5 = r28.iterator()
            r6 = r4
        L_0x002d:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L_0x0045
            java.lang.Object r7 = r5.next()
            java.lang.String r7 = (java.lang.String) r7
            if (r7 != 0) goto L_0x003f
            r2.bindNull(r6)
            goto L_0x0042
        L_0x003f:
            r2.bindString(r6, r7)
        L_0x0042:
            int r6 = r6 + 1
            goto L_0x002d
        L_0x0045:
            if (r0 != 0) goto L_0x004b
            r2.bindNull(r3)
            goto L_0x004e
        L_0x004b:
            r2.bindString(r3, r0)
        L_0x004e:
            androidx.room.RoomDatabase r0 = r1.__db
            r0.assertNotSuspendingTransaction()
            androidx.room.RoomDatabase r0 = r1.__db
            r3 = 0
            r5 = 0
            android.database.Cursor r6 = androidx.room.util.DBUtil.query(r0, r2, r3, r5)
            java.lang.String r0 = "key"
            int r0 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r6, r0)     // Catch:{ all -> 0x02b6 }
            java.lang.String r7 = "variation"
            int r7 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r6, r7)     // Catch:{ all -> 0x02b6 }
            java.lang.String r8 = "abTest"
            int r8 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r6, r8)     // Catch:{ all -> 0x02b6 }
            java.lang.String r9 = "accessToken"
            int r9 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r6, r9)     // Catch:{ all -> 0x02b6 }
            java.lang.String r10 = "date"
            int r10 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r6, r10)     // Catch:{ all -> 0x02b6 }
            java.lang.String r11 = "relevantContext"
            int r11 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r6, r11)     // Catch:{ all -> 0x02b6 }
            java.lang.String r12 = "subscribe"
            int r12 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r6, r12)     // Catch:{ all -> 0x02b6 }
            java.lang.String r13 = "holdoutsEvaluations"
            int r13 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r6, r13)     // Catch:{ all -> 0x02b6 }
            java.lang.String r14 = "kind"
            int r14 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r6, r14)     // Catch:{ all -> 0x02b6 }
            java.lang.String r15 = "from"
            int r15 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r6, r15)     // Catch:{ all -> 0x02b6 }
            java.lang.String r3 = "ruleIndex"
            int r3 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r6, r3)     // Catch:{ all -> 0x02b6 }
            java.lang.String r4 = "evaluatedAttributes"
            int r4 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r6, r4)     // Catch:{ all -> 0x02b6 }
            java.lang.String r5 = "evaluatedFlags"
            int r5 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r6, r5)     // Catch:{ all -> 0x02b6 }
            java.lang.String r1 = "error"
            int r1 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r6, r1)     // Catch:{ all -> 0x02b6 }
            r16 = r2
            java.lang.String r2 = "variationName"
            int r2 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r6, r2)     // Catch:{ all -> 0x02b4 }
            r17 = r13
            java.lang.String r13 = "flagType"
            int r13 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r6, r13)     // Catch:{ all -> 0x02b4 }
            r18 = r12
            java.lang.String r12 = "flagEnabled"
            int r12 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r6, r12)     // Catch:{ all -> 0x02b4 }
            r19 = r11
            java.lang.String r11 = "trackerServices"
            int r11 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r6, r11)     // Catch:{ all -> 0x02b4 }
            r20 = r10
            java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ all -> 0x02b4 }
            r21 = r9
            int r9 = r6.getCount()     // Catch:{ all -> 0x02b4 }
            r10.<init>(r9)     // Catch:{ all -> 0x02b4 }
        L_0x00dc:
            boolean r9 = r6.moveToNext()     // Catch:{ all -> 0x02b4 }
            if (r9 == 0) goto L_0x02ad
            boolean r9 = r6.isNull(r14)     // Catch:{ all -> 0x02b4 }
            if (r9 == 0) goto L_0x010c
            boolean r9 = r6.isNull(r15)     // Catch:{ all -> 0x02b4 }
            if (r9 == 0) goto L_0x010c
            boolean r9 = r6.isNull(r3)     // Catch:{ all -> 0x02b4 }
            if (r9 == 0) goto L_0x010c
            boolean r9 = r6.isNull(r4)     // Catch:{ all -> 0x02b4 }
            if (r9 == 0) goto L_0x010c
            boolean r9 = r6.isNull(r5)     // Catch:{ all -> 0x02b4 }
            if (r9 == 0) goto L_0x010c
            boolean r9 = r6.isNull(r1)     // Catch:{ all -> 0x02b4 }
            if (r9 != 0) goto L_0x0107
            goto L_0x010c
        L_0x0107:
            r23 = r14
            r9 = 0
            goto L_0x0179
        L_0x010c:
            fwfd.com.fwfsdk.model.api.FWFExplanation r9 = new fwfd.com.fwfsdk.model.api.FWFExplanation     // Catch:{ all -> 0x02b4 }
            r9.<init>()     // Catch:{ all -> 0x02b4 }
            boolean r22 = r6.isNull(r14)     // Catch:{ all -> 0x02b4 }
            if (r22 == 0) goto L_0x011b
            r23 = r14
            r14 = 0
            goto L_0x0123
        L_0x011b:
            java.lang.String r22 = r6.getString(r14)     // Catch:{ all -> 0x02b4 }
            r23 = r14
            r14 = r22
        L_0x0123:
            r9.setKind(r14)     // Catch:{ all -> 0x02b4 }
            boolean r14 = r6.isNull(r15)     // Catch:{ all -> 0x02b4 }
            if (r14 == 0) goto L_0x012e
            r14 = 0
            goto L_0x0132
        L_0x012e:
            java.lang.String r14 = r6.getString(r15)     // Catch:{ all -> 0x02b4 }
        L_0x0132:
            r9.setFrom(r14)     // Catch:{ all -> 0x02b4 }
            boolean r14 = r6.isNull(r3)     // Catch:{ all -> 0x02b4 }
            if (r14 == 0) goto L_0x013d
            r14 = 0
            goto L_0x0141
        L_0x013d:
            java.lang.String r14 = r6.getString(r3)     // Catch:{ all -> 0x02b4 }
        L_0x0141:
            r9.setRuleIndex(r14)     // Catch:{ all -> 0x02b4 }
            boolean r14 = r6.isNull(r4)     // Catch:{ all -> 0x02b4 }
            if (r14 == 0) goto L_0x014c
            r14 = 0
            goto L_0x0150
        L_0x014c:
            java.lang.String r14 = r6.getString(r4)     // Catch:{ all -> 0x02b4 }
        L_0x0150:
            java.util.List r14 = fwfd.com.fwfsdk.util.FWFStringListConverter.fromString(r14)     // Catch:{ all -> 0x02b4 }
            r9.setEvaluatedAttributes(r14)     // Catch:{ all -> 0x02b4 }
            boolean r14 = r6.isNull(r5)     // Catch:{ all -> 0x02b4 }
            if (r14 == 0) goto L_0x015f
            r14 = 0
            goto L_0x0163
        L_0x015f:
            java.lang.String r14 = r6.getString(r5)     // Catch:{ all -> 0x02b4 }
        L_0x0163:
            java.util.List r14 = fwfd.com.fwfsdk.util.FWFStringListConverter.fromString(r14)     // Catch:{ all -> 0x02b4 }
            r9.setEvaluatedFlags(r14)     // Catch:{ all -> 0x02b4 }
            boolean r14 = r6.isNull(r1)     // Catch:{ all -> 0x02b4 }
            if (r14 == 0) goto L_0x0172
            r14 = 0
            goto L_0x0176
        L_0x0172:
            java.lang.String r14 = r6.getString(r1)     // Catch:{ all -> 0x02b4 }
        L_0x0176:
            r9.setError(r14)     // Catch:{ all -> 0x02b4 }
        L_0x0179:
            boolean r14 = r6.isNull(r2)     // Catch:{ all -> 0x02b4 }
            if (r14 == 0) goto L_0x0196
            boolean r14 = r6.isNull(r13)     // Catch:{ all -> 0x02b4 }
            if (r14 == 0) goto L_0x0196
            boolean r14 = r6.isNull(r12)     // Catch:{ all -> 0x02b4 }
            if (r14 == 0) goto L_0x0196
            boolean r14 = r6.isNull(r11)     // Catch:{ all -> 0x02b4 }
            if (r14 != 0) goto L_0x0192
            goto L_0x0196
        L_0x0192:
            r24 = r1
            r14 = 0
            goto L_0x01f9
        L_0x0196:
            fwfd.com.fwfsdk.model.api.FWFTrackInfo r14 = new fwfd.com.fwfsdk.model.api.FWFTrackInfo     // Catch:{ all -> 0x02b4 }
            r14.<init>()     // Catch:{ all -> 0x02b4 }
            boolean r22 = r6.isNull(r2)     // Catch:{ all -> 0x02b4 }
            if (r22 == 0) goto L_0x01a6
            r24 = r1
            r22 = 0
            goto L_0x01ac
        L_0x01a6:
            byte[] r22 = r6.getBlob(r2)     // Catch:{ all -> 0x02b4 }
            r24 = r1
        L_0x01ac:
            java.lang.Object r1 = fwfd.com.fwfsdk.util.FWFAnyConverter.toObject(r22)     // Catch:{ all -> 0x02b4 }
            r14.setVariationName(r1)     // Catch:{ all -> 0x02b4 }
            boolean r1 = r6.isNull(r13)     // Catch:{ all -> 0x02b4 }
            if (r1 == 0) goto L_0x01bb
            r1 = 0
            goto L_0x01bf
        L_0x01bb:
            java.lang.String r1 = r6.getString(r13)     // Catch:{ all -> 0x02b4 }
        L_0x01bf:
            r14.setFlagType(r1)     // Catch:{ all -> 0x02b4 }
            boolean r1 = r6.isNull(r12)     // Catch:{ all -> 0x02b4 }
            if (r1 == 0) goto L_0x01ca
            r1 = 0
            goto L_0x01d2
        L_0x01ca:
            int r1 = r6.getInt(r12)     // Catch:{ all -> 0x02b4 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x02b4 }
        L_0x01d2:
            if (r1 != 0) goto L_0x01d6
            r1 = 0
            goto L_0x01e3
        L_0x01d6:
            int r1 = r1.intValue()     // Catch:{ all -> 0x02b4 }
            if (r1 == 0) goto L_0x01de
            r1 = 1
            goto L_0x01df
        L_0x01de:
            r1 = 0
        L_0x01df:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch:{ all -> 0x02b4 }
        L_0x01e3:
            r14.setFlagEnabled(r1)     // Catch:{ all -> 0x02b4 }
            boolean r1 = r6.isNull(r11)     // Catch:{ all -> 0x02b4 }
            if (r1 == 0) goto L_0x01ee
            r1 = 0
            goto L_0x01f2
        L_0x01ee:
            java.lang.String r1 = r6.getString(r11)     // Catch:{ all -> 0x02b4 }
        L_0x01f2:
            java.util.List r1 = fwfd.com.fwfsdk.util.FWFStringListConverter.fromString(r1)     // Catch:{ all -> 0x02b4 }
            r14.setTrackerServices(r1)     // Catch:{ all -> 0x02b4 }
        L_0x01f9:
            fwfd.com.fwfsdk.model.db.FWFFeature r1 = new fwfd.com.fwfsdk.model.db.FWFFeature     // Catch:{ all -> 0x02b4 }
            r1.<init>()     // Catch:{ all -> 0x02b4 }
            boolean r22 = r6.isNull(r0)     // Catch:{ all -> 0x02b4 }
            if (r22 == 0) goto L_0x0208
            r25 = r0
            r0 = 0
            goto L_0x0210
        L_0x0208:
            java.lang.String r22 = r6.getString(r0)     // Catch:{ all -> 0x02b4 }
            r25 = r0
            r0 = r22
        L_0x0210:
            r1.setKey(r0)     // Catch:{ all -> 0x02b4 }
            boolean r0 = r6.isNull(r7)     // Catch:{ all -> 0x02b4 }
            if (r0 == 0) goto L_0x021b
            r0 = 0
            goto L_0x021f
        L_0x021b:
            byte[] r0 = r6.getBlob(r7)     // Catch:{ all -> 0x02b4 }
        L_0x021f:
            java.lang.Object r0 = fwfd.com.fwfsdk.util.FWFAnyConverter.toObject(r0)     // Catch:{ all -> 0x02b4 }
            r1.setVariation(r0)     // Catch:{ all -> 0x02b4 }
            int r0 = r6.getInt(r8)     // Catch:{ all -> 0x02b4 }
            if (r0 == 0) goto L_0x022e
            r0 = 1
            goto L_0x022f
        L_0x022e:
            r0 = 0
        L_0x022f:
            r1.setAbTest(r0)     // Catch:{ all -> 0x02b4 }
            r0 = r21
            boolean r21 = r6.isNull(r0)     // Catch:{ all -> 0x02b4 }
            if (r21 == 0) goto L_0x023e
            r22 = r0
            r0 = 0
            goto L_0x0246
        L_0x023e:
            java.lang.String r21 = r6.getString(r0)     // Catch:{ all -> 0x02b4 }
            r22 = r0
            r0 = r21
        L_0x0246:
            r1.setAccessToken(r0)     // Catch:{ all -> 0x02b4 }
            r21 = r2
            r0 = r20
            r20 = r3
            long r2 = r6.getLong(r0)     // Catch:{ all -> 0x02b4 }
            r1.setDate(r2)     // Catch:{ all -> 0x02b4 }
            r2 = r19
            boolean r3 = r6.isNull(r2)     // Catch:{ all -> 0x02b4 }
            if (r3 == 0) goto L_0x0260
            r3 = 0
            goto L_0x0264
        L_0x0260:
            java.lang.String r3 = r6.getString(r2)     // Catch:{ all -> 0x02b4 }
        L_0x0264:
            r1.setRelevantContext(r3)     // Catch:{ all -> 0x02b4 }
            r3 = r18
            r18 = r0
            int r0 = r6.getInt(r3)     // Catch:{ all -> 0x02b4 }
            r1.setSubscribe(r0)     // Catch:{ all -> 0x02b4 }
            r0 = r17
            boolean r17 = r6.isNull(r0)     // Catch:{ all -> 0x02b4 }
            if (r17 == 0) goto L_0x027f
            r19 = r0
            r17 = 0
            goto L_0x0285
        L_0x027f:
            java.lang.String r17 = r6.getString(r0)     // Catch:{ all -> 0x02b4 }
            r19 = r0
        L_0x0285:
            java.util.Map r0 = fwfd.com.fwfsdk.util.FWFMapConverter.fromString(r17)     // Catch:{ all -> 0x02b4 }
            r1.setHoldoutsEvaluations(r0)     // Catch:{ all -> 0x02b4 }
            r1.setExplanation(r9)     // Catch:{ all -> 0x02b4 }
            r1.setTrackInfo(r14)     // Catch:{ all -> 0x02b4 }
            r10.add(r1)     // Catch:{ all -> 0x02b4 }
            r17 = r19
            r14 = r23
            r1 = r24
            r0 = r25
            r19 = r2
            r2 = r21
            r21 = r22
            r26 = r18
            r18 = r3
            r3 = r20
            r20 = r26
            goto L_0x00dc
        L_0x02ad:
            r6.close()
            r16.release()
            return r10
        L_0x02b4:
            r0 = move-exception
            goto L_0x02b9
        L_0x02b6:
            r0 = move-exception
            r16 = r2
        L_0x02b9:
            r6.close()
            r16.release()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fwfd.com.fwfsdk.model.dao.FWFDBDAO_Impl.getFlagsById(java.util.List, java.lang.String):java.util.List");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: fwfd.com.fwfsdk.model.db.FWFSDKInfo} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.lang.Integer} */
    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v3 */
    /* JADX WARNING: type inference failed for: r3v6 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public fwfd.com.fwfsdk.model.db.FWFSDKInfo getLastSDKInfo() {
        /*
            r6 = this;
            java.lang.String r0 = "SELECT * FROM FWFSDKInfo ORDER BY versionNumber DESC LIMIT 1"
            r1 = 0
            androidx.room.RoomSQLiteQuery r0 = androidx.room.RoomSQLiteQuery.acquire(r0, r1)
            androidx.room.RoomDatabase r2 = r6.__db
            r2.assertNotSuspendingTransaction()
            androidx.room.RoomDatabase r2 = r6.__db
            r3 = 0
            android.database.Cursor r1 = androidx.room.util.DBUtil.query(r2, r0, r1, r3)
            java.lang.String r2 = "sdkVersion"
            int r2 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x004d }
            java.lang.String r4 = "versionNumber"
            int r4 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r1, r4)     // Catch:{ all -> 0x004d }
            boolean r5 = r1.moveToFirst()     // Catch:{ all -> 0x004d }
            if (r5 == 0) goto L_0x0046
            boolean r5 = r1.isNull(r2)     // Catch:{ all -> 0x004d }
            if (r5 == 0) goto L_0x002d
            r2 = r3
            goto L_0x0031
        L_0x002d:
            java.lang.String r2 = r1.getString(r2)     // Catch:{ all -> 0x004d }
        L_0x0031:
            boolean r5 = r1.isNull(r4)     // Catch:{ all -> 0x004d }
            if (r5 == 0) goto L_0x0038
            goto L_0x0040
        L_0x0038:
            int r3 = r1.getInt(r4)     // Catch:{ all -> 0x004d }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x004d }
        L_0x0040:
            fwfd.com.fwfsdk.model.db.FWFSDKInfo r4 = new fwfd.com.fwfsdk.model.db.FWFSDKInfo     // Catch:{ all -> 0x004d }
            r4.<init>(r2, r3)     // Catch:{ all -> 0x004d }
            r3 = r4
        L_0x0046:
            r1.close()
            r0.release()
            return r3
        L_0x004d:
            r2 = move-exception
            r1.close()
            r0.release()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: fwfd.com.fwfsdk.model.dao.FWFDBDAO_Impl.getLastSDKInfo():fwfd.com.fwfsdk.model.db.FWFSDKInfo");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: fwfd.com.fwfsdk.model.db.FWFFlagId} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.lang.Long} */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v3 */
    /* JADX WARNING: type inference failed for: r2v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public fwfd.com.fwfsdk.model.db.FWFFlagId getOldestUpdatedFlagFromEnvironment(java.lang.String r7) {
        /*
            r6 = this;
            java.lang.String r0 = "SELECT `key`, accessToken, date FROM FWFFeature WHERE accessToken = ? ORDER BY date DESC LIMIT 1"
            r1 = 1
            androidx.room.RoomSQLiteQuery r0 = androidx.room.RoomSQLiteQuery.acquire(r0, r1)
            if (r7 != 0) goto L_0x000d
            r0.bindNull(r1)
            goto L_0x0010
        L_0x000d:
            r0.bindString(r1, r7)
        L_0x0010:
            androidx.room.RoomDatabase r7 = r6.__db
            r7.assertNotSuspendingTransaction()
            androidx.room.RoomDatabase r7 = r6.__db
            r1 = 0
            r2 = 0
            android.database.Cursor r7 = androidx.room.util.DBUtil.query(r7, r0, r1, r2)
            java.lang.String r1 = "key"
            int r1 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r7, r1)     // Catch:{ all -> 0x0069 }
            java.lang.String r3 = "accessToken"
            int r3 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r7, r3)     // Catch:{ all -> 0x0069 }
            java.lang.String r4 = "date"
            int r4 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r7, r4)     // Catch:{ all -> 0x0069 }
            boolean r5 = r7.moveToFirst()     // Catch:{ all -> 0x0069 }
            if (r5 == 0) goto L_0x0062
            boolean r5 = r7.isNull(r1)     // Catch:{ all -> 0x0069 }
            if (r5 == 0) goto L_0x003d
            r1 = r2
            goto L_0x0041
        L_0x003d:
            java.lang.String r1 = r7.getString(r1)     // Catch:{ all -> 0x0069 }
        L_0x0041:
            boolean r5 = r7.isNull(r3)     // Catch:{ all -> 0x0069 }
            if (r5 == 0) goto L_0x0049
            r3 = r2
            goto L_0x004d
        L_0x0049:
            java.lang.String r3 = r7.getString(r3)     // Catch:{ all -> 0x0069 }
        L_0x004d:
            boolean r5 = r7.isNull(r4)     // Catch:{ all -> 0x0069 }
            if (r5 == 0) goto L_0x0054
            goto L_0x005c
        L_0x0054:
            long r4 = r7.getLong(r4)     // Catch:{ all -> 0x0069 }
            java.lang.Long r2 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x0069 }
        L_0x005c:
            fwfd.com.fwfsdk.model.db.FWFFlagId r4 = new fwfd.com.fwfsdk.model.db.FWFFlagId     // Catch:{ all -> 0x0069 }
            r4.<init>(r1, r3, r2)     // Catch:{ all -> 0x0069 }
            r2 = r4
        L_0x0062:
            r7.close()
            r0.release()
            return r2
        L_0x0069:
            r1 = move-exception
            r7.close()
            r0.release()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: fwfd.com.fwfsdk.model.dao.FWFDBDAO_Impl.getOldestUpdatedFlagFromEnvironment(java.lang.String):fwfd.com.fwfsdk.model.db.FWFFlagId");
    }

    public List<FWFFlagId> getSubscribedFlagIds() {
        String str;
        String str2;
        Long l11;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT `key`, accessToken, date FROM FWFFeature WHERE subscribe = 1", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "key");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "accessToken");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "date");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                if (query.isNull(columnIndexOrThrow)) {
                    str = null;
                } else {
                    str = query.getString(columnIndexOrThrow);
                }
                if (query.isNull(columnIndexOrThrow2)) {
                    str2 = null;
                } else {
                    str2 = query.getString(columnIndexOrThrow2);
                }
                if (query.isNull(columnIndexOrThrow3)) {
                    l11 = null;
                } else {
                    l11 = Long.valueOf(query.getLong(columnIndexOrThrow3));
                }
                arrayList.add(new FWFFlagId(str, str2, l11));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public void insertFlag(FWFFeature fWFFeature) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfFWFFeature.insert(fWFFeature);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public void insertFlagKeys(List<FWFFlagKey> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfFWFFlagKey.insert(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public void insertFlags(List<FWFFeature> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfFWFFeature.insert(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public void insertSDKInfo(FWFSDKInfo fWFSDKInfo) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfFWFSDKInfo.insert(fWFSDKInfo);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }
}
