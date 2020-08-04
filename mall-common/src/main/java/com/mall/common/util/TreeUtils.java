package com.mall.common.util;

import com.mall.common.domain.TreeList;
import com.mall.common.domain.TreeVO;

import java.util.ArrayList;
import java.util.List;

/**获取树形结构
 * @Author HC
 * @Date 2020/8/4 17:06
 * @Version 1.0
 */
public class TreeUtils {
    public static List<TreeList> getTree(List<TreeVO> list){
        List<TreeList> treeList = new ArrayList<>();
        for (TreeVO treeVO : list) {
            if(treeVO.getParentId()==0){
                TreeList tree = new TreeList();
                tree.setId(String.valueOf(treeVO.getId()));
                tree.setLabel(treeVO.getLabel());
                tree.setChildren(getChild(list, treeVO.getId()));
                treeList.add(tree);
            }
        }
        return treeList;
    }
    public static List<TreeList> getChild(List<TreeVO> list, int parentId){
        List<TreeList> treeLists = new ArrayList<>();
        for (TreeVO treeVO : list) {
            if(treeVO.getParentId()==parentId){
                TreeList tree = new TreeList();
                tree.setId(String.valueOf(treeVO.getId()));
                tree.setLabel(treeVO.getLabel());
                tree.setChildren(getChild(list, treeVO.getId()));
                treeLists.add(tree);
            }
        }
        return treeLists;
    }
}
