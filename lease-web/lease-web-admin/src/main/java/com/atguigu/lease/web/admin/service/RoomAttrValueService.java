package com.atguigu.lease.web.admin.service;

import com.atguigu.lease.model.entity.RoomAttrValue;
import com.atguigu.lease.web.admin.vo.attr.AttrValueVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author liubo
* @description 针对表【room_attr_value(房间&基本属性值关联表)】的数据库操作Service
* @createDate 2023-07-24 15:48:00
*/
public interface RoomAttrValueService extends IService<RoomAttrValue> {

    List<AttrValueVo> selectListByRoomId(Long id);
}
