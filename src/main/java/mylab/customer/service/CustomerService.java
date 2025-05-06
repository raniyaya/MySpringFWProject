package mylab.customer.service;

import java.util.List;
import mylab.customer.vo.CustomerVO;

public interface CustomerService {

    // ID로 고객 정보 조회
    CustomerVO getCustomerInfo(int id);

    // 전체 고객 목록 조회
    List<CustomerVO> getAllCustomerList();

    // 고객 등록
    void insertCustomer(CustomerVO customer);
}
