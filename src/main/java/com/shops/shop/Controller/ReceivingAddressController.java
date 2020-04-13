package com.shops.shop.Controller;

import com.shops.shop.Bean.ReceivingAddress;
import com.shops.shop.Bean.Result;
import com.shops.shop.Interface.AddReceivingAddressInterface;
import com.shops.shop.Interface.GetReceivingAddressInterface;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class ReceivingAddressController {
    @Autowired
    AddReceivingAddressInterface addReceivingAddressInterface;
    @Autowired
    GetReceivingAddressInterface getReceivingAddressInterface;
    @RequestMapping(value = "/getReceivingAddress", method = RequestMethod.POST)
    @CrossOrigin(origins = "*")
    public Result getReceivingAddress(
            @Param("user_id")int user_id,
            @Param("page")int page,
            @Param("pageSize")int pageSize
    ){
        Result result = new Result();
        int start_subscript = (page - 1) * pageSize;
        try {
            List<ReceivingAddress> receivingAddresses = new ArrayList<>(getReceivingAddressInterface.getReceivingAddress(user_id,start_subscript,pageSize));
            if(receivingAddresses.size()>0){
                result.setStatus(100);
                result.setMsg("获取成功.");
                result.setValue(receivingAddresses);
                log.info("获取成功.");
            }else{
                result.setStatus(200);
                result.setMsg("获取失败.");
                log.info("获取失败.");
            }
        }catch (Exception e){
            e.printStackTrace();
            result.setStatus(601);
            result.setMsg("Error!");
            log.error("操作出现异常.");
        }
        return result;
    }
    @RequestMapping(value = "/getReceivingAddressById", method = RequestMethod.POST)
    @CrossOrigin(origins = "*")
    public Result getReceivingAddressById(
            @Param("id")int id
    ){
        Result result = new Result();
        try {
            List<ReceivingAddress> receivingAddresses = new ArrayList<>(getReceivingAddressInterface.getReceivingAddressById(id));
            if(receivingAddresses.size()==1){
                result.setStatus(100);
                result.setMsg("获取成功.");
                result.setValue(receivingAddresses.get(0));
                log.info("获取成功.");
            }else{
                result.setStatus(200);
                result.setMsg("获取失败.");
                log.info("获取失败.");
            }
        }catch (Exception e){
            e.printStackTrace();
            result.setStatus(601);
            result.setMsg("Error!");
            log.error("操作出现异常.");
        }
        return result;
    }
    @RequestMapping(value = "/setDefault", method = RequestMethod.POST)
    @CrossOrigin(origins = "*")
    public Result setDefault(
            @Param("user_id")int user_id,
            @Param("receiving_address_id")int receiving_address_id
    ){
        Result result = new Result();
        try {
                addReceivingAddressInterface.setDefault(user_id, receiving_address_id);
                result.setStatus(100);
                result.setMsg("设置成功.");
                log.info("设置成功.");

        }catch (Exception e){
            e.printStackTrace();
            result.setStatus(601);
            result.setMsg("Error!");
            log.error("操作出现异常.");
        }
        return result;
    }
    @RequestMapping(value = "/addReceivingAddress", method = RequestMethod.POST)
    @CrossOrigin(origins = "*")
    public Result addReceivingAddress(
            @Param("user_id")int user_id,
            @Param("name")String name,
            @Param("phone")int phone,
            @Param("address")String address,
            @Param("_default")int _default
    ){
        Result result = new Result();
        try {
                addReceivingAddressInterface.addReceivingAddress(user_id, name, phone, address, _default);
                result.setStatus(100);
                result.setMsg("添加成功.");
                log.info("添加成功.");

        }catch (Exception e){
            e.printStackTrace();
            result.setStatus(601);
            result.setMsg("Error!");
            log.error("操作出现异常.");
        }
        return result;
    }
    @RequestMapping(value = "/deleteReceivingAddress", method = RequestMethod.POST)
    @CrossOrigin(origins = "*")
    public Result deleteReceivingAddress(
            @Param("id")int id
    ){
        Result result = new Result();
        try {
                addReceivingAddressInterface.deleteReceivingAddress(id);
                result.setStatus(100);
                result.setMsg("获取成功.");
                log.info("获取成功.");
        }catch (Exception e){
            e.printStackTrace();
            result.setStatus(601);
            result.setMsg("Error!");
            log.error("操作出现异常.");
        }
        return result;
    }
}
