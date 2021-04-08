package com.nikki.dao;

import com.nikki.bean.*;
import com.nikki.utils.DBUtils;
import com.nikki.utils.RandomUtil;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@SuppressWarnings("all")
public class MymsDao implements MymsDaoImp{
    private static Connection conn = null;
    private static ResultSet rs = null;
    private static PreparedStatement ps = null;
    /**
     *
     * @param page 分页的页数
     * @param limit 每页多少条数据
     * @return list
     * @throws SQLException 抛出异常
     */
    @Override
    public List<Store_Account> getAllStore(String page, String limit) throws SQLException {
        List<Store_Account> list = new ArrayList<>();
        conn = DBUtils.getConnection();
        String sql = "SELECT * FROM `store_account` WHERE 1 = 1";
        if(page != null && limit != null) {
            int num = (Integer.parseInt(page) - 1 ) * Integer.parseInt(limit);
            sql += " LIMIT " + num + ","  + Integer.parseInt(limit);
        }
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnsNumber = rsmd.getColumnCount();
        while (rs.next()) {
            Store_Account store_account = new Store_Account();
            store_account.setS_content(rs.getString("S_content"));
            store_account.setS_id(rs.getInt("S_id"));
            store_account.setS_image(rs.getString("S_image"));
            store_account.setS_name(rs.getString("S_name"));
            store_account.setS_telephone(rs.getString("S_telephone"));
            list.add(store_account);
        }
        rs.close();
        ps.close();
        conn.close();
        return list;
    }

    /**
     * 方法为获取指定餐厅的菜品
     * @param S_id 餐厅id
     * @return List<Store_Food>
     * @throws SQLException 抛出Sql异常
     */
    public static Connection connection = DBUtils.getConnection();
    @Override
    public List<Store_Food> getStoreFood(String S_id) throws SQLException {
        if(S_id == null)return null;
        List<Store_Food> store_foods = new ArrayList<>();
        connection = DBUtils.getConnection();
        String sql = "SELECT * FROM `store_food` WHERE S_id = ?";
        ps = connection.prepareStatement(sql);
        ps.setInt(1,Integer.parseInt(S_id));
        rs = ps.executeQuery();
        while (rs.next()){
            Store_Food store_food = new Store_Food();
            store_food.setF_id(rs.getInt("F_id"));
            store_food.setF_image(rs.getString("F_image"));
            store_food.setF_introduction(rs.getString("F_introduction"));
            store_food.setF_name(rs.getString("F_name"));
            store_food.setF_price(rs.getInt("F_price"));
            store_food.setF_kind(rs.getString("F_kind"));
            store_food.setF_unit(rs.getString("F_unit"));
            store_food.setS_id(rs.getInt("S_id"));
            store_food.setF_date(rs.getString("F_date"));
            store_foods.add(store_food);
        }
        rs.close();
        ps.close();
        return store_foods;
    }

