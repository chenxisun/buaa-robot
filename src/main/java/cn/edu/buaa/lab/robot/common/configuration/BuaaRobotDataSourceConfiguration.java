//package cn.edu.buaa.lab.robot.common.configuration;
//
//import org.apache.tomcat.jdbc.pool.PoolProperties;
//import org.flywaydb.core.Flyway;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//import org.springframework.transaction.PlatformTransactionManager;
//
//import javax.sql.DataSource;
//import java.util.Properties;
//
//@Configuration
//@EnableJpaRepositories(
//        entityManagerFactoryRef = "buaaRobotEntityManagerFactory",
//        transactionManagerRef = "buaaRobotTransactionManager",
//        basePackages = {"cn.edu.buaa.lab.robot.repository"})
//public class BuaaRobotDataSourceConfiguration {
//
//    @Bean
//    @ConfigurationProperties("spring.datasource.tomcat")
//    public PoolProperties buaaRobotPoolProperties() {
//        return new PoolProperties();
//    }
//
//    @Bean
//    @ConfigurationProperties("spring.datasource")
//    public DataSourceProperties buaaRobotDataSourceProperties() {
//        return new DataSourceProperties();
//    }
//
//    @Bean
//    public DataSource buaaRobotDataSource() {
//        PoolProperties poolProperties = buaaRobotPoolProperties();
//        DataSourceProperties dataSourceProperties = buaaRobotDataSourceProperties();
//
//        poolProperties.setDriverClassName(dataSourceProperties.getDriverClassName());
//        poolProperties.setUrl(dataSourceProperties.getUrl());
//        poolProperties.setUsername(dataSourceProperties.getUsername());
//        poolProperties.setPassword(dataSourceProperties.getPassword());
//
//        return new org.apache.tomcat.jdbc.pool.DataSource(poolProperties);
//    }
//
//    @Bean
//    PlatformTransactionManager buaaRobotTransactionManager() {
//        return new JpaTransactionManager(buaaRobotEntityManagerFactory().getObject());
//    }
//
//    @Bean
//    LocalContainerEntityManagerFactoryBean buaaRobotEntityManagerFactory() {
//
//        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        vendorAdapter.setGenerateDdl(true);
//
//        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
//
//        factoryBean.setDataSource(buaaRobotDataSource());
//        factoryBean.setJpaVendorAdapter(vendorAdapter);
//        factoryBean.setPackagesToScan(new String[]{"cn.edu.buaa.lab.robot.model"});
//        factoryBean.setJpaProperties(additionalProperties());
//
//        return factoryBean;
//    }
//
//    Properties additionalProperties() {
//        Properties properties = new Properties();
//        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
//        properties.setProperty("hibernate.show_sql", "true");
//        properties.setProperty("hibernate.hbm2ddl.auto", "none");
////        properties.setProperty("hibernate.hbm2ddl.auto", "update");
//        properties.setProperty("hibernate.enable_lazy_load_no_trans", "true");
//        return properties;
//    }
//
//    @Bean(initMethod = "migrate")
//    public Flyway flyway() {
//        Flyway flyway = new Flyway();
//        flyway.setDataSource(buaaRobotDataSource());
//        flyway.setBaselineOnMigrate(true);
//        flyway.setValidateOnMigrate(false);
//        flyway.migrate();
//        return flyway;
//    }
//}
