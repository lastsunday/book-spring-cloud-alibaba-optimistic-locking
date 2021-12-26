package com.github.lastsunday.cloud.optimisticlocking.manager;

import com.github.lastsunday.cloud.optimisticlocking.entity.ProductEntity;
import com.github.lastsunday.cloud.optimisticlocking.mapper.ProductMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserManager {

    @Resource
    private ProductMapper productMapper;

    public void updateByEntity(){
        ProductEntity entity = new ProductEntity();
        entity.setNum(100L);
        productMapper.insert(entity);
        Long saveId = entity.getId();
        ProductEntity goodA = productMapper.selectById(saveId);
        ProductEntity goodB = productMapper.selectById(saveId);
        goodA.setNum(goodA.getNum() + 50);
        productMapper.updateById(goodA);
        goodB.setNum(goodB.getNum()-30);
        int result = productMapper.updateById(goodB);
        if(result == 0){
            ProductEntity goodC = productMapper.selectById(saveId);
            goodC.setNum(goodC.getNum() - 30);
            productMapper.updateById(goodC);
        }
        ProductEntity newEntity = productMapper.selectById(saveId);
        System.out.println("current stock is "+newEntity.getNum());
    }
}
