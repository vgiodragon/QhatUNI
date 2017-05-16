package com.smartcity.qhatuni.EditorialesBecas;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.smartcity.qhatuni.NewFragment;
import com.smartcity.qhatuni.R;


public class DetailUni extends NewFragment {

    String uni;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_stand, container, false);

        uni=getArguments().getString("layout");
        CollapsingToolbarLayout collapser = (CollapsingToolbarLayout)v.findViewById(R.id.collapser);
        collapser.setTitle(uni.toUpperCase());
        ((TextView) v.findViewById(R.id.nombre_stand)).setText(getResources().getString(getResources().getIdentifier("nombre_uni_" + uni, "string", getActivity().getPackageName())));
        ((TextView) v.findViewById(R.id.info_stand)).setText(getResources().getString(getResources().getIdentifier("info_uni_" + uni, "string", getActivity().getPackageName())));
        loadImageParallax(v, getResources().getIdentifier(uni, "drawable", getActivity().getPackageName()));
        ((TextView) v.findViewById(R.id.contacto)).setText(getResources().getString(getResources().getIdentifier("contacto_uni_" + uni, "string", getActivity().getPackageName())));
        v.findViewById(R.id.irstand).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(getString(getResources().getIdentifier("pagina_uni_" + uni, "string", getActivity().getPackageName()))));
                startActivity(intent);
            }
        });
        return v;
    }

    public static void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null)
            return;

        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.UNSPECIFIED);
        int totalHeight = 0;
        View view = null;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            view = listAdapter.getView(i, view, listView);
            if (i == 0)
                view.setLayoutParams(new ViewGroup.LayoutParams(desiredWidth, RadioGroup.LayoutParams.WRAP_CONTENT));

            view.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
            totalHeight += view.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }

    private void loadImageParallax(View v,int id){
        ImageView image = (ImageView)v.findViewById(R.id.image_paralax);
        image.setImageResource(id);
    }
}
