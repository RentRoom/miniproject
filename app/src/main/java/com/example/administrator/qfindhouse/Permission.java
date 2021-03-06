package com.example.administrator.qfindhouse;

/**
 * Created by Administrator on 2017/11/21 0021.
 */
import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;


public class Permission {

    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE ,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
    };

    public static void verifyStoragePermissions(Activity activity) {
        int permission = ActivityCompat.checkSelfPermission(activity,
                Manifest.permission.READ_EXTERNAL_STORAGE);

        if (permission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity,
                    PERMISSIONS_STORAGE, REQUEST_EXTERNAL_STORAGE);
        }

    }
}