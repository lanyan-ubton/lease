package com.atguigu.lease.web.admin.service;

import com.atguigu.lease.model.entity.ApartmentFacility;
import com.atguigu.lease.model.entity.FacilityInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author liubo
* @description 针对表【apartment_facility(公寓&配套关联表)】的数据库操作Service
* @createDate 2023-07-24 15:48:00
*/
public interface ApartmentFacilityService extends IService<ApartmentFacility> {

    List<FacilityInfo> queryFacilityInfoList(Long id);
}
