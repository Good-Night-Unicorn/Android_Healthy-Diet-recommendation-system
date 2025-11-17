package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import com.utils.ValidatorUtils;
import com.utils.DeSensUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.ShiyirenqunEntity;
import com.entity.view.ShiyirenqunView;

import com.service.ShiyirenqunService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 适宜人群
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-11 15:10:46
 */
@RestController
@RequestMapping("/shiyirenqun")
public class ShiyirenqunController {
    @Autowired
    private ShiyirenqunService shiyirenqunService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShiyirenqunEntity shiyirenqun,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<ShiyirenqunEntity> ew = new EntityWrapper<ShiyirenqunEntity>();


        //查询结果
		PageUtils page = shiyirenqunService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shiyirenqun), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShiyirenqunEntity shiyirenqun, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<ShiyirenqunEntity> ew = new EntityWrapper<ShiyirenqunEntity>();

        //查询结果
		PageUtils page = shiyirenqunService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shiyirenqun), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShiyirenqunEntity shiyirenqun){
       	EntityWrapper<ShiyirenqunEntity> ew = new EntityWrapper<ShiyirenqunEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shiyirenqun, "shiyirenqun")); 
        return R.ok().put("data", shiyirenqunService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShiyirenqunEntity shiyirenqun){
        EntityWrapper< ShiyirenqunEntity> ew = new EntityWrapper< ShiyirenqunEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shiyirenqun, "shiyirenqun")); 
		ShiyirenqunView shiyirenqunView =  shiyirenqunService.selectView(ew);
		return R.ok("查询适宜人群成功").put("data", shiyirenqunView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShiyirenqunEntity shiyirenqun = shiyirenqunService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(shiyirenqun,deSens);
        return R.ok().put("data", shiyirenqun);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShiyirenqunEntity shiyirenqun = shiyirenqunService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(shiyirenqun,deSens);
        return R.ok().put("data", shiyirenqun);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShiyirenqunEntity shiyirenqun, HttpServletRequest request){
        //验证字段唯一性，否则返回错误信息
        if(shiyirenqunService.selectCount(new EntityWrapper<ShiyirenqunEntity>().eq("shiyirenqun", shiyirenqun.getShiyirenqun()))>0) {
            return R.error("适宜人群已存在");
        }
        //ValidatorUtils.validateEntity(shiyirenqun);
        shiyirenqunService.insert(shiyirenqun);
        return R.ok().put("data",shiyirenqun.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShiyirenqunEntity shiyirenqun, HttpServletRequest request){
        //验证字段唯一性，否则返回错误信息
        if(shiyirenqunService.selectCount(new EntityWrapper<ShiyirenqunEntity>().eq("shiyirenqun", shiyirenqun.getShiyirenqun()))>0) {
            return R.error("适宜人群已存在");
        }
        //ValidatorUtils.validateEntity(shiyirenqun);
        shiyirenqunService.insert(shiyirenqun);
        return R.ok().put("data",shiyirenqun.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ShiyirenqunEntity shiyirenqun, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shiyirenqun);
        //验证字段唯一性，否则返回错误信息
        if(shiyirenqunService.selectCount(new EntityWrapper<ShiyirenqunEntity>().ne("id", shiyirenqun.getId()).eq("shiyirenqun", shiyirenqun.getShiyirenqun()))>0) {
            return R.error("适宜人群已存在");
        }
        //全部更新
        shiyirenqunService.updateById(shiyirenqun);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shiyirenqunService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
