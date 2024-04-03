package com.huawei.location.lite.common.log.logwrite;

import android.text.TextUtils;
import android.util.Log;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.util.PermissionUtil;
import com.huawei.location.lite.common.util.SDKComponentType;
import db.a;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Locale;
import java.util.Map;
import net.bytebuddy.utility.JavaConstant;

public final class LogWrite {
    private static final long DAY_TO_MILL = 86400000;
    private static final int DOWN_LINE_INDEX = 17;
    private static final int FILE_NAME_LENTH = 28;
    private static final int FIVE = 5;
    private static final String PATTERN_ONE = "yyyyMMdd_HHmmss";
    private static final String PATTERN_TWO = "yy-MM-dd HH:mm:ss.SSS";
    private static final String TAG = "LogWrite";
    private static final int TWENTY = 20;
    private static final int TWO = 2;
    private static final int UNIT_CONVERSION = 1024;
    private static boolean enableWriteLog = false;
    private Map<String, FileParam> fileInfoMap = new ConcurrentHashMap();
    private String logDirPath = null;
    private long maxFileExpired;
    private int maxFileNum;
    private int maxFileSize;

    public static class FileComparator implements Comparator<File>, Serializable {
        private static final long serialVersionUID = 1;

        private FileComparator() {
        }

        public int compare(File file, File file2) {
            return (int) (file.lastModified() - file2.lastModified());
        }
    }

    private void beforeWriteCheck(FileParam fileParam, String str) throws IOException {
        String fileName = fileParam.getFileName();
        String fileDirPath = fileParam.getFileDirPath();
        if (!TextUtils.isEmpty(fileName)) {
            if (!new File(fileDirPath, fileName).exists()) {
                Log.i(TAG, "writeToFile file is not exit");
            } else {
                return;
            }
        }
        File file = new File(fileDirPath);
        if (!file.exists()) {
            Log.i(TAG, "beforeWriteCheck None of the paths exist--Create a path--Create a file");
            fileParam.setNeedCheck(false);
            creatFolder(fileDirPath);
            createNewLogFile(fileParam, makeLogFileName(str), str);
            return;
        }
        pathExistsDeal(file, fileParam, str);
    }

    private void creatFolder(String str) {
        boolean z11;
        File file = new File(str);
        if (!file.exists()) {
            try {
                z11 = file.mkdirs();
            } catch (SecurityException unused) {
                Log.e(TAG, "createFolder SecurityException:");
                z11 = false;
            }
            if (!z11) {
                Log.e(TAG, "createFolder fail");
            } else {
                Log.i(TAG, "createFolder success");
            }
        }
    }

