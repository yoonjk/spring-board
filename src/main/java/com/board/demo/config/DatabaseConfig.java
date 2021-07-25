package com.board.demo.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@Configuration
public class DatabaseConfig {
	  @Bean
	  public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
	    SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
	    sessionFactoryBean.setDataSource(dataSource);

	    Resource[] res = new PathMatchingResourcePatternResolver().getResources("classpath:mappers/*/*Mapper.xml");
	    sessionFactoryBean.setMapperLocations(res);

	    return sessionFactoryBean.getObject();
	  }

	  @Bean
	  public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) throws Exception {
	    final SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
	    return sqlSessionTemplate;
	  }
}
