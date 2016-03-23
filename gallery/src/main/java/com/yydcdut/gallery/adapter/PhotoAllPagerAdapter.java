package com.yydcdut.gallery.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.yydcdut.gallery.R;
import com.yydcdut.gallery.model.MediaPhoto;

import java.util.List;

import uk.co.senab.photoview.PhotoView;

/**
 * Created by yuyidong on 16/3/22.
 */
public class PhotoAllPagerAdapter extends AbsPhotoPagerAdapter {
    private List<MediaPhoto> mMediaPhotoList;

    public PhotoAllPagerAdapter(List<MediaPhoto> mediaPhotoList) {
        mMediaPhotoList = mediaPhotoList;
    }

    @Override
    public int getCount() {
        return mMediaPhotoList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.item_pager_photo, null);
        PhotoView imageView = (PhotoView) view.findViewById(R.id.img_item_detail);
        ImageLoader.getInstance().displayImage("file:/" + mMediaPhotoList.get(position).getPath(), imageView);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}