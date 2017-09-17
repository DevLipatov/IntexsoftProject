package by.intexsoft.backend.config;

import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/**
 * Annotated with {@link @Configuration} which indicates that a class is purely
 * used for Spring configuration. Several {@link @Bean} methods can be processed
 * by the Spring container.<br>
 * Additional information about utilized annotations:<br>
 * {@link @ComponentScan} defines a package to scan for a components<br>
 * {@link @EnableJpaRepositories} enables the use of Spring Data JPA
 * repositories<br>
 * {@link @PropertySource} provides a declarative mechanism for adding a
 * PropertySource to Spring's Environment. In our particular case it provides
 * database specific information<br>
 * {@link @EnableTransactionManagement} enables transaction management
 * capability<br>
 */
@Configuration
@ComponentScan("by.intexsoft.backend.service")
@EnableJpaRepositories("by.intexsoft.backend.repository")
@PropertySource("classpath:base.properties")
@EnableTransactionManagement
public class ApplicationConfiguration {

    @Autowired
    private Environment environment;

    /**
     * Configure a DataSource object
     *
     * @return configured DataSource object which is used for getting a
     * connection to a database
     */
    @Bean
    public DataSource dataSource() {
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setServerName(environment.getProperty("db.name"));
        dataSource.setDatabaseName(environment.getProperty("db.dbname"));
        dataSource.setUser(environment.getProperty("db.user"));
        dataSource.setPassword(environment.getProperty("db.password"));
        return dataSource;
    }

    /**
     * Configure a vendor-specific JpaVendorAdapter object. In particular case
     * Hibernate Jpa is used
     *
     * @return configured JpaVendorAdapter which is used for ORM operations
     */
    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setShowSql(false);
        return adapter;
    }

    /**
     * Create configured {@link EntityManagerFactory} with provided DataSource
     * and JpaVendorAdapter objects. EntityManagerFactory creates an
     * EntityManager instance, which provides functionality for performing
     * operations on a database
     *
     * @param dataSource       - configured {@link DataSource} object
     * @param jpaVendorAdapter - configured {@link JpaVendorAdapter} object
     * @return EntityManagerFactory instance
     */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource,
                                                                       JpaVendorAdapter jpaVendorAdapter) {
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setDataSource(dataSource);
        entityManagerFactory.setJpaVendorAdapter(jpaVendorAdapter);
        entityManagerFactory.setPackagesToScan("by.intexsoft.backend.model");
        return entityManagerFactory;
    }

    /**
     * Create an instance of {@link PlatformTransactionManager}, which in our
     * case is appropriate for applications that use a single JPA
     * EntityManagerFactory
     *
     * @param entityManagerFactory - configured factory, which produces EntityManager objects
     * @return an instance of a {@link PlatformTransactionManager} for a single
     * JPA {@link EntityManagerFactory}
     */
    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
