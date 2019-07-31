package com.springboot.datasource;

import com.mysql.jdbc.jdbc2.optional.MysqlXADataSource;
import com.springboot.dbconfig.DBConfig1;
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
@MapperScan(basePackages = "com.springboot.data1.mapper",sqlSessionFactoryRef = "data1SqlSessionFactory")
public class DataSource1{
    //配置主数据源
    @Bean(name = "data1Source")
    @Primary
    public DataSource dataSource(DBConfig1 dbConfig1) throws SQLException {
        MysqlXADataSource mysqlXADataSource = new MysqlXADataSource();
        mysqlXADataSource.setUrl(dbConfig1.getUrl());
        mysqlXADataSource.setPinGlobalTxToPhysicalConnection(true);
        mysqlXADataSource.setPassword(dbConfig1.getPassword());
        mysqlXADataSource.setUser(dbConfig1.getUsername());
        mysqlXADataSource.setPinGlobalTxToPhysicalConnection(true);

        AtomikosDataSourceBean atomikosDataSourceBean = new AtomikosDataSourceBean();
        atomikosDataSourceBean.setXaDataSource(mysqlXADataSource);
        atomikosDataSourceBean.setUniqueResourceName("data1Source");
        atomikosDataSourceBean.setMinPoolSize(dbConfig1.getMinPoolSize());
        atomikosDataSourceBean.setMaxPoolSize(dbConfig1.getMaxPoolSize());
        atomikosDataSourceBean.setMaxLifetime(dbConfig1.getMaxLifetime());
        atomikosDataSourceBean.setBorrowConnectionTimeout(dbConfig1.getBorrowConnectionTimeout());
        atomikosDataSourceBean.setLoginTimeout(dbConfig1.getLoginTimeout());
        atomikosDataSourceBean.setMaintenanceInterval(dbConfig1.getMaintenanceInterval());
        atomikosDataSourceBean.setMaxIdleTime(dbConfig1.getMaxIdleTime());
        return atomikosDataSourceBean;
    }
    //配置会话工厂
    @Bean(name = "data1SqlSessionFactory")
    @Primary
    public SqlSessionFactory sqlSessionFactory(@Qualifier("data1Source") DataSource ds) throws Exception{
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(ds);
        return bean.getObject();
    }
    //配置会话模板
    @Bean(name = "data1SqlSessionTemplate")
    @Primary
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("data1SqlSessionFactory") SqlSessionFactory sessionFactory) throws  Exception{
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
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration//注解到spring容器中
@MapperScan(basePackages = "com.springboot.data1.mapper",sqlSessionFactoryRef = "data1SqlSessionFactory")
public class DataSource1 {

    *//**
     * 返回data1数据库的数据源
     * @return
     *//*
    @Bean(name="data1Source")
    @Primary//主数据源
    @ConfigurationProperties(prefix = "spring.datasource.data1")
    public DataSource dataSource(){
        return DataSourceBuilder.create().build();
    }

    *//**
     * 返回data1数据库的会话工厂
     * @param ds
     * @return
     * @throws Exception
     *//*
    @Bean(name = "data1SqlSessionFactory")
    @Primary
    public SqlSessionFactory sqlSessionFactory(@Qualifier("data1Source") DataSource ds) throws Exception{
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(ds);
        return bean.getObject();
    }

    *//**
     * 返回data1数据库的会话模板
     * @param sessionFactory
     * @return
     * @throws Exception
     *//*
    @Bean(name = "data1SqlSessionTemplate")
    @Primary
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("data1SqlSessionFactory") SqlSessionFactory sessionFactory) throws  Exception{
        return  new SqlSessionTemplate(sessionFactory);
    }

    *//**
     * 返回data1数据库的事务
     * @param ds
     * @return
     *//*
    @Bean(name = "data1TransactionManager")
    @Primary
    public DataSourceTransactionManager transactionManager(@Qualifier("data1Source") DataSource ds){
        return new DataSourceTransactionManager(ds);
    }
}*/
