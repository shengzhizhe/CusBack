package org.cus.fx.spgl.service;

import org.cus.fx.order.service.serviceImpl.OrderServiceImpl;
import org.cus.fx.spgl.dao.SpglDao;
import org.cus.fx.spgl.dao.SpglDaoImpl;
import org.cus.fx.spgl.model.SpglModel;
import org.cus.fx.util.GetUuid;

import java.util.List;
import java.util.StringJoiner;
import java.util.logging.Logger;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
public class SpglServiceImpl implements SpglService {

    private static Logger logger = Logger.getLogger(SpglServiceImpl.class.toString());

    @Override
    public int add(SpglModel model) {
        SpglDao dao = new SpglDaoImpl();
        StringJoiner sql = new StringJoiner("");
        sql.add("insert into commodity_table (uuid,cname,jg,dw,ge,zt,pp,xq,xl,busid,sl,lm,sxj)");
        sql.add(" values ");
        sql.add("('" + GetUuid.getUUID() + "','"
                + model.getCname() + "',"
                + model.getJg() + ",'"
                + model.getDw() + "','"
                + model.getGe() + "','"
                + model.getZt() + "','"
                + model.getPp() + "','"
                + model.getXq() + "','"
                + model.getXl() + "','"
                + model.getBusid() + "',"
                + model.getSl() + ",'"
                + model.getLm() + "',"
                + model.getSxj() + ")");
        logger.info(sql.toString());
        return dao.data(sql.toString());
    }

    @Override
    public int update(SpglModel model) {
        SpglDao dao = new SpglDaoImpl();
        StringJoiner sql = new StringJoiner("");
        sql.add("update commodity_table set cname='" + model.getCname() + "',jg=" + model.getJg() + ",dw='"
                + model.getDw() + "',ge='" + model.getGe() + "',zt='" + model.getZt() + "',pp='" + model.getPp()
                + "',xq='" + model.getXq() + "',xl='" + model.getXl() + "',busid='" + model.getBusid() + "',sl=" + model.getSl()
                + ",lm='" + model.getLm() + "',sxj=" + model.getSxj() + "");
        sql.add(" where uuid = '" + model.getUuid() + "'");
        logger.info(sql.toString());
        return dao.data(sql.toString());
    }

    @Override
    public int delete(String id) {
        SpglDao dao = new SpglDaoImpl();
        StringJoiner sql = new StringJoiner("");
        sql.add("delete from commodity_table where uuid = '" + id + "'");
        logger.info(sql.toString());
        return dao.data(sql.toString());
    }

    @Override
    public List<SpglModel> get(String account, int page) {
        page = page < 0 ? 0 : page * 15;
        SpglDao dao = new SpglDaoImpl();
        StringJoiner sql = new StringJoiner("");
        sql.add("select * from commodity_table order by cname desc LIMIT " + page + ",15");
        logger.info(sql.toString());
        return dao.get(sql.toString());
    }
}
