package com.itdr.service;

import com.itdr.common.ResponseCode;
import com.itdr.dao.ProductDao;
import com.itdr.pojo.Products;

import java.util.List;

/**
 * @author Excellent吴
 * @date 2019-08-03 15:53
 */
public class ProductService {
    private ProductDao pd =new ProductDao();
    //查找全部的信息
    public ResponseCode selectAll(String pageSize, String pageNum){
        if (pageSize==null ||pageSize.equals("")){
            pageSize="10";

        }
        if (pageNum==null|| pageNum.equals("")){
            pageNum="1";

        }
        ResponseCode rs=null;
        //如果集合元素是空呢
        List<Products> li =pd.selectAll(pageSize,pageNum);
           rs=ResponseCode.successRs(li);
           return rs ;
    }
}
