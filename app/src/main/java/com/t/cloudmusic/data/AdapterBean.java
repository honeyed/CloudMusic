package com.t.cloudmusic.data;

import com.t.cloudmusic.adapter.ItemType;

import java.util.ArrayList;
import java.util.List;

public class AdapterBean {

    //总的数据集合
    private List<ItemType> objectList = new ArrayList<>();

    public List<ItemType> getObjectList() {
        return objectList;
    }

    public void setObjectList(List<ItemType> objectList) {
        this.objectList = objectList;
    }

    public void addItemTypeBean(ItemType itemType) {
        objectList.add(itemType);
    }
}
