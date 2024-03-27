package com.mx.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mx.model.common.dtos.ResponseResult;
import com.mx.model.user.dtos.LoginDto;
import com.mx.model.user.pojos.ApUser;

public interface ApUserService extends IService<ApUser> {
    /**
     * app端登录功能
     * @param dto
     * @return
     */
    public ResponseResult login(LoginDto dto);
}
