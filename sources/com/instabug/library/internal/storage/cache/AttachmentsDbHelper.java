package com.instabug.library.internal.storage.cache;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.instabug.library.diagnostics.IBGDiagnostics;
import com.instabug.library.internal.storage.cache.db.DatabaseManager;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper;
import com.instabug.library.model.Attachment;
import com.instabug.library.util.InstabugSDKLogger;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;

@Instrumented
public class AttachmentsDbHelper {
    private static final String[] ATTACHMENT_COLUMN = {"attachments._id", "name", InstabugDbContract.AttachmentEntry.COLUMN_LOCALE_PATH, "url", "type", InstabugDbContract.AttachmentEntry.COLUMN_ATTACHMENT_STATE, InstabugDbContract.AttachmentEntry.COLUMN_VIDEO_ENCODED, "duration", InstabugDbContract.AttachmentEntry.COLUMN_REPORT_ID, InstabugDbContract.AttachmentEntry.COLUMN_ENCRYPTED};
    private static final String TAG = "AttachmentsDbHelper";

    public static synchronized void delete(long j11) {
        synchronized (AttachmentsDbHelper.class) {
            SQLiteDatabaseWrapper openDatabase = DatabaseManager.getInstance().openDatabase();
            String[] strArr = {String.valueOf(j11)};
            openDatabase.beginTransaction();
            try {
                if (!(openDatabase instanceof SQLiteDatabase)) {
                    openDatabase.delete(InstabugDbContract.AttachmentEntry.TABLE_NAME, "_id=? ", strArr);
                } else {
                    SQLiteInstrumentation.delete((SQLiteDatabase) openDatabase, InstabugDbContract.AttachmentEntry.TABLE_NAME, "_id=? ", strArr);
                }
                openDatabase.setTransactionSuccessful();
            } catch (Exception e11) {
                try {
                    InstabugSDKLogger.e(TAG, "Error while deleting attachment: " + e11.getMessage(), e11);
                    IBGDiagnostics.reportNonFatal(e11, "Error while updating attachment: " + e11.getMessage());
                } catch (Throwable th2) {
                    openDatabase.endTransaction();
                    openDatabase.close();
                    throw th2;
                }
            }
            openDatabase.endTransaction();
            openDatabase.close();
        }
    }

