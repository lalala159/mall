package com.mall.info.service.sp;

import com.mall.common.domain.TreeList;
import com.mall.common.domain.sp.MallSplxInfo;
import com.mall.info.dao.sp.MallSplxInfoDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author HC
 * @Date 2020/7/7 17:25
 * @Version 1.0
 */
@Service
@Slf4j
public class MallSplxInfoService {

    @Autowired
    private MallSplxInfoDao mallSplxInfoDao;

    public int deleteByPrimaryKey(Integer id){
        try {
            return mallSplxInfoDao.deleteByPrimaryKey(id);
        }catch (Exception e){
            log.error(e.getMessage(),e.getCause());
            return 0;
        }

    }

    public int insert(MallSplxInfo record){
        try {
            return mallSplxInfoDao.insert(record);
        }catch (Exception e){
            log.error(e.getMessage(),e.getCause());
            return 0;
        }
    }

    public int insertSelective(MallSplxInfo record){
        try {
            return mallSplxInfoDao.insertSelective(record);
        }catch (Exception e){
            log.error(e.getMessage(),e.getCause());
            return 0;
        }
    }

    public MallSplxInfo selectByPrimaryKey(Integer id){
        try {
            return mallSplxInfoDao.selectByPrimaryKey(id);
        }catch (Exception e){
            log.error(e.getMessage(),e.getCause());
            return null;
        }
    }

    public int updateByPrimaryKeySelective(MallSplxInfo record){
        try {
            return mallSplxInfoDao.updateByPrimaryKeySelective(record);
        }catch (Exception e){
            log.error(e.getMessage(),e.getCause());
            return 0;
        }
    }

    public int updateByPrimaryKey(MallSplxInfo record){
        try {
            return mallSplxInfoDao.updateByPrimaryKey(record);
        }catch (Exception e){
            log.error(e.getMessage(),e.getCause());
            return 0;
        }
    }

    public List<TreeList> queryLxList(){
        List<MallSplxInfo> list = mallSplxInfoDao.queryLxList();
        List<TreeList> treeList = new ArrayList<>();
        for (MallSplxInfo mallSplxInfo : list) {
            if(mallSplxInfo.getParentId()==0){
                TreeList tree = new TreeList();
                tree.setId(String.valueOf(mallSplxInfo.getId()));
                tree.setLabel(mallSplxInfo.getLxMc());
                tree.setChildren(getChild(list, mallSplxInfo.getId()));
                treeList.add(tree);
            }
        }
        return treeList;
    }

    public List<TreeList> getChild(List<MallSplxInfo> list, int parentId){
        List<TreeList> treeLists = new ArrayList<>();
        for (MallSplxInfo mallSplxInfo : list) {
            if(mallSplxInfo.getParentId()==parentId){
                TreeList tree = new TreeList();
                tree.setId(String.valueOf(mallSplxInfo.getId()));
                tree.setLabel(mallSplxInfo.getLxMc());
                tree.setChildren(getChild(list, mallSplxInfo.getId()));
                treeLists.add(tree);
            }
        }
        return treeLists;
    }
}
