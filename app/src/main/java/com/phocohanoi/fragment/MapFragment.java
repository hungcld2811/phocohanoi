package com.phocohanoi.fragment;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.phocohanoi.R;
import com.phocohanoi.adapter.BigVisitAdapter;
import com.phocohanoi.model.BigVisit;

import java.util.ArrayList;
import java.util.List;

public class MapFragment extends Fragment {

    private RecyclerView recyclerView;
    private BigVisitAdapter bigVisitAdapter;
    private List<BigVisit> bigVisitList;


    public MapFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_map, container, false);

        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.frg);  //use SuppoprtMapFragment for using in fragment instead of activity  MapFragment = activity   SupportMapFragment = fragment
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap mMap) {
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

                mMap.clear(); //clear old markers

                CameraPosition googlePlex = CameraPosition.builder()
                        .target(new LatLng(21.030231,105.835652))
                        .zoom(15)
                        .bearing(0)
//                        .tilt(45)
                        .build();

                mMap.animateCamera(CameraUpdateFactory.newCameraPosition(googlePlex), 5000, null);
            }
        });



        recyclerView = (RecyclerView) rootView.findViewById(R.id.mapList);

        bigVisitList = new ArrayList<>();
        bigVisitAdapter = new BigVisitAdapter(getActivity(), bigVisitList);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(bigVisitAdapter);

        prepareList();

        return rootView;
    }

    private BitmapDescriptor bitmapDescriptorFromVector(Context context, int vectorResId) {
        Drawable vectorDrawable = ContextCompat.getDrawable(context, vectorResId);
        vectorDrawable.setBounds(0, 0, vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight());
        Bitmap bitmap = Bitmap.createBitmap(vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        vectorDrawable.draw(canvas);
        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }

    private void prepareList() {
        BigVisit big1 = new BigVisit("https://i.ytimg.com/vi/tyejzT4nQcU/hqdefault.jpg","Ngôi nhà di sản","87 Mã Mây","ĐỊA ĐIỂM THĂM QUAN");
        BigVisit big2 = new BigVisit("https://media.doisongvietnam.vn/u/rootimage/editor/2018/09/18/21/34/w825/img1537259674_7219.jpg","Viện bảo tàng","1 Phùng Hưng","ĐỊA ĐIỂM THĂM QUAN");
        BigVisit big3 = new BigVisit("https://image-us.eva.vn/upload/4-2018/images/2018-12-04/yaya-truong-nhi-khoe-body-van-nguoi-me-cung-than-sac-khong-kem-hoa-hau-11-1543909541-863-width660height441.jpg","Ốc quán","113 Yên Hòa","ĐỊA ĐIỂM THĂM QUAN");
        BigVisit big4 = new BigVisit("https://icdn.dantri.com.vn/thumb_w/640/59245d4683/2018/12/04/img20181204143303578-f1c3f.jpg","Bưu điện Hà Nội","75 Đinh Tiên Hoàng","ĐỊA ĐIỂM THĂM QUAN");
        BigVisit big5 = new BigVisit("https://image-us.eva.vn/upload/4-2018/images/2018-12-04/yaya-truong-nhi-khoe-body-van-nguoi-me-cung-than-sac-khong-kem-hoa-hau-1-1543909541-425-width660height441.jpg","Ngôi nhà di sản","87 Mã Mây","ĐỊA ĐIỂM THĂM QUAN");
        BigVisit big6 = new BigVisit("https://i.ytimg.com/vi/tyejzT4nQcU/hqdefault.jpg","Ngôi nhà di sản","87 Mã Mây","ĐỊA ĐIỂM THĂM QUAN");
        bigVisitList.add(big1);
        bigVisitList.add(big2);
        bigVisitList.add(big3);
        bigVisitList.add(big4);
        bigVisitList.add(big5);
        bigVisitList.add(big6);
    }

}
