package com.ovlab.menu_project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by 김준영 on 2018-08-29.
 */

public class AddFoodPopupActivity extends Activity{
    private String foodName;
    private int foodPrice;
    private int foodImgId;

    private TextView txtItemAddName, txtItemAddPrice, txtItemAddQuantity;
    private ImageView imgItemAdd;

    private Controller controller = Controller.getInstance();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.menu_add);

        txtItemAddName = (TextView) findViewById(R.id.txtItemAddName);
        txtItemAddPrice = (TextView) findViewById(R.id.txtItemAddPrice);
        txtItemAddQuantity = (TextView) findViewById(R.id.txtItemQuantity);
        imgItemAdd = (ImageView) findViewById(R.id.imgItemAdd);

        Intent intent = getIntent();

        foodName = intent.getStringExtra("name");
        foodPrice = intent.getIntExtra("price", 0);
        foodImgId = intent.getIntExtra("imgId", 0);

        txtItemAddName.setText(foodName);
        txtItemAddPrice.setText(foodPrice + "원");
        imgItemAdd.setImageResource(foodImgId);
    }

    // 주문량 개수 up&down
    public void quantityAdd(){
        int quantity = Integer.parseInt(txtItemAddQuantity.getText().toString());
        txtItemAddQuantity.setText(++quantity);
    }
    public void quantityMinus(){
        int quantity = Integer.parseInt(txtItemAddQuantity.getText().toString());
        if(quantity > 1){
            txtItemAddQuantity.setText(--quantity);
        }else{
            Toast.makeText(this, "이미 최소 주문량 입니다.", Toast.LENGTH_SHORT).show();
        }
    }


    // 추가 버튼 클릭 ( 상품명, 가격, 개수 입력  => 상품명, 가격, 이미지 id, 개수를 벡터에 추가
    public void itemAddOK(View view){
        int quantity = Integer.parseInt(txtItemAddQuantity.getText().toString());

        controller.addCart(new FoodDTO(
                foodName,
                foodPrice,
                foodImgId,
                quantity));
        Toast.makeText(this, quantity
                + "개 추가 완료", Toast.LENGTH_SHORT).show();
        finish();
    }
    // 취소 버튼 클릭
    public void itemAddCancel(View view){
        finish();
    }
}