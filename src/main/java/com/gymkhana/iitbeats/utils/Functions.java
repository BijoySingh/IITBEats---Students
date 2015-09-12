package com.gymkhana.iitbeats.utils;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.gymkhana.iitbeats.R;
import com.gymkhana.iitbeats.items.MenuItem;
import com.gymkhana.iitbeats.viewholder.DialogViewHolder;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by Bijoy on 3/6/2015.
 * This file is the core function file of the entire application
 * All the functions here are static functions and form the basis of the app
 */
public class Functions {

    private static ImageLoader mImageLoader;

    //It store the filedata into the file given by the filename
    public static void offlineDataWriter(Context context, String filename, String filedata) {
        try {
            FileOutputStream fos = context.openFileOutput(filename, Context.MODE_PRIVATE);
            fos.write(filedata.getBytes());
            fos.close();
        } catch (Exception e) {
            ;
        }

    }

    public static String correctUTFEncoding(String source) {
        try {
            return new String(source.getBytes("ISO-8859-1"), "UTF-8");
        } catch (Exception e) {
            return source;
        }
    }

    //Reads the data stored in the file given by the filename
    public static String offlineDataReader(Context context, String filename) {

        try {
            FileInputStream fis = context.openFileInput(filename);
            StringBuilder builder = new StringBuilder();
            int ch;
            while ((ch = fis.read()) != -1) {
                builder.append((char) ch);
            }

            return builder.toString();
        } catch (Exception e) {
            ;
        }

        return "";
    }

    //Makes a toast(this is much cleaner than the code for toast)
    public static void makeToast(Context context, String text) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }

    //Makes a toast(this is much cleaner than the code for toast) from resources
    public static void makeToast(Context context, Integer textId) {
        Toast.makeText(context, context.getString(textId), Toast.LENGTH_SHORT).show();
    }

    //Sets the actionbar title
    public static void setActionBarTitle(ActionBarActivity activity, String title) {
        ActionBar ab = activity.getSupportActionBar();
        ab.setTitle(title);
    }

    //Setup the actionbar of the activity
    public static void setActionBar(ActionBarActivity activity) {
        setActionBar(activity, R.color.primary_color, R.color.primary_dark_color);
    }

    //Setup the actionbar of the activity
    public static void setActionBarWithColor(ActionBarActivity activity,
                                             int actionbarColor,
                                             int navigationColor) {
        ActionBar ab = activity.getSupportActionBar();
        ab.setBackgroundDrawable(new ColorDrawable(actionbarColor));
        ab.setDisplayHomeAsUpEnabled(true);
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = activity.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(navigationColor);
            //window.setNavigationBarColor(navigationColor);
        }
    }

    //Setup the actionbar of the activity
    public static void setActionBar(ActionBarActivity activity,
                                    int action_bar_color_resource,
                                    int navigation_bar_color_resource) {
        setActionBarWithColor(activity,
                activity.getResources().getColor(action_bar_color_resource),
                activity.getResources().getColor(navigation_bar_color_resource));
    }

    //Hide the actionbar of the activity
    public static void hideActionBar(ActionBarActivity activity) {
        ActionBar ab = activity.getSupportActionBar();
        ab.hide();
    }

    //Gets a dialog which is transparent
    public static Dialog getTransparentDialog(Context context, Integer layout, Integer color) {
        Dialog dialog = new Dialog(context);
        dialog.setContentView(layout);

        final Window d_window = dialog.getWindow();
        d_window.setBackgroundDrawable(new ColorDrawable(color));
        return dialog;
    }

    public static String cropString(String str, Integer length) {
        if (str.length() <= length) {
            return str;
        } else {
            str = str.substring(0, length - 3);
            str += "...";
            return str;
        }
    }

    public static float convertDpToPixel(float dp, Context context) {
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float px = dp * (metrics.densityDpi / 160f);
        return px;
    }

    public static void openWebsite(Context context, String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        context.startActivity(intent);
    }

    public static Intent openAppStore(String packageName) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setData(Uri.parse("market://details?id=" + packageName));

        return intent;
    }

    public static Intent openApp(Context context, String packageName) {
        Intent intent = context.getPackageManager().getLaunchIntentForPackage(packageName);
        if (intent != null) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            return intent;
        } else {
            return openAppStore(packageName);
        }
    }

    public static void callPhone(Context context, String phone) {
        PackageManager pm = context.getPackageManager();

        if (pm.hasSystemFeature(PackageManager.FEATURE_TELEPHONY)) {
            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phone));
            context.startActivity(intent);
        } else {
            Functions.makeToast(context, "It seems your device doesn't support calling!");
        }
    }

    public static String showVolleyError(VolleyError error) {
        if (error != null && error.networkResponse != null && error.networkResponse.data != null) {
            return new String(error.networkResponse.data);
        }

        String error_message = error.getMessage();
        if (error_message == null)
            return "ERROR";

        return error_message;
    }

    public static ImageLoader loadImageLoader(Context context) {
        if (mImageLoader != null)
            return mImageLoader;

        DisplayImageOptions displayImageOptions = new DisplayImageOptions.Builder()
                .cacheOnDisk(true)
                .cacheInMemory(true)
                .build();

        ImageLoaderConfiguration.Builder config = new ImageLoaderConfiguration.Builder(context);
        config.threadPriority(Thread.NORM_PRIORITY - 2);
        config.defaultDisplayImageOptions(displayImageOptions);
        config.denyCacheImageMultipleSizesInMemory();
        config.diskCacheFileNameGenerator(new Md5FileNameGenerator());
        config.diskCacheSize(50 * 1024 * 1024); // 50 MiB
        config.tasksProcessingOrder(QueueProcessingType.LIFO);
        config.writeDebugLogs(); // Remove for release app
        ImageLoader.getInstance().init(config.build());

        mImageLoader = ImageLoader.getInstance();
        return mImageLoader;
    }


    public static Dialog createOrderDialog(Context context, MenuItem item) {
        final Dialog dialog = getTransparentDialog(context, R.layout.order_dialog,
                Color.TRANSPARENT);
        DialogViewHolder holder = new DialogViewHolder(dialog);
        holder.name.setText(item.food_item.name);
        holder.vegetarian.setImageResource(item.food_item.getVegetarianResource());
        holder.categories.setText(item.food_item.getCategories());
        holder.quantity.setText("1");
        holder.price.setText(item.getPrice());
        return dialog;
    }

}
