package com.fine.distribution.control;

import com.fine.distribution.common.BackJson;
import com.fine.distribution.common.JsonBackEntityT;
import com.fine.distribution.common.LoginVo;
import com.fine.distribution.dao.MenuMapper;
import com.fine.distribution.entity.Menu;
import com.fine.distribution.securityvo.UserUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/common")
@Api(value="组件")
public class CommonContor {

    @Autowired
    MenuMapper menuMapper;

    @ApiOperation("获取登陆者信息")
    @PostMapping("/getloginvo")
    public JsonBackEntityT<LoginVo> insertmeeting(){
        return BackJson.successObj(UserUtils.getCurrent());
    }

    @ApiOperation("获取登陆者信息")
    @PostMapping("/getmenu")
    public JsonBackEntityT<List<Menu>> menus(){


        return  BackJson.successObj(menuMapper.selectallmenubyuserid(UserUtils.getCurrent().getUserrightsid()));
    }

}
