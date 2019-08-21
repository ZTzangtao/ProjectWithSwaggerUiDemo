package com.bbd.common.handler;

import com.bbd.core.entity.LaArticle;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 处理CNY人民币
 *
 * @author zangtao
 * @create 2019 - 08 -15 10:45
 */
public class MoneyTypeHandler extends BaseTypeHandler<LaArticle> {

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, LaArticle laArticle, JdbcType jdbcType) throws SQLException {

    }

    @Override
    public LaArticle getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return null;
    }

    @Override
    public LaArticle getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return null;
    }

    @Override
    public LaArticle getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return null;
    }
}
