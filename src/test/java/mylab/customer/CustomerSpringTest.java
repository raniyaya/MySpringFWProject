package mylab.customer;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import mylab.customer.service.CustomerService;
import mylab.customer.vo.CustomerVO;
import mylab.customer.dao.mapper.CustomerMapper;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:spring-beans-mybatis.xml")
public class CustomerSpringTest {

    protected static final Logger logger = LogManager.getLogger();

    @Autowired
    DataSource dataSource;

    @Autowired
    SqlSessionFactory sqlSessionFactory;

    @Autowired
    SqlSession sqlSession;

    @Autowired
    CustomerMapper customerMapper;

    @Autowired
    CustomerService customerService;

    // ✅ Service 테스트
    @Test
    void serviceTest() {
        CustomerVO customer = new CustomerVO();
        customer.setEmail("spring@test.com");
        customer.setName("스프링");
        customer.setAge(28);

        customerService.insertCustomer(customer);
        logger.debug("등록 완료");

        List<CustomerVO> list = customerService.getAllCustomerList();
        list.forEach(c -> logger.debug(c));

        CustomerVO one = customerService.getCustomerInfo(1);
        logger.debug("ID 1번 고객: {}", one);
    }

   
    @Test @Disabled
    void mapperTest() {
        CustomerVO customer = customerMapper.selectCustomerById(1);
        logger.debug(customer);
    }

 
    @Test @Disabled
    void sqlSessionTest() {
        List<CustomerVO> list = sqlSession.selectList("mylab.customer.dao.mapper.CustomerMapper.selectAllCustomer");
        list.forEach(System.out::println);
    }

    
    @Test @Disabled
    void connectionTest() {
        try {
            Connection conn = dataSource.getConnection();
            DatabaseMetaData meta = conn.getMetaData();
            logger.debug("DB URL = {}", meta.getURL());
            logger.debug("DB User = {}", meta.getUserName());
            logger.debug("DB Vendor = {}", meta.getDatabaseProductName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
