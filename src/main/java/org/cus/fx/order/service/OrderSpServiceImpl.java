package org.cus.fx.order.service;

import org.cus.fx.order.dao.OrderSpDao;
import org.cus.fx.order.dao.OrderSpDaoImpl;
import org.cus.fx.order.model.OrderSpModel;
import org.cus.fx.spgl.model.SpglModel;

import java.util.List;
import java.util.StringJoiner;
import java.util.logging.Logger;

public class OrderSpServiceImpl implements OrderSpService {

    private static Logger logger = Logger.getLogger(OrderSpServiceImpl.class.toString());

    @Override
    public List<SpglModel> getByOrderId(String id) {
        OrderSpDao dao = new OrderSpDaoImpl();
        StringJoiner sql = new StringJoiner("");
        sql.add("select o.uuid uuid,c.cname cname,o.spdj jg,c.dw dw,c.ge ge," +
                "c.pp pp,o.spsl sl,o.spzj sxj from ordersp_table o left join commodity_table c on c.uuid = o.spid" +
                " where o.uuid = '" + id + "'");
        logger.info(sql.toString());
        return dao.query(sql.toString());
    }

    @Override
    public int update(OrderSpModel model) {
        OrderSpDao dao = new OrderSpDaoImpl();
        StringJoiner sql = new StringJoiner("");
        sql.add("update order_table set zt='" + model.getZt() + "' where uuid = '" + model.getUuid() + "'");
        logger.info(sql.toString());
        return dao.data(sql.toString());
    }
}
