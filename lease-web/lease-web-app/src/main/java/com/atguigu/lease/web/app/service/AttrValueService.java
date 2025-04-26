package com.atguigu.lease.web.app.service;

import com.atguigu.lease.model.entity.AttrValue;
import com.atguigu.lease.web.app.vo.attr.AttrValueVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author liubo
* @description 针对表【attr_value(房间基本属性值表)】的数据库操作Service
* @createDate 2023-07-26 11:12:39
*/
public interface AttrValueService extends IService<AttrValue> {

    List<AttrValueVo> selectListByRoomId(Long id);
}
