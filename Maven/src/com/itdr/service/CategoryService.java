package com.itdr.service;

import com.itdr.common.ResponseCode;
import com.itdr.dao.CategoryDao;
import com.itdr.pojo.Categorys;
import com.itdr.utils.PropertiesGetUTil;

import java.util.List;

/**
 * @author Excellent吴
 * @date 2019-08-09 10:31
 */
public class CategoryService {
    CategoryDao cd = new CategoryDao();
    //根据category查找
    public ResponseCode seleCategory(String category) {
        Integer c_category = Integer.parseInt(category);
        ResponseCode rs = new ResponseCode();
        List<Categorys> li = cd.selectCategory(c_category);
        if(li != null){
            rs = rs.successRs(li);
            return rs;
        }
        rs.successRs(Integer.parseInt(PropertiesGetUTil.getValue("CATEGORY_SELECT_FAIL")),
                PropertiesGetUTil.getValue("CATEGORY_SELECT_FAIL_MSG"));
        return rs;
    }

    //增加节点
    public ResponseCode addCategory( String parentId, String categoryName) {
        ResponseCode rs = new ResponseCode();
        Integer id = Integer.parseInt(parentId);
        int i = 0;
        if (parentId == null || parentId.equals("")){
            id = 0;
        }
        i = cd.addCategory(id,categoryName);
        if(i != 0){
            rs = ResponseCode.successRs(Integer.parseInt(PropertiesGetUTil.getValue("CATEGORY_SELECT_SUCCESS"))
                    ,PropertiesGetUTil.getValue("CATEGORY_SELECT_SUCCESS_MSG"));
            return rs;
        }
        rs = ResponseCode.successRs(Integer.parseInt(PropertiesGetUTil.getValue("CATEGORY_ADD_FAIL"))
                , PropertiesGetUTil.getValue("CATEGORY_ADD_FAIL_MSG"));
        return rs;
    }

    public ResponseCode setcategoryName(String categoryId, String categoryName) {
        ResponseCode rs = new ResponseCode();
        Integer id = Integer.parseInt(categoryId);
        int i = 0;
        i = cd.setCategoryName(id,categoryName);
        if(i != 0){
            rs = ResponseCode.successRs(Integer.parseInt(PropertiesGetUTil.getValue("CATEGORY_MODIFY_SUCCESS"))
                    ,PropertiesGetUTil.getValue("CATEGORY_MODIFY_SUCCESS_MSG"));
            return rs;
        }
        rs = ResponseCode.successRs(Integer.parseInt(PropertiesGetUTil.getValue("CATEGORY_MODIFY_FAIL"))
                ,PropertiesGetUTil.getValue("CATEGORY_MODIFY_FAIL_MSG"));
        return rs;
    }

}
