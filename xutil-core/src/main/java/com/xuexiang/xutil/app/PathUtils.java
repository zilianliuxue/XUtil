/*
 * Copyright (C) 2018 xuexiangjys(xuexiangjys@163.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.xuexiang.xutil.app;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.CursorLoader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.RequiresPermission;
import android.support.v4.content.FileProvider;

import com.xuexiang.xutil.XUtil;

import java.io.File;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;

/**
 * <pre>
 *     desc   : 路径相关工具类
 *     author : xuexiang
 *     time   : 2018/5/5 上午12:16
 * </pre>
 */
public final class PathUtils {

    private PathUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * 获取 Android 系统根目录
     * <pre>path: /system</pre>
     *
     * @return 系统根目录
     */
    public static String getRootPath() {
        return Environment.getRootDirectory().getAbsolutePath();
    }

    /**
     * 获取 data 目录
     * <pre>path: /data</pre>
     *
     * @return data 目录
     */
    public static String getDataPath() {
        return Environment.getDataDirectory().getAbsolutePath();
    }

    /**
     * 获取缓存目录
     * <pre>path: data/cache</pre>
     *
     * @return 缓存目录
     */
    public static String getIntDownloadCachePath() {
        return Environment.getDownloadCacheDirectory().getAbsolutePath();
    }

    /**
     * 获取此应用的缓存目录
     * <pre>path: /data/data/package/cache</pre>
     *
     * @return 此应用的缓存目录
     */
    public static String getAppIntCachePath() {
        return XUtil.getContext().getCacheDir().getAbsolutePath();
    }

    /**
     * 获取此应用的文件目录
     * <pre>path: /data/data/package/files</pre>
     *
     * @return 此应用的文件目录
     */
    public static String getAppIntFilesPath() {
        return XUtil.getContext().getFilesDir().getAbsolutePath();
    }

    /**
     * 获取此应用的数据库文件目录
     * <pre>path: /data/data/package/databases/name</pre>
     *
     * @param name 数据库文件名
     * @return 数据库文件目录
     */
    public static String getAppIntDbPath(String name) {
        return XUtil.getContext().getDatabasePath(name).getAbsolutePath();
    }

    /**
     * 获取 Android 外置储存的根目录
     * <pre>path: /storage/emulated/0</pre>
     *
     * @return 外置储存根目录
     */
    public static String getExtStoragePath() {
        return Environment.getExternalStorageDirectory().getAbsolutePath();
    }

    /**
     * 获取闹钟铃声目录
     * <pre>path: /storage/emulated/0/Alarms</pre>
     *
     * @return 闹钟铃声目录
     */
    public static String getExtAlarmsPath() {
        return Environment
                .getExternalStoragePublicDirectory(Environment.DIRECTORY_ALARMS)
                .getAbsolutePath();
    }

