package tobi.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import tobi.spring.sql.SqlService;

import javax.sql.DataSource;

@Configuration
public class SqlServiceContext {

    @Autowired
    SqlMapConfig sqlMapConfig;

    @Bean
    public SqlService sqlService() {
        OxmSqlService sqlService = new OxmSqlService();
        sqlService.setUnmarshaller(unmarshaller());
        //sqlService.setSqlRegistry(sqlRegistry());
        sqlService.setSqlMapFile(this.sqlMapConfig.getSqlMapResource());
        return sqlService;
    }

//    @Bean
//    public SqlRegistry sqlRegistry() {
//        EmbeddedDbSqlRegistry sqlRegistry = new EmbeddedDbSqlRegistry();
//        sqlRegistry.setDataSource(embeddedDatabase());
//        return sqlRegistry;
//    }


    @Bean
    public Unmarshaller unmarshaller() {
        Jaxb2Marshaller unmarshaller = new Jaxb2Marshaller();
        unmarshaller.setContextPath("com.tobi.domain.sql.jaxb");
        return unmarshaller;
    }

    @Bean
    public DataSource embeddedDatabase() {

        return new EmbeddedDatabaseBuilder()
                .setName("embeddedDatabase")
                .setType(EmbeddedDatabaseType.HSQL)
                .addScript("classpath:com/tobi/test/sqlRegistrySchema.sql")
                .build();
    }
}
