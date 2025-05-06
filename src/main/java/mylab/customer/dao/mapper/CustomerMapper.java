package mylab.customer.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import mylab.customer.vo.CustomerVO;

public interface CustomerMapper {

    CustomerVO selectCustomerById(@Param("id") int id); // param 이름을 명시해두면 XML에서 사용 가능
    List<CustomerVO> selectAllCustomer();
    void insertCustomer(CustomerVO customer);
}
