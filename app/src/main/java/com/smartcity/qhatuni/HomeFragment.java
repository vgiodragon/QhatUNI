package com.smartcity.qhatuni;

import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


public class HomeFragment extends NewFragment {

    private ImageView tw,inst;
    static String hashStags="#QhatUNI #FeriaLibro #CTIC";
    int conexion=0; // sirve para las conexiones a face,twitter,instagram
    static final int REQUEST_TAKE_PHOTO_INSTAGRAM = 1; // toma foto para instagram
    static String qhatuniDir = Environment.getExternalStorageDirectory().toString() + "/QhatUNI/Images/";
    private File photoToShare; // imagen creada despues de tomar foto


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        //FacebookSdk.sdkInitialize(getContext());
        initInstancesDrawer(v);
        return v;
    }

    // llamda a instancias **
    private void initInstancesDrawer(View v) {
        tw = (ImageView) v.findViewById(R.id.ttwtIv);
        inst = (ImageView) v.findViewById(R.id.instIv);

        tw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharePostTwitter(hashStags, "twitter");
            }
        });
        inst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                photoToShare = takePicturePost(REQUEST_TAKE_PHOTO_INSTAGRAM);
            }
        });
    }

    // creamos el directorio QhatUNI y guardamos imagenes **
    public File saveFileQhatUNI() {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File direct = new File(Environment.getExternalStorageDirectory() + "/QhatUNI/Images/");
        File file = new File(Environment.getExternalStorageDirectory() + "/QhatUNI/Images/qhatuni_"+timeStamp+"_.png");

        if(!direct.exists()) {
            if (!direct.mkdirs()) {
                Log.e("TravellerLog :: ", "Problema al crear el folder");
            }
        }
        return file;
    }

    // toma la foto haciendo un intent a la camara, y retorna con valores **
    // y la guarda usando la funcion saveFileQhatuni
    private File takePicturePost(int Request) {
        Intent takePictureIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        File image = saveFileQhatUNI();
        Uri uriSavedImage = Uri.fromFile(image);
        takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, uriSavedImage);
        if (takePictureIntent.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, Request);
        }
        return image;
    }

    // al retornar al activity ejecuta esta accion **
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode) {

            case REQUEST_TAKE_PHOTO_INSTAGRAM:
                if (resultCode == getActivity().RESULT_OK) {
                    Uri uri = getImageUri(photoToShare);
                    sharePhotoInstagram(uri, "instagram");
                }
                break;
        }
    }

    // mandamos la ultima imagen de nuestro directorio whatuni **
    public Uri getImageUri(File photo) {
        //String fileName = "qhatuni_20160430_112433_.png";
        //File f = saveFileQhatUNI();
        //Log.d("nombre de la foto :D Meow",f.getName());
        // retorna la imagen
        Uri uri = Uri.parse("file:///" + qhatuniDir + photo.getName());
        return uri;
    }



    // Twitter **
    public void sharePostTwitter(String txtUri,final String sharingapp) {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/*");
        shareIntent.putExtra(android.content.Intent.EXTRA_TEXT, txtUri);
        PackageManager pm = getActivity().getPackageManager();
        List<ResolveInfo> activityList = pm.queryIntentActivities(shareIntent, 0);
        for (final ResolveInfo app : activityList) {
            if ((app.activityInfo.name).contains(sharingapp)) {
                conexion++;
                final ActivityInfo activity = app.activityInfo;
                final ComponentName name = new ComponentName(activity.applicationInfo.packageName, activity.name);
                shareIntent.addCategory(Intent.CATEGORY_LAUNCHER);
                shareIntent.setComponent(name);
                startActivity(shareIntent);
                break;
            }

        }
        if (conexion == 1 || conexion==2)
            conexion = 0;
        else {
            final AlertDialog.Builder alertDialog = new AlertDialog.Builder(getContext());
            alertDialog.setTitle("Alert");
            alertDialog.setMessage("No tienes instalado " + sharingapp);
            alertDialog.setPositiveButton("OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,
                                            int which) {
                            dialog.dismiss();
                            getApplicationSharing(sharingapp);
                        }
                    });
            alertDialog.show();
        }
    }

    // instagram **
    public void sharePhotoInstagram(Uri pngUri, final String sharingapp) {
        Intent shareIntent = new Intent(android.content.Intent.ACTION_SEND);
        shareIntent.setType("image/*");
        shareIntent.putExtra(android.content.Intent.EXTRA_STREAM, pngUri);
        PackageManager pm = getActivity().getPackageManager();
        List<ResolveInfo> activityList = pm.queryIntentActivities(shareIntent, 0);
        for (final ResolveInfo app : activityList) {
            if ((app.activityInfo.name).contains(sharingapp)) {
                conexion++;
                final ActivityInfo activity = app.activityInfo;
                final ComponentName name = new ComponentName(activity.applicationInfo.packageName, activity.name);
                shareIntent.addCategory(Intent.CATEGORY_LAUNCHER);
                shareIntent.setComponent(name);
                startActivity(shareIntent);
                break;
            }

        }
        if (conexion == 1)
            conexion = 0;
        else {
            final AlertDialog.Builder alertDialog = new AlertDialog.Builder(getContext());
            alertDialog.setTitle("Alert");
            alertDialog.setMessage("No tienes instalado " + sharingapp);
            alertDialog.setPositiveButton("OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,
                                            int which) {
                            dialog.dismiss();
                            getApplicationSharing(sharingapp);
                        }
                    });
            alertDialog.show();
        }
    }

    // hace intent hacia google store por si no tenemos las apps **
    public void getApplicationSharing(String sharingapp){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        String rutaGStore = null;
        if(sharingapp.equals("instagram")) rutaGStore = "com.instagram.android";
        else if(sharingapp.equals("twitter")) rutaGStore = "com.twitter.android";
        intent.setData(Uri.parse("market://details?id=" + rutaGStore));
        startActivity(intent);
    }
}