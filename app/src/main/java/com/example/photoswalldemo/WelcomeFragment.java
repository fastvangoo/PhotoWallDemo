package com.example.photoswalldemo;

import android.app.Fragment;
import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

/**
 * Created by vangoo on 17/2/12.
 */

public class WelcomeFragment extends Fragment {


    private int mImageThumbSize;

    private int mImageThumbSpacing;

    /**
     * GridView的适配器
     */
    private PhotoWallAdapter mAdapter;

    /**
     * 用于展示照片墙的GridView
     */
    private GridView mPhotoWall;

    private Button mBtnNext;

    private Context mContext;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View gallaryLayout = inflater.inflate(R.layout.fragment_gallary, container, false);

        mBtnNext = (Button) gallaryLayout.findViewById(R.id.btnNext2);

        mContext = getActivity();

        mBtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, NextPageActivity.class);
                startActivity(intent);
            }
        });

        mImageThumbSize = getResources().getDimensionPixelSize(
                R.dimen.image_thumbnail_size);
        mImageThumbSpacing = getResources().getDimensionPixelSize(
                R.dimen.image_thumbnail_spacing);
        mPhotoWall = (GridView) gallaryLayout.findViewById(R.id.photo_wall);
        mAdapter = new PhotoWallAdapter(this.getActivity(), 0, Images.imageThumbUrls,
                mPhotoWall);
        mPhotoWall.setAdapter(mAdapter);
        mPhotoWall.getViewTreeObserver().addOnGlobalLayoutListener(
                new ViewTreeObserver.OnGlobalLayoutListener() {

                    @Override
                    public void onGlobalLayout() {
                        final int numColumns = (int) Math.floor(mPhotoWall
                                .getWidth()
                                / (mImageThumbSize + mImageThumbSpacing));
                        if (numColumns > 0) {
                            int columnWidth = (mPhotoWall.getWidth() / numColumns)
                                    - mImageThumbSpacing;
                            mAdapter.setItemHeight(columnWidth);
                            mPhotoWall.getViewTreeObserver()
                                    .removeGlobalOnLayoutListener(this);
                        }
                    }
                });

        mPhotoWall.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d("AA", "AA");
                Log.d("AA" + i, "AA" + l);
                System.out.println("helloworld");


                Intent intent = new Intent(mContext, NextPageActivity.class);
                startActivity(intent);

            }
        });

        return gallaryLayout;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
