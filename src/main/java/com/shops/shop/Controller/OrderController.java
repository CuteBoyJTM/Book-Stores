package com.shops.shop.Controller;

import com.shops.shop.Bean.*;
import com.shops.shop.Interface.*;
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
public class OrderController {
    @Autowired
    GetBookInterface getBookInterface;
    @Autowired
    PayForOrderInterface payForOrderInterface;
    @Autowired
    GetReceivingAddressInterface getReceivingAddressInterface;
    @Autowired
    GetOrderInterface getOrderInterface;
    @Autowired
    AddOrderInterface addOrderInterface;
    @RequestMapping(value = "/addOrderContent", method = RequestMethod.POST)
    @CrossOrigin(origins = "*")
    public Result addOrderContent(
            @Param("user_id")int user_id,
            @Param("receiving_address_id")int receiving_address_id,
            @Param("book_id")int book_id,
            @Param("store_id")int store_id,
            @Param("book_number")int book_number
    ){
        Result result = new Result();
        System.out.println(user_id);
        try{
            Long startTs = System.currentTimeMillis();
            String str = startTs.toString()+user_id;
            int rs = Integer.parseInt(str.substring(str.length()-9));
            addOrderInterface.addOrder(1,rs,user_id,receiving_address_id);
            addOrderInterface.addOrderContent(rs,book_id,store_id,book_number);
            result.setStatus(100);
            result.setMsg("添加成功.");
            result.setValue(rs);
            log.info("添加成功.");
        }catch (Exception e){
            e.printStackTrace();
            result.setStatus(601);
            result.setMsg("Error!");
            log.error("操作出现异常.");
        }
        return result;
    };
    @RequestMapping(value = "/addOrderContentFromCart", method = RequestMethod.POST)
    @CrossOrigin(origins = "*")
    public Result addOrderContentFromCart(
            @Param("user_id")int user_id,
            @Param("receiving_address_id")int receiving_address_id
    ){
        Result result = new Result();
        System.out.println(user_id);
        try{
            Long startTs = System.currentTimeMillis();
            String str = startTs.toString()+user_id;
            int rs = Integer.parseInt(str.substring(str.length()-9));
            addOrderInterface.addOrder(2,rs,user_id,receiving_address_id);
            result.setStatus(100);
            result.setMsg("添加成功.");
            result.setValue(rs);
            log.info("添加成功.");
        }catch (Exception e){
            e.printStackTrace();
            result.setStatus(601);
            result.setMsg("Error!");
            log.error("操作出现异常.");
        }
        return result;
    };
    @RequestMapping(value = "/getOrder", method = RequestMethod.POST)
    @CrossOrigin(origins = "*")
    public Result getOrder(
            @Param("order_id")int order_id
    ){
        Result result = new Result();
        try{
            List<Orders> orders = new ArrayList<>(getOrderInterface.getOrder(order_id));
            if(orders.size()==1) {
                if(orders.get(0).getReceiving_address_id() != 0){
                    List<ReceivingAddress> receivingAddresses=new ArrayList<>(getReceivingAddressInterface.getReceivingAddressById(orders.get(0).getReceiving_address_id()));
                    orders.get(0).setReceiving_address(receivingAddresses.get(0).getName()+"-"+
                            receivingAddresses.get(0).getPhone()+"-"+
                            receivingAddresses.get(0).getAddress());
                }
                ReturnOrder returnOrder = new ReturnOrder();
                returnOrder.setOrders(orders.get(0));
                List<Stores> stores = new ArrayList<>(getOrderInterface.getOrderStores(order_id));
                List<ReturnOrderList> returnOrderLists = new ArrayList<>();
                for (int i = 0; i < stores.size(); i++) {
                    ReturnOrderList returnOrderList = new ReturnOrderList();
                    List<Books> books = new ArrayList<>(getOrderInterface.getOrderBooks(order_id, stores.get(i).getStore_id()));
                    returnOrderList.setBooks(books);
                    returnOrderList.setStores(stores.get(i));
                    returnOrderLists.add(returnOrderList);
                }
                returnOrder.setReturnOrderLists(returnOrderLists);
                result.setStatus(100);
                result.setMsg("获取成功.");
                result.setValue(returnOrder);
                log.info("获取成功.");
            }else{
                result.setStatus(200);
                result.setMsg("获取失败,订单不存在或已删除.");
                log.info("获取失败,订单不存在或已删除.");
            }
        }catch (Exception e){
            e.printStackTrace();
            result.setStatus(601);
            result.setMsg("Error!");
            log.error("操作出现异常.");
        }
        return result;
    };
    @RequestMapping(value = "/payForOrder", method = RequestMethod.POST)
    @CrossOrigin(origins = "*")
    public Result payForOrder(
            @Param("order_id")int order_id
    ){
        Result result = new Result();
        try {
            payForOrderInterface.payForOrder(order_id);
            result.setStatus(100);
            result.setMsg("付款成功.");
            log.info("付款成功.");
        }catch (Exception e){
            e.printStackTrace();
            result.setStatus(601);
            result.setMsg("Error!");
            log.error("操作出现异常.");
        }
        return result;
    }
    @RequestMapping(value = "/cancelOrder", method = RequestMethod.POST)
    @CrossOrigin(origins = "*")
    public Result cancelOrder(
            @Param("order_id")int order_id
    ){
        Result result = new Result();
        try {
            addOrderInterface.cancelOrder(order_id);
            result.setStatus(100);
            result.setMsg("取消成功.");
            log.info("取消成功.");
        }catch (Exception e){
            e.printStackTrace();
            result.setStatus(601);
            result.setMsg("Error!");
            log.error("操作出现异常.");
        }
        return result;
    }
    private class OrderFirst{
        private OrderList orderList;
        private Books books;

