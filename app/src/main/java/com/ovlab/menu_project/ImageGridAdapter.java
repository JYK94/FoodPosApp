package com.ovlab.menu_project;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Vector;

/**
 * Created by 김준영 on 2018-08-27.
 */

public class ImageGridAdapter extends BaseAdapter{
    Context context = null;

    Vector item = null;

    String[] food_name = null;
    int[] food_price = null;
    int[] imageIds = null;

    FoodDTO dto = null;

    public ImageGridAdapter(Context context, Vector item){
        this.context = context;
        this.item = item;
    }

    @Override
    public int getCount() {
        return (item != null) ? item.size(): 0;
    }


    // getItem 받을 때 Vector 형으로 받으세요
    // imageIds, foodName, foodPrice 순  0, 1, 2
    @Override
    public FoodDTO getItem(int i) {
        return (item != null) ? (FoodDTO)item.get(i) : null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Context c = viewGroup.getContext();

        if (view == null)    {
            Log.d("g", "excute");
            LayoutInflater inflater = (LayoutInflater) c.getSystemService(c.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.food_image, viewGroup, false);
        }

        dto = (FoodDTO) item.get(i);

        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
        TextView txtView = (TextView) view.findViewById(R.id.tv_menu);
        //  ImageView 비트맵 정의
        //  크기 320*240
        /*Bitmap bitmap =
                BitmapFactory.decodeResource(context.getResources(),
                        dto.getImgID());

        bitmap = Bitmap.createScaledBitmap(bitmap,320,240,false);

        imageView = new ImageView(c);
        imageView.setAdjustViewBounds(true);
        imageView.setImageBitmap(bitmap);*/
        imageView.setImageResource(dto.getImgID());
       // imageView.setScaleType(ImageView.ScaleType.FIT_XY);

        Log.d("", "" + dto.getFood_name()+ "\n" + dto.getFood_price() + "원");
        txtView.setText("" + dto.getFood_name()+ "\n" + dto.getFood_price() + "원");
        return view;
    }
}