    public static synchronized void deleteAll() {
        synchronized (AttachmentsDbHelper.class) {
            SQLiteDatabaseWrapper openDatabase = DatabaseManager.getInstance().openDatabase();
            openDatabase.beginTransaction();
            try {
                if (!(openDatabase instanceof SQLiteDatabase)) {
                    openDatabase.delete(InstabugDbContract.AttachmentEntry.TABLE_NAME, (String) null, (String[]) null);
                } else {
                    SQLiteInstrumentation.delete((SQLiteDatabase) openDatabase, InstabugDbContract.AttachmentEntry.TABLE_NAME, (String) null, (String[]) null);
                }
                openDatabase.setTransactionSuccessful();
            } catch (Exception e11) {
                try {
                    InstabugSDKLogger.e(TAG, "Error while deleting all attachments: " + e11.getMessage(), e11);
                    IBGDiagnostics.reportNonFatal(e11, "Error while deleting all attachments: " + e11.getMessage());
                } catch (Throwable th2) {
                    openDatabase.endTransaction();
                    openDatabase.close();
                    throw th2;
                }
            }
            openDatabase.endTransaction();
            openDatabase.close();
        }
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public static synchronized long insert(Attachment attachment, String str) {
        long insertWithOnConflictReplace;
        synchronized (AttachmentsDbHelper.class) {
            SQLiteDatabaseWrapper openDatabase = DatabaseManager.getInstance().openDatabase();
            openDatabase.beginTransaction();
            try {
                ContentValues contentValues = new ContentValues();
                if (attachment.getId() != -1) {
                    contentValues.put(InstabugDbContract.FeatureRequestEntry.COLUMN_ID, Long.valueOf(attachment.getId()));
                }
                contentValues.put("url", attachment.getUrl());
                Attachment.AttachmentState attachmentState = attachment.getAttachmentState();
                if (attachmentState != null) {
                    contentValues.put(InstabugDbContract.AttachmentEntry.COLUMN_ATTACHMENT_STATE, attachmentState.name());
                }
                contentValues.put("duration", attachment.getDuration());
                contentValues.put(InstabugDbContract.AttachmentEntry.COLUMN_LOCALE_PATH, attachment.getLocalPath());
                contentValues.put("name", attachment.getName());
                if (attachment.getType() != null) {
                    contentValues.put("type", attachment.getType().name());
                }
                contentValues.put(InstabugDbContract.AttachmentEntry.COLUMN_VIDEO_ENCODED, Boolean.valueOf(attachment.isVideoEncoded()));
                contentValues.put(InstabugDbContract.AttachmentEntry.COLUMN_REPORT_ID, str);
                contentValues.put(InstabugDbContract.AttachmentEntry.COLUMN_ENCRYPTED, Boolean.valueOf(attachment.isEncrypted()));
                insertWithOnConflictReplace = openDatabase.insertWithOnConflictReplace(InstabugDbContract.AttachmentEntry.TABLE_NAME, (String) null, contentValues);
                openDatabase.setTransactionSuccessful();
                openDatabase.endTransaction();
                openDatabase.close();
            } catch (Exception e11) {
                try {
                    InstabugSDKLogger.e(TAG, "Error inserting attachments: " + e11.getMessage());
                    IBGDiagnostics.reportNonFatal(e11, "Error inserting attachments: " + e11.getMessage());
                    return -1;
                } finally {
                    openDatabase.endTransaction();
                    openDatabase.close();
                }
            }
        }
        return insertWithOnConflictReplace;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00fa, code lost:
        if (r14 == null) goto L_0x0133;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x012e, code lost:
        if (r14 == null) goto L_0x0133;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0130, code lost:
        r14.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0133, code lost:
        return r13;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.ArrayList<com.instabug.library.model.Attachment> retrieve(java.lang.String r21, com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper r22) {
        /*
            r0 = r22
            java.lang.String r10 = "Error while retrieving attachments: "
            java.lang.String r11 = "attachments._id"
            java.lang.String r12 = "name"
            java.lang.String r13 = "local_path"
            java.lang.String r14 = "url"
            java.lang.String r15 = "type"
            java.lang.String r16 = "attachment_state"
            java.lang.String r17 = "video_encoded"
            java.lang.String r18 = "duration"
            java.lang.String r19 = "report_id"
            java.lang.String r20 = "encrypted"
            java.lang.String[] r3 = new java.lang.String[]{r11, r12, r13, r14, r15, r16, r17, r18, r19, r20}
            r11 = 1
            java.lang.String[] r5 = new java.lang.String[r11]
            r12 = 0
            r5[r12] = r21
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
            r14 = 0
            java.lang.String r2 = "attachments"
            java.lang.String r4 = "report_id=?"
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            boolean r1 = r0 instanceof android.database.sqlite.SQLiteDatabase     // Catch:{ Exception -> 0x00ff }
            if (r1 != 0) goto L_0x0042
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r1 = r22
            android.database.Cursor r0 = r1.query(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x00ff }
            goto L_0x0050
        L_0x0042:
            android.database.sqlite.SQLiteDatabase r0 = (android.database.sqlite.SQLiteDatabase) r0     // Catch:{ Exception -> 0x00ff }
            r1 = r2
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r9
            android.database.Cursor r0 = com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.query(r0, r1, r2, r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x00ff }
        L_0x0050:
            r14 = r0
            if (r14 == 0) goto L_0x00fa
            boolean r0 = r14.moveToFirst()     // Catch:{ Exception -> 0x00ff }
            if (r0 == 0) goto L_0x00fa
        L_0x0059:
            com.instabug.library.model.Attachment r0 = new com.instabug.library.model.Attachment     // Catch:{ Exception -> 0x00ff }
            r0.<init>()     // Catch:{ Exception -> 0x00ff }
            java.lang.String r1 = "_id"
            int r1 = r14.getColumnIndex(r1)     // Catch:{ Exception -> 0x00ff }
            int r1 = r14.getInt(r1)     // Catch:{ Exception -> 0x00ff }
            long r1 = (long) r1     // Catch:{ Exception -> 0x00ff }
            r0.setId(r1)     // Catch:{ Exception -> 0x00ff }
            java.lang.String r1 = "name"
            int r1 = r14.getColumnIndex(r1)     // Catch:{ Exception -> 0x00ff }
            java.lang.String r1 = r14.getString(r1)     // Catch:{ Exception -> 0x00ff }
            r0.setName(r1)     // Catch:{ Exception -> 0x00ff }
            java.lang.String r1 = "attachment_state"
            int r1 = r14.getColumnIndex(r1)     // Catch:{ Exception -> 0x00ff }
            java.lang.Class<com.instabug.library.model.Attachment$AttachmentState> r2 = com.instabug.library.model.Attachment.AttachmentState.class
            java.lang.String r1 = r14.getString(r1)     // Catch:{ Exception -> 0x00ff }
            java.lang.Enum r1 = java.lang.Enum.valueOf(r2, r1)     // Catch:{ Exception -> 0x00ff }
            com.instabug.library.model.Attachment$AttachmentState r1 = (com.instabug.library.model.Attachment.AttachmentState) r1     // Catch:{ Exception -> 0x00ff }
            r0.setAttachmentState(r1)     // Catch:{ Exception -> 0x00ff }
            java.lang.String r1 = "duration"
            int r1 = r14.getColumnIndex(r1)     // Catch:{ Exception -> 0x00ff }
            java.lang.String r1 = r14.getString(r1)     // Catch:{ Exception -> 0x00ff }
            r0.setDuration(r1)     // Catch:{ Exception -> 0x00ff }
            java.lang.String r1 = "url"
            int r1 = r14.getColumnIndex(r1)     // Catch:{ Exception -> 0x00ff }
            java.lang.String r1 = r14.getString(r1)     // Catch:{ Exception -> 0x00ff }
            r0.setUrl(r1)     // Catch:{ Exception -> 0x00ff }
            java.lang.String r1 = "local_path"
            int r1 = r14.getColumnIndex(r1)     // Catch:{ Exception -> 0x00ff }
            java.lang.String r1 = r14.getString(r1)     // Catch:{ Exception -> 0x00ff }
            r0.setLocalPath(r1)     // Catch:{ Exception -> 0x00ff }
            java.lang.String r1 = "video_encoded"
            int r1 = r14.getColumnIndex(r1)     // Catch:{ Exception -> 0x00ff }
            int r1 = r14.getInt(r1)     // Catch:{ Exception -> 0x00ff }
            if (r1 == 0) goto L_0x00c5
            r1 = r11
            goto L_0x00c6
        L_0x00c5:
            r1 = r12
        L_0x00c6:
            r0.setVideoEncoded(r1)     // Catch:{ Exception -> 0x00ff }
            java.lang.String r1 = "type"
            int r1 = r14.getColumnIndex(r1)     // Catch:{ Exception -> 0x00ff }
            java.lang.Class<com.instabug.library.model.Attachment$Type> r2 = com.instabug.library.model.Attachment.Type.class
            java.lang.String r1 = r14.getString(r1)     // Catch:{ Exception -> 0x00ff }
            java.lang.Enum r1 = java.lang.Enum.valueOf(r2, r1)     // Catch:{ Exception -> 0x00ff }
            com.instabug.library.model.Attachment$Type r1 = (com.instabug.library.model.Attachment.Type) r1     // Catch:{ Exception -> 0x00ff }
            r0.setType(r1)     // Catch:{ Exception -> 0x00ff }
            java.lang.String r1 = "encrypted"
            int r1 = r14.getColumnIndex(r1)     // Catch:{ Exception -> 0x00ff }
            int r1 = r14.getInt(r1)     // Catch:{ Exception -> 0x00ff }
            if (r1 == 0) goto L_0x00ed
            r1 = r11
            goto L_0x00ee
        L_0x00ed:
            r1 = r12
        L_0x00ee:
            r0.setEncrypted(r1)     // Catch:{ Exception -> 0x00ff }
            r13.add(r0)     // Catch:{ Exception -> 0x00ff }
            boolean r0 = r14.moveToNext()     // Catch:{ Exception -> 0x00ff }
            if (r0 != 0) goto L_0x0059
        L_0x00fa:
            if (r14 == 0) goto L_0x0133
            goto L_0x0130
        L_0x00fd:
            r0 = move-exception
            goto L_0x0134
        L_0x00ff:
            r0 = move-exception
            java.lang.String r1 = "AttachmentsDbHelper"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00fd }
            r2.<init>()     // Catch:{ all -> 0x00fd }
            r2.append(r10)     // Catch:{ all -> 0x00fd }
            java.lang.String r3 = r0.getMessage()     // Catch:{ all -> 0x00fd }
            r2.append(r3)     // Catch:{ all -> 0x00fd }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00fd }
            com.instabug.library.util.InstabugSDKLogger.e(r1, r2, r0)     // Catch:{ all -> 0x00fd }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00fd }
            r1.<init>()     // Catch:{ all -> 0x00fd }
            r1.append(r10)     // Catch:{ all -> 0x00fd }
            java.lang.String r2 = r0.getMessage()     // Catch:{ all -> 0x00fd }
            r1.append(r2)     // Catch:{ all -> 0x00fd }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00fd }
            com.instabug.library.diagnostics.IBGDiagnostics.reportNonFatal(r0, r1)     // Catch:{ all -> 0x00fd }
            if (r14 == 0) goto L_0x0133
        L_0x0130:
            r14.close()
        L_0x0133:
            return r13
        L_0x0134:
            if (r14 == 0) goto L_0x0139
            r14.close()
        L_0x0139:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.internal.storage.cache.AttachmentsDbHelper.retrieve(java.lang.String, com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper):java.util.ArrayList");
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public static synchronized void update(long j11, ContentValues contentValues) {
        synchronized (AttachmentsDbHelper.class) {
            SQLiteDatabaseWrapper openDatabase = DatabaseManager.getInstance().openDatabase();
            String[] strArr = {String.valueOf(j11)};
            openDatabase.beginTransaction();
            try {
                if (!(openDatabase instanceof SQLiteDatabase)) {
                    openDatabase.update(InstabugDbContract.AttachmentEntry.TABLE_NAME, contentValues, "_id=? ", strArr);
                } else {
                    SQLiteInstrumentation.update((SQLiteDatabase) openDatabase, InstabugDbContract.AttachmentEntry.TABLE_NAME, contentValues, "_id=? ", strArr);
                }
                openDatabase.setTransactionSuccessful();
            } catch (Exception e11) {
                try {
                    InstabugSDKLogger.e(TAG, "Error while updating attachment: " + e11.getMessage(), e11);
                    IBGDiagnostics.reportNonFatal(e11, "Error while updating attachment: " + e11.getMessage());
                } catch (Throwable th2) {
                    openDatabase.endTransaction();
                    openDatabase.close();
                    throw th2;
                }
            }
            openDatabase.endTransaction();
            openDatabase.close();
        }
    }

    public static synchronized void delete(String str, String str2) {
        synchronized (AttachmentsDbHelper.class) {
            SQLiteDatabaseWrapper openDatabase = DatabaseManager.getInstance().openDatabase();
            String[] strArr = {str, str2};
            openDatabase.beginTransaction();
            try {
                if (!(openDatabase instanceof SQLiteDatabase)) {
                    openDatabase.delete(InstabugDbContract.AttachmentEntry.TABLE_NAME, "name = ? and report_id = ?", strArr);
                } else {
                    SQLiteInstrumentation.delete((SQLiteDatabase) openDatabase, InstabugDbContract.AttachmentEntry.TABLE_NAME, "name = ? and report_id = ?", strArr);
                }
                openDatabase.setTransactionSuccessful();
            } catch (Exception e11) {
                try {
                    InstabugSDKLogger.e(TAG, "Error while deleting attachment: " + e11.getMessage(), e11);
                    IBGDiagnostics.reportNonFatal(e11, "Error while deleting attachment: " + e11.getMessage());
                } catch (Throwable th2) {
                    openDatabase.endTransaction();
                    openDatabase.close();
                    throw th2;
                }
            }
            openDatabase.endTransaction();
            openDatabase.close();
        }
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public static synchronized void update(String str, String str2, ContentValues contentValues) {
        synchronized (AttachmentsDbHelper.class) {
            SQLiteDatabaseWrapper openDatabase = DatabaseManager.getInstance().openDatabase();
            String[] strArr = {str, str2};
            openDatabase.beginTransaction();
            try {
                if (!(openDatabase instanceof SQLiteDatabase)) {
                    openDatabase.update(InstabugDbContract.AttachmentEntry.TABLE_NAME, contentValues, "name=? and report_id=? ", strArr);
                } else {
                    SQLiteInstrumentation.update((SQLiteDatabase) openDatabase, InstabugDbContract.AttachmentEntry.TABLE_NAME, contentValues, "name=? and report_id=? ", strArr);
                }
                openDatabase.setTransactionSuccessful();
            } finally {
                openDatabase.endTransaction();
                openDatabase.close();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x00ef, code lost:
        if (r4 == null) goto L_0x0128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0123, code lost:
        if (r4 == null) goto L_0x0128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0125, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0128, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.ArrayList<com.instabug.library.model.Attachment> retrieve(java.lang.String r21, com.instabug.library.internal.storage.cache.dbv2.IBGDbManager r22) {
        /*
            java.lang.String r1 = "Error while retrieving attachments: "
            java.lang.String r2 = "attachments._id"
            java.lang.String r3 = "name"
            java.lang.String r4 = "local_path"
            java.lang.String r5 = "url"
            java.lang.String r6 = "type"
            java.lang.String r7 = "attachment_state"
            java.lang.String r8 = "video_encoded"
            java.lang.String r9 = "duration"
            java.lang.String r10 = "report_id"
            java.lang.String r11 = "encrypted"
            java.lang.String[] r14 = new java.lang.String[]{r2, r3, r4, r5, r6, r7, r8, r9, r10, r11}
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            com.instabug.library.internal.storage.cache.dbv2.IBGWhereArg r2 = new com.instabug.library.internal.storage.cache.dbv2.IBGWhereArg
            r3 = 1
            r4 = r21
            r2.<init>(r4, r3)
            r0.add(r2)
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r4 = 0
            java.lang.String r13 = "attachments"
            java.lang.String r15 = "report_id=?"
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r12 = r22
            r16 = r0
            com.instabug.library.internal.storage.cache.dbv2.IBGCursor r4 = r12.query(r13, r14, r15, r16, r17, r18, r19, r20)     // Catch:{ Exception -> 0x00f4 }
            if (r4 == 0) goto L_0x00ef
            boolean r0 = r4.moveToFirst()     // Catch:{ Exception -> 0x00f4 }
            if (r0 == 0) goto L_0x00ef
        L_0x004f:
            com.instabug.library.model.Attachment r0 = new com.instabug.library.model.Attachment     // Catch:{ Exception -> 0x00f4 }
            r0.<init>()     // Catch:{ Exception -> 0x00f4 }
            java.lang.String r5 = "_id"
            int r5 = r4.getColumnIndex(r5)     // Catch:{ Exception -> 0x00f4 }
            int r5 = r4.getInt(r5)     // Catch:{ Exception -> 0x00f4 }
            long r5 = (long) r5     // Catch:{ Exception -> 0x00f4 }
            r0.setId(r5)     // Catch:{ Exception -> 0x00f4 }
            java.lang.String r5 = "name"
            int r5 = r4.getColumnIndex(r5)     // Catch:{ Exception -> 0x00f4 }
            java.lang.String r5 = r4.getString(r5)     // Catch:{ Exception -> 0x00f4 }
            r0.setName(r5)     // Catch:{ Exception -> 0x00f4 }
            java.lang.String r5 = "attachment_state"
            int r5 = r4.getColumnIndex(r5)     // Catch:{ Exception -> 0x00f4 }
            java.lang.Class<com.instabug.library.model.Attachment$AttachmentState> r6 = com.instabug.library.model.Attachment.AttachmentState.class
            java.lang.String r5 = r4.getString(r5)     // Catch:{ Exception -> 0x00f4 }
            java.lang.Enum r5 = java.lang.Enum.valueOf(r6, r5)     // Catch:{ Exception -> 0x00f4 }
            com.instabug.library.model.Attachment$AttachmentState r5 = (com.instabug.library.model.Attachment.AttachmentState) r5     // Catch:{ Exception -> 0x00f4 }
            r0.setAttachmentState(r5)     // Catch:{ Exception -> 0x00f4 }
            java.lang.String r5 = "duration"
            int r5 = r4.getColumnIndex(r5)     // Catch:{ Exception -> 0x00f4 }
            java.lang.String r5 = r4.getString(r5)     // Catch:{ Exception -> 0x00f4 }
            r0.setDuration(r5)     // Catch:{ Exception -> 0x00f4 }
            java.lang.String r5 = "url"
            int r5 = r4.getColumnIndex(r5)     // Catch:{ Exception -> 0x00f4 }
            java.lang.String r5 = r4.getString(r5)     // Catch:{ Exception -> 0x00f4 }
            r0.setUrl(r5)     // Catch:{ Exception -> 0x00f4 }
            java.lang.String r5 = "local_path"
            int r5 = r4.getColumnIndex(r5)     // Catch:{ Exception -> 0x00f4 }
            java.lang.String r5 = r4.getString(r5)     // Catch:{ Exception -> 0x00f4 }
            r0.setLocalPath(r5)     // Catch:{ Exception -> 0x00f4 }
            java.lang.String r5 = "video_encoded"
            int r5 = r4.getColumnIndex(r5)     // Catch:{ Exception -> 0x00f4 }
            int r5 = r4.getInt(r5)     // Catch:{ Exception -> 0x00f4 }
            r6 = 0
            if (r5 == 0) goto L_0x00bc
            r5 = r3
            goto L_0x00bd
        L_0x00bc:
            r5 = r6
        L_0x00bd:
            r0.setVideoEncoded(r5)     // Catch:{ Exception -> 0x00f4 }
            java.lang.String r5 = "type"
            int r5 = r4.getColumnIndex(r5)     // Catch:{ Exception -> 0x00f4 }
            java.lang.Class<com.instabug.library.model.Attachment$Type> r7 = com.instabug.library.model.Attachment.Type.class
            java.lang.String r5 = r4.getString(r5)     // Catch:{ Exception -> 0x00f4 }
            java.lang.Enum r5 = java.lang.Enum.valueOf(r7, r5)     // Catch:{ Exception -> 0x00f4 }
            com.instabug.library.model.Attachment$Type r5 = (com.instabug.library.model.Attachment.Type) r5     // Catch:{ Exception -> 0x00f4 }
            r0.setType(r5)     // Catch:{ Exception -> 0x00f4 }
            java.lang.String r5 = "encrypted"
            int r5 = r4.getColumnIndex(r5)     // Catch:{ Exception -> 0x00f4 }
            int r5 = r4.getInt(r5)     // Catch:{ Exception -> 0x00f4 }
            if (r5 == 0) goto L_0x00e3
            r6 = r3
        L_0x00e3:
            r0.setEncrypted(r6)     // Catch:{ Exception -> 0x00f4 }
            r2.add(r0)     // Catch:{ Exception -> 0x00f4 }
            boolean r0 = r4.moveToNext()     // Catch:{ Exception -> 0x00f4 }
            if (r0 != 0) goto L_0x004f
        L_0x00ef:
            if (r4 == 0) goto L_0x0128
            goto L_0x0125
        L_0x00f2:
            r0 = move-exception
            goto L_0x0129
        L_0x00f4:
            r0 = move-exception
            java.lang.String r3 = "AttachmentsDbHelper"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f2 }
            r5.<init>()     // Catch:{ all -> 0x00f2 }
            r5.append(r1)     // Catch:{ all -> 0x00f2 }
            java.lang.String r6 = r0.getMessage()     // Catch:{ all -> 0x00f2 }
            r5.append(r6)     // Catch:{ all -> 0x00f2 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x00f2 }
            com.instabug.library.util.InstabugSDKLogger.e(r3, r5, r0)     // Catch:{ all -> 0x00f2 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f2 }
            r3.<init>()     // Catch:{ all -> 0x00f2 }
            r3.append(r1)     // Catch:{ all -> 0x00f2 }
            java.lang.String r1 = r0.getMessage()     // Catch:{ all -> 0x00f2 }
            r3.append(r1)     // Catch:{ all -> 0x00f2 }
            java.lang.String r1 = r3.toString()     // Catch:{ all -> 0x00f2 }
            com.instabug.library.diagnostics.IBGDiagnostics.reportNonFatal(r0, r1)     // Catch:{ all -> 0x00f2 }
            if (r4 == 0) goto L_0x0128
        L_0x0125:
            r4.close()
        L_0x0128:
            return r2
        L_0x0129:
            if (r4 == 0) goto L_0x012e
            r4.close()
        L_0x012e:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.internal.storage.cache.AttachmentsDbHelper.retrieve(java.lang.String, com.instabug.library.internal.storage.cache.dbv2.IBGDbManager):java.util.ArrayList");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00e5, code lost:
        if (r12 == null) goto L_0x011e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0119, code lost:
        if (r12 == null) goto L_0x011e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x011b, code lost:
        r12.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x011e, code lost:
        r1.endTransaction();
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0124, code lost:
        return r11;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.ArrayList<com.instabug.library.model.Attachment> retrieve(java.lang.String r15) {
        /*
            java.lang.String r0 = "Error while retrieving attachments: "
            com.instabug.library.internal.storage.cache.db.DatabaseManager r1 = com.instabug.library.internal.storage.cache.db.DatabaseManager.getInstance()
            com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper r1 = r1.openDatabase()
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            r12 = 0
            r1.beginTransaction()     // Catch:{ Exception -> 0x00ea }
            r13 = 1
            java.lang.String[] r6 = new java.lang.String[r13]     // Catch:{ Exception -> 0x00ea }
            r14 = 0
            r6[r14] = r15     // Catch:{ Exception -> 0x00ea }
            java.lang.String r3 = "attachments"
            java.lang.String[] r4 = ATTACHMENT_COLUMN     // Catch:{ Exception -> 0x00ea }
            java.lang.String r5 = "report_id=?"
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            boolean r15 = r1 instanceof android.database.sqlite.SQLiteDatabase     // Catch:{ Exception -> 0x00ea }
            if (r15 != 0) goto L_0x0031
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r2 = r1
            android.database.Cursor r15 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x00ea }
            goto L_0x0038
        L_0x0031:
            r2 = r1
            android.database.sqlite.SQLiteDatabase r2 = (android.database.sqlite.SQLiteDatabase) r2     // Catch:{ Exception -> 0x00ea }
            android.database.Cursor r15 = com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.query(r2, r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x00ea }
        L_0x0038:
            r12 = r15
            if (r12 == 0) goto L_0x00e2
            boolean r15 = r12.moveToFirst()     // Catch:{ Exception -> 0x00ea }
            if (r15 == 0) goto L_0x00e2
        L_0x0041:
            com.instabug.library.model.Attachment r15 = new com.instabug.library.model.Attachment     // Catch:{ Exception -> 0x00ea }
            r15.<init>()     // Catch:{ Exception -> 0x00ea }
            java.lang.String r2 = "_id"
            int r2 = r12.getColumnIndex(r2)     // Catch:{ Exception -> 0x00ea }
            int r2 = r12.getInt(r2)     // Catch:{ Exception -> 0x00ea }
            long r2 = (long) r2     // Catch:{ Exception -> 0x00ea }
            r15.setId(r2)     // Catch:{ Exception -> 0x00ea }
            java.lang.String r2 = "name"
            int r2 = r12.getColumnIndex(r2)     // Catch:{ Exception -> 0x00ea }
            java.lang.String r2 = r12.getString(r2)     // Catch:{ Exception -> 0x00ea }
            r15.setName(r2)     // Catch:{ Exception -> 0x00ea }
            java.lang.String r2 = "attachment_state"
            int r2 = r12.getColumnIndex(r2)     // Catch:{ Exception -> 0x00ea }
            java.lang.Class<com.instabug.library.model.Attachment$AttachmentState> r3 = com.instabug.library.model.Attachment.AttachmentState.class
            java.lang.String r2 = r12.getString(r2)     // Catch:{ Exception -> 0x00ea }
            java.lang.Enum r2 = java.lang.Enum.valueOf(r3, r2)     // Catch:{ Exception -> 0x00ea }
            com.instabug.library.model.Attachment$AttachmentState r2 = (com.instabug.library.model.Attachment.AttachmentState) r2     // Catch:{ Exception -> 0x00ea }
            r15.setAttachmentState(r2)     // Catch:{ Exception -> 0x00ea }
            java.lang.String r2 = "duration"
            int r2 = r12.getColumnIndex(r2)     // Catch:{ Exception -> 0x00ea }
            java.lang.String r2 = r12.getString(r2)     // Catch:{ Exception -> 0x00ea }
            r15.setDuration(r2)     // Catch:{ Exception -> 0x00ea }
            java.lang.String r2 = "url"
            int r2 = r12.getColumnIndex(r2)     // Catch:{ Exception -> 0x00ea }
            java.lang.String r2 = r12.getString(r2)     // Catch:{ Exception -> 0x00ea }
            r15.setUrl(r2)     // Catch:{ Exception -> 0x00ea }
            java.lang.String r2 = "local_path"
            int r2 = r12.getColumnIndex(r2)     // Catch:{ Exception -> 0x00ea }
            java.lang.String r2 = r12.getString(r2)     // Catch:{ Exception -> 0x00ea }
            r15.setLocalPath(r2)     // Catch:{ Exception -> 0x00ea }
            java.lang.String r2 = "video_encoded"
            int r2 = r12.getColumnIndex(r2)     // Catch:{ Exception -> 0x00ea }
            int r2 = r12.getInt(r2)     // Catch:{ Exception -> 0x00ea }
            if (r2 == 0) goto L_0x00ad
            r2 = r13
            goto L_0x00ae
        L_0x00ad:
            r2 = r14
        L_0x00ae:
            r15.setVideoEncoded(r2)     // Catch:{ Exception -> 0x00ea }
            java.lang.String r2 = "type"
            int r2 = r12.getColumnIndex(r2)     // Catch:{ Exception -> 0x00ea }
            java.lang.Class<com.instabug.library.model.Attachment$Type> r3 = com.instabug.library.model.Attachment.Type.class
            java.lang.String r2 = r12.getString(r2)     // Catch:{ Exception -> 0x00ea }
            java.lang.Enum r2 = java.lang.Enum.valueOf(r3, r2)     // Catch:{ Exception -> 0x00ea }
            com.instabug.library.model.Attachment$Type r2 = (com.instabug.library.model.Attachment.Type) r2     // Catch:{ Exception -> 0x00ea }
            r15.setType(r2)     // Catch:{ Exception -> 0x00ea }
            java.lang.String r2 = "encrypted"
            int r2 = r12.getColumnIndex(r2)     // Catch:{ Exception -> 0x00ea }
            int r2 = r12.getInt(r2)     // Catch:{ Exception -> 0x00ea }
            if (r2 <= 0) goto L_0x00d5
            r2 = r13
            goto L_0x00d6
        L_0x00d5:
            r2 = r14
        L_0x00d6:
            r15.setEncrypted(r2)     // Catch:{ Exception -> 0x00ea }
            r11.add(r15)     // Catch:{ Exception -> 0x00ea }
            boolean r15 = r12.moveToNext()     // Catch:{ Exception -> 0x00ea }
            if (r15 != 0) goto L_0x0041
        L_0x00e2:
            r1.setTransactionSuccessful()     // Catch:{ Exception -> 0x00ea }
            if (r12 == 0) goto L_0x011e
            goto L_0x011b
        L_0x00e8:
            r15 = move-exception
            goto L_0x0125
        L_0x00ea:
            r15 = move-exception
            java.lang.String r2 = "AttachmentsDbHelper"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e8 }
            r3.<init>()     // Catch:{ all -> 0x00e8 }
            r3.append(r0)     // Catch:{ all -> 0x00e8 }
            java.lang.String r4 = r15.getMessage()     // Catch:{ all -> 0x00e8 }
            r3.append(r4)     // Catch:{ all -> 0x00e8 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00e8 }
            com.instabug.library.util.InstabugSDKLogger.e(r2, r3, r15)     // Catch:{ all -> 0x00e8 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e8 }
            r2.<init>()     // Catch:{ all -> 0x00e8 }
            r2.append(r0)     // Catch:{ all -> 0x00e8 }
            java.lang.String r0 = r15.getMessage()     // Catch:{ all -> 0x00e8 }
            r2.append(r0)     // Catch:{ all -> 0x00e8 }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x00e8 }
            com.instabug.library.diagnostics.IBGDiagnostics.reportNonFatal(r15, r0)     // Catch:{ all -> 0x00e8 }
            if (r12 == 0) goto L_0x011e
        L_0x011b:
            r12.close()
        L_0x011e:
            r1.endTransaction()
            r1.close()
            return r11
        L_0x0125:
            if (r12 == 0) goto L_0x012a
            r12.close()
        L_0x012a:
            r1.endTransaction()
            r1.close()
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.internal.storage.cache.AttachmentsDbHelper.retrieve(java.lang.String):java.util.ArrayList");
    }
}
