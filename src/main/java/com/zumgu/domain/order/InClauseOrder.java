package com.zumgu.domain.order;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.criterion.Order;

import java.util.List;

/**
 * Created by kanghonggu on 2017-01-31.
 */
public class InClauseOrder extends Order {
    private List<Long> ids;

    public InClauseOrder(List<Long> ids) {
        super("", true);

        this.ids = ids;

    }

    @Override
    public String toSqlString(Criteria criteria, CriteriaQuery criteriaQuery) throws HibernateException {
        String sql = "FIELD (this_.id, ";

        for (int i = 0; i < ids.size(); i++) {
            if (i == (ids.size() - 1)) {
                sql = sql.concat(ids.get(i) + ")");
                break;
            }

            sql = sql.concat(ids.get(i) + ",");
        }

        return sql;
    }
}