        public OrderList getOrderList() {
            return orderList;
        }

        public void setOrderList(OrderList orderList) {
            this.orderList = orderList;
        }

        public Books getBooks() {
            return books;
        }

        public void setBooks(Books books) {
            this.books = books;
        }
    }
    @RequestMapping(value = "/getOrderToBePaid", method = RequestMethod.POST)
    @CrossOrigin(origins = "*")
    public Result getOrderToBePaid(
            @Param("user_id")int user_id,
            @Param("page")int page,
            @Param("pageSize")int pageSize
    ){
        Result result = new Result();
        int start_subscript = (page - 1) * pageSize;
        try {
            List<OrderFirst> orderFirsts = new ArrayList<>();
            List<OrderList> orderLists = new ArrayList<>(getOrderInterface.getOrderToBePaid(user_id,start_subscript,pageSize));
            if(orderLists.size()>0){
                System.out.println(orderLists.size());
                for(int i = 0;i<orderLists.size();i++){
                    OrderFirst orderFirst = new OrderFirst();
                    orderFirst.setOrderList(orderLists.get(i));
                    System.out.println(orderLists.get(i).getId()+" dd " + i);
                    orderFirst.setBooks(getOrderInterface.getOrderFirstBook(orderLists.get(i).getId()).get(0));
                    orderFirsts.add(orderFirst);
                }
                result.setStatus(100);
                result.setMsg("获取成功.");
                result.setValue(orderFirsts);
                log.info("获取成功.");
            }else{
                result.setStatus(100);
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
    @RequestMapping(value = "/getOrderPaid", method = RequestMethod.POST)
    @CrossOrigin(origins = "*")
    public Result getOrderPaid(
            @Param("user_id")int user_id,
            @Param("page")int page,
            @Param("pageSize")int pageSize
    ){
        Result result = new Result();
        int start_subscript = (page - 1) * pageSize;
        try {
            List<OrderFirst> orderFirsts = new ArrayList<>();
            List<OrderList> orderLists = new ArrayList<>(getOrderInterface.getOrderPaid(user_id,start_subscript,pageSize));
            if(orderLists.size()>0){
                for(int i = 0;i<orderLists.size();i++){
                    OrderFirst orderFirst = new OrderFirst();
                    orderFirst.setOrderList(orderLists.get(i));
                    System.out.println(orderLists.get(i).getId());
                    orderFirst.setBooks(getOrderInterface.getOrderFirstBook(orderLists.get(i).getId()).get(0));
                    orderFirsts.add(orderFirst);
                }
                result.setStatus(100);
                result.setMsg("获取成功.");
                result.setValue(orderFirsts);
                log.info("获取成功.");
            }else{
                result.setStatus(100);
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
    private class ReturnOrderList{
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
    private class ReturnOrder{
        private Orders orders;
        private List<ReturnOrderList> returnOrderLists;

        public Orders getOrders() {
            return orders;
        }

        public void setOrders(Orders orders) {
            this.orders = orders;
        }

        public List<ReturnOrderList> getReturnOrderLists() {
            return returnOrderLists;
        }

        public void setReturnOrderLists(List<ReturnOrderList> returnOrderLists) {
            this.returnOrderLists = returnOrderLists;
        }
    }

}
