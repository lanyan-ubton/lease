package com.atguigu.lease.web.admin.mapper;

import com.atguigu.lease.model.entity.ApartmentInfo;
import com.atguigu.lease.model.enums.ItemType;
import com.atguigu.lease.web.admin.vo.apartment.ApartmentItemVo;
import com.atguigu.lease.web.admin.vo.apartment.ApartmentQueryVo;
import com.atguigu.lease.web.admin.vo.graph.GraphVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liubo
 * @description 针对表【apartment_info(公寓信息表)】的数据库操作Mapper
 * @createDate 2023-07-24 15:48:00
 * @Entity com.atguigu.lease.model.ApartmentInfo
 */
public interface ApartmentInfoMapper extends BaseMapper<ApartmentInfo> {

    IPage<ApartmentItemVo> queryApartmentPage(IPage<ApartmentItemVo> page, @Param("queryVo") ApartmentQueryVo queryVo);

    List<GraphVo> selectListByItemTypeAndId(ItemType apartment, Long itemId);
}




