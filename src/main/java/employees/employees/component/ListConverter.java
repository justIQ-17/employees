package employees.employees.component;

import employees.employees.entity.Employee;
import employees.employees.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

//@Component
//@RequiredArgsConstructor
//public class ListConverter implements Converter<Long, Employee> {
//    private final EmployeeRepository employeeRepository;
//
//    @Override
//    public Employee convert(Long id) {
//        return employeeRepository.findById(id).orElse(null);
//    }
//
//
//}
