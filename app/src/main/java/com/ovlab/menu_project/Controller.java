package com.ovlab.menu_project;

import java.util.Vector;

/**
 * Created by 김준영 on 2018-08-31.
 */

public class Controller {
    private static Controller instance = new Controller();
    private Vector<FoodDTO> v = new Vector<>();

    private Controller(){}

    public static Controller getInstance(){
        return instance;
    }

    public void addCart(FoodDTO dto){
        int checkIndex = checkOverlap(dto.getFood_name());
        if(checkIndex != -1){
            v.get(checkIndex).setQuantity(v.get(checkIndex).getQuantity() + dto.getQuantity());
        }else {
            v.add(dto);
        }
    }

    public void delete(int index){
        v.remove(index);
    }

    public void addQuantity(int index){
        v.get(index).setQuantity(v.get(index).getQuantity()+1);
    }
    public void minusQuantity(int index){
        if (! (v.get(index).getQuantity() <= 0 )){
            v.get(index).setQuantity(v.get(index).getQuantity()-1);
        }
    }
    public Vector<FoodDTO> getAllItem(){
        return v;
    }
    /*
        이미 중복된 메뉴를 추가한다면
        그 메뉴에 수량만 더해서 수정
        중복 메뉴가 있으면 index 반환 없으면 -1 반환
     */
    public int checkOverlap(String foodName){
        for(int i=0; i<v.size(); i++){
            if(v.get(i).getFood_name().equals(foodName)){
                return i;
            }
        }
        return -1;
    }
}
