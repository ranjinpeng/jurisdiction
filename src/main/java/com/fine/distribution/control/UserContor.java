package com.fine.distribution.control;

import com.fine.distribution.common.BackJson;
import com.fine.distribution.common.JsonBackEntityT;
import com.fine.distribution.common.LoginVo;
import com.fine.distribution.entity.User;
import com.fine.distribution.securityvo.UserUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Api(value="用户")
public class UserContor {

    @ApiOperation("测试代理商权限")
    @PostMapping("/testAgent")
    public JsonBackEntityT<String > testAgent(){
        return BackJson.successObj("代理");
    }
}
