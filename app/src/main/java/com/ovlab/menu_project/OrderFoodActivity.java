package com.ovlab.menu_project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.Vector;

/**
 * Created by 김준영 on 2018-08-27.
 */

public class OrderFoodActivity extends Activity{

    private GridView gridView;
    private ImageView imageView;

    private int[] imageIds;
    private String[] food_names;
    private int[] food_price;
    public void initImage(){
        imageIds = new int[] {
                R.drawable.burger_big_mac,
                R.drawable.burger_bulgogi,
                R.drawable.burger_cheese,
                R.drawable.burger_double_bulgogi,
                R.drawable.burger_double_cheese,
                R.drawable.burger_golden_egg_cheese,
                R.drawable.burger_mega_mac,
                R.drawable.burger_original,
                R.drawable.burger_susu
        };

        food_names = new String[] {
                "빅맥 BLT",
                "불고기버거",
                "치즈버거",
                "더블 불고기버거",
                "더블 치즈버거",
                "골든에그 치즈버거",
                "메가 Mac",
                "햄버거",
                "슈슈버거"
        };

        food_price = new int[] {
                5600,   2100,   2100,
                4600,   4600,   7600,
                5900,   2100,   4600
        };
    }

    private Vector v;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_main_view);

        gridView = (GridView) findViewById(R.id.gridView_main);
        imageView = (ImageView) findViewById(R.id.imageView);

        initImage();

        v = new Vector();

        for(int i=0; i<food_names.length; i++) {
            v.add(new FoodDTO(food_names[i], food_price[i], imageIds[i]));
        }
        ImageGridAdapter adapter = new ImageGridAdapter(this, v);
        gridView.setAdapter(adapter);   // 그리드 뷰에 모든 상품메뉴 추가

        //  그리드뷰 itemClick이벤트
        // 아이템을 클릭 하면 해당 아이템에 대한 추가 할 수 있는 다이알로그가 뜬다.
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // int i = position,
                // 다이알 로그로 장바구니에 아이템 추가 해야함.
                // 화면은 메뉴 이미지, 가격, 개수 up & down 최종 가격, 추가 버튼
                Intent intent = new Intent(
                        getApplicationContext(),
                        AddFoodPopupActivity.class
                );
                FoodDTO item;
                item = (FoodDTO) v.get(i);
                intent.putExtra("name", item.getFood_name());
                intent.putExtra("price", item.getFood_price());
                intent.putExtra("imgId", item.getImgID());

                Log.d("name", item.getFood_name());
                Log.d("price", item.getFood_price()+"원");
                startActivity(intent);
            }
        });
    }
}