package com.mobile.schedule.environment.module;

import android.content.Context;
import android.os.Environment;


import com.mobile.schedule.base.IModule;

import java.io.File;

public class FileModule extends IModule {
    private static final String CACHE = "cache";

    private final String rootDir;
    public FileModule(Context context) {
        super(context);
        if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED))
            rootDir = Environment.getExternalStorageDirectory().toString() + File.separator + "schedule";
        else rootDir = context.getFilesDir().getPath();
    }

    public File getRootDir() {
        File dir = new File(rootDir);

        if(!dir.exists())
            dir.mkdirs();

        return dir;
    }

    public String getCacheFilePath(String filePath) {
        return getCacheFile(filePath).toString();
    }

    public File getCacheFile(String filePath) {
        return new File(getCacheDir(),filePath);
    }

    public File getCacheDir() {
        return getDir(CACHE);
    }

    private File getDir(String dirType) {
        File dir = new File(rootDir,dirType);

        if(!dir.exists())
            dir.mkdirs();

        return dir;
    }
}