    /**
     * 获取相机拍摄的照片和视频的目录
     * <pre>path: /storage/emulated/0/DCIM</pre>
     *
     * @return 照片和视频目录
     */
    public static String getExtDcimPath() {
        return Environment
                .getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM)
                .getAbsolutePath();
    }

    /**
     * 获取文档目录
     * <pre>path: /storage/emulated/0/Documents</pre>
     *
     * @return 文档目录
     */
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static String getExtDocumentsPath() {
        return Environment
                .getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)
                .getAbsolutePath();
    }

    /**
     * 获取下载目录
     * <pre>path: /storage/emulated/0/Download</pre>
     *
     * @return 下载目录
     */
    public static String getExtDownloadsPath() {
        return Environment
                .getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
                .getAbsolutePath();
    }

    /**
     * 获取视频目录
     * <pre>path: /storage/emulated/0/Movies</pre>
     *
     * @return 视频目录
     */
    public static String getExtMoviesPath() {
        return Environment
                .getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES)
                .getAbsolutePath();
    }

    /**
     * 获取音乐目录
     * <pre>path: /storage/emulated/0/Music</pre>
     *
     * @return 音乐目录
     */
    public static String getExtMusicPath() {
        return Environment
                .getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC)
                .getAbsolutePath();
    }

    /**
     * 获取提示音目录
     * <pre>path: /storage/emulated/0/Notifications</pre>
     *
     * @return 提示音目录
     */
    public static String getExtNotificationsPath() {
        return Environment
                .getExternalStoragePublicDirectory(Environment.DIRECTORY_NOTIFICATIONS)
                .getAbsolutePath();
    }

    /**
     * 获取图片目录
     * <pre>path: /storage/emulated/0/Pictures</pre>
     *
     * @return 图片目录
     */
    public static String getExtPicturesPath() {
        return Environment
                .getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)
                .getAbsolutePath();
    }

    /**
     * 获取 Podcasts 目录
     * <pre>path: /storage/emulated/0/Podcasts</pre>
     *
     * @return Podcasts 目录
     */
    public static String getExtPodcastsPath() {
        return Environment
                .getExternalStoragePublicDirectory(Environment.DIRECTORY_PODCASTS)
                .getAbsolutePath();
    }

    /**
     * 获取铃声目录
     * <pre>path: /storage/emulated/0/Ringtones</pre>
     *
     * @return 下载目录
     */
    public static String getExtRingtonesPath() {
        return Environment
                .getExternalStoragePublicDirectory(Environment.DIRECTORY_RINGTONES)
                .getAbsolutePath();
    }

    /**
     * 获取此应用在外置储存中的缓存目录
     * <pre>path: /storage/emulated/0/Android/data/package/cache</pre>
     *
     * @return 此应用在外置储存中的缓存目录
     */
    public static String getAppExtCachePath() {
        return XUtil.getContext().getExternalCacheDir().getAbsolutePath();
    }

    /**
     * 获取此应用在外置储存中的文件目录
     * <pre>path: /storage/emulated/0/Android/data/package/files</pre>
     *
     * @return 此应用在外置储存中的文件目录
     */
    public static String getAppExtFilePath() {
        return XUtil.getContext().getExternalFilesDir(null).getAbsolutePath();
    }

    /**
     * 获取此应用在外置储存中的闹钟铃声目录
     * <pre>path: /storage/emulated/0/Android/data/package/files/Alarms</pre>
     *
     * @return 此应用在外置储存中的闹钟铃声目录
     */
    public static String getAppExtAlarmsPath() {
        return XUtil.getContext().getExternalFilesDir(Environment.DIRECTORY_ALARMS)
                .getAbsolutePath();
    }

    /**
     * 获取此应用在外置储存中的相机目录
     * <pre>path: /storage/emulated/0/Android/data/package/files/DCIM</pre>
     *
     * @return 此应用在外置储存中的相机目录
     */
    public static String getAppExtDcimPath() {
        return XUtil.getContext().getExternalFilesDir(Environment.DIRECTORY_DCIM)
                .getAbsolutePath();
    }

    /**
     * 获取此应用在外置储存中的文档目录
     * <pre>path: /storage/emulated/0/Android/data/package/files/Documents</pre>
     *
     * @return 此应用在外置储存中的文档目录
     */
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static String getAppExtDocumentsPath() {
        return XUtil.getContext().getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS)
                .getAbsolutePath();
    }

    /**
     * 获取此应用在外置储存中的下载目录
     * <pre>path: /storage/emulated/0/Android/data/package/files/Download</pre>
     *
     * @return 此应用在外置储存中的闹钟目录
     */
    public static String getAppExtDownloadPath() {
        return XUtil.getContext().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS)
                .getAbsolutePath();
    }

    /**
     * 获取此应用在外置储存中的视频目录
     * <pre>path: /storage/emulated/0/Android/data/package/files/Movies</pre>
     *
     * @return 此应用在外置储存中的视频目录
     */
    public static String getAppExtMoviesPath() {
        return XUtil.getContext().getExternalFilesDir(Environment.DIRECTORY_MOVIES)
                .getAbsolutePath();
    }

    /**
     * 获取此应用在外置储存中的音乐目录
     * <pre>path: /storage/emulated/0/Android/data/package/files/Music</pre>
     *
     * @return 此应用在外置储存中的音乐目录
     */
    public static String getAppExtMusicPath() {
        return XUtil.getContext().getExternalFilesDir(Environment.DIRECTORY_MUSIC)
                .getAbsolutePath();
    }

    /**
     * 获取此应用在外置储存中的提示音目录
     * <pre>path: /storage/emulated/0/Android/data/package/files/Notifications</pre>
     *
     * @return 此应用在外置储存中的提示音目录
     */
    public static String getAppExtNotificationsPath() {
        return XUtil.getContext().getExternalFilesDir(Environment.DIRECTORY_NOTIFICATIONS)
                .getAbsolutePath();
    }

    /**
     * 获取此应用在外置储存中的图片目录
     * <pre>path: /storage/emulated/0/Android/data/package/files/Pictures</pre>
     *
     * @return 此应用在外置储存中的图片目录
     */
    public static String getAppExtPicturesPath() {
        return XUtil.getContext().getExternalFilesDir(Environment.DIRECTORY_PICTURES)
                .getAbsolutePath();
    }

    /**
     * 获取此应用在外置储存中的 Podcasts 目录
     * <pre>path: /storage/emulated/0/Android/data/package/files/Podcasts</pre>
     *
     * @return 此应用在外置储存中的 Podcasts 目录
     */
    public static String getAppExtPodcastsPath() {
        return XUtil.getContext().getExternalFilesDir(Environment.DIRECTORY_PODCASTS)
                .getAbsolutePath();
    }

    /**
     * 获取此应用在外置储存中的铃声目录
     * <pre>path: /storage/emulated/0/Android/data/package/files/Ringtones</pre>
     *
     * @return 此应用在外置储存中的铃声目录
     */
    public static String getAppExtRingtonesPath() {
        return XUtil.getContext().getExternalFilesDir(Environment.DIRECTORY_RINGTONES)
                .getAbsolutePath();
    }

    /**
     * 获取此应用的 Obb 目录
     * <pre>path: /storage/emulated/0/Android/obb/package</pre>
     * <pre>一般用来存放游戏数据包</pre>
     *
     * @return 此应用的 Obb 目录
     */
    public static String getObbPath() {
        return XUtil.getContext().getObbDir().getAbsolutePath();
    }


    /**
     * 将媒体文件转化为资源定位符
     *
     * @param mediaFile 媒体文件
     * @return
     */
    public static Uri getMediaContentUri(File mediaFile) {
        return getMediaContentUri(XUtil.getContext(), mediaFile);
    }

    /**
     * 将媒体文件转化为资源定位符
     *
     * @param context
     * @param mediaFile 媒体文件
     * @return
     */
    public static Uri getMediaContentUri(Context context, File mediaFile) {
        String filePath = mediaFile.getAbsolutePath();
        Cursor cursor = context.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                new String[]{MediaStore.Images.Media._ID}, MediaStore.Images.Media.DATA + "=? ",
                new String[]{filePath}, null);
        if (cursor != null && cursor.moveToFirst()) {
            int id = cursor.getInt(cursor.getColumnIndex(MediaStore.MediaColumns._ID));
            Uri baseUri = Uri.parse("content://media/external/images/media");
            return Uri.withAppendedPath(baseUri, "" + id);
        } else {
            if (mediaFile.exists()) {
                ContentValues values = new ContentValues();
                values.put(MediaStore.Images.Media.DATA, filePath);
                return context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
            } else {
                return null;
            }
        }
    }

    /**
     * Return a content URI for a given file.
     *
     * @param file The file.
     * @return a content URI for a given file
     */
    @Nullable
    public static Uri getUriForFile(final File file) {
        if (file == null) return null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            String authority = XUtil.getContext().getPackageName() + ".xutil.provider";
            return FileProvider.getUriForFile(XUtil.getContext(), authority, file);
        } else {
            return Uri.fromFile(file);
        }
    }

    /**
     * Uri to file.
     *
     * @param uri        The uri.
     * @param columnName The name of the target column.
     *                   <p>e.g. {@link MediaStore.Images.Media#DATA}</p>
     * @return file
     */
    public static File uri2File(final Uri uri, final String columnName) {
        if (uri == null) return null;
        CursorLoader cl = new CursorLoader(XUtil.getContext());
        cl.setUri(uri);
        cl.setProjection(new String[]{columnName});
        Cursor cursor = cl.loadInBackground();
        int columnIndex = cursor.getColumnIndexOrThrow(columnName);
        cursor.moveToFirst();
        return new File(cursor.getString(columnIndex));
    }

    /**
     * 根据uri获取文件的绝对路径，解决Android 4.4以上 根据uri获取路径的方法
     *
     * @param uri
     * @return
     */
    @SuppressLint("MissingPermission")
    @RequiresPermission(READ_EXTERNAL_STORAGE)
    public static String getFilePathByUri(Uri uri) {
        return getFilePathByUri(XUtil.getContext(), uri);
    }

    /**
     * 根据uri获取文件的绝对路径，解决Android 4.4以上 根据uri获取路径的方法
     *
     * @param context
     * @param uri
     * @return
     */
    @SuppressLint("MissingPermission")
    @RequiresPermission(READ_EXTERNAL_STORAGE)
    public static String getFilePathByUri(Context context, Uri uri) {
        if (context == null || uri == null) return null;

        String path = null;
        // 以 file:// 开头的
        if (ContentResolver.SCHEME_FILE.equals(uri.getScheme())) {
            path = uri.getPath();
            return path;
        }
        // 以 content:// 开头的，比如 content://media/extenral/images/media/17766
        if (ContentResolver.SCHEME_CONTENT.equals(uri.getScheme()) && Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
            Cursor cursor = context.getContentResolver().query(uri, new String[]{MediaStore.Images.Media.DATA}, null, null, null);
            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    int columnIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
                    if (columnIndex > -1) {
                        path = cursor.getString(columnIndex);
                    }
                }
                cursor.close();
            }
            return path;
        }
        // 4.4及之后的 是以 content:// 开头的，比如 content://com.android.providers.media.documents/document/image%3A235700
        if (ContentResolver.SCHEME_CONTENT.equals(uri.getScheme()) && Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT && DocumentsContract.isDocumentUri(context, uri)) {
            if (isExternalStorageDocument(uri)) {
                String docId = DocumentsContract.getDocumentId(uri);
                String[] split = docId.split(":");
                String type = split[0];
                if ("primary".equalsIgnoreCase(type)) {
                    return Environment.getExternalStorageDirectory() + "/" + split[1];
                }
            } else if (isDownloadsDocument(uri)) {
                String id = DocumentsContract.getDocumentId(uri);
                Uri contentUri = ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(id));
                return getDataColumn(context, contentUri, null, null);
            } else if (isMediaDocument(uri)) {
                String docId = DocumentsContract.getDocumentId(uri);
                String[] split = docId.split(":");
                String type = split[0];
                Uri contentUri = null;
                if ("image".equals(type)) {
                    contentUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                } else if ("video".equals(type)) {
                    contentUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                } else if ("audio".equals(type)) {
                    contentUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                }
                String selection = MediaStore.Images.Media._ID + "=?";
                String[] selectionArgs = new String[]{split[1]};
                return getDataColumn(context, contentUri, selection, selectionArgs);
            }
        } // MediaStore (and general)
        else if ("content".equalsIgnoreCase(uri.getScheme())) {
            // Return the remote address
            if (isGooglePhotosUri(uri))
                return uri.getLastPathSegment();
            return getDataColumn(context, uri, null, null);
        }
        // File
        else if ("file".equalsIgnoreCase(uri.getScheme())) {
            return uri.getPath();
        }
        return null;
    }

    private static String getDataColumn(Context context, Uri uri, String selection, String[] selectionArgs) {
        Cursor cursor = null;
        final String column = "_data";
        final String[] projection = {column};
        try {
            cursor = context.getContentResolver().query(uri, projection, selection, selectionArgs, null);
            if (cursor != null && cursor.moveToFirst()) {
                final int column_index = cursor.getColumnIndexOrThrow(column);
                return cursor.getString(column_index);
            }
        } finally {
            if (cursor != null)
                cursor.close();
        }
        return null;
    }

    private static boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    private static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    private static boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    /**
     * @param uri The Uri to check.
     * @return Whether the Uri authority is Google Photos.
     */
    public static boolean isGooglePhotosUri(Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }

}