    /**
     * 模糊查询所有菜品
     * @param F_name 菜品名字
     * @return List<Store_Food>
     * @throws SQLException 抛出Sql异常
     */
    @Override
    public List<Store_Food> getFoods(String F_name) throws SQLException {
        List<Store_Food> store_foods = new ArrayList<>();
        conn = DBUtils.getConnection();
        String sql = "SELECT * FROM `store_food` WHERE 1 = 1";
        System.out.println(F_name);
        if(F_name!=null){
            sql += " AND F_name LIKE '%" + F_name + "%'";
        }
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()){
            Store_Food store_food = new Store_Food();
            store_food.setF_id(rs.getInt("F_id"));
            store_food.setF_image(rs.getString("F_image"));
            store_food.setF_introduction(rs.getString("F_introduction"));
            store_food.setF_name(rs.getString("F_name"));
            store_food.setF_price(rs.getInt("F_price"));
            store_food.setF_kind(rs.getString("F_kind"));
            store_food.setF_unit(rs.getString("F_unit"));
            store_food.setS_id(rs.getInt("S_id"));
            store_food.setF_date(rs.getString("F_date"));
            store_foods.add(store_food);
        }
        rs.close();
        ps.close();
        conn.close();
        return store_foods;
    }

    /**
     * 查询用户订单
     * @param _openid 用户id
     * @param state 订单类型
     * @return List<Orders>
     * @throws SQLException 抛出Sql异常
     */
    @Override
    public List<Orders> getOrders(String _openid, String state) throws SQLException {
        List<Orders> orders = new ArrayList<>();
        if(_openid==null||state==null)return null;
        conn = DBUtils.getConnection();
        String sql = "";
        if(Integer.parseInt(state)!=2) {
            sql = "SELECT * FROM `orders` WHERE `_openid` = ? AND `state` >= ? AND `state` < 2 ORDER BY date DESC";
        }else {
            sql = "SELECT * FROM `orders` WHERE `_openid` = ? AND `state` = ? ORDER BY date DESC";
        }
        ps = conn.prepareStatement(sql);
        ps.setString(1,_openid);
        ps.setInt(2,Integer.parseInt(state));
        rs = ps.executeQuery();
        while (rs.next()){
            Orders orders1 = new Orders();
            orders1.set_id(rs.getString("_id"));
            orders1.set_openid(rs.getString("_openid"));
            orders1.setDate(rs.getString("date"));
            orders1.setState(rs.getInt("state"));
            orders1.setPrice(rs.getInt("price"));
            String _id = rs.getString("_id");
//            List<Goods> goods = getGoods(_id);
//            orders1.setFood(goods);
//            for (Goods goods1:goods){
//                num += goods1.getGoods_num() * goods1.getGoods_price();
//            }
//            orders1.setPrice(num);
            orders.add(orders1);
        }
        rs.close();
        ps.close();
        conn.close();
        return orders;
    }

    /**
     * 根据订单号获取订单里面的菜品
     * @param _id 订单id
     * @return 订单所包含的菜品
     * @throws SQLException 抛出Sql异常
     */
    @Override
    public List<Goods> getGoods(String _id) throws SQLException {
        if(_id==null)return null;
        List<Goods> goods = new ArrayList<>();
        String sql = "SELECT goods.F_id,goods.goods_num,store_food.F_image,store_food.F_introduction,store_food.F_name,store_food.F_price,goods.goods_time,store_account.S_name,goods._openid\n" +
                "FROM goods,store_food,store_account,orders\n" +
                "WHERE goods._id = ? AND goods.F_id = store_food.F_id AND goods.S_id = store_account.S_id AND goods._id = orders._id";
        conn = DBUtils.getConnection();
        ps = conn.prepareStatement(sql);
        ps.setString(1,_id);
        rs = ps.executeQuery();
        while (rs.next()){
            Goods goods1 = new Goods();
            goods1.setF_id(rs.getInt("goods.F_id"));
            goods1.setGoods_num(rs.getInt("goods.goods_num"));
            goods1.setGoods_image(rs.getString("store_food.F_image"));
            goods1.setGoods_info(rs.getString("store_food.F_introduction"));
            goods1.setGoods_name(rs.getString("store_food.F_name"));
            goods1.setGoods_price(rs.getInt("store_food.F_price"));
            goods1.setGoods_time(rs.getLong("goods.goods_time"));
            goods1.setS_name(rs.getString("store_account.S_name"));
            goods1.set_openid(rs.getString("goods._openid"));
            goods.add(goods1);
        }
        rs.close();
        ps.close();
        conn.close();
        return goods;
    }

    /**
     * 生成订单
     * @param orders 订单类
     * @return 布尔值:true = 成功，false = 失败
     * @throws SQLException 抛出Sql异常
     */
    @Override
    public boolean generateOrder(Orders orders) throws SQLException {
        if(orders == null)return false;
        String sql = "INSERT INTO `orders`(`_id`, `_openid`, `date`, `food`, `price`, `state`) VALUES (?,?,?,?,?,?)";
        conn = DBUtils.getConnection();
        ps = conn.prepareStatement(sql);
        ps.setString(1,orders.get_id());
        ps.setString(2,orders.get_openid());
        ps.setString(3,orders.getDate());
        ps.setString(4,orders.getFood().toString());
        ps.setInt(5,orders.getPrice());
        ps.setInt(6,orders.getState());
        int row = ps.executeUpdate();
        ps.close();
        conn.close();
        return row > 0;
    }

    /**
     * 查询餐厅类型
     * @param S_type 餐厅类型
     * @return 符合条件的餐厅
     * @throws SQLException 抛出Sql异常
     */
    @Override
    public List<Store_Account> getStores(String S_type) throws SQLException {
        if(S_type == null) return null;
        List<Store_Account> store_accounts = new ArrayList<>();
        String sql = "SELECT * FROM store_account WHERE S_type = ?";
        conn = DBUtils.getConnection();
        ps = conn.prepareStatement(sql);
        ps.setInt(1,Integer.parseInt(S_type));
        rs = ps.executeQuery();
        while (rs.next()){
            Store_Account store_account = new Store_Account();
            store_account.setS_id(rs.getInt("S_id"));
            store_account.setS_name(rs.getString("S_name"));
            store_account.setS_menu(rs.getInt("S_menu"));
            store_account.setS_location(rs.getString("S_location"));
            store_account.setS_content(rs.getString("S_content"));
            store_account.setS_telephone(rs.getString("S_telephone"));
            store_account.setS_image(rs.getString("S_image"));
            store_account.setS_time(rs.getString("S_time"));
            store_account.setS_email(rs.getString("S_email"));
            store_account.setType(rs.getInt("S_type"));
            store_accounts.add(store_account);
        }
        rs.close();
        ps.close();
        conn.close();
        return store_accounts;
    }

    /**
     * 添加订购菜品
     * @param goods 订购菜品类
     * @return 布尔值:true = 成功，false = 失败
     * @throws SQLException 抛出Sql异常
     */
    @Override
    public boolean insertGoods(Goods goods) throws SQLException {
        if(goods == null)return false;
        String sql = "INSERT INTO `goods`(`_id`, `_openid`, `F_id`, `goods_num`, `S_id`, `goods_time`) VALUES (?,?,?,?,?,?)";
        conn = DBUtils.getConnection();
        ps = conn.prepareStatement(sql);
        ps.setString(1,goods.get_id());
        ps.setString(2,goods.get_openid());
        ps.setInt(3,goods.getF_id());
        ps.setInt(4,goods.getGoods_num());
        ps.setInt(5,goods.getS_id());
        ps.setLong(6,goods.getGoods_time());
        int row = ps.executeUpdate();
        ps.close();
        conn.close();
        return row > 0;
    }

    /**
     * 查询所有商店的数量并返回
     * @return int 商店的数量
     * @throws SQLException 抛出Sql异常
     */
    @Override
    public int selectAll() throws SQLException {
        String sql = "SELECT COUNT(*) FROM `store_account` WHERE 1 = 1";
        conn = DBUtils.getConnection();
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        int rows = 0;
        while (rs.next()){
            rows = rs.getInt(1);
        }
        rs.close();
        ps.close();
        conn.close();
        return rows;
    }

    /**
     * 取消订单
     * @param _id 订单id
     * @param _openid 用户id
     * @return 布尔值:true = 成功，false = 失败
     * @throws SQLException 抛出Sql异常
     */
    @Override
    public boolean cancelOrder(String _id, String _openid) throws SQLException {
        if(_id == null||_openid == null) return false;
        String sql = "UPDATE `orders` SET `state`= 3 WHERE _id = ? AND _openid = ?";
        conn = DBUtils.getConnection();
        ps = conn.prepareStatement(sql);
        ps.setString(1,_id);
        ps.setString(2,_openid);
        int rows = ps.executeUpdate();
        ps.close();
        conn.close();
        return rows > 0;
    }

    /**
     * 查询订单状态
     * @param _id 订单id
     * @param _openid 订餐人id
     * @return 订单状态
     * @throws SQLException 抛出Sql异常
     */
    @Override
    public int selectState(String _id, String _openid) throws SQLException {
        if(_id == null || _openid == null) return -1;
        String sql = "SELECT state FROM orders WHERE _id = ? AND _openid = ?";
        conn = DBUtils.getConnection();
        ps = conn.prepareStatement(sql);
        ps.setString(1,_id);
        ps.setString(2,_openid);
        int state = -1;
        rs = ps.executeQuery();
        while (rs.next()){
            state = rs.getInt(1);
        }
        rs.close();
        ps.close();
        conn.close();
        return state;
    }

    /**
     * 设置用户信息
     * @param user  用户
     * @return 布尔值:true = 成功，false = 失败
     * @throws SQLException 抛出Sql异常
     */
    @Override
    public boolean setUser(User user) throws SQLException {
        String sql = "";
        conn = DBUtils.getConnection();
        if(getUser(user.get_openid()).getEmail()!=null){
            sql = "UPDATE `user` SET `email`= ? WHERE `_openid` = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,user.getEmail());
            ps.setString(2,user.get_openid());
        }else {
            sql = "INSERT INTO `user`(`_openid`, `uname`, `email`) VALUES (?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1,user.get_openid());
            ps.setString(2,user.getUname());
            ps.setString(3,user.getEmail());
        }
        int rows = -1;
        rows = ps.executeUpdate();
        ps.close();
        conn.close();
        return rows > 0;
    }

    /**
     * 查询用户邮箱
     * @param _openid 用户id
     * @return 返回用户信息
     * @throws SQLException 抛出Sql异常
     */
    @Override
    public User getUser(String _openid) throws SQLException {
        if(_openid == null) return null;
        User user = new User();
        String sql = "SELECT * FROM `user` WHERE _openid = ?";
        conn = DBUtils.getConnection();
        ps = conn.prepareStatement(sql);
        ps.setString(1,_openid);
        rs = ps.executeQuery();
        while (rs.next()){
            user.set_openid(rs.getString("_openid"));
            user.setUname(rs.getString("uname"));
            user.setEmail(rs.getString("email"));
        }
        rs.close();
        ps.close();
        return user;
    }

    /**
     * 查询活动
     * @return 活动image
     * @throws SQLException 抛出Sql异常
     */
    @Override
    public String getSImage(String S_id) throws SQLException {
        if(S_id == null) return null;
        String sql = "SELECT A_image FROM store_activity WHERE S_id = ? AND A_state = 1";
        conn = DBUtils.getConnection();
        ps = conn.prepareStatement(sql);
        ps.setInt(1,Integer.parseInt(S_id));
        rs = ps.executeQuery();
        String A_image = "";
        while (rs.next()){
            A_image = rs.getString("A_image");
        }
        rs.close();
        ps.close();
        conn.close();
        return A_image;
    }

    /**
     * 取消订单
     * @param _id 订单id
     * @param _openid 用户id
     * @return 布尔值:true = 成功，false = 失败
     * @throws SQLException 抛出Sql异常
     */
    @Override
    public boolean endOrder(String _id, String _openid) throws SQLException {
        if(_id == null||_openid == null) return false;
        String sql = "UPDATE `orders` SET `state`= 2 WHERE _id = ? AND _openid = ?";
        conn = DBUtils.getConnection();
        ps = conn.prepareStatement(sql);
        ps.setString(1,_id);
        ps.setString(2,_openid);
        int rows = ps.executeUpdate();
        ps.close();
        conn.close();
        return rows > 0;
    }
}
