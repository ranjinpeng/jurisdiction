package com.fine.distribution.control;


import com.fine.distribution.common.BackJson;
import com.fine.distribution.common.JsonBackEntityT;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/finance")
@Api(value="财务")
public class FinanceContor {

    @ApiOperation("测试代理商权限")
    @PostMapping("/testfinance")
    public JsonBackEntityT<String > testfinance(){
        return BackJson.successObj("财务");
    }
}
