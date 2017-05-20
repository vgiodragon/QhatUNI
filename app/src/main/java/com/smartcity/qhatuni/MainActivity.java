package com.smartcity.qhatuni;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.smartcity.qhatuni.EditorialesBecas.PagerFragment;
import com.smartcity.qhatuni.GMapa.MapaFragment;

import java.util.List;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    /* Meow */
    static String hashStags="#QhatUNI #FeriaLibro #CTIC";
    private int anterior=1;
    ImageView twtMain,fbMain,instMain;
    int conexion=0; // sirve para las conexiones a face,twitter,instagram
    private final int code_request=1234;
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case code_request:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission Granted

                } else {
                    // Permission Denied
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    public void fbApp(View view){}
    public void instApp(View view){}

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(new String[]{Manifest.permission.CAMERA,Manifest.permission.ACCESS_COARSE_LOCATION,Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE}, code_request);
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fbMain = (ImageView) findViewById(R.id.fbbbutton);
        twtMain = (ImageView) findViewById(R.id.twttbutton);
        instMain = (ImageView) findViewById(R.id.insttbutton);

        fbMain.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
            }
        });

        twtMain.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //sharePostTwitter(hashStags,"twitter");
            }
        });

        instMain.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        if(savedInstanceState==null)
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.principal, new HomeFragment()).commit();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
            int m=getSupportFragmentManager().getBackStackEntryCount();
            if(m==0) {
                ((NavigationView) findViewById(R.id.nav_view)).setCheckedItem(R.id.info);
                anterior=R.id.info;
            }
        }
    }
/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }*/
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        int id = item.getItemId();
        if(id==anterior) return true;
        anterior=id;

        clearBackStack();
        switch(id) {
            case R.id.info:
                break;
            case R.id.feria:
                getSupportFragmentManager().beginTransaction()
                        .setCustomAnimations(R.anim.enter,R.anim.exit,R.anim.pop_enter,R.anim.pop_exit)
                        .replace(R.id.principal,new MapaFragment()).addToBackStack(null).commit();
                break;
            case R.id.cronog:
                getSupportFragmentManager().beginTransaction()
                        .setCustomAnimations(R.anim.enter,R.anim.exit,R.anim.pop_enter,R.anim.pop_exit)
                        .replace(R.id.principal,new CronogramaFragment()).addToBackStack(null).commit();
                break;
            case R.id.inst:
                getSupportFragmentManager().beginTransaction()
                        .setCustomAnimations(R.anim.enter,R.anim.exit,R.anim.pop_enter,R.anim.pop_exit)
                        .replace(R.id.principal,new PagerFragment()).addToBackStack(null).commit();
                break;
            case R.id.exp:
                getSupportFragmentManager().beginTransaction()
                        .setCustomAnimations(R.anim.enter,R.anim.exit,R.anim.pop_enter,R.anim.pop_exit)
                        .replace(R.id.principal,new MapFragment()).addToBackStack(null).commit();
                break;
            default:
        }
        return true;
    }
    public void clearBackStack() {
        NewFragment.sDisableFragmentAnimations = true;
        getSupportFragmentManager().popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        NewFragment.sDisableFragmentAnimations = false;
    }

    // Twitter **
    public void sharePostTwitter(String txtUri,final String sharingapp) {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/*");
        shareIntent.putExtra(android.content.Intent.EXTRA_TEXT, txtUri);
        PackageManager pm = getApplicationContext().getPackageManager();
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
            final AlertDialog.Builder alertDialog = new AlertDialog.Builder(getApplicationContext());
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
        if(sharingapp.equals("facebook")) rutaGStore="com.facebook.katana";
        else if(sharingapp.equals("instagram")) rutaGStore = "com.instagram.android";
        else if(sharingapp.equals("twitter")) rutaGStore = "com.twitter.android";
        intent.setData(Uri.parse("market://details?id=" + rutaGStore));
        startActivity(intent);
    }

}
