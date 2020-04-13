package com.shops.shop.Controller;

import com.shops.shop.Bean.Press;
import com.shops.shop.Bean.Result;
import com.shops.shop.Bean.Store;
import com.shops.shop.Bean.Users;
import com.shops.shop.Interface.GetUserInterface;
import com.shops.shop.Interface.LoginInterface;
import com.shops.shop.Interface.RegisterInterface;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.apache.tomcat.util.codec.binary.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    RegisterInterface registerInterface;
    @Autowired
    LoginInterface loginInterface;
    @Autowired
    GetUserInterface getUserInterface;
    @RequestMapping(value = "/getUser", method = RequestMethod.POST)
    @CrossOrigin(origins = "*")
    public Result getUser(
            @Param("id") int id
    ) {
        Result result = new Result();
        try {
            List<Press> presses = new ArrayList<>(getUserInterface.getUser(id));
            if (presses.size() == 1) {
                if (presses.get(0).getType() == 1) {
                    Users users = new Users();
                    users.setName(presses.get(0).getName());
                    users.setId(presses.get(0).getId());
                    users.setAccount(presses.get(0).getAccount());
                    users.setType(presses.get(0).getType());
                    result.setStatus(100);
                    result.setMsg("获取成功.");
                    result.setValue(users);
                    log.info("获取成功.");
                } else if (presses.get(0).getType() == 3) {
                    result.setStatus(100);
                    result.setMsg("获取成功");
                    result.setValue(presses);
                    log.info("获取成功.");
                } else if (presses.get(0).getType() == 2) {
                    Store stores = new Store();
                    stores.setId(presses.get(0).getId());
                    stores.setName(presses.get(0).getName());
                    stores.setAccount(presses.get(0).getAccount());
                    stores.setAddress(presses.get(0).getAddress());
                    stores.setPhone(presses.get(0).getPhone());
                    stores.setType(presses.get(0).getType());
                    result.setStatus(100);
                    result.setMsg("获取成功");
                    result.setValue(stores);
                    log.info("获取成功.");
                }else {
                    result.setStatus(200);
                    result.setMsg("获取失败.");
                    log.info("获取失败.");
                }
            }else {
                result.setStatus(200);
                result.setMsg("获取失败.");
                log.info("获取失败.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setStatus(601);
            result.setMsg("Error!");
            log.error("操作出现异常.");
        }
        return result;
    }
    @RequestMapping(value = "/getUserList", method = RequestMethod.POST)
    @CrossOrigin(origins = "*")
    public Result getUserList(
            @Param("type") int type,
            @Param("page")int page,
            @Param("pageSize")int pageSize
    ) {
        Result result = new Result();
        int start_subscript = (page - 1) * pageSize;
        try {
            List<Press> presses = new ArrayList<>(getUserInterface.getUserList(type,start_subscript,pageSize));
            if (presses.size() > 0) {
                if (type == 1) {
                    List<Users> users = new ArrayList<>();
                    for(int i = 0; i<presses.size();i++){
                        Users user = new Users();
                        user.setName(presses.get(i).getName());
                        user.setId(presses.get(i).getId());
                        user.setAccount(presses.get(i).getAccount());
                        user.setType(presses.get(i).getType());
                        users.add(user);
                    }
                    result.setStatus(100);
                    result.setMsg("获取成功.");
                    result.setValue(users);
                    log.info("获取成功.");
                } else if (type == 3) {
                    result.setStatus(100);
                    result.setMsg("获取成功");
                    result.setValue(presses);
                    log.info("获取成功.");
                } else if (type == 2) {
                    List<Store> stores = new ArrayList<>();
                    for(int i = 0;i<presses.size();i++) {
                        Store store = new Store();
                        store.setId(presses.get(i).getId());
                        store.setName(presses.get(i).getName());
                        store.setAccount(presses.get(i).getAccount());
                        store.setAddress(presses.get(i).getAddress());
                        store.setPhone(presses.get(i).getPhone());
                        store.setType(presses.get(i).getType());
                        stores.add(store);
                    }
                    result.setStatus(100);
                    result.setMsg("获取成功");
                    result.setValue(stores);
                    log.info("获取成功.");
                }else {
                    result.setStatus(200);
                    result.setMsg("获取失败.");
                    log.info("获取失败.");
                }
            }else {
                result.setStatus(200);
                result.setMsg("获取失败.");
                log.info("获取失败.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setStatus(601);
            result.setMsg("Error!");
            log.error("操作出现异常.");
        }
        return result;
    }
    @RequestMapping(value = "/Login", method = RequestMethod.POST)
    @CrossOrigin(origins = "*")
    public Result Login(
            @Param("account") String account,
            @Param("password") String password
    ) {
        Result result = new Result();
        try {
            List<Users> user = new ArrayList<>(loginInterface.Login( account, password));
            if (user.size() == 1) {
                result.setStatus(100);
                result.setMsg("登录成功.");
                result.setValue(user);
                log.info("登录成功.");
            }else {
                result.setStatus(200);
                result.setMsg("用户名或密码错误.");
                log.info("用户名或密码错误.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setStatus(601);
            result.setMsg("Error!");
            log.error("操作出现异常.");
        }
        return result;
    }
    @RequestMapping(value = "/Register", method = RequestMethod.POST)
    @CrossOrigin(origins = "*")
    public Result Register(
            @RequestParam(value = "type")int type,
            @RequestParam(value = "account")String account,
            @RequestParam(value = "password")String password,
            @RequestParam(value = "name")String name,
            @RequestParam(value = "phone",defaultValue = "0")int phone,
            @RequestParam(value = "address",required = false)String address,
            @RequestParam(value = "bank_account",defaultValue = "0")int bank_account,
            @RequestParam(value = "email",required = false)String email
    ) {
        Result result = new Result();
        try {
            int statusNum = registerInterface.Register(type, account, password, name, phone, address, bank_account, email);
            if (statusNum > 0) {
                result.setStatus(100);
                result.setMsg("注册成功.");
                result.setValue(100);
                log.info("注册成功.");
            }else {
                result.setStatus(200);
                result.setMsg("注册失败，账号重复.");
                log.info("注册失败，账号重复.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setStatus(601);
            result.setMsg("Error!");
            log.error("操作出现异常.");
        }
        return result;
    }
    @RequestMapping(value = "/checkAccount", method = RequestMethod.POST)
    public Result checkAccount(
            @RequestParam(value = "account")String account
    ) {
        Result result = new Result();
        try {
            int statusNum = registerInterface.checkAccount(account);
            if (statusNum > 0) {
                result.setStatus(100);
                result.setMsg("验证成功.");
                result.setValue(100);
                log.info("验证成功.");
            }else {
                result.setStatus(200);
                result.setMsg("验证失败，账号重复.");
                log.info("验证失败，账号重复.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setStatus(601);
            result.setMsg("Error!");
            log.error("操作出现异常.");
        }
        return result;
    }
    @RequestMapping(value = "/ChangePassword", method = RequestMethod.POST)
    public Result ChangePassword(
            @Param("id")int id,
            @Param("oldPwd")String oldPwd,
            @Param("newPwd")String newPwd
    ) {
        Result result = new Result();
        try {
            int statusNum = loginInterface.ChangePassword(id, oldPwd, newPwd);
            if (statusNum > 0) {
                result.setStatus(100);
                result.setMsg("修改成功.");
                result.setValue(100);
                log.info("修改成功.");
            }else {
                result.setStatus(200);
                result.setMsg("修改失败，旧密码错误.");
                log.info("修改失败，旧密码错误.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setStatus(601);
            result.setMsg("Error!");
            log.error("操作出现异常.");
        }
        return result;
    }
};

