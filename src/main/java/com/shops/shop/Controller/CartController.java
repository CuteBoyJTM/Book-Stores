package com.shops.shop.Controller;

import com.shops.shop.Bean.Books;
import com.shops.shop.Bean.Result;
import com.shops.shop.Bean.Stores;
import com.shops.shop.Bean.Total;
import com.shops.shop.Interface.AddToCartInterface;
import com.shops.shop.Interface.GetCartInterface;
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
public class CartController {
    @Autowired
    AddToCartInterface addToCartInterface;
    @Autowired
    GetCartInterface getCartInterface;
    @RequestMapping(value = "/addToCart", method = RequestMethod.POST)
    @CrossOrigin(origins = "*")
    public Result addToCart(
            @Param("user_id")int user_id,
            @Param("book_id")int book_id,
            @Param("store_id")int store_id,
            @Param("number")int number
    ){
        Result result = new Result();
        try{
            addToCartInterface.addToCart(user_id, book_id, store_id, number);
            result.setStatus(100);
            result.setMsg("添加成功.");
            log.info("添加成功.");
        }catch (Exception e){
            e.printStackTrace();
            result.setStatus(601);
            result.setMsg("Error!");
            log.error("操作出现异常.");
        }
        return  result;
    };
    @RequestMapping(value = "/updateChecked", method = RequestMethod.POST)
    @CrossOrigin(origins = "*")
    public Result updateChecked(
            @Param("user_id")int user_id,
            @Param("book_id")int book_id,
            @Param("store_id")int store_id,
            @Param("checked")int checked
    ){
        Result result = new Result();
        try{
            double total_price = addToCartInterface.updateChecked(user_id, book_id, store_id, checked);
            result.setStatus(100);
            result.setMsg("修改成功.");
            result.setValue(total_price);
            log.info("修改成功.");
        }catch (Exception e){
            e.printStackTrace();
            result.setStatus(601);
            result.setMsg("Error!");
            log.error("操作出现异常.");
        }
        return  result;
    };
    @RequestMapping(value = "/deleteFromCart", method = RequestMethod.POST)
    @CrossOrigin(origins = "*")
    public Result deleteFromCart(
            @Param("user_id")int user_id,
            @Param("book_id")int book_id,
            @Param("store_id")int store_id
    ){
        Result result = new Result();
        try{
            addToCartInterface.deleteFromCart(user_id, book_id, store_id);
            result.setStatus(100);
            result.setMsg("删除成功.");
            log.info("删除成功.");
        }catch (Exception e){
            e.printStackTrace();
            result.setStatus(601);
            result.setMsg("Error!");
            log.error("操作出现异常.");
        }
        return  result;
    };
    private class ReturnCartMap{
        private Total total;
        private List<ReturnCart> returnCarts;



        public Total getTotal() {
            return total;
        }

        public void setTotal(Total total) {
            this.total = total;
        }

        public List<ReturnCart> getReturnCarts() {
            return returnCarts;
        }

        public void setReturnCarts(List<ReturnCart> returnCarts) {
            this.returnCarts = returnCarts;
        }
    }
    private class ReturnCart{
        private Stores stores;
        private List<Books> books;


        public Stores getStores() {
            return stores;
        }

        public void setStores(Stores stores) {
            this.stores = stores;
        }

        public List<Books> getBooks() {
            return books;
        }

        public void setBooks(List<Books> books) {
            this.books = books;
        }
    }
    @RequestMapping(value = "/getCart", method = RequestMethod.POST)
    @CrossOrigin(origins = "*")
    public Result getCart(
            @Param("user_id")int user_id
    ){
        Result result = new Result();
        try{
            ReturnCartMap returnCartMap = new ReturnCartMap();

            Total total =  getCartInterface.getCartInfo(user_id);
            returnCartMap.setTotal(total);
            List<Stores> stores= getCartInterface.getCartStores(user_id);
            if(stores.size()>0){
            List<ReturnCart> returnCarts = new ArrayList<>();
            for (int i = 0; i < stores.size(); i++) {
                ReturnCart returnCart = new ReturnCart();
                returnCart.stores = stores.get(i);
                returnCart.books = getCartInterface.getCartBooks(user_id,stores.get(i).getStore_id());
                returnCarts.add(returnCart);
            }
                returnCartMap.setReturnCarts(returnCarts);
                result.setStatus(100);
                result.setMsg("获取成功.");
                result.setValue(returnCartMap);
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
        return  result;
    };


}
