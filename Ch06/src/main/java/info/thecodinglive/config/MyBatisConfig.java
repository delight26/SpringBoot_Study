package info.thecodinglive.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
@MapperScan(basePackages = {"info.thecodinglive.repository"})
public class MyBatisConfig {
	
	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
		
		SqlSessionFactoryBean sqlsessionfactrBean = new SqlSessionFactoryBean();
		sqlsessionfactrBean.setDataSource(dataSource);
		sqlsessionfactrBean.setConfigLocation((new PathMatchingResourcePatternResolver().getResource("classpath:mybatis-config.xml")));
		sqlsessionfactrBean.setMapperLocations((new PathMatchingResourcePatternResolver().getResources("classpath:sample/mapper/*.xml")));
		return sqlsessionfactrBean.getObject();
	}
}
