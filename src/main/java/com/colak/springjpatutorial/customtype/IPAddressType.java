package com.colak.springjpatutorial.customtype;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.ParameterizedType;
import org.hibernate.usertype.UserType;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Properties;

public class IPAddressType implements UserType<IPAddress>, ParameterizedType {
    private String scheme = "https://";

    @Override
    public int getSqlType() {
        return Types.VARCHAR;
    }

    @Override
    public Class<IPAddress> returnedClass() {
        return IPAddress.class;
    }

    @Override
    public boolean equals(IPAddress x, IPAddress y) {
        return x != null && x.equals(y);
    }

    @Override
    public int hashCode(IPAddress x) {
        return x.hashCode();
    }

    @Override
    public IPAddress nullSafeGet(ResultSet rs, int column, SharedSessionContractImplementor session, Object owner) throws SQLException {
        String address = rs.getString(column);
        if (address != null && !address.startsWith(scheme)) {
            address = scheme + address;
        }
        return address != null ? new IPAddress(address) : null;
    }

    @Override
    public void nullSafeSet(PreparedStatement st, IPAddress value, int index, SharedSessionContractImplementor session) throws SQLException {
        if (value == null || value.getAddress() == null) {
            st.setNull(index, Types.VARCHAR);
        } else {
            String address = value.getAddress();
            if (!address.startsWith("http://") && !address.startsWith("https://")) {
                address = scheme + address;
            }
            st.setString(index, address);
        }
    }

    @Override
    public IPAddress deepCopy(IPAddress value) {
        return new IPAddress(value.getAddress());
    }

    @Override
    public boolean isMutable() {
        return true;
    }

    @Override
    public Serializable disassemble(IPAddress value) {
        return value.getAddress();
    }

    @Override
    public IPAddress assemble(Serializable cached, Object owner) {
        return new IPAddress((String) cached);
    }

    @Override
    public IPAddress replace(IPAddress detached, IPAddress managed, Object owner) {
        return deepCopy(detached);
    }

    @Override
    public void setParameterValues(Properties parameters) {
        String paramScheme = parameters.getProperty("scheme");
        if (paramScheme != null && (paramScheme.equals("http") || paramScheme.equals("https"))) {
            scheme = paramScheme + "://";
        }
    }
}
