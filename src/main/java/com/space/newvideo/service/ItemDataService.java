package com.space.newvideo.service;

import com.space.newvideo.bean.ItemBean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemDataService {
    public List<ItemBean> getMoreItem(int length) {
        List<ItemBean> list=new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            ItemBean itemBean = new ItemBean();
            itemBean.setId(i);
            itemBean.setTitle("item "+i);
            list.add(itemBean);
        }
        return list;
    }
}
