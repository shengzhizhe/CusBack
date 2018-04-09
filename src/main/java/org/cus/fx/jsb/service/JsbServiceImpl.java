package org.cus.fx.jsb.service;

import org.cus.fx.jsb.dao.JsbDao;
import org.cus.fx.jsb.dao.JsbDaoImpl;
import org.cus.fx.jsb.model.JsbModel;
import org.cus.fx.util.GetUuid;

import java.util.List;
import java.util.StringJoiner;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
public class JsbServiceImpl implements JsbService {
    @Override
    public int add(JsbModel model) {
        JsbDao dao = new JsbDaoImpl();
        StringJoiner sql = new StringJoiner("");
        sql.add("insert into jsb_table (uuid,rq,titles,bodys)");
        sql.add(" values ");
        sql.add("('" + GetUuid.getUUID() + "','" + model.getRq() + "','" + model.getTitles() + "','" + model.getBodys() + "')");
        return dao.data(sql.toString());
    }

    @Override
    public int update(JsbModel model) {
        return 0;
    }

    @Override
    public int delete(String id) {
        JsbDao dao = new JsbDaoImpl();
        StringJoiner sql = new StringJoiner("");
        sql.add("delete from jsb_table where uuid = '" + id + "'");
        return dao.data(sql.toString());
    }

    @Override
    public List<JsbModel> get(String account,int page) {
        page = page < 0 ? 0 : page*15;
        JsbDao dao = new JsbDaoImpl();
        StringJoiner sql = new StringJoiner("");
        sql.add("select * from jsb_table order by rq desc LIMIT "+page+",15");
        return dao.get(sql.toString());
    }
}
