package mylab.customer.dao;

import java.util.List;
import mylab.customer.vo.CustomerVO;

public interface CustomerDAO {

    // 고객 목록 전체 조회
    List<CustomerVO> selectAllCustomer();

    // ID로 고객 조회
    CustomerVO selectCustomer(int id);

    // 고객 등록
    void insertCustomer(CustomerVO customer);
}
