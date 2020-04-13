package com.shops.shop.Controller;

import com.shops.shop.Bean.Book;
import com.shops.shop.Bean.Books;
import com.shops.shop.Bean.BooksAll;
import com.shops.shop.Bean.Result;
import com.shops.shop.Interface.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/api")
public class BookController {
    @Autowired
    GetBookInterface getBookInterface;
    @Autowired
    AddBookInterface addBookInterface;
    @Autowired
    DeleteBookInterface deleteBookInterface;
    @RequestMapping(value = "/addBook", method = RequestMethod.POST)
    @CrossOrigin(origins = "*")
    public Result addBook(
            @Param("name")String name,
            @Param("author")String author,
            @Param("theme")String theme,
            @Param("publisher_id")int publisher_id,
            @Param("pages")int pages,
            @Param("proportion")double proportion,
            @Param("price")double price,
            @Param("photos") MultipartFile photos
    ){
        Result result = new Result();
        try {
            if (photos.isEmpty()) {
                result.setStatus(300);
                result.setMsg("文件不能为空");
                log.warn("★上传的文件为空！★");
            } else {
                if (photos.getSize() > 5242880) {
                    result.setStatus(200);
                    result.setMsg("图片最大不超过5MB");
                    log.warn("★上传的文件超过5MB！★");
                } else {

                    String fileName = photos.getOriginalFilename();  // 获取到的文件名
                    String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
                    fileName = publisher_id +"-"+ new Date().getTime()  + suffixName; // 生成的新文件名加上后缀名
                    String c=System.getProperty("user.dir");
                    System.out.println(c);
                    String rootPath = c + "\\src\\main\\resources\\static\\Photo\\Press-" +publisher_id+"\\"+ fileName;
                    File dest = new File(rootPath);//dest是绝对路径
                    if (!dest.getParentFile().exists()) {//判断是否存在上级目录
                        dest.getParentFile().mkdirs();//否则创建目录
                    }
                    try {
                        photos.transferTo(dest);//将新的图片存入磁盘中
                    } catch (IOException e) {
                        e.printStackTrace();
                        result.setStatus(601);
                        result.setMsg("Error!");
                        log.error("存入目录失败.");
                    }
                    addBookInterface.addBook(name,author,theme, publisher_id,pages,proportion,price,rootPath);
                    result.setStatus(100);
                    result.setMsg("添加成功.");
                    result.setValue(rootPath);
                    log.info("添加成功.");
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
            result.setStatus(601);
            result.setMsg("Error!");
            log.error("操作出现异常.");
        }
        return result;
    };
    @RequestMapping(value = "/ReviseBook", method = RequestMethod.POST)
    @CrossOrigin(origins = "*")
    public Result ReviseBook(
            @Param("id")int id,
            @Param("name")String name,
            @Param("author")String author,
            @Param("theme")String theme,
            @Param("publisher_id")int publisher_id,
            @Param("pages")int pages,
            @Param("proportion")double proportion,
            @Param("photos") MultipartFile photos
    ){
        Result result = new Result();

        try {
            if(photos == null){
                addBookInterface.ReviseBook(id,name,author,theme, publisher_id,pages,proportion,getBookInterface.getBook(id).get(0).getPhoto());
                result.setStatus(100);
                result.setMsg("添加成功.");
                result.setValue(getBookInterface.getBook(id).get(0).getPhoto());
                log.info("添加成功.");
            }else{
            if (photos.isEmpty()) {
                result.setStatus(300);
                result.setMsg("文件不能为空");
                log.warn("★上传的文件为空！★");
            } else {
                if (photos.getSize() > 5242880) {
                    result.setStatus(200);
                    result.setMsg("图片最大不超过5MB");
                    log.warn("★上传的文件超过5MB！★");
                } else {

                    String fileName = photos.getOriginalFilename();  // 获取到的文件名
                    String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
                    fileName = publisher_id +"-"+ new Date().getTime()  + suffixName; // 生成的新文件名加上后缀名
                    String c=System.getProperty("user.dir");
                    System.out.println(c);
                    String rootPath = c + "\\src\\main\\resources\\static\\Photo\\Press-" +publisher_id+"\\"+ fileName;
                    File dest = new File(rootPath);//dest是绝对路径
                    if (!dest.getParentFile().exists()) {//判断是否存在上级目录
                        dest.getParentFile().mkdirs();//否则创建目录
                    }
                    try {
                        photos.transferTo(dest);//将新的图片存入磁盘中
                    } catch (IOException e) {
                        e.printStackTrace();
                        result.setStatus(601);
                        result.setMsg("Error!");
                        log.error("存入目录失败.");
                    }
                    addBookInterface.ReviseBook(id,name,author,theme, publisher_id,pages,proportion,rootPath);
                    result.setStatus(100);
                    result.setMsg("添加成功.");
                    result.setValue(rootPath);
                    log.info("添加成功.");
                }
            }}
        }catch (Exception e) {
            e.printStackTrace();
            result.setStatus(601);
            result.setMsg("Error!");
            log.error("操作出现异常.");
        }
        return result;
    };
    @RequestMapping(value = "/deleteBook", method = RequestMethod.POST)
    @CrossOrigin(origins = "*")
    public Result deleteBook(
            @Param("id")int id
    ){
        Result result = new Result();
        try {
            deleteBookInterface.deleteBook(id);
            result.setStatus(100);
            result.setMsg("删除成功.");
            result.setValue(100);
            log.info("删除成功.");
        }catch (Exception e){
            e.printStackTrace();
            result.setStatus(601);
            result.setMsg("Error!");
            log.error("操作出现异常.");
        }
        return result;
    }
    @RequestMapping(value = "/getBook", method = RequestMethod.POST)
    @CrossOrigin(origins = "*")
    public Result getBook(
            @Param("id")int id
    ){
        Result result = new Result();
        try {
            List<Books> books = new ArrayList<>(getBookInterface.getBook(id));
            if(books.size()==1){
                result.setStatus(100);
                result.setMsg("获取成功.");
                result.setValue(books.get(0));
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
    @RequestMapping(value = "/getBookList", method = RequestMethod.POST)
    @CrossOrigin(origins = "*")
    public Result getBookList(
            @Param("id")int id
    ){
        Result result = new Result();
        try {
            List<Book> books = new ArrayList<>(getBookInterface.getBookList(id));
            if(books.size()>0){
                result.setStatus(100);
                result.setMsg("获取成功.");
                result.setValue(books);
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
    @RequestMapping(value = "/getBooks", method = RequestMethod.POST)
    @CrossOrigin(origins = "*")
    public Result getBooks(
            @Param("store_id")int store_id,
            @Param("page")int page,
            @Param("pageSize")int pageSize
    ){
        Result result = new Result();
        int start_subscript = (page - 1) * pageSize;
        try {
            List<Books> books = new ArrayList<>(getBookInterface.getBooks(store_id,start_subscript,pageSize));
            if(books.size()>0){
                result.setStatus(100);
                result.setMsg("获取成功.");
                result.setValue(books);
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
    @RequestMapping(value = "/getBookListAll", method = RequestMethod.POST)
    @CrossOrigin(origins = "*")
    public Result getBookListAll(
    ){
        Result result = new Result();
        try {
            List<Books> books = new ArrayList<>(getBookInterface.getBookListAll());
            if(books.size()>0){
                result.setStatus(100);
                result.setMsg("获取成功.");
                result.setValue(books);
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
    @RequestMapping(value = "/getBooksAll", method = RequestMethod.POST)
    @CrossOrigin(origins = "*")
    public Result getBooksAll(
            @Param("page")int page,
            @Param("pageSize")int pageSize
    ){
        Result result = new Result();
        int start_subscript = (page - 1) * pageSize;
        try {
            List<BooksAll> books = new ArrayList<>(getBookInterface.getBooksAll(start_subscript,pageSize));
            if(books.size()>0){
                result.setStatus(100);
                result.setMsg("获取成功.");
                result.setValue(books);
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
    @Autowired
    ExportBookInterface exportBookInterface;
    @RequestMapping(value = "/exportBook", method = RequestMethod.POST)
    @CrossOrigin(origins = "*")
    public Result exportBook(
            @Param("book_id")int book_id,
            @Param("store_id")int store_id
    ){
        Result result = new Result();
        try {
            exportBookInterface.exportBook(book_id, store_id);
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
    @RequestMapping(value = "/importBook", method = RequestMethod.POST)
    @CrossOrigin(origins = "*")
    public Result importBook(
            @Param("book_id")int book_id,
            @Param("store_id")int store_id,
            @Param("number")int number,
            @Param("price")double price
    ){
        Result result = new Result();
        try {
            exportBookInterface.importBook(book_id, store_id, number, price);
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
    @Autowired
    RevisePriceInterface revisePriceInterface;
    @RequestMapping(value = "/revisePrice", method = RequestMethod.POST)
    @CrossOrigin(origins = "*")
    public Result revisePrice(
            @Param("book_id")int book_id,
            @Param("store_id")int store_id,
            @Param("price")double price
    ){
        Result result = new Result();
        try {
            revisePriceInterface.revisePrice(book_id, store_id, price);
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
