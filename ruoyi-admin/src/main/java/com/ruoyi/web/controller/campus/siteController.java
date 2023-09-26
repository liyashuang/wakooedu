package com.ruoyi.web.controller.campus;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.educationalAdministration.domain.District;
import com.ruoyi.educationalAdministration.service.DistrictService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author HASEE
 */
@RestController
@RequestMapping("/educationalAdministration/management")
public class siteController extends BaseController {

    @Resource
    private DistrictService districtService;


    @Operation(summary = "查询所有省份")
    @GetMapping("/province")
    public Map<String,Object> province() {
        Map<String,Object> map=new HashMap<>();
        List<District> districts = districtService.queryProvince();
        map.put("districts",districts);
        return map;
    }
    @Operation(summary = "查询城市或地区")
    @GetMapping("/city")
    public Map<String,Object> city(@Parameter(description = "地区编码") @RequestParam("code") String code) {
        Map<String,Object> map=new HashMap<>();
        List<District> districts =districtService.queryCity(code);
        map.put("districts",districts);
        return map;
    }

    @Operation(summary = "查询城市或地区")
    @GetMapping("/queryCity")
    public Map<String, Object> queryCity(@Parameter(description = "地区编码") @RequestParam("code") String code) {
        List<District> districts = districtService.queryCity(code);
        Map<String,Object> map=new HashMap<>();
        map.put("districts",districts);
        return map;
    }
}
