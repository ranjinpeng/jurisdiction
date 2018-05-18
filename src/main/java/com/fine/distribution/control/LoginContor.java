package com.fine.distribution.control;

import com.fine.distribution.common.BackJson;
import com.fine.distribution.common.JsonBackEntityT;
import com.fine.distribution.common.LoginVo;
import com.fine.distribution.securityvo.UsernameAndPwdVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@Api(value="登陆")
public class LoginContor {

    @ApiOperation(value = "登陆",consumes = "application/x-www-form-urlencoded")
    @PostMapping("/login")
    public JsonBackEntityT<String > Login(@ModelAttribute UsernameAndPwdVo loginVo){

        return BackJson.successObj("ok");
    }

    @ApiOperation(value = "登出")
    @GetMapping("/logout")
    public JsonBackEntityT<String > Logout(){
        return BackJson.successObj("ok");
    }
}