    private void createNewLogFile(FileParam fileParam, String str, String str2) throws IOException {
        String fileDirPath = fileParam.getFileDirPath();
        BufferedWriter writer = fileParam.getWriter();
        if (TextUtils.isEmpty(fileDirPath) || TextUtils.isEmpty(str)) {
            Log.e(TAG, "createNewLogFile Exception");
            return;
        }
        File file = new File(fileDirPath, str);
        FileOutputStream fileOutputStream = new FileOutputStream(file, true);
        synchronized (LogWrite.class) {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException unused) {
                    Log.e(TAG, "createNewLogFile IOException");
                }
            }
            fileParam.setWriter(new BufferedWriter(new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8)));
            if (fileParam.isNeedCheck()) {
                filesNumAndUsefulCheck(fileDirPath, str2);
            }
            fileParam.setFileName(str);
            enableWriteLog = true;
            if (str2.equals("location") && file.length() == 0) {
                fileParam.getWriter().append(getCSVFileHeader());
                fileParam.getWriter().flush();
            }
            Log.i(TAG, "createNewLogFile:File creation complete logFileName:" + str);
        }
    }

    private boolean deleteFiles(File[] fileArr, int i11) {
        if (fileArr != null && fileArr.length > 0) {
            if (i11 == -1) {
                try {
                    for (int length = fileArr.length - 1; length >= 0; length--) {
                        if (!fileArr[length].delete()) {
                            Log.e(TAG, "deleteFiles result false");
                            return false;
                        }
                    }
                } catch (SecurityException unused) {
                    Log.e(TAG, "deleteFiles SecurityException");
                }
            } else {
                for (int i12 = i11 - 1; i12 >= 0; i12--) {
                    if (!fileArr[i12].delete()) {
                        Log.e(TAG, "deleteFiles result false");
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }

    private void doWrite(AppLog appLog, FileParam fileParam) throws IOException {
        String msgByFileType = getMsgByFileType(appLog);
        BufferedWriter writer = fileParam.getWriter();
        if (writer != null) {
            writer.append(msgByFileType);
            writer.flush();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void filesNumAndUsefulCheck(java.lang.String r6, java.lang.String r7) {
        /*
            r5 = this;
            java.lang.String r0 = "LogWrite"
            java.io.File r1 = new java.io.File
            r1.<init>(r6)
            java.io.File[] r6 = r5.getExistedFiles(r1, r7)
            if (r6 == 0) goto L_0x0094
            int r7 = r6.length
            if (r7 <= 0) goto L_0x0094
            com.huawei.location.lite.common.log.logwrite.LogWrite$FileComparator r7 = new com.huawei.location.lite.common.log.logwrite.LogWrite$FileComparator     // Catch:{ IllegalArgumentException -> 0x001a }
            r1 = 0
            r7.<init>()     // Catch:{ IllegalArgumentException -> 0x001a }
            java.util.Arrays.sort(r6, r7)     // Catch:{ IllegalArgumentException -> 0x001a }
            goto L_0x001f
        L_0x001a:
            java.lang.String r7 = "Arrays sort IllegalArgumentException"
            android.util.Log.e(r0, r7)
        L_0x001f:
            int r7 = r6.length     // Catch:{ SecurityException -> 0x0080, Exception -> 0x007d }
            int r7 = r7 + -1
            r7 = r6[r7]     // Catch:{ SecurityException -> 0x0080, Exception -> 0x007d }
            long r1 = r5.getFileSavaTimeMill(r7)     // Catch:{ SecurityException -> 0x0080, Exception -> 0x007d }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ SecurityException -> 0x0080, Exception -> 0x007d }
            long r3 = r3 - r1
            long r1 = r5.maxFileExpired     // Catch:{ SecurityException -> 0x0080, Exception -> 0x007d }
            int r7 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r7 <= 0) goto L_0x003d
            java.lang.String r7 = "filesNumAndUsefulCheck:The latest saved files are more than maxFileExpired delete all files"
            android.util.Log.i(r0, r7)     // Catch:{ SecurityException -> 0x0080, Exception -> 0x007d }
            r7 = -1
            r5.deleteFiles(r6, r7)     // Catch:{ SecurityException -> 0x0080, Exception -> 0x007d }
            goto L_0x0085
        L_0x003d:
            int r7 = r6.length     // Catch:{ SecurityException -> 0x0080, Exception -> 0x007d }
            int r7 = r7 + -1
        L_0x0040:
            if (r7 < 0) goto L_0x0085
            r1 = r6[r7]     // Catch:{ SecurityException -> 0x0080, Exception -> 0x007d }
            long r1 = r5.getFileSavaTimeMill(r1)     // Catch:{ SecurityException -> 0x0080, Exception -> 0x007d }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ SecurityException -> 0x0080, Exception -> 0x007d }
            long r3 = r3 - r1
            long r1 = r5.maxFileExpired     // Catch:{ SecurityException -> 0x0080, Exception -> 0x007d }
            int r1 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r1 <= 0) goto L_0x007a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ SecurityException -> 0x0080, Exception -> 0x007d }
            r1.<init>()     // Catch:{ SecurityException -> 0x0080, Exception -> 0x007d }
            java.lang.String r2 = "filesNumAndUsefulCheck:delete the exceed file:"
            r1.append(r2)     // Catch:{ SecurityException -> 0x0080, Exception -> 0x007d }
            r2 = r6[r7]     // Catch:{ SecurityException -> 0x0080, Exception -> 0x007d }
            java.lang.String r2 = r2.getName()     // Catch:{ SecurityException -> 0x0080, Exception -> 0x007d }
            r1.append(r2)     // Catch:{ SecurityException -> 0x0080, Exception -> 0x007d }
            java.lang.String r1 = r1.toString()     // Catch:{ SecurityException -> 0x0080, Exception -> 0x007d }
            android.util.Log.i(r0, r1)     // Catch:{ SecurityException -> 0x0080, Exception -> 0x007d }
            r1 = r6[r7]     // Catch:{ SecurityException -> 0x0080, Exception -> 0x007d }
            boolean r1 = r1.delete()     // Catch:{ SecurityException -> 0x0080, Exception -> 0x007d }
            if (r1 != 0) goto L_0x007a
            java.lang.String r1 = "filesNumAndUsefulCheck:delete the exceed file result false"
            android.util.Log.e(r0, r1)     // Catch:{ SecurityException -> 0x0080, Exception -> 0x007d }
        L_0x007a:
            int r7 = r7 + -1
            goto L_0x0040
        L_0x007d:
            java.lang.String r7 = "filesNumAndUsefulCheck:Exception"
            goto L_0x0082
        L_0x0080:
            java.lang.String r7 = "filesNumAndUsefulCheck:SecurityException"
        L_0x0082:
            android.util.Log.i(r0, r7)
        L_0x0085:
            int r7 = r6.length
            int r1 = r5.maxFileNum
            if (r7 < r1) goto L_0x0094
            int r7 = r6.length
            int r7 = r7 - r1
            java.lang.String r1 = "createNewLogFile Exceeded the maximum number of files--Delete the earliest file."
            android.util.Log.i(r0, r1)
            r5.deleteFiles(r6, r7)
        L_0x0094:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.lite.common.log.logwrite.LogWrite.filesNumAndUsefulCheck(java.lang.String, java.lang.String):void");
    }

    private static String getCSVFileHeader() {
        return LogWriteConstants.WRITE_TIME + "," + "transId" + "," + "provider" + "," + "latitude" + "," + "longitude" + "," + "accuracy" + "," + LogWriteConstants.LOCATION_TIME + "," + "speed" + "," + "sessionId" + "," + LogWriteConstants.SOURCE_TYPE + "," + LogWriteConstants.LOCATE_TYPE + "," + LogWriteConstants.VENDOR_TYPE + "," + "src" + "," + LogWriteConstants.SWITCH_HD + "," + LogWriteConstants.FLOOR + "," + LogWriteConstants.FLOOR_ACC + "," + LogWriteConstants.BUILDING_ID + System.lineSeparator();
    }

    private File[] getExistedFiles(File file, String str) {
        FilenameFilter filenameFilter;
        if (str.equals("location")) {
            new a
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000a: CONSTRUCTOR  (r3v4 ? I:db.a) =  call: db.a.<init>():void type: CONSTRUCTOR in method: com.huawei.location.lite.common.log.logwrite.LogWrite.getExistedFiles(java.io.File, java.lang.String):java.io.File[], dex: classes6.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r3v4 ?
                	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:189)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:620)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                	... 34 more
                */
            /*
                this = this;
                java.lang.String r0 = "location"
                boolean r3 = r3.equals(r0)
                if (r3 == 0) goto L_0x0012
                db.a r3 = new db.a
                r3.<init>()
            L_0x000d:
                java.io.File[] r2 = r2.listFiles(r3)
                return r2
            L_0x0012:
                db.b r3 = new db.b
                r3.<init>()
                goto L_0x000d
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.lite.common.log.logwrite.LogWrite.getExistedFiles(java.io.File, java.lang.String):java.io.File[]");
        }

        private FileParam getFileInfo(String str) {
            if (this.fileInfoMap.containsKey(str)) {
                return this.fileInfoMap.get(str);
            }
            FileParam fileParam = new FileParam();
            String str2 = this.logDirPath;
            if (!str.equals(LogWriteConstants.LOG_TYPE) && str.equals("location")) {
                str2 = this.logDirPath + LogWriteConstants.DEBUG_PATH + LogWriteConstants.LOCATION_PATH;
            }
            fileParam.setFileDirPath(str2);
            this.fileInfoMap.put(str, fileParam);
            return fileParam;
        }

        private long getFileSavaTimeMill(File file) throws SecurityException {
            return file.lastModified();
        }

        private String getMsgByFileType(AppLog appLog) {
            if (appLog.getFileType().equals("location")) {
                Locale locale = Locale.ENGLISH;
                return String.format(locale, LogWriteConstants.LOCATION_MSG_FORMAT, new Object[]{appLog.getMsg() + System.lineSeparator()});
            }
            Locale locale2 = Locale.ENGLISH;
            return String.format(locale2, LogWriteConstants.LOG_MSG_FORMAT, new Object[]{getNow(), appLog.getLevel(), appLog.getTag(), appLog.getMsg() + System.lineSeparator() + Log.getStackTraceString(appLog.getTr())});
        }

        private String getNow() {
            return DateUtil.formate(Calendar.getInstance().getTime(), PATTERN_TWO);
        }

        public static boolean isEnableWriteLog() {
            return enableWriteLog;
        }

        private boolean isFileFull(String str, String str2, String str3) {
            File file = new File(str2, str3);
            boolean equals = str.equals("location");
            long length = file.length();
            return equals ? length > ((long) 1048576) : length > ((long) this.maxFileSize);
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ boolean lambda$getExistedFiles$0(File file, String str) {
            return str.startsWith("Location") && str.endsWith(".csv") && str.length() == 28 && JavaConstant.Dynamic.DEFAULT_NAME.equals(String.valueOf(str.charAt(17)));
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ boolean lambda$getExistedFiles$1(File file, String str) {
            return str.startsWith("Location") && str.endsWith(".log") && str.length() == 28 && JavaConstant.Dynamic.DEFAULT_NAME.equals(String.valueOf(str.charAt(17)));
        }

        private String makeLogFileName(String str) {
            String str2 = str.equals("location") ? ".csv" : ".log";
            String format = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Calendar.getInstance().getTime());
            return "Location." + format + str2;
        }

        private void openLogFile(FileParam fileParam) throws IOException {
            BufferedWriter writer = fileParam.getWriter();
            String fileDirPath = fileParam.getFileDirPath();
            String fileName = fileParam.getFileName();
            if (writer != null) {
                return;
            }
            if (TextUtils.isEmpty(fileDirPath) || TextUtils.isEmpty(fileName)) {
                Log.e(TAG, "openLogFile Exception");
                return;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(new File(fileDirPath, fileName), true);
            synchronized (LogWrite.class) {
                fileParam.setWriter(new BufferedWriter(new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8)));
            }
        }

        private void pathExistsDeal(File file, FileParam fileParam, String str) throws IOException {
            boolean isFirstWrite = fileParam.isFirstWrite();
            String fileDirPath = fileParam.getFileDirPath();
            if (isFirstWrite) {
                filesNumAndUsefulCheck(fileDirPath, str);
                fileParam.setNeedCheck(false);
            }
            File[] existedFiles = getExistedFiles(file, str);
            if (existedFiles == null) {
                Log.e(TAG, "beforeWriteCheck  existedFiles is null");
            } else if (existedFiles.length == 0) {
                Log.i(TAG, "beforeWriteCheck  Path Exist -- No File -- Create File");
                fileParam.setNeedCheck(false);
                createNewLogFile(fileParam, makeLogFileName(str), str);
            } else {
                try {
                    Arrays.sort(existedFiles, new FileComparator());
                } catch (IllegalArgumentException unused) {
                    Log.e(TAG, "beforeWriteCheck Arrays sort IllegalArgumentException");
                }
                fileParam.setFileName(existedFiles[existedFiles.length - 1].getName());
            }
        }

        public static void setEnableWriteLog(boolean z11) {
            enableWriteLog = z11;
        }

        public void init(int i11, String str, int i12, int i13) {
            boolean z11;
            this.maxFileSize = i11 > 0 ? Math.min(i11, 2) * 1024 * 1024 : 2097152;
            int i14 = 20;
            if (i12 > 0) {
                i14 = Math.min(i12, 20);
            }
            this.maxFileNum = i14;
            this.maxFileExpired = i13 > 0 ? ((long) Math.min(i13, 5)) * 86400000 : 432000000;
            if (str != null) {
                this.logDirPath = str;
                z11 = true;
            } else {
                z11 = false;
            }
            setEnableWriteLog(z11);
            Log.i(TAG, "LogWrite init complete");
        }

        public boolean permissionCheck(String str) {
            String str2;
            if (str.startsWith(LogWriteConstants.INNER_PATH_DATA_USER1) || str.startsWith(LogWriteConstants.INNER_PATH_DATA_DATA1) || str.startsWith(LogWriteConstants.INNER_PATH_DATA_DATA) || str.startsWith(LogWriteConstants.INNER_PATH_DATA_USER)) {
                return true;
            }
            if (!PermissionUtil.checkSelfPermission(ContextUtil.getContext(), PermissionUtil.READ_EXTERNAL_PERMISSION)) {
                str2 = "READ_EXTERNAL_PERMISSION Permission check unPass";
            } else if (PermissionUtil.checkSelfPermission(ContextUtil.getContext(), PermissionUtil.WRITE_EXTERNAL_PERMISSION)) {
                return true;
            } else {
                str2 = "WRITE_EXTERNAL_PERMISSION Permission check unPass";
            }
            Log.e(TAG, str2);
            return false;
        }

        public void shutdown() {
            synchronized (LogWrite.class) {
                for (Map.Entry<String, FileParam> value : this.fileInfoMap.entrySet()) {
                    FileParam fileParam = (FileParam) value.getValue();
                    if (!(fileParam == null || fileParam.getWriter() == null)) {
                        try {
                            fileParam.getWriter().close();
                        } catch (IOException unused) {
                            Log.e(TAG, "shutdown IOException");
                        }
                        fileParam.setWriter((BufferedWriter) null);
                    }
                }
            }
        }

        public void writeToFile(AppLog appLog) {
            if (enableWriteLog) {
                String fileType = appLog.getFileType();
                synchronized (LogWrite.class) {
                    try {
                        FileParam fileInfo = getFileInfo(fileType);
                        if (SDKComponentType.getComponentType() != 100 || permissionCheck(this.logDirPath)) {
                            beforeWriteCheck(fileInfo, fileType);
                            if (!TextUtils.isEmpty(fileInfo.getFileName())) {
                                if (isFileFull(fileType, fileInfo.getFileDirPath(), fileInfo.getFileName())) {
                                    fileInfo.setNeedCheck(true);
                                    createNewLogFile(fileInfo, makeLogFileName(fileType), fileType);
                                } else {
                                    openLogFile(fileInfo);
                                }
                                doWrite(appLog, fileInfo);
                            }
                        }
                    } catch (IOException unused) {
                        Log.e(TAG, "writeToFile IOException");
                    }
                }
            }
        }
    }
