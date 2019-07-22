package com.phocohanoi.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.phocohanoi.R;
import com.phocohanoi.adapter.BigVisitAdapter;
import com.phocohanoi.model.BigVisit;

import java.util.ArrayList;
import java.util.List;

public class ListViewFragment extends Fragment {

    private RecyclerView recyclerView;
    private BigVisitAdapter bigVisitAdapter;
    private List<BigVisit> bigVisitList;

    public ListViewFragment() {
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
        View view = inflater.inflate(R.layout.fragment_list, container, false);


        recyclerView = (RecyclerView) view.findViewById(R.id.listBigVisit);

        bigVisitList = new ArrayList<>();
        bigVisitAdapter = new BigVisitAdapter(getActivity(), bigVisitList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 1);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(bigVisitAdapter);

        prepareList();
        
        return view;
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
