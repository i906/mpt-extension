package com.i906.mpt.extension;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;

/**
 * @author Noorzaini Ilhami
 */
public class Utils {

    public static final String MPT_PACKAGE = "com.i906.mpt";
    public static final String ACTION_EXTENSION_PICKER = "com.i906.mpt.action.EXTENSION_PICKER";

    public static boolean isMptAvailable(Context context) {
        PackageManager packageManager = context.getPackageManager();

        try {
            PackageInfo pi = packageManager.getPackageInfo(MPT_PACKAGE, 0);
            int vc = pi.versionCode;
            return vc > 3000;
        } catch (Exception ignored) {
        }

        return false;
    }

    public static boolean openMptSettings(Context context) {
        Intent intent = new Intent(ACTION_EXTENSION_PICKER);

        try {
            context.startActivity(intent);
            return true;
        } catch (Exception ignored) {
            ignored.printStackTrace();
        }

        return false;
    }

    public static void openMptPlayStore(Context context) {
        try {
            context.startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("market://details?id=" + MPT_PACKAGE)));
        } catch (android.content.ActivityNotFoundException anfe) {
            context.startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://play.google.com/store/apps/details?id=" + MPT_PACKAGE)));
        }
    }
}
