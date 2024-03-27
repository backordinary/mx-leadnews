package com.mx.user.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mx.model.user.pojos.ApUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ApUserMapper extends BaseMapper<ApUser> {
}
