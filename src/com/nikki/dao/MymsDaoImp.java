package com.nikki.dao;

import com.nikki.bean.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface MymsDaoImp {
    /**
     * 方法为获取商店列表
     * @param page 分页的页数
     * @param limit 每页多少条数据
     * @return list
     * @throws SQLException 当发生错误时抛出异常
     */
    List<Store_Account> getAllStore(String page,String limit) throws SQLException;

    /**
     * 方法为获取指定餐厅的菜品
     * @param S_id 餐厅id
     * @return List<Store_Food>
     * @throws SQLException 抛出Sql异常
     */
    List<Store_Food> getStoreFood(String S_id) throws SQLException;

    /**
     * 模糊查询所有菜品
     * @param F_name 菜品名字
     * @return List<Store_Food>
     * @throws SQLException 抛出Sql异常
     */
    List<Store_Food> getFoods(String F_name) throws SQLException;

    /**
     * 查询用户订单
     * @param _openid 用户id
     * @param state 订单类型
     * @return List<Orders>
     * @throws SQLException 抛出Sql异常
     */
    List<Orders> getOrders(String _openid,String state) throws SQLException;

    /**
     * 根据订单号获取订单里面的菜品
     * @param _id 订单id
     * @return 订单所包含的菜品
     * @throws SQLException 抛出Sql异常
     */
    List<Goods> getGoods(String _id) throws SQLException;

    /**
     * 生成订单
     * @param orders 订单类
     * @return 布尔值:true = 成功，false = 失败
     * @throws SQLException 抛出Sql异常
     */
    boolean generateOrder(Orders orders) throws SQLException;

    /**
     * 查询餐厅类型
     * @param S_type 餐厅id
     * @return 餐厅类型
     * @throws SQLException 抛出Sql异常
     */
    List<Store_Account> getStores(String S_type) throws SQLException;

    /**
     * 添加订购菜品
     * @param goods 订购菜品类
     * @return 布尔值:true = 成功，false = 失败
     * @throws SQLException 抛出Sql异常
     */
    boolean insertGoods(Goods goods) throws SQLException;

    /**
     * 查询所有商店的数量并返回
     * @return int 商店的数量
     * @throws SQLException 抛出Sql异常
     */
    int selectAll() throws SQLException;

    /**
     * 取消订单
     * @param _id 订单id
     * @param _openid 用户id
     * @return 布尔值:true = 成功，false = 失败
     * @throws SQLException 抛出Sql异常
     */
    boolean cancelOrder(String _id,String _openid) throws SQLException;

    /**
     * 完成订单
     * @param _id 订单id
     * @param _openid 用户id
     * @return 布尔值:true = 成功，false = 失败
     * @throws SQLException 抛出Sql异常
     */
     boolean endOrder(String _id, String _openid) throws SQLException;

    /**
     * 查询订单状态
     * @param _id 订单id
     * @param _openid 订餐人id
     * @return 订单状态
     * @throws SQLException 抛出Sql异常
     */
    int selectState(String _id,String _openid) throws SQLException;

    /**
     * 设置用户信息
     * @param user  用户
     * @return 布尔值:true = 成功，false = 失败
     * @throws SQLException 抛出Sql异常
     */
    boolean setUser(User user) throws SQLException;

    /**
     * 查询用户
     * @param _openid 用户id
     * @return 返回用户信息
     * @throws SQLException 抛出Sql异常
     */
    User getUser(String _openid) throws SQLException;

    /**
     * 查询活动
     * @return 活动image
     * @throws SQLException 抛出Sql异常
     */
    String getSImage(String S_id) throws SQLException;
}
