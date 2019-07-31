package com.springboot.datasource;

import com.mysql.jdbc.jdbc2.optional.MysqlXADataSource;
import com.springboot.dbconfig.DBConfig1;
import com.springboot.dbconfig.DBConfig2;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@MapperScan(basePackages = "com.springboot.data2.mapper",sqlSessionFactoryRef = "data2SqlSessionFactory")
public class DataSource2{
    //配置主数据源
    @Bean(name = "data2Source")
    public DataSource dataSource(DBConfig2 dbConfig2) throws SQLException {
        MysqlXADataSource mysqlXADataSource = new MysqlXADataSource();
        mysqlXADataSource.setUrl(dbConfig2.getUrl());
        mysqlXADataSource.setPinGlobalTxToPhysicalConnection(true);
        mysqlXADataSource.setPassword(dbConfig2.getPassword());
        mysqlXADataSource.setUser(dbConfig2.getUsername());
        mysqlXADataSource.setPinGlobalTxToPhysicalConnection(true);

        AtomikosDataSourceBean atomikosDataSourceBean = new AtomikosDataSourceBean();
        atomikosDataSourceBean.setXaDataSource(mysqlXADataSource);
        atomikosDataSourceBean.setUniqueResourceName("data2Source");
        atomikosDataSourceBean.setMinPoolSize(dbConfig2.getMinPoolSize());
        atomikosDataSourceBean.setMaxPoolSize(dbConfig2.getMaxPoolSize());
        atomikosDataSourceBean.setMaxLifetime(dbConfig2.getMaxLifetime());
        atomikosDataSourceBean.setBorrowConnectionTimeout(dbConfig2.getBorrowConnectionTimeout());
        atomikosDataSourceBean.setLoginTimeout(dbConfig2.getLoginTimeout());
        atomikosDataSourceBean.setMaintenanceInterval(dbConfig2.getMaintenanceInterval());
        atomikosDataSourceBean.setMaxIdleTime(dbConfig2.getMaxIdleTime());
        return atomikosDataSourceBean;
    }
    //配置会话工厂
    @Bean(name = "data2SqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("data2Source") DataSource ds) throws Exception{
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(ds);
        return bean.getObject();
    }
    //配置会话模板
    @Bean(name = "data2SqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("data2SqlSessionFactory") SqlSessionFactory sessionFactory) throws  Exception{
        return  new SqlSessionTemplate(sessionFactory);
    }
}

/*import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration//注解到spring容器中
@MapperScan(basePackages = "com.springboot.data2.mapper",sqlSessionFactoryRef = "data2SqlSessionFactory")
public class DataSource2 {

    *//**
     * 返回data2数据库的数据源
     * @return
     *//*
    @Bean(name="data2Source")
    @ConfigurationProperties(prefix = "spring.datasource.data2")
    public DataSource dataSource(){
        return DataSourceBuilder.create().build();
    }

    *//**
     * 返回data2数据库的会话工厂
     * @param ds
     * @return
     * @throws Exception
     *//*
    @Bean(name = "data2SqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("data2Source") DataSource ds) throws Exception{
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(ds);
        return bean.getObject();
    }

    *//**
     * 返回data2数据库的会话模板
     * @param sessionFactory
     * @return
     * @throws Exception
     *//*
    @Bean(name = "data2SqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("data2SqlSessionFactory") SqlSessionFactory sessionFactory) throws  Exception{
        return  new SqlSessionTemplate(sessionFactory);
    }

    *//**
     * 返回data2数据库的事务
     * @param ds
     * @return
     *//*
    @Bean(name = "data2TransactionManager")
    public DataSourceTransactionManager transactionManager(@Qualifier("data2Source") DataSource ds){
        return new DataSourceTransactionManager(ds);
    }
}*/
