package org.cus.fx.order.service.serviceImpl;

import org.cus.fx.order.dao.OrderDao;
import org.cus.fx.order.dao.OrderDaoImpl;
import org.cus.fx.order.model.OrderModel;
import org.cus.fx.order.service.OrderService;
import org.cus.fx.util.GetUuid;

import java.util.List;
import java.util.StringJoiner;
import java.util.logging.Logger;

public class OrderServiceImpl implements OrderService {

    private static Logger logger = Logger.getLogger(OrderServiceImpl.class.toString());

    @Override
    public List<OrderModel> page(int pageNow, String zt) {
        pageNow = pageNow < 0 ? 0 : pageNow * 15;
        OrderDao dao = new OrderDaoImpl();
        StringJoiner sql = new StringJoiner("");
        String s = "";
        if (zt != null && !zt.trim().equals(""))
            s = " where type = " + zt;
        sql.add("select * from order_table " + s + " order by cjtime desc LIMIT " + pageNow + ",15");
        logger.info(sql.toString());
        return dao.query(sql.toString());
    }

    @Override
    public List<OrderModel> getById(String id) {
        OrderDao dao = new OrderDaoImpl();
        StringJoiner sql = new StringJoiner("");
        String s = " where uuid = " + id;
        sql.add("select * from order_table " + s);
        logger.info(sql.toString());
        return dao.query(sql.toString());
    }

    @Override
    public int update(OrderModel model) {
        OrderDao dao = new OrderDaoImpl();
        StringJoiner sql = new StringJoiner("");
        sql.add("update order_table set spid='" + model.getSpid() + "'," +
                "sl='" + model.getSl() + "'," +
                "zj='" + model.getZj() + "'," +
                "address='" + model.getAddress() + "'," +
                "phone='" + model.getPhone() + "'," +
                "ddbh='" + model.getDdbh() + "'," +
                "cjtime='" + model.getCjTime() + "'," +
                "account='" + model.getAccount() + "'," +
                "type='" + model.getType() + "' where uuid = '" + model.getUuid() + "'");
        logger.info(sql.toString());
        return dao.data(sql.toString());
    }

    @Override
    public int add(OrderModel model) {
        OrderDao dao = new OrderDaoImpl();
        StringJoiner sql = new StringJoiner("");
        sql.add("insert into order_table (uuid,spid,sl,zj,address,phone,ddbh,cjtime,account,type)");
        sql.add(" values ");
        sql.add("(");

        sql.add("'");
        sql.add(GetUuid.getUUID());
        sql.add("',");
        sql.add("'");
        sql.add(model.getSpid());
        sql.add("',");
        sql.add("'");
        sql.add(model.getSl());
        sql.add("',");
        sql.add("'");
        sql.add(model.getZj());
        sql.add("',");
        sql.add("'");
        sql.add(model.getAddress());
        sql.add("',");
        sql.add("'");
        sql.add(model.getPhone());
        sql.add("',");
        sql.add("'");
        sql.add(model.getDdbh());
        sql.add("',");
        sql.add("'");
        sql.add(model.getCjTime());
        sql.add("',");
        sql.add("'");
        sql.add(model.getAccount());
        sql.add("',");
        sql.add(model.getType() + "");

        sql.add(")");
        logger.info(sql.toString());
        return dao.data(sql.toString());
    }

    @Override
    public int del(String id) {
        OrderDao dao = new OrderDaoImpl();
        StringJoiner sql = new StringJoiner("");
        sql.add("delete from order_table where uuid = '" + id + "'");
        logger.info(sql.toString());
        return dao.data(sql.toString());
    }
}